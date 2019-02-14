package mx.xpd.cfdi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Colonia{

	private String c_colonia;
	private String nombre;
	
	@Id
	public String getC_colonia() {
		return c_colonia;
	}
	public void setC_colonia(String c_colonia) {
		this.c_colonia = c_colonia;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
