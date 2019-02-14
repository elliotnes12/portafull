package mx.xpd.cfdi.domain.cfdi.pdf.complementos.ecc12;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Conceptos")
public class ConceptosConsumoCombustibles12{

	private List<ConceptoConsumoCombustiblesECC12> conceptoconsumodecombustibles;
	
	public ConceptosConsumoCombustibles12() {
		
	}

	@XmlElement(name = "ConceptoEstadoDeCuentaCombustible")
	public List<ConceptoConsumoCombustiblesECC12> getConceptoconsumodecombustibles() {
		return conceptoconsumodecombustibles;
	}

	public void setConceptoconsumodecombustibles(
			List<ConceptoConsumoCombustiblesECC12> conceptoconsumodecombustibles) {
		this.conceptoconsumodecombustibles = conceptoconsumodecombustibles;
	}

	
	
		
	
}
