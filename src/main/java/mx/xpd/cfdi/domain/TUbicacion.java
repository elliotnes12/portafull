package mx.xpd.cfdi.domain;

import javax.xml.bind.annotation.XmlAttribute;

public class TUbicacion {
	
	private String calle;
	private String noExterior;
	private String noInterior;
	private String colonia;
	private String localidad; 
	private String referencia;
	private String municipio;
	private String estado;
	private String pais;
	private String codigoPostal;
	
	@XmlAttribute
	public String getCalle() {
		return calle;
	}
	@XmlAttribute
	public String getNoExterior() {
		return noExterior;
	}
	@XmlAttribute
	public String getNoInterior() {
		return noInterior;
	}
	@XmlAttribute
	public String getColonia() {
		return colonia;
	}
	@XmlAttribute
	public String getLocalidad() {
		return localidad;
	}
	@XmlAttribute
	public String getReferencia() {
		return referencia;
	}
	@XmlAttribute
	public String getMunicipio() {
		return municipio;
	}
	@XmlAttribute
	public String getEstado() {
		return estado;
	}
	@XmlAttribute
	public String getPais() {
		return pais;
	}
	@XmlAttribute
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public void setNoExterior(String noExterior) {
		this.noExterior = noExterior;
	}
	public void setNoInterior(String noInterior) {
		this.noInterior = noInterior;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@Override
	public String toString() {
		return "TUbicacion [calle=" + calle + ", noExterior=" + noExterior
				+ ", noInterior=" + noInterior + ", colonia=" + colonia
				+ ", localidad=" + localidad + ", referencia=" + referencia
				+ ", municipio=" + municipio + ", estado=" + estado + ", pais="
				+ pais + ", codigoPostal=" + codigoPostal + "]";
	}	
}
