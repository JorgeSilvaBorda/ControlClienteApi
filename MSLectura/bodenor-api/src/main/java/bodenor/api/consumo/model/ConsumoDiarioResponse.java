package bodenor.api.consumo.model;

public class ConsumoDiarioResponse {
    private ConsumoDiario consumoDiario;
    private String idString;

    public ConsumoDiarioResponse() {
    }

    public ConsumoDiarioResponse(ConsumoDiario consumoDiario, String idString) {
        this.consumoDiario = consumoDiario;
        this.idString = idString;
    }

    public ConsumoDiario getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(ConsumoDiario consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

    public String getIdString() {
        return idString;
    }

    public void setIdString(String idString) {
        this.idString = idString;
    }
}
