package mx.avanti.desarollo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mx.avanti.desarollo.persistence.AbstractDAO;
import mx.desarollo.entity.Profesor;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.util.List;


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
            System.out.println("Profesor guardado exitosamente: " + profesor.getNombre());
        }catch(Exception ex){
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("Error al guardar profesor: " + ex.getMessage());
            ex.printStackTrace();
            throw new RuntimeException("Error al guardar profesor", ex);
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

    //En esta funcion se utiliza un fecth para que tambien se traiga las unidades y las filas que estan
    //relacionadas en la tabla de "imparte" (que es la tabla peunte)
    public Profesor buscarID(int idProfesor) {
        return entityManager.createQuery("SELECT p FROM Profesor p LEFT JOIN FETCH p.unidades WHERE p.id = :id",Profesor.class).setParameter("id", idProfesor).getSingleResult();
    }

    public List<Profesor> obtenerAsignaciones(){
        try{
            //Se utiliza LEFT JOIN para traer a todos los profesores, no solo a los que tienen asignaciones
            //El DISTINCT se usa para que no se repitan los profesores si tienen mas de una unidad
            return entityManager.createQuery("SELECT DISTINCT p FROM Profesor p LEFT JOIN FETCH p.unidades", Profesor.class).getResultList();
        } catch (Exception ex){
            System.out.println("Error al obtener asignaciones" + ex.getMessage());
            return null;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
