package mx.xpd.cfdi.domain.cfdi.pdf.complementos.comercioexterior;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "Emisor")
public class EmisorComercioExterior{

	private String curp;
	private Domicilio domicilio;
	
	public EmisorComercioExterior() {
		
	}
	
	@XmlAttribute(name = "Curp")
	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	@XmlElement(name = "Domicilio")
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
			
}