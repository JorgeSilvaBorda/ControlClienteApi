package bodenor.api.remarcador.model.asignacion;

import bodenor.api.remarcador.model.asignacion.model.Asignacion;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "config.api.bodenor")
@Path("/bodenor/remarcador/asignacion")
public interface AsignacionClient {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Asignacion> getAsignaciones();
    
    @Path("/{idremarcador}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Asignacion> getAsignacionesIdRemarcador(@PathParam("idremarcador") Integer idremarcador);
    
    @Path("/{idremarcador}/{anio}/{mes}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Asignacion getAsignacionesIdRemarcadorAnioMes(@PathParam("idremarcador") Integer idremarcador, @PathParam("anio") Integer anio, @PathParam("mes") Integer mes);
    
}
