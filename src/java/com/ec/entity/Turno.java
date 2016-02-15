/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "turno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t WHERE t.estado LIKE 'LIBRE'"),
    //@NamedQuery(name = "Turno.findDisponibilidad", query = "SELECT t FROM Turno t WHERE t.estado LIKE 'LIBRE'"),
    @NamedQuery(name = "Turno.findByIdturno", query = "SELECT t FROM Turno t WHERE t.turnoPK.idturno = :idturno"),
    @NamedQuery(name = "Turno.findByFechahoraturno", query = "SELECT t FROM Turno t WHERE t.fechahoraturno = :fechahoraturno"),
    @NamedQuery(name = "Turno.findByEstado", query = "SELECT t FROM Turno t WHERE t.estado = :estado"),
    @NamedQuery(name = "Turno.findByPacienteIDPACIENTE", query = "SELECT t FROM Turno t WHERE t.turnoPK.pacienteIDPACIENTE = :pacienteIDPACIENTE"),
    @NamedQuery(name = "Turno.findByEspecialidadidEspecialidad", query = "SELECT t FROM Turno t WHERE t.turnoPK.especialidadidEspecialidad = :especialidadidEspecialidad"),
    @NamedQuery(name = "Turno.findByDoctorIDDOCTOR", query = "SELECT t FROM Turno t WHERE t.turnoPK.doctorIDDOCTOR = :doctorIDDOCTOR"),
    @NamedQuery(name = "Turno.findByDoctorEspecialidadidEspecialidad", query = "SELECT t FROM Turno t WHERE t.turnoPK.doctorEspecialidadidEspecialidad = :doctorEspecialidadidEspecialidad")})
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnoPK turnoPK;
    @Column(name = "fechahoraturno")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahoraturno;
    @Size(max = 25)
    @Column(name = "Estado")
    private String estado;
    @JoinColumn(name = "paciente_ID_PACIENTE", referencedColumnName = "ID_PACIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paciente paciente;
    @JoinColumn(name = "especialidad_idEspecialidad", referencedColumnName = "idEspecialidad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Especialidad especialidad;
    @JoinColumns({
        @JoinColumn(name = "doctor_ID_DOCTOR", referencedColumnName = "ID_DOCTOR", insertable = false, updatable = false),
        @JoinColumn(name = "doctor_Especialidad_idEspecialidad", referencedColumnName = "Especialidad_idEspecialidad", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Doctor doctor;

    public Turno() {
    }

    public Turno(TurnoPK turnoPK) {
        this.turnoPK = turnoPK;
    }

    public Turno(int idturno, int pacienteIDPACIENTE, int especialidadidEspecialidad, int doctorIDDOCTOR, int doctorEspecialidadidEspecialidad) {
        this.turnoPK = new TurnoPK(idturno, pacienteIDPACIENTE, especialidadidEspecialidad, doctorIDDOCTOR, doctorEspecialidadidEspecialidad);
    }

    public TurnoPK getTurnoPK() {
        return turnoPK;
    }

    public void setTurnoPK(TurnoPK turnoPK) {
        this.turnoPK = turnoPK;
    }

    public Date getFechahoraturno() {
        return fechahoraturno;
    }

    public void setFechahoraturno(Date fechahoraturno) {
        this.fechahoraturno = fechahoraturno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turnoPK != null ? turnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turno)) {
            return false;
        }
        Turno other = (Turno) object;
        if ((this.turnoPK == null && other.turnoPK != null) || (this.turnoPK != null && !this.turnoPK.equals(other.turnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entity.Turno[ turnoPK=" + turnoPK + " ]";
    }
    
}
