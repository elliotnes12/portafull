package mx.xpd.cfdi.domain.map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MapCfdGrafica {
	
	@Id
	private Integer mes;
	private Integer suma;
	private String anio;
	
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getSuma() {
		return suma;
	}
	public void setSuma(Integer suma) {
		this.suma = suma;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}

}
