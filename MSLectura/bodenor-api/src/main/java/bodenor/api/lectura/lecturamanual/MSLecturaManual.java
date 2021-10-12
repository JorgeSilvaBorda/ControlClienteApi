package bodenor.api.lectura.lecturamanual;

import bodenor.api.continuidad.model.Continuidad;
import bodenor.api.lectura.lecturamanual.model.LecturaManual;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/lecturamanual")
public class MSLecturaManual {
    
    @Inject
    EntityManager manager;
    
    @Path("/{numremarcador}/{anio}/{mes}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LecturaManual> getLecturaManualAnioMes(@PathParam("numremarcador") Integer numremarcador, @PathParam("anio") Integer anio, @PathParam("mes") Integer mes){
        String query = "SELECT LM FROM LECTURAMANUAL LM WHERE LM.numremarcador = " + numremarcador + " AND LM.anio = " + anio + " AND LM.mes = " + mes;
        List<LecturaManual> resultado = manager.createQuery(query, LecturaManual.class).getResultList();  
        return resultado;
    }
    
    @Path("/{numremarcador}/{fechadesde}/{fechahasta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LecturaManual> getLecturaManualFechas(@PathParam("numremarcador") Integer numremarcador, @PathParam("fechadesde") String fechadesde, @PathParam("fechahasta") String fechahasta){
        String query = "SELECT LM FROM LECTURAMANUAL LM WHERE LM.numremarcador = " + numremarcador + " AND (LM.fecha >= '" + fechadesde + "' AND LM.fecha <= '" + fechahasta + "')";
        List<LecturaManual> resultado = manager.createQuery(query, LecturaManual.class).getResultList();  
        return resultado;
    }
    
    @Path("/{numremarcador}/{timestamp}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LecturaManual> getLecturaManualTimestamp(@PathParam("numremarcador") Integer numremarcador, @PathParam("timestamp") String timestamp){
        String query = "SELECT LM FROM LECTURAMANUAL LM WHERE LM.numremarcador = " + numremarcador + " AND LM.timestamp = '" + timestamp + "'";
        List<LecturaManual> resultado = manager.createQuery(query, LecturaManual.class).getResultList();  
        return resultado;
    }
    
}
