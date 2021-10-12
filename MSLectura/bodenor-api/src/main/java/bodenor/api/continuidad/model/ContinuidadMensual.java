package bodenor.api.continuidad.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApplicationScoped
@Entity(name = "CONTINUIDADMENSUAL")
public class ContinuidadMensual implements Serializable{
    
    @Id
    @Column(name = "ANIO")
    private Integer anio;
    @Id
    @Column(name = "MES")
    private Integer mes;
    @Id
    @Column(name = "NUMREMARCADOR")
    private Integer numremarcador;
    
    @Column(name = "LECTURAREALINI")
    private Double lecturarealini;
    @Column(name = "LECTURAREALFIN")
    private Double lecturarealfin;
    @Column(name = "LECTURAPROYECTADAINI")
    private Double lecturaproyectadaini;
    @Column(name = "LECTURAPROYECTADAFIN")
    private Double lecturaproyectadafin;
    
    @Column(name = "TIMELECTURAINI")
    private String timelecturaini;
    @Column(name = "TIMELECTURAFIN")
    private String timelecturafin;
    
    @Column(name = "MAXPOTENCIA")
    private Double maxpotencia;
    @Column(name = "MAXPOTENCIAHPUNTA")
    private Double maxpotenciahpunta;
    @Column(name = "PROMPOTENCIA")
    private Double prompotencia;
    @Column(name = "PROMPOTENCIAHPUNTA")
    private Double prompotenciahpunta;

    public ContinuidadMensual() {
    }

    public ContinuidadMensual(Integer anio, Integer mes, Integer numremarcador, Double lecturarealini, Double lecturarealfin, Double lecturaproyectadaini, Double lecturaproyectadafin, String timelecturaini, String timelecturafin, Double maxpotencia, Double maxpotenciahpunta, Double prompotencia, Double prompotenciahpunta) {
        this.anio = anio;
        this.mes = mes;
        this.numremarcador = numremarcador;
        this.lecturarealini = lecturarealini;
        this.lecturarealfin = lecturarealfin;
        this.lecturaproyectadaini = lecturaproyectadaini;
        this.lecturaproyectadafin = lecturaproyectadafin;
        this.timelecturaini = timelecturaini;
        this.timelecturafin = timelecturafin;
        this.maxpotencia = maxpotencia;
        this.maxpotenciahpunta = maxpotenciahpunta;
        this.prompotencia = prompotencia;
        this.prompotenciahpunta = prompotenciahpunta;
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

    public Integer getNumremarcador() {
        return numremarcador;
    }

    public void setNumremarcador(Integer numremarcador) {
        this.numremarcador = numremarcador;
    }

    public Double getLecturarealini() {
        return lecturarealini;
    }

    public void setLecturarealini(Double lecturarealini) {
        this.lecturarealini = lecturarealini;
    }

    public Double getLecturarealfin() {
        return lecturarealfin;
    }

    public void setLecturarealfin(Double lecturarealfin) {
        this.lecturarealfin = lecturarealfin;
    }

    public Double getLecturaproyectadaini() {
        return lecturaproyectadaini;
    }

    public void setLecturaproyectadaini(Double lecturaproyectadaini) {
        this.lecturaproyectadaini = lecturaproyectadaini;
    }

    public Double getLecturaproyectadafin() {
        return lecturaproyectadafin;
    }

    public void setLecturaproyectadafin(Double lecturaproyectadafin) {
        this.lecturaproyectadafin = lecturaproyectadafin;
    }

    public String getTimelecturaini() {
        return timelecturaini;
    }

    public void setTimelecturaini(String timelecturaini) {
        this.timelecturaini = timelecturaini;
    }

    public String getTimelecturafin() {
        return timelecturafin;
    }

    public void setTimelecturafin(String timelecturafin) {
        this.timelecturafin = timelecturafin;
    }

    public Double getMaxpotencia() {
        return maxpotencia;
    }

    public void setMaxpotencia(Double maxpotencia) {
        this.maxpotencia = maxpotencia;
    }

    public Double getMaxpotenciahpunta() {
        return maxpotenciahpunta;
    }

    public void setMaxpotenciahpunta(Double maxpotenciahpunta) {
        this.maxpotenciahpunta = maxpotenciahpunta;
    }

    public Double getPrompotencia() {
        return prompotencia;
    }

    public void setPrompotencia(Double prompotencia) {
        this.prompotencia = prompotencia;
    }

    public Double getPrompotenciahpunta() {
        return prompotenciahpunta;
    }

    public void setPrompotenciahpunta(Double prompotenciahpunta) {
        this.prompotenciahpunta = prompotenciahpunta;
    }

    
}
