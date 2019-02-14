package mx.xpd.cfdi.domain.cfdi;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="Comprobante")
@XmlType(propOrder={
		"cfdiRelacionados",
		"emisor",
		"receptor",
		"conceptos",
		"impuestos", 
		"complemento"
//		"addenda"
})
@XmlSeeAlso({Comprobante.class}) 
public class Comprobante {
	
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
	private String descuento;
	private String tipoCambio;
	private String moneda;
	private String total;
	private String tipoDeComprobante;
	private String metodoPago;
	private String confirmacion;
	private String lugarExpedicion;
	private String numCtaPago;
	private String folioFiscalOrig;
	private String serieFolioFiscalOrig;
	private String fechaFolioFiscalOrig;
	private String montoFolioFiscalOrig;
	
	private CfdiRelacionados cfdiRelacionados;
	private Emisor emisor;
	private Receptor receptor;
	private Conceptos conceptos;
	private Impuestos impuestos;
	private Complemento complemento;
	
	@XmlElement(name = "Complemento")
	public Complemento getComplemento() {
		return complemento;
	}

	public void setComplemento(Complemento complemento) {
		this.complemento = complemento;
	}

	public void setConceptos(Conceptos conceptos) {
		this.conceptos = conceptos;
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
	public String getDescuento() {
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
		String result = "";
		try {
			result = new String(lugarExpedicion.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
		if (impuestos!=null){
			if ((impuestos.getImpuestoTraslados() ==null)&&(impuestos.getImpuestoRetenciones() ==null)){
				return null;
			}
		}
		return impuestos;
	}
	@XmlElement(name = "Conceptos")
	public Conceptos getConceptos() {
		return conceptos;
	}
	/*****************************************/
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
	public void setDescuento(String descuento) {
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
	@Override
	public String toString() {
		return "Comprobante [version=" + version + ", serie=" + serie
				+ ", folio=" + folio + ", fecha=" + fecha + ", sello=" + sello
				+ ", formaPago=" + formaPago + ", noCertificado="
				+ noCertificado + ", certificado=" + certificado
				+ ", condicionesDePago=" + condicionesDePago + ", subTotal="
				+ subTotal + ", descuento=" + descuento + ", tipoCambio=" + tipoCambio + ", moneda="
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
