package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.retenciones.pdf.ReceptorExtranjeroRetenciones;
import mx.xpd.cfdi.domain.retenciones.pdf.ReceptorNacionalRetenciones;


@XmlRootElement(name = "Pagosaextranjeros")
public class PagosAExtranjeros {

	private String version = "1.0";
	private String esBenefEfectDelCobro;
	private Beneficiario beneficiario;
	private NoBeneficiario noBeneficiario;
	
	public PagosAExtranjeros() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "EsBenefEfectDelCobro")
	public String getEsBenefEfectDelCobro() {
		return esBenefEfectDelCobro;
	}

	public void setEsBenefEfectDelCobro(String esBenefEfectDelCobro) {
		this.esBenefEfectDelCobro = esBenefEfectDelCobro;
	}

	@XmlElement(name = "Beneficiario")
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	@XmlElement(name = "NoBeneficiario")
	public NoBeneficiario getNoBeneficiario() {
		return noBeneficiario;
	}

	public void setNoBeneficiario(NoBeneficiario noBeneficiario) {
		this.noBeneficiario = noBeneficiario;
	}

	
	
}
