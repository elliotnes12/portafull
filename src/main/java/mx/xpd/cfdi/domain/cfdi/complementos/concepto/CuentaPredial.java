package mx.xpd.cfdi.domain.cfdi.complementos.concepto;

import javax.xml.bind.annotation.XmlAttribute;

public class CuentaPredial {

	private String numero;

	@XmlAttribute(name = "Numero")
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
}
