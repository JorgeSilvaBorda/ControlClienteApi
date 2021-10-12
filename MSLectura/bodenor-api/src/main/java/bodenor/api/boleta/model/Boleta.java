package bodenor.api.boleta.model;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApplicationScoped
@Entity(name = "HIST_BOLETA")
@Table
public class Boleta implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDBOLETA")
    private Integer idboleta;
    @Column(name = "TIMESTAMP")
    private String timestamp;
    @Column(name = "IDTARIFA")
    private Integer idtarifa;
    @Column(name = "NOMTARIFA")
    private String nomtarifa;
    @Column(name = "NUMBOLETA")
    private String numboleta;
    @Column(name = "idcliente")
    private Integer idcliente;
    @Column(name = "NOMCLIENTE")
    private String nomcliente;
    @Column(name = "RAZONCLIENTE")
    private String razoncliente;
    @Column(name = "RUTCLIENTE")
    private Integer rutcliente;
    @Column(name = "DVCLIENTE")
    private String dvcliente;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "PERSONA")
    private String persona;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FONO")
    private Integer fono;
    @Column(name = "FECHAEMISION")
    private String fechaemision;
    @Column(name = "FECHAPROXLECTURA")
    private String fechaproxlectura;
    @Column(name = "IDINSTALACION")
    private Integer idinstalacion;
    @Column(name = "NOMINSTALACION")
    private String nominstalacion;
    @Column(name = "IDPARQUE")
    private Integer idparque;
    @Column(name = "NOMPARQUE")
    private String nomparque;
    @Column(name = "IDEMPALME")
    private Integer idempalme;
    @Column(name = "NUMEMPALME")
    private String numempalme;
    @Column(name = "IDCOMUNA")
    private Integer idcomuna;
    @Column(name = "NOMCOMUNA")
    private String nomcomuna;
    @Column(name = "IDRED")
    private Integer idred;
    @Column(name = "NOMRED")
    private String nomred;
    @Column(name = "IDREMARCADOR")
    private Integer idremarcador;
    @Column(name = "NUMREMARCADOR")
    private Integer numremarcador;
    @Column(name = "MODULOS")
    private String modulos;
    @Column(name = "NUMSERIE")
    private String numserie;
    @Column(name = "LECTURAANTERIOR")
    private Double lecturaanterior;
    @Column(name = "LECTURAACTUAL")
    private Double lecturaactual;
    @Column(name = "FECHALECTURAANTERIOR")
    private String fechalecturaanterior;
    @Column(name = "FECHALECTURAACTUAL")
    private String fechalecturaactual;
    @Column(name = "CONSUMO")
    private Double consumo;
    @Column(name = "DEM_MAX_SUMINISTRADA_LEIDA")
    private Double demmaxsuministradaleida;
    @Column(name = "DEM_MAX_SUMINISTRADA_FACTURADA")
    private Double demmaxsuministradafacturada;

    @Column(name = "DEM_MAX_HORA_PUNTA_LEIDA")
    private Double demmaxhorapuntaleida;
    @Column(name = "DEM_MAX_HORA_PUNTA_FACTURADA")
    private Double demmaxhorapuntafacturada;

    @Column(name = "TOTALNETO")
    private Integer totalneto;
    @Column(name = "IVA")
    private Integer iva;
    @Column(name = "EXENTO")
    private Integer exento;
    @Column(name = "TOTAL")
    private Integer total;

    public Boleta() {
    }

    public Boleta(Integer idboleta, String timestamp, Integer idtarifa, String nomtarifa, String numboleta, Integer idcliente, String nomcliente, String razoncliente, Integer rutcliente, String dvcliente, String direccion, String persona, String email, Integer fono, String fechaemision, String fechaproxlectura, Integer idinstalacion, String nominstalacion, Integer idparque, String nomparque, Integer idempalme, String numempalme, Integer idcomuna, String nomcomuna, Integer idred, String nomred, Integer idremarcador, Integer numremarcador, String modulos, String numserie, Double lecturaanterior, Double lecturaactual, String fechalecturaanterior, String fechalecturaactual, Double consumo, Double demmaxsuministradaleida, Double demmaxsuministradafacturada, Double demmaxhorapuntaleida, Double demmaxhorapuntafacturada, Integer totalneto, Integer iva, Integer exento, Integer total) {
        this.idboleta = idboleta;
        this.timestamp = timestamp;
        this.idtarifa = idtarifa;
        this.nomtarifa = nomtarifa;
        this.numboleta = numboleta;
        this.idcliente = idcliente;
        this.nomcliente = nomcliente;
        this.razoncliente = razoncliente;
        this.rutcliente = rutcliente;
        this.dvcliente = dvcliente;
        this.direccion = direccion;
        this.persona = persona;
        this.email = email;
        this.fono = fono;
        this.fechaemision = fechaemision;
        this.fechaproxlectura = fechaproxlectura;
        this.idinstalacion = idinstalacion;
        this.nominstalacion = nominstalacion;
        this.idparque = idparque;
        this.nomparque = nomparque;
        this.idempalme = idempalme;
        this.numempalme = numempalme;
        this.idcomuna = idcomuna;
        this.nomcomuna = nomcomuna;
        this.idred = idred;
        this.nomred = nomred;
        this.idremarcador = idremarcador;
        this.numremarcador = numremarcador;
        this.modulos = modulos;
        this.numserie = numserie;
        this.lecturaanterior = lecturaanterior;
        this.lecturaactual = lecturaactual;
        this.fechalecturaanterior = fechalecturaanterior;
        this.fechalecturaactual = fechalecturaactual;
        this.consumo = consumo;
        this.demmaxsuministradaleida = demmaxsuministradaleida;
        this.demmaxsuministradafacturada = demmaxsuministradafacturada;
        this.demmaxhorapuntaleida = demmaxhorapuntaleida;
        this.demmaxhorapuntafacturada = demmaxhorapuntafacturada;
        this.totalneto = totalneto;
        this.iva = iva;
        this.exento = exento;
        this.total = total;
    }

    public Integer getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(Integer idboleta) {
        this.idboleta = idboleta;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Integer idtarifa) {
        this.idtarifa = idtarifa;
    }

    public String getNomtarifa() {
        return nomtarifa;
    }

    public void setNomtarifa(String nomtarifa) {
        this.nomtarifa = nomtarifa;
    }

    public String getNumboleta() {
        return numboleta;
    }

    public void setNumboleta(String numboleta) {
        this.numboleta = numboleta;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNomcliente() {
        return nomcliente;
    }

    public void setNomcliente(String nomcliente) {
        this.nomcliente = nomcliente;
    }

    public String getRazoncliente() {
        return razoncliente;
    }

    public void setRazoncliente(String razoncliente) {
        this.razoncliente = razoncliente;
    }

    public Integer getRutcliente() {
        return rutcliente;
    }

    public void setRutcliente(Integer rutcliente) {
        this.rutcliente = rutcliente;
    }

    public String getDvcliente() {
        return dvcliente;
    }

    public void setDvcliente(String dvcliente) {
        this.dvcliente = dvcliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFono() {
        return fono;
    }

    public void setFono(Integer fono) {
        this.fono = fono;
    }

    public String getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(String fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getFechaproxlectura() {
        return fechaproxlectura;
    }

    public void setFechaproxlectura(String fechaproxlectura) {
        this.fechaproxlectura = fechaproxlectura;
    }

    public Integer getIdinstalacion() {
        return idinstalacion;
    }

    public void setIdinstalacion(Integer idinstalacion) {
        this.idinstalacion = idinstalacion;
    }

    public String getNominstalacion() {
        return nominstalacion;
    }

    public void setNominstalacion(String nominstalacion) {
        this.nominstalacion = nominstalacion;
    }

    public Integer getIdparque() {
        return idparque;
    }

    public void setIdparque(Integer idparque) {
        this.idparque = idparque;
    }

    public String getNomparque() {
        return nomparque;
    }

    public void setNomparque(String nomparque) {
        this.nomparque = nomparque;
    }

    public Integer getIdempalme() {
        return idempalme;
    }

    public void setIdempalme(Integer idempalme) {
        this.idempalme = idempalme;
    }

    public String getNumempalme() {
        return numempalme;
    }

    public void setNumempalme(String numempalme) {
        this.numempalme = numempalme;
    }

    public Integer getIdcomuna() {
        return idcomuna;
    }

    public void setIdcomuna(Integer idcomuna) {
        this.idcomuna = idcomuna;
    }

    public String getNomcomuna() {
        return nomcomuna;
    }

    public void setNomcomuna(String nomcomuna) {
        this.nomcomuna = nomcomuna;
    }

    public Integer getIdred() {
        return idred;
    }

    public void setIdred(Integer idred) {
        this.idred = idred;
    }

    public String getNomred() {
        return nomred;
    }

    public void setNomred(String nomred) {
        this.nomred = nomred;
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

    public String getModulos() {
        return modulos;
    }

    public void setModulos(String modulos) {
        this.modulos = modulos;
    }

    public String getNumserie() {
        return numserie;
    }

    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    public Double getLecturaanterior() {
        return lecturaanterior;
    }

    public void setLecturaanterior(Double lecturaanterior) {
        this.lecturaanterior = lecturaanterior;
    }

    public Double getLecturaactual() {
        return lecturaactual;
    }

    public void setLecturaactual(Double lecturaactual) {
        this.lecturaactual = lecturaactual;
    }

    public String getFechalecturaanterior() {
        return fechalecturaanterior;
    }

    public void setFechalecturaanterior(String fechalecturaanterior) {
        this.fechalecturaanterior = fechalecturaanterior;
    }

    public String getFechalecturaactual() {
        return fechalecturaactual;
    }

    public void setFechalecturaactual(String fechalecturaactual) {
        this.fechalecturaactual = fechalecturaactual;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public Double getDemmaxsuministradaleida() {
        return demmaxsuministradaleida;
    }

    public void setDemmaxsuministradaleida(Double demmaxsuministradaleida) {
        this.demmaxsuministradaleida = demmaxsuministradaleida;
    }

    public Double getDemmaxsuministradafacturada() {
        return demmaxsuministradafacturada;
    }

    public void setDemmaxsuministradafacturada(Double demmaxsuministradafacturada) {
        this.demmaxsuministradafacturada = demmaxsuministradafacturada;
    }

    public Double getDemmaxhorapuntaleida() {
        return demmaxhorapuntaleida;
    }

    public void setDemmaxhorapuntaleida(Double demmaxhorapuntaleida) {
        this.demmaxhorapuntaleida = demmaxhorapuntaleida;
    }

    public Double getDemmaxhorapuntafacturada() {
        return demmaxhorapuntafacturada;
    }

    public void setDemmaxhorapuntafacturada(Double demmaxhorapuntafacturada) {
        this.demmaxhorapuntafacturada = demmaxhorapuntafacturada;
    }

    public Integer getTotalneto() {
        return totalneto;
    }

    public void setTotalneto(Integer totalneto) {
        this.totalneto = totalneto;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getExento() {
        return exento;
    }

    public void setExento(Integer exento) {
        this.exento = exento;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    
    
}