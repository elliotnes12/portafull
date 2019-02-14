package mx.xpd.cfdi.domain.cfdi.pdf.complementos.ecc12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Traslado")
public class TrasladoConsumoCombustibles12 {

	private String impuestoTrasladoECC12;
	private String tasaoCuotaECC12;
	private String importeTrasladoECC12;
	
	public TrasladoConsumoCombustibles12() {
		
	}

	@XmlAttribute(name = "Impuesto")
	public String getImpuestoTrasladoECC12() {
		return impuestoTrasladoECC12;
	}

	public void setImpuestoTrasladoECC12(String impuestoTrasladoECC12) {
		this.impuestoTrasladoECC12 = impuestoTrasladoECC12;
	}

	@XmlAttribute(name = "TasaoCuota")
	public String getTasaoCuotaECC12() {
		return tasaoCuotaECC12;
	}

	public void setTasaoCuotaECC12(String tasaoCuotaECC12) {
		this.tasaoCuotaECC12 = tasaoCuotaECC12;
	}

	@XmlAttribute(name = "Importe")
	public String getImporteTrasladoECC12() {
		return importeTrasladoECC12;
	}

	public void setImporteTrasladoECC12(String importeTrasladoECC12) {
		this.importeTrasladoECC12 = importeTrasladoECC12;
	}

	
	
	
	
	
	
	
		
	
}
