package bodenor.api.consumo.model;

public class Bodega {
    private Integer idBodega;
    private String nomBodega;

    public Bodega() {
    }

    public Bodega(Integer idBodega, String nomBodega) {
        this.idBodega = idBodega;
        this.nomBodega = nomBodega;
    }

    public Integer getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Integer idBodega) {
        this.idBodega = idBodega;
    }

    public String getNomBodega() {
        return nomBodega;
    }

    public void setNomBodega(String nomBodega) {
        this.nomBodega = nomBodega;
    }
    
    
}
