package mx.xpd.cfdi.domain;

import javax.xml.bind.annotation.XmlAttribute;


public class Concepto {

	private Double cantidad;
	private String unidad;
	private String noIdentificacion;
	private String descripcion;
	private Double valorUnitario;
	private Double importe;
	
	@XmlAttribute
	public Double getCantidad() {
		return cantidad;
	}
	@XmlAttribute
	public String getUnidad() {
		return unidad;
	}
	@XmlAttribute
	public String getNoIdentificacion() {
		return noIdentificacion;
	}
	@XmlAttribute
	public String getDescripcion() {
		return descripcion;
	}
	@XmlAttribute
	public Double getValorUnitario() {
		return valorUnitario;
	}
	@XmlAttribute
	public Double getImporte() {
		return importe;
	}
	
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public void setNoIdentificacion(String noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	
	
}
