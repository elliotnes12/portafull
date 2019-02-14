package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;

public class SubsidioAlEmpleo {
	
	private String subsidioCausado;
	
	public SubsidioAlEmpleo() {
		
	}
	
	public SubsidioAlEmpleo(String []data) {
		
		subsidioCausado = data[1].equals(" ") ? null : (data[1]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "SubsidioCausado")
	public String getSubsidioCausado() {
		if(subsidioCausado==null){return null;}
		return subsidioCausado.trim().equals("") ? null : subsidioCausado.trim();
	}

	
	///////////// SETTERS ATRIBUTOS
	public void setSubsidioCausado(String subsidioCausado) {
		this.subsidioCausado = subsidioCausado;
	}

}
