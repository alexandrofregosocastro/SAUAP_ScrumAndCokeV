package mx.desarollo.delegate;

import mx.avanti.desarollo.dao.UnidadAprendizajeDAO;
import mx.avanti.desarollo.integration.ServiceLocator;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.util.List;

public class DelegateUnidadAprendizaje {

    private final UnidadAprendizajeDAO dao = ServiceLocator.getInstanceUnidadAprendizajeDAO();

    public List<Unidad_aprendizaje> listar(String orderBy, boolean asc){
        // Sólo permitir ordenar por campos conocidos para evitar JPQL injection
        String campo = normalizarCampoOrden(orderBy);
        return dao.findAllOrdered(campo, asc);
    }

    public List<Unidad_aprendizaje> buscarPorNombre(String texto, String orderBy, boolean asc){
        String campo = normalizarCampoOrden(orderBy);
        String t = texto == null ? "" : texto.trim();
        if(t.length() > 50) t = t.substring(0,50); // límite prudente
        return dao.searchByNombre(t, campo, asc);
    }

    /*public List<Unidad_aprendizaje> listarPagina(int pageIndex, int pageSize, String orderBy, boolean asc){
        if(pageIndex < 0) pageIndex = 0;
        if(pageSize <= 0 || pageSize > 200) pageSize = 10; // default y límite
        String campo = normalizarCampoOrden(orderBy);
        return dao.findPage(pageIndex, pageSize, campo, asc);
    }

    public long contarTodas(){
        return dao.countAll();
    }

    public List<Unidad_aprendizaje> filtrarPorHoras(Integer clase, Integer taller, Integer lab, String orderBy, boolean asc){
        validarRangoHoras(clase);
        validarRangoHoras(taller);
        validarRangoHoras(lab);
        String campo = normalizarCampoOrden(orderBy);
        return dao.filterByHoras(clase, taller, lab, campo, asc);
    }

    private void validarRangoHoras(Integer v){
        if(v == null) return;
        if(v < 0 || v > 4) throw new IllegalArgumentException("Las horas deben estar entre 0 y 4");
    }

    /** Permite sólo campos de orden válidos */
    private String normalizarCampoOrden(String orderBy){
        if(orderBy == null) return "nombre";
        switch (orderBy) {
            case "nombre":
            case "horas_clase":
            case "horas_taller":
            case "horas_lab":
                return orderBy;
            default:
                return "nombre";
        }
    }
}
