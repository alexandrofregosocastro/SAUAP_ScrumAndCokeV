//el xhtml lo utiliza para saber en que pagina se encuentra y dejar activado el boton de la barra lateral
package ui;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("navigation")
@SessionScoped
public class NavigationBean implements Serializable {

    private String currentPage = "inicio"; // valor inicial

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    // Métodos para navegar
    public String goInicio() {
        currentPage = "login";
        return "login.xhtml?faces-redirect=true";
    }

    public String goProfesores() {
        currentPage = "profesores";
        return "profesores.xhtml?faces-redirect=true";
    }

    public String goClases() {
        currentPage = "clases";
        return "clases.xhtml?faces-redirect=true";
    }

    public String goAsignaciones() {
        currentPage = "asignaciones";
        return "asignaciones.xhtml?faces-redirect=true";
    }
}
