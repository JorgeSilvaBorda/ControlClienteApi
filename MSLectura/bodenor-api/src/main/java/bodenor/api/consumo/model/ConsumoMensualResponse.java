package bodenor.api.consumo.model;

public class ConsumoMensualResponse{
    private ConsumoMensual consumoMensual;
    private String idString;

    public ConsumoMensualResponse() {
    }

    public ConsumoMensualResponse(ConsumoMensual consumoMensual, String idString) {
        this.consumoMensual = consumoMensual;
        this.idString = idString;
    }

    public ConsumoMensual getConsumoMensual() {
        return consumoMensual;
    }

    public void setConsumoMensual(ConsumoMensual consumoMensual) {
        this.consumoMensual = consumoMensual;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }
}