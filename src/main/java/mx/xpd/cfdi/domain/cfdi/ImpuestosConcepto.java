package mx.xpd.cfdi.domain.cfdi;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={
		"traslados",
		"retenciones"
})
public class ImpuestosConcepto {
	
	private Traslados traslados;
	private Retenidos retenciones;
	
	
	@XmlElement(name = "Traslados")
	public Traslados getTraslados() {
		return traslados;
	}
	
	public void setTraslados(Traslados traslados) {
		this.traslados = traslados;
	}
	
	@XmlElement(name = "Retenciones")
	public Retenidos getRetenciones() {
		return retenciones;
	}
	/*
	public  boolean isExento() {
		if ((getRetenidos() == null) && (getTraslados() == null))
			return true;
		return false;
	}*/


	
	

	public void setRetencioens(Retenidos retenciones) {
		this.retenciones = retenciones;
	}


	
	
	
	
	
	
	
}
