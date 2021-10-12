package bodenor.api.cliente.model;

import bodenor.api.remarcador.model.asignacion.model.Asignacion;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@ApplicationScoped
@Entity(name = "CLIENTE")
@Table(name = "CLIENTE")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 9197911968558298804L;
    
    @Id
    @Column(name = "IDCLIENTE")
    @JsonProperty("idcliente")
    private Long idcliente;
    @Column(name = "RUTCLIENTE")
    @JsonProperty("rutcliente")
    private Integer rutcliente;
    @Column(name = "DVCLIENTE")
    @JsonProperty("dvcliente")
    private String dvcliente;
    @Column(name = "NOMCLIENTE")
    @JsonProperty("nomcliente")
    private String nomcliente;
    @Column(name = "RAZONCLIENTE")
    @JsonProperty("razoncliente")
    private String razoncliente;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDCLIENTE", nullable = true)
    @JsonProperty("asignaciones")
    @JsonManagedReference
    @JsonbTransient
    private List<Asignacion> asignaciones = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Long idcliente, Integer rutcliente, String dvcliente, String nomcliente, String razoncliente, List<Asignacion> asignaciones) {
        this.idcliente = idcliente;
        this.rutcliente = rutcliente;
        this.dvcliente = dvcliente;
        this.nomcliente = nomcliente;
        this.razoncliente = razoncliente;
        this.asignaciones = asignaciones;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
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

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

}
