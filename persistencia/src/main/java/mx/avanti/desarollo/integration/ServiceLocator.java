package mx.avanti.desarollo.integration;

import jakarta.persistence.EntityManager;
import mx.avanti.desarollo.dao.*;
import mx.avanti.desarollo.persistence.HibernateUtil;


/**
 *
 * @author total
 */

/*
El service locator es una "fabrica" de DAOs, configura el entity manager que los DAOs necesitan
para comunicarse con la base de datos, si alguien necesita comunicarse con la BD, llama al servicelocator
para obtener el dao que necesita
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

    public static UA_DAO getInstanceUA_DAO() {
        return new UA_DAO(HibernateUtil.getEntityManager());
    }


}
