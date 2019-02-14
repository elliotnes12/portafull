package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina;

import javax.xml.bind.annotation.XmlAttribute;

public class Incapacidad {

	private String tipoIncapacidad;
	private Integer diasIncapacidad;
	private Double descuento;
	
	
	public Incapacidad() {
		
	}
	
	public Incapacidad(String []data) {
		diasIncapacidad = Integer.valueOf(data[1]);
		tipoIncapacidad = data[2];
		descuento = Double.parseDouble(data[3]);
	}
	
	@XmlAttribute(name = "TipoIncapacidad")
	public String getTipoIncapacidad() {
		return tipoIncapacidad;
	}

	@XmlAttribute(name = "DiasIncapacidad")
	public Integer getDiasIncapacidad() {
		return diasIncapacidad;
	}

	@XmlAttribute(name = "Descuento")
	public Double getDescuento() {
		return descuento;
	}

	public void setTipoIncapacidad(String tipoIncapacidad) {
		this.tipoIncapacidad = tipoIncapacidad;
	}

	public void setDiasIncapacidad(Integer diasIncapacidad) {
		this.diasIncapacidad = diasIncapacidad;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}	
}
