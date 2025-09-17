package helper;

import mx.desarollo.integration.ServiceFacadeLocator;

import java.io.Serializable;

public class AsignacionHelper implements Serializable {

    public boolean asignarUA(Integer idProfesor, Integer idUA){
        try{
            return ServiceFacadeLocator.getInstanceFacadeProfesor().asignarUA(idProfesor, idUA);
        } catch (Exception ex){
            System.out.println("Error al asignar UA" + ex.getMessage());
            return false;
        }
    }
}
