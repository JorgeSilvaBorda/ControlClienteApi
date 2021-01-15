package api.controlcliente;

import api.controlcliente.model.Bodega;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import api.controlcliente.model.Instalacion;
import java.util.Collection;
import javax.ws.rs.PathParam;

@Path("/bodega")
public class BodegaResource {
    @Inject
    EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Bodega> getBodegas() {
        return manager.createQuery("SELECT I FROM PARQUE I JOIN I.instalacion C", Bodega.class).getResultList();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bodega getBodega(@PathParam("id") Long id) {
        return manager.createQuery("SELECT I FROM PARQUE I JOIN I.instalacion C WHERE I.idbodega = " + id, Bodega.class).getResultList().get(0);
    }
    
}