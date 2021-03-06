package bodenor.api.lectura;

import bodenor.api.bodega.model.Bodega;
import bodenor.api.consumo.ConsumoDiarioClient;
import bodenor.api.consumo.model.Cliente;
import bodenor.api.consumo.model.ConsumoDiario;
import bodenor.api.consumo.model.ConsumoDiarioResponse;
import bodenor.api.empalme.model.Empalme;
import bodenor.api.instalacion.model.Instalacion;
import bodenor.api.lectura.legado.LecturaLegadoClient;
import bodenor.api.lectura.legado.model.CircutorCVMC10;
import bodenor.api.lectura.legado.model.SchneiderPM5300;
import bodenor.api.lectura.legado.model.SchneiderPM710;
import bodenor.api.lectura.model.Lectura;
import bodenor.api.lectura.model.LecturaCircutorCVMC10;
import bodenor.api.lectura.model.LecturaRemarcador;
import bodenor.api.lectura.model.LecturaSchneiderPM5300;
import bodenor.api.lectura.model.LecturaSchneiderPM710;
import bodenor.api.remarcador.RemarcadorClient;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/api/bodenor/lectura")
public class MSLectura {

	@Inject
	@RestClient
	ConsumoDiarioClient consumoDiarioClient;

	@Inject
	@RestClient
	RemarcadorClient remarcadorClient;

	@Inject
	@RestClient
	LecturaLegadoClient lecturaLegadoClient;

	@Path("/circutorcvmc10")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public ConsumoDiario postLecturaCircutorCVMC10(String contenido) {
		System.out.println("Entra CircutorCVMC10");
		Lectura lectura = Lectura.getLectura(contenido);

		if (contenido.contains("MANUAL[true]")) {
			System.out.println("Entra a lectura Manual");

			//Se procesa una lectura manual (sin potencia) que viene llegando.
			LecturaRemarcador lecturaRemarcador = new LecturaRemarcador();
			lecturaRemarcador.setAnio(lectura.getAnio());
			lecturaRemarcador.setCalculable(true);
			lecturaRemarcador.setDia(lectura.getDia());
			lecturaRemarcador.setManual(true);

			String regexp = "";
			Pattern pattern;
			Matcher matcher;

			regexp = "(LECTURA\\[)([0-9]{1,9})(\\])";
			pattern = Pattern.compile(regexp);
			matcher = pattern.matcher(contenido);
			if (matcher.find()) {
				lecturaRemarcador.setEnergia(Double.parseDouble(matcher.group(2)));
			}

			lecturaRemarcador.setNumRemarcador(lectura.getNumremarcador());
			lecturaRemarcador.setMes(lectura.getMes());
			lecturaRemarcador.setTimestamp(lectura.getTimestamp());
			lecturaRemarcador.setTipoRemarcador("circutorcvmc10");
			lecturaRemarcador.setFecha(lectura.getFecha());
			bodenor.api.com.Util.imprimirClaseJson(lecturaRemarcador);

			return procesarLecturaRemarcador(lecturaRemarcador);

		} else {

			if (!lectura.esProcesable()) {
				//No se puede procesar ni obtener la anterior.
				System.out.println("No se puede procesar la lectura");
				return new ConsumoDiario();
			}
			//Se extraen los campos de c??lculo de circutor desde el mensaje
			LecturaRemarcador lecturaRemarcador = LecturaCircutorCVMC10.parseItems(contenido, lectura).toLecturaRemarcador();
			//Activar este una vez se haya completado la migraci??n
			lecturaLegadoClient.postLecturaCircutorLegado(new CircutorCVMC10().fromLectura(LecturaCircutorCVMC10.parseItems(contenido, lectura)));
			return procesarLecturaRemarcador(lecturaRemarcador);
		}

	}

