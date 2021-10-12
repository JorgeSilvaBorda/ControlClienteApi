package bodenor.api.com;

import com.google.gson.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class CustomDateTimeSerializer implements JsonSerializer<LocalDateTime>{
    
    private static final java.time.format.DateTimeFormatter dateTimeFormat = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
    @Override
    public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(dateTimeFormat.format(date));
    }
}