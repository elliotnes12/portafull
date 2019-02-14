package mx.xpd.cfdi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FraccionArancelaria {

	private String codigo;
	private String descripcion;
	
	@Id
	public String getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