	@Path("/schneiderpm710")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public ConsumoDiario postLecturaSchneiderPM710(String contenido) {
		System.out.println("Entra SchneiderPM710");
		Lectura lectura = Lectura.getLectura(contenido);

		if (contenido.contains("MANUAL[true]")) {
			System.out.println("Entra a lectura Manual");

			//Se procesa una lectura manual (sin potencia) que viene llegando.
			LecturaRemarcador lecturaRemarcador = new LecturaRemarcador();
			lecturaRemarcador.setAnio(lectura.getAnio());
			lecturaRemarcador.setCalculable(true);
			lecturaRemarcador.setDia(lectura.getDia());
			lecturaRemarcador.setManual(true);

			String regexp = "";
			Pattern pattern;
			Matcher matcher;

			regexp = "(LECTURA\\[)([0-9]{1,9})(\\])";
			pattern = Pattern.compile(regexp);
			matcher = pattern.matcher(contenido);
			if (matcher.find()) {
				lecturaRemarcador.setEnergia(Double.parseDouble(matcher.group(2)));
			}

			lecturaRemarcador.setNumRemarcador(lectura.getNumremarcador());
			lecturaRemarcador.setMes(lectura.getMes());
			lecturaRemarcador.setTimestamp(lectura.getTimestamp());
			lecturaRemarcador.setTipoRemarcador("schneiderpm710");
			lecturaRemarcador.setFecha(lectura.getFecha());
			bodenor.api.com.Util.imprimirClaseJson(lecturaRemarcador);

			return procesarLecturaRemarcador(lecturaRemarcador);

		} else {
			if (!lectura.esProcesable()) {
				//No se puede procesar ni obtener la anterior.
				System.out.println("No se puede procesar la lectura");
				return new ConsumoDiario();
			}

			//Se extraen los campos de c??lculo de circutor desde el mensaje
			LecturaSchneiderPM710 l1 = LecturaSchneiderPM710.parseItems(contenido, lectura);
			LecturaRemarcador lecturaRemarcador = l1.toLecturaRemarcador();
			//LecturaRemarcador lecturaRemarcador = LecturaSchneiderPM710.parseItems(contenido, lectura).toLecturaRemarcador();
			//Activar este una vez se haya completado la migraci??n
			lecturaLegadoClient.postLecturaSchneiderPM710Legado(new SchneiderPM710().fromLectura(LecturaSchneiderPM710.parseItems(contenido, lectura)));
			return procesarLecturaRemarcador(lecturaRemarcador);
		}

	}

	@Path("/schneiderpm5300")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.TEXT_PLAIN)
	public ConsumoDiario postLecturaSchneiderPM5300(String contenido) {
		System.out.println("Entra SchneiderPM5300");
		Lectura lectura = Lectura.getLectura(contenido);

		if (contenido.contains("MANUAL[true]")) {
			System.out.println("Entra a lectura Manual");

			//Se procesa una lectura manual (sin potencia) que viene llegando.
			LecturaRemarcador lecturaRemarcador = new LecturaRemarcador();
			lecturaRemarcador.setAnio(lectura.getAnio());
			lecturaRemarcador.setCalculable(true);
			lecturaRemarcador.setDia(lectura.getDia());
			lecturaRemarcador.setManual(true);

			String regexp = "";
			Pattern pattern;
			Matcher matcher;

			regexp = "(LECTURA\\[)([0-9]{1,9})(\\])";
			pattern = Pattern.compile(regexp);
			matcher = pattern.matcher(contenido);
			if (matcher.find()) {
				lecturaRemarcador.setEnergia(Double.parseDouble(matcher.group(2)));
			}

			lecturaRemarcador.setNumRemarcador(lectura.getNumremarcador());
			lecturaRemarcador.setMes(lectura.getMes());
			lecturaRemarcador.setTimestamp(lectura.getTimestamp());
			lecturaRemarcador.setTipoRemarcador("schneiderpm5300");
			lecturaRemarcador.setFecha(lectura.getFecha());
			bodenor.api.com.Util.imprimirClaseJson(lecturaRemarcador);

			return procesarLecturaRemarcador(lecturaRemarcador);

		} else {
			if (!lectura.esProcesable()) {
				//No se puede procesar ni obtener la anterior.
				System.out.println("No se puede procesar la lectura");
				return new ConsumoDiario();
			}

			//Se extraen los campos de c??lculo de circutor desde el mensaje
			LecturaRemarcador lecturaRemarcador = LecturaSchneiderPM5300.parseItems(contenido, lectura).toLecturaRemarcador();
			//LecturaRemarcador lecturaRemarcador = LecturaSchneiderPM5300.parseItemsMigracion(contenido, lectura).toLecturaRemarcador();
			
			//Activar este una vez se haya completado la migraci??n
			lecturaLegadoClient.postLecturaSchneiderPM5300Legado(new SchneiderPM5300().fromLectura(LecturaSchneiderPM5300.parseItems(contenido, lectura)));
			return procesarLecturaRemarcador(lecturaRemarcador);
		}

	}

	private ConsumoDiario procesarLecturaRemarcador(LecturaRemarcador lecturaRemarcador) {
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
		if (!lecturaRemarcador.esCalculable()) {
			//Insertar lectura en tabla correspondiente con vampos vac??os
			System.out.println("No vienen campos para calcular. Se intentar?? obtener anteriores para delta 0");
			//No tiene campos para poder calcular la energ??a.
			//Se obtiene el ??ltimo consumo diario registrado

			ConsumoDiarioResponse response = consumoDiarioClient.getLastConsumoDiario(lecturaRemarcador.getNumRemarcador(), formatterDate.format(lecturaRemarcador.getFecha()));
			ConsumoDiario anterior = response.getConsumoDiario();
			
			if (anterior == null) {
				return new ConsumoDiario(); //Retorna Vac??o
			}
			anterior.setId(new ObjectId(response.getIdString()));
			//Se modifica el anterior para hacer update con delta cero y last lectura con valores nulos
			bodenor.api.consumo.model.Lectura nuevaLast = anterior.getLastLectura();
			bodenor.api.remarcador.model.Remarcador r = remarcadorClient.getRemarcadorNumRemarcador(anterior.getNumRemarcador());
			bodenor.api.remarcador.model.asignacion.model.Asignacion a = r.getLastAsignacion();
			bodenor.api.cliente.model.Cliente c = a.getCliente();

			nuevaLast.setLectura(null);
			nuevaLast.setPotencia(null);
			nuevaLast.setDelta(0d);
			nuevaLast.setAnio(lecturaRemarcador.getAnio());
			nuevaLast.setMes(lecturaRemarcador.getMes());
			nuevaLast.setDia(lecturaRemarcador.getDia());
			nuevaLast.setFecha(lecturaRemarcador.getFecha());
			nuevaLast.setManual(lecturaRemarcador.isManual());

			String hora = formatterTime.format(lecturaRemarcador.getTimestamp());
			int hh = Integer.parseInt(hora.substring(0, 2));
			int mm = Integer.parseInt(hora.substring(3, 5));
			int ss = Integer.parseInt(hora.substring(6, 8));
			nuevaLast.setHh(hh);
			nuevaLast.setMm(mm);
			nuevaLast.setSs(ss);
			Cliente clienteLectura = new Cliente(c.getIdcliente().intValue(), c.getRutcliente(), c.getDvcliente(), c.getNomcliente(), c.getRazoncliente());
			nuevaLast.setCliente(clienteLectura);

			anterior.setLastLectura(nuevaLast);
			LinkedList<bodenor.api.consumo.model.Lectura> lecturasActuales = anterior.getLecturas();
			lecturasActuales.add(nuevaLast);
			anterior.setLecturas(lecturasActuales);

			anterior.setClienteActual(clienteLectura);

			String fechaEntrada = formatterDate.format(lecturaRemarcador.getFecha());
			String fechaAnterior = formatterDate.format(anterior.getFecha());

			if (fechaEntrada.equals(fechaAnterior)) { //Es el mismo d??a
				ConsumoDiarioResponse res = new ConsumoDiarioResponse(anterior, response.getIdString());
				consumoDiarioClient.patchConsumoDiario(res);
			} else { //Es un dia distinto (Nuevo documento).
				anterior.setId(null);
				//Se debe limpiar el arreglo de lecturas para este d??a, porque es una nueva
				lecturasActuales = new LinkedList();
				lecturasActuales.add(nuevaLast);
				anterior.setLecturas(lecturasActuales);
				anterior.setFecha(lecturaRemarcador.getFecha());
				anterior.setAnio(lecturaRemarcador.getAnio());
				anterior.setMes(lecturaRemarcador.getMes());
				anterior.setDia(lecturaRemarcador.getDia());
				consumoDiarioClient.postConsumoDiario(anterior);
			}
			return anterior;
		} else {
			//Insertar en tabla mysql los campos normales
			System.out.println("Existen campos para calcular.");
			Double lecActual = lecturaRemarcador.getEnergia();
			//Existen valores para poder calcular la energ??a
			//Se actualiza la continuidad con el valor que venga en los campos.

			ConsumoDiarioResponse response = consumoDiarioClient.getLastConsumoDiario(lecturaRemarcador.getNumRemarcador(), formatterDate.format(lecturaRemarcador.getFecha()));
			ConsumoDiario anterior = response.getConsumoDiario();

			//System.out.println("El id que llega en la creacion del anterior: " + anterior.getId());
			//Util.imprimirClaseJson(anterior);
			if (response.getConsumoDiario() == null) { //No existe anterior. ??sta es la primera
				System.out.println("No existe una anterior. Se insertar?? este primer registro");
				ConsumoDiario cons = new ConsumoDiario();
				cons.setAnio(lecturaRemarcador.getAnio());
				//Verificar el cliente asociado
				bodenor.api.remarcador.model.Remarcador r = remarcadorClient.getRemarcadorNumRemarcador(lecturaRemarcador.getNumRemarcador());
				bodenor.api.remarcador.model.asignacion.model.Asignacion a = r.getLastAsignacion();
				bodenor.api.cliente.model.Cliente c = a.getCliente();

				Cliente newCliente = new Cliente();
				newCliente.setDvCliente(c.getDvcliente());
				newCliente.setIdCliente(c.getIdcliente().intValue());
				newCliente.setNomCliente(c.getNomcliente());
				newCliente.setRazonCliente(c.getRazoncliente());
				newCliente.setRutCliente(c.getRutcliente());

				cons.setClienteActual(newCliente);

				cons.setDemandaMaxima(lecturaRemarcador.getPotencia());
				String hora = formatterTime.format(lecturaRemarcador.getTimestamp());
				int hh = Integer.parseInt(hora.substring(0, 2));
				int mm = Integer.parseInt(hora.substring(3, 5));
				int ss = Integer.parseInt(hora.substring(6, 8));
				if (hh >= 18 && hh <= 23) {
					cons.setDemandaMaximaHoraPunta(lecturaRemarcador.getPotencia());
				}

				cons.setDia(lecturaRemarcador.getDia());
				Empalme e = r.getEmpalme();
				bodenor.api.consumo.model.Empalme empalme = new bodenor.api.consumo.model.Empalme();
				empalme.setIdEmpalme(e.getIdempalme().intValue());
				empalme.setNumEmpalme(e.getNumempalme());

				Bodega b = e.getBodega();
				bodenor.api.consumo.model.Bodega bodega = new bodenor.api.consumo.model.Bodega();

				bodega.setIdBodega(b.getIdbodega().intValue());
				bodega.setNomBodega(b.getNombodega());
				empalme.setBodega(bodega);
				Instalacion i = e.getInstalacion();

				bodenor.api.consumo.model.Instalacion instalacion = new bodenor.api.consumo.model.Instalacion();
				instalacion.setIdInstalacion(i.getIdinstalacion().intValue());
				instalacion.setNomInstalacion(i.getNominstalacion());
				instalacion.setComuna(i.getComuna());
				instalacion.setDireccion(i.getDireccion());

				empalme.setInstalacion(instalacion);

				cons.setEmpalme(empalme);
				cons.setEnergiaConsumidaTotal(0d);
				cons.setEstado(1);
				cons.setFecha(lecturaRemarcador.getFecha());
				cons.setIdRemarcador(r.getIdremarcador().intValue());

				bodenor.api.consumo.model.Lectura last = new bodenor.api.consumo.model.Lectura();
				last.setAnio(lecturaRemarcador.getAnio());
				last.setDelta(0d);
				last.setDia(lecturaRemarcador.getDia());
				last.setFecha(lecturaRemarcador.getFecha());

				last.setHh(hh);
				last.setLectura(lecturaRemarcador.getEnergia());
				last.setMes(lecturaRemarcador.getMes());
				last.setMm(mm);
				last.setPotencia(lecturaRemarcador.getPotencia());
				last.setSs(ss);
				last.setTime(lecturaRemarcador.getTimestamp());
				last.setCliente(newCliente);
				last.setManual(lecturaRemarcador.isManual());

				cons.setLastLectura(last);
				cons.setLastLecturaValida(last);
				LinkedList<bodenor.api.consumo.model.Lectura> lecturas = new LinkedList();

				lecturas.add(last);
				cons.setLecturas(lecturas);
				cons.setMarca(r.getMarca());
				cons.setMes(lecturaRemarcador.getMes());
				cons.setModelo(r.getModelo());
				cons.setModulos(r.getModulos());
				cons.setNumRemarcador(r.getNumremarcador());
				cons.setNumSerie(r.getNumserie());
				cons.setPromedioDemanda(lecturaRemarcador.getPotencia());
				if (hh >= 18 && hh <= 23) {
					cons.setPromedioDemandaHoraPunta(lecturaRemarcador.getPotencia());
				}

				return consumoDiarioClient.postConsumoDiario(cons);
			} else { //Existe una anterior (puede ser del mes anterior)
				//Verificar el cliente asociado
				bodenor.api.remarcador.model.Remarcador r = remarcadorClient.getRemarcadorNumRemarcador(anterior.getNumRemarcador());
				bodenor.api.remarcador.model.asignacion.model.Asignacion a = r.getLastAsignacion();
				bodenor.api.cliente.model.Cliente c = a.getCliente();

				Cliente newClienteLectura = new Cliente();
				newClienteLectura.setDvCliente(c.getDvcliente());
				newClienteLectura.setIdCliente(c.getIdcliente().intValue());
				newClienteLectura.setNomCliente(c.getNomcliente());
				newClienteLectura.setRazonCliente(c.getRazoncliente());
				newClienteLectura.setRutCliente(c.getRutcliente());
				if (formatterDate.format(anterior.getFecha()).equals(formatterDate.format(lecturaRemarcador.getFecha()))) {
					anterior.setId(new ObjectId(response.getIdString()));
				} else {
					anterior.setId(null);
				}

				Double delta = 0d;
				Double lecAnterior = null;
				if (anterior.getLastLectura().getLectura() == null) { //La lectura anterior es una que se repiti??
					lecAnterior = anterior.getLastLecturaValida().getLectura();
				} else { //La lectura anterior estaba bien
					lecAnterior = anterior.getLastLectura().getLectura();
				}

				if (lecAnterior <= lecActual) { //Todo bien. Hay continuidad
					delta = lecActual - lecAnterior;
					anterior.setEnergiaConsumidaTotal(anterior.getEnergiaConsumidaTotal() + (lecActual - lecAnterior));
				}
				bodenor.api.consumo.model.Lectura newLastLectura = new bodenor.api.consumo.model.Lectura();
				newLastLectura.setAnio(lecturaRemarcador.getAnio());
				newLastLectura.setMes(lecturaRemarcador.getMes());
				newLastLectura.setDia(lecturaRemarcador.getDia());
				newLastLectura.setDelta(delta);
				newLastLectura.setFecha(lecturaRemarcador.getFecha());
				newLastLectura.setTime(lecturaRemarcador.getTimestamp());
				newLastLectura.setManual(lecturaRemarcador.isManual());
				String hora = formatterTime.format(lecturaRemarcador.getTimestamp());
				int hh = Integer.parseInt(hora.substring(0, 2));
				int mm = Integer.parseInt(hora.substring(3, 5));
				int ss = Integer.parseInt(hora.substring(6, 8));
				newLastLectura.setHh(hh);
				newLastLectura.setMm(mm);
				newLastLectura.setSs(ss);

				newLastLectura.setPotencia(lecturaRemarcador.getPotencia());
				newLastLectura.setLectura(lecturaRemarcador.getEnergia());
				newLastLectura.setCliente(newClienteLectura);

				//Actualizar las last y last valida
				anterior.setLastLectura(newLastLectura);
				anterior.setLastLecturaValida(newLastLectura);

				LinkedList<bodenor.api.consumo.model.Lectura> lecturas = new LinkedList();

				lecturas.add(newLastLectura);
				if (formatterDate.format(anterior.getFecha()).equals(formatterDate.format(lecturaRemarcador.getFecha()))) {
					anterior.addLectura(newLastLectura);
				} else {
					anterior.setLecturas(lecturas);
				}

				//anterior.setLecturas(lecturas);
				//Recalcular demandas
				if (lecturaRemarcador.getPotencia() != null && anterior.getDemandaMaxima() != null) {
					if (lecturaRemarcador.getPotencia() > anterior.getDemandaMaxima()) {
						anterior.setDemandaMaxima(lecturaRemarcador.getPotencia());
					}
				}

				if (hh >= 18 && hh <= 23) {

					if (anterior.getDemandaMaximaHoraPunta() == null || (lecturaRemarcador.getPotencia() != null && lecturaRemarcador.getPotencia() > anterior.getDemandaMaximaHoraPunta())) {
						anterior.setDemandaMaximaHoraPunta(lecturaRemarcador.getPotencia());
					}
				} else {
					anterior.setDemandaMaximaHoraPunta(null);
				}

				//Sacar los promedios
				int contDemandaMaxima = 0;
				int contDemandaMaximaHoraPunta = 0;
				Double sumaDemandaMaxima = 0d;
				Double sumaDemandaMaximaHoraPunta = 0d;
				for (bodenor.api.consumo.model.Lectura l : anterior.getLecturas()) {
					if (l.getLectura() != null) {
						if (l.getPotencia() != null) {
							sumaDemandaMaxima += l.getPotencia();
							contDemandaMaxima++;
						}

						if (l.getHh() >= 18 && l.getHh() <= 23 && l.getPotencia() != null) {
							sumaDemandaMaximaHoraPunta += l.getPotencia();
							contDemandaMaximaHoraPunta++;
						}
					}
				}

				if (contDemandaMaxima > 0) {
					anterior.setPromedioDemanda(sumaDemandaMaxima / contDemandaMaxima);
				}
				if (contDemandaMaximaHoraPunta > 0) {
					anterior.setPromedioDemandaHoraPunta(sumaDemandaMaximaHoraPunta / contDemandaMaximaHoraPunta);
				} else {
					anterior.setPromedioDemandaHoraPunta(null);
				}

				anterior.setClienteActual(newClienteLectura);

				String fechaEntrada = formatterDate.format(lecturaRemarcador.getFecha());
				String fechaAnterior = formatterDate.format(anterior.getFecha());
				if (fechaEntrada.equals(fechaAnterior)) { //Es el mismo d??a
					return consumoDiarioClient.patchConsumoDiario(new ConsumoDiarioResponse(anterior, response.getIdString()));
				} else { //Es un mes distinto (Nuevo documento).
					anterior.setId(null);
					//Se debe limpiar el arreglo de lecturas para este d??a, porque es una nueva
					lecturas = new LinkedList();
					lecturas.add(newLastLectura);
					anterior.setLecturas(lecturas);
					anterior.setLastLectura(newLastLectura);
					anterior.setLastLecturaValida(newLastLectura);
					anterior.setFecha(lecturaRemarcador.getFecha());

					//Actualizar el cliente actual en caso de que haya cambiado en la ??ltima lectura
					anterior.setClienteActual(newLastLectura.getCliente());
					//Recalcular Demandas
					anterior.setDemandaMaxima(lecturaRemarcador.getPotencia());
					//anterior.setDemandaMaximaHoraPunta(lecturaRemarcador.getPotencia());
					if (hh >= 18 && hh <= 23) {
						anterior.setDemandaMaximaHoraPunta(lecturaRemarcador.getPotencia());
					} else {
						anterior.setDemandaMaximaHoraPunta(null);
					}

					//Sacar los promedios con solo la ??nica lectura que viene
					anterior.setPromedioDemanda(null);
					anterior.setPromedioDemandaHoraPunta(null);
					if (newLastLectura.getPotencia() != null) {
						anterior.setPromedioDemanda(newLastLectura.getPotencia());
						if (newLastLectura.getHh() >= 18 && newLastLectura.getHh() <= 23) {
							anterior.setPromedioDemandaHoraPunta(newLastLectura.getPotencia());
						}
					}

					anterior.setAnio(lecturaRemarcador.getAnio());
					anterior.setMes(lecturaRemarcador.getMes());
					anterior.setDia(lecturaRemarcador.getDia());

					anterior.setEnergiaConsumidaTotal(delta);
					return consumoDiarioClient.postConsumoDiario(anterior);
				}
			}

		}
	}

}
