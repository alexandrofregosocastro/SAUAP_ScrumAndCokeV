package mx.desarollo.delegate;

import mx.avanti.desarollo.dao.ProfesorDAO;
import mx.avanti.desarollo.dao.UA_DAO;
import mx.avanti.desarollo.integration.ServiceLocator;
import mx.desarollo.entity.Profesor;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.time.LocalTime;
import java.util.List;

public class DelegateProfesor {
    private final ProfesorDAO profDao;
    private final UA_DAO uaDao;

    public DelegateProfesor(){

        this.profDao = ServiceLocator.getInstanceProfesorDAO();
        this.uaDao = ServiceLocator.getInstanceUA_DAO();
    }

    public boolean registrarProfesor(Profesor profesor){
        try{
            System.out.println("DelegateProfesor: Iniciando registro de profesor: " + profesor.getNombre());
            if (!profesor.getRFC().matches("^[A-Z0-9]+$")) {
                System.out.println("El formato de RFC es invalido: " + profesor.getRFC());
                return false;
            }

            Profesor existe = profDao.buscarRFC(profesor.getRFC());
            if(existe!= null){
                System.out.println("Profesor ya existe con RFC: " + profesor.getRFC());
                return false;
            }

            System.out.println("DelegateProfesor: Validaciones pasadas, guardando profesor...");
            profDao.crearProfesor(profesor);
            System.out.println("DelegateProfesor: Profesor registrado exitosamente");
            return true;
        } catch (Exception ex){
            System.out.println("Error en DelegateProfesor: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean asignarUA(int idProfesor, int idUA){
        try{
            Profesor profesor = profDao.buscarID(idProfesor);
            Unidad_aprendizaje ua = uaDao.buscarID(idUA);

            if(profesor == null || ua == null){ //Verifica si el profesor y la UA q buscamos existen
                return false;
            }

            /*
            para verificar si hay traslapes o no, se pide la hora de inicio y de fin que se quieren
            asignar, despues se sacan todas las horas inicios y horas fin de las clases asignadas
            al profesor y se comparan a ver si hay una que sea igual
             */
            LocalTime horaInicio = ua.getHora_inicio();
            LocalTime horaFin = ua.getHora_fin();

            for(Unidad_aprendizaje unidad : profesor.getUnidades()){
                LocalTime inic = unidad.getHora_inicio();
                LocalTime fin = unidad.getHora_fin();

                if(traslapa(horaInicio, horaFin,inic, fin)) {
                    System.out.println("Hay traslape de horarios");
                    return false;
                }
            }

            profDao.asignarUA(profesor, ua);
            return true;

        } catch (Exception ex){
            System.out.println("Error" + ex.getMessage());
            return false;
        }
    }
    public boolean traslapa(LocalTime inic1, LocalTime fin1, LocalTime inic2, LocalTime fin2){
        if(inic1.equals(inic2)){ //se mira si la hora inicio es igual en las dos
            return true;
        }
        return inic1.isBefore(fin2) && inic2.isBefore(fin1);
        //si la hora inicio es antes que la hora fin esta bien, siempre y cuando la hora fin no sea antes que la hora inicio
    }
    public List<Profesor> obtenerAsignaciones(){
        return profDao.obtenerAsignaciones();
    }
}