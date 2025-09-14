package ui;
import helper.AsignacionHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;


@Named("AsignacionUI")
@ViewScoped
public class AsignacionUI implements Serializable {
    private AsignacionHelper AH;
    private  Integer idProfesor;
    private Integer idUA;

    @PostConstruct
    public void init() {
        AH = new AsignacionHelper();
    }

    public void Asignar(){
        boolean bandera = AH.asignarUA(idProfesor, idUA);

        if(bandera){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Asignacion exitosa",""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Registro fallido",""));
        }

    }

    public Integer getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }
    public Integer getIdUA() {
        return idUA;
    }
    public void setIdUA(Integer idUA) {
        this.idUA = idUA;
    }
}
