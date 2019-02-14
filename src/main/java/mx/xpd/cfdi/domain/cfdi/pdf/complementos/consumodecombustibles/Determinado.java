package mx.xpd.cfdi.domain.cfdi.pdf.complementos.consumodecombustibles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Determinado")
public class Determinado {

	private String tipoImpuesto;
	private String tasaImpuesto;
	private String importeImpuesto;
	
	public Determinado() {
		
	}

	@XmlAttribute(name = "impuesto")
	public String getTipoImpuesto() {
		return tipoImpuesto;
	}

	public void setTipoImpuesto(String tipoImpuesto) {
		this.tipoImpuesto = tipoImpuesto;
	}

	@XmlAttribute(name = "tasaOCuota")
	public String getTasaImpuesto() {
		return tasaImpuesto;
	}

	public void setTasaImpuesto(String tasaImpuesto) {
		this.tasaImpuesto = tasaImpuesto;
	}

	@XmlAttribute(name = "importe")
	public String getImporteImpuesto() {
		return importeImpuesto;
	}

	public void setImporteImpuesto(String importeImpuesto) {
		this.importeImpuesto = importeImpuesto;
	}

	
	
	
	
	
	
	
		
	
}
