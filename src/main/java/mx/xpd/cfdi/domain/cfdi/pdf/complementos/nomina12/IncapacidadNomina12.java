package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class IncapacidadNomina12 {

	private Integer diasIncapacidad;
	private String tipoIncapacidad;
	private Double importeMonetario;
	
	
	public IncapacidadNomina12() {
		
	}
	
	
	@XmlAttribute(name = "DiasIncapacidad")
	public Integer getDiasIncapacidad() {
		return diasIncapacidad;
	}
	
	public void setDiasIncapacidad(Integer diasIncapacidad) {
		this.diasIncapacidad = diasIncapacidad;
	}
	
	@XmlAttribute(name = "TipoIncapacidad")
	public String getTipoIncapacidad() {
		return tipoIncapacidad;
	}

	public void setTipoIncapacidad(String tipoIncapacidad) {
		this.tipoIncapacidad = tipoIncapacidad;
	}

	@XmlAttribute(name = "ImporteMonetario")
	public Double getImporteMonetario() {
		return importeMonetario;
	}

	public void setImporteMonetario(Double importeMonetario) {
		this.importeMonetario = importeMonetario;
	}	
}
