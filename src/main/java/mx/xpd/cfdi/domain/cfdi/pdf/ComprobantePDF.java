package mx.xpd.cfdi.domain.cfdi.pdf;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.pdf.CfdiRelacionados;
import mx.xpd.cfdi.domain.cfdi.pdf.Emisor;
import mx.xpd.cfdi.domain.cfdi.pdf.Impuestos;
import mx.xpd.cfdi.domain.cfdi.pdf.Receptor;
import mx.xpd.cfdi.domain.cfdi.pdf.Conceptos; 


@XmlRootElement(name="Comprobante")
@XmlType(propOrder={
		"cfdiRelacionados",
		"emisor",
		"receptor",
		"conceptos",
		"impuestos", 
		"complemento", 
		"cartaPorte",
		"firmas"
})
public class ComprobantePDF {
	
	private String version; //
	private String serie;
	private String folio;
	// Se expresa en la forma aaaa-mm-ddThh:mm:ss, de acuerdo con la especificación ISO 8601
	private String fecha;
	private String sello;  //
	private String formaPago;
	private String noCertificado;
	private String certificado; //
	private String condicionesDePago;
	private String subTotal;
	private Double descuento;
	private String tipoCambio;
	private String moneda;
	private String total;
	private String tipoDeComprobante;
	private String tipoComprobante;
	private String metodoPago;
	private String confirmacion;
	private String lugarExpedicion;
	private String numCtaPago;
	private String folioFiscalOrig;
	private String serieFolioFiscalOrig;
	// La forma aaaa-mm-ddThh:mm:ss, de acuerdo con la especificación ISO 8601
	private String fechaFolioFiscalOrig;
	private String montoFolioFiscalOrig;
	private String totalDescuento;
	private String observaciones;
	/* Carta Porte */
	
	private String aDestino;
	private String aOrigen;
	private String conducira;
	private String condujo;
	private String deDestino;
	private String deOrigen;
	private String destinatario;
	private String destino;
	private String domicilioDestino;
	private String domicilioOrigen;
	private String entregarEn;
	private String origen;
	private String recogerEn;
	private String remitente;
	private String rfcDestino;
	private String rfcOrigen;
	
	private String noObjetoIva;
	
