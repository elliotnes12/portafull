package mx.xpd.cfdi.domain.cfdi.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Retencion")
public class Retencion{

	private String impuestoRetencionesCuentaTerceros;
	private String importeRetencionesCuentaTerceros;
		
	public Retencion() {
		
	}
	
	@XmlAttribute(name = "impuesto")
	public String getImpuestoRetencionesCuentaTerceros() {
		return impuestoRetencionesCuentaTerceros;
	}

	public void setImpuestoRetencionesCuentaTerceros(String impuestoRetencionesCuentaTerceros) {
		this.impuestoRetencionesCuentaTerceros = impuestoRetencionesCuentaTerceros;
	}

	
	@XmlAttribute(name = "importe")
	public String getImporteRetencionesCuentaTerceros() {
		return importeRetencionesCuentaTerceros;
	}

	public void setImporteRetencionesCuentaTerceros(String importeRetencionesCuentaTerceros) {
		this.importeRetencionesCuentaTerceros= importeRetencionesCuentaTerceros;
	}


	

	

	
	
	
	
		
	
}
