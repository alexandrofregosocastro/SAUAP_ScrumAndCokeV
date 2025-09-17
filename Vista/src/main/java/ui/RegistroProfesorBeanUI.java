package ui;

import helper.RegistroProfesorHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarollo.entity.Profesor;
import java.io.Serializable;

@Named("RegistroProfesorUI")//mombre q usara el XHTML
@ViewScoped
public class RegistroProfesorBeanUI implements Serializable{
    private RegistroProfesorHelper RPH;
    private Profesor profesor;

    public RegistroProfesorBeanUI() {
        RPH = new RegistroProfesorHelper();
    }
    //
    @PostConstruct
    public void init(){
        profesor = new Profesor();
    }

    public void RegistrarProfesor(){
        System.out.println("RegistroProfesorBeanUI: Iniciando proceso de registro");
        boolean bandera = RPH.registrarProfesor(profesor);
        if(bandera){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro exitoso","El profesor ha sido registrado correctamente"));
            // Limpiar el formulario después del registro exitoso
            profesor = new Profesor();
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
