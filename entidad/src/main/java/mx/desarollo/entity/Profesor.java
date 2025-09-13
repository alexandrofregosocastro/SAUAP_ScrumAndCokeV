package mx.desarollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table (name = "profesor")
public class Profesor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    @Size(max = 50)
    private String nombre;
    @Column(length = 50)
    @Size(max = 50)
    private String apellido_paterno;
    @Column(length = 50)
    @Size(max = 50)
    private String apellido_materno;
    @Column(length = 12, unique = true, nullable = false)
    @Size(max = 12)
    private String RFC;

    @ManyToMany
    @JoinTable(
            name = "imparte",
            joinColumns = @JoinColumn(name = "id_profesor"),
            inverseJoinColumns = @JoinColumn (name = "id_uniapr")
    )
    private Set<Unidad_aprendizaje> unidades = new HashSet<>();

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public Set<Unidad_aprendizaje> getUnidades() {
        return unidades;
    }

    public void setUnidades(Set<Unidad_aprendizaje> unidades) {
        this.unidades = unidades;
    }
}