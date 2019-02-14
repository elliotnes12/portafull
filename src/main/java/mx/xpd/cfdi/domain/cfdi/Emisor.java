package mx.xpd.cfdi.domain.cfdi;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Emisor {
	
	private String rfc;
	private String nombre;
	private String regimenFiscal;
	private TUbicacion domicilioFiscal;
	private TUbicacion expedidoEn;
	
	
	public Emisor() {
	
	}
	
	@XmlElement(name = "DomicilioFiscal")
	public TUbicacion getDomicilioFiscal() {
		return domicilioFiscal;
	}
	@XmlElement(name = "ExpedidoEn")
	public TUbicacion getExpedidoEn() {
		return expedidoEn;
	}
	@XmlAttribute(name = "Rfc")
	public String getRfc() {
		return rfc;
	}
	@XmlAttribute(name = "Nombre")
	public String getNombre() {
		return nombre;
	}
	@XmlAttribute(name = "RegimenFiscal")
	public String getRegimenFiscal() {
		return regimenFiscal;
	}
	public void setExpedidoEn(TUbicacion expedidoEn) {
		this.expedidoEn = expedidoEn;
	}
	
	public void setDomicilioFiscal(TUbicacion domicilioFiscal) {
		this.domicilioFiscal = domicilioFiscal;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setRegimenFiscal(String regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}
	@Override
	public String toString() {
		return "Emisor [rfc=" + rfc + ", nombre=" + nombre + "]";
	}
	
}