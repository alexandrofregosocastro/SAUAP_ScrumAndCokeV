package mx.avanti.desarollo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mx.avanti.desarollo.persistence.AbstractDAO;
import mx.desarollo.entity.Unidad_aprendizaje;
import java.util.List;

public class UnidadAprendizajeDAO extends AbstractDAO<Unidad_aprendizaje> {

    private final EntityManager em;

    public UnidadAprendizajeDAO(EntityManager em) {
        super(Unidad_aprendizaje.class);
        this.em = em;
    }

    @Override
    public EntityManager getEntityManager() { // objeto que hace consultas y hace crud
        return em;
    }

    // lista completa sin filtros
    public List<Unidad_aprendizaje> findAllOrdered(String orderBy, boolean asc){
        String campo = (orderBy == null || orderBy.isBlank()) ? "nombre" : orderBy;
        String dir = asc ? "ASC" : "DESC";
        String jpql = "SELECT u FROM Unidad_aprendizaje u ORDER BY u." + campo + " " + dir;
        return em.createQuery(jpql, Unidad_aprendizaje.class).getResultList();
    }

    // busqueda por nombre
    public List<Unidad_aprendizaje> searchByNombre(String texto, String orderBy, boolean asc){
        String campo = (orderBy == null || orderBy.isBlank()) ? "nombre" : orderBy;
        String dir = asc ? "ASC" : "DESC";
        String jpql = "SELECT u FROM Unidad_aprendizaje u " +
                "WHERE LOWER(u.nombre) LIKE :q " +
                "ORDER BY u." + campo + " " + dir;
        return em.createQuery(jpql, Unidad_aprendizaje.class)
                .setParameter("q", "%" + (texto == null ? "" : texto.toLowerCase().trim()) + "%")
                .getResultList();
    }

    /*// paginacion simple
    public List<Unidad_aprendizaje> findPage(int pageIndex, int pageSize, String orderBy, boolean asc){
        String campo = (orderBy == null || orderBy.isBlank()) ? "nombre" : orderBy;
        String dir = asc ? "ASC" : "DESC";
        TypedQuery<Unidad_aprendizaje> q = em.createQuery(
                "SELECT u FROM Unidad_aprendizaje u ORDER BY u." + campo + " " + dir,
                Unidad_aprendizaje.class
        );
        int first = Math.max(0, pageIndex) * Math.max(1, pageSize);
        q.setFirstResult(first);
        q.setMaxResults(Math.max(1, pageSize));
        return q.getResultList();
    }

    // total para apoyar paginacion
    public long countAll(){
        return em.createQuery("SELECT COUNT(u) FROM Unidad_aprendizaje u", Long.class)
                .getSingleResult();
    }

    // filtro por horas (todas opcionales)
    public List<Unidad_aprendizaje> filterByHoras(Integer clase, Integer taller, Integer lab, String orderBy, boolean asc){
        StringBuilder jpql = new StringBuilder("SELECT u FROM Unidad_aprendizaje u WHERE 1=1 ");
        if(clase != null) jpql.append("AND u.horas_clase = :hc ");
        if(taller != null) jpql.append("AND u.horas_taller = :ht ");
        if(lab   != null) jpql.append("AND u.horas_lab = :hl ");
        String campo = (orderBy == null || orderBy.isBlank()) ? "nombre" : orderBy;
        String dir = asc ? "ASC" : "DESC";
        jpql.append("ORDER BY u.").append(campo).append(" ").append(dir);

        TypedQuery<Unidad_aprendizaje> q = em.createQuery(jpql.toString(), Unidad_aprendizaje.class);
        if(clase != null) q.setParameter("hc", clase);
        if(taller != null) q.setParameter("ht", taller);
        if(lab   != null) q.setParameter("hl", lab);
        return q.getResultList();
    } */
}
