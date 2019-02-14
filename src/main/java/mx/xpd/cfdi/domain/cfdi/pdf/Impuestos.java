package mx.xpd.cfdi.domain.cfdi.pdf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import mx.xpd.cfdi.domain.cfdi.pdf.ImpuestoRetenidos;
import mx.xpd.cfdi.domain.cfdi.pdf.ImpuestoTraslados;
import mx.xpd.cfdi.domain.cfdi.pdf.Retenidos;


public class Impuestos {
	
	private Traslados traslados;
	private Retenidos retenciones;
	
	private ImpuestoTraslados impuestoTraslados;
	private ImpuestoRetenidos impuestoRetenciones;
	
	private String totalImpuestosRetenidos;
	private String totalImpuestosTrasladados;
	
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
	public void setRetenciones(Retenidos retenciones) {
		this.retenciones = retenciones;
	}
	
	@XmlElement(name = "Traslados")
	public ImpuestoTraslados getImpuestoTraslados() {
		return impuestoTraslados;
	}
	public void setImpuestoTraslados(ImpuestoTraslados impuestoTraslados) {
		this.impuestoTraslados = impuestoTraslados;
	}
	
	@XmlElement(name = "Retenciones")
	public ImpuestoRetenidos getImpuestoRetenciones() {
		return impuestoRetenciones;
	}
	public void setImpuestoRetenciones(ImpuestoRetenidos impuestoRetenciones) {
		this.impuestoRetenciones = impuestoRetenciones;
	}

	@XmlAttribute(name = "TotalImpuestosRetenidos")
	public String getTotalImpuestosRetenidos() {
		return totalImpuestosRetenidos;
	}
	public void setTotalImpuestosRetenidos(String totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}
	
	@XmlAttribute(name = "TotalImpuestosTrasladados")
	public String getTotalImpuestosTrasladados() {
		return totalImpuestosTrasladados;
	}
	public void setTotalImpuestosTrasladados(String totalImpuestosTrasladados) {
		this.totalImpuestosTrasladados = totalImpuestosTrasladados;
	}
	
}
