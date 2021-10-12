
package bodenor.api.empalme;

import bodenor.api.empalme.model.Empalme;
import bodenor.api.remarcador.model.Remarcador;
import bodenor.api.remarcador.model.asignacion.model.Asignacion;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/empalme")
public class MSEmpalme {

    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empalme> getEmpalmes() {
        String query = "SELECT E FROM EMPALME E";
        return manager.createQuery(query, Empalme.class).getResultList();
    }

    @Path("/remarcadores")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empalme> getEmpalmesRemarcadores() {
        String query = "SELECT E FROM EMPALME E JOIN E.remarcadores RES JOIN RES.asignaciones";
        return manager.createQuery(query, Empalme.class).getResultList();
    }

    @Path("/{numempalme}/remarcadores/lastasignacion")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Empalme getEmpalmeRemarcadoresNumempalme(@PathParam("numempalme") String numempalme) {
        String query = "SELECT E FROM EMPALME E JOIN E.remarcadores RES JOIN RES.asignaciones ASI JOIN ASI.cliente C WHERE E.numempalme = '" + numempalme + "' ORDER BY E.numempalme ASC, RES.numremarcador ASC, timestamp(ASI.fechaasignacion) DESC";
        List<Empalme> empalmes = manager.createQuery(query, Empalme.class).getResultList();

        List<Asignacion> lastasignaciones = new ArrayList<>();
        Asignacion definitiva = new Asignacion();
        definitiva.setIdasignacion(0);
        if (empalmes.size() > 0) {
            Empalme salida = empalmes.get(0);
            return salida;
        } else {
            return new Empalme();
        }

    }
    
    @Path("/{idempalme}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Empalme getEmpalmeIdEmpalme(@PathParam("idempalme") Integer idempalme) {
        String query = "SELECT E FROM EMPALME E WHERE E.idempalme = " + idempalme;
        List<Empalme> empalmes = manager.createQuery(query, Empalme.class).getResultList();
        if (empalmes.size() < 1) {
            return new Empalme();
        } else {
            return empalmes.get(0);
        }
    }
    
    @Path("/{numempalme}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Empalme getEmpalmeNumEmpalme(@PathParam("numempalme") String numempalme) {
        String query = "SELECT E FROM EMPALME E WHERE E.numempalme = " + numempalme;
        List<Empalme> empalmes = manager.createQuery(query, Empalme.class).getResultList();
        if (empalmes.size() < 1) {
            return new Empalme();
        } else {
            return empalmes.get(0);
        }
    }
}
