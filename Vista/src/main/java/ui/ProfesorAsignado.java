package ui;

import java.util.List;

public class ProfesorAsignado {
    private int id;
    private String nombre;
    private List<Asignacion> clases;

    public ProfesorAsignado(int id, String nombre, List<Asignacion> clases) {
        this.id = id;
        this.nombre = nombre;
        this.clases = clases;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Asignacion> getClases() { return clases; }
    public void setClases(List<Asignacion> clases) { this.clases = clases; }
}

