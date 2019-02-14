package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Emisor {
	private String curp;
	private String registroPatronal;
	private String rfcPatronOrigen;
	
	private EntidadSNCF entidadSNCF;
	

	public Emisor() {
		
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
	public EntidadSNCF getEntidadSNCF() {
		return entidadSNCF;
	}

	public void setEntidadSNCF(EntidadSNCF entidadSNCF) {
		this.entidadSNCF = entidadSNCF;
	}
	
	
	
	
	
	
}
