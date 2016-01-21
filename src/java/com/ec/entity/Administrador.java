/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "administrador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByCiAdministrador", query = "SELECT a FROM Administrador a WHERE a.ciAdministrador = :ciAdministrador"),
    @NamedQuery(name = "Administrador.findByNombreAdiministrador", query = "SELECT a FROM Administrador a WHERE a.nombreAdiministrador = :nombreAdiministrador"),
    @NamedQuery(name = "Administrador.findByPasswordAdministrador", query = "SELECT a FROM Administrador a WHERE a.passwordAdministrador = :passwordAdministrador")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ADMINISTRADOR")
    private Integer idAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CI_ADMINISTRADOR")
    private String ciAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMBRE_ADIMINISTRADOR")
    private String nombreAdiministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PASSWORD_ADMINISTRADOR")
    private String passwordAdministrador;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Administrador(Integer idAdministrador, String ciAdministrador, String nombreAdiministrador, String passwordAdministrador) {
        this.idAdministrador = idAdministrador;
        this.ciAdministrador = ciAdministrador;
        this.nombreAdiministrador = nombreAdiministrador;
        this.passwordAdministrador = passwordAdministrador;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getCiAdministrador() {
        return ciAdministrador;
    }

    public void setCiAdministrador(String ciAdministrador) {
        this.ciAdministrador = ciAdministrador;
    }

    public String getNombreAdiministrador() {
        return nombreAdiministrador;
    }

    public void setNombreAdiministrador(String nombreAdiministrador) {
        this.nombreAdiministrador = nombreAdiministrador;
    }

    public String getPasswordAdministrador() {
        return passwordAdministrador;
    }

    public void setPasswordAdministrador(String passwordAdministrador) {
        this.passwordAdministrador = passwordAdministrador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entity.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
