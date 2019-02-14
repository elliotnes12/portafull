package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class Deduccion {

	private String tipoDeduccion;
	private String claveDeduccion;
	private String conceptoDeduccion;
	private String importeDeduccion;
		
	public Deduccion() {
		
	}
			
	@XmlAttribute(name = "TipoDeduccion")
	public String getTipoDeduccion() {
		return tipoDeduccion;
	}

	public void setTipoDeduccion(String tipoDeduccion) {
		this.tipoDeduccion = tipoDeduccion;
	}
	
	@XmlAttribute(name = "Clave")
	public String getClaveDeduccion() {
		return claveDeduccion;
	}

	public void setClaveDeduccion(String claveDeduccion) {
		this.claveDeduccion = claveDeduccion;
	}
	
	@XmlAttribute(name = "Concepto")
	public String getConceptoDeduccion() {
		return conceptoDeduccion;
	}
	
	public void setConceptoDeduccion(String conceptoDeduccion) {
		this.conceptoDeduccion = conceptoDeduccion;
	}

	@XmlAttribute(name = "Importe")
	public String getImporteDeduccion() {
		return importeDeduccion;
	}

	public void setImporteDeduccion(String importeDeduccion) {
		this.importeDeduccion = importeDeduccion;
	}
}
