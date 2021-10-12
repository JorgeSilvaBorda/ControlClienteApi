/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.lectura.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author jorge
 */
@ApplicationScoped
public class LecturaSchneiderPM710 implements Serializable {

    private LocalDateTime timestamp;
    private LocalDate fecha;
    private Integer anio, mes, dia;

    private Integer idConversor;
    private String ipConversor;
    private Integer idRemarcador;
    private Integer numRemarcador;

    private Double item1;
    private Double item2;
    private Double item7;
    private Double item108;
    private Double item109;

    private static final Integer BASE_POTENCIA = 10;

    public LecturaSchneiderPM710() {
    }

    public LecturaSchneiderPM710(LocalDateTime timestamp, LocalDate fecha, Integer anio, Integer mes, Integer dia, Integer idConversor, String ipConversor, Integer idRemarcador, Integer numRemarcador, Double item1, Double item2, Double item7, Double item108, Double item109) {
        this.timestamp = timestamp;
        this.fecha = fecha;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.idConversor = idConversor;
        this.ipConversor = ipConversor;
        this.idRemarcador = idRemarcador;
        this.numRemarcador = numRemarcador;
        this.item1 = item1;
        this.item2 = item2;
        this.item7 = item7;
        this.item108 = item108;
        this.item109 = item109;
    }

    public LecturaSchneiderPM710(Lectura lectura) {

        this.timestamp = lectura.getTimestamp();
        this.fecha = lectura.getFecha();
        this.anio = lectura.getAnio();
        this.mes = lectura.getMes();
        this.dia = lectura.getDia();
        this.idConversor = lectura.getIdconversor();
        this.ipConversor = lectura.getIpconversor();
        this.idRemarcador = lectura.getIdremarcador();
        this.numRemarcador = lectura.getNumremarcador();
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

    public Double getItem1() {
        return item1;
    }

    public void setItem1(Double item1) {
        this.item1 = item1;
    }

    public Double getItem2() {
        return item2;
    }

    public void setItem2(Double item2) {
        this.item2 = item2;
    }

    public Double getItem7() {
        return item7;
    }

    public void setItem7(Double item7) {
        this.item7 = item7;
    }

    public Double getItem108() {
        return item108;
    }

    public void setItem108(Double item108) {
        this.item108 = item108;
    }

    public Double getItem109() {
        return item109;
    }

    public void setItem109(Double item109) {
        this.item109 = item109;
    }

    public boolean esCalculable() {
        return getItem1() != null && getItem2() != null && getItem109() != null;
    }

    public Double getEnergia() {
        if (this.item2 >= 0) {
            Double salida = ((this.item1 * 65536) + this.item2) * Math.pow(BASE_POTENCIA, this.item109);
            return salida;
        }
        if (this.item2 < 0) {
            Double salida = (((this.item1 * 65536) + (this.item2 + 65536)) * Math.pow(BASE_POTENCIA, this.item109));
            return salida;
        }
        return null;
    }

    public Double getPotencia() {
        Double salida = this.item7 * Math.pow(BASE_POTENCIA, this.item108);
        return salida;
    }

    public String toCsv() {

        DateTimeFormatter formatterTimestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return this.getNumRemarcador() + ";" + formatterTimestamp.format(this.getTimestamp()) + ";" + this.getItem1() + ";" + this.getItem2() + ";" + this.getItem7() + ";" + this.getItem108() + ";" + this.getItem109();
    }

    public LecturaRemarcador toLecturaRemarcador() {
        LecturaRemarcador lecturaRemarcador = new LecturaRemarcador(
                timestamp,
                fecha,
                anio,
                mes,
                dia,
                idConversor,
                ipConversor,
                idRemarcador,
                numRemarcador,
                getEnergia(),
                getPotencia(),
                esCalculable(),
                "schneiderpm710",
				false
        );

        return lecturaRemarcador;
    }

    public static LecturaSchneiderPM710 parseItems(String contenido, Lectura lectura) {
        String regexp = "";
        Pattern pattern;
        Matcher matcher;
        LecturaSchneiderPM710 lecturaSchneiderPM710 = new LecturaSchneiderPM710(lectura);
        //Patrón regexp sacar campos del mensaje
        regexp = "(\\[)([0-9]{1,4})(\\])(\\:)(\\s+)(-?)([0-9]{1,9})";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(contenido);

        //Recorrer la cantidad de coincidencias del patrón
        while (matcher.find()) {//Campos específicos de modelo circutorcvmC10
            if (matcher.group(2).trim().equals("4000")) {
                lecturaSchneiderPM710.setItem1(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
            if (matcher.group(2).trim().equals("4001")) {
                lecturaSchneiderPM710.setItem2(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
            if (matcher.group(2).trim().equals("4006")) {
                lecturaSchneiderPM710.setItem7(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
            if (matcher.group(2).trim().equals("4107")) {
                lecturaSchneiderPM710.setItem108(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
            if (matcher.group(2).trim().equals("4108")) {
                lecturaSchneiderPM710.setItem109(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
        }

        return lecturaSchneiderPM710;
    }

}
