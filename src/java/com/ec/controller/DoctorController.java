package com.ec.controller;

import com.ec.entity.Doctor;
import com.ec.controller.util.JsfUtil;
import com.ec.controller.util.JsfUtil.PersistAction;
import com.ec.sesion.DoctorFacade;

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

@Named("doctorController")
@SessionScoped
public class DoctorController implements Serializable {

    @EJB
    private com.ec.sesion.DoctorFacade ejbFacade;
    private List<Doctor> items = null;
    private Doctor selected;

    public DoctorController() {
    }

    public Doctor getSelected() {
        return selected;
    }

    public void setSelected(Doctor selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getDoctorPK().setEspecialidadidEspecialidad(selected.getEspecialidad().getIdEspecialidad());
    }

    protected void initializeEmbeddableKey() {
        selected.setDoctorPK(new com.ec.entity.DoctorPK());
    }

    private DoctorFacade getFacade() {
        return ejbFacade;
    }

    public Doctor prepareCreate() {
        selected = new Doctor();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DoctorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DoctorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DoctorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Doctor> getItems() {
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

    public Doctor getDoctor(com.ec.entity.DoctorPK id) {
        return getFacade().find(id);
    }

    public List<Doctor> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Doctor> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Doctor.class)
    public static class DoctorControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DoctorController controller = (DoctorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "doctorController");
            return controller.getDoctor(getKey(value));
        }

        com.ec.entity.DoctorPK getKey(String value) {
            com.ec.entity.DoctorPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.ec.entity.DoctorPK();
            key.setIdDoctor(Integer.parseInt(values[0]));
            key.setEspecialidadidEspecialidad(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.ec.entity.DoctorPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdDoctor());
            sb.append(SEPARATOR);
            sb.append(value.getEspecialidadidEspecialidad());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Doctor) {
                Doctor o = (Doctor) object;
                return getStringKey(o.getDoctorPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Doctor.class.getName()});
                return null;
            }
        }

    }

}
