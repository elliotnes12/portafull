	package mx.xpd.cfdi.domain.cfdi;

import javax.validation.constraints.DecimalMax;
import javax.xml.bind.annotation.XmlAttribute;

public class ImpuestoTraslado {

	private String impuesto;
	private String tipoFactor;
	private String tasaOCuota;
	private String importe;
	
		
	@XmlAttribute(name = "Impuesto")
	public String getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}
	
	@XmlAttribute(name = "TipoFactor")
	public String getTipoFactor() {
		return tipoFactor;
	}
	public void setTipoFactor(String tipoFactor) {
		this.tipoFactor = tipoFactor;
	}
	
	@XmlAttribute(name = "TasaOCuota")
	public String getTasaOCuota() {
		return tasaOCuota;
	}
	public void setTasa(String tasaOCuota) {
		this.tasaOCuota = tasaOCuota;
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