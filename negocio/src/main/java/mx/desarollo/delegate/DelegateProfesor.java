package mx.desarollo.delegate;

import mx.avanti.desarollo.dao.ProfesorDAO;
import mx.avanti.desarollo.integration.ServiceLocator;
import mx.desarollo.entity.Profesor;

public class DelegateProfesor {
    private final ProfesorDAO profDao;

    public DelegateProfesor(){
        this.profDao = ServiceLocator.getInstanceProfesorDAO();
    }

    public boolean registrarProfesor(Profesor profesor){
        try{

            if (!profesor.getRFC().matches("^[A-Z]{4}[0-9]{9}$")) {
                System.out.println("El formato de RFC es invalido");
                return false;
            }

            Profesor existe = profDao.buscarRFC(profesor.getRFC());
            if(existe!= null){
                System.out.println("Profesor ja existe");
                return false;
            }
            profDao.crearProfesor(profesor);
            return true;
        } catch (Exception ex){
            System.out.println("Error" + ex.getMessage());
            return false;
        }
    }
}