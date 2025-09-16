//Esta clase no sirve fue creada solamenet para pruebas
package ui;
public class Asignacion {
    private String claseAsignada;
    private int hrClase;
    private int hrTaller;
    private int hrLaboratorio;

    public Asignacion(String claseAsignada, int hrClase, int hrTaller, int hrLaboratorio) {
        this.claseAsignada = claseAsignada;
        this.hrClase = hrClase;
        this.hrTaller = hrTaller;
        this.hrLaboratorio = hrLaboratorio;
    }

    public String getClaseAsignada() { return claseAsignada; }
    public void setClaseAsignada(String claseAsignada) { this.claseAsignada = claseAsignada; }

    public int getHrClase() { return hrClase; }
    public void setHrClase(int hrClase) { this.hrClase = hrClase; }

    public int getHrTaller() { return hrTaller; }
    public void setHrTaller(int hrTaller) { this.hrTaller = hrTaller; }

    public int getHrLaboratorio() { return hrLaboratorio; }
    public void setHrLaboratorio(int hrLaboratorio) { this.hrLaboratorio = hrLaboratorio; }
}
