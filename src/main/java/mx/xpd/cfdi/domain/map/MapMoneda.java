package mx.xpd.cfdi.domain.map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MapMoneda {

	@Id
	private Long id;
	private String nombreCorto;
	private double tipoCambio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	
}
