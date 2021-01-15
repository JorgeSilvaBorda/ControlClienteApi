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
@Entity(name = "PROVINCIA")
public class Provincia {
    @Id
    @Column(name = "IDPROVINCIA")
    private Long idprovincia;
    @Column(name = "NOMPROVINCIA")
    private String nomprovincia;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDREGION")
    private Region region;

    public Provincia() {
    }

    public Provincia(Long idprovincia, String nomprovincia, Region region) {
        this.idprovincia = idprovincia;
        this.nomprovincia = nomprovincia;
        this.region = region;
    }

    public Long getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(Long idprovincia) {
        this.idprovincia = idprovincia;
    }

    public String getNomprovincia() {
        return nomprovincia;
    }

    public void setNomprovincia(String nomprovincia) {
        this.nomprovincia = nomprovincia;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    
    
}
