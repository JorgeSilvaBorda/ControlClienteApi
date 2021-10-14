package bodenor.api.lectura.legado;

import bodenor.api.lectura.legado.model.CircutorCVMC10;
import bodenor.api.lectura.legado.model.SchneiderPM5300;
import bodenor.api.lectura.legado.model.SchneiderPM710;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/lecturalegado")
public class MSLecturaLegado {

	@Inject
	EntityManager manager;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public CircutorCVMC10 postLecturaCircutorLegado(CircutorCVMC10 remarcador) {
		System.out.println("Entra a postear Lectura Legado CircutorCVMC10");
		manager.persist(remarcador);
		
		return (CircutorCVMC10) remarcador;

	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public SchneiderPM5300 postLecturaSchneiderPM5300Legado(SchneiderPM5300 remarcador) {
		System.out.println("Entra a postear Lectura Legado SchneiderPM5300");
		manager.persist((SchneiderPM5300) remarcador);
		return (SchneiderPM5300) remarcador;

	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public SchneiderPM710 postLecturaSchneiderPM710Legado(SchneiderPM710 remarcador) {
		System.out.println("Entra a postear Lectura Legado SchneiderPM710");
		manager.persist((SchneiderPM710) remarcador);
		return (SchneiderPM710) remarcador;

	}

}
