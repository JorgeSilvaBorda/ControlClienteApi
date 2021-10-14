package bodenor.api.lectura.legado;

import bodenor.api.lectura.legado.model.CircutorCVMC10;
import bodenor.api.lectura.legado.model.SchneiderPM5300;
import bodenor.api.lectura.legado.model.SchneiderPM710;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "config.api.bodenor")
@Path("/lecturalegado")
public interface LecturaLegadoClient {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public CircutorCVMC10 postLecturaCircutorLegado(CircutorCVMC10 remarcador);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public SchneiderPM5300 postLecturaSchneiderPM5300Legado(SchneiderPM5300 remarcador);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public SchneiderPM710 postLecturaSchneiderPM710Legado(SchneiderPM710 remarcador);
}
