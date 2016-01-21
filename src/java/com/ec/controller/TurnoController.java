package com.ec.controller;

import com.ec.entity.Turno;
import com.ec.controller.util.JsfUtil;
import com.ec.controller.util.JsfUtil.PersistAction;
import com.ec.sesion.TurnoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("turnoController")
@SessionScoped
public class TurnoController implements Serializable {

    @EJB
    private com.ec.sesion.TurnoFacade ejbFacade;
    private List<Turno> items = null;
    private Turno selected;

    public TurnoController() {
    }

    public Turno getSelected() {
        return selected;
    }

    public void setSelected(Turno selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTurnoPK().setEspecialidadidEspecialidad(selected.getEspecialidad().getIdEspecialidad());
        selected.getTurnoPK().setDoctorEspecialidadidEspecialidad(selected.getDoctor().getDoctorPK().getEspecialidadidEspecialidad());
        selected.getTurnoPK().setPacienteIDPACIENTE(selected.getPaciente().getIdPaciente());
        selected.getTurnoPK().setDoctorIDDOCTOR(selected.getDoctor().getDoctorPK().getIdDoctor());
    }

    protected void initializeEmbeddableKey() {
        selected.setTurnoPK(new com.ec.entity.TurnoPK());
    }

    private TurnoFacade getFacade() {
        return ejbFacade;
    }

    public Turno prepareCreate() {
        selected = new Turno();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TurnoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TurnoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TurnoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Turno> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Turno getTurno(com.ec.entity.TurnoPK id) {
        return getFacade().find(id);
    }

    public List<Turno> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Turno> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Turno.class)
    public static class TurnoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TurnoController controller = (TurnoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "turnoController");
            return controller.getTurno(getKey(value));
        }

        com.ec.entity.TurnoPK getKey(String value) {
            com.ec.entity.TurnoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.ec.entity.TurnoPK();
            key.setIdturno(Integer.parseInt(values[0]));
            key.setPacienteIDPACIENTE(Integer.parseInt(values[1]));
            key.setEspecialidadidEspecialidad(Integer.parseInt(values[2]));
            key.setDoctorIDDOCTOR(Integer.parseInt(values[3]));
            key.setDoctorEspecialidadidEspecialidad(Integer.parseInt(values[4]));
            return key;
        }

        String getStringKey(com.ec.entity.TurnoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdturno());
            sb.append(SEPARATOR);
            sb.append(value.getPacienteIDPACIENTE());
            sb.append(SEPARATOR);
            sb.append(value.getEspecialidadidEspecialidad());
            sb.append(SEPARATOR);
            sb.append(value.getDoctorIDDOCTOR());
            sb.append(SEPARATOR);
            sb.append(value.getDoctorEspecialidadidEspecialidad());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Turno) {
                Turno o = (Turno) object;
                return getStringKey(o.getTurnoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Turno.class.getName()});
                return null;
            }
        }

    }

}
