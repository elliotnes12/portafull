package mx.xpd.cfdi.domain.cfdi.pdf.complementos.comercioexterior;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Domicilio")
public class Domicilio{

	private String calle;
	private String numeroExterior;
	private String numeroInterior;
	private String colonia;
	private String localidad;
	private String referencia;
	private String municipio;
	private String estado;
	private String pais;
	private String codigoPostal;
	
	public Domicilio() {
		
	}
	
	@XmlAttribute(name = "Calle")
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	@XmlAttribute(name = "NumeroExterior")
	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	
	@XmlAttribute(name = "NumeroInterior")
	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	
	@XmlAttribute(name = "Colonia")
	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	
	@XmlAttribute(name = "Localidad")
	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@XmlAttribute(name = "Referencia")
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	@XmlAttribute(name = "Municipio")
	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	@XmlAttribute(name = "Estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@XmlAttribute(name = "Pais")
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@XmlAttribute(name = "CodigoPostal")
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
			
}