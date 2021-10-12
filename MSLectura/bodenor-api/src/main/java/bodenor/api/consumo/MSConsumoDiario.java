package bodenor.api.consumo;

import bodenor.api.com.CustomDateDeserializer;
import bodenor.api.com.CustomDateSerializer;
import bodenor.api.com.CustomDateTimeDeserializer;
import bodenor.api.com.CustomDateTimeSerializer;
import bodenor.api.com.Util;
import bodenor.api.comuna.model.Comuna;
import bodenor.api.consumo.model.Bodega;
import bodenor.api.consumo.model.Cliente;
import bodenor.api.consumo.model.ConsumoDiario;
import bodenor.api.consumo.model.ConsumoDiarioResponse;
import bodenor.api.consumo.model.ConsumoMensual;
import bodenor.api.consumo.model.ConsumoMensualResponse;
import bodenor.api.consumo.model.Empalme;
import bodenor.api.consumo.model.Instalacion;
import bodenor.api.consumo.model.Lectura;
import bodenor.api.provincia.model.Provincia;
import bodenor.api.region.model.Region;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.lt;
import com.mongodb.client.model.Sorts;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
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
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/bodenor/consumodiario")
public class MSConsumoDiario {

	@Inject
	MongoClient mongoClient;

	@Inject
	@RestClient
	ConsumoMensualClient consumoMensualClient;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ConsumoDiario postConsumoDiario(ConsumoDiario consumo) {
		System.out.println("Entra a postConsumoDiario");
		GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
		builder.registerTypeAdapter(LocalDate.class, new CustomDateSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateDeserializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeDeserializer());

		Gson gson = builder.create();
		String json = gson.toJson(consumo);
		Document doc = Document.parse(json);
		getCollection().insertOne(doc);

		//Postear Consumo Mensual
		//Al crear un nuevo consumo diario, evaluar si se debe crear un nuevo consumo mensual o pisar un existente
		Integer numRemarcador = consumo.getNumRemarcador();
		Integer anio = consumo.getAnio();
		Integer mes = consumo.getMes();

		procesarConsumoMensual(numRemarcador, anio, mes, consumo);
		return consumo;
	}

	@PATCH
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ConsumoDiario patchConsumoDiario(ConsumoDiarioResponse consumoDiarioResponse) {
		System.out.println("Entra a patchConsumoDiario");
		GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
		builder.registerTypeAdapter(LocalDate.class, new CustomDateSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeSerializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateDeserializer());
		builder.registerTypeAdapter(LocalDateTime.class, new CustomDateTimeDeserializer());

		Gson gson = builder.create();

		Document document = Document.parse(gson.toJson(consumoDiarioResponse.getConsumoDiario()));
		String idString = consumoDiarioResponse.getIdString();

		document.remove("_id");
		getCollection().replaceOne(Filters.eq("_id", new ObjectId(idString)), document);

		Integer numRemarcador = consumoDiarioResponse.getConsumoDiario().getNumRemarcador();
		Integer anio = consumoDiarioResponse.getConsumoDiario().getAnio();
		Integer mes = consumoDiarioResponse.getConsumoDiario().getMes();

		procesarConsumoMensual(numRemarcador, anio, mes, consumoDiarioResponse.getConsumoDiario());
		return new ConsumoDiario();
	}

