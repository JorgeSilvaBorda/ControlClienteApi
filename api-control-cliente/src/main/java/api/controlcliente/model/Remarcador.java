package api.controlcliente.model;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ApplicationScoped
@Entity(name = "REMARCADOR")
public class Remarcador {
    @Id
    @Column(name = "IDREMARCADOR")
    private Long idremarcador;
    @Column(name = "NUMREMARCADOR")
    private Integer numremarcador;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "NUMSERIE")
    private String numserie;
    @Column(name = "MODULOS")
    private String modulos;
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPARQUE")
    private Bodega bodega;
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDEMPALME")
    private Empalme empalme;

    public Remarcador() {
    }

    public Remarcador(Long idremarcador, Integer numremarcador, String marca, String modelo, String numserie, String modulos, Bodega bodega, Empalme empalme) {
        this.idremarcador = idremarcador;
        this.numremarcador = numremarcador;
        this.marca = marca;
        this.modelo = modelo;
        this.numserie = numserie;
        this.modulos = modulos;
        this.bodega = bodega;
        this.empalme = empalme;
    }

    public Long getIdremarcador() {
        return idremarcador;
    }

    public void setIdremarcador(Long idremarcador) {
        this.idremarcador = idremarcador;
    }
    
    public Integer getNumremarcador() {
        return numremarcador;
    }

    public void setNumremracador(Integer numremarcador) {
        this.numremarcador = numremarcador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumserie() {
        return numserie;
    }

    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    public String getModulos() {
        return modulos;
    }

    public void setModulos(String modulos) {
        this.modulos = modulos;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Empalme getEmpalme() {
        return empalme;
    }

    public void setEmpalme(Empalme empalme) {
        this.empalme = empalme;
    }

    
}
