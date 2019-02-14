package mx.xpd.cfdi.domain.retenciones.complementos.pagosaextranjeros;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Beneficiario")
public class Beneficiario {

	private String rfcBenef;
	private String curpBenef;
	private String nomDenRazSocBenef;
	private String conceptoPago;
	private String descripcionConcepto;

	
	public Beneficiario() {
		
	}
	
	@XmlAttribute(name = "RFC")
	public String getRfcBenef() {
		return rfcBenef;
	}

	public void setRfcBenef(String rfcBenef) {
		this.rfcBenef = rfcBenef;
	}

	@XmlAttribute(name = "CURP")
	public String getCurpBenef() {
		return curpBenef;
	}

	public void setCurpBenef(String curpBenef) {
		this.curpBenef = curpBenef;
	}

	@XmlAttribute(name = "NomDenRazSocB")
	public String getNomDenRazSocBenef() {
		return nomDenRazSocBenef;
	}

	public void setNomDenRazSocBenef(String nomDenRazSocBenef) {
		this.nomDenRazSocBenef = nomDenRazSocBenef;
	}
	
	@XmlAttribute(name = "ConceptoPago")
	public String getConceptoPago() {
		return conceptoPago;
	}

	public void setConceptoPago(String conceptoPago) {
		this.conceptoPago = conceptoPago;
	}

	@XmlAttribute(name = "DescripcionConcepto")
	public String getDescripcionConcepto() {
		return descripcionConcepto;
	}

	public void setDescripcionConcepto(String descripcionConcepto) {
		this.descripcionConcepto = descripcionConcepto;
	}

	

	

	
}
