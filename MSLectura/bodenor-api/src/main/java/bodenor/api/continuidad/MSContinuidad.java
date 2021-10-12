/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.continuidad;

import bodenor.api.continuidad.model.Continuidad;
import bodenor.api.continuidad.model.ContinuidadDiario;
import bodenor.api.continuidad.model.ContinuidadMensual;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Microservicio Continuidad [MSContinuidad]
 *
 * @author Jorge Silva Borda.
 */
@Path("/api/bodenor/continuidad")
public class MSContinuidad {

    @Inject
    private EntityManager manager;

    /**
     * Obtiene un registro de continuidad registrado inmediatamente anterior al
     * que viene ingresando.
     *
     * @param origen Tipo de remarcador
     * @param timestamp String con el timestamp que viene de linux Normalmente
     * crontab desde una shell.
     * @param numremarcador Integer con el número compuesto que viene de la
     * shell. Se compome de NUMCONVERSOR + IDREMARCADOR_EN_CONVERSOR
     * @return Continuidad
     */
    @Path("/anterior")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Continuidad getAnterior(@QueryParam("origen") String origen, @QueryParam("timestamp") String timestamp, @QueryParam("numremarcador") Integer numremarcador) {
        System.out.println("Entra a buscar continuidad");

        //DateTimeFormatter formatterTimestamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("MSContinuidad Recibe: " + "[origen:" + origen + "]" + "[timestamp:" + timestamp + "]" + "[numremarcador:" + numremarcador + "]");
        System.out.println("La fecha = " + timestamp);
        String query = "SELECT "
                + "C "
                + "FROM "
                + "CONTINUIDAD C "
                + "WHERE "
                + "C.origen = '" + origen + "' "
                + "AND C.timestamp < TIMESTAMP('" + timestamp + "') "
                + "AND C.numremarcador = " + numremarcador + " "
                + ""
                + "ORDER BY "
                + "C.timestamp DESC "
                + "";
        System.out.println(query);
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        if (resultado.size() == 0) {
            System.out.println("MSContinuidad: No existe anterior. Se devuelve new Continuidad()");
            return new Continuidad();
        } else {
            System.out.println("MSContinuidad: Existe anterior. Se devuelve.");
            return resultado.get(0);
        }

    }

    /**
     * Trae todas las lecturas de un determinado remarcador para el anio mes
     *
     * @return
     */
    @Path("/{numremarcador}/{anio}/{mes}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Continuidad> getContinuidadAnioMes(@PathParam("numremarcador") Integer numremarcador, @PathParam("anio") Integer anio, @PathParam("mes") Integer mes) {
        String query = "SELECT C FROM CONTINUIDAD C WHERE C.numremarcador = '" + numremarcador + "' AND C.anio = " + anio + " AND C.mes = " + mes + " ORDER BY C.timestamp ASC";
        System.out.println(query);
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        return resultado;
    }
    
    /**
     * Trae todas las lecturas de un determinado remarcador para el anio mes dia
     *
     * @return
     */
    @Path("/{numremarcador}/{anio}/{mes}/{dia}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Continuidad> getContinuidadAnioMesDia(@PathParam("numremarcador") Integer numremarcador, @PathParam("anio") Integer anio, @PathParam("mes") Integer mes, @PathParam("dia") Integer dia) {
        String query = "SELECT C FROM CONTINUIDAD C WHERE C.numremarcador = '" + numremarcador + "' AND C.anio = " + anio + " AND C.mes = " + mes + " AND C.dia = " + dia + " ORDER BY C.timestamp ASC";
        System.out.println(query);
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        return resultado;
    }

