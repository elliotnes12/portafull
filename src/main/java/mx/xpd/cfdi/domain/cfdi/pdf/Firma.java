package mx.xpd.cfdi.domain.cfdi.pdf;

import javax.xml.bind.annotation.XmlAttribute;


public class Firma {

	private String nombre;
	private String puesto;
	private String extra;
	
	@XmlAttribute
	public String getNombre() {
		return nombre;
	}
	@XmlAttribute
	public String getPuesto() {
		return puesto;
	}
	@XmlAttribute
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	
	
}
