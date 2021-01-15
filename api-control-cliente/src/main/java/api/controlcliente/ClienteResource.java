package api.controlcliente;

import api.controlcliente.model.Cliente;
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

@Path("/cliente")
public class ClienteResource {
    @Inject
    EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Cliente> getClientes() {
        return manager.createQuery("SELECT C FROM CLIENTE C", Cliente.class).getResultList();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getCliente(@PathParam("id") Long id) {
        return manager.createQuery("SELECT C FROM CLIENTE C WHERE C.idcliente = " + id, Cliente.class).getResultList().get(0);
    }
    
}