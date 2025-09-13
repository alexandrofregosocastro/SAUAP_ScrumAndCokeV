/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.avanti.desarollo.integration;

import jakarta.persistence.EntityManager;
import mx.avanti.desarollo.dao.*;
import mx.avanti.desarollo.persistence.HibernateUtil;


/**
 *
 * @author total
 */
public class ServiceLocator {

    private static ProfesorDAO profesorDAO;

    private static EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager();
    }

    /**
     * se crea la instancia para alumno DAO si esta no existe
     */

    public static ProfesorDAO getInstanceProfesorDAO() {
        return new ProfesorDAO(HibernateUtil.getEntityManager());
    }


    
}
