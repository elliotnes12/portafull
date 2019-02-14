package mx.xpd.cfdi.domain.cfdi;

import javax.xml.bind.annotation.XmlAttribute;

public class RegimenFiscal {

	private String regimen;

	@XmlAttribute(name = "Regimen")
	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	
	
	
}
