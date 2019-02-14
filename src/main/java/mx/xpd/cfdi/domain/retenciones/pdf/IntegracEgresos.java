package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "IntegracEgresos")
public class IntegracEgresos {

	private String conceptoS;
		
	public IntegracEgresos() {
		
	}
	
	@XmlAttribute(name = "ConceptoS")
	public String getConceptoS() {
		return conceptoS;
	}

	public void setConceptoS(String conceptoS) {
		this.conceptoS = conceptoS;
	}

	

	

	
}
