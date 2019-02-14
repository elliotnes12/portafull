package mx.xpd.cfdi.domain.retenciones.complementos.fideicomisonoempresarial;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "RetEfectFideicomiso")
public class RetEfectFideicomiso {

	private String montRetRelPagFideic;
	private String descRetRelPagFideic;
	
	
	public RetEfectFideicomiso() {
		
	}


	@XmlAttribute(name = "MontRetRelPagFideic")
	public String getMontRetRelPagFideic() {
		return montRetRelPagFideic;
	}

	public void setMontRetRelPagFideic(String montRetRelPagFideic) {
		this.montRetRelPagFideic = montRetRelPagFideic;
	}

	@XmlAttribute(name = "DescRetRelPagFideic")
	public String getDescRetRelPagFideic() {
		return descRetRelPagFideic;
	}


	public void setDescRetRelPagFideic(String descRetRelPagFideic) {
		this.descRetRelPagFideic = descRetRelPagFideic;
	}
	
	
	

	
}
