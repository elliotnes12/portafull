package mx.xpd.cfdi.domain.prefactura;

import java.io.Serializable;
import java.util.List;

public class Prefactura implements Serializable {

	private static final long serialVersionUID = 6962609263590562722L;
	private String serie;
	private String folio;
	private String fecha;
	private String tipoComprobante;
	private String receptorNombre;
	private String receptorRfc;
	private String receptorEmail;
	private String receptorUsoCfdi;
	private String receptorResidenciaFiscal;
	private String receptorNumRegIdTrib;
	private ValidadorXml respuesta;
	
	private String emisorNombre;
	private String emisorRfc;
		
	private String formaPago;
	private String condicionespago;
	private String moneda;
	private String tipoCambio;
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							private String metodoPago;
	private String lugarExpedicion;
	private String regimenFiscal;
	private String confirmacion;
	private String tipoRelacion;
	private String observaciones;
	private List<Concepto> conceptos;
	private List<CfdiRelacionado> cfdisRelacionados;

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getReceptorNombre() {
		return receptorNombre;
	}

	public void setReceptorNombre(String receptorNombre) {
		this.receptorNombre = receptorNombre;
	}

	public String getReceptorRfc() {
		return receptorRfc;
	}

	public void setReceptorRfc(String receptorRfc) {
		this.receptorRfc = receptorRfc;
	}

	public String getReceptorEmail() {
		return receptorEmail;
	}

	public void setReceptorEmail(String receptorEmail) {
		this.receptorEmail = receptorEmail;
	}

	public String getReceptorUsoCfdi() {
		return receptorUsoCfdi;
	}

	public void setReceptorUsoCfdi(String receptorUsoCfdi) {
		this.receptorUsoCfdi = receptorUsoCfdi;
	}

	public String getReceptorResidenciaFiscal() {
		return receptorResidenciaFiscal;
	}

	public void setReceptorResidenciaFiscal(String receptorResidenciaFiscal) {
		this.receptorResidenciaFiscal = receptorResidenciaFiscal;
	}

	public String getReceptorNumRegIdTrib() {
		return receptorNumRegIdTrib;
	}

	public void setReceptorNumRegIdTrib(String receptorNumRegIdTrib) {
		this.receptorNumRegIdTrib = receptorNumRegIdTrib;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getCondicionespago() {
		return condicionespago;
	}

	public void setCondicionespago(String condicionespago) {
		this.condicionespago = condicionespago;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public String getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}

	public String getEmisorNombre() {
		return emisorNombre;
	}

	public void setEmisorNombre(String emisorNombre) {
		this.emisorNombre = emisorNombre;
	}

	public String getEmisorRfc() {
		return emisorRfc;
	}

	public void setEmisorRfc(String emisorRfc) {
		this.emisorRfc = emisorRfc;
	}

	public String getLugarExpedicion() {
		return lugarExpedicion;
	}

	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}

	public List<Concepto> getConceptos() {
		return conceptos;
	}

	public void setConceptos(List<Concepto> conceptos) {
		this.conceptos = conceptos;
	}

	public String getRegimenFiscal() {
		return regimenFiscal;
	}

	public void setRegimenFiscal(String regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}

	public String getTipoRelacion() {
		return tipoRelacion;
	}

	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

	public List<CfdiRelacionado> getCfdisRelacionados() {
		return cfdisRelacionados;
	}

	public void setCfdisRelacionados(List<CfdiRelacionado> cfdisRelacionados) {
		this.cfdisRelacionados = cfdisRelacionados;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ValidadorXml getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(ValidadorXml respuesta) {
		this.respuesta = respuesta;
	}
	
}
