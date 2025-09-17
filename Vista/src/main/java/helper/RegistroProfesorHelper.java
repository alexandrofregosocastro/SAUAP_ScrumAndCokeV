package helper;


import mx.desarollo.entity.Profesor;
import mx.desarollo.integration.ServiceFacadeLocator;

import java.io.Serializable;

public class RegistroProfesorHelper implements Serializable {
    

    public boolean registrarProfesor(Profesor profesor){
        try{
            System.out.println("RegistroProfesorHelper: Iniciando registro de profesor");
            System.out.println("Datos del profesor: " + profesor.getNombre() + " " + profesor.getApellido_paterno() + " RFC: " + profesor.getRFC());
            
            boolean resultado = ServiceFacadeLocator.getInstanceFacadeProfesor().registrarProfesor(profesor);
            
            System.out.println("RegistroProfesorHelper: Resultado del registro: " + resultado);
            return resultado;
        }catch (Exception ex){
            System.out.println("Error en RegistroProfesorHelper: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @param correo
     * @param password
     * @return 
     */
    /*
    public Usuario Login(String correo, String password){
        return ServiceFacadeLocator.getInstanceFacadeUsuario().login(password, correo);
    }
     */
}
