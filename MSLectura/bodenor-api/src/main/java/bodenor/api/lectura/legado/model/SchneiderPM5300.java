package bodenor.api.lectura.legado.model;

import bodenor.api.lectura.model.LecturaSchneiderPM5300;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApplicationScoped
@Table(name = "schneiderPM5300")
@Entity(name = "schneiderPM5300")
public class SchneiderPM5300 implements Serializable{

	@Id
	private LocalDateTime TIMESTAMP;
	@Id
	private Integer EQUIPO_ID;
	private String ITEM1;
	private String ITEM43;
	private LocalDate FECHA;
	private Integer ANIO;
	private Integer MES;
	private Integer DIA;
	private LocalTime HORA;
	private Integer HH;
	private Integer MM;
	private Integer SS;

	public SchneiderPM5300() {
	}

	public SchneiderPM5300(LocalDateTime TIMESTAMP, Integer EQUIPO_ID, String ITEM1, String ITEM43, LocalDate FECHA, Integer ANIO, Integer MES, Integer DIA, LocalTime HORA, Integer HH, Integer MM, Integer SS) {
		this.TIMESTAMP = TIMESTAMP;
		this.EQUIPO_ID = EQUIPO_ID;
		this.ITEM1 = ITEM1;
		this.ITEM43 = ITEM43;
		this.FECHA = FECHA;
		this.ANIO = ANIO;
		this.MES = MES;
		this.DIA = DIA;
		this.HORA = HORA;
		this.HH = HH;
		this.MM = MM;
		this.SS = SS;
	}

	public LocalDateTime getTIMESTAMP() {
		return TIMESTAMP;
	}

	public void setTIMESTAMP(LocalDateTime TIMESTAMP) {
		this.TIMESTAMP = TIMESTAMP;
	}

	public Integer getEQUIPO_ID() {
		return EQUIPO_ID;
	}

	public void setEQUIPO_ID(Integer EQUIPO_ID) {
		this.EQUIPO_ID = EQUIPO_ID;
	}

	public String getITEM1() {
		return ITEM1;
	}

	public void setITEM1(String ITEM1) {
		this.ITEM1 = ITEM1;
	}

	public String getITEM43() {
		return ITEM43;
	}

	public void setITEM43(String ITEM43) {
		this.ITEM43 = ITEM43;
	}

	public LocalDate getFECHA() {
		return FECHA;
	}

	public void setFECHA(LocalDate FECHA) {
		this.FECHA = FECHA;
	}

	public Integer getANIO() {
		return ANIO;
	}

	public void setANIO(Integer ANIO) {
		this.ANIO = ANIO;
	}

	public Integer getMES() {
		return MES;
	}

	public void setMES(Integer MES) {
		this.MES = MES;
	}

	public Integer getDIA() {
		return DIA;
	}

	public void setDIA(Integer DIA) {
		this.DIA = DIA;
	}

	public LocalTime getHORA() {
		return HORA;
	}

	public void setHORA(LocalTime HORA) {
		this.HORA = HORA;
	}

	public Integer getHH() {
		return HH;
	}

	public void setHH(Integer HH) {
		this.HH = HH;
	}

	public Integer getMM() {
		return MM;
	}

	public void setMM(Integer MM) {
		this.MM = MM;
	}

	public Integer getSS() {
		return SS;
	}

	public void setSS(Integer SS) {
		this.SS = SS;
	}
	
	public SchneiderPM5300 fromLectura(LecturaSchneiderPM5300 lectura){
		SchneiderPM5300 schneider = new SchneiderPM5300();
		
		if(lectura.getTimestamp() == null || lectura.getNumRemarcador() == null){
			return schneider;
		}
		
		schneider.setTIMESTAMP(lectura.getTimestamp());
		schneider.setEQUIPO_ID(lectura.getNumRemarcador());
		
		if(lectura.getItem1() == null || lectura.getItem1().equals(LecturaSchneiderPM5300.LECTURA_VACIA)){
			schneider.setITEM1("5.8774717541114E-39");
		}else{
			schneider.setITEM1(Double.toString(lectura.getItem1()));
		}
		if(lectura.getItem43() == null || lectura.getItem43().equals(LecturaSchneiderPM5300.LECTURA_VACIA)){
			schneider.setITEM43("5.8774717541114E-39");
		}else{
			schneider.setITEM43(Double.toString(lectura.getItem43()));
		}
		
		schneider.setFECHA(lectura.getFecha());
		schneider.setANIO(lectura.getAnio());
		schneider.setMES(lectura.getMes());
		schneider.setDIA(lectura.getDia());
		schneider.setHORA(lectura.getTimestamp().toLocalTime());
		schneider.setHH(schneider.getHORA().getHour());
		schneider.setMM(schneider.getHORA().getMinute());
		schneider.setSS(schneider.getHORA().getSecond());
		
		return schneider;
	}
}
