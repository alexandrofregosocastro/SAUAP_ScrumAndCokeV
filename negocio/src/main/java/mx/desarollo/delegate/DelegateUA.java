package mx.desarollo.delegate;

import mx.avanti.desarollo.dao.ProfesorDAO;
import mx.avanti.desarollo.dao.UA_DAO;
import mx.avanti.desarollo.integration.ServiceLocator;
import mx.desarollo.entity.Profesor;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.time.LocalTime;

public class DelegateUA {
    private final UA_DAO uaDao;
    private final ProfesorDAO profDao;

    public DelegateUA() { this.uaDao = ServiceLocator.getInstanceUA_DAO();
        this.profDao = ServiceLocator.getInstanceProfesorDAO();}

    public boolean registrarUA( Unidad_aprendizaje ua ){
        try{
            uaDao.crearUA(ua);
            return true;
        } catch (Exception ex){
            System.out.println("Error al crear una Unidad de Aprendizaje: " + ex.getMessage());
            return false;
        }
    }

    public boolean modificarUA ( Unidad_aprendizaje ua ){
        try{
            Unidad_aprendizaje existe = uaDao.buscarID(ua.getId_uniapr());
            if(existe == null){
                System.out.println("No existe una Unidad de Aprendizaje");
                return false;
            }
            for(Profesor profesor : existe.getProfesores()){
                for(Unidad_aprendizaje unidad : profesor.getUnidades()){
                    if(unidad.getId_uniapr() == ua.getId_uniapr()){
                        continue;
                        /*
                        este if sirve para que no se tome en cuenta la misma unidad de aprendizaje que se manda
                        en caso de no hacerlo siempre va a detectar un traslape
                         */
                    }

                    if(traslapa(ua.getHora_inicio(), ua.getHora_fin(), unidad.getHora_inicio(), unidad.getHora_fin())){
                        System.out.println("Hay un error de traslape");
                        return false;
                    }
                }
            }
            return uaDao.modificarUA(ua);
        } catch (Exception ex) {
            System.out.println("Error al modificar Unidad de Aprendizaje: " + ex.getMessage());
            return false;
        }
    }

    public java.util.List<Unidad_aprendizaje> obtenerTodasLasUA() {
        try {
            return uaDao.obtenerTodasLasUA();
        } catch (Exception ex) {
            System.out.println("Error al obtener todas las UA: " + ex.getMessage());
            return null;
        }
    }

    public boolean eliminarUA(int idUA) {
        try {
            Unidad_aprendizaje existe = uaDao.buscarID(idUA);
            if (existe == null) {
                System.out.println("No existe la Unidad de Aprendizaje con id: " + idUA);
                return false;
            }
            return uaDao.eliminarUA(idUA);
        } catch (Exception ex) {
            System.out.println("Error al eliminar Unidad de Aprendizaje: " + ex.getMessage());
            return false;
        }
    }

    public boolean traslapa(LocalTime inic1, LocalTime fin1, LocalTime inic2, LocalTime fin2){
        if(inic1.equals(inic2)){ //se mira si la hora inicio es igual en las dos
            return true;
        }
        return inic1.isBefore(fin2) && inic2.isBefore(fin1);
        //si la hora inicio es antes que la hora fin esta bien, siempre y cuando la hora fin no sea antes que la hora inicio
    }
}
