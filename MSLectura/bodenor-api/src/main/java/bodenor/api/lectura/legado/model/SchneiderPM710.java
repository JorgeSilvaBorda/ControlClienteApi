package bodenor.api.lectura.legado.model;

import bodenor.api.lectura.model.LecturaSchneiderPM710;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApplicationScoped
@Table(name = "schneiderPM710")
@Entity(name = "schneiderPM710")
public class SchneiderPM710 implements Serializable{
	@Id
	private LocalDateTime TIMESTAMP;
	@Id
	private Integer EQUIPO_ID;
	private String ITEM1;
	private String ITEM2;
	private String ITEM7;
	private String ITEM108;
	private String ITEM109;
	private LocalDate FECHA;
	private Integer ANIO;
	private Integer MES;
	private Integer DIA;
	private LocalTime HORA;
	private Integer HH;
	private Integer MM;
	private Integer SS;

	public SchneiderPM710() {
	}

	public SchneiderPM710(LocalDateTime TIMESTAMP, Integer EQUIPO_ID, String ITEM1, String ITEM2, String ITEM7, String ITEM108, String ITEM109, LocalDate FECHA, Integer ANIO, Integer MES, Integer DIA, LocalTime HORA, Integer HH, Integer MM, Integer SS) {
		this.TIMESTAMP = TIMESTAMP;
		this.EQUIPO_ID = EQUIPO_ID;
		this.ITEM1 = ITEM1;
		this.ITEM2 = ITEM2;
		this.ITEM7 = ITEM7;
		this.ITEM108 = ITEM108;
		this.ITEM109 = ITEM109;
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

	public String getITEM2() {
		return ITEM2;
	}

	public void setITEM2(String ITEM2) {
		this.ITEM2 = ITEM2;
	}

	public String getITEM7() {
		return ITEM7;
	}

	public void setITEM7(String ITEM7) {
		this.ITEM7 = ITEM7;
	}

	public String getITEM108() {
		return ITEM108;
	}

	public void setITEM108(String ITEM108) {
		this.ITEM108 = ITEM108;
	}

	public String getITEM109() {
		return ITEM109;
	}

	public void setITEM109(String ITEM109) {
		this.ITEM109 = ITEM109;
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

	public SchneiderPM710 fromLectura(LecturaSchneiderPM710 lectura){
		SchneiderPM710 schneider = new SchneiderPM710();
		
		if(lectura.getTimestamp() == null || lectura.getNumRemarcador() == null){
			return schneider;
		}
		
		schneider.setTIMESTAMP(lectura.getTimestamp());
		schneider.setEQUIPO_ID(lectura.getNumRemarcador());
		
		if(lectura.getItem1() == null){
			schneider.setITEM1("");
		}else{
			schneider.setITEM1(Double.toString(lectura.getItem1()));
		}
		if(lectura.getItem2() == null){
			schneider.setITEM2("");
		}else{
			schneider.setITEM2(Double.toString(lectura.getItem2()));
		}
		if(lectura.getItem7() == null){
			schneider.setITEM7("");
		}else{
			schneider.setITEM7(Double.toString(lectura.getItem7()));
		}
		if(lectura.getItem108() == null){
			schneider.setITEM108("");
		}else{
			schneider.setITEM108(Double.toString(lectura.getItem108()));
		}
		
		if(lectura.getItem109() == null){
			schneider.setITEM109("");
		}else{
			schneider.setITEM109(Double.toString(lectura.getItem109()));
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
