package mx.xpd.cfdi.domain.cfdi.pdf;

import javax.validation.constraints.DecimalMax;
import javax.xml.bind.annotation.XmlAttribute;

public class ImpuestoRetenciones {

	private String impuesto;
	private String importe;
	
		
	@XmlAttribute(name = "Impuesto")
	public String getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	
	
	@XmlAttribute(name = "Importe")
	@DecimalMax(value = "6")
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	
	
	
	
}