package mx.xpd.cfdi.domain.cfdi.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "CuentaPredial")
public class CuentaPredial{

	private String numeroCuentaPredialTerceros;
		
	public CuentaPredial() {
		
	}
	
	@XmlAttribute(name = "numero")
	public String getNumeroCuentaPredialTerceros() {
		return numeroCuentaPredialTerceros;
	}

	public void setNumeroCuentaPredialTerceros(String numeroCuentaPredialTerceros) {
		this.numeroCuentaPredialTerceros = numeroCuentaPredialTerceros;
	}
	
	
}
