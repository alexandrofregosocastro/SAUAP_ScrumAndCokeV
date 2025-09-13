
import mx.avanti.desarollo.dao.ProfesorDAO;
import mx.avanti.desarollo.persistence.HibernateUtil;
import mx.desarollo.entity.Alumno;

public class testDAO {

    public static void main(String[] args) {
        ProfesorDAO alumnoDAO = new ProfesorDAO(HibernateUtil.getEntityManager());



        for (Alumno alumno : alumnoDAO.findAll()) {
            System.out.println(alumno + "|| id [" + alumno.getId()+ "]");
        }
    }
}
