package bodenor.api.tarifa.model;

import java.time.LocalDateTime;

public class Detalle {
	
	private LocalDateTime timeCreacion;
	private LocalDateTime timeDesde;
	private LocalDateTime timeHasta;
	
	private Double cargoFijo;
	private Double cargoServicioPublico;
	private Double transporteElectricidad;
	private Double cargoEnergia;
	
	private Double cargoDemandaMaximaPotenciaLeidaHoraPuntaAA;
	private Double cargoDemandaMaximaPotenciaLeidaHoraPuntaAS;
	private Double cargoDemandaMaximaPotenciaLeidaHoraPuntaSA;
	private Double cargoDemandaMaximaPotenciaLeidaHoraPuntaSS;
	
	private Double cargoDemandaMaximaPotenciaSuministradaAA;
	private Double cargoDemandaMaximaPotenciaSuministradaAS;
	private Double cargoDemandaMaximaPotenciaSuministradaSA;
	private Double cargoDemandaMaximaPotenciaSuministradaSS;
	
	private String accion;

	public Detalle() {
	}

	public Detalle(LocalDateTime timeCreacion, LocalDateTime timeDesde, LocalDateTime timeHasta, Double cargoFijo, Double cargoServicioPublico, Double transporteElectricidad, Double cargoEnergia, Double cargoDemandaMaximaPotenciaLeidaHoraPuntaAA, Double cargoDemandaMaximaPotenciaLeidaHoraPuntaAS, Double cargoDemandaMaximaPotenciaLeidaHoraPuntaSA, Double cargoDemandaMaximaPotenciaLeidaHoraPuntaSS, Double cargoDemandaMaximaPotenciaSuministradaAA, Double cargoDemandaMaximaPotenciaSuministradaAS, Double cargoDemandaMaximaPotenciaSuministradaSA, Double cargoDemandaMaximaPotenciaSuministradaSS, String accion) {
		this.timeCreacion = timeCreacion;
		this.timeDesde = timeDesde;
		this.timeHasta = timeHasta;
		this.cargoFijo = cargoFijo;
		this.cargoServicioPublico = cargoServicioPublico;
		this.transporteElectricidad = transporteElectricidad;
		this.cargoEnergia = cargoEnergia;
		this.cargoDemandaMaximaPotenciaLeidaHoraPuntaAA = cargoDemandaMaximaPotenciaLeidaHoraPuntaAA;
		this.cargoDemandaMaximaPotenciaLeidaHoraPuntaAS = cargoDemandaMaximaPotenciaLeidaHoraPuntaAS;
		this.cargoDemandaMaximaPotenciaLeidaHoraPuntaSA = cargoDemandaMaximaPotenciaLeidaHoraPuntaSA;
		this.cargoDemandaMaximaPotenciaLeidaHoraPuntaSS = cargoDemandaMaximaPotenciaLeidaHoraPuntaSS;
		this.cargoDemandaMaximaPotenciaSuministradaAA = cargoDemandaMaximaPotenciaSuministradaAA;
		this.cargoDemandaMaximaPotenciaSuministradaAS = cargoDemandaMaximaPotenciaSuministradaAS;
		this.cargoDemandaMaximaPotenciaSuministradaSA = cargoDemandaMaximaPotenciaSuministradaSA;
		this.cargoDemandaMaximaPotenciaSuministradaSS = cargoDemandaMaximaPotenciaSuministradaSS;
		this.accion = accion;
	}

	public LocalDateTime getTimeCreacion() {
		return timeCreacion;
	}

	public void setTimeCreacion(LocalDateTime timeCreacion) {
		this.timeCreacion = timeCreacion;
	}

	public LocalDateTime getTimeDesde() {
		return timeDesde;
	}

	public void setTimeDesde(LocalDateTime timeDesde) {
		this.timeDesde = timeDesde;
	}

	public LocalDateTime getTimeHasta() {
		return timeHasta;
	}

	public void setTimeHasta(LocalDateTime timeHasta) {
		this.timeHasta = timeHasta;
	}

