package mx.xpd.cfdi.domain.cfdi;

import javax.xml.bind.annotation.XmlAttribute;
public class Receptor {

	private String rfc;
	private String nombre;
	private String residenciaFiscal;
	private String numRegIdTrib;
	private String usoCFDI;
	
	@XmlAttribute(name = "Rfc")
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	@XmlAttribute(name = "Nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	@Override
	public String toString() {
		return "Receptor [rfc=" + rfc + ", nombre=" + nombre + "]";
	}
	
}
