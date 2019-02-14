package mx.xpd.cfdi.domain.cfdi;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "InformacionAduanera")
public class InformacionAduanera{

	private String numeroPedimento;
		
	public InformacionAduanera() {
		
	}
	
	@XmlAttribute(name = "NumeroPedimento")
	public String getNumeroPedimento() {
		return numeroPedimento;
	}

	public void setNumeroPedimento(String numeroPedimento) {
		this.numeroPedimento = numeroPedimento;
	}
}
