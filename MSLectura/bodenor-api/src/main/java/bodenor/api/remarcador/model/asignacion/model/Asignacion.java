package bodenor.api.remarcador.model.asignacion.model;

import bodenor.api.cliente.model.Cliente;
import bodenor.api.remarcador.model.Remarcador;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@ApplicationScoped
@Entity(name = "CLIREMPAR")
@Table(name = "CLIREMPAR")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "idasignacion")
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 9197911968578298904L;
    
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCLIENTE")
    //@JsonbTransient
    @JsonProperty("cliente")
    private Cliente cliente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDASIGNACION")
    private Integer idasignacion;

    @Column(name = "FECHAASIGNACION")
    private String fechaasignacion;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "IDUSUARIO")
    private Integer idusuario;

    @Column(name = "FECHAULTLECTURAVALIDA")
    private String fechaultlecturavalida;

    @Column(name = "IDCONTACTO")
    private Integer idcontacto;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDREMARCADOR")
    @JsonbTransient
    @JsonProperty("remarcador")
    private Remarcador remarcador;
    
    

    public Asignacion() {
    }

    public Asignacion(Integer idasignacion, String fechaasignacion, String tipo, Integer idusuario, String fechaultlecturavalida, Integer idcontacto, Remarcador remarcador, Cliente cliente) {
        this.idasignacion = idasignacion;
        this.fechaasignacion = fechaasignacion;
        this.tipo = tipo;
        this.idusuario = idusuario;
        this.fechaultlecturavalida = fechaultlecturavalida;
        this.idcontacto = idcontacto;
        this.remarcador = remarcador;
        this.cliente = cliente;
    }

    public Integer getIdasignacion() {
        return idasignacion;
    }

    public void setIdasignacion(Integer idasignacion) {
        this.idasignacion = idasignacion;
    }

    public String getFechaasignacion() {
        return fechaasignacion;
    }

    public void setFechaasignacion(String fechaasignacion) {
        this.fechaasignacion = fechaasignacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getFechaultlecturavalida() {
        return fechaultlecturavalida;
    }

    public void setFechaultlecturavalida(String fechaultlecturavalida) {
        this.fechaultlecturavalida = fechaultlecturavalida;
    }

    public Integer getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(Integer idcontacto) {
        this.idcontacto = idcontacto;
    }

    public Remarcador getRemarcador() {
        return remarcador;
    }

    public void setRemarcador(Remarcador remarcador) {
        this.remarcador = remarcador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
