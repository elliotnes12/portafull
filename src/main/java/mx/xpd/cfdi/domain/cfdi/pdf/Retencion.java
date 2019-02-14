package mx.xpd.cfdi.domain.cfdi.pdf;

import javax.validation.constraints.DecimalMax;
import javax.xml.bind.annotation.XmlAttribute;

public class Retencion {

	private Double importe;
	private String impuesto;
	
	@DecimalMax(value = "6")
	@XmlAttribute
	public Double getImporte() {
		return importe;
	}
	@XmlAttribute
	@DecimalMax(value = "6")
	public String getImpuesto() {
		return impuesto;
	}
	
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
}
