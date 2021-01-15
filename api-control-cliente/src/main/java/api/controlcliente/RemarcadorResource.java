package api.controlcliente;

import api.controlcliente.model.Empalme;
import api.controlcliente.model.Remarcador;
import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/remarcador")
public class RemarcadorResource {
    @Inject
    EntityManager manager;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Remarcador> getRemarcadores() {
        return manager.createQuery("SELECT R FROM REMARCADOR R JOIN R.empalme JOIN R.bodega", Remarcador.class).getResultList();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Remarcador getRemarcador(@PathParam("id") Long id) {
        return manager.createQuery("SELECT R FROM REMARCADOR R JOIN R.empalme JOIN R.bodega WHERE R.idremarcador = " + id, Remarcador.class).getResultList().get(0);
    }
}