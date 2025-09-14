package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import helper.UnidadAprendizajeBeanHelper;
import mx.desarollo.entity.Unidad_aprendizaje;

import java.io.Serializable;
import java.util.List;

@Named("unidadBeanUI")
@ViewScoped
public class UnidadAprendizajeBeanUI implements Serializable {

    private UnidadAprendizajeBeanHelper helper = new UnidadAprendizajeBeanHelper();

    private List<Unidad_aprendizaje> lista;
    private String textoBusqueda;
    private int pagina = 0;
    private int tamanioPagina = 10;
    private long total;

    @PostConstruct
    public void init(){
        cargarLista();
    }

    public void cargarLista(){
        lista = helper.listarTodas();
        //total = helper.contarTodas();
    }

    public void buscar(){
        if(textoBusqueda == null || textoBusqueda.isBlank()){
            cargarLista();
        } else {
            lista = helper.buscarPorNombre(textoBusqueda);
            total = lista.size();
        }
    }

    /*public void paginar(){
        lista = helper.listarPagina(pagina, tamanioPagina);
        total = helper.contarTodas();
    }*/

    // Getters y setters
    public List<Unidad_aprendizaje> getLista() { return lista; }
    public String getTextoBusqueda() { return textoBusqueda; }
    public void setTextoBusqueda(String textoBusqueda) { this.textoBusqueda = textoBusqueda; }
    public int getPagina() { return pagina; }
    public void setPagina(int pagina) { this.pagina = pagina; }
    public int getTamanioPagina() { return tamanioPagina; }
    public void setTamanioPagina(int tamanioPagina) { this.tamanioPagina = tamanioPagina; }
    public long getTotal() { return total; }
}
