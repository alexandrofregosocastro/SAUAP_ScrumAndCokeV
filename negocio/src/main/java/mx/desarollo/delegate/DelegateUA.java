package mx.desarollo.delegate;

import mx.avanti.desarollo.dao.UA_DAO;
import mx.avanti.desarollo.integration.ServiceLocator;
import mx.desarollo.entity.Unidad_aprendizaje;

public class DelegateUA {
    private final UA_DAO uaDao;

    public DelegateUA() { this.uaDao = ServiceLocator.getInstanceUA_DAO(); }

    public boolean registrarUA( Unidad_aprendizaje ua ){
        try{
            uaDao.crearUA(ua);
            return true;
        } catch (Exception ex){
            System.out.println("Error al crear una Unidad de Aprendizaje: " + ex.getMessage());
            return false;
        }
    }
}
