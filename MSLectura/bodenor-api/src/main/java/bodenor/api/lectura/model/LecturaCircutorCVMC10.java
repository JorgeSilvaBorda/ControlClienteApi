package bodenor.api.lectura.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LecturaCircutorCVMC10 implements Serializable {

    private LocalDateTime timestamp;
    private LocalDate fecha;
    private Integer anio, mes, dia;

    private Integer idConversor;
    private String ipConversor;
    private Integer idRemarcador;
    private Integer numRemarcador;

    private Double item49;
    private Double item50;
    private Double item95;
    private Double item96;

    public LecturaCircutorCVMC10() {
    }

    public LecturaCircutorCVMC10(LocalDateTime timestamp, LocalDate fecha, Integer anio, Integer mes, Integer dia, Integer idconversor, String ipconversor, Integer idremarcador, Integer numremarcador, Double item49, Double item50, Double item95, Double item96) {
        this.timestamp = timestamp;
        this.fecha = fecha;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.idConversor = idconversor;
        this.ipConversor = ipconversor;
        this.idRemarcador = idremarcador;
        this.numRemarcador = numremarcador;
        this.item49 = item49;
        this.item50 = item50;
        this.item95 = item95;
        this.item96 = item96;
    }
    
    public LecturaCircutorCVMC10(Lectura lectura) {
        
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

    public Integer getIdconversor() {
        return idConversor;
    }

    public void setIdconversor(Integer idconversor) {
        this.idConversor = idconversor;
    }

    public String getIpconversor() {
        return ipConversor;
    }

    public void setIpconversor(String ipconversor) {
        this.ipConversor = ipconversor;
    }

    public Integer getIdremarcador() {
        return idRemarcador;
    }

    public void setIdremarcador(Integer idremarcador) {
        this.idRemarcador = idremarcador;
    }

    public Integer getNumremarcador() {
        return numRemarcador;
    }

    public void setNumremarcador(Integer numremarcador) {
        this.numRemarcador = numremarcador;
    }

    public Double getItem49() {
        return item49;
    }

    public void setItem49(Double item49) {
        this.item49 = item49;
    }

    public Double getItem50() {
        return item50;
    }

    public void setItem50(Double item50) {
        this.item50 = item50;
    }

    public Double getItem95() {
        return item95;
    }

    public void setItem95(Double item95) {
        this.item95 = item95;
    }

    public Double getItem96() {
        return item96;
    }

    public void setItem96(Double item96) {
        this.item96 = item96;
    }
    
    public boolean esCalculable(){
        return getItem95() != null && getItem96() != null && getItem49() != null && getItem50() != null;
    }
    
    public Double getEnergia() {
        if (this.item96 >= 0) {
            return (this.item95 * 65536) + this.item96;
        } else {
            return (this.item95 * 65536) + (this.item96 + 65536);
        }
    }

    public Double getPotencia() {
        if (this.item50 >= 0) {
            return (((Double) this.item49 * 65536) + (Double) this.item50) / 1000;
        } else {
            return (((Double) this.item49 * 65536) + ((Double) this.item50 + 65536)) / 1000;
        }
    }
    
    public String toCsv(){
        DateTimeFormatter formatterTimestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return this.getNumremarcador() + ";" + formatterTimestamp.format(this.getTimestamp()) + ";" + this.getItem49() + ";" + this.getItem50() + ";" + this.getItem95() + ";" + this.getItem96();
    }
    
    public static LecturaCircutorCVMC10 parseItems(String contenido, Lectura lectura) {
        String regexp = "";
        Pattern pattern;
        Matcher matcher;
        LecturaCircutorCVMC10 lecturaCircutor = new LecturaCircutorCVMC10(lectura);
        //Patrón regexp sacar campos del mensaje
        regexp = "(\\[)([0-9]{1,3})(\\])(\\:)(\\s+)(-?)([0-9]{1,9})";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(contenido);

        //Recorrer la cantidad de coincidencias del patrón
        while (matcher.find()) {//Campos específicos de modelo circutorcvmC10
            if (matcher.group(2).trim().equals("49")) {
                lecturaCircutor.setItem49(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
            if (matcher.group(2).trim().equals("50")) {
                lecturaCircutor.setItem50(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
            if (matcher.group(2).trim().equals("95")) {
                lecturaCircutor.setItem95(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
            if (matcher.group(2).trim().equals("96")) {
                lecturaCircutor.setItem96(Double.parseDouble(matcher.group(6) + matcher.group(7)));
            }
        }

        return lecturaCircutor;
    }
    
    public LecturaRemarcador toLecturaRemarcador(){
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
                "circutorcvmc10",
				false
        );
        
        return lecturaRemarcador;
    }
}
