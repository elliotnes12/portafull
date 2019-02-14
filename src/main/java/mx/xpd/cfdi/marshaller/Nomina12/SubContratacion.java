package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;

public class SubContratacion {
	
	private String rfcLabora;
	private String porcentajeTiempo;
	
	public SubContratacion() {
		
	}
	
	public SubContratacion(String []data) {
		
		rfcLabora = data[1].equals(" ") ? null : data[1];
		porcentajeTiempo = data[2].equals(" ") ? null : (data[2]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "RfcLabora")
	public String getRfcLabora() {
		if(rfcLabora==null){return null;}
		return rfcLabora.trim().equals("") ? null : rfcLabora.trim();
		//return rfcLabora;
	}

	@XmlAttribute(name = "PorcentajeTiempo")
	public String getPorcentajeTiempo() {
		if(porcentajeTiempo==null){return null;}
		return porcentajeTiempo.trim().equals("") ? null : porcentajeTiempo.trim();
	}

	
	///////////// SETTERS ATRIBUTOS
	public void setRfcLabora(String rfcLabora) {
		this.rfcLabora = rfcLabora;
	}

	public void setPorcentajeTiempo(String porcentajeTiempo) {
		this.porcentajeTiempo = porcentajeTiempo;
	}
}
