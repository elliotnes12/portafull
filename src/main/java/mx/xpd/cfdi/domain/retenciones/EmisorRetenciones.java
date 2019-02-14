package mx.xpd.cfdi.domain.retenciones;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class EmisorRetenciones {
	
	private String RFCEmisor;
	private String NomDenRazSocE;
	private String CURPE;
	
		
	public EmisorRetenciones() {
		
	}
	
	@XmlAttribute(name="RFCEmisor")
	public String getRFCEmisor() {
		return RFCEmisor;
	}
	
	public void setRFCEmisor(String RFCEmisor) {
		this.RFCEmisor = RFCEmisor;
	}
	
	@XmlAttribute(name="NomDenRazSocE")
	public String getNomDenRazSocE() {
		return NomDenRazSocE;
	}

	public void setNomDenRazSocE(String NomDenRazSocE) {
		this.NomDenRazSocE = NomDenRazSocE;
	}
	
	@XmlAttribute(name="CURPE")
	public String getCURPE() {
		return CURPE;
	}

	public void setCURPE(String CURPE) {
		this.CURPE = CURPE;
	}
		
	
	@Override
	public String toString() {
		return "Emisor [RFCEmisor=" + RFCEmisor + ", NomDenRazSocE=" + NomDenRazSocE + ", CURPE=" + CURPE +"]";
	}
	
}