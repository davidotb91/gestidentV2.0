/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.ec.entity.Administrador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ANGEL
 */
@ManagedBean(name= "usuario")
@SessionScoped
public class admincontrol {
    public String nombre;
    public String login;
    public String password;
    
    
    public String validarLogin() throws Exception{
        adminDao admin = new adminDao();
        Administrador a = admin.validarAdmin(login, password);
        if (a != null) {
            nombre = a.getNombreAdiministrador();
            return "home";
        } else {
            return "index";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
