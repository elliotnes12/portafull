package mx.xpd.cfdi.domain;

import javax.xml.bind.annotation.XmlElement;

public  class Conceptos {
	
	private java.util.List<Concepto> conceptos;

	@XmlElement(name = "Concepto")
	public java.util.List<Concepto> getConceptos() {
		return conceptos;
	}

	public void setConceptos(java.util.List<Concepto> conceptos) {
		this.conceptos = conceptos;
	}
	
	
	
}
