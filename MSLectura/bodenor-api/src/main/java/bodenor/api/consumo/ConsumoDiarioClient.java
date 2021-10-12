package bodenor.api.consumo;

import bodenor.api.consumo.model.ConsumoDiario;
import bodenor.api.consumo.model.ConsumoDiarioResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(configKey = "config.api.bodenor")
@Path("/consumodiario")
public interface ConsumoDiarioClient {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ConsumoDiario postConsumoDiario(ConsumoDiario consumo);
    
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ConsumoDiario patchConsumoDiario(ConsumoDiarioResponse consumoDiarioResponse);
    
    @Path("/anterior")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ConsumoDiario getAnterior(@QueryParam("origen") String origen, @QueryParam("timestamp") String timestamp, @QueryParam("numremarcador") Integer numremarcador);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/last/{numremarcador}/{fechaBusqueda}")
    public ConsumoDiarioResponse getLastConsumoDiario(@PathParam("numremarcador") Integer numRemarcador, @PathParam("fechaBusqueda") String fechaBusqueda);
}
