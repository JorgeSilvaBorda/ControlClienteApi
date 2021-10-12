
package bodenor.api.boleta.model.concepto.model;

import bodenor.api.red.model.Red;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONCEPTO")
@ApplicationScoped
public class Concepto implements Serializable {
    @Id
    @Column(name = "IDCONCEPTO")
    private Integer idconcepto;
    @Column(name = "NOMCONCEPTO")
    private String nomconcepto;
    @Column(name = "UMEDIDA")
    private String umedida;
    //@ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDRED")
    private Red red;

    public Concepto() {
    }

    public Concepto(Integer idconcepto, String nomconcepto, String umedida, Red red) {
        this.idconcepto = idconcepto;
        this.nomconcepto = nomconcepto;
        this.umedida = umedida;
        this.red = red;
    }

    public Integer getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Integer idconcepto) {
        this.idconcepto = idconcepto;
    }

    public String getNomconcepto() {
        return nomconcepto;
    }

    public void setNomconcepto(String nomconcepto) {
        this.nomconcepto = nomconcepto;
    }

    public String getUmedida() {
        return umedida;
    }

    public void setUmedida(String umedida) {
        this.umedida = umedida;
    }

    public Red getRed() {
        return red;
    }

    public void setRed(Red red) {
        this.red = red;
    }

    
}
