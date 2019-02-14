package mx.xpd.cfdi.domain.cfdi.pdf;

import java.util.ArrayList;
import java.util.List;

import mx.xpd.cfdi.domain.cfdi.TUbicacion;
import mx.xpd.cfdi.domain.cfdi.pdf.RegimenFiscal;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Emisor {
	
	private String rfc;
	private String nombre;
	private String email;
	private String regimenFiscal;
	
	public Emisor() {
		
	}
	
	
	@XmlAttribute(name = "RegimenFiscal")
	public String getRegimenFiscal() {
		return regimenFiscal;
	}
	@XmlAttribute(name = "Rfc")
	public String getRfc() {
		return rfc;
	}
	@XmlAttribute(name = "Nombre")
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

	
	public void setRegimenFiscal(String regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
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