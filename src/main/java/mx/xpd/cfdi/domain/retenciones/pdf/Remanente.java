package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Remanente")
public class Remanente {

	private String proporcionRem;
		
	public Remanente() {
		
	}
	
	@XmlAttribute(name = "ProporcionRem")
	public String getProporcionRem() {
		return proporcionRem;
	}

	public void setProporcionRem(String proporcionRem) {
		proporcionRem = proporcionRem;
	}

	

	

	

	
}
