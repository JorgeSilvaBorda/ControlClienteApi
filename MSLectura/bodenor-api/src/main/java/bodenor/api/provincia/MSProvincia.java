package bodenor.api.provincia;

import bodenor.api.provincia.model.Provincia;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/provincia")
public class MSProvincia {

    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Provincia> getProvincias() {
        String query = "SELECT P FROM PROVINCIA P";
        return manager.createQuery(query, Provincia.class).getResultList();
    }

    @Path("/{idprovincia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Provincia getProvinciaIdProvincia(@PathParam("idprovincia") Integer idprovincia) {
        String query = "SELECT P FROM PROVINCIA P WHERE P.idprovincia = " + idprovincia;
        List<Provincia> provincias = manager.createQuery(query, Provincia.class).getResultList();
        if (provincias.size() < 1) {
            return new Provincia();
        } else {
            return provincias.get(0);
        }
    }
}