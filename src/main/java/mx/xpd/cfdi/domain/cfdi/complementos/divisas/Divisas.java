package mx.xpd.cfdi.domain.cfdi.complementos.divisas;


import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "Divisas")
public class Divisas {

	private String version = "1.0";
	private String tipoOperacionDivisas;
			
	public Divisas() {
		
	}

	@XmlAttribute(name = "version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "tipoOperacion")
	public String getTipoOperacionDivisas() {
		return tipoOperacionDivisas;
	}

	public void setTipoOperacionDivisas(String tipoOperacionDivisas) {
		this.tipoOperacionDivisas = tipoOperacionDivisas;
	}
			
			
}