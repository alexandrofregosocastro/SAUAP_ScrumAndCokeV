/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import mx.desarollo.entity.Profesor;
import mx.desarollo.integration.ServiceFacadeLocator;
import java.io.Serializable;

public class RegistroProfesorHelper implements Serializable {
    

    public boolean registrarProfesor(Profesor profesor){
        try{
            ServiceFacadeLocator.getInstanceFacadeProfesor().registrarProfesor(profesor);
            return true;
        }catch (Exception ex){
            System.out.println("Error" + ex.getMessage());
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
