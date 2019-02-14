package mx.xpd.cfdi.domain.retenciones;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import mx.xpd.cfdi.domain.cfdi.complementos.concepto.ComplementoConcepto;
import mx.xpd.cfdi.domain.cfdi.complementos.concepto.CuentaPredial;


public class ImpuestoRetenciones {

	private String baseRet;
	private String impuesto;
	private String montoRet;
	private String tipoPagoRet;
	
	
	//private ComplementoConcepto complementoConcepto;
		
	
	
	public ImpuestoRetenciones() {
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
	
	
	@Override
	public String toString() {
		return "ImpuestoRetenciones [baseRet=" + baseRet + ", impuesto=" + impuesto + ", montoRet=" + montoRet +", tipoPagoRet=" +tipoPagoRet +"]";
	}
	/*
	@XmlElement(name = "ComplementoConcepto")
	public ComplementoConcepto getComplementoConcepto() {
		if (complementoConcepto.getInstEducativas() == null) {
			return null;
		}
		return complementoConcepto;
	}
	

	public void getComplementoConcepto(ComplementoConcepto complementoConcepto) {
		this.complementoConcepto = complementoConcepto;
	}
	*/
	
	
	
}
