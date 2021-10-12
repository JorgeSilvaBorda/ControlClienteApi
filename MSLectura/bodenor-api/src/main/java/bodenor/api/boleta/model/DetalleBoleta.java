/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.boleta.model;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApplicationScoped
@Entity(name = "HIST_DETALLE_BOLETA")
@Table
public class DetalleBoleta implements Serializable{

    @Id
    @Column(name = "IDBOLETA")
    private Integer idboleta;
    @Id
    @Column(name = "IDCONCEPTO")
    private Integer idconcepto;
    @Column(name = "NOMCONCEPTO")
    private String nomconcepto;
    @Column(name = "UMEDIDA")
    private String umedida;
    @Column(name = "IDRED")
    private Integer idred;
    @Column(name = "NOMRED")
    private String nomred;
    @Column(name = "VALORNETO")
    private Double valorneto;
    @Column(name = "CANTIDAD")
    private Double cantidad;
    @Column(name = "TOTAL")
    private Double total;

    public DetalleBoleta() {
    }

    public DetalleBoleta(Integer idboleta, Integer idconcepto, String nomconcepto, String umedida, Integer idred, String nomred, Double valorneto, Double cantidad, Double total) {
        this.idboleta = idboleta;
        this.idconcepto = idconcepto;
        this.nomconcepto = nomconcepto;
        this.umedida = umedida;
        this.idred = idred;
        this.nomred = nomred;
        this.valorneto = valorneto;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Integer getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(Integer idboleta) {
        this.idboleta = idboleta;
    }

    public Integer getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Integer idconcepto) {
        this.idconcepto = idconcepto;
    }

    public String getNomconcepto() {
        return nomconcepto;
    }

    public void setNomconcepto(String nomconcepto) {
        this.nomconcepto = nomconcepto;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
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

    public Double getValorneto() {
        return valorneto;
    }

    public void setValorneto(Double valorneto) {
        this.valorneto = valorneto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    
}
