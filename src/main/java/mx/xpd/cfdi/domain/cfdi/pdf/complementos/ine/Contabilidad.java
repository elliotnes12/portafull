package mx.xpd.cfdi.domain.cfdi.pdf.complementos.ine;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Contabilidad")
public class Contabilidad{

	private String idContabilidad;
		
	public Contabilidad() {
		
	}
	
	@XmlAttribute(name = "IdContabilidad")
	public String getIdContabilidad() {
		return idContabilidad;
	}

	public void setIdContabilidad(String idContabilidad) {
		this.idContabilidad = idContabilidad;
	}

	
		
}