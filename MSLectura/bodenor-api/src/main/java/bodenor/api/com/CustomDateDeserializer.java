package bodenor.api.com;

import java.lang.reflect.Type;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 
public class CustomDateDeserializer implements JsonDeserializer<LocalDate> {
 
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 
    @Override
    public LocalDate deserialize(JsonElement dateStr, Type typeOfSrc, JsonDeserializationContext context) {
        LocalDate salida = LocalDate.parse(dateStr.getAsString());
        return salida;
    }
}
