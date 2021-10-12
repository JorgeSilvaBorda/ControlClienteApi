package bodenor.api.consumo.model;

public class Empalme {
    private Integer idEmpalme;
    private String numEmpalme;
    private Bodega bodega;
    private Instalacion instalacion;

    public Empalme() {
    }

    public Empalme(Integer idEmpalme, String numEmpalme, Bodega bodega, Instalacion instalacion) {
        this.idEmpalme = idEmpalme;
        this.numEmpalme = numEmpalme;
        this.bodega = bodega;
        this.instalacion = instalacion;
    }

    public Integer getIdEmpalme() {
        return idEmpalme;
    }

    public void setIdEmpalme(Integer idEmpalme) {
        this.idEmpalme = idEmpalme;
    }

    public String getNumEmpalme() {
        return numEmpalme;
    }

    public void setNumEmpalme(String numEmpalme) {
        this.numEmpalme = numEmpalme;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Instalacion getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(Instalacion instalacion) {
        this.instalacion = instalacion;
    }
    
    
}
