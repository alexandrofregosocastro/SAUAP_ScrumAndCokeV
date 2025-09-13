package mx.desarollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "unidad_aprendizaje")
public class Unidad_aprendizaje {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_uniapr;
    @Column (length = 50)
    @Size(max = 50)
    String nombre;
    int horas_clase;
    int horas_taller;
    int horas_lab;

    @ManyToMany(mappedBy = "unidades")

    private Set<Profesor> profesores = new HashSet<Profesor>();

    public int getId_uniapr() {
        return id_uniapr;
    }

    public void setId_uniapr(int id_uniapr) {
        this.id_uniapr = id_uniapr;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras_clase() {
        return horas_clase;
    }

    public void setHoras_clase(int horas_clase) {
        this.horas_clase = horas_clase;
    }

    public int getHoras_taller() {
        return horas_taller;
    }

    public void setHoras_taller(int horas_taller) {
        this.horas_taller = horas_taller;
    }

    public int getHoras_lab() {
        return horas_lab;
    }

    public void setHoras_lab(int horas_lab) {
        this.horas_lab = horas_lab;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }
}