	public Double getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(Double cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public Double getCargoServicioPublico() {
		return cargoServicioPublico;
	}

	public void setCargoServicioPublico(Double cargoServicioPublico) {
		this.cargoServicioPublico = cargoServicioPublico;
	}

	public Double getTransporteElectricidad() {
		return transporteElectricidad;
	}

	public void setTransporteElectricidad(Double transporteElectricidad) {
		this.transporteElectricidad = transporteElectricidad;
	}

	public Double getCargoEnergia() {
		return cargoEnergia;
	}

	public void setCargoEnergia(Double cargoEnergia) {
		this.cargoEnergia = cargoEnergia;
	}

	public Double getCargoDemandaMaximaPotenciaLeidaHoraPuntaAA() {
		return cargoDemandaMaximaPotenciaLeidaHoraPuntaAA;
	}

	public void setCargoDemandaMaximaPotenciaLeidaHoraPuntaAA(Double cargoDemandaMaximaPotenciaLeidaHoraPuntaAA) {
		this.cargoDemandaMaximaPotenciaLeidaHoraPuntaAA = cargoDemandaMaximaPotenciaLeidaHoraPuntaAA;
	}

	public Double getCargoDemandaMaximaPotenciaLeidaHoraPuntaAS() {
		return cargoDemandaMaximaPotenciaLeidaHoraPuntaAS;
	}

	public void setCargoDemandaMaximaPotenciaLeidaHoraPuntaAS(Double cargoDemandaMaximaPotenciaLeidaHoraPuntaAS) {
		this.cargoDemandaMaximaPotenciaLeidaHoraPuntaAS = cargoDemandaMaximaPotenciaLeidaHoraPuntaAS;
	}

	public Double getCargoDemandaMaximaPotenciaLeidaHoraPuntaSA() {
		return cargoDemandaMaximaPotenciaLeidaHoraPuntaSA;
	}

	public void setCargoDemandaMaximaPotenciaLeidaHoraPuntaSA(Double cargoDemandaMaximaPotenciaLeidaHoraPuntaSA) {
		this.cargoDemandaMaximaPotenciaLeidaHoraPuntaSA = cargoDemandaMaximaPotenciaLeidaHoraPuntaSA;
	}

	public Double getCargoDemandaMaximaPotenciaLeidaHoraPuntaSS() {
		return cargoDemandaMaximaPotenciaLeidaHoraPuntaSS;
	}

	public void setCargoDemandaMaximaPotenciaLeidaHoraPuntaSS(Double cargoDemandaMaximaPotenciaLeidaHoraPuntaSS) {
		this.cargoDemandaMaximaPotenciaLeidaHoraPuntaSS = cargoDemandaMaximaPotenciaLeidaHoraPuntaSS;
	}

	public Double getCargoDemandaMaximaPotenciaSuministradaAA() {
		return cargoDemandaMaximaPotenciaSuministradaAA;
	}

	public void setCargoDemandaMaximaPotenciaSuministradaAA(Double cargoDemandaMaximaPotenciaSuministradaAA) {
		this.cargoDemandaMaximaPotenciaSuministradaAA = cargoDemandaMaximaPotenciaSuministradaAA;
	}

	public Double getCargoDemandaMaximaPotenciaSuministradaAS() {
		return cargoDemandaMaximaPotenciaSuministradaAS;
	}

	public void setCargoDemandaMaximaPotenciaSuministradaAS(Double cargoDemandaMaximaPotenciaSuministradaAS) {
		this.cargoDemandaMaximaPotenciaSuministradaAS = cargoDemandaMaximaPotenciaSuministradaAS;
	}

	public Double getCargoDemandaMaximaPotenciaSuministradaSA() {
		return cargoDemandaMaximaPotenciaSuministradaSA;
	}

	public void setCargoDemandaMaximaPotenciaSuministradaSA(Double cargoDemandaMaximaPotenciaSuministradaSA) {
		this.cargoDemandaMaximaPotenciaSuministradaSA = cargoDemandaMaximaPotenciaSuministradaSA;
	}

	public Double getCargoDemandaMaximaPotenciaSuministradaSS() {
		return cargoDemandaMaximaPotenciaSuministradaSS;
	}

	public void setCargoDemandaMaximaPotenciaSuministradaSS(Double cargoDemandaMaximaPotenciaSuministradaSS) {
		this.cargoDemandaMaximaPotenciaSuministradaSS = cargoDemandaMaximaPotenciaSuministradaSS;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	
}
