package mx.xpd.cfdi.domain.cfdi;

import javax.validation.constraints.DecimalMax;
import javax.xml.bind.annotation.XmlAttribute;

public class Retencion {

	private String importe;
	private String impuesto;
	
	@DecimalMax(value = "6")
	@XmlAttribute
	public String getImporte() {
		return importe;
	}
	@XmlAttribute
	@DecimalMax(value = "6")
	public String getImpuesto() {
		return impuesto;
	}
	
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
}
