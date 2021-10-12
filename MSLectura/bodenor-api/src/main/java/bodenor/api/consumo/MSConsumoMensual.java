package bodenor.api.consumo;

import bodenor.api.com.CustomDateDeserializer;
import bodenor.api.com.CustomDateSerializer;
import bodenor.api.com.CustomDateTimeDeserializer;
import bodenor.api.com.CustomDateTimeSerializer;
import bodenor.api.comuna.model.Comuna;
import bodenor.api.consumo.model.Bodega;
import bodenor.api.consumo.model.Cliente;
import bodenor.api.consumo.model.ConsumoMensual;
import bodenor.api.consumo.model.ConsumoMensualResponse;
import bodenor.api.consumo.model.Empalme;
import bodenor.api.consumo.model.Instalacion;
import bodenor.api.consumo.model.Lectura;
import bodenor.api.provincia.model.Provincia;
import bodenor.api.region.model.Region;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;
import com.mongodb.client.model.Sorts;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.bson.Document;
import org.bson.types.ObjectId;

@Path("/api/bodenor/consumomensual")
public class MSConsumoMensual {
    @Inject
    MongoClient mongoClient;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ConsumoMensual postConsumoMensual(ConsumoMensual consumo) {
		System.out.println("Entra a postConsumoMensual");
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        builder.registerTypeAdapter(LocalDate.class, new CustomDateSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateDeserializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeDeserializer());

        Gson gson = builder.create();
        String json = gson.toJson(consumo);
        Document doc = Document.parse(json);
        getCollection().insertOne(doc);
        //consumo.setId(id);
        return consumo;
    }
    
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ConsumoMensual patchConsumoMensual(ConsumoMensualResponse consumoMensualResponse) {
		System.out.println("Entra a patchConsumoMensual");
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        builder.registerTypeAdapter(LocalDate.class, new CustomDateSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateDeserializer());
        builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeDeserializer());

        Gson gson = builder.create();
        
        Document document = Document.parse(gson.toJson(consumoMensualResponse.getConsumoMensual()));
		//System.out.println(document.toJson());
        String idString = consumoMensualResponse.getIdString();

