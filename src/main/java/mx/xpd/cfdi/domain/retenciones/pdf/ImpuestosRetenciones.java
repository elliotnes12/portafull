package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import mx.xpd.cfdi.domain.retenciones.ImpuestoRetenciones;

public class ImpuestosRetenciones {
	
	private String baseRet;
	private String impuesto;
	private String montoRet;
	private String tipoPagoRet;
	

	public ImpuestosRetenciones() {
		//this.complementoConcepto = new ComplementoConcepto();
	}
	
	@XmlAttribute(name="BaseRet")
	public String getBaseRet() {
		return baseRet;
	}
	
	public void setBaseRet(String baseRet) {
		this.baseRet = baseRet;
	}
	
	@XmlAttribute(name="Impuesto")
	public String getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	
	@XmlAttribute(name="montoRet")
	public String getMontoRet() {
		return montoRet;
	}

	public void setMontoRet(String montoRet) {
		this.montoRet = montoRet;
	}
	
	@XmlAttribute(name="TipoPagoRet")
	public String getTipoPagoRet() {
		return tipoPagoRet;
	}

	public void setTipoPagoRet(String tipoPagoRet) {
		this.tipoPagoRet = tipoPagoRet;
	}	
	
	
	
}