package mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto;

import javax.xml.bind.annotation.XmlAttribute;

public class CuentaPredial {

	private String numero;

	@XmlAttribute
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
}
