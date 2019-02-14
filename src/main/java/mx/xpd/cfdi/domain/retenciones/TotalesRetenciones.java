package mx.xpd.cfdi.domain.retenciones;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import mx.xpd.cfdi.domain.cfdi.Concepto;

public class TotalesRetenciones {
	
	private String montoTotOperacion;
	private String montoTotGrav;
	private String montoTotExent;
	private String montoTotRet;
	
	private java.util.List<ImpuestosRetenciones> impuestos;
			
	

	public TotalesRetenciones() {
		this.impuestos = new ArrayList<ImpuestosRetenciones>();
	}
	
	@XmlAttribute(name="montoTotOperacion")
	public String getMontoTotOperacion() {
		return montoTotOperacion;
	}

	public void setMontoTotOperacion(String montoTotOperacion) {
		montoTotOperacion = montoTotOperacion;
	}
		
	@XmlAttribute(name="montoTotGrav")
	public String getMontoTotGrav() {
		return montoTotGrav;
	}

	public void setMontoTotGrav(String montoTotGrav) {
		this.montoTotGrav = montoTotGrav;
	}
	
	@XmlAttribute(name="montoTotExent")
	public String getMontoTotExent() {
		return montoTotExent;
	}

	public void setMontoTotExent(String montoTotExent) {
		this.montoTotExent = montoTotExent;
	}
	
	@XmlAttribute(name="montoTotRet")
	public String getMontoTotRet() {
		return montoTotRet;
	}

	public void setMontoTotRet(String montoTotRet) {
		this.montoTotRet = montoTotRet;
	}
	
	@XmlElement(name = "ImpRetenidos")
	public java.util.List<ImpuestosRetenciones> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(java.util.List<ImpuestosRetenciones> impuestos) {
		this.impuestos = impuestos;
	}
	
		
	
	@Override
	public String toString() {
		return "TotalesRetenciones [montoTotOperacion=" + montoTotOperacion + ", montoTotGrav=" + montoTotGrav + ", montoTotExent=" + montoTotExent +", montoTotRet=" +montoTotRet+"]";
	}
	
}