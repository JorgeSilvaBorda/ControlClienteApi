/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.remarcador;

import bodenor.api.remarcador.model.Remarcador;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author jorge
 */
@RegisterRestClient(configKey = "config.api.bodenor")
@Path("/remarcador")
public interface RemarcadorClient {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Remarcador> getRemarcadores();
    
    @Path("/idempalme/{idempalme}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Remarcador> getRemarcadoresIdEmpalme(@PathParam("idempalme") Integer idempalme);
    
    @Path("/numempalme/{numempalme}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Remarcador> getRemarcadoresNumEmpalme(@PathParam("numempalme") String numempalme);

    @Path("/{idremarcador}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Remarcador getRemarcadorIdRemarcador(@PathParam("idremarcador") Integer idremarcador);
    
    @Path("/numremarcador/{numremarcador}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Remarcador getRemarcadorNumRemarcador(@PathParam("numremarcador") Integer numremarcador);
}
