package bodenor.api.cliente.contacto;

import bodenor.api.cliente.contacto.model.Contacto;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/cliente/contacto")
public class MSContacto {
    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contacto> getContacto() {
        String query = "SELECT C FROM CONTACTO C";
        return manager.createQuery(query, Contacto.class).getResultList();
    }

    @Path("/{idcontacto}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Contacto getContactoIcContacto(@PathParam("idcontacto") Integer idcontacto) {
        String query = "SELECT C FROM CONTACTO C WHERE C.idcontacto = " + idcontacto;
        List<Contacto> contactos = manager.createQuery(query, Contacto.class).getResultList();
        if (contactos.size() < 1) {
            return new Contacto();
        } else {
            return contactos.get(0);
        }
    }
}
