package mx.xpd.cfdi.domain.cfdi.complementos.impuestos;

import javax.validation.constraints.DecimalMax;
import javax.xml.bind.annotation.XmlAttribute;

public class TrasladosLocales {

	@DecimalMax(value = "2")
	private Double importe;
	@DecimalMax(value = "2")
	private Double tasade;
	private String impLoc;
	
	@XmlAttribute(name = "Importe")
	public Double getImporte() {
		return importe;
	}
	@XmlAttribute(name = "TasadeTraslado")
	public Double getTasade() {
		return tasade;
	}
	@XmlAttribute(name = "ImpLocTrasladado")
	public String getImpLoc() {
		return impLoc;
	}
	
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public void setTasade(Double tasade) {
		this.tasade = tasade;
	}
	public void setImpLoc(String impLoc) {
		this.impLoc = impLoc;
	}
		
}
