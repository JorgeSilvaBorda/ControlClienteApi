package bodenor.api.instalacion.model;

import bodenor.api.comuna.model.Comuna;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ApplicationScoped
@Entity(name = "INSTALACION")
public class Instalacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDINSTALACION")
    private Long idinstalacion;
    @Column(name = "NOMINSTALACION")
    private String nominstalacion;
    @Column(name = "DIRECCION")
    private String direccion;
    
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCOMUNA")
    private Comuna comuna;
    
    public Instalacion() {
    }

    public Instalacion(Long idinstalacion, String nominstalacion, String direccion, Comuna comuna) {
        this.idinstalacion = idinstalacion;
        this.nominstalacion = nominstalacion;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    public Long getIdinstalacion() {
        return idinstalacion;
    }

    public void setIdinstalacion(Long idinstalacion) {
        this.idinstalacion = idinstalacion;
    }

    public String getNominstalacion() {
        return nominstalacion;
    }

    public void setNominstalacion(String nominstalacion) {
        this.nominstalacion = nominstalacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }
    
    
    
}
