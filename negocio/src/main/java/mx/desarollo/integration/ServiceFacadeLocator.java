package mx.desarollo.integration;

import mx.desarollo.facade.FacadeProfesor;
import mx.desarollo.facade.FacadeUA;

public class ServiceFacadeLocator {

    private static FacadeProfesor facadeProfesor = new FacadeProfesor();
    //private static FacadeUsuario facadeUsuario;

    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }

    public static FacadeUA facadeUA = new FacadeUA();

    public static FacadeUA getInstanceFacadeUA() {
        if (facadeUA == null) {
            facadeUA = new FacadeUA();
            return facadeUA;
        } else{
            return facadeUA;
        }
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
