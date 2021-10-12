
import bodenor.api.instalacion.model.Instalacion;
import bodenor.api.region.model.Region;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/region")
public class MSRegion {

    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Region> getRegiones() {
        String query = "SELECT R FROM REGION R";
        return manager.createQuery(query, Region.class).getResultList();
    }

    @Path("/{idregion}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Region getRegionIdRegion(@PathParam("idregion") Integer idregion) {
        String query = "SELECT R FROM REGION R WHERE R.idregion = " + idregion;
        List<Region> regiones = manager.createQuery(query, Region.class).getResultList();
        if (regiones.size() < 1) {
            return new Region();
        } else {
            return regiones.get(0);
        }
    }
}
