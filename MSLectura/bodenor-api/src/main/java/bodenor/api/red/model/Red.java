package bodenor.api.red.model;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApplicationScoped
@Entity(name = "RED")
public class Red {
    @Id
    @Column(name = "IDRED")
    private Long idred;
    @Column(name = "NOMRED")
    private String nomred;

    public Red() {
    }

    public Red(Long idred, String nomred) {
        this.idred = idred;
        this.nomred = nomred;
    }

    public Long getIdred() {
        return idred;
    }

    public void setIdred(Long idred) {
        this.idred = idred;
    }

    public String getNomred() {
        return nomred;
    }

    public void setNomred(String nomred) {
        this.nomred = nomred;
    }
    
    
}
