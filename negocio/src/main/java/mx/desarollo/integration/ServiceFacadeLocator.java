package mx.desarollo.integration;

import mx.desarollo.facade.FacadeProfesor;
import mx.desarollo.facade.FacadeUnidadAprendizaje;

public class ServiceFacadeLocator {

    private static FacadeProfesor facadeProfesor = new FacadeProfesor();
    private static FacadeUnidadAprendizaje facadeUA = new FacadeUnidadAprendizaje();
    //private static FacadeUsuario facadeUsuario;

    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }

    public static FacadeUnidadAprendizaje getInstanceFacadeUA(){
        return facadeUA;
    }

    /*
    public static FacadeUsuario getInstanceFacadeUsuario() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsuario();
            return facadeUsuario;
        } else {
            return facadeUsuario;
        }
    }
     */
}
