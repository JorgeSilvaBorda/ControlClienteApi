package bodenor.api.bodega.model;

import bodenor.api.instalacion.model.Instalacion;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ApplicationScoped
@Entity(name = "PARQUE")
public class Bodega {
    @Id
    @Column(name = "IDPARQUE")
    private Long idbodega;
    @Column(name = "NOMPARQUE")
    private String nombodega;
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDINSTALACION")
    private Instalacion instalacion;

    public Bodega(Long idbodega, String nombodega, Instalacion instalacion) {
        this.idbodega = idbodega;
        this.nombodega = nombodega;
        this.instalacion = instalacion;
    }

    public Bodega() {
    }

    public Long getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Long idbodega) {
        this.idbodega = idbodega;
    }

    public String getNombodega() {
        return nombodega;
    }

    public void setNombodega(String nombodega) {
        this.nombodega = nombodega;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }
}
