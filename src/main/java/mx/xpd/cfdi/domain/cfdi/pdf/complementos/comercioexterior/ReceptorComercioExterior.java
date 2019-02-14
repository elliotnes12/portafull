package mx.xpd.cfdi.domain.cfdi.pdf.complementos.comercioexterior;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Receptor")
public class ReceptorComercioExterior{

	private String numRegIdTrib;
	private Domicilio domicilio;
	
	public ReceptorComercioExterior() {
		
	}
	
	@XmlAttribute(name = "NumRegIdTrib")
	public String getNumRegIdTrib() {
		return numRegIdTrib;
	}

	public void setNumRegIdTrib(String numRegIdTrib) {
		this.numRegIdTrib = numRegIdTrib;
	}
	
	@XmlElement(name = "Domicilio")
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
			
}