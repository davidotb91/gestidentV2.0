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
public class DoctorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID_DOCTOR")
    private int idDoctor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Especialidad_idEspecialidad")
    private int especialidadidEspecialidad;

    public DoctorPK() {
    }

    public DoctorPK(int idDoctor, int especialidadidEspecialidad) {
        this.idDoctor = idDoctor;
        this.especialidadidEspecialidad = especialidadidEspecialidad;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getEspecialidadidEspecialidad() {
        return especialidadidEspecialidad;
    }

    public void setEspecialidadidEspecialidad(int especialidadidEspecialidad) {
        this.especialidadidEspecialidad = especialidadidEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDoctor;
        hash += (int) especialidadidEspecialidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorPK)) {
            return false;
        }
        DoctorPK other = (DoctorPK) object;
        if (this.idDoctor != other.idDoctor) {
            return false;
        }
        if (this.especialidadidEspecialidad != other.especialidadidEspecialidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entity.DoctorPK[ idDoctor=" + idDoctor + ", especialidadidEspecialidad=" + especialidadidEspecialidad + " ]";
    }
    
}
