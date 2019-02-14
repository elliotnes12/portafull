package mx.xpd.cfdi.domain.cfdi.pdf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="InformacionAduaneraConcepto")
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
