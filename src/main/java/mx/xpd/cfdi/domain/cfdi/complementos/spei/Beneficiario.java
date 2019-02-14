package mx.xpd.cfdi.domain.cfdi.complementos.spei;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Beneficiario")
public class Beneficiario{

	private String bancoReceptor;
	private String nombreBeneficiarioSpei;
	private String tipoCuentaBeneficiarioSpei;
	private String cuentaBeneficiarioSpei;
	private String rfcBeneficiarioSpei;
	private String conceptoSpei;
	private String ivaSpei;
	private String montoSpei;
	
	
	public Beneficiario() {
		
	}
	
	@XmlAttribute(name = "BancoReceptor")
	public String getBancoReceptor() {
		return bancoReceptor;
	}

	public void setBancoReceptor(String bancoReceptor) {
		this.bancoReceptor = bancoReceptor;
	}
	
	@XmlAttribute(name = "Nombre")
	public String getNombreBeneficiarioSpei() {
		return nombreBeneficiarioSpei;
	}

	public void setNombreBeneficiarioSpei(String nombreBeneficiarioSpei) {
		this.nombreBeneficiarioSpei = nombreBeneficiarioSpei;
	}
	
	@XmlAttribute(name = "TipoCuenta")
	public String getTipoCuentaBeneficiarioSpei() {
		return tipoCuentaBeneficiarioSpei;
	}

	public void setTipoCuentaBeneficiarioSpei(String tipoCuentaBeneficiarioSpei) {
		this.tipoCuentaBeneficiarioSpei = tipoCuentaBeneficiarioSpei;
	}
	
	@XmlAttribute(name = "Cuenta")
	public String getCuentaBeneficiarioSpei() {
		return cuentaBeneficiarioSpei;
	}

	public void setCuentaBeneficiarioSpei(String cuentaBeneficiarioSpei) {
		this.cuentaBeneficiarioSpei = cuentaBeneficiarioSpei;
	}
	
	@XmlAttribute(name = "RFC")
	public String getRfcBeneficiarioSpei() {
		return rfcBeneficiarioSpei;
	}

	public void setRfcBeneficiarioSpei(String rfcBeneficiarioSpei) {
		this.rfcBeneficiarioSpei = rfcBeneficiarioSpei;
	}
		
	@XmlAttribute(name = "Concepto")
	public String getConceptoSpei() {
		return conceptoSpei;
	}

	public void setConceptoSpei(String conceptoSpei) {
		this.conceptoSpei = conceptoSpei;
	}
	
	@XmlAttribute(name = "IVA")
	public String getIVASpei() {
		return ivaSpei;
	}

	public void setIVASpei(String ivaSpei) {
		this.ivaSpei = ivaSpei;
	}
	
	@XmlAttribute(name = "MontoPago")
	public String getMontoSpei() {
		return montoSpei;
	}

	public void setMontoSpei(String montoSpei) {
		this.montoSpei = montoSpei;
	}
}