package mx.xpd.cfdi.domain.cfdi.complementos.aerolineas;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cargo")
public class Cargo{

	private String codigoCargo;
	private String importeCargo;
	
	public Cargo() {
		
	}
	
	@XmlAttribute(name = "CodigoCargo")
	public String getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	@XmlAttribute(name = "Importe")
	public String getImporteCargo() {
		return importeCargo;
	}

	public void setImporteCargo(String importeCargo) {
		this.importeCargo = importeCargo;
	}

		
}