package mx.desarollo.facade;

import mx.desarollo.delegate.DelegateUA;
import mx.desarollo.entity.Unidad_aprendizaje;

public class FacadeUA {
    private final DelegateUA delegateUA;

    public FacadeUA() {
        this.delegateUA = new DelegateUA();
    }

    public boolean registrarUA(Unidad_aprendizaje ua){
        return delegateUA.registrarUA(ua);
    }

    public boolean modificarUA(Unidad_aprendizaje ua){
        return delegateUA.modificarUA(ua);
    }

    public java.util.List<Unidad_aprendizaje> obtenerTodasLasUA(){
        return delegateUA.obtenerTodasLasUA();
    }

    public boolean eliminarUA(int idUA) {
        return delegateUA.eliminarUA(idUA);
    }
}
