package bodenor.api.instalacion;

import bodenor.api.instalacion.model.Instalacion;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/instalacion")
public class MSInstalacion {
    
    @Inject
    private EntityManager manager;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Instalacion> getInstalaciones(){
        String query = "SELECT I FROM INSTALACION I JOIN I.comuna C JOIN C.provincia P JOIN P.region R";
        return manager.createQuery(query, Instalacion.class).getResultList();
    }
    
    @Path("/{idinstalacion}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Instalacion getInstalacionIdInstalacion(@PathParam("idinstalacion") Integer idinstalacion){
        String query = "SELECT I FROM INSTALACION I JOIN I.comuna C JOIN C.provincia P JOIN P.region R WHERE I.idinstalacion = " + idinstalacion;
        List<Instalacion> instalaciones = manager.createQuery(query, Instalacion.class).getResultList();
        if(instalaciones.size() < 1){
            return new Instalacion();
        }else{
            return instalaciones.get(0);
        }
    }
    
}
