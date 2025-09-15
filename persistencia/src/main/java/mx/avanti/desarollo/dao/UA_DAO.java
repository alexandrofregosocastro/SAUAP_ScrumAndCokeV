package mx.avanti.desarollo.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mx.avanti.desarollo.persistence.AbstractDAO;
import mx.desarollo.entity.Unidad_aprendizaje;

public class UA_DAO extends AbstractDAO<Unidad_aprendizaje> {
    private final EntityManager em;

    public UA_DAO(EntityManager em) {
        super(Unidad_aprendizaje.class);
        this.em = em;
    }

    public void crearUA(Unidad_aprendizaje ua) {
        EntityTransaction t = null;

        try{
            t = em.getTransaction();
            t.begin();
            em.persist(ua);
            t.commit();
        } catch(Exception ex){
            t.rollback();
            System.out.println("Error al guardar Unidad_aprendizaje" + ex.getMessage());
        }
        finally{
            if (t != null && t.isActive()) {
                t.rollback();
            }
        }
    }

    public Unidad_aprendizaje buscarID(int idUA) {
        try{
            return em.createQuery("SELECT ua FROM Unidad_aprendizaje ua LEFT JOIN FETCH ua.profesores WHERE ua.id_uniapr = :id", Unidad_aprendizaje.class).setParameter("id",idUA).getSingleResult();
        } catch (Exception ex){
            System.out.println("Error al buscar UA" + ex.getMessage());
            return null;
        }
    }

    public boolean modificarUA(Unidad_aprendizaje ua) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(ua);
            tx.commit();
            return true;
        } catch (Exception ex) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error al modificar UA: " + ex.getMessage());
            return false;
        }
    }



    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
