package bodenor.api.lectura.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LecturaRemarcador {
    private LocalDateTime timestamp;
    private LocalDate fecha;
    private Integer anio, mes, dia;

    private Integer idConversor;
    private String ipConversor;
    private Integer idRemarcador;
    private Integer numRemarcador;
    
    private Double energia;
    private Double potencia;
    
    private boolean calculable;
    
    private String tipoRemarcador;
	
	private boolean manual = false;

    public LecturaRemarcador() {
    }

    public LecturaRemarcador(LocalDateTime timestamp, LocalDate fecha, Integer anio, Integer mes, Integer dia, Integer idConversor, String ipConversor, Integer idRemarcador, Integer numRemarcador, Double energia, Double potencia, boolean calculable, String tipoRemarcador, boolean manual) {
        this.timestamp = timestamp;
        this.fecha = fecha;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.idConversor = idConversor;
        this.ipConversor = ipConversor;
        this.idRemarcador = idRemarcador;
        this.numRemarcador = numRemarcador;
        this.energia = energia;
        this.potencia = potencia;
        this.calculable = calculable;
        this.tipoRemarcador = tipoRemarcador;
		this.manual = manual;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getIdConversor() {
        return idConversor;
    }

    public void setIdConversor(Integer idConversor) {
        this.idConversor = idConversor;
    }

    public String getIpConversor() {
        return ipConversor;
    }

    public void setIpConversor(String ipConversor) {
        this.ipConversor = ipConversor;
    }

    public Integer getIdRemarcador() {
        return idRemarcador;
    }

    public void setIdRemarcador(Integer idRemarcador) {
        this.idRemarcador = idRemarcador;
    }

    public Integer getNumRemarcador() {
        return numRemarcador;
    }

    public void setNumRemarcador(Integer numRemarcador) {
        this.numRemarcador = numRemarcador;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        this.energia = energia;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public boolean esCalculable() {
        return calculable;
    }

    public void setCalculable(boolean calculable) {
        this.calculable = calculable;
    }
    
    public String getTipoRemarcador() {
        return tipoRemarcador;
    }

    public void setTipoRemarcador(String tipoRemarcador) {
        this.tipoRemarcador = tipoRemarcador;
    }

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}
	
	
    
}
