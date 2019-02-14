package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class HorasExtras {

	private Integer dias;
	private String tipoHoras;
	private Integer numeroHorasExtra;
	private Double importePagado;
	
	public HorasExtras() {
		
	}
	
	@XmlAttribute(name = "Dias")
	public Integer getDias() {
		return dias;
	}

	@XmlAttribute(name = "TipoHoras")
	public String getTipoHoras() {
		return tipoHoras;
	}

	@XmlAttribute(name = "HorasExtra")
	public Integer getNumeroHorasExtra() {
		return numeroHorasExtra;
	}

	@XmlAttribute(name = "ImportePagado")
	public Double getImportePagado() {
		return importePagado;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public void setTipoHoras(String tipoHoras) {
		this.tipoHoras = tipoHoras;
	}

	public void setNumeroHorasExtra(Integer numeroHorasExtra) {
		this.numeroHorasExtra = numeroHorasExtra;
	}

	public void setImportePagado(Double importePagado) {
		this.importePagado = importePagado;
	}
	
	
}
