package mx.xpd.cfdi.domain.cfdi.pdf.complementos.aerolineas;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Aerolineas")
public class Aerolineas {

	private String version = "1.0";
	private String tua;
	private OtrosCargos otrosCargos;
		
	public Aerolineas() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "TUA")
	public String getTua() {
		return tua;
	}

	public void setTua(String tua) {
		this.tua = tua;
	}
	
	@XmlElement(name = "OtrosCargos")
	public OtrosCargos getOtrosCargos() {
		return otrosCargos;
	}

	public void setOtrosCargos(OtrosCargos otrosCargos) {
		this.otrosCargos = otrosCargos;
	}

	



		
			
}