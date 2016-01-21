/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author david
 */
@Embeddable
public class TurnoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idturno")
    private int idturno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paciente_ID_PACIENTE")
    private int pacienteIDPACIENTE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "especialidad_idEspecialidad")
    private int especialidadidEspecialidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doctor_ID_DOCTOR")
    private int doctorIDDOCTOR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doctor_Especialidad_idEspecialidad")
    private int doctorEspecialidadidEspecialidad;

    public TurnoPK() {
    }

    public TurnoPK(int idturno, int pacienteIDPACIENTE, int especialidadidEspecialidad, int doctorIDDOCTOR, int doctorEspecialidadidEspecialidad) {
        this.idturno = idturno;
        this.pacienteIDPACIENTE = pacienteIDPACIENTE;
        this.especialidadidEspecialidad = especialidadidEspecialidad;
        this.doctorIDDOCTOR = doctorIDDOCTOR;
        this.doctorEspecialidadidEspecialidad = doctorEspecialidadidEspecialidad;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public int getPacienteIDPACIENTE() {
        return pacienteIDPACIENTE;
    }

    public void setPacienteIDPACIENTE(int pacienteIDPACIENTE) {
        this.pacienteIDPACIENTE = pacienteIDPACIENTE;
    }

    public int getEspecialidadidEspecialidad() {
        return especialidadidEspecialidad;
    }

    public void setEspecialidadidEspecialidad(int especialidadidEspecialidad) {
        this.especialidadidEspecialidad = especialidadidEspecialidad;
    }

    public int getDoctorIDDOCTOR() {
        return doctorIDDOCTOR;
    }

    public void setDoctorIDDOCTOR(int doctorIDDOCTOR) {
        this.doctorIDDOCTOR = doctorIDDOCTOR;
    }

    public int getDoctorEspecialidadidEspecialidad() {
        return doctorEspecialidadidEspecialidad;
    }

    public void setDoctorEspecialidadidEspecialidad(int doctorEspecialidadidEspecialidad) {
        this.doctorEspecialidadidEspecialidad = doctorEspecialidadidEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idturno;
        hash += (int) pacienteIDPACIENTE;
        hash += (int) especialidadidEspecialidad;
        hash += (int) doctorIDDOCTOR;
        hash += (int) doctorEspecialidadidEspecialidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnoPK)) {
            return false;
        }
        TurnoPK other = (TurnoPK) object;
        if (this.idturno != other.idturno) {
            return false;
        }
        if (this.pacienteIDPACIENTE != other.pacienteIDPACIENTE) {
            return false;
        }
        if (this.especialidadidEspecialidad != other.especialidadidEspecialidad) {
            return false;
        }
        if (this.doctorIDDOCTOR != other.doctorIDDOCTOR) {
            return false;
        }
        if (this.doctorEspecialidadidEspecialidad != other.doctorEspecialidadidEspecialidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entity.TurnoPK[ idturno=" + idturno + ", pacienteIDPACIENTE=" + pacienteIDPACIENTE + ", especialidadidEspecialidad=" + especialidadidEspecialidad + ", doctorIDDOCTOR=" + doctorIDDOCTOR + ", doctorEspecialidadidEspecialidad=" + doctorEspecialidadidEspecialidad + " ]";
    }
    
}
