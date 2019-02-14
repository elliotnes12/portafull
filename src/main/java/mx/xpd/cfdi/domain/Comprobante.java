package mx.xpd.cfdi.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mx.xpd.cfdi.domain.cfdi.Complemento;



@XmlRootElement(name="Comprobante")
public class Comprobante {
	
	private String version; //
	private String serie;
	private String folio;
	// Se expresa en la forma aaaa-mm-ddThh:mm:ss, de acuerdo con la especificación ISO 8601
	private String fecha;
	private String sello;  //
	private String formaDePago;
	private String noCertificado;
	private String certificado; //
	private String condicionesDePago;
	private Double subTotal;
	private Double descuento;
	private String motivoDescuento;
	private String tipoCambio;
	private String moneda;
	private Double total;
	private String tipoComprobante;
	private String metodoDePago;
	private String LugarExpedicion;
	private String NumCtaPago;
	private String FolioFiscalOrig;
	private String SerieFolioFiscalOrig;
	// La forma aaaa-mm-ddThh:mm:ss, de acuerdo con la especificación ISO 8601
	private String FechaFolioFiscalOrig;
	private String MontoFolioFiscalOrig;
	
	private Emisor emisor;
	private Receptor receptor;
	private Conceptos conceptos;
	private Complemento complemento;
	
	@XmlElement(name = "Complemento")
	public Complemento getComplemento() {
		return complemento;
	}

	public void setComplemento(Complemento complemento) {
		this.complemento = complemento;
	}

	@XmlElement(name = "Conceptos")
	public Conceptos getConceptos() {
		return conceptos;
	}
	public void setConceptos(Conceptos conceptos) {
		this.conceptos = conceptos;
	}
	@XmlElement(name = "Receptor")
	public Receptor getReceptor() {
		return receptor;
	}
	@XmlElement(name = "Emisor")
	public Emisor getEmisor() {
		return emisor;
	}
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	@XmlAttribute
	public String getSerie() {
		return serie;
	}
	@XmlAttribute
	public String getFolio() {
		return folio;
	}
	@XmlAttribute
	public String getFecha() {
		return fecha;
	}
	@XmlAttribute
	public String getSello() {
		return sello;
	}
	@XmlAttribute
	public String getFormaDePago() {
		return formaDePago;
	}
	@XmlAttribute
	public String getNoCertificado() {
		return noCertificado;
	}
	@XmlAttribute
	public String getCertificado() {
		return certificado;
	}
	@XmlAttribute
	public String getCondicionesDePago() {
		return condicionesDePago;
	}
	@XmlAttribute
	public Double getSubTotal() {
		return subTotal;
	}
	@XmlAttribute
	public Double getDescuento() {
		return descuento;
	}
	@XmlAttribute
	public String getMotivoDescuento() {
		return motivoDescuento;
	}
	@XmlAttribute
	public String getTipoCambio() {
		return tipoCambio;
	}
	@XmlAttribute
	public String getMoneda() {
		return moneda;
	}
	@XmlAttribute
	public Double getTotal() {
		return total;
	}
	@XmlAttribute
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	@XmlAttribute
	public String getMetodoDePago() {
		return metodoDePago;
	}
	@XmlAttribute
	public String getLugarExpedicion() {
		return LugarExpedicion;
	}
	@XmlAttribute
	public String getNumCtaPago() {
		return NumCtaPago;
	}
	@XmlAttribute
	public String getFolioFiscalOrig() {
		return FolioFiscalOrig;
	}
	@XmlAttribute
	public String getSerieFolioFiscalOrig() {
		return SerieFolioFiscalOrig;
	}
	@XmlAttribute
	public String getFechaFolioFiscalOrig() {
		return FechaFolioFiscalOrig;
	}
	@XmlAttribute
	public String getMontoFolioFiscalOrig() {
		return MontoFolioFiscalOrig;
	}
	/*****************************************/
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
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
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
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public void setMotivoDescuento(String motivoDescuento) {
		this.motivoDescuento = motivoDescuento;
	}
	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	public void setLugarExpedicion(String lugarExpedicion) {
		LugarExpedicion = lugarExpedicion;
	}
	public void setNumCtaPago(String numCtaPago) {
		NumCtaPago = numCtaPago;
	}
	public void setFolioFiscalOrig(String folioFiscalOrig) {
		FolioFiscalOrig = folioFiscalOrig;
	}
	public void setSerieFolioFiscalOrig(String serieFolioFiscalOrig) {
		SerieFolioFiscalOrig = serieFolioFiscalOrig;
	}
	public void setFechaFolioFiscalOrig(String fechaFolioFiscalOrig) {
		FechaFolioFiscalOrig = fechaFolioFiscalOrig;
	}
	public void setMontoFolioFiscalOrig(String montoFolioFiscalOrig) {
		MontoFolioFiscalOrig = montoFolioFiscalOrig;
	}
	
	

	
	
	
}