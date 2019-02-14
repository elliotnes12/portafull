package mx.xpd.cfdi.domain.cfdi.pdf.complementos.comercioexterior;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mx.xpd.cfdi.domain.cfdi.complementos.comercioexterior.Domicilio;

@XmlRootElement(name = "Destinatario")
public class Destinatario{

	private String numRegIdTrib;
	private String nombre;
	private List<Domicilio> domicilio;
	
	public Destinatario() {
		
	}
	
	@XmlAttribute(name = "NumRegIdTrib")
	public String getNumRegIdTrib() {
		return numRegIdTrib;
	}

	public void setNumRegIdTrib(String numRegIdTrib) {
		this.numRegIdTrib = numRegIdTrib;
	}
	

	@XmlAttribute(name = "Nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name = "Domicilio")
	public List<Domicilio> getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(List<Domicilio> domicilio) {
		this.domicilio = domicilio;
	}
	
			
}