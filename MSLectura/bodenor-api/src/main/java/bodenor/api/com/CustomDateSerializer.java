package bodenor.api.com;

import com.google.gson.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomDateSerializer implements JsonSerializer<LocalDate> {

    //private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //"yyyy-MM-dd'T'HH:mm:ss'Z'"
    @Override
    public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
        //return new JsonPrimitive("ISODate(" + dateFormat.format(date) + ")");
        return new JsonPrimitive(dateFormat.format(date));
    }
}
