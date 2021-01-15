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
@Entity(name = "CONTACTO")
public class ContactoCliente {
    @Id
    @Column(name = "IDCONTACTO")
    private Long idcontactocliente;
    @Column(name = "PERSONA")
    private String nombre;
    @Column(name = "CARGO")
    private String cargo;
    @Column(name = "FONO")
    private Long fono;
    @Column(name = "EMAIL")
    private String email;
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;

    public ContactoCliente() {
    }

    public ContactoCliente(Long idcliente, String nombre, String cargo, Long fono, String email, Cliente cliente) {
        this.idcontactocliente = idcontactocliente;
        this.nombre = nombre;
        this.cargo = cargo;
        this.fono = fono;
        this.email = email;
        this.cliente = cliente;
    }

    public Long getIdcontactocliente() {
        return idcontactocliente;
    }

    public void setIdcontactocliente(Long idcontactocliente) {
        this.idcontactocliente = idcontactocliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Long getFono() {
        return fono;
    }

    public void setFono(Long fono) {
        this.fono = fono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