    /**
     * Trae todas las lecturas de un determinado REMARCADOR EN rango de fechas
     *
     * @return
     */
    @Path("/{numremarcador}/{fechadesde}/{fechahasta}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Continuidad> getContinuidadFechas(@PathParam("numremarcador") Integer numremarcador, @PathParam("fechadesde") String fechadesde, @PathParam("fechahasta") String fechahasta) {
        String query = "SELECT C FROM CONTINUIDAD C WHERE C.numremarcador = '" + numremarcador + "' AND (C.fecha >= '" + fechadesde + "' AND C.fecha <= '" + fechahasta + "') ORDER BY C.timestamp ASC";
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        return resultado;
    }

    /**
     * No consumir. Las trae todas
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Continuidad> getContinuidades() {
        String query = "SELECT C FROM CONTINUIDAD C";
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        return resultado;
    }

    /**
     * Trae todas las continuidades de los circutor
     *
     * @return
     */
    @Path("/circutorcvmC10")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Continuidad> getContinuidadesCircutor() {
        String query = "SELECT C FROM CONTINUIDAD C WHERE C.origen = 'circutorcvmC10'";
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        return resultado;
    }
    
    /**
     * Trae todas las lecturas de los SchneiderPM710
     *
     * @return
     */
    @Path("/schneiderPM5300")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Continuidad> getContinuidadesSchneiderPM5300() {
        String query = "SELECT C FROM CONTINUIDAD C WHERE C.origen = 'schneiderPM5300'";
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        return resultado;
    }

    /**
     * Trae todas las lecturas de los SchneiderPM710
     *
     * @return
     */
    @Path("/schneiderPM710")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Continuidad> getContinuidadesSchneiderPM710() {
        String query = "SELECT C FROM CONTINUIDAD C WHERE C.origen = 'schneiderPM710'";
        List<Continuidad> resultado = manager.createQuery(query, Continuidad.class).getResultList();
        return resultado;
    }

    // POST ------------------------------------------------------------------------------------------------------------
    

