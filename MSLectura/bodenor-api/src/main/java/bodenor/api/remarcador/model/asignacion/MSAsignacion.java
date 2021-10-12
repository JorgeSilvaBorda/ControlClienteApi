/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.remarcador.model.asignacion;

import bodenor.api.remarcador.model.asignacion.model.Asignacion;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jorge
 */
@Path("/api/bodenor/remarcador/asignacion")
public class MSAsignacion {
    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Asignacion> getAsignaciones() {
        //String query = "SELECT A FROM CLIREMPAR A JOIN A.cliente C JOIN A.remarcador R ORDER BY timestamp(A.fechaasignacion) DESC, time(A.fechaasignacion) DESC";
        String query = "SELECT A FROM CLIREMPAR A INNER JOIN FETCH A.remarcador INNER JOIN FETCH A.cliente C ORDER BY time(A.fechaasignacion) DESC";
        //String query = "SELECT C FROM CLIREMPAR A, C FROM CLIENTE C where A.cliente = C";
        return manager.createQuery(query, Asignacion.class).getResultList();
        //return manager.createNamedQuery(Remarcador.findAll, Remarcador.class).getResultList();
    }
    @Path("/{idremarcador}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Asignacion> getAsignacionesIdRemarcador(@PathParam("idremarcador") Integer idremarcador) {
        String query = "SELECT A FROM CLIREMPAR A WHERE A.remarcador.idremarcador = " + idremarcador + " ORDER BY time(A.fechaasignacion) DESC";
        return manager.createQuery(query, Asignacion.class).getResultList();
    }
    
    @Path("/{idremarcador}/{anio}/{mes}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Asignacion getAsignacionesIdRemarcadorAnioMes(@PathParam("idremarcador") Integer idremarcador, @PathParam("anio") Integer anio, @PathParam("mes") Integer mes) {
        String query = "SELECT A FROM CLIREMPAR A WHERE A.remarcador.idremarcador = " + idremarcador + " AND year(A.fechaasignacion) <= " + anio + " AND month(A.fechaasignacion) <= " + mes + " AND A.tipo = 'ASIGNACION' ORDER BY A.idasignacion DESC";
        System.out.println("Query: " + query);
        //Asignacion asignacion = new Asignacion();
        List<Asignacion> asignaciones =  manager.createQuery(query, Asignacion.class).getResultList();
        if(asignaciones.size() > 0){
            return asignaciones.get(0);
        }else{
            return new Asignacion();
        }
    }
    
    @Path("/last/{idRemarcador}/{fechaConsulta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Asignacion getAsignacionesIdRemarcadorAnioMes(@PathParam("idRemarcador") Integer idRemarcador, LocalDate fechaConsulta) {
        String query = "SELECT A FROM CLIREMPAR A WHERE A.remarcador.idremarcador = " + idRemarcador + " AND A.fechaasignacion <= '" + fechaConsulta + "' ORDER BY A.idasignacion DESC";
        System.out.println("Query: " + query);
        //Asignacion asignacion = new Asignacion();
        List<Asignacion> asignaciones =  manager.createQuery(query, Asignacion.class).getResultList();
        if(asignaciones.size() > 0){
            return asignaciones.get(0);
        }else{
            return new Asignacion();
        }
    }
}
