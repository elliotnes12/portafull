package mx.xpd.cfdi.domain;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public  class Emisor {
	
	private String rfc;
	private String nombre;
	private String email;
	private TUbicacion domicilio;
	
	
	
	@XmlElement(name = "Domicilio")
	public TUbicacion getDomicilio() {
		return domicilio;
	}
	@XmlAttribute
	public String getRfc() {
		return rfc;
	}
	@XmlAttribute
	public String getNombre() {
		return nombre;
	}
	@Transient
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDomicilio(TUbicacion domicilio) {
		this.domicilio = domicilio;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Emisor [rfc=" + rfc + ", nombre=" + nombre + "]";
	}
	
	
}