package bodenor.api.empalme.model;

import bodenor.api.bodega.model.Bodega;
import bodenor.api.instalacion.model.Instalacion;
import bodenor.api.red.model.Red;
import bodenor.api.remarcador.model.Remarcador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@ApplicationScoped
@Entity(name = "EMPALME")
public class Empalme implements Serializable {

    @Id
    @Column(name = "IDEMPALME")
    private Long idempalme;
    @Column(name = "NUMEMPALME")
    private String numempalme;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDINSTALACION")
    private Instalacion instalacion;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPARQUE")
    private Bodega bodega;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDRED")
    private Red red;

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "IDEMPALME")
    //private List<Remarcador> remarcadores = new ArrayList<>();

    public Empalme() {
    }

    public Empalme(Long idempalme, String numempalme, Instalacion instalacion, Bodega bodega, Red red) {
        this.idempalme = idempalme;
        this.numempalme = numempalme;
        this.instalacion = instalacion;
        this.bodega = bodega;
        this.red = red;
    }

    public Long getIdempalme() {
        return idempalme;
    }

    public void setIdempalme(Long idempalme) {
        this.idempalme = idempalme;
    }

    public String getNumempalme() {
        return numempalme;
    }

    public void setNumempalme(String numempalme) {
        this.numempalme = numempalme;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Red getRed() {
        return red;
    }

    public void setRed(Red red) {
        this.red = red;
    }
/*
    public List<Remarcador> getRemarcadores() {
        return remarcadores;
    }

    public void setRemarcadores(List<Remarcador> remarcadores) {
        this.remarcadores = remarcadores;
    }
*/
}
