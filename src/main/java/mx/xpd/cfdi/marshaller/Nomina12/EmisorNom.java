package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class EmisorNom {
	
	private EntidadSNCF entidadSNCF;
	private String curp;
	private String registroPatronal;
	private String rfcPatronOrigen;
	
	public EmisorNom() {
		entidadSNCF = new EntidadSNCF();
	}
	
	public EmisorNom(String []data) {
		
		entidadSNCF = new EntidadSNCF();
		
		curp = data[1].equals(" ") ? null : data[1];
		registroPatronal = data[2].equals(" ") ? null : data[2];
		rfcPatronOrigen = data[3].equals(" ") ? null : data[3];
		
	}
	
	///////////// GETTERS NODOS
	@XmlElement(name = "EntidadSNCF")
	public EntidadSNCF getEntidadSNCF() {
		return entidadSNCF;
	}
	
	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "Curp")
	public String getCurp() {
		if(curp==null){return null;}
		return curp.trim().equals("") ? null : curp.trim();
		//return curp;
	}
	
	@XmlAttribute(name = "RegistroPatronal")
	public String getRegistroPatronal() {
		if(registroPatronal==null){return null;}
		return registroPatronal.trim().equals("") ? null : registroPatronal.trim();
		//return registroPatronal;
	}
	
	@XmlAttribute(name = "RfcPatronOrigen")
	public String getRfcPatronOrigen() {
		if(rfcPatronOrigen==null){return null;}
		return rfcPatronOrigen.trim().equals("") ? null : rfcPatronOrigen.trim();
		//return rfcPatronOrigen;
	}
	
	///////////// SETTERS NODOS
	public void setEntidadSNCF(EntidadSNCF entidadSNCF) {
		this.entidadSNCF = entidadSNCF;
	}

	///////////// SETTERS ATRIBUTOS
	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}
	
	public void setRfcPatronOrigen(String rfcPatronOrigen) {
		this.rfcPatronOrigen = rfcPatronOrigen;
	}

}
