package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class EmisorNomina12 {
	private String curp;
	private String registroPatronal;
	private String rfcPatronOrigen;
	
	private EntidadSNCFNomina12 entidadSNCF;
	

	public EmisorNomina12() {
		
	}
	
	@XmlAttribute(name = "Curp")
	public String getCurp() {
		return curp;
	}
	
	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	@XmlAttribute(name = "RegistroPatronal")
	public String getRegistroPatronal() {
		return registroPatronal;
	}
	
	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}	
	
	@XmlAttribute(name = "RfcPatronOrigen")
	public String getRfcPatronOrigen() {
		return rfcPatronOrigen;
	}
	
	public void setRfcPatronOrigen(String rfcPatronOrigen) {
		this.rfcPatronOrigen = rfcPatronOrigen;
	}
	
	@XmlElement(name = "EntidadSNCF")
	public EntidadSNCFNomina12 getEntidadSNCF() {
		return entidadSNCF;
	}

	public void setPercepciones(EntidadSNCFNomina12 entidadSNCF) {
		this.entidadSNCF = entidadSNCF;
	}
	
	
	
	
	
	
}
