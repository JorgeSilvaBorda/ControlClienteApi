package bodenor.api.region.model;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApplicationScoped
@Entity(name = "REGION")
public class Region {
    @Id
    @Column(name = "IDREGION")
    private Integer idregion;
    @Column(name = "NOMREGION")
    private String nomregion;
    @Column(name = "ABREVIATURA")
    private String abreviatura;
    @Column(name = "CAPITAL")
    private String capital;

    public Region() {
    }

    public Region(Integer idregion, String nomregion, String abreviatura, String capital) {
        this.idregion = idregion;
        this.nomregion = nomregion;
        this.abreviatura = abreviatura;
        this.capital = capital;
    }

    public Integer getIdregion() {
        return idregion;
    }

    public void setIdregion(Integer idregion) {
        this.idregion = idregion;
    }

    public String getNomregion() {
        return nomregion;
    }

    public void setNomregion(String nomregion) {
        this.nomregion = nomregion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    
}
