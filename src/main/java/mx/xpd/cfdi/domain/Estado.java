package mx.xpd.cfdi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {

	private String id;
	private String nombre;
	
	@Id
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
	
	
}
