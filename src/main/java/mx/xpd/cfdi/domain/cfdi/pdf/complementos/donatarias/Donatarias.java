package mx.xpd.cfdi.domain.cfdi.pdf.complementos.donatarias;

import javax.xml.bind.annotation.XmlAttribute;

public class Donatarias {

	private String version;
	private String noAutorizacion;
	private String fechaAutorizacion;
	private String leyenda;
	
	public Donatarias() {
		this.version = "1.1";
		this.leyenda = "Este comprobante ampara un donativo, el cual será destinado por "
				+ "la donataria a los fines propios de su objeto social. En el caso de "
				+ "que los bienes donados hayan sido deducidos previamente para los efectos "
				+ "del impuesto sobre la renta, este donativo no es deducible. La reproducción "
				+ "no autorizada de este comprobante constituye un delito en los términos de "
				+ "las disposiciones fiscales.";
	}
	
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	@XmlAttribute
	public String getNoAutorizacion() {
		return noAutorizacion;
	}
	@XmlAttribute
	public String getFechaAutorizacion() {
		return fechaAutorizacion;
	}
	@XmlAttribute
	public String getLeyenda() {
		return leyenda;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setNoAutorizacion(String noAutorizacion) {
		this.noAutorizacion = noAutorizacion;
	}
	public void setFechaAutorizacion(String fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}
	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}
	
}
