package mx.xpd.cfdi.domain.cfdi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Retenidos {
	private List<Impuesto> retencion;

	public Retenidos() {
		retencion = new ArrayList<Impuesto>();
	}
	@XmlElement(name = "Retencion")
	public List<Impuesto> getRetencion() {
		return retencion;
	}

	public void setRetencion(List<Impuesto> retencion) {
		this.retencion = retencion;
	}

	
	
	
}
