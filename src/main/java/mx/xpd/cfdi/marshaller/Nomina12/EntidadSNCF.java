package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;

public class EntidadSNCF {
	
	private String origenRecurso;
	private String montoRecursoPropio;
	
	public EntidadSNCF() {
		
	}
	
	public EntidadSNCF(String []data) {
		
		origenRecurso = data[1].equals(" ") ? null : data[1];
		montoRecursoPropio = data[2].equals(" ") ? null : (data[2]);
		
	}
	
	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "OrigenRecurso")
	public String getOrigenRecurso() {
		if(origenRecurso==null){return null;}
		return origenRecurso.trim().equals("") ? null : origenRecurso.trim();
		//return origenRecurso;
	}
	
	@XmlAttribute(name = "MontoRecursoPropio")
	public String getMontoRecursoPropio() {
		if(montoRecursoPropio==null){return null;}
		return montoRecursoPropio.trim().equals("") ? null : montoRecursoPropio.trim();
	}
	
	///////////// SETTERS ATRIBUTOS
	public void setOrigenRecurso(String origenRecurso) {
		this.origenRecurso = origenRecurso;
	}
	
	public void setMontoRecursoPropio(String montoRecursoPropio) {
		this.montoRecursoPropio = montoRecursoPropio;
	}
	
	

}
