package helper;

import mx.desarollo.integration.ServiceFacadeLocator;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class UnidadAprendizajeBeanHelper implements Serializable {

    public List<Unidad_aprendizaje> listarTodas(){
        try {
            return ServiceFacadeLocator.getInstanceFacadeUA().listar("nombre", true);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Unidad_aprendizaje> buscarPorNombre(String texto){
        try {
            return ServiceFacadeLocator.getInstanceFacadeUA().buscarPorNombre(texto, "nombre", true);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /*public List<Unidad_aprendizaje> listarPagina(int pagina, int tamanio){
        try {
            return ServiceFacadeLocator.getInstanceFacadeUA().listarPagina(pagina, tamanio, "nombre", true);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public long contarTodas(){
        try {
            return ServiceFacadeLocator.getInstanceFacadeUA().contarTodas();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }*/
}
