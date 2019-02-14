package mx.xpd.cfdi.domain.cfdi.complementos.comercioexterior;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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