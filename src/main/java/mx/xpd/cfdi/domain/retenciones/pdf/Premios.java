package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Premios")
public class Premios {

	private String version = "1.0";
	private String entidadFederativa;
	private String montTotPago;
	private String montTotPagoGrav;
	private String montTotPagoExent;
	
	public Premios() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "EntidadFederativa")
	public String getEntidadFederativa() {
		return entidadFederativa;
	}

	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}

	@XmlAttribute(name = "MontTotPago")
	public String getMontTotPago() {
		return montTotPago;
	}

	public void setMontTotPago(String montTotPago) {
		this.montTotPago = montTotPago;
	}

	@XmlAttribute(name = "MontTotPagoGrav")
	public String getMontTotPagoGrav() {
		return montTotPagoGrav;
	}

	public void setMontTotPagoGrav(String montTotPagoGrav) {
		this.montTotPagoGrav = montTotPagoGrav;
	}

	@XmlAttribute(name = "MontTotPagoExent")
	public String getMontTotPagoExent() {
		return montTotPagoExent;
	}

	public void setMontTotPagoExent(String montTotPagoExent) {
		this.montTotPagoExent = montTotPagoExent;
	}

	

	
}
