package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class SubsidioAlEmpleo {

	private String subsidioCausado;
	
	public SubsidioAlEmpleo() {
		
	}
			
	@XmlAttribute(name = "SubsidioCausado")
	public String getSubsidioCausado() {
		return subsidioCausado;
	}

	public void setSubsidioCausado(String subsidioCausado) {
		this.subsidioCausado = subsidioCausado;
	}
	
	
}
