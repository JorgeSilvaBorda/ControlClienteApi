package bodenor.api.consumo.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;
import org.bson.types.ObjectId;

public class ConsumoDiario {

    private ObjectId _id;
    private Lectura lastLectura, lastLecturaValida;
    private LocalDate fecha;
    private Integer anio, mes, dia;
    private LinkedList<Lectura> lecturas = new LinkedList();

    private Double energiaConsumidaTotal, demandaMaxima, demandaMaximaHoraPunta, promedioDemanda, promedioDemandaHoraPunta;
    private Integer idRemarcador, numRemarcador;
    private String modulos, numSerie, modelo, marca;
    private Integer estado;

    private Cliente clienteActual;
    private Empalme empalme;

    public ConsumoDiario() {
    }

    public ConsumoDiario(ObjectId id, Lectura lastLectura, Lectura lastLecturaValida, LocalDate fecha, Integer anio, Integer mes, Integer dia, Double energiaConsumidaTotal, Double demandaMaxima, Double demandaMaximaHoraPunta, Double promedioDemanda, Double promedioDemandaHoraPunta, Integer idRemarcador, Integer numRemarcador, String modulos, String numSerie, String modelo, String marca, Integer estado, Cliente clienteActual, Empalme empalme) {
        this._id = id;
        this.lastLectura = lastLectura;
        this.lastLecturaValida = lastLecturaValida;
        this.fecha = fecha;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
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
        this.estado = estado;
        this.clienteActual = clienteActual;
        this.empalme = empalme;
    }
    
    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public Lectura getLastLectura() {
        return lastLectura;
    }

    public void setLastLectura(Lectura lastLectura) {
        this.lastLectura = lastLectura;
    }

    public Lectura getLastLecturaValida() {
        return lastLecturaValida;
    }

    public void setLastLecturaValida(Lectura lastLecturaValida) {
        this.lastLecturaValida = lastLecturaValida;
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

    public LinkedList<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(LinkedList<Lectura> lecturas) {
        this.lecturas = lecturas;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
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
        if (!(obj instanceof ConsumoDiario)) {
            return false;
        }

        ConsumoDiario other = (ConsumoDiario) obj;

        return Objects.equals(other._id, this._id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this._id);
    }
    
    public void addLectura(Lectura l){
        this.lecturas.add(l);
    }

}
