package bodenor.api.com;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateTimeDeserializer implements JsonDeserializer<LocalDateTime>{
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 
    @Override
    public LocalDateTime deserialize(JsonElement dateStr, Type typeOfSrc, JsonDeserializationContext context) {
        LocalDateTime salida = LocalDateTime.parse(dateStr.getAsString());
        return salida;
    }
}
