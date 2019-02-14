package mx.xpd.cfdi.domain.cfdi.pdf.complementos.comercioexterior;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Propietario")
public class Propietario{

	private String numRegIdTrib;
	private String residenciaFiscal;
	
	public Propietario() {
		
	}
	
	@XmlAttribute(name = "NumRegIdTrib")
	public String getNumRegIdTrib() {
		return numRegIdTrib;
	}

	public void setNumRegIdTrib(String numRegIdTrib) {
		this.numRegIdTrib = numRegIdTrib;
	}
	
	@XmlAttribute(name = "ResidenciaFiscal")
	public String getResidenciaFiscal() {
		return residenciaFiscal;
	}

	public void setResidenciaFiscal(String residenciaFiscal) {
		this.residenciaFiscal = residenciaFiscal;
	}
	
			
}