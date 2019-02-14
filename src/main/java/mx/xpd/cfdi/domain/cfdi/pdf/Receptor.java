package mx.xpd.cfdi.domain.cfdi.pdf;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Receptor {

	private String rfc;
	private String nombre;
	private String residenciaFiscal;
	private String numRegIdTrib;
	private String usoCFDI;
	private String email;
	
	
	@XmlAttribute(name = "Rfc")
	public String getRfc() {
		return rfc;
	}
	@XmlAttribute(name = "Nombre")
	public String getNombre() {
		return nombre;
	}
	@XmlAttribute(name = "ResidenciaFiscal")
	public String getResidenciaFiscal() {
		return residenciaFiscal;
	}
	public void setResidenciaFiscal(String residenciaFiscal) {
		this.residenciaFiscal = residenciaFiscal;
	}
	@XmlAttribute(name = "NumRegIdTrib")
	public String getNumRegIdTrib() {
		return numRegIdTrib;
	}
	public void setNumRegIdTrib(String numRegIdTrib) {
		this.numRegIdTrib = numRegIdTrib;
	}
	@XmlAttribute(name = "UsoCFDI")
	public String getUsoCFDI() {
		return usoCFDI;
	}
	public void setUsoCFDI(String usoCFDI) {
		this.usoCFDI = usoCFDI;
	}
	@Transient
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
