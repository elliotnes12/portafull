package mx.xpd.cfdi.domain.cfdi.complementos.consumodecombustibles;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Conceptos")
public class Conceptos{

	private List<ConceptoConsumoCombustibles> conceptoconsumodecombustibles;
	
	public Conceptos() {
		
	}

	@XmlElement(name = "ConceptoConsumoDeCombustibles")
	public List<ConceptoConsumoCombustibles> getConceptoconsumodecombustibles() {
		return conceptoconsumodecombustibles;
	}

	public void setConceptoconsumodecombustibles(
			List<ConceptoConsumoCombustibles> conceptoconsumodecombustibles) {
		this.conceptoconsumodecombustibles = conceptoconsumodecombustibles;
	}

	
	
		
	
}
