
package bodenor.api.consumo.model;

import bodenor.api.comuna.model.Comuna;

public class Instalacion {
    private Integer idInstalacion;
    private String nomInstalacion;
    private String direccion;
    private Comuna comuna;

    public Instalacion() {
    }

    public Instalacion(Integer idInstalacion, String nomInstalacion, String direccion, Comuna comuna) {
        this.idInstalacion = idInstalacion;
        this.nomInstalacion = nomInstalacion;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    public Integer getIdInstalacion() {
        return idInstalacion;
    }

    public void setIdInstalacion(Integer idInstalacion) {
        this.idInstalacion = idInstalacion;
    }

    public String getNomInstalacion() {
        return nomInstalacion;
    }

    public void setNomInstalacion(String nomInstalacion) {
        this.nomInstalacion = nomInstalacion;
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
