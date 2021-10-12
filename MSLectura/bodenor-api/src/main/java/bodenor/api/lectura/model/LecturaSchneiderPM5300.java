package bodenor.api.lectura.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LecturaSchneiderPM5300 implements Serializable {

    private LocalDateTime timestamp;
    private LocalDate fecha;
    private Integer anio, mes, dia;

    private Integer idConversor;
    private String ipConversor;
    private Integer idRemarcador;
    private Integer numRemarcador;
    private Double item1;
    private Double item43;

    public static final Double LECTURA_VACIA = 5.8774717541114E-39;

    public LecturaSchneiderPM5300() {
    }

    public LecturaSchneiderPM5300(LocalDateTime timestamp, LocalDate fecha, Integer anio, Integer mes, Integer dia, Integer idConversor, String ipConversor, Integer idRemarcador, Integer numRemarcador, Double item1, Double item43) {
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
        this.item43 = item43;
    }

    public LecturaSchneiderPM5300(Lectura lectura) {

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

    public Double getItem43() {
        return item43;
    }

    public void setItem43(Double item43) {
        this.item43 = item43;
    }

    public boolean esCalculable() {
        return getItem1() != null && getItem43() != null;
    }

    public Double getEnergia() {
        return this.item1;
    }

    public Double getPotencia() {
        return this.item43;
    }

    public String toCsv() {

        DateTimeFormatter formatterTimestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.getNumRemarcador() + ";" + formatterTimestamp.format(this.getTimestamp()) + ";" + this.getItem1() + ";" + this.getItem43();
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
                "schneiderpm5300",
				false
        );

        return lecturaRemarcador;
    }

    public static LecturaSchneiderPM5300 parseItems(String contenido, Lectura lectura) {
        String regexp = "";
        Pattern pattern;
        Matcher matcher;
        LecturaSchneiderPM5300 lecturaSchneiderPM5300 = new LecturaSchneiderPM5300(lectura);
        //Patrón regexp sacar campos del mensaje
        regexp = "(\\[)([0-9]{1,4})(\\])(\\:)(\\s+)(0x)(([A-Z]|[0-9]){4})";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(contenido);

        String item1pt1 = "";
        String item1pt2 = "";
        String item43pt1 = "";
        String item43pt2 = "";

        System.out.println("Mensaje");
        System.out.println(contenido);

        //Recorrer la cantidad de coincidencias del patrón
        while (matcher.find()) {//Campos específicos de modelo circutorcvmC10
            System.out.println("Matcher.group: " + matcher.group());
            if (matcher.group(2).trim().equals("2700")) {
                item1pt1 += matcher.group(7);
                System.out.println("Encuentra Item1 pt1: " + matcher.group(7));
            }
            if (matcher.group(2).trim().equals("2701")) {
                item1pt2 += matcher.group(7);
                System.out.println("Encuentra Item1 pt2: " + matcher.group(7));
            }
            if (matcher.group(2).trim().equals("3060")) {
                item43pt1 += matcher.group(7);
                System.out.println("Encuentra Item43 pt1: " + matcher.group(7));
            }
            if (matcher.group(2).trim().equals("3061")) {
                item43pt1 += matcher.group(7);
                System.out.println("Encuentra Item43 pt2: " + matcher.group(7));
            }
        }
        String item1 = (item1pt1 + item1pt2);
        String item43 = (item43pt1 + item43pt2);
        
        if (item1.length() == 8) {
            Long i = Long.parseLong(item1, 16);
            Float f = Float.intBitsToFloat(i.intValue());
            lecturaSchneiderPM5300.setItem1(Double.parseDouble(f.toString()));
        }

        if (item43.length() == 8) {
            Long i = Long.parseLong(item43, 16);
            Float f = Float.intBitsToFloat(i.intValue());
            lecturaSchneiderPM5300.setItem43(Double.parseDouble(f.toString()));
        }
        
        
        

        return lecturaSchneiderPM5300;
    }

    @Deprecated
    public static LecturaSchneiderPM5300 parseItemsMigracion(String contenido, Lectura lectura) {
        String regexp = "";
        Pattern pattern;
        Matcher matcher;
        LecturaSchneiderPM5300 lecturaSchneiderPM5300 = new LecturaSchneiderPM5300(lectura);
        //Patrón regexp sacar campos del mensaje
        regexp = "(\\[)([0-9]{1,3})(\\])(\\:)(\\s+)(-?)([0-9]{1,9})(\\.)?([0-9]{1,14})?";
        pattern = Pattern.compile(regexp);
        matcher = pattern.matcher(contenido);

        //Recorrer la cantidad de coincidencias del patrón
        while (matcher.find()) {//Campos específicos de modelo circutorcvmC10
            if (matcher.group(2).trim().equals("1")) {
                String valorItem1 = "";
                if(matcher.group().contains(".")){
                    valorItem1 = matcher.group(6) + matcher.group(7) + matcher.group(8) + matcher.group(9);
                    System.out.println("Encuentra item1: " + Double.parseDouble(matcher.group(6) + matcher.group(7) + matcher.group(8)+ matcher.group(9)));
                }else{
                    valorItem1 = matcher.group(6) + matcher.group(7);
                    System.out.println("Encuentra item1: " + Double.parseDouble(matcher.group(6) + matcher.group(7)));

                }
                lecturaSchneiderPM5300.setItem1(Double.parseDouble(valorItem1));
                
            }
            if (matcher.group(2).trim().equals("43")) {
                String valorItem43 = "";
                if(matcher.group().contains(".")){
                    valorItem43 = matcher.group(6) + matcher.group(7) + matcher.group(8) + matcher.group(9);
                    System.out.println("Encuentra item43: " + Double.parseDouble(matcher.group(6) + matcher.group(7) + matcher.group(8) + matcher.group(9)));
                }else{
                    valorItem43 = matcher.group(6) + matcher.group(7);
                    System.out.println("Encuentra item43: " + Double.parseDouble(matcher.group(6) + matcher.group(7)));

                }
                lecturaSchneiderPM5300.setItem43(Double.parseDouble(valorItem43));
                
            }
        }

        return lecturaSchneiderPM5300;
    }

}
