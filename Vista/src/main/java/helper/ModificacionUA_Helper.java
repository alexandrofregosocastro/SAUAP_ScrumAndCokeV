package helper;

import mx.desarollo.entity.Unidad_aprendizaje;
import mx.desarollo.integration.ServiceFacadeLocator;

import java.io.Serializable;

public class ModificacionUA_Helper implements Serializable {
    public boolean modificarUA(Unidad_aprendizaje unidad){
        try{
            return ServiceFacadeLocator.getInstanceFacadeUA().modificarUA(unidad);
        } catch(Exception ex){
            System.out.println("Error modificando unidad aprendizaje " + ex.getMessage());
            return false;
        }
    }
}
