package helper;

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
