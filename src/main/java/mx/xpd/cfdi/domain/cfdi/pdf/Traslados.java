package mx.xpd.cfdi.domain.cfdi.pdf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Traslados {
	
	private List<Impuesto> traslado;

	public Traslados() {
		traslado = new ArrayList<Impuesto>();
	}

	@XmlElement(name = "Traslado")
	public List<Impuesto> getTraslado() {
		return traslado;
	}

	public void setTraslado(List<Impuesto> traslado) {
		this.traslado = traslado;
	}
	
	
	
}
