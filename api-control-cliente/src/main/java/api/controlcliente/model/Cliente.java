package api.controlcliente.model;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApplicationScoped
@Entity(name = "CLIENTE")
public class Cliente {
    @Id
    @Column(name = "IDCLIENTE")
    private Long idcliente;
    @Column(name = "RUTCLIENTE")
    private Integer rutcliente;
    @Column(name = "DVCLIENTE")
    private String dvcliente;
    @Column(name = "NOMCLIENTE")
    private String nomcliente;
    @Column(name = "RAZONCLIENTE")
    private String razoncliente;

    public Cliente() {
    }

    public Cliente(Long idcliente, Integer rutcliente, String dvcliente, String nomcliente, String razoncliente) {
        this.idcliente = idcliente;
        this.rutcliente = rutcliente;
        this.dvcliente = dvcliente;
        this.nomcliente = nomcliente;
        this.razoncliente = razoncliente;
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
    
    
    
}
