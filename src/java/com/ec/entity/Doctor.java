/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author david
 */
@Entity
@Table(name = "doctor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM Doctor d"),
    @NamedQuery(name = "Doctor.findByIdDoctor", query = "SELECT d FROM Doctor d WHERE d.doctorPK.idDoctor = :idDoctor"),
    @NamedQuery(name = "Doctor.findByNombresDoctor", query = "SELECT d FROM Doctor d WHERE d.nombresDoctor = :nombresDoctor"),
    @NamedQuery(name = "Doctor.findByApellidosDoctor", query = "SELECT d FROM Doctor d WHERE d.apellidosDoctor = :apellidosDoctor"),
    @NamedQuery(name = "Doctor.findByCiDoctor", query = "SELECT d FROM Doctor d WHERE d.ciDoctor = :ciDoctor"),
    @NamedQuery(name = "Doctor.findByNumConsultorioDoctor", query = "SELECT d FROM Doctor d WHERE d.numConsultorioDoctor = :numConsultorioDoctor"),
    @NamedQuery(name = "Doctor.findByEmailDoctor", query = "SELECT d FROM Doctor d WHERE d.emailDoctor = :emailDoctor"),
    @NamedQuery(name = "Doctor.findByTelefonoFijoDoctor", query = "SELECT d FROM Doctor d WHERE d.telefonoFijoDoctor = :telefonoFijoDoctor"),
    @NamedQuery(name = "Doctor.findByCelularDoctor", query = "SELECT d FROM Doctor d WHERE d.celularDoctor = :celularDoctor"),
    @NamedQuery(name = "Doctor.findByFechaNacimientoDoctor", query = "SELECT d FROM Doctor d WHERE d.fechaNacimientoDoctor = :fechaNacimientoDoctor"),
    @NamedQuery(name = "Doctor.findByPasswordDoctor", query = "SELECT d FROM Doctor d WHERE d.passwordDoctor = :passwordDoctor"),
    @NamedQuery(name = "Doctor.findByEspecialidadidEspecialidad", query = "SELECT d FROM Doctor d WHERE d.doctorPK.especialidadidEspecialidad = :especialidadidEspecialidad")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DoctorPK doctorPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRES_DOCTOR")
    private String nombresDoctor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "APELLIDOS_DOCTOR")
    private String apellidosDoctor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CI_DOCTOR")
    private String ciDoctor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_CONSULTORIO_DOCTOR")
    private int numConsultorioDoctor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EMAIL_DOCTOR")
    private String emailDoctor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO_FIJO_DOCTOR")
    private int telefonoFijoDoctor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CELULAR_DOCTOR")
    private int celularDoctor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO_DOCTOR")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoDoctor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD_DOCTOR")
    private String passwordDoctor;
    @JoinColumn(name = "Especialidad_idEspecialidad", referencedColumnName = "idEspecialidad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Especialidad especialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private Collection<Turno> turnoCollection;

    public Doctor() {
    }

    public Doctor(DoctorPK doctorPK) {
        this.doctorPK = doctorPK;
    }

    public Doctor(DoctorPK doctorPK, String nombresDoctor, String apellidosDoctor, String ciDoctor, int numConsultorioDoctor, String emailDoctor, int telefonoFijoDoctor, int celularDoctor, Date fechaNacimientoDoctor, String passwordDoctor) {
        this.doctorPK = doctorPK;
        this.nombresDoctor = nombresDoctor;
        this.apellidosDoctor = apellidosDoctor;
        this.ciDoctor = ciDoctor;
        this.numConsultorioDoctor = numConsultorioDoctor;
        this.emailDoctor = emailDoctor;
        this.telefonoFijoDoctor = telefonoFijoDoctor;
        this.celularDoctor = celularDoctor;
        this.fechaNacimientoDoctor = fechaNacimientoDoctor;
        this.passwordDoctor = passwordDoctor;
    }

    public Doctor(int idDoctor, int especialidadidEspecialidad) {
        this.doctorPK = new DoctorPK(idDoctor, especialidadidEspecialidad);
    }

    public DoctorPK getDoctorPK() {
        return doctorPK;
    }

    public void setDoctorPK(DoctorPK doctorPK) {
        this.doctorPK = doctorPK;
    }

    public String getNombresDoctor() {
        return nombresDoctor;
    }

    public void setNombresDoctor(String nombresDoctor) {
        this.nombresDoctor = nombresDoctor;
    }

    public String getApellidosDoctor() {
        return apellidosDoctor;
    }

    public void setApellidosDoctor(String apellidosDoctor) {
        this.apellidosDoctor = apellidosDoctor;
    }

    public String getCiDoctor() {
        return ciDoctor;
    }

    public void setCiDoctor(String ciDoctor) {
        this.ciDoctor = ciDoctor;
    }

    public int getNumConsultorioDoctor() {
        return numConsultorioDoctor;
    }

    public void setNumConsultorioDoctor(int numConsultorioDoctor) {
        this.numConsultorioDoctor = numConsultorioDoctor;
    }

    public String getEmailDoctor() {
        return emailDoctor;
    }

    public void setEmailDoctor(String emailDoctor) {
        this.emailDoctor = emailDoctor;
    }

    public int getTelefonoFijoDoctor() {
        return telefonoFijoDoctor;
    }

    public void setTelefonoFijoDoctor(int telefonoFijoDoctor) {
        this.telefonoFijoDoctor = telefonoFijoDoctor;
    }

    public int getCelularDoctor() {
        return celularDoctor;
    }

    public void setCelularDoctor(int celularDoctor) {
        this.celularDoctor = celularDoctor;
    }

    public Date getFechaNacimientoDoctor() {
        return fechaNacimientoDoctor;
    }

    public void setFechaNacimientoDoctor(Date fechaNacimientoDoctor) {
        this.fechaNacimientoDoctor = fechaNacimientoDoctor;
    }

    public String getPasswordDoctor() {
        return passwordDoctor;
    }

    public void setPasswordDoctor(String passwordDoctor) {
        this.passwordDoctor = passwordDoctor;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @XmlTransient
    public Collection<Turno> getTurnoCollection() {
        return turnoCollection;
    }

    public void setTurnoCollection(Collection<Turno> turnoCollection) {
        this.turnoCollection = turnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorPK != null ? doctorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        if ((this.doctorPK == null && other.doctorPK != null) || (this.doctorPK != null && !this.doctorPK.equals(other.doctorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entity.Doctor[ doctorPK=" + doctorPK + " ]";
    }
    
}
