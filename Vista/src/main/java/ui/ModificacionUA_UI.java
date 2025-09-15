package ui;

import helper.ModificacionUA_Helper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.io.Serializable;

@Named("ModificacionUA_UI")
@ViewScoped
public class ModificacionUA_UI implements Serializable {
    private ModificacionUA_Helper MUAH;
    private Unidad_aprendizaje unidad;

    public ModificacionUA_UI() { MUAH = new ModificacionUA_Helper(); }

    @PostConstruct
    public void init () { unidad = new Unidad_aprendizaje(); }

    public void modificarUA(){
        boolean bandera = MUAH.modificarUA(unidad);
        if(bandera){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Modificacion exitosa",""));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro fallido",""));
        }

    }

    public Unidad_aprendizaje getUnidad() {
        return unidad;
    }
    public void setUnidad(Unidad_aprendizaje unidad) {
        this.unidad = unidad;
    }
}