	private CfdiRelacionados cfdiRelacionados;
	private Emisor emisor;
	private Receptor receptor;
	private Conceptos conceptos;
	private Impuestos impuestos;
	private Complemento complemento;
	private Firmas firmas;
	private CartaPorte cartaPorte;
	
	
	@XmlAttribute
	public String getNoObjetoIva() {
		return noObjetoIva;
	}
	public void setNoObjetoIva(String noObjetoIva) {
		this.noObjetoIva = noObjetoIva;
	}
	@XmlAttribute
	public String getaDestino() {
		return aDestino;
	}
	@XmlAttribute
	public String getaOrigen() {
		return aOrigen;
	}
	@XmlAttribute
	public String getConducira() {
		return conducira;
	}
	@XmlAttribute
	public String getCondujo() {
		return condujo;
	}
	@XmlAttribute
	public String getDeDestino() {
		return deDestino;
	}
	@XmlAttribute
	public String getDeOrigen() {
		return deOrigen;
	}
	@XmlAttribute
	public String getDestinatario() {
		return destinatario;
	}
	@XmlAttribute
	public String getDestino() {
		return destino;
	}
	@XmlAttribute
	public String getDomicilioDestino() {
		return domicilioDestino;
	}
	@XmlAttribute
	public String getDomicilioOrigen() {
		return domicilioOrigen;
	}
	@XmlAttribute
	public String getEntregarEn() {
		return entregarEn;
	}
	@XmlAttribute
	public String getOrigen() {
		return origen;
	}
	@XmlAttribute
	public String getRecogerEn() {
		return recogerEn;
	}
	@XmlAttribute
	public String getRemitente() {
		return remitente;
	}
	@XmlAttribute
	public String getRfcDestino() {
		return rfcDestino;
	}
	@XmlAttribute
	public String getRfcOrigen() {
		return rfcOrigen;
	}
	@XmlElement(name = "CartaPorte")
	public CartaPorte getCartaPorte() {
		return cartaPorte;
	}
	public void setCartaPorte(CartaPorte cartaPorte) {
		this.cartaPorte = cartaPorte;
	}
	public void setaDestino(String aDestino) {
		this.aDestino = aDestino;
	}
	public void setaOrigen(String aOrigen) {
		this.aOrigen = aOrigen;
	}
	public void setConducira(String conducira) {
		this.conducira = conducira;
	}
	public void setCondujo(String condujo) {
		this.condujo = condujo;
	}
	public void setDeDestino(String deDestino) {
		this.deDestino = deDestino;
	}
	public void setDeOrigen(String deOrigen) {
		this.deOrigen = deOrigen;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void setDomicilioDestino(String domicilioDestino) {
		this.domicilioDestino = domicilioDestino;
	}
	public void setDomicilioOrigen(String domicilioOrigen) {
		this.domicilioOrigen = domicilioOrigen;
	}
	public void setEntregarEn(String entregarEn) {
		this.entregarEn = entregarEn;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public void setRecogerEn(String recogerEn) {
		this.recogerEn = recogerEn;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public void setRfcDestino(String rfcDestino) {
		this.rfcDestino = rfcDestino;
	}
	public void setRfcOrigen(String rfcOrigen) {
		this.rfcOrigen = rfcOrigen;
	}
	@XmlElement(name = "Firmas")
	public Firmas getFirmas() {
		return firmas;
	}
	@XmlAttribute
	public String getTotalDescuento() {
		return totalDescuento;
	}
	@XmlElement(name = "Complemento")
	public Complemento getComplemento() {
		return complemento;
	}
	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}
	@XmlAttribute(name = "Serie")
	public String getSerie() {
		return serie;
	}
	@XmlAttribute(name = "Folio")
	public String getFolio() {
		return folio;
	}
	@XmlAttribute(name = "Fecha")
	public String getFecha() {
		return fecha;
	}
	@XmlAttribute(name = "Sello")
	public String getSello() {
		return sello;
	}
	@XmlAttribute(name = "FormaPago")
	public String getFormaPago() {
		return formaPago;
	}
	@XmlAttribute(name = "NoCertificado")
	public String getNoCertificado() {
		return noCertificado;
	}
	@XmlAttribute(name = "Certificado")
	public String getCertificado() {
		return certificado;
	}
	@XmlAttribute(name = "CondicionesDePago")
	public String getCondicionesDePago() {
		return condicionesDePago;
	}
	@XmlAttribute(name = "SubTotal")
	public String getSubTotal() {
		return subTotal;
	}
	@XmlAttribute(name = "Descuento")
	public Double getDescuento() {
		return descuento;
	}
	@XmlAttribute(name = "TipoCambio")
	public String getTipoCambio() {
		return tipoCambio;
	}
	@XmlAttribute(name = "Moneda")
	public String getMoneda() {
		return moneda;
	}
	@XmlAttribute(name = "Total")
	public String getTotal() {
		return total;
	}
	@XmlAttribute(name = "TipoDeComprobante")
	public String getTipoDeComprobante() {
		return tipoDeComprobante;
	}
	@XmlAttribute(name = "MetodoPago")
	public String getMetodoPago() {
		return metodoPago;
	}
	@XmlAttribute(name = "Confirmacion")
	public String getConfirmacion() {
		return confirmacion;
	}
	@XmlAttribute(name = "LugarExpedicion")
	public String getLugarExpedicion() {
		return lugarExpedicion;
	}
	@XmlAttribute(name = "NumCtaPago")
	public String getNumCtaPago() {
		return numCtaPago;
	} 
	@XmlAttribute(name = "FolioFiscalOrig")
	public String getFolioFiscalOrig() {
		return folioFiscalOrig;
	}
	@XmlAttribute(name = "SerieFolioFiscalOrig")
	public String getSerieFolioFiscalOrig() {
		return serieFolioFiscalOrig;
	}
	@XmlAttribute(name = "FechaFolioFiscalOrig")
	public String getFechaFolioFiscalOrig() {
		return fechaFolioFiscalOrig;
	}
	@XmlAttribute(name = "MontoFolioFiscalOrig")
	public String getMontoFolioFiscalOrig() {
		return montoFolioFiscalOrig;
	}
	@XmlElement(name = "CfdiRelacionados")
	public CfdiRelacionados getCfdiRelacionados() {
		return cfdiRelacionados;
	}	
	@XmlElement(name = "Emisor")
	public Emisor getEmisor() {
		return emisor;
	}
	@XmlElement(name = "Receptor")
	public Receptor getReceptor() {
		return receptor;
	}
	@XmlElement(name = "Impuestos")
	public Impuestos getImpuestos() {
		return impuestos;
	}
	@XmlElement(name = "Conceptos")
	public Conceptos getConceptos() {
		return conceptos;
	}
	@XmlAttribute
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	@XmlAttribute
	public String getObservaciones() {
		return observaciones;
	}
	/*****************************************/
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public void setFirmas(Firmas firmas) {
		this.firmas = firmas;
	}
	public void setTotalDescuento(String totalDescuento) {
		this.totalDescuento = totalDescuento;
	}
	public void setComplemento(Complemento complemento) {
		this.complemento = complemento;
	}
	public void setConceptos(Conceptos conceptos) {
		this.conceptos = conceptos;
	}
	public void setImpuestos(Impuestos impuestos) {
		this.impuestos = impuestos;
	}
	public void setCfdiRelacionados(CfdiRelacionados cfdiRelacionados) {
		this.cfdiRelacionados = cfdiRelacionados;
	}
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setSello(String sello) {
		this.sello = sello;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public void setNoCertificado(String noCertificado) {
		this.noCertificado = noCertificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public void setCondicionesDePago(String condicionesDePago) {
		this.condicionesDePago = condicionesDePago;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public void setTipoDeComprobante(String tipoDeComprobante) {
		this.tipoDeComprobante = tipoDeComprobante;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}
	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}
	public void setNumCtaPago(String numCtaPago) {
		this.numCtaPago = numCtaPago;
	}
	public void setFolioFiscalOrig(String folioFiscalOrig) {
		this.folioFiscalOrig = folioFiscalOrig;
	}
	public void setSerieFolioFiscalOrig(String serieFolioFiscalOrig) {
		this.serieFolioFiscalOrig = serieFolioFiscalOrig;
	}
	public void setFechaFolioFiscalOrig(String fechaFolioFiscalOrig) {
		this.fechaFolioFiscalOrig = fechaFolioFiscalOrig;
	}
	public void setMontoFolioFiscalOrig(String montoFolioFiscalOrig) {
		this.montoFolioFiscalOrig = montoFolioFiscalOrig;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	@Override
	public String toString() {
		return "Comprobante [version=" + version + ", serie=" + serie
				+ ", folio=" + folio + ", fecha=" + fecha + ", sello=" + sello
				+ ", formaPago=" + formaPago + ", noCertificado="
				+ noCertificado + ", certificado=" + certificado
				+ ", condicionesDePago=" + condicionesDePago + ", subTotal="
				+ subTotal + ", descuento=" + descuento + ", tipoCambio=" 
				+ tipoCambio + ", moneda="
				+ moneda + ", total=" + total + ", tipoComprobante="
				+ tipoDeComprobante + ", metodoPago=" + metodoPago
				+ ", LugarExpedicion=" + lugarExpedicion + ", NumCtaPago="
				+ numCtaPago + ", FolioFiscalOrig=" + folioFiscalOrig
				+ ", SerieFolioFiscalOrig=" + serieFolioFiscalOrig
				+ ", FechaFolioFiscalOrig=" + fechaFolioFiscalOrig
				+ ", MontoFolioFiscalOrig=" + montoFolioFiscalOrig
				+ ", emisor=" + emisor + ", receptor=" + receptor
				+ ", conceptos=" + conceptos + "]";
	}
	
}
