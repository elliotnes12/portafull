package mx.xpd.cfdi.domain.cfdi.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Retenciones")
public class Retenciones{

	private List<Retencion> retencion;
	
	public Retenciones() {
		
	}
	
	@XmlElement(name = "Retencion")
	public List<Retencion> getRetencion() {
		return retencion;
	}

	public void setRetencion(List<Retencion> retencion) {
		this.retencion = retencion;
	}
	
		
	
}
