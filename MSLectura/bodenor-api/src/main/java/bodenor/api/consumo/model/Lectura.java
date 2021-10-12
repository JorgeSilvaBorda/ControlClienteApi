package bodenor.api.consumo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Lectura {
    private LocalDateTime time;
    private LocalDate fecha;
    private Integer anio, mes, dia, hh, mm, ss;
    private Double lectura;
    private Double potencia;
    private Double delta;
    private Cliente cliente;
	boolean manual = false;

    public Lectura() {
    }

    public Lectura(LocalDateTime time, LocalDate fecha, Integer anio, Integer mes, Integer dia, Integer hh, Integer mm, Integer ss, Double lectura, Double potencia, Double delta, Cliente cliente, boolean manual) {
        this.time = time;
        this.fecha = fecha;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
        this.lectura = lectura;
        this.potencia = potencia;
        this.delta = delta;
        this.cliente = cliente;
		this.manual = manual;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
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

    public Integer getHh() {
        return hh;
    }

    public void setHh(Integer hh) {
        this.hh = hh;
    }

    public Integer getMm() {
        return mm;
    }

    public void setMm(Integer mm) {
        this.mm = mm;
    }

    public Integer getSs() {
        return ss;
    }

    public void setSs(Integer ss) {
        this.ss = ss;
    }

    public Double getLectura() {
        return lectura;
    }

    public void setLectura(Double lectura) {
        this.lectura = lectura;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }
    
    public Double getDelta() {
        return delta;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}
}
