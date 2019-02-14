package mx.xpd.cfdi.domain.cfdi.pdf;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Firmas {

	private int numeroFirmas;
	private List<Firma> firmas;
	
	@XmlAttribute
	public int getNumeroFirmas() {
		return numeroFirmas;
	}
	@XmlElement(name = "Firmas")
	public List<Firma> getFirmas() {
		return firmas;
	}
	public void setNumeroFirmas(int numeroFirmas) {
		this.numeroFirmas = numeroFirmas;
	}
	public void setFirmas(List<Firma> firmas) {
		this.firmas = firmas;
	}
	
	
}
