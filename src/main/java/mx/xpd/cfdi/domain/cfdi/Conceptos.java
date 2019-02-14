package mx.xpd.cfdi.domain.cfdi;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public  class Conceptos {
	
	private java.util.List<Concepto> conceptos;

	public Conceptos() {
		this.conceptos = new ArrayList<Concepto>();
	}
	
	@XmlElement(name = "Concepto")
	public java.util.List<Concepto> getConceptos() {
		return conceptos;
	}

	public void setConceptos(java.util.List<Concepto> conceptos) {
		this.conceptos = conceptos;
	}

	@Override
	public String toString() {
		return "Conceptos [conceptos=" + conceptos + "]";
	}
	
}
