package mx.xpd.cfdi.domain.cfdi.pdf.complementos.spei;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "SPEI_Tercero")
public class SPEI_Tercero{

	private String fechaSpei;
	private String horaSpei;
	private String claveSpei;
	private String selloSpei;
	private String numeroCertificado;
	private String cadenaCDA;
	private Ordenante ordenante;
	private Beneficiario beneficiario;
	
	public SPEI_Tercero() {
		
	}
	
	@XmlAttribute(name = "FechaOperacion")
	public String getFechaSpei() {
		return fechaSpei;
	}

	public void setFechaSpei(String fechaSpei) {
		this.fechaSpei = fechaSpei;
	}
	
	@XmlAttribute(name = "Hora")
	public String getHoraSpei() {
		return horaSpei;
	}

	public void setHoraSpei(String horaSpei) {
		this.horaSpei = horaSpei;
	}
	
	@XmlAttribute(name = "ClaveSPEI")
	public String getClaveSpei() {
		return claveSpei;
	}

	public void setClaveSPEI(String claveSpei) {
		this.claveSpei = claveSpei;
	}
	
	@XmlAttribute(name = "sello")
	public String getSelloSpei() {
		return selloSpei;
	}

	public void setSelloSpei(String selloSpei) {
		this.selloSpei = selloSpei;
	}
	
	@XmlAttribute(name = "numeroCertificado")
	public String getNumeroCertificado() {
		return numeroCertificado;
	}

	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}
	
	@XmlAttribute(name = "cadenaCDA")
	public String getCadenaCDA() {
		return cadenaCDA;
	}

	public void setCadenaCDA(String cadenaCDA) {
		this.cadenaCDA = cadenaCDA;
	}
	
	@XmlElement(name = "Ordenante")
	public Ordenante getOrdenante() {
		return ordenante;
	}

	public void setOrdenante(Ordenante ordenante) {
		this.ordenante = ordenante;
	}
	
	@XmlElement(name = "Beneficiario")
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
		
}