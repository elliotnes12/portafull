package mx.xpd.cfdi.domain.cfdi.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Traslados")
public class Traslados{

	private List<Traslado> traslado;
	
	public Traslados() {
		
	}
	
	@XmlElement(name = "Traslado")
	public List<Traslado> getTraslado() {
		return traslado;
	}

	public void setTraslado(List<Traslado> traslado) {
		this.traslado = traslado;
	}
	
		
	
}
