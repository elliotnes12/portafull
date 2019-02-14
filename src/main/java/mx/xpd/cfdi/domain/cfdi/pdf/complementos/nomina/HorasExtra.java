package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina;

import javax.xml.bind.annotation.XmlAttribute;

public class HorasExtra {

	private Integer dias;
	private String tipoHoras;
	private Integer numeroHorasExtra;
	private Double importePagado;
	
	public HorasExtra() {
		
	}
	
	public HorasExtra(String []data) {
		dias = Integer.valueOf(data[1]);
		tipoHoras = data[2];
		numeroHorasExtra = Integer.valueOf(data[3]);
		importePagado = Double.parseDouble(data[4]);
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
