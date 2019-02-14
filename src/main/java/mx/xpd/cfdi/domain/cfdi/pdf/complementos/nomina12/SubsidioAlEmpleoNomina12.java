package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class SubsidioAlEmpleoNomina12 {

	private String subsidioCausado;
	
	public SubsidioAlEmpleoNomina12() {
		
	}
			
	@XmlAttribute(name = "SubsidioCausado")
	public String getSubsidioCausado() {
		return subsidioCausado;
	}

	public void setSubsidioCausado(String subsidioCausado) {
		this.subsidioCausado = subsidioCausado;
	}
	
	
}
