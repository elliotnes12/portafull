package mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros.RetencionesTercero;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros.TrasladosTercero;

@XmlRootElement(name = "Impuestos")
public class ImpuestosTercero{

	private RetencionesTercero retenciones;
	private TrasladosTercero traslados;
	
	
	public ImpuestosTercero() {
		
	}
	
	
	@XmlElement(name = "Retenciones")
	public RetencionesTercero getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(RetencionesTercero retenciones) {
		this.retenciones = retenciones;
	}

	@XmlElement(name = "Traslados")
	public TrasladosTercero getTraslados() {
		return traslados;
	}

	public void setTraslados(TrasladosTercero traslados) {
		this.traslados = traslados;
	}

			
	
}
