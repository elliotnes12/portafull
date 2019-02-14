package mx.xpd.cfdi.domain.cfdi.pdf.complementos.comercioexterior;



import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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