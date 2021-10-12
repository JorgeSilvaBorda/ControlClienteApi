package bodenor.api.comuna;

import bodenor.api.comuna.model.Comuna;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/comuna")
public class MSComuna {

    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comuna> getComuna() {
        String query = "SELECT C FROM COMUNA C";
        return manager.createQuery(query, Comuna.class).getResultList();
    }

    @Path("/{idcomuna}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Comuna getComunaIdComuna(@PathParam("idcomuna") Integer idcomuna) {
        String query = "SELECT C FROM COMUNA C WHERE C.idcomuna = " + idcomuna;
        List<Comuna> provincias = manager.createQuery(query, Comuna.class).getResultList();
        if (provincias.size() < 1) {
            return new Comuna();
        } else {
            return provincias.get(0);
        }
    }
}