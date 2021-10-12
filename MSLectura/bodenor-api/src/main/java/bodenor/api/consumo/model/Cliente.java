package bodenor.api.consumo.model;

public class Cliente {
    private Integer idCliente, rutCliente;
    private String dvCliente, nomCliente, razonCliente;

    public Cliente() {
    }

    public Cliente(Integer idCliente, Integer rutCliente, String dvCliente, String nomCliente, String razonCliente) {
        this.idCliente = idCliente;
        this.rutCliente = rutCliente;
        this.dvCliente = dvCliente;
        this.nomCliente = nomCliente;
        this.razonCliente = razonCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(Integer rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getDvCliente() {
        return dvCliente;
    }

    public void setDvCliente(String dvCliente) {
        this.dvCliente = dvCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getRazonCliente() {
        return razonCliente;
    }

    public void setRazonCliente(String razonCliente) {
        this.razonCliente = razonCliente;
    }
    
    
}
