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

public class recuperarDao {
    private EntityManagerFactory emf;

public recuperarDao() {
    emf = Persistence.createEntityManagerFactory("gestidentV2.0PU");
}

    public Paciente recuperarContraPaciente(String emailPaciente ) {
        Paciente paciente;
        EntityManager em= emf.createEntityManager();
        String sql2="SELECT p FROM Paciente p WHERE p.emailPaciente=:emailPaciente"; 
        Query query =em.createQuery(sql2);
        query.setParameter("emailPaciente", emailPaciente);
        
        paciente= (Paciente) query.getSingleResult();
                
        return paciente;
    }
}
