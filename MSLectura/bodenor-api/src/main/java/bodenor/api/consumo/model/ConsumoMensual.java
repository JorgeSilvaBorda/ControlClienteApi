package bodenor.api.consumo.model;

import java.io.Serializable;
import java.util.Objects;
import org.bson.types.ObjectId;

public class ConsumoMensual implements Serializable{
    
    private ObjectId _id;
    private Lectura primeraLectura, ultimaLectura;
    
    private Integer anio, mes;

    private Double energiaConsumidaTotal, demandaMaxima, demandaMaximaHoraPunta, promedioDemanda, promedioDemandaHoraPunta;
    private Integer idRemarcador, numRemarcador;
    private String modulos, numSerie, modelo, marca;

    private Cliente clienteActual;
    private Empalme empalme;

	public ConsumoMensual() {
	}

	public ConsumoMensual(ObjectId _id, Lectura primeraLectura, Lectura ultimaLectura, Integer anio, Integer mes, Double energiaConsumidaTotal, Double demandaMaxima, Double demandaMaximaHoraPunta, Double promedioDemanda, Double promedioDemandaHoraPunta, Integer idRemarcador, Integer numRemarcador, String modulos, String numSerie, String modelo, String marca, Cliente clienteActual, Empalme empalme) {
		this._id = _id;
		this.primeraLectura = primeraLectura;
		this.ultimaLectura = ultimaLectura;
		this.anio = anio;
		this.mes = mes;
		this.energiaConsumidaTotal = energiaConsumidaTotal;
		this.demandaMaxima = demandaMaxima;
		this.demandaMaximaHoraPunta = demandaMaximaHoraPunta;
		this.promedioDemanda = promedioDemanda;
		this.promedioDemandaHoraPunta = promedioDemandaHoraPunta;
		this.idRemarcador = idRemarcador;
		this.numRemarcador = numRemarcador;
		this.modulos = modulos;
		this.numSerie = numSerie;
		this.modelo = modelo;
		this.marca = marca;
		this.clienteActual = clienteActual;
		this.empalme = empalme;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
	}

	public Lectura getPrimeraLectura() {
		return primeraLectura;
	}

	public void setPrimeraLectura(Lectura primeraLectura) {
		this.primeraLectura = primeraLectura;
	}

	public Lectura getUltimaLectura() {
		return ultimaLectura;
	}

	public void setUltimaLectura(Lectura ultimaLectura) {
		this.ultimaLectura = ultimaLectura;
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

	public Double getEnergiaConsumidaTotal() {
		return energiaConsumidaTotal;
	}

	public void setEnergiaConsumidaTotal(Double energiaConsumidaTotal) {
		this.energiaConsumidaTotal = energiaConsumidaTotal;
	}

	public Double getDemandaMaxima() {
		return demandaMaxima;
	}

	public void setDemandaMaxima(Double demandaMaxima) {
		this.demandaMaxima = demandaMaxima;
	}

	public Double getDemandaMaximaHoraPunta() {
		return demandaMaximaHoraPunta;
	}

	public void setDemandaMaximaHoraPunta(Double demandaMaximaHoraPunta) {
		this.demandaMaximaHoraPunta = demandaMaximaHoraPunta;
	}

	public Double getPromedioDemanda() {
		return promedioDemanda;
	}

	public void setPromedioDemanda(Double promedioDemanda) {
		this.promedioDemanda = promedioDemanda;
	}

	public Double getPromedioDemandaHoraPunta() {
		return promedioDemandaHoraPunta;
	}

	public void setPromedioDemandaHoraPunta(Double promedioDemandaHoraPunta) {
		this.promedioDemandaHoraPunta = promedioDemandaHoraPunta;
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

	public String getModulos() {
		return modulos;
	}

	public void setModulos(String modulos) {
		this.modulos = modulos;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Cliente getClienteActual() {
		return clienteActual;
	}

	public void setClienteActual(Cliente clienteActual) {
		this.clienteActual = clienteActual;
	}

	public Empalme getEmpalme() {
		return empalme;
	}

	public void setEmpalme(Empalme empalme) {
		this.empalme = empalme;
	}

    
	
	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ConsumoMensual)) {
            return false;
        }

        ConsumoMensual other = (ConsumoMensual) obj;

        return Objects.equals(other._id, this._id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this._id);
    }
}
