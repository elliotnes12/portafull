package mx.xpd.cfdi.domain.cfdi.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Traslado")
public class Traslado{

	private String impuestoTrasladosCuentaTerceros;
	private String tasaTrasladosCuentaTerceros;
	private String importeTrasladosCuentaTerceros;
		
	public Traslado() {
		
	}
	
	@XmlAttribute(name = "impuesto")
	public String getImpuestoTrasladosCuentaTerceros() {
		return impuestoTrasladosCuentaTerceros;
	}

	public void setImpuestoTrasladosCuentaTerceros(String impuestoTrasladosCuentaTerceros) {
		this.impuestoTrasladosCuentaTerceros = impuestoTrasladosCuentaTerceros;
	}

	@XmlAttribute(name = "tasa")
	public String getTasaTrasladosCuentaTerceros() {
		return tasaTrasladosCuentaTerceros;
	}

	public void setTasaTrasladosCuentaTerceros(String tasaTrasladosCuentaTerceros) {
		this.tasaTrasladosCuentaTerceros= tasaTrasladosCuentaTerceros;
	}
	
	@XmlAttribute(name = "importe")
	public String getImporteTrasladosCuentaTerceros() {
		return importeTrasladosCuentaTerceros;
	}

	public void setImporteTrasladosCuentaTerceros(String importeTrasladosCuentaTerceros) {
		this.importeTrasladosCuentaTerceros= importeTrasladosCuentaTerceros;
	}


	

	

	
	
	
	
		
	
}
