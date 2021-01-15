package api.controlcliente.model;

import java.util.List;
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
import javax.persistence.OneToMany;

@ApplicationScoped
@Entity(name = "COMUNA")
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCOMUNA")
    private Long idcomuna;
    @Column(name = "NOMCOMUNA")
    private String nomcomuna;
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPROVINCIA")
    private Provincia provincia;
    
    //@OneToMany(mappedBy = "comuna")
    //private List<Instalacion> instalaciones;
    
    public Comuna() {
    }

    public Comuna(Long idcomuna, String nomcomuna, Provincia provincia) {
        this.idcomuna = idcomuna;
        this.nomcomuna = nomcomuna;
        this.provincia = provincia;
    }

    public Long getIdcomuna() {
        return idcomuna;
    }

    public void setIdcomuna(Long idcomuna) {
        this.idcomuna = idcomuna;
    }

    public String getNomcomuna() {
        return nomcomuna;
    }

    public void setNomcomuna(String nomcomuna) {
        this.nomcomuna = nomcomuna;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    
}
