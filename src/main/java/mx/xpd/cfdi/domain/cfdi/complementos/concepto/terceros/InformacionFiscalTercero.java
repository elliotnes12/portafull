package mx.xpd.cfdi.domain.cfdi.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "InformacionFiscalTercero")
public class InformacionFiscalTercero{

	private String calleCuentaTerceros;
	private String noExteriorCuentaTerceros;
	private String noInteriorCuentaTerceros;
	private String coloniaCuentaTerceros;
	private String localidadCuentaTerceros;
	private String referenciaCuentaTerceros;
	private String municipioCuentaTerceros;
	private String estadoCuentaTerceros;
	private String paisCuentaTerceros;
	private String codigoPostalCuentaTerceros;
	
	
	
	public InformacionFiscalTercero() {
		
	}
	
	@XmlAttribute(name = "calle")
	public String getCalleCuentaTerceros() {
		return calleCuentaTerceros;
	}

	public void setCalleCuentaTerceros(String calleCuentaTerceros) {
		this.calleCuentaTerceros = calleCuentaTerceros;
	}

	@XmlAttribute(name = "noExterior")
	public String getNoExteriorCuentaTerceros() {
		return noExteriorCuentaTerceros;
	}

	public void setNoExteriorCuentaTerceros(String noExteriorCuentaTerceros) {
		this.noExteriorCuentaTerceros = noExteriorCuentaTerceros;
	}

	@XmlAttribute(name = "noInterior")
	public String getNoInteriorCuentaTerceros() {
		return noInteriorCuentaTerceros;
	}

	public void setNoInteriorCuentaTerceros(String noInteriorCuentaTerceros) {
		this.noInteriorCuentaTerceros = noInteriorCuentaTerceros;
	}

	@XmlAttribute(name = "colonia")
	public String getColoniaCuentaTerceros() {
		return coloniaCuentaTerceros;
	}

	public void setColoniaCuentaTerceros(String coloniaCuentaTerceros) {
		this.coloniaCuentaTerceros = coloniaCuentaTerceros;
	}

	@XmlAttribute(name = "localidad")
	public String getLocalidadCuentaTerceros() {
		return localidadCuentaTerceros;
	}

	public void setLocalidadCuentaTerceros(String localidadCuentaTerceros) {
		this.localidadCuentaTerceros = localidadCuentaTerceros;
	}

	@XmlAttribute(name = "referencia")
	public String getReferenciaCuentaTerceros() {
		return referenciaCuentaTerceros;
	}

	public void setReferenciaCuentaTerceros(String referenciaCuentaTerceros) {
		this.referenciaCuentaTerceros = referenciaCuentaTerceros;
	}

	@XmlAttribute(name = "municipio")
	public String getMunicipioCuentaTerceros() {
		return municipioCuentaTerceros;
	}

	public void setMunicipioCuentaTerceros(String municipioCuentaTerceros) {
		this.municipioCuentaTerceros = municipioCuentaTerceros;
	}

	@XmlAttribute(name = "estado")
	public String getEstadoCuentaTerceros() {
		return estadoCuentaTerceros;
	}

	public void setEstadoCuentaTerceros(String estadoCuentaTerceros) {
		this.estadoCuentaTerceros = estadoCuentaTerceros;
	}

	@XmlAttribute(name = "pais")
	public String getPaisCuentaTerceros() {
		return paisCuentaTerceros;
	}

	public void setPaisCuentaTerceros(String paisCuentaTerceros) {
		this.paisCuentaTerceros = paisCuentaTerceros;
	}

	@XmlAttribute(name = "codigoPostal")
	public String getCodigoPostalCuentaTerceros() {
		return codigoPostalCuentaTerceros;
	}

	public void setCodigoPostalCuentaTerceros(String codigoPostalCuentaTerceros) {
		this.codigoPostalCuentaTerceros = codigoPostalCuentaTerceros;
	}

	

			
	
}
