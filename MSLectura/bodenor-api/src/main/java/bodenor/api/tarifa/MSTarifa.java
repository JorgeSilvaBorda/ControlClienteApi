package bodenor.api.tarifa;

import bodenor.api.com.CustomDateDeserializer;
import bodenor.api.com.CustomDateSerializer;
import bodenor.api.com.CustomDateTimeDeserializer;
import bodenor.api.com.CustomDateTimeSerializer;
import bodenor.api.comuna.model.Comuna;
import bodenor.api.provincia.model.Provincia;
import bodenor.api.region.model.Region;
import bodenor.api.tarifa.model.Detalle;
import bodenor.api.tarifa.model.Tarifa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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

@Path("/api/bodenor/tarifa")
public class MSTarifa {

	@Inject
	MongoClient mongoClient;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Tarifa postTarifa(Tarifa tarifa) {
		GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
		builder.registerTypeAdapter(LocalDate.class, new CustomDateSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateDeserializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeDeserializer());

		Gson gson = builder.create();
		String json = gson.toJson(tarifa);
		Document doc = Document.parse(json);
		getCollection().insertOne(doc);
		return new Tarifa();
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Tarifa patchTarifa(Tarifa tarifa) {
		Tarifa t = getTarifaNomTarifaIdComuna(tarifa.getNomTarifa(), tarifa.getComuna().getIdcomuna());
		if (t == null) {
			return new Tarifa();
		}

		GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
		builder.registerTypeAdapter(LocalDate.class, new CustomDateSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateDeserializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeDeserializer());

		Gson gson = builder.create();

		Document document = Document.parse(gson.toJson(tarifa));
		//System.out.println(document.toJson());

		getCollection().replaceOne(Filters.eq("_id", tarifa.getId()), document);
		return tarifa;
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{idTarifa}")
	public Tarifa addDetalleTarifa(@PathParam("idTarifa") String idTarifa, Detalle detalle) {
		Document docTarifa = (Document) getCollection().find(new Document("_id", new ObjectId(idTarifa))).first();
		System.out.println(docTarifa);
		
		if (docTarifa.isEmpty()) {
			return new Tarifa();
		}
		List<Document> docDetalles = docTarifa.getList("detalles", Document.class);
		List<Detalle> detalles = new ArrayList();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		for (Document docDetalle : docDetalles) {
			Detalle d = new Detalle();
			d.setAccion(docDetalle.getString("accion"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaAA(docDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaAA"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaAS(docDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaAS"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaSA(docDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaSA"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaSS(docDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaSS"));
			d.setCargoDemandaMaximaPotenciaSuministradaAA(docDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaAA"));
			d.setCargoDemandaMaximaPotenciaSuministradaAS(docDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaAS"));
			d.setCargoDemandaMaximaPotenciaSuministradaSA(docDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaSA"));
			d.setCargoDemandaMaximaPotenciaSuministradaSS(docDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaSS"));
			d.setCargoEnergia(docDetalle.getDouble("cargoEnergia"));
			d.setCargoFijo(docDetalle.getDouble("cargoFijo"));
			d.setCargoServicioPublico(docDetalle.getDouble("cargoServicioPublico"));
			d.setTimeCreacion(LocalDateTime.parse(docDetalle.getString("timeCreacion").replace(" ", "T")));
			d.setTimeDesde(LocalDateTime.parse(docDetalle.getString("timeDesde").replace(" ", "T")));
			if (docDetalle.getString("timeHasta") == null) {
				LocalDateTime now = LocalDateTime.now();
				d.setTimeHasta(now);
				detalle.setTimeDesde(now);
				detalle.setTimeCreacion(now);
				detalle.setTimeHasta(null);
				detalle.setAccion("Reemplazo");
			}
			d.setTransporteElectricidad(docDetalle.getDouble("transporteElectricidad"));
			detalles.add(d);
		}
		detalles.add(detalle);

		Tarifa t = new Tarifa();
		Comuna c = new Comuna();
		Document documentComuna = docTarifa.get("comuna", Document.class);
		c.setIdcomuna(documentComuna.getInteger("idcomuna").longValue());
		c.setNomcomuna(documentComuna.getString("nomcomuna"));
		Document documentProvincia = documentComuna.get("provincia", Document.class);
		Provincia p = new Provincia();
		p.setIdprovincia(documentProvincia.getInteger("idprovincia").longValue());
		p.setNomprovincia(documentProvincia.getString("nomprovincia"));
		Document documentRegion = documentProvincia.get("region", Document.class);
		Region r = new Region();
		r.setIdregion(documentRegion.getInteger("idregion"));
		r.setNomregion(documentRegion.getString("nomregion"));
		r.setCapital(documentRegion.getString("capital"));
		r.setAbreviatura(documentRegion.getString("abreviatura"));
		p.setRegion(r);
		c.setProvincia(p);
		t.setComuna(c);

		t.setDetalles(detalles);

		t.setId(null);
		t.setNomTarifa(docTarifa.getString("nomTarifa"));

		GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
		builder.registerTypeAdapter(LocalDate.class, new CustomDateSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateDeserializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeDeserializer());

		Gson gson = builder.create();

		Document document = Document.parse(gson.toJson(t));
		//System.out.println(document.toJson());

		getCollection().replaceOne(Filters.eq("_id", new ObjectId(idTarifa)), document);
		return t;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tarifa> getTarifas() {
		MongoCollection<Document> CollectionTarifa = getCollection();
		FindIterable<Document> documentosTarifa = CollectionTarifa.find();
		List<Tarifa> tarifas = new ArrayList();
		MongoCursor cursor = documentosTarifa.cursor();
		while (cursor.hasNext()) {
			Document documentTarifa = (Document) cursor.next();
			Tarifa t = new Tarifa();
			Comuna c = new Comuna();
			Document documentComuna = documentTarifa.get("comuna", Document.class);
			c.setIdcomuna(documentComuna.getInteger("idcomuna").longValue());
			c.setNomcomuna(documentComuna.getString("nomcomuna"));
			Document documentProvincia = documentComuna.get("provincia", Document.class);
			Provincia p = new Provincia();
			p.setIdprovincia(documentProvincia.getInteger("idprovincia").longValue());
			p.setNomprovincia(documentProvincia.getString("nomprovincia"));
			Document documentRegion = documentProvincia.get("region", Document.class);
			Region r = new Region();
			r.setIdregion(documentRegion.getInteger("idregion"));
			r.setNomregion(documentRegion.getString("nomregion"));
			r.setCapital(documentRegion.getString("capital"));
			r.setAbreviatura(documentRegion.getString("abreviatura"));
			p.setRegion(r);
			c.setProvincia(p);
			t.setComuna(c);

			List<Document> documentDetalles = documentTarifa.getList("detalles", Document.class);
			List<Detalle> detalles = new ArrayList();
			for (Document documentDetalle : documentDetalles) {
				Detalle d = new Detalle();
				d.setAccion(documentDetalle.getString("accion"));
				d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaAA(documentDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaAA"));
				d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaAS(documentDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaAS"));
				d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaSA(documentDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaSA"));
				d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaSS(documentDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaSS"));
				d.setCargoDemandaMaximaPotenciaSuministradaAA(documentDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaAA"));
				d.setCargoDemandaMaximaPotenciaSuministradaAS(documentDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaAS"));
				d.setCargoDemandaMaximaPotenciaSuministradaSA(documentDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaSA"));
				d.setCargoDemandaMaximaPotenciaSuministradaSS(documentDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaSS"));
				d.setCargoEnergia(documentDetalle.getDouble("cargoEnergia"));
				d.setCargoFijo(documentDetalle.getDouble("cargoFijo"));
				d.setCargoServicioPublico(documentDetalle.getDouble("cargoServicioPublico"));
				d.setTimeCreacion(LocalDateTime.parse(documentDetalle.getString("timeCreacion").replace(" ", "T")));
				d.setTimeDesde(LocalDateTime.parse(documentDetalle.getString("timeDesde").replace(" ", "T")));
				d.setTimeHasta(LocalDateTime.parse(documentDetalle.getString("timeHasta").replace(" ", "T")));
				d.setTransporteElectricidad(documentDetalle.getDouble("transporteElectricidad"));
				detalles.add(d);
			}

			t.setDetalles(detalles);

			t.setId(new ObjectId(documentTarifa.getObjectId("_id").toString()));
			t.setNomTarifa(documentTarifa.getString("nomTarifa"));
			tarifas.add(t);
		}
		if (tarifas.size() == 0) {
			return new ArrayList();
		}
		return tarifas;

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{nomtarifa}/{idcomuna}")
	public Tarifa getTarifaNomTarifaIdComuna(@PathParam("nomTarifa") String nomTarifa, Long idcomuna) {
		MongoCollection<Document> CollectionTarifa = getCollection();
		Document documentTarifa = CollectionTarifa.find(Filters.and(eq("nomTarifa", nomTarifa), eq("comuna.idcomuna", idcomuna))).first();
		if (documentTarifa == null) {
			return new Tarifa();
		}
		Tarifa t = new Tarifa();
		Comuna c = new Comuna();
		Document documentComuna = documentTarifa.get("comuna", Document.class);
		c.setIdcomuna(documentComuna.getLong("idcomuna"));
		c.setNomcomuna(documentComuna.getString("nomcomuna"));
		Document documentProvincia = documentComuna.get("provincia", Document.class);
		Provincia p = new Provincia();
		p.setIdprovincia(documentProvincia.getLong("idprovincia"));
		p.setNomprovincia(documentProvincia.getString("nomprovincia"));
		Document documentRegion = documentProvincia.get("region", Document.class);
		Region r = new Region();
		r.setIdregion(documentRegion.getInteger("idregion"));
		r.setNomregion(documentRegion.getString("nomregion"));
		r.setCapital(documentRegion.getString("capital"));
		r.setAbreviatura(documentRegion.getString("abreviatura"));
		p.setRegion(r);
		c.setProvincia(p);
		t.setComuna(c);

		List<Document> documentDetalles = documentTarifa.getList("detalles", Document.class);
		List<Detalle> detalles = new ArrayList();
		for (Document documentDetalle : documentDetalles) {
			Detalle d = new Detalle();
			d.setAccion(documentDetalle.getString("accion"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaAA(documentDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaAA"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaAS(documentDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaAS"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaSA(documentDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaSA"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaSS(documentDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaSS"));
			d.setCargoDemandaMaximaPotenciaSuministradaAA(documentDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaAA"));
			d.setCargoDemandaMaximaPotenciaSuministradaAS(documentDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaAS"));
			d.setCargoDemandaMaximaPotenciaSuministradaSA(documentDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaSA"));
			d.setCargoDemandaMaximaPotenciaSuministradaSS(documentDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaSS"));
			d.setCargoEnergia(documentDetalle.getDouble("cargoEnergia"));
			d.setCargoFijo(documentDetalle.getDouble("cargoFijo"));
			d.setCargoServicioPublico(documentDetalle.getDouble("cargoServicioPublico"));
			d.setTimeCreacion(LocalDateTime.parse(documentDetalle.getString("timeCreacion").replace(" ", "T")));
			d.setTimeDesde(LocalDateTime.parse(documentDetalle.getString("timeDesde").replace(" ", "T")));
			d.setTimeHasta(LocalDateTime.parse(documentDetalle.getString("timeHasta").replace(" ", "T")));
			d.setTransporteElectricidad(documentDetalle.getDouble("transporteElectricidad"));
			detalles.add(d);
		}

		t.setDetalles(detalles);

		t.setId(new ObjectId(documentTarifa.getObjectId("_id").toString()));
		t.setNomTarifa(documentTarifa.getString("nomTarifa"));

		return new Tarifa();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{idTarifa}")
	public List<Detalle> getDetallesTarifa(@PathParam("idTarifa") String idTarifa){
		Document docTarifa = (Document) getCollection().find(new Document("_id", new ObjectId(idTarifa))).first();
		Document docDetalles1 = docTarifa.get("detalles", Document.class);
		System.out.println(docDetalles1);
		
		if (docTarifa.isEmpty()) {
			return new ArrayList();
		}
		
		List<Document> docDetalles = docTarifa.getList("detalles", Document.class);
		
		List<Detalle> detalles = new ArrayList();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		for (Document docDetalle : docDetalles) {
			Detalle d = new Detalle();
			d.setAccion(docDetalle.getString("accion"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaAA(docDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaAA"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaAS(docDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaAS"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaSA(docDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaSA"));
			d.setCargoDemandaMaximaPotenciaLeidaHoraPuntaSS(docDetalle.getDouble("cargoDemandaMaximaPotenciaLeidaHoraPuntaSS"));
			d.setCargoDemandaMaximaPotenciaSuministradaAA(docDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaAA"));
			d.setCargoDemandaMaximaPotenciaSuministradaAS(docDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaAS"));
			d.setCargoDemandaMaximaPotenciaSuministradaSA(docDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaSA"));
			d.setCargoDemandaMaximaPotenciaSuministradaSS(docDetalle.getDouble("cargoDemandaMaximaPotenciaSuministradaSS"));
			d.setCargoEnergia(docDetalle.getDouble("cargoEnergia"));
			d.setCargoFijo(docDetalle.getDouble("cargoFijo"));
			d.setCargoServicioPublico(docDetalle.getDouble("cargoServicioPublico"));
			d.setTimeCreacion(LocalDateTime.parse(docDetalle.getString("timeCreacion").replace(" ", "T")));
			d.setTimeDesde(LocalDateTime.parse(docDetalle.getString("timeDesde").replace(" ", "T")));
			d.setTimeDesde(LocalDateTime.parse(docDetalle.getString("timeHasta").replace(" ", "T")));
			d.setTransporteElectricidad(docDetalle.getDouble("transporteElectricidad"));
			detalles.add(d);
		}
		
		return detalles;
	}

	private MongoCollection getCollection() {
		return mongoClient.getDatabase("bodenor").getCollection("Tarifa");
	}
}
