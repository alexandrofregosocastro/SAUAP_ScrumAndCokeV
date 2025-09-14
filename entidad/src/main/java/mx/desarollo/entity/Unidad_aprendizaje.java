package mx.desarollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "unidad_aprendizaje")
public class Unidad_aprendizaje {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_uniapr;
    @Column (length = 50)
    @Size(max = 50)
    private String nombre;
    private int horas_clase;
    private int horas_taller;
    private int horas_lab;
    @Column(name = "hora_inicio",nullable = false)//realmente no es necesarip es solo si el nombre del java no coincide con el de la BD
    private LocalTime hora_inicio;
    @Column(name = "hora_fin",nullable = false)
    private LocalTime hora_fin;

    @ManyToMany(mappedBy = "unidades")

    private Set<Profesor> profesores = new HashSet<Profesor>();

    public int getId_uniapr() {
        return id_uniapr;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }
    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
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
