package mx.xpd.cfdi.domain.map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MapMonedaComercioExterior {

	@Id
	private String id;
	private String nombre;
	private int decimales;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDecimales() {
		return decimales;
	}
	public void setDecimales(int decimales) {
		this.decimales = decimales;
	}
	
}
