package mx.desarollo.facade;

import mx.desarollo.entity.Unidad_aprendizaje;
import mx.desarollo.delegate.DelegateUA;

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
}
