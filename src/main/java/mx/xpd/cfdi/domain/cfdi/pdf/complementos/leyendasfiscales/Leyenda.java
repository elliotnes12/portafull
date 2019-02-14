package mx.xpd.cfdi.domain.cfdi.pdf.complementos.leyendasfiscales;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Leyenda")
public class Leyenda{

	private String disposicionFiscal;
	private String norma;
	private String textoLeyenda;
	
	public Leyenda() {
		
	}
	
	@XmlAttribute(name = "disposicionFiscal")
	public String getDisposicionFiscal() {
		return disposicionFiscal;
	}

	public void setDisposicionFiscal(String disposicionFiscal) {
		this.disposicionFiscal = disposicionFiscal;
	}

	@XmlAttribute(name = "norma")
	public String getNorma() {
		return norma;
	}

	public void setNorma(String norma) {
		this.norma = norma;
	}
	
	@XmlAttribute(name = "textoLeyenda")
	public String getTextoLeyenda() {
		return textoLeyenda;
	}

	public void setTextoLeyenda(String textoLeyenda) {
		this.textoLeyenda = textoLeyenda;
	}

		
}