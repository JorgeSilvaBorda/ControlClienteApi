package bodenor.api.lectura.lecturamanual.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApplicationScoped
@Entity(name = "LECTURAMANUAL")
public class LecturaManual implements Serializable{
    
    @Id
    @Column(name = "NUMREMARCADOR")
    private Integer numremarcador;
    @Id
    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;
    @Column(name = "FECHA")
    private LocalDate fecha;
    @Column(name = "ANIO")
    private Integer anio;
    @Column(name = "MES")
    private Integer mes;
    @Column(name = "DIA")
    private Integer dia;
    @Column(name = "HORA")
    private LocalTime hora;
    @Column(name = "LECTURA")
    private Double lectura;

    public LecturaManual() {
    }

    public LecturaManual(Integer numremarcador, LocalDateTime timestamp, LocalDate fecha, Integer anio, Integer mes, Integer dia, LocalTime hora, Double lectura) {
        this.numremarcador = numremarcador;
        this.timestamp = timestamp;
        this.fecha = fecha;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.lectura = lectura;
    }

    public Integer getNumremarcador() {
        return numremarcador;
    }

    public void setNumremarcador(Integer numremarcador) {
        this.numremarcador = numremarcador;
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

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Double getLectura() {
        return lectura;
    }

    public void setLectura(Double lectura) {
        this.lectura = lectura;
    }
    
    
}
