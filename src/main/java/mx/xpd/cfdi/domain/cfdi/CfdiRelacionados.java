package mx.xpd.cfdi.domain.cfdi;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class CfdiRelacionados {
	
	private String tipoRelacion;
	private java.util.List<CfdiRelacionado> cfdiRelacionado;
		
	public CfdiRelacionados() {
	
	}
		
	@XmlAttribute(name = "TipoRelacion")
	public String getTipoRelacion() {
		return tipoRelacion;
	}
	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}
	
	@XmlElement(name = "CfdiRelacionado")
	public java.util.List<CfdiRelacionado> getCfdiRelacionado() {
		return cfdiRelacionado;
	}

	public void setCfdiRelacionado(java.util.List<CfdiRelacionado> cfdiRelacionado) {
		this.cfdiRelacionado = cfdiRelacionado;
	}
	
	
	@Override
	public String toString() {
		return "CfdiRelacionados [tipoRelacion=" + tipoRelacion + "]";
	}
	
}