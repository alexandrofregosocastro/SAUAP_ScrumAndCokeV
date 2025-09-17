/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import helper.LoginHelper;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarollo.entity.Usuario;

import java.io.IOException;
import java.io.Serializable;

@Named("LoginBeanUI")//Nombre que se va a usar en el HTML para llamar al Bean
@SessionScoped//Establece que el bean estara activo toda la sesion

public class LoginBeanUI implements Serializable {
    private Usuario usuario;
    private final LoginHelper lh;

    public LoginBeanUI() { lh = new LoginHelper(); }//Inicializa el bean helper
    /*Tambien se puede inicializar al momento de crear la variable, pero es una buena practica
    realizarlo de esta manera*/

    @PostConstruct //Indica que este metodo se hara automaticamente cuando el bean se contruya
    public void iniit() {//Se tiene que inicializar aqui para asegurarte que tiene las "configuraciones" necesarias
        usuario = new Usuario();
    }

    public void login() throws IOException{
        Usuario user = lh.login(usuario.getNombre_usuario(), usuario.getPassword());
        if(user != null) {
            usuario = user;
            String URL = "/inicio.xhtml"; //Aqui es la pagina a donde se redigira si el login funciona
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + URL);
            /*
            Cuando el usuario presiona el boton de registrar, JSF crea un objeto con las siguientes cosas:
            -Que pagina pidio
            -Que parametros mando
            -Que usuario de sesion es
            -Que respuesta va a devolver
            Esto es FacesContext la funcion current instance recibe la peticion actual
            el external context simplemente es necesario para obtener pues todo el contexto :P
             */
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos incorrectos", "Ingresa los datos nuevamente"));
        }
    }

    /* Los constructores son necesarios para la comunicacion del xhtml al bean, puesto que JSF
    (JavaServerFaces) llama a los dos metodos automaticamente al invocar el metodo en el xhtml
     */
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}
    
    
    
    
    

    

    

