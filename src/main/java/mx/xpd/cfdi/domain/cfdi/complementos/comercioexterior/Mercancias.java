package mx.xpd.cfdi.domain.cfdi.complementos.comercioexterior;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




@XmlRootElement(name = "Mercancias")
public class Mercancias{

	private List<Mercancia> mercancia;
	
	
	public Mercancias() {
		
	}
	
	@XmlElement(name = "Mercancia")
	public List<Mercancia> getMercancia() {
		return mercancia;
	}
	
	public void setMercancia(
			List<Mercancia> mercancia) {
		this.mercancia = mercancia;
	}
}