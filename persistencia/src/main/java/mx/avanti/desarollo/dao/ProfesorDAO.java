package mx.avanti.desarollo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mx.avanti.desarollo.persistence.AbstractDAO;
import mx.desarollo.entity.Profesor;


public class ProfesorDAO extends AbstractDAO<Profesor> {
    private final EntityManager entityManager;

    public ProfesorDAO(EntityManager em) {
        super(Profesor.class);
        this.entityManager = em;
    }

    public void crearProfesor(Profesor profesor){
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(profesor);
            transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
            System.out.println("Error al guardar profesor" + ex.getMessage());
        } finally {
            if(entityManager.isOpen()){
                entityManager.close();//Todos los EM se tienen que cerrar para prevenir fugas y errores
            }
        }
    }

    public Profesor buscarRFC(String rfc){
        try{
            //Aqui se realiza un Query de busqueda en la BD para verificar que el RFC no esta repetido
            return entityManager.createQuery(
                    "SELECT p FROM Profesor p WHERE p.RFC = :rfc", Profesor.class)
                    .setParameter("rfc", rfc).getResultStream().findFirst().orElse(null);
        } catch(Exception ex){
            System.out.println("Error al buscar profesor" + ex.getMessage());
            return null;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
