package mx.avanti.desarollo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mx.avanti.desarollo.persistence.AbstractDAO;
import mx.desarollo.entity.Profesor;
import mx.desarollo.entity.Unidad_aprendizaje;


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
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
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

    public void asignarUA(Profesor profesor, Unidad_aprendizaje ua) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            profesor.getUnidades().add(ua);
            entityManager.merge(profesor);
            tx.commit();
        } catch (Exception ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        }
    }

    public Profesor buscarID(int idProfesor) {
        return entityManager.createQuery("SELECT p FROM Profesor p LEFT JOIN FETCH p.unidades WHERE p.id = :id",Profesor.class).setParameter("id", idProfesor).getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
