package bodenor.api.lectura.legado.model;

import bodenor.api.lectura.model.LecturaCircutorCVMC10;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApplicationScoped
@Table(name = "circutorcvmC10")
@Entity(name = "circutorcvmC10")
public class CircutorCVMC10 implements Serializable{
    @Id
	private LocalDateTime TIMESTAMP;
	@Id
	private Integer EQUIPO_ID;
	private String ITEM49;
	private String ITEM50;
	private String ITEM95;
	private String ITEM96;
	private LocalDate FECHA;
	private Integer ANIO;
	private Integer MES;
	private Integer DIA;
	private LocalTime HORA;
	private Integer HH;
	private Integer MM;
	private Integer SS;

	public CircutorCVMC10() {
	}

	public CircutorCVMC10(LocalDateTime TIMESTAMP, Integer EQUIPO_ID, String ITEM49, String ITEM50, String ITEM95, String ITEM96, LocalDate FECHA, Integer ANIO, Integer MES, Integer DIA, LocalTime HORA, Integer HH, Integer MM, Integer SS) {
		this.TIMESTAMP = TIMESTAMP;
		this.EQUIPO_ID = EQUIPO_ID;
		this.ITEM49 = ITEM49;
		this.ITEM50 = ITEM50;
		this.ITEM95 = ITEM95;
		this.ITEM96 = ITEM96;
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

	public String getITEM49() {
		return ITEM49;
	}

	public void setITEM49(String ITEM49) {
		this.ITEM49 = ITEM49;
	}

	public String getITEM50() {
		return ITEM50;
	}

	public void setITEM50(String ITEM50) {
		this.ITEM50 = ITEM50;
	}

	public String getITEM95() {
		return ITEM95;
	}

	public void setITEM95(String ITEM95) {
		this.ITEM95 = ITEM95;
	}

	public String getITEM96() {
		return ITEM96;
	}

	public void setITEM96(String ITEM96) {
		this.ITEM96 = ITEM96;
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
	
	public CircutorCVMC10 fromLectura(LecturaCircutorCVMC10 lectura){
		CircutorCVMC10 circutor = new CircutorCVMC10();
		
		if(lectura.getTimestamp() == null || lectura.getNumremarcador() == null){
			return circutor;
		}
		
		circutor.setTIMESTAMP(lectura.getTimestamp());
		circutor.setEQUIPO_ID(lectura.getNumremarcador());
		
		if(lectura.getItem49() == null){
			circutor.setITEM49("");
		}else{
			circutor.setITEM49(Integer.toString(lectura.getItem49().intValue()));
		}
		if(lectura.getItem50() == null){
			circutor.setITEM50("");
		}else{
			circutor.setITEM50(Integer.toString(lectura.getItem50().intValue()));
		}
		if(lectura.getItem95() == null){
			circutor.setITEM95("");
		}else{
			circutor.setITEM95(Integer.toString(lectura.getItem95().intValue()));
		}
		if(lectura.getItem96() == null){
			circutor.setITEM96("");
		}else{
			circutor.setITEM96(Integer.toString(lectura.getItem96().intValue()));
		}
		
		circutor.setFECHA(lectura.getFecha());
		circutor.setANIO(lectura.getAnio());
		circutor.setMES(lectura.getMes());
		circutor.setDIA(lectura.getDia());
		circutor.setHORA(lectura.getTimestamp().toLocalTime());
		circutor.setHH(circutor.getHORA().getHour());
		circutor.setMM(circutor.getHORA().getMinute());
		circutor.setSS(circutor.getHORA().getSecond());
		
		return circutor;
	}
}
