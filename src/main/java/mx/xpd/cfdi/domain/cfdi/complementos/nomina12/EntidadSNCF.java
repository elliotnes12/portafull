package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class EntidadSNCF {
	private String origenRecurso;
	private String montoRecursoPropio;

	public EntidadSNCF() {
		
	}
	
	@XmlAttribute(name = "OrigenRecurso")
	public String getOrigenRecurso() {
		return origenRecurso;
	}
	
	public void setOrigenRecurso(String origenRecurso) {
		this.origenRecurso = origenRecurso;
	}
	
	@XmlAttribute(name = "MontoRecursoPropio")
	public String getMontoRecursoPropio() {
		return montoRecursoPropio;
	}
	
	public void setMontoRecursoPropio(String montoRecursoPropio) {
		this.montoRecursoPropio = montoRecursoPropio;
	}	
		
}
