package mx.xpd.cfdi.domain.retenciones;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ReceptorNacionalRetenciones {
	
	private String rfcRecep;
	private String nomDenRazSocR;
	private String curpR;
		
		
	public ReceptorNacionalRetenciones() {
		
	}
	
	@XmlAttribute(name = "RFCRecep")
	public String getRfcRecep() {
		return rfcRecep;
	}

	public void setRfcRecep(String rfcRecep) {
		this.rfcRecep = rfcRecep;
	}
	
	@XmlAttribute(name = "NomDenRazSocR")
	public String getNomDenRazSocR() {
		return nomDenRazSocR;
	}

	public void setNomDenRazSocR(String nomDenRazSocR) {
		this.nomDenRazSocR = nomDenRazSocR;
	}
	
	@XmlAttribute(name = "CURPR")
	public String getCurpR() {
		return curpR;
	}

	public void setCurpR(String curpR) {
		this.curpR = curpR;
	}
		
	
	
	@Override
	public String toString() {
		return "ReceptorNacionalRetenciones [rfcRecep=" + rfcRecep + ",nomDenRazSocR=" + nomDenRazSocR +", curpR=" +curpR +"]";
	}
	
}