package bodenor.api.boleta;

import bodenor.api.boleta.model.Boleta;
import bodenor.api.boleta.model.DetalleBoleta;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/boleta")
public class MSBoleta {

    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Boleta> getBoletas() {
        String query = "SELECT B FROM HIST_BOLETA B";
        return manager.createQuery(query, Boleta.class).getResultList();
    }

    @Path("/detalle/{idboleta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetalleBoleta> getDetallesBoletas(@PathParam("idboleta") Integer idboleta) {
        String query = "SELECT DB FROM HIST_DETALLE_BOLETA DB JOIN DB.boleta B WHERE B.idboleta = " + idboleta;
        return manager.createQuery(query, DetalleBoleta.class).getResultList();
    }
}
