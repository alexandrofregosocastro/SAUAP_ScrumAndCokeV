package helper;
import mx.desarollo.entity.Unidad_aprendizaje;
import mx.desarollo.integration.ServiceFacadeLocator;
import java.io.Serializable;

public class RegistroUA_Helper implements Serializable {
    public boolean registrarUA(Unidad_aprendizaje ua){
        try{
            return ServiceFacadeLocator.getInstanceFacadeUA().registrarUA(ua);
        }catch (Exception ex){
            System.out.println("Error" + ex.getMessage());
            return false;
        }
    }
}
