package mx.xpd.cfdi.domain.cfdi.complementos.impuestos;

import javax.validation.constraints.DecimalMax;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class RetencionesLocales {
	
	@DecimalMax(value = "2")
	@XmlAttribute(name = "Importe", required = true)
	private Double importe;
	@DecimalMax(value = "2")
	@XmlAttribute(name = "TasadeRetencion", required = true)
	private Double tasade;
	@XmlAttribute(name = "ImpLocRetenido", required = true)
	private String impLoc;
	
	public Double getImporte() {
		return importe;
	}
	public Double getTasade() {
		return tasade;
	}
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
