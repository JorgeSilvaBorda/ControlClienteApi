
package bodenor.api.continuidad;

import bodenor.api.continuidad.model.Continuidad;
import bodenor.api.continuidad.model.ContinuidadDiario;
import bodenor.api.continuidad.model.ContinuidadMensual;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
/**
 * Cliente de MSContinuidad.
 * Todo consumo de funcionalidades de continuidad debe ser declarado acá.
 * @author jorge
 */

@RegisterRestClient(configKey = "config.api.bodenor")
@Path("/continuidad")
public interface ContinuidadClient {
    
    /**
     * Obtiene la medida anterior almacenada en caso de existir
     * @param origen Tipo de remarcador en String.
     * @param timestamp timestamp en String.
     * @param numremarcador numero compuesto en [Número de Conversor] + [Id Remarcador en el conversor]
     * @return Continuidad
     */
    @Path("/anterior")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Continuidad getAnterior(@QueryParam("origen") String origen, @QueryParam("timestamp") String timestamp, @QueryParam("numremarcador") Integer numremarcador);
    
    
    /**
     * Publica una continuidad en la tabla CONTINUIDAD.
     * @param continuidad Continuidad.
     * @return 
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Continuidad postContinuidad(Continuidad continuidad);
    
    @Path("/diario")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public ContinuidadDiario postContinuidadDiario(Continuidad continuidad);
    
    @Path("/mensual")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public ContinuidadMensual postContinuidadMensual(Continuidad continuidad);
    
}
