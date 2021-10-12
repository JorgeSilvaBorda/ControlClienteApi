package bodenor.api.conversor.model;

public class Remarcador {
    private Integer numPuerto;
    private String tipoRemarcador;

    public Remarcador() {
    }

    public Remarcador(Integer numPuerto, String tipoRemarcador) {
        this.numPuerto = numPuerto;
        this.tipoRemarcador = tipoRemarcador;
    }

    public Integer getNumPuerto() {
        return numPuerto;
    }

    public void setNumPuerto(Integer numPuerto) {
        this.numPuerto = numPuerto;
    }

    public String getTipoRemarcador() {
        return tipoRemarcador;
    }

    public void setTipoRemarcador(String tipoRemarcador) {
        this.tipoRemarcador = tipoRemarcador;
    }
    
    
}
