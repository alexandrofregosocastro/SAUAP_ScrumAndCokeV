//Esta le pasa al xhtml de los profesores la lista para imprimirla en la tabla
//aqui no se deberian de crear los profesores solamente pasarcelos al xhtml
package ui;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class ProfesorBean implements Serializable {
    private List<Profesor> listaProfesores;
    private List<Profesor> listaFiltrada;
    private String filtro;

    public ProfesorBean() {
        // Simulación: profesores iniciales
        listaProfesores = new ArrayList<>();
        listaProfesores.add(new Profesor(1, "Sebastian", "Charles Diaz", "123456789112"));
        listaProfesores.add(new Profesor(2, "Ana", "Lopez Perez", "987654321000"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));
        listaProfesores.add(new Profesor(3, "Luis", "Martinez Ruiz", "112233445566"));

        listaFiltrada = new ArrayList<>(listaProfesores);
    }


    private String globalFilter;

    public String getGlobalFilter() {
        return globalFilter;
    }

    public void setGlobalFilter(String globalFilter) {
        this.globalFilter = globalFilter;
    }

    // Getters & Setters
    public List<Profesor> getListaProfesores() { return listaProfesores; }
    public List<Profesor> getListaFiltrada() { return listaFiltrada; }
    public String getFiltro() { return filtro; }
    public void setFiltro(String filtro) { this.filtro = filtro; }
}
