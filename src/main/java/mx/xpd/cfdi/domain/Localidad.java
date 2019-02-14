package mx.xpd.cfdi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Localidad{

	private String clave;
	private String nombre;
	
	@Id
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
