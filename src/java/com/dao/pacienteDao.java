/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.ec.entity.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author stand
 */
public class pacienteDao {
    private EntityManagerFactory emf;

    public pacienteDao() {
        emf = Persistence.createEntityManagerFactory("gestidentV2.0PU");
    }

    public Paciente validarPaciente(String ciPaciente, String passwordPaciente ) {
        Paciente paciente;
        EntityManager em= emf.createEntityManager();
        String sql="SELECT p FROM Paciente p WHERE p.ciPaciente=:ciPaciente AND p.passwordPaciente = :passwordPaciente"; 
        Query query =em.createQuery(sql);
        query.setParameter("ciPaciente",ciPaciente);
        query.setParameter("passwordPaciente", passwordPaciente);
        
        paciente= (Paciente) query.getSingleResult();
                
        return paciente;
    }
    

}