        document.remove("_id");
		System.out.println("El ID que llega a patch: " + consumoMensualResponse.getIdString());
        getCollection().replaceOne(Filters.eq("_id", new ObjectId(idString)), document);
        return new ConsumoMensual();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/last/{numremarcador}/{anio}/{mes}")
    public ConsumoMensualResponse getLastConsumoMensual(@PathParam("numremarcador") Integer numRemarcador, @PathParam("anio") Integer anioBusqueda, @PathParam("mes") Integer mesBusqueda) {
		System.out.println("Entra a getLastConsumoMensual");
        MongoCollection<Document> colectionConsumoMensual = getCollection();
        
        Document documentLastConsumo = colectionConsumoMensual.find(Filters.and(eq("numRemarcador", numRemarcador), eq("anio", anioBusqueda), eq("mes", mesBusqueda))).sort(Sorts.descending("anio", "mes")).first();
        if (documentLastConsumo == null) { //En caso de no encontrar uno para la fecha que se pide, se devuelve el anterior (Fecha distinta anterior).
            documentLastConsumo = colectionConsumoMensual.find(Filters.and(eq("numRemarcador", numRemarcador), Filters.or(lt("mes", mesBusqueda), lt("anio", anioBusqueda)))).sort(Sorts.descending("anio", "mes")).first();
            //return new ConsumoDiario();
            if (documentLastConsumo == null) {//Si no encuentra nada, devuelve un consumo diario en blanco
                return new ConsumoMensualResponse();
            }
        }

        ConsumoMensual last = new ConsumoMensual();

        last.setId(documentLastConsumo.getObjectId("_id"));
        last.setAnio(documentLastConsumo.getInteger("anio"));
        last.setMes(documentLastConsumo.getInteger("mes"));
        
        Cliente c = new Cliente();

        Document documentClienteLecturaActual = documentLastConsumo.get("clienteActual", Document.class);

        c.setIdCliente(documentClienteLecturaActual.getInteger("idCliente"));

        c.setRutCliente(documentClienteLecturaActual.getInteger("rutCliente"));
        c.setDvCliente(documentClienteLecturaActual.getString("dvCliente"));
        c.setNomCliente(documentClienteLecturaActual.getString("nomCliente"));
        c.setRazonCliente(documentClienteLecturaActual.getString("razonCliente"));
        
        last.setEnergiaConsumidaTotal(documentLastConsumo.getDouble("energiaConsumidaTotal"));
        last.setDemandaMaxima(documentLastConsumo.getDouble("demandaMaxima"));
        last.setDemandaMaximaHoraPunta(documentLastConsumo.getDouble("demandaMaximaHoraPunta"));
        last.setPromedioDemanda(documentLastConsumo.getDouble("promedioDemanda"));
        last.setPromedioDemandaHoraPunta(documentLastConsumo.getDouble("promedioDemandaHoraPunta"));
        last.setIdRemarcador(documentLastConsumo.getInteger("idRemarcador"));
        last.setNumRemarcador(documentLastConsumo.getInteger("numRemarcador"));
        last.setModulos(documentLastConsumo.getString("modulos"));
        last.setNumSerie(documentLastConsumo.getString("numSerie"));
        last.setMarca(documentLastConsumo.getString("marca"));
        last.setModelo(documentLastConsumo.getString("modelo"));
        
        last.setClienteActual(c);

        Empalme e = new Empalme();

        Document emp = documentLastConsumo.get("empalme", Document.class);
        e.setIdEmpalme(emp.getInteger("idEmpalme"));
        e.setNumEmpalme(emp.getString("numEmpalme"));

        Bodega b = new Bodega();

        Document bod = emp.get("bodega", Document.class);

        b.setIdBodega(bod.getInteger("idBodega"));
        b.setNomBodega(bod.getString("nomBodega"));

        e.setBodega(b);

        Instalacion i = new Instalacion();

        Document ins = emp.get("instalacion", Document.class);
        i.setIdInstalacion(ins.getInteger("idInstalacion"));
        i.setNomInstalacion(ins.getString("nomInstalacion"));
        i.setDireccion(ins.getString("direccion"));

        Comuna comuna = new Comuna();

        Document com = ins.get("comuna", Document.class);

        comuna.setIdcomuna(com.getInteger("idcomuna").longValue());
        comuna.setNomcomuna(com.getString("nomcomuna"));

        Provincia provincia = new Provincia();

        Document prov = com.get("provincia", Document.class);
        provincia.setIdprovincia(prov.getInteger("idprovincia").longValue());
        provincia.setNomprovincia(prov.getString("nomprovincia"));

        Region region = new Region();

        Document reg = prov.get("region", Document.class);
        region.setAbreviatura(reg.getString("abrebiatura"));
        region.setIdregion(reg.getInteger("idregion").intValue());
        region.setNomregion(reg.getString("nomregion"));
        region.setCapital(reg.getString("capital"));

        provincia.setRegion(region);
        comuna.setProvincia(provincia);
        i.setComuna(comuna);
        e.setInstalacion(i);

        last.setEmpalme(e);
        
        Lectura primeraLectura = new Lectura();

        Document documentPrimeraLectura = documentLastConsumo.get("primeraLectura", Document.class);
        primeraLectura.setTime(LocalDateTime.parse(documentPrimeraLectura.getString("time").replace(" ", "T")));
        primeraLectura.setAnio(documentPrimeraLectura.getInteger("anio"));
        primeraLectura.setMes(documentPrimeraLectura.getInteger("mes"));
        primeraLectura.setDia(documentPrimeraLectura.getInteger("dia"));
        primeraLectura.setHh(documentPrimeraLectura.getInteger("hh"));
        primeraLectura.setMm(documentPrimeraLectura.getInteger("mm"));
        primeraLectura.setSs(documentPrimeraLectura.getInteger("ss"));
        primeraLectura.setFecha(LocalDate.parse(documentPrimeraLectura.getString("fecha")));
        primeraLectura.setLectura(documentPrimeraLectura.getDouble("lectura"));
        primeraLectura.setPotencia(documentPrimeraLectura.getDouble("potencia"));
		primeraLectura.setDelta(documentPrimeraLectura.getDouble("delta"));

		Cliente cPrimeraLectura = new Cliente();
		Document documentClientePrimeraLectura = documentPrimeraLectura.get("cliente", Document.class);
		cPrimeraLectura.setDvCliente(documentClientePrimeraLectura.getString("dvCliente"));
		cPrimeraLectura.setIdCliente(documentClientePrimeraLectura.getInteger("idCliente"));
		cPrimeraLectura.setNomCliente(documentClientePrimeraLectura.getString("nomCliente"));
		cPrimeraLectura.setRazonCliente(documentClientePrimeraLectura.getString("razonCliente"));
		cPrimeraLectura.setRutCliente(documentClientePrimeraLectura.getInteger("rutCliente"));
		
		primeraLectura.setCliente(cPrimeraLectura);
		
        last.setPrimeraLectura(primeraLectura);

        Lectura ultimaLectura = new Lectura();

        Document documentUltimaLectura = documentLastConsumo.get("ultimaLectura", Document.class);
        ultimaLectura.setTime(LocalDateTime.parse(documentUltimaLectura.getString("time").replace(" ", "T")));
        ultimaLectura.setAnio(documentUltimaLectura.getInteger("anio"));
        ultimaLectura.setMes(documentUltimaLectura.getInteger("mes"));
        ultimaLectura.setDia(documentUltimaLectura.getInteger("dia"));
        ultimaLectura.setHh(documentUltimaLectura.getInteger("hh"));
        ultimaLectura.setMm(documentUltimaLectura.getInteger("mm"));
        ultimaLectura.setSs(documentUltimaLectura.getInteger("ss"));
        ultimaLectura.setFecha(LocalDate.parse(documentUltimaLectura.getString("fecha")));
        ultimaLectura.setLectura(documentUltimaLectura.getDouble("lectura"));
        ultimaLectura.setPotencia(documentUltimaLectura.getDouble("potencia"));

        last.setUltimaLectura(ultimaLectura);
        //ConsumoMensualResponse response = new ConsumoMensualResponse(last, last.getId().toString());
		//bodenor.api.com.Util.imprimirClaseJson(response);
		System.out.println("El ID del ultimo consumo mensual: " + last.getId().toString());
        return new ConsumoMensualResponse(last, last.getId().toString());
    }
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/last/{numremarcador}/{anio}/{mes}/idstring")
    public String getLastConsumoMensualIdString(@PathParam("numremarcador") Integer numRemarcador, @PathParam("anio") Integer anioBusqueda, @PathParam("mes") Integer mesBusqueda) {
		System.out.println("Entra a getLastConsumoMensual");
        MongoCollection<Document> colectionConsumoMensual = getCollection();
        Document lastConsumo = colectionConsumoMensual.find(Filters.and(eq("numRemarcador", numRemarcador), eq("anio", anioBusqueda), eq("mes", mesBusqueda))).sort(Sorts.descending("anio", "mes")).first();
        if (lastConsumo == null) {
            lastConsumo = colectionConsumoMensual.find(Filters.and(eq("numRemarcador", numRemarcador), Filters.or(lt("mes", mesBusqueda), lt("anio", anioBusqueda)))).sort(Sorts.descending("anio", "mes")).first();
            if (lastConsumo == null) {
                return new String();
            }
        }

        return lastConsumo.getObjectId("_id").toString();

    }
    
    private MongoCollection getCollection() {
        return mongoClient.getDatabase("bodenor").getCollection("ConsumoMensual");
    }
}
