package ui;

import helper.RegistroUA_Helper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.io.Serializable;

@Named ("RegistroUA_UI")
@ViewScoped
public class RegistroUA_BeanUI implements Serializable {
    private RegistroUA_Helper UA_helper;
    private Unidad_aprendizaje unidad_aprendizaje;

    public RegistroUA_BeanUI() { UA_helper = new RegistroUA_Helper(); }

    @PostConstruct
    public void init () { unidad_aprendizaje = new Unidad_aprendizaje(); }

    public void RegistrarUA(){
        boolean bandera = UA_helper.registrarUA(unidad_aprendizaje);
        if(bandera){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro exitoso",""));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro no exitoso","Verifica de nuevo los datos"));
        }
    }

    public Unidad_aprendizaje getUA(){
        return unidad_aprendizaje;
    }
    public void setUA(Unidad_aprendizaje unidad_aprendizaje){
        this.unidad_aprendizaje = unidad_aprendizaje;
    }
}
