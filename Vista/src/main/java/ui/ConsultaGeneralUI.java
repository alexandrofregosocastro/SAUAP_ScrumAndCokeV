package ui;

import helper.ConsultaGeneralHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarollo.entity.Profesor;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.io.Serializable;
import java.util.List;

@Named("ConsultaGeneralUI")
@ViewScoped
public class ConsultaGeneralUI implements Serializable {
    ConsultaGeneralHelper CGH;
    private List<Profesor> lista_profesores;
    private List<Unidad_aprendizaje> lista_unidades;
    // Estado para acciones de edición y eliminación
    private Unidad_aprendizaje unidadSeleccionada;
    private Unidad_aprendizaje editUA;

    @PostConstruct
    public void init() {
        CGH = new ConsultaGeneralHelper();
        lista_profesores = CGH.obtenerRegistrosAsignaciones();
        lista_unidades = CGH.obtenerTodasLasUnidades();
        System.out.println("Profesores: " + (lista_profesores != null ? lista_profesores.size() : 0));
        System.out.println("Unidades: " + (lista_unidades != null ? lista_unidades.size() : 0));
    }
    public void mensajeError(){
        if (lista_profesores == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Busqueda fallida",""));
        }
    }

    public List<Profesor> getLista_profesores() {
        return lista_profesores;
    }

    public List<Unidad_aprendizaje> getLista_unidades() {
        return lista_unidades;
    }
    //No se ocupa un set pq no va a recibir parametros

    public void abrirMod(Unidad_aprendizaje ua) {
        if (ua == null) return;
        // Creamos una copia editable para no tocar la referencia de la tabla
        editUA = new Unidad_aprendizaje();
        editUA.setId_uniapr(ua.getId_uniapr());
        editUA.setNombre(ua.getNombre());
        editUA.setHoras_clase(ua.getHoras_clase());
        editUA.setHoras_taller(ua.getHoras_taller());
        editUA.setHoras_lab(ua.getHoras_lab());
        editUA.setHora_inicio(ua.getHora_inicio());
        editUA.setHora_fin(ua.getHora_fin());
    }

    public void modificarUA() {
        try {
            if (editUA == null) return;
            boolean ok = CGH.modificarUA(editUA);
            if (ok) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad actualizada", "Cambios guardados correctamente"));
                refrescarUnidades();
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo actualizar", "Verifica que el horario no traslape y los datos sean válidos"));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar", ex.getMessage()));
        }
    }

    public void prepararEliminar(Unidad_aprendizaje ua) {
        this.unidadSeleccionada = ua;
    }

    public void eliminarUA() {
        try {
            if (unidadSeleccionada == null) return;
            boolean ok = CGH.eliminarUA(unidadSeleccionada.getId_uniapr());
            if (ok) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad eliminada", unidadSeleccionada.getNombre()));
                refrescarUnidades();
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo eliminar", "La unidad puede estar relacionada con profesores"));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar", ex.getMessage()));
        }
    }

    public void refrescarUnidades() {
        lista_unidades = CGH.obtenerTodasLasUnidades();
    }

    // ----- Getters/Setters adicionales -----
    public Unidad_aprendizaje getUnidadSeleccionada() { return unidadSeleccionada; }
    public void setUnidadSeleccionada(Unidad_aprendizaje unidadSeleccionada) { this.unidadSeleccionada = unidadSeleccionada; }
    public Unidad_aprendizaje getEditUA() { return editUA; }
    public void setEditUA(Unidad_aprendizaje editUA) { this.editUA = editUA; }
}
