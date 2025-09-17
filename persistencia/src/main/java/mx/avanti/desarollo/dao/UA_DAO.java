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

    public java.util.List<Unidad_aprendizaje> obtenerTodasLasUA() {
        try {
            System.out.println("UA_DAO: Ejecutando consulta para obtener todas las unidades de aprendizaje...");
            java.util.List<Unidad_aprendizaje> resultado = em.createQuery("SELECT ua FROM Unidad_aprendizaje ua", Unidad_aprendizaje.class).getResultList();
            System.out.println("UA_DAO: Consulta ejecutada. Resultados encontrados: " + (resultado != null ? resultado.size() : "null"));
            return resultado;
        } catch (Exception ex) {
            System.out.println("Error al obtener todas las UA: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    public boolean eliminarUA(int idUA) {
        EntityTransaction tx = em.getTransaction();
        try {
            Unidad_aprendizaje ua = em.createQuery("SELECT ua FROM Unidad_aprendizaje ua LEFT JOIN FETCH ua.profesores WHERE ua.id_uniapr = :id", Unidad_aprendizaje.class)
                    .setParameter("id", idUA)
                    .getSingleResult();
            if (ua == null) {
                return false;
            }
            tx.begin();
            // Romper relaciones ManyToMany con profesores para evitar constraint violations
            ua.getProfesores().forEach(p -> {
                p.getUnidades().remove(ua);
                em.merge(p);
            });
            // Asegurar que la colección esté limpia del lado de UA también
            ua.getProfesores().clear();
            em.remove(em.contains(ua) ? ua : em.merge(ua));
            tx.commit();
            return true;
        } catch (Exception ex) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error al eliminar UA: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
