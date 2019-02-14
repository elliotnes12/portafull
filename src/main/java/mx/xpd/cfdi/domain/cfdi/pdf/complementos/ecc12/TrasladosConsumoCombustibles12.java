package mx.xpd.cfdi.domain.cfdi.pdf.complementos.ecc12;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Traslados")
public class TrasladosConsumoCombustibles12{

	private List<TrasladoConsumoCombustibles12> traslado;
	
	public TrasladosConsumoCombustibles12() {
		
	}

	@XmlElement(name = "Traslado")
	public List<TrasladoConsumoCombustibles12> getTraslado() {
		return traslado;
	}

	public void setTraslado(List<TrasladoConsumoCombustibles12> traslado) {
		this.traslado = traslado;
	}

	
	
	
	
		
	
}
