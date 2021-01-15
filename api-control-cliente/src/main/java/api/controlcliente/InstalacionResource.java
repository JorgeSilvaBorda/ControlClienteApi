package api.controlcliente;

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
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

@Path("/instalacion")
public class InstalacionResource {
    @Inject
    EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Instalacion> getInstalaciones() {
        return manager.createQuery("SELECT I FROM INSTALACION I JOIN I.comuna C JOIN C.provincia D JOIN D.region R", Instalacion.class).getResultList();
    }
    
    @GET
    @Path("/{idinstalacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Instalacion getInstalacion(@PathParam("idinstalacion") Long id) {
        return manager.createQuery("SELECT I FROM INSTALACION I JOIN I.comuna C JOIN C.provincia D JOIN D.region R WHERE I.idinstalacion = " + id, Instalacion.class).getResultList().get(0);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Instalacion insInstalacion(Instalacion instalacion) {
        manager.persist(instalacion);
        return instalacion;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Instalacion updInstalacion(Instalacion instalacion) {
        Instalacion ant = manager.find(Instalacion.class, instalacion.getIdinstalacion());
        ant.setComuna(instalacion.getComuna());
        ant.setDireccion(instalacion.getDireccion());
        ant.setNominstalacion(instalacion.getNominstalacion());
        manager.merge(ant);
        return ant;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{idinstalacion}")
    @Transactional
    public Instalacion delInstalacion(@PathParam("idinstalacion") Long idinstalacion) {
        Instalacion i = manager.find(Instalacion.class, idinstalacion);
        manager.remove(i);
        return i;
    }
}