package mx.xpd.cfdi.domain.cfdi.pdf.complementos.leyendasfiscales;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "LeyendasFiscales")
public class LeyendasFiscales {

	private String version = "1.0";
	private List<Leyenda> leyenda;
		
	public LeyendasFiscales() {
		
	}

	@XmlAttribute(name = "version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
		
	@XmlElement(name = "Leyenda")
	public List<Leyenda> getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(List<Leyenda> leyenda) {
		this.leyenda = leyenda;
	}

	



		
			
}