package ui;

import helper.ConsultaGeneralHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarollo.entity.Profesor;
import java.io.Serializable;
import java.util.List;

@Named("ConsultaGeneralUI")
@ViewScoped
public class ConsultaGeneralUI implements Serializable {
    ConsultaGeneralHelper CGH;
    private List<Profesor> lista_profesores;

    @PostConstruct
    public void init() {
        CGH = new ConsultaGeneralHelper();
        lista_profesores = CGH.obtenerRegistrosAsignaciones();
    }
    public void mensajeError(){
        if (lista_profesores == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Busqueda fallida",""));
        }
    }

    public List<Profesor> getLista_profesores() {
        return lista_profesores;
    }
    //No se ocupa un set pq no va a recibir parametros
}
