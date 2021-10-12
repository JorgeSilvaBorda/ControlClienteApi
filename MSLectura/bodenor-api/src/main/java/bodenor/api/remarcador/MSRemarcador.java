package bodenor.api.remarcador;

import bodenor.api.remarcador.model.Remarcador;
import bodenor.api.remarcador.model.asignacion.AsignacionClient;
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
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/bodenor/remarcador")
public class MSRemarcador {

    @Inject
    @RestClient
    AsignacionClient asignacionClient;

    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Remarcador> getRemarcadores() {
        String query = "SELECT R FROM REMARCADOR R JOIN R.asignaciones A ORDER BY R.numremarcador ASC, time(A.fechaasignacion) DESC";
        return manager.createQuery(query, Remarcador.class).getResultList();
        //return manager.createNamedQuery(Remarcador.findAll, Remarcador.class).getResultList();
    }

    @Path("/asignaciones")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Asignacion> getAsignaciones() {
        String query = "SELECT CRP FROM CLIREMPAR CRP";
        return manager.createQuery(query, Asignacion.class).getResultList();
        //return manager.createNamedQuery(Remarcador.findAll, Remarcador.class).getResultList();
    }

    @Path("/numremarcador/{numremarcador}/momento/{anio}/{mes}")
    //@Path("/numremarcador/21/momento/2021/3")

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Remarcador getAsignacionMomento(@PathParam("numremarcador") Integer numremarcador, @PathParam("anio") Integer anio, @PathParam("mes") Integer mes) {
        System.out.println("Entra");
        String query = "SELECT R FROM REMARCADOR R WHERE R.numremarcador = " + numremarcador;
        Remarcador remarcador = manager.createQuery(query, Remarcador.class).getResultList().get(0);
        System.out.println("Remarcador: " + remarcador.getIdremarcador());
        Asignacion asignacion = asignacionClient.getAsignacionesIdRemarcadorAnioMes(Integer.parseInt(remarcador.getIdremarcador().toString()), anio, mes);
        System.out.println("Asignacion: " + asignacion.getIdasignacion());
        List<Asignacion> asignaciones = new ArrayList<>();
        asignaciones.add(asignacion);
        remarcador.setAsignaciones(asignaciones);

        return remarcador;
        //return manager.createNamedQuery(Remarcador.findAll, Remarcador.class).getResultList();
    }

    @Path("/idempalme/{idempalme}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Remarcador> getRemarcadoresIdEmpalme(@PathParam("idempalme") Integer idempalme) {
        String query = "SELECT R FROM REMARCADOR R JOIN R.empalme E WHERE E.idempalme = " + idempalme;
        return manager.createQuery(query, Remarcador.class).getResultList();
    }

    @Path("/numempalme/{numempalme}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Remarcador> getRemarcadoresNumEmpalme(@PathParam("numempalme") String numempalme) {
        String query = "SELECT R FROM REMARCADOR R JOIN R.empalme E WHERE E.numempalme = '" + numempalme + "'";
        return manager.createQuery(query, Remarcador.class).getResultList();
    }

    @Path("/{idremarcador}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Remarcador getRemarcadorIdRemarcador(@PathParam("idremarcador") Integer idremarcador) {
        String query = "SELECT R FROM REMARCADOR R WHERE R.idremarcador = " + idremarcador;
        List<Remarcador> remarcadores = manager.createQuery(query, Remarcador.class).getResultList();
        if (remarcadores.size() < 1) {
            return new Remarcador();
        } else {
            return remarcadores.get(0);
        }
    }

    @Path("/numremarcador/{numremarcador}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Remarcador getRemarcadorNumRemarcador(@PathParam("numremarcador") Integer numremarcador) {
        String query = "SELECT R FROM REMARCADOR R WHERE R.numremarcador = " + numremarcador;
        List<Remarcador> remarcadores = manager.createQuery(query, Remarcador.class).getResultList();
        if (remarcadores.size() < 1) {
            return new Remarcador();
        } else {
            return remarcadores.get(0);
        }
    }
}
