package mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros.Traslado;

@XmlRootElement(name = "Traslados")
public class TrasladosTercero{

	private List<Traslado> traslado;
	
	public TrasladosTercero() {
		
	}
	
	@XmlElement(name = "Traslado")
	public List<Traslado> getTraslado() {
		return traslado;
	}

	public void setTraslado(List<Traslado> traslado) {
		this.traslado = traslado;
	}
	
		
	
}