    /**
     * Publica una continuidad.
     *
     * @param continuidad Continuidad.
     * @return Continuidad publicada.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Continuidad postContinuidad(Continuidad continuidad) {
        System.out.println("Entra a insertar la continuidad");
        System.out.println("Continuidad a insertar: " + continuidad.toCsv());
        manager.persist(continuidad);
        return continuidad;
    }
    
    @Path("/diario")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public ContinuidadDiario postContinuidadDiario(Continuidad continuidad) {
        //Recibe continuidad previamente guardada y va a pisar la diaria
        ContinuidadDiario cd = new ContinuidadDiario();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String query = "SELECT CD FROM CONTINUIDADDIARIO CD WHERE CD.anio = " + continuidad.getAnio() + " AND CD.mes = " + continuidad.getMes() + " AND CD.dia = " + continuidad.getDia() + " AND CD.numremarcador = " + continuidad.getNumremarcador();
        List<ContinuidadDiario> continuidadesDiario = manager.createQuery(query, ContinuidadDiario.class).getResultList();

        if (continuidadesDiario.size() == 0) {
            //En caso de no existir, se asume que es la primera del mes y se crea una nueva.
            cd.setAnio(continuidad.getAnio());
            cd.setMes(continuidad.getMes());
            cd.setDia(continuidad.getDia());
            cd.setNumremarcador(continuidad.getNumremarcador());

            cd.setLecturarealini(continuidad.getLecturareal());
            cd.setLecturaproyectadaini(continuidad.getLecturaproyectada());
            cd.setTimelecturaini(continuidad.getTimestamp());
            cd.setMaxpotencia(continuidad.getPotencia());
            cd.setPrompotencia(continuidad.getPotencia());
            
            cd.setLecturarealfin(continuidad.getLecturareal());
            cd.setLecturaproyectadafin(continuidad.getLecturaproyectada());
            cd.setTimelecturafin(continuidad.getTimestamp());

            
            LocalDateTime time = LocalDateTime.parse(continuidad.getTimestamp(), formatter);

            //Horas punta:
            int hh = time.getHour();
            if (hh >= 18 && hh <= 23) {
                cd.setMaxpotenciahpunta(continuidad.getPotencia());
                cd.setPrompotenciahpunta(continuidad.getPotencia());
            }
            
            manager.persist(cd);
            return cd;

        } else { //Si ya hay una, la traemos para ajustar los valore actuales.
            ContinuidadDiario continuidadDiario = continuidadesDiario.get(0);
            //primero traemos las del día para calcular promedios y máximos.
            query = "SELECT C FROM CONTINUIDAD C WHERE C.anio = " + continuidad.getAnio() + " AND C.mes = " + continuidad.getMes() + "AND C.dia = " + continuidad.getDia() + " AND C.numremarcador = " + continuidad.getNumremarcador() + " ORDER BY timestamp(C.timestamp) ASC ";
            List<Continuidad> continuidadesDia = manager.createQuery(query, Continuidad.class).getResultList();

            Double prompotencia;
            Double prompotenciahpunta;
            Double maxpotencia = 0.0;
            Double maxpotenciahpunta = 0.0;
            int cantpotenciashpunta = 0;

            Double sumapotencias = 0.0;
            Double sumapotenciashpunta = 0.0;

            for (int i = 0; i < continuidadesDia.size(); i++) {
                sumapotencias += continuidadesDia.get(i).getPotencia();
                LocalDateTime time = LocalDateTime.parse(continuidadesDia.get(i).getTimestamp(), formatter);
                if (continuidadesDia.get(i).getPotencia() > maxpotencia) {
                    maxpotencia = continuidadesDia.get(i).getPotencia();
                }
                //Horas punta:
                int hh = time.getHour();
                if (hh >= 18 && hh <= 23) {
                    cantpotenciashpunta++;
                    sumapotenciashpunta++;
                    if (continuidadesDia.get(i).getPotencia() > maxpotenciahpunta) {
                        maxpotenciahpunta = continuidadesDia.get(i).getPotencia();
                    }
                }
            }
            if (cantpotenciashpunta > 0) {
                prompotenciahpunta = sumapotenciashpunta / cantpotenciashpunta;
                cd.setPrompotenciahpunta(prompotenciahpunta);
            }

            prompotencia = sumapotencias / continuidadesDia.size();

            cd.setAnio(continuidad.getAnio());
            cd.setMes(continuidad.getMes());
            cd.setDia(continuidad.getDia());
            cd.setNumremarcador(continuidad.getNumremarcador());

            cd.setTimelecturaini(continuidadDiario.getTimelecturaini());
            cd.setLecturarealini(continuidadDiario.getLecturarealini());
            cd.setLecturaproyectadaini(continuidadDiario.getLecturaproyectadaini());
            cd.setLecturarealfin(continuidad.getLecturareal());
            cd.setLecturaproyectadafin(continuidad.getLecturaproyectada());
            cd.setPrompotencia(prompotencia);
            cd.setMaxpotencia(maxpotencia);
            cd.setMaxpotenciahpunta(maxpotenciahpunta);

            cd.setTimelecturafin(continuidad.getTimestamp());

        }

        manager.merge(cd);
        return cd;
    }

    @Path("/mensual")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public ContinuidadMensual postContinuidadMensual(Continuidad continuidad) {
        //Recibe continuidad previamente guardada y va a pisar la mensual
        ContinuidadMensual cm = new ContinuidadMensual();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String query = "SELECT CM FROM CONTINUIDADMENSUAL CM WHERE CM.anio = " + continuidad.getAnio() + " AND CM.mes = " + continuidad.getMes() + " AND CM.numremarcador = " + continuidad.getNumremarcador();
        List<ContinuidadMensual> continuidadesMensual = manager.createQuery(query, ContinuidadMensual.class).getResultList();

        if (continuidadesMensual.size() == 0) {
            //En caso de no existir, se asume que es la primera del mes y se crea una nueva.
            cm.setAnio(continuidad.getAnio());
            cm.setMes(continuidad.getMes());
            cm.setNumremarcador(continuidad.getNumremarcador());

            cm.setLecturarealini(continuidad.getLecturareal());
            cm.setLecturaproyectadaini(continuidad.getLecturaproyectada());
            cm.setTimelecturaini(continuidad.getTimestamp());
            cm.setMaxpotencia(continuidad.getPotencia());
            cm.setPrompotencia(continuidad.getPotencia());
            
            cm.setLecturarealfin(continuidad.getLecturareal());
            cm.setLecturaproyectadafin(continuidad.getLecturaproyectada());
            cm.setTimelecturafin(continuidad.getTimestamp());

            
            LocalDateTime time = LocalDateTime.parse(continuidad.getTimestamp(), formatter);

            //Horas punta:
            int hh = time.getHour();
            if (hh >= 18 && hh <= 23) {
                cm.setMaxpotenciahpunta(continuidad.getPotencia());
                cm.setPrompotenciahpunta(continuidad.getPotencia());
            }
            
            manager.persist(cm);
            return cm;

        } else { //Si ya hay una, la traemos para ajustar los valore actuales.
            ContinuidadMensual continuidadMensual = continuidadesMensual.get(0);
            //primero traemos las del mes para calcular promedios y máximos.
            query = "SELECT C FROM CONTINUIDAD C WHERE C.anio = " + continuidad.getAnio() + " AND C.mes = " + continuidad.getMes() + " AND C.numremarcador = " + continuidad.getNumremarcador() + " ORDER BY timestamp(C.timestamp) ASC ";
            List<Continuidad> continuidadesMes = manager.createQuery(query, Continuidad.class).getResultList();

            Double prompotencia;
            Double prompotenciahpunta;
            Double maxpotencia = 0.0;
            Double maxpotenciahpunta = 0.0;
            int cantpotenciashpunta = 0;

            Double sumapotencias = 0.0;
            Double sumapotenciashpunta = 0.0;

            for (int i = 0; i < continuidadesMes.size(); i++) {
                sumapotencias += continuidadesMes.get(i).getPotencia();
                LocalDateTime time = LocalDateTime.parse(continuidadesMes.get(i).getTimestamp(), formatter);
                if (continuidadesMes.get(i).getPotencia() > maxpotencia) {
                    maxpotencia = continuidadesMes.get(i).getPotencia();
                }
                //Horas punta:
                int hh = time.getHour();
                if (hh >= 18 && hh <= 23) {
                    cantpotenciashpunta++;
                    sumapotenciashpunta++;
                    if (continuidadesMes.get(i).getPotencia() > maxpotenciahpunta) {
                        maxpotenciahpunta = continuidadesMes.get(i).getPotencia();
                    }
                }
            }
            if (cantpotenciashpunta > 0) {
                prompotenciahpunta = sumapotenciashpunta / cantpotenciashpunta;
                cm.setPrompotenciahpunta(prompotenciahpunta);
            }

            prompotencia = sumapotencias / continuidadesMes.size();

            cm.setAnio(continuidad.getAnio());
            cm.setMes(continuidad.getMes());
            cm.setNumremarcador(continuidad.getNumremarcador());

            cm.setTimelecturaini(continuidadMensual.getTimelecturaini());
            cm.setLecturarealini(continuidadMensual.getLecturarealini());
            cm.setLecturaproyectadaini(continuidadMensual.getLecturaproyectadaini());
            cm.setLecturarealfin(continuidad.getLecturareal());
            cm.setLecturaproyectadafin(continuidad.getLecturaproyectada());
            cm.setPrompotencia(prompotencia);
            cm.setMaxpotencia(maxpotencia);
            cm.setMaxpotenciahpunta(maxpotenciahpunta);

            cm.setTimelecturafin(continuidad.getTimestamp());

        }

        manager.merge(cm);
        return cm;
    }

}
