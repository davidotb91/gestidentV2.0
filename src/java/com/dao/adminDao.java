/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;


import com.ec.entity.Administrador;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author ANGEL
 */
public class adminDao {

    private EntityManagerFactory emf;

    public adminDao() {
        emf = Persistence.createEntityManagerFactory("gestidentV1.7PU");
    }

    public Administrador validarAdmin(String ciAdministrador, String passwordAdministrador ) {
        Administrador admin;
        EntityManager em= emf.createEntityManager();
        String sql="SELECT a FROM Administrador a WHERE a.ciAdministrador=:ciAdministrador AND a.passwordAdministrador = :passwordAdministrador"; 
        Query query =em.createQuery(sql);
        query.setParameter("ciAdministrador",ciAdministrador);
        query.setParameter("passwordAdministrador", passwordAdministrador);
        
        admin= (Administrador) query.getSingleResult();
                
        return admin;
    }

}