	private ConsumoMensual procesarConsumoMensual(Integer numRemarcador, Integer anio, Integer mes, ConsumoDiario consumo) {

		ConsumoMensualResponse response = consumoMensualClient.getLastConsumoMensual(numRemarcador, anio, mes);
		String idString = response.getIdString();
		if (response.getConsumoMensual() == null) { //No existe un anterior. Se intenta crear
			System.out.println("No encuentra consumo mensual anterior. No existe ninguno.");
			ConsumoMensual consumoMensual = new ConsumoMensual();
			//ConsumoDiario consumo = consumoDiarioResponse.getConsumoDiario();
			consumoMensual.setAnio(consumo.getAnio());
			consumoMensual.setClienteActual(consumo.getClienteActual());
			consumoMensual.setDemandaMaxima(consumo.getDemandaMaxima());
			consumoMensual.setDemandaMaximaHoraPunta(consumo.getDemandaMaximaHoraPunta());
			consumoMensual.setEmpalme(consumo.getEmpalme());
			consumoMensual.setEnergiaConsumidaTotal(consumo.getLastLectura().getDelta());
			consumoMensual.setIdRemarcador(consumo.getIdRemarcador());
			consumoMensual.setPrimeraLectura(consumo.getLastLectura());
			consumoMensual.setUltimaLectura(consumo.getLastLectura());
			consumoMensual.setMarca(consumo.getMarca());
			consumoMensual.setMes(consumo.getMes());
			consumoMensual.setModelo(consumo.getModelo());
			consumoMensual.setModulos(consumo.getModulos());
			consumoMensual.setNumRemarcador(consumo.getNumRemarcador());
			consumoMensual.setNumSerie(consumo.getNumSerie());
			consumoMensual.setPromedioDemanda(consumo.getPromedioDemanda());
			consumoMensual.setPromedioDemandaHoraPunta(consumo.getPromedioDemandaHoraPunta());

			consumoMensualClient.postConsumoMensual(consumoMensual);
			return consumoMensual;
		} else { //Existe un anterior
			System.out.println("Existe un consumo mensual anterior.");
			ConsumoMensual lastConsumoMensual = response.getConsumoMensual();
			//ConsumoDiario consumo = consumoDiarioResponse.getConsumoDiario();
			if (lastConsumoMensual.getAnio().intValue() == consumo.getAnio().intValue() && lastConsumoMensual.getMes().intValue() == consumo.getMes().intValue()) { //Es el mismo mes
				System.out.println("Es el mismo mes que el mes del consumo diario que viene llegando");
				ConsumoMensual newConsumoMensual = new ConsumoMensual();
				newConsumoMensual.setAnio(lastConsumoMensual.getAnio());
				newConsumoMensual.setClienteActual(consumo.getClienteActual());

				if (lastConsumoMensual.getDemandaMaxima() != null) {
					newConsumoMensual.setDemandaMaxima(lastConsumoMensual.getDemandaMaxima());
					if (consumo.getDemandaMaxima() != null) {
						if (consumo.getDemandaMaxima() > lastConsumoMensual.getDemandaMaxima()) {
							System.out.println("Hay demanda mayor que la existente.");
							newConsumoMensual.setDemandaMaxima(consumo.getDemandaMaxima());
						} else {
							newConsumoMensual.setDemandaMaxima(lastConsumoMensual.getDemandaMaxima());
						}
					}
				} else {
					if (consumo.getDemandaMaxima() != null) {
						newConsumoMensual.setDemandaMaxima(consumo.getDemandaMaxima());
					}
				}

				if (consumo.getLastLectura().getHh() >= 18 && consumo.getLastLectura().getHh() <= 23) {
					if (lastConsumoMensual.getDemandaMaximaHoraPunta() != null) {
						if (consumo.getDemandaMaximaHoraPunta() != null && consumo.getDemandaMaximaHoraPunta() > lastConsumoMensual.getDemandaMaximaHoraPunta()) {
							newConsumoMensual.setDemandaMaximaHoraPunta(consumo.getDemandaMaximaHoraPunta());
						} else {
							newConsumoMensual.setDemandaMaximaHoraPunta(lastConsumoMensual.getDemandaMaximaHoraPunta());
						}
					} else {
						newConsumoMensual.setDemandaMaximaHoraPunta(consumo.getDemandaMaximaHoraPunta());
					}
				} else {
					newConsumoMensual.setDemandaMaximaHoraPunta(lastConsumoMensual.getDemandaMaximaHoraPunta());
				}

				newConsumoMensual.setEmpalme(consumo.getEmpalme());
				newConsumoMensual.setEnergiaConsumidaTotal(consumo.getLastLectura().getDelta() + lastConsumoMensual.getEnergiaConsumidaTotal());
				newConsumoMensual.setIdRemarcador(consumo.getIdRemarcador());
				newConsumoMensual.setMarca(consumo.getMarca());
				newConsumoMensual.setMes(consumo.getMes());
				newConsumoMensual.setModelo(consumo.getModelo());
				newConsumoMensual.setModulos(consumo.getModulos());
				newConsumoMensual.setNumRemarcador(consumo.getNumRemarcador());
				newConsumoMensual.setNumSerie(consumo.getNumSerie());
				newConsumoMensual.setPrimeraLectura(lastConsumoMensual.getPrimeraLectura());

				//Promedios------------
				List<ConsumoDiario> consumosDiariosMes = getConsumosDiariosMes(consumo.getNumRemarcador(), consumo.getAnio(), consumo.getMes());
				Double sumaDemanda = 0.0d;
				Double cuentaDemanda = 0.0d;

				Double sumaDemandaHoraPunta = 0.0d;
				Double cuentaDemandaHoraPunta = 0.0d;

				for (ConsumoDiario c : consumosDiariosMes) {
					if(c.getPromedioDemanda() != null){
						sumaDemanda += c.getPromedioDemanda();
						cuentaDemanda++;
					}
					
					if (c.getDemandaMaximaHoraPunta() != null) {
						sumaDemandaHoraPunta += c.getPromedioDemandaHoraPunta();
						cuentaDemandaHoraPunta++;
					}
					
				}

				if (cuentaDemanda > 0) {
					newConsumoMensual.setPromedioDemanda(sumaDemanda / cuentaDemanda);
				}
				if (cuentaDemandaHoraPunta > 0) {
					newConsumoMensual.setPromedioDemandaHoraPunta(sumaDemandaHoraPunta / cuentaDemandaHoraPunta);
				}
				newConsumoMensual.setUltimaLectura(consumo.getLastLectura());
				System.out.println("El ID que sale: " + idString);
				consumoMensualClient.patchConsumoMensual(new ConsumoMensualResponse(newConsumoMensual, idString));
				return newConsumoMensual;

			} else {//Es un mes anterior
				System.out.println("Es un mes anterior al del consumo diario");
				//Se debe ir a postear un nuevo consumoMensual
				ConsumoMensual consumoMensual = new ConsumoMensual();
				consumoMensual.setAnio(consumo.getAnio());
				consumoMensual.setClienteActual(consumo.getClienteActual());
				consumoMensual.setDemandaMaxima(consumo.getDemandaMaxima());
				consumoMensual.setDemandaMaximaHoraPunta(consumo.getDemandaMaximaHoraPunta());
				consumoMensual.setEmpalme(consumo.getEmpalme());
				consumoMensual.setEnergiaConsumidaTotal(consumo.getLastLectura().getDelta());
				consumoMensual.setIdRemarcador(consumo.getIdRemarcador());
				consumoMensual.setPrimeraLectura(consumo.getLastLectura());
				consumoMensual.setUltimaLectura(consumo.getLastLectura());
				consumoMensual.setMarca(consumo.getMarca());
				consumoMensual.setMes(consumo.getMes());
				consumoMensual.setModelo(consumo.getModelo());
				consumoMensual.setModulos(consumo.getModulos());
				consumoMensual.setNumRemarcador(consumo.getNumRemarcador());
				consumoMensual.setNumSerie(consumo.getNumSerie());
				consumoMensual.setPromedioDemanda(consumo.getPromedioDemanda());
				consumoMensual.setPromedioDemandaHoraPunta(consumo.getPromedioDemandaHoraPunta());
				consumoMensualClient.postConsumoMensual(consumoMensual);
				return consumoMensual;
			}
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/last/{numremarcador}/{fechaBusqueda}")
	public ConsumoDiarioResponse getLastConsumoDiario(@PathParam("numremarcador") Integer numRemarcador, @PathParam("fechaBusqueda") String fechaBusqueda) {
		MongoCollection<Document> colectionConsumoDiario = getCollection();

		Document lastConsumo = colectionConsumoDiario.find(Filters.and(eq("numRemarcador", numRemarcador), eq("fecha", fechaBusqueda))).sort(Sorts.descending("fecha")).first();
		if (lastConsumo == null) { //En caso de no encontrar uno para la fecha que se pide, se devuelve el anterior (Fecha distinta anterior).
			lastConsumo = colectionConsumoDiario.find(Filters.and(eq("numRemarcador", numRemarcador), lt("fecha", fechaBusqueda))).sort(Sorts.descending("fecha")).first();
			//return new ConsumoDiario();
			if (lastConsumo == null) {//Si no encuentra nada, devuelve un consumo diario en blanco
				return new ConsumoDiarioResponse();
			}
		}
		/*
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("numRemarcador", numRemarcador);
        whereQuery.put("fecha", fechaBusqueda);
		 */
		ConsumoDiario last = new ConsumoDiario();

		//last.setId(lastConsumo.getObjectId("_id").toString());
		last.setId(lastConsumo.getObjectId("_id"));
		LocalDate fecha = LocalDate.parse(lastConsumo.getString("fecha"));

		last.setFecha(fecha);
		last.setAnio(lastConsumo.getInteger("anio"));
		last.setMes(lastConsumo.getInteger("mes"));
		last.setDia(lastConsumo.getInteger("dia"));

		Cliente c = new Cliente();

		Document cli = lastConsumo.get("clienteActual", Document.class);

		c.setIdCliente(cli.getInteger("idCliente"));

		c.setRutCliente(cli.getInteger("rutCliente"));
		c.setDvCliente(cli.getString("dvCliente"));
		c.setNomCliente(cli.getString("nomCliente"));
		c.setRazonCliente(cli.getString("razonCliente"));

		List<Document> lecturas = lastConsumo.getList("lecturas", Document.class);
		LinkedList<Lectura> lecturasSalida = new LinkedList();
		for (Document l : lecturas) {
			//lecturasSalida.add(l);
			Lectura newLec = new Lectura();
			newLec.setTime(LocalDateTime.parse(l.getString("time").replace(" ", "T")));
			newLec.setFecha(LocalDate.parse(l.getString("fecha")));
			newLec.setAnio(l.getInteger("anio"));
			newLec.setMes(l.getInteger("mes"));
			newLec.setDia(l.getInteger("dia"));
			newLec.setHh(l.getInteger("hh"));
			newLec.setMm(l.getInteger("mm"));
			newLec.setSs(l.getInteger("ss"));
			newLec.setDelta(l.getDouble("delta"));
			newLec.setLectura(l.getDouble("lectura"));
			newLec.setManual(l.getBoolean("manual"));

			newLec.setPotencia(l.getDouble("potencia"));
			Document documentClienteLectura = l.get("cliente", Document.class);
			Cliente clienteLectura = new Cliente(
					documentClienteLectura.getInteger("idCliente"),
					documentClienteLectura.getInteger("rutCliente"),
					documentClienteLectura.getString("dvCliente"),
					documentClienteLectura.getString("nomCliente"),
					documentClienteLectura.getString("razonCliente")
			);
			newLec.setCliente(clienteLectura);
			lecturasSalida.add(newLec);
		}

		last.setLecturas(lecturasSalida);

		last.setEnergiaConsumidaTotal(lastConsumo.getDouble("energiaConsumidaTotal"));
		last.setDemandaMaxima(lastConsumo.getDouble("demandaMaxima"));
		last.setDemandaMaximaHoraPunta(lastConsumo.getDouble("demandaMaximaHoraPunta"));
		last.setPromedioDemanda(lastConsumo.getDouble("promedioDemanda"));
		last.setPromedioDemandaHoraPunta(lastConsumo.getDouble("promedioDemandaHoraPunta"));
		last.setIdRemarcador(lastConsumo.getInteger("idRemarcador"));
		last.setNumRemarcador(lastConsumo.getInteger("numRemarcador"));
		last.setModulos(lastConsumo.getString("modulos"));
		last.setNumSerie(lastConsumo.getString("numSerie"));
		last.setMarca(lastConsumo.getString("marca"));
		last.setModelo(lastConsumo.getString("modelo"));
		last.setEstado(lastConsumo.getInteger("estado"));

		last.setClienteActual(c);

		Empalme e = new Empalme();

		Document emp = lastConsumo.get("empalme", Document.class);
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

		Lectura lastLectura = new Lectura();

		Document lastLec = lastConsumo.get("lastLectura", Document.class);
		lastLectura.setTime(LocalDateTime.parse(lastLec.getString("time").replace(" ", "T")));
		lastLectura.setAnio(lastLec.getInteger("anio"));
		lastLectura.setMes(lastLec.getInteger("mes"));
		lastLectura.setDia(lastLec.getInteger("dia"));
		lastLectura.setHh(lastLec.getInteger("hh"));
		lastLectura.setMm(lastLec.getInteger("mm"));
		lastLectura.setSs(lastLec.getInteger("ss"));
		lastLectura.setFecha(LocalDate.parse(lastLec.getString("fecha")));
		lastLectura.setLectura(lastLec.getDouble("lectura"));
		lastLectura.setPotencia(lastLec.getDouble("potencia"));
		lastLectura.setManual(lastLec.getBoolean("manual"));

		last.setLastLectura(lastLectura);

		Lectura lastLecturaValida = new Lectura();

		Document lastLecValid = lastConsumo.get("lastLecturaValida", Document.class);
		lastLecturaValida.setTime(LocalDateTime.parse(lastLecValid.getString("time").replace(" ", "T")));
		lastLecturaValida.setAnio(lastLecValid.getInteger("anio"));
		lastLecturaValida.setMes(lastLecValid.getInteger("mes"));
		lastLecturaValida.setDia(lastLecValid.getInteger("dia"));
		lastLecturaValida.setHh(lastLecValid.getInteger("hh"));
		lastLecturaValida.setMm(lastLecValid.getInteger("mm"));
		lastLecturaValida.setSs(lastLecValid.getInteger("ss"));
		lastLecturaValida.setFecha(LocalDate.parse(lastLecValid.getString("fecha")));
		lastLecturaValida.setLectura(lastLecValid.getDouble("lectura"));
		lastLecturaValida.setPotencia(lastLecValid.getDouble("potencia"));
		lastLecturaValida.setManual(lastLecValid.getBoolean("manual"));

		last.setLastLecturaValida(lastLecturaValida);
		System.out.println("el ID de la last: " + last.getId());
		ConsumoDiarioResponse response = new ConsumoDiarioResponse(last, last.getId().toString());
		return response;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{numremarcador}/{anio}/{mes}")
	public List<ConsumoDiario> getConsumosDiariosMes(@PathParam("numremarcador") Integer numRemarcador, @PathParam("anio") Integer anio, @PathParam("mes") Integer mes) {
		FindIterable<Document> documentConsumosDiariosAnioMes = getCollection().find(Filters.and(eq("numRemarcador", numRemarcador), eq("anio", anio), eq("mes", mes))).sort(Sorts.ascending("fecha"));
		List<ConsumoDiario> consumosDiariosAnioMes = new ArrayList();

		MongoCursor cursor = documentConsumosDiariosAnioMes.cursor();
		while (cursor.hasNext()) {
			Document doc = (Document) cursor.next();
			ConsumoDiario consumo = new ConsumoDiario();
			consumo.setAnio(doc.getInteger("anio"));
			consumo.setDemandaMaxima(doc.getDouble("demandaMaxima"));
			consumo.setDemandaMaximaHoraPunta(doc.getDouble("demandaMaximaHoraPunta"));
			consumo.setDia(doc.getInteger("dia"));
			consumo.setEnergiaConsumidaTotal(doc.getDouble("energiaConsumidaTotal"));
			LocalDate fecha = LocalDate.parse(doc.getString("fecha"));
			consumo.setFecha(fecha);
			consumo.setId(doc.getObjectId("_id"));
			consumo.setIdRemarcador(doc.getInteger("idRemarcador"));
			consumo.setMarca(doc.getString("marca"));
			consumo.setMes(doc.getInteger("mes"));
			consumo.setModelo(doc.getString("modelo"));
			consumo.setModulos(doc.getString("modulos"));
			consumo.setNumRemarcador(doc.getInteger("numRemarcador"));
			consumo.setNumSerie(doc.getString("numSerie"));
			consumo.setPromedioDemanda(doc.getDouble("promedioDemanda"));
			consumo.setPromedioDemandaHoraPunta(doc.getDouble("promedioDemandaHoraPunta"));

			consumosDiariosAnioMes.add(consumo);
		}

		return consumosDiariosAnioMes;
	}

	private MongoCollection getCollection() {
		return mongoClient.getDatabase("bodenor").getCollection("ConsumoDiario");
	}

}
