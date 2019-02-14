package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "InteresesHipotecarios")
public class InteresesHipotecarios {

	private String version = "1.0";
	private String creditoDeInstFinanc;
	private String saldoInsoluto;
	private String propDeducDelCredit;
	private String montTotIntNominalesDev;
	private String montTotIntNominalesDevYPag;
	private String montTotIntRealPagDeduc;
	private String numContrato;
	
	public InteresesHipotecarios() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "CreditoDeInstFinanc")
	public String getCreditoDeInstFinanc() {
		return creditoDeInstFinanc;
	}

	public void setCreditoDeInstFinanc(String creditoDeInstFinanc) {
		this.creditoDeInstFinanc = creditoDeInstFinanc;
	}
	
	@XmlAttribute(name = "SaldoInsoluto")
	public String getSaldoInsoluto() {
		return saldoInsoluto;
	}

	public void setSaldoInsoluto(String saldoInsoluto) {
		this.saldoInsoluto = saldoInsoluto;
	}
	
	@XmlAttribute(name = "PropDeducDelCredit")
	public String getPropDeducDelCredit() {
		return propDeducDelCredit;
	}

	public void setPropDeducDelCredit(String propDeducDelCredit) {
		this.propDeducDelCredit = propDeducDelCredit;
	}

	@XmlAttribute(name = "MontTotIntNominalesDev")
	public String getMontTotIntNominalesDev() {
		return montTotIntNominalesDev;
	}

	public void setMontTotIntNominalesDev(String montTotIntNominalesDev) {
		this.montTotIntNominalesDev = montTotIntNominalesDev;
	}

	@XmlAttribute(name = "MontTotIntNominalesDevYPag")
	public String getMontTotIntNominalesDevYPag() {
		return montTotIntNominalesDevYPag;
	}

	public void setMontTotIntNominalesDevYPag(String montTotIntNominalesDevYPag) {
		this.montTotIntNominalesDevYPag = montTotIntNominalesDevYPag;
	}

	@XmlAttribute(name = "MontTotIntRealPagDeduc")
	public String getMontTotIntRealPagDeduc() {
		return montTotIntRealPagDeduc;
	}

	public void setMontTotIntRealPagDeduc(String montTotIntRealPagDeduc) {
		this.montTotIntRealPagDeduc = montTotIntRealPagDeduc;
	}

	@XmlAttribute(name = "NumContrato")
	public String getNumContrato() {
		return numContrato;
	}

	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	
			
}
