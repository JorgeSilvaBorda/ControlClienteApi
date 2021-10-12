package bodenor.api.remarcador.model;

import bodenor.api.bodega.model.Bodega;
import bodenor.api.empalme.model.Empalme;
import bodenor.api.remarcador.model.asignacion.model.Asignacion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@ApplicationScoped
@Entity(name = "REMARCADOR")
public class Remarcador implements Serializable {

    private static final long serialVersionUID = 9197911968578298804L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    //@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPARQUE")
    private Bodega bodega;

    //@ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idempalme")
    //@JsonbTransient
    private Empalme empalme;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDREMARCADOR")
    @JsonManagedReference
    //@JsonbTransient
    private List<Asignacion> asignaciones = new ArrayList<>();

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

    public void setNumremarcador(Integer numremarcador) {
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

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    public Asignacion getLastAsignacion() {

        Asignacion a = new Asignacion();
        a.setIdasignacion(0);
        for (int x = 0; x < asignaciones.size(); x++) {
            Asignacion asignacion = asignaciones.get(x);
            if(asignacion.getIdasignacion() > a.getIdasignacion()){
                a = asignacion;
            }
        }
        return a;
    }

}
