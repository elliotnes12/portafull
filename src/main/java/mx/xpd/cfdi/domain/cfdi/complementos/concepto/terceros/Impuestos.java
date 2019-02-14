package mx.xpd.cfdi.domain.cfdi.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "Impuestos")
public class Impuestos{

	private Retenciones retenciones;
	private Traslados traslados;
	
	
	public Impuestos() {
		
	}
	
	
	@XmlElement(name = "Retenciones")
	public Retenciones getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(Retenciones retenciones) {
		this.retenciones = retenciones;
	}

	@XmlElement(name = "Traslados")
	public Traslados getTraslados() {
		return traslados;
	}

	public void setTraslados(Traslados traslados) {
		this.traslados = traslados;
	}

			
	
}
