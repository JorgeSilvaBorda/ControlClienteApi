package bodenor.api.continuidad.model;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Tabla CONTINUIDAD.
 * @author jorge
 */
@ApplicationScoped
@Entity(name = "CONTINUIDAD")
public class Continuidad implements Serializable{
    @Id
    @Column(name = "ORIGEN")
    private String origen;
    @Id
    @Column(name = "TIMESTAMP")
    //private LocalDateTime timestamp;
    private String timestamp;
    @Column(name = "FECHA")
    //private LocalDate fecha;
    private String fecha;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "MES")
    private Integer mes;
    @Column(name = "DIA")
    private Integer dia;
    @Id
    @Column(name = "NUMREMARCADOR")
    private Integer numremarcador;
    @Column(name = "IDREMARCADOR")
    private Integer idremarcador;
    @Column(name = "LECTURAREAL")
    private Double lecturareal;
    @Column(name = "ULTIMOMAXIMO")
    private Double ultimomaximo;
    @Column(name = "LECTURAPROYECTADA")
    private Double lecturaproyectada;
    @Column(name = "DELTA")
    private Double delta;
    @Column(name = "POTENCIA")
    private Double potencia;
    @Column(name = "EXISTE")
    private Integer existe;

    public Continuidad() {
        
    }

    //public Continuidad(String origen, String timestamp, String fecha, Integer anio, Integer mes, Integer dia, Integer numremarcador, Integer idremarcador, Double lecturareal, Double ultimomaximo, Double lecturaproyectada, Double delta, Double potencia, Integer existe) {
    public Continuidad(String origen, String timestamp, String fecha, Integer anio, Integer mes, Integer dia, Integer numremarcador, Integer idremarcador, Double lecturareal, Double ultimomaximo, Double lecturaproyectada, Double delta, Double potencia, Integer existe) {
        //DateTimeFormatter formatterTimestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.origen = origen;
        //this.timestamp = LocalDateTime.parse(timestamp, formatterTimestamp);
        //this.fecha = LocalDate.parse(fecha, formatterDate);
        this.timestamp = timestamp;
        this.fecha = fecha;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.numremarcador = numremarcador;
        this.idremarcador = idremarcador;
        this.lecturareal = lecturareal;
        this.ultimomaximo = ultimomaximo;
        this.lecturaproyectada = lecturaproyectada;
        this.delta = delta;
        this.potencia = potencia;
        this.existe = existe;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        DateTimeFormatter formatterTimestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //this.timestamp = LocalDateTime.parse(timestamp, formatterTimestamp);
        this.timestamp = timestamp;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //this.fecha = LocalDate.parse(fecha, formatterDate);
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

    public Integer getNumremarcador() {
        return numremarcador;
    }

    public void setNumremarcador(Integer numremarcador) {
        this.numremarcador = numremarcador;
    }

    public Integer getIdremarcador() {
        return idremarcador;
    }

    public void setIdremarcador(Integer idremarcador) {
        this.idremarcador = idremarcador;
    }

    public Double getLecturareal() {
        return lecturareal;
    }

    public void setLecturareal(Double lecturareal) {
        this.lecturareal = lecturareal;
    }

    public Double getUltimomaximo() {
        return ultimomaximo;
    }

    public void setUltimomaximo(Double ultimomaximo) {
        this.ultimomaximo = ultimomaximo;
    }

    public Double getLecturaproyectada() {
        return lecturaproyectada;
    }

    public void setLecturaproyectada(Double lecturaproyectada) {
        this.lecturaproyectada = lecturaproyectada;
    }

    public Double getDelta() {
        return delta;
    }

    public void setDelta(Double delta) {
        this.delta = delta;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public Integer getExiste() {
        return existe;
    }

    public void setExiste(Integer existe) {
        this.existe = existe;
    }
    
    public String toCsv(){
        DateTimeFormatter formatterTimestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //return this.getOrigen() + ";" + formatterTimestamp.format(this.getTimestamp()) + ";" + this.getNumremarcador() + ";" + this.getLecturareal() + ";" + this.getUltimomaximo() + ";" + this.getLecturaproyectada() + ";" + this.getDelta() + ";" + this.getPotencia() + ";" + this.getExiste();
        return this.getOrigen() + ";" + this.getTimestamp() + ";" + this.getNumremarcador() + ";" + this.getLecturareal() + ";" + this.getUltimomaximo() + ";" + this.getLecturaproyectada() + ";" + this.getDelta() + ";" + this.getPotencia() + ";" + this.getExiste();
    }

}