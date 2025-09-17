package helper;

import mx.desarollo.entity.Profesor;
import mx.desarollo.integration.ServiceFacadeLocator;

import java.io.Serializable;
import java.util.List;

public class ConsultaGeneralHelper implements Serializable {

    public List<Profesor> obtenerRegistrosAsignaciones() {
        try{
            return ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerAsignaciones();
        } catch (Exception ex){
            System.out.println("Error al consultar las asignaciones de los profesores" + ex.getMessage());
            return null;
        }
    }

    public List<mx.desarollo.entity.Unidad_aprendizaje> obtenerTodasLasUnidades() {
        try{
            System.out.println("ConsultaGeneralHelper: Iniciando consulta de unidades de aprendizaje...");
            List<mx.desarollo.entity.Unidad_aprendizaje> unidades = ServiceFacadeLocator.getInstanceFacadeUA().obtenerTodasLasUA();
            System.out.println("ConsultaGeneralHelper: Unidades obtenidas: " + (unidades != null ? unidades.size() : "null"));
            return unidades;
        } catch (Exception ex){
            System.out.println("Error al consultar las unidades de aprendizaje: " + ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    public boolean modificarUA(mx.desarollo.entity.Unidad_aprendizaje ua) {
        try {
            System.out.println("ConsultaGeneralHelper: Modificando UA id=" + ua.getId_uniapr());
            return ServiceFacadeLocator.getInstanceFacadeUA().modificarUA(ua);
        } catch (Exception ex) {
            System.out.println("Error al modificar UA: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarUA(int idUA) {
        try {
            System.out.println("ConsultaGeneralHelper: Eliminando UA id=" + idUA);
            return ServiceFacadeLocator.getInstanceFacadeUA().eliminarUA(idUA);
        } catch (Exception ex) {
            System.out.println("Error al eliminar UA: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
