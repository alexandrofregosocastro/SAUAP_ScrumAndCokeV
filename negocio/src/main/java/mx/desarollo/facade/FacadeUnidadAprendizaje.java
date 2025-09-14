package mx.desarollo.facade;

import mx.desarollo.delegate.DelegateUnidadAprendizaje;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.util.List;

public class FacadeUnidadAprendizaje {
    private final DelegateUnidadAprendizaje d = new DelegateUnidadAprendizaje();

    public List<Unidad_aprendizaje> listar(String orderBy, boolean asc){ return d.listar(orderBy, asc); }
    public List<Unidad_aprendizaje> buscarPorNombre(String texto, String orderBy, boolean asc){ return d.buscarPorNombre(texto, orderBy, asc); }
    /*public List<Unidad_aprendizaje> listarPagina(int pageIndex, int pageSize, String orderBy, boolean asc){ return d.listarPagina(pageIndex, pageSize, orderBy, asc); }
    public long contarTodas(){ return d.contarTodas(); }
    public List<Unidad_aprendizaje> filtrarPorHoras(Integer clase, Integer taller, Integer lab, String orderBy, boolean asc){
        return d.filtrarPorHoras(clase, taller, lab, orderBy, asc);
    }*/
}
