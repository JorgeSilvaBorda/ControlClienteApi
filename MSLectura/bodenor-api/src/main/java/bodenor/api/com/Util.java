package bodenor.api.com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Util {
    public static void imprimirClaseJson(Object o){
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        builder.registerTypeAdapter(LocalDate.class, new CustomDateSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateDeserializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeDeserializer());
        
        Gson gson = builder.create();
        String json = gson.toJson(o);
        
        System.out.println(json);
    }
}
