package mx.xpd.cfdi.domain;

import java.util.List;

public class Cancelacion {


	private String xml;
	private String acuse;
	private String codigoHtml;
	private List<String> uuidParaCancelar;
	private String rfcEmisor;
	private List<String> uuidsRespuesta;
	private List<String> codigosRespuesta;
	
	public String cancelar() {
		
		return "acuse";
	}
	
	public String getXml() {
		return xml;
	}
	public void setXml(String xml) {
		this.xml = xml;
	}
	public String getAcuse() {
		return acuse;
	}
	public void setAcuse(String acuse) {
		this.acuse = acuse;
	}
	public String getCodigoHtml() {
		return codigoHtml;
	}
	public void setCodigoHtml(String codigoHtml) {
		this.codigoHtml = codigoHtml;
	}
	public List<String> getUuidParaCancelar() {
		return uuidParaCancelar;
	}
	public void setUuidParaCancelar(List<String> uuidParaCancelar) {
		this.uuidParaCancelar = uuidParaCancelar;
	}
	public String getRfcEmisor() {
		return rfcEmisor;
	}
	public void setRfcEmisor(String rfcEmisor) {
		this.rfcEmisor = rfcEmisor;
	}
	public List<String> getUuidsRespuesta() {
		return uuidsRespuesta;
	}
	public void setUuidsRespuesta(List<String> uuidsRespuesta) {
		this.uuidsRespuesta = uuidsRespuesta;
	}
	public List<String> getCodigosRespuesta() {
		return codigosRespuesta;
	}
	public void setCodigosRespuesta(List<String> codigosRespuesta) {
		this.codigosRespuesta = codigosRespuesta;
	}	
	
	
}
