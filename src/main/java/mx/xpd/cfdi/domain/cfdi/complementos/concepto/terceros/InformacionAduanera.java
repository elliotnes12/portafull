package mx.xpd.cfdi.domain.cfdi.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "InformacionAduanera")
public class InformacionAduanera{

	private String numeroCuentaTerceros;
	private String fechaExpDocAduaneroCuentaTerceros;
	private String aduanaCuentaTerceros;
	
	public InformacionAduanera() {
		
	}
	
	@XmlAttribute(name = "numero")
	public String getNumeroCuentaTerceros() {
		return numeroCuentaTerceros;
	}

	public void setNumeroCuentaTerceros(String numeroCuentaTerceros) {
		this.numeroCuentaTerceros = numeroCuentaTerceros;
	}

	@XmlAttribute(name = "fecha")
	public String getFechaExpDocAduaneroCuentaTerceros() {
		return fechaExpDocAduaneroCuentaTerceros;
	}

	public void setFechaExpDocAduaneroCuentaTerceros(String fechaExpDocAduaneroCuentaTerceros) {
		this.fechaExpDocAduaneroCuentaTerceros = fechaExpDocAduaneroCuentaTerceros;
	}

	@XmlAttribute(name = "aduana")
	public String getAduanaCuentaTerceros() {
		return aduanaCuentaTerceros;
	}

	public void setAduanaCuentaTerceros(String aduanaCuentaTerceros) {
		this.aduanaCuentaTerceros= aduanaCuentaTerceros;
	}

	

	
	
	
	
		
	
}
