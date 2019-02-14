package mx.xpd.cfdi.domain.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MapClienteJSON {
	
	@Id 
	@Column
	private Long id;
	@Column
	private String clave;
	@Column
	private String rfc;
	@Column
	private String razonSocial;
	
	
	
	public MapClienteJSON() {
		super();
	}
	public MapClienteJSON(Long id, String clave, String rfc, String razonSocial) {
		super();
		this.id = id;
		this.clave = clave;
		this.rfc = rfc;
		this.razonSocial = razonSocial;
	}
	public Long getId() {
		return id;
	}
	public String getClave() {
		return clave;
	}
	public String getRfc() {
		return rfc;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	
	
	
	
	
}
