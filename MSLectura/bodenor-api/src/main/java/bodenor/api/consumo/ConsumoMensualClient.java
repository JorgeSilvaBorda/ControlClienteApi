
package bodenor.api.consumo;
import bodenor.api.consumo.model.ConsumoMensual;
import bodenor.api.consumo.model.ConsumoMensualResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "config.api.bodenor")
@Path("/consumomensual")
public interface ConsumoMensualClient {
	
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ConsumoMensual postConsumoMensual(ConsumoMensual consumo);
    
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ConsumoMensual patchConsumoMensual(ConsumoMensualResponse consumoMensualResponse);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/last/{numremarcador}/{anio}/{mes}")
    public ConsumoMensualResponse getLastConsumoMensual(@PathParam("numremarcador") Integer numRemarcador, @PathParam("anio") Integer anioBusqueda, @PathParam("mes") Integer mesBusqueda);
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/last/{numremarcador}/{anio}/{mes}/idstring")
    public String getLastConsumoMensualIdString(@PathParam("numremarcador") Integer numRemarcador, @PathParam("anio") Integer anioBusqueda, @PathParam("mes") Integer mesBusqueda);
}
