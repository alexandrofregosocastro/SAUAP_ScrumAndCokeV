/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import helper.RegistroProfesorHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarollo.entity.Profesor;
import mx.desarollo.entity.Usuario;

import java.io.IOException;
import java.io.Serializable;

@Named("RegistroProfesorUI")
@ViewScoped //Especifica que se destruira al momento de completar el formulario
public class RegistroProfesorBeanUI implements Serializable{
    private RegistroProfesorHelper RPH;
    private Profesor profesor;

    public RegistroProfesorBeanUI() {
        RPH = new RegistroProfesorHelper();
    }

    @PostConstruct
    public void init(){
        profesor = new Profesor();
    }

    /*
     public void login() throws IOException{
        String appURL = "/index.xhtml";
        Usuario us= new Usuario();
        us = loginHelper.Login(usuario.getNombre_usuario(), usuario.getPassword());
          if(us != null && us.getNombre_usuario()!=null){
            usuario=us;
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + appURL);
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o contraseña incorrecta:", "Intente de nuevo"));
        }
    }

     */

    public void RegistrarProfesor(){
        boolean bandera = RPH.registrarProfesor(profesor);
        if(bandera == true){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro exitoso",""));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro no exitoso","Verifica de nuevo los datos"));
        }
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

}
