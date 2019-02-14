package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Intereses")
public class Intereses {

	private String version = "1.0";
	private String sistFinanciero;
	private String retiroAORESRetInt;
	private String operFinancDerivad;
	private String montIntNominal;
	private String montIntReal;
	private String perdida;
	
	public Intereses() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "SistFinanciero")
	public String getSistFinanciero() {
		return sistFinanciero;
	}

	public void setSistFinanciero(String sistFinanciero) {
		this.sistFinanciero = sistFinanciero;
	}

	@XmlAttribute(name = "RetiroAORESRetInt")
	public String getRetiroAORESRetInt() {
		return retiroAORESRetInt;
	}

	public void setRetiroAORESRetInt(String retiroAORESRetInt) {
		this.retiroAORESRetInt = retiroAORESRetInt;
	}

	@XmlAttribute(name = "OperFinancDerivad")
	public String getOperFinancDerivad() {
		return operFinancDerivad;
	}

	public void setOperFinancDerivad(String operFinancDerivad) {
		this.operFinancDerivad = operFinancDerivad;
	}

	@XmlAttribute(name = "MontIntNominal")
	public String getMontIntNominal() {
		return montIntNominal;
	}

	public void setMontIntNominal(String montIntNominal) {
		this.montIntNominal = montIntNominal;
	}
	
	@XmlAttribute(name = "MontIntReal")
	public String getMontIntReal() {
		return montIntReal;
	}

	public void setMontIntReal(String montIntReal) {
		this.montIntReal = montIntReal;
	}
	
	@XmlAttribute(name = "Perdida")
	public String getPerdida() {
		return perdida;
	}

	public void setPerdida(String perdida) {
		this.perdida = perdida;
	}

	


	
}
