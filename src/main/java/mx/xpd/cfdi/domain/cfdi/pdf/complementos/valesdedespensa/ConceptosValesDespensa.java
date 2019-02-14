package mx.xpd.cfdi.domain.cfdi.pdf.complementos.valesdedespensa;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Conceptos")
public class ConceptosValesDespensa{

	private List<ConceptoValesDespensa> conceptovalesdespensa;
	
	public ConceptosValesDespensa() {
		
	}

	@XmlElement(name = "Concepto")
	public List<ConceptoValesDespensa> getConceptovalesdespensa() {
		return conceptovalesdespensa;
	}

	public void setConceptovalesdedespensa(
			List<ConceptoValesDespensa> conceptovalesdespensa) {
		this.conceptovalesdespensa = conceptovalesdespensa;
	}

	
	
		
	
}
