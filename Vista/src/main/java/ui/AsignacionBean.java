//Esta clase le manda al xhtml la lista de profes (solamente su nombre i id, y la lista de clases que imparten)
//Aqui no se debe de crear a ningun profesor ni clase, fue solamente con fines de pre=uebas
package ui;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Named("asignacionBean")
@ViewScoped
public class AsignacionBean implements Serializable {

    private List<ProfesorAsignado> listaProfesores;

    public AsignacionBean() {
        listaProfesores = new ArrayList<>();

        listaProfesores.add(new ProfesorAsignado(
                1, "Sebastian",
                Arrays.asList(
                        new Asignacion("Conectividad", 10, 10, 10),
                        new Asignacion("Desarrollo", 10, 10, 10)
                )
        ));

        listaProfesores.add(new ProfesorAsignado(
                2, "Ana",
                Arrays.asList(
                        new Asignacion("Matemáticas", 8, 6, 4),
                        new Asignacion("Bases de Datos", 6, 8, 6)
                )
        ));

        listaProfesores.add(new ProfesorAsignado(
                2, "Ana",
                Arrays.asList(
                        new Asignacion("Matemáticas", 8, 6, 4),
                        new Asignacion("Bases de Datos", 6, 8, 6)
                )
        ));

        listaProfesores.add(new ProfesorAsignado(
                2, "Ana",
                Arrays.asList(
                        new Asignacion("Matemáticas", 8, 6, 4),
                        new Asignacion("Bases de Datos", 6, 8, 6)
                )
        ));

        listaProfesores.add(new ProfesorAsignado(
                2, "Ana",
                Arrays.asList(
                        new Asignacion("Matemáticas", 8, 6, 4),
                        new Asignacion("Bases de Datos", 6, 8, 6)
                )
        ));
    }

    public List<ProfesorAsignado> getListaProfesores() {
        return listaProfesores;
    }
}

