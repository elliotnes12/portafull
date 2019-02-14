package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class SubContratacionNomina12 {
	private String rfcLabora;
	private String porcentajeTiempo;

	public SubContratacionNomina12() {
		
	}
	
	@XmlAttribute(name = "RfcLabora")
	public String getRfcLabora() {
		return rfcLabora;
	}
	
	public void setRfcLabora(String rfcLabora) {
		this.rfcLabora = rfcLabora;
	}
	
	@XmlAttribute(name = "PorcentajeTiempo")
	public String getPorcentajeTiempo() {
		return porcentajeTiempo;
	}
	
	public void setPorcentajeTiempo(String porcentajeTiempo) {
		this.porcentajeTiempo = porcentajeTiempo;
	}	
		
}
