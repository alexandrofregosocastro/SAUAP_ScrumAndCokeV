package mx.desarollo.facade;

import mx.desarollo.delegate.DelegateProfesor;
import mx.desarollo.entity.Profesor;

public class FacadeProfesor {

    /*
    Los facades sirven para ocultar toda la complejidad del codigo, como por ejemplo el delegate y el DAO
    Es un patron de diseno, hace que la capa de vista solo se comunique con el facade y no se preocupe
    de nada mas, el facade llama a los meotodos "complejos"
     */
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }

    public boolean registrarProfesor(Profesor profesor){
        return delegateProfesor.registrarProfesor(profesor);
    }

}
