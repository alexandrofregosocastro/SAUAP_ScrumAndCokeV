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
}
