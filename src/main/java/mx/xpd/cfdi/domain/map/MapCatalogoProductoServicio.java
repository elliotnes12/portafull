package mx.xpd.cfdi.domain.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MapCatalogoProductoServicio {
	@Id
	@Column(name="id")
	private Long value;
	@Column(name = "nombre")
	private String label;
	@Column(name = "clave")
	private String clave;
	
	private String iepsTrasladado;
	private String complementoAIncluir;
	
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getIepsTrasladado() {
		return iepsTrasladado;
	}
	public void setIepsTrasladado(String iepsTrasladado) {
		this.iepsTrasladado = iepsTrasladado;
	}
	public String getComplementoAIncluir() {
		return complementoAIncluir;
	}
	public void setComplementoAIncluir(String complementoAIncluir) {
		this.complementoAIncluir = complementoAIncluir;
	}

}
