package mx.xpd.cfdi.domain.cfdi.complementos.pagos;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Pago")
public class Pago{

	private String fechaPago;
	private String formaDePagoP;
	private String monedaP;
	private String tipoCambioP;
	private String monto;
	private String numOperacion;
	private String rfcEmisorCtaOrd;
	private String nomBancoOrdExt;
	private String ctaOrdenante;
	private String rfcEmisorCtaBen;
	private String ctaBeneficiario;
	private String tipoCadPago;
	private String certPago;
	private String cadPago;
	private String selloPago;
	
	private List<DoctoRelacionado> doctoRelacionado;
	
	public Pago() {
		
	}
	
	@XmlAttribute(name = "FechaPago")
	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	@XmlAttribute(name = "FormaDePagoP")
	public String getFormaDePagoP() {
		return formaDePagoP;
	}

	public void setFormaDePagoP(String formaDePagoP) {
		this.formaDePagoP = formaDePagoP;
	}

	@XmlAttribute(name = "MonedaP")
	public String getMonedaP() {
		return monedaP;
	}

	public void setMonedaP(String monedaP) {
		this.monedaP = monedaP;
	}

	@XmlAttribute(name = "TipoCambioP")
	public String getTipoCambioP() {
		return tipoCambioP;
	}

	public void setTipoCambioP(String tipoCambioP) {
		this.tipoCambioP = tipoCambioP;
	}

	@XmlAttribute(name = "Monto")
	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	@XmlAttribute(name = "NumOperacion")
	public String getNumOperacion() {
		return numOperacion;
	}

	public void setNumOperacion(String numOperacion) {
		this.numOperacion = numOperacion;
	}

	@XmlAttribute(name = "RfcEmisorCtaOrd")
	public String getRfcEmisorCtaOrd() {
		return rfcEmisorCtaOrd;
	}

	public void setRfcEmisorCtaOrd(String rfcEmisorCtaOrd) {
		this.rfcEmisorCtaOrd = rfcEmisorCtaOrd;
	}

	@XmlAttribute(name = "NomBancoOrdExt")
	public String getNomBancoOrdExt() {
		return nomBancoOrdExt;
	}

	public void setNomBancoOrdExt(String nomBancoOrdExt) {
		this.nomBancoOrdExt = nomBancoOrdExt;
	}

	@XmlAttribute(name = "CtaOrdenante")
	public String getCtaOrdenante() {
		return ctaOrdenante;
	}

	public void setCtaOrdenante(String ctaOrdenante) {
		this.ctaOrdenante = ctaOrdenante;
	}

	@XmlAttribute(name = "RfcEmisorCtaBen")
	public String getRfcEmisorCtaBen() {
		return rfcEmisorCtaBen;
	}

	public void setRfcEmisorCtaBen(String rfcEmisorCtaBen) {
		this.rfcEmisorCtaBen = rfcEmisorCtaBen;
	}

	@XmlAttribute(name = "CtaBeneficiario")
	public String getCtaBeneficiario() {
		return ctaBeneficiario;
	}

	public void setCtaBeneficiario(String ctaBeneficiario) {
		this.ctaBeneficiario = ctaBeneficiario;
	}

	@XmlAttribute(name = "TipoCadPago")
	public String getTipoCadPago() {
		return tipoCadPago;
	}

	public void setTipoCadPago(String tipoCadPago) {
		this.tipoCadPago = tipoCadPago;
	}

	@XmlAttribute(name = "CertPago")
	public String getCertPago() {
		return certPago;
	}

	public void setCertPago(String certPago) {
		this.certPago = certPago;
	}

	@XmlAttribute(name = "CadPago")
	public String getCadPago() {
		return cadPago;
	}

	public void setCadPago(String cadPago) {
		this.cadPago = cadPago;
	}

	@XmlAttribute(name = "SelloPago")
	public String getSelloPago() {
		return selloPago;
	}

	public void setSelloPago(String selloPago) {
		this.selloPago = selloPago;
	}
	
	@XmlElement(name = "DoctoRelacionado")
	public List<DoctoRelacionado> getDoctoRelacionado() {
		return doctoRelacionado;
	}

	public void setDoctoRelacionado(List<DoctoRelacionado> doctoRelacionado) {
		this.doctoRelacionado = doctoRelacionado;
	}

		
}