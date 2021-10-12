package bodenor.api.lectura.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Lectura implements Serializable {

	private LocalDateTime timestamp;
	private LocalDate fecha;
	private Integer anio, mes, dia;

	private Integer idconversor;
	private String ipconversor;
	private Integer idremarcador;
	private Integer numremarcador;

	public Lectura() {

	}

	public Lectura(LocalDateTime timestamp, LocalDate fecha, Integer idconversor, String ipconversor, Integer idremarcador, Integer numremarcador, Integer anio, Integer mes, Integer dia) {
		this.timestamp = timestamp;
		this.fecha = fecha;
		this.anio = anio;
		this.mes = mes;
		this.dia = dia;
		this.idconversor = idconversor;
		this.ipconversor = ipconversor;
		this.idremarcador = idremarcador;
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

	public Integer getIdconversor() {
		return idconversor;
	}

	public void setIdconversor(Integer idconversor) {
		this.idconversor = idconversor;
	}

	public String getIpconversor() {
		return ipconversor;
	}

	public void setIpconversor(String ipconversor) {
		this.ipconversor = ipconversor;
	}

	public Integer getIdremarcador() {
		return idremarcador;
	}

	public void setIdremarcador(Integer idremarcador) {
		this.idremarcador = idremarcador;
	}

	public Integer getNumremarcador() {
		return numremarcador;
	}

	public void setNumremarcador(Integer numremarcador) {
		this.numremarcador = numremarcador;
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

	public boolean esProcesable() {
		return getTimestamp() != null && getNumremarcador() != null;
	}

	public static Lectura getLectura(String mensaje) {
		Lectura lectura = new Lectura();

		if (mensaje.contains("MANUAL[true]")) {
			lectura.setTimestamp(parseTimestamp(mensaje));
			lectura.setFecha(parseFecha(lectura.getTimestamp()));
			lectura.setAnio(lectura.getFecha().getYear());
			lectura.setMes(lectura.getFecha().getMonthValue());
			lectura.setDia(lectura.getFecha().getDayOfMonth());
			lectura.setNumremarcador(parseNumRemarcadorManualMigracion(mensaje));
			System.out.println("Se retornará una lectura manual");
			return lectura;
		}

		if (parseTimestamp(mensaje) == null) {
			return new Lectura();
		}
		lectura.setTimestamp(parseTimestamp(mensaje));
		lectura.setFecha(parseFecha(lectura.getTimestamp()));
		lectura.setAnio(lectura.getFecha().getYear());
		lectura.setMes(lectura.getFecha().getMonthValue());
		lectura.setDia(lectura.getFecha().getDayOfMonth());
		lectura.setIpconversor(parseIp(mensaje));
		lectura.setNumremarcador(parseNumremarcador(mensaje));
		lectura.setIdconversor(parseIdConversor(mensaje));
		lectura.setIdremarcador(parseIdRemarcador(mensaje));

		return lectura;
	}
	
	public static Integer parseNumRemarcadorManualMigracion(String contenido) {

		String regexp = "";
		Pattern pattern;
		Matcher matcher;

		//Patrón regexp sacar timestamp del mensaje
		regexp = "(NUMREMARCADOR\\[)([0-9]{1,4})(\\])";
		pattern = Pattern.compile(regexp);
		matcher = pattern.matcher(contenido);
		if (matcher.find()) {
			return Integer.parseInt(matcher.group(2));
		}

		return null;
	}

	public static LocalDateTime parseTimestamp(String contenido) {

		String regexp = "";
		Pattern pattern;
		Matcher matcher;

		//Patrón regexp sacar timestamp del mensaje
		regexp = "(TIMESTAMP\\[)([0-9]{4}-[0-9]{1,2}-[0-9]{1,2}\\s+[0-9]{1,2}\\:[0-9]{1,2}\\:[0-9]{1,2})(\\])";
		pattern = Pattern.compile(regexp);
		matcher = pattern.matcher(contenido);
		if (matcher.find()) {
			//return matcher.group(2);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime timestamp = LocalDateTime.parse(matcher.group(2), formatter);
			return timestamp;
		}

		return null;
	}

	public static LocalDate parseFecha(LocalDateTime timestamp) {
		return timestamp.toLocalDate();
	}

	public static String parseIp(String contenido) {

		String regexp = "";
		Pattern pattern;
		Matcher matcher;

		//Patrón regexp sacar IP Conversor del mensaje
		regexp = "(IP\\[)([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})(\\])";
		pattern = Pattern.compile(regexp);
		matcher = pattern.matcher(contenido);
		if (matcher.find()) {
			//System.out.println("IP: " + matcher.group(2));
			return matcher.group(2);
		}

		return null;
	}

	public static Integer parseIdConversor(String contenido) {
		String regexp = "";
		Pattern pattern;
		Matcher matcher;

		//Patrón regexp sacar Id del conversor del mensaje
		regexp = "(EQUIPO\\[)([0-9]{1,8})(\\]IDREM\\[)([0-9]{1,8})(\\])";
		pattern = Pattern.compile(regexp);
		matcher = pattern.matcher(contenido);
		if (matcher.find()) {
			return Integer.parseInt(matcher.group(2));
		}

		return null;
	}

	public static Integer parseIdRemarcador(String contenido) {
		String regexp = "";
		Pattern pattern;
		Matcher matcher;

		//Patrón regexp sacar Id Remarcador en el conversor del mensaje
		regexp = "(EQUIPO\\[)([0-9]{1,8})(\\]IDREM\\[)([0-9]{1,8})(\\])";
		pattern = Pattern.compile(regexp);
		matcher = pattern.matcher(contenido);
		if (matcher.find()) {
			return Integer.parseInt(matcher.group(4));
		}

		return null;
	}

	public static Integer parseNumremarcador(String contenido) {

		String regexp = "";
		Pattern pattern;
		Matcher matcher;

		//Patrón regexp sacar Id Remarcador en el conversor del mensaje
		regexp = "(EQUIPO\\[)([0-9]{1,8})(\\]IDREM\\[)([0-9]{1,8})(\\])";
		pattern = Pattern.compile(regexp);
		matcher = pattern.matcher(contenido);
		boolean idEncontrado = false;
		if (matcher.find()) {
			//System.out.println("NUMREMARCADOR: " + matcher.group(2) + matcher.group(4));
			System.out.println("NumRemarcador: " + Integer.parseInt(matcher.group(2) + matcher.group(4)));
			return Integer.parseInt(matcher.group(2) + matcher.group(4));
		}
		if (!idEncontrado) {
			//Patrón regexp sacar Id Remarcador en el conversor del mensaje
			regexp = "(EQUIPO\\[)([0-9]{1,8})(\\])";
			pattern = Pattern.compile(regexp);
			matcher = pattern.matcher(contenido);
			if (matcher.find()) {
				//System.out.println("NUMREMARCADOR: " + matcher.group(2) + matcher.group(4));
				return Integer.parseInt(matcher.group(2));
			}
		}

		return null;
	}

}
