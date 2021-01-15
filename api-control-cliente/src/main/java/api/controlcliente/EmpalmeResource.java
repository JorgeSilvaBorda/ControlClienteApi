package api.controlcliente;

import api.controlcliente.model.Empalme;
import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/empalme")
public class EmpalmeResource {
    @Inject
    EntityManager manager;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Empalme> getEmpalmes() {
        return manager.createQuery("SELECT E FROM EMPALME E JOIN E.instalacion I JOIN E.bodega B", Empalme.class).getResultList();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empalme getEmpalme(@PathParam("id") Long id) {
        return manager.createQuery("SELECT E FROM EMPALME E JOIN E.instalacion I JOIN E.bodega B WHERE E.idempalme = " + id, Empalme.class).getResultList().get(0);
    }
}
