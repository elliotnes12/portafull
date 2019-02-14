package mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros.RetencionTercero;

@XmlRootElement(name = "Retenciones")
public class RetencionesTercero{

	private List<RetencionTercero> retencion;
	
	public RetencionesTercero() {
		
	}
	
	@XmlElement(name = "Retencion")
	public List<RetencionTercero> getRetencion() {
		return retencion;
	}

	public void setRetencion(List<RetencionTercero> retencion) {
		this.retencion = retencion;
	}
	
		
	
}
