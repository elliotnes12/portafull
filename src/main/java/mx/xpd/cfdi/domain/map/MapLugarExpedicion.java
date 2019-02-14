package mx.xpd.cfdi.domain.map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MapLugarExpedicion {

	@Id
	private Long id;
	private String codigoPostal;
	private String nombre;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
