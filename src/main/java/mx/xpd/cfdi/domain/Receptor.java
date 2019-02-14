package mx.xpd.cfdi.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Receptor {

	private String rfc;
	private String nombre;
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
		return "Receptor [rfc=" + rfc + ", nombre=" + nombre + "]";
	}
	
}
