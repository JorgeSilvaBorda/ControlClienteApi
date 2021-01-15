package api.controlcliente;

import api.controlcliente.model.ContactoCliente;
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

@Path("/contactocliente")
public class ContactoClienteResource {
    @Inject
    EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ContactoCliente> getContactosCliente() {
        return manager.createQuery("SELECT CC FROM CONTACTO CC JOIN CC.cliente", ContactoCliente.class).getResultList();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ContactoCliente getContactoCliente(@PathParam("id") Long id) {
        return manager.createQuery("SELECT CC FROM CONTACTO CC JOIN CC.cliente WHERE CC.idcontactocliente = " + id, ContactoCliente.class).getResultList().get(0);
    }
    
}