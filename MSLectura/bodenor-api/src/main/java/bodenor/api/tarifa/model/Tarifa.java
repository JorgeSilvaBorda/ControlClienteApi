package bodenor.api.tarifa.model;

import bodenor.api.comuna.model.Comuna;
import java.util.List;
import org.bson.types.ObjectId;

public class Tarifa {
	private ObjectId _id;
	private String nomTarifa;
	private Comuna comuna;
	
	private List<Detalle> detalles;

	public Tarifa() {
	}

	public Tarifa(ObjectId _id, String nomTarifa, Comuna comuna, List<Detalle> detalles) {
		this._id = _id;
		this.nomTarifa = nomTarifa;
		this.comuna = comuna;
		this.detalles = detalles;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId _id) {
		this._id = _id;
	}

	public String getNomTarifa() {
		return nomTarifa;
	}

	public void setNomTarifa(String nomTarifa) {
		this.nomTarifa = nomTarifa;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	
}
