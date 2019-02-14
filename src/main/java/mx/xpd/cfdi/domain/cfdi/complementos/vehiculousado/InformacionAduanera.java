package mx.xpd.cfdi.domain.cfdi.complementos.vehiculousado;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "InformacionAduanera")
public class InformacionAduanera{

	private String numero;
	private String fechaExpDocAduanero;
	private String aduana;
	
	public InformacionAduanera() {
		
	}
	
	@XmlAttribute(name = "numero")
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@XmlAttribute(name = "fecha")
	public String getFechaExpDocAduanero() {
		return fechaExpDocAduanero;
	}

	public void setFechaExpDocAduanero(String fechaExpDocAduanero) {
		this.fechaExpDocAduanero = fechaExpDocAduanero;
	}

	@XmlAttribute(name = "aduana")
	public String getAduana() {
		return aduana;
	}

	public void setAduana(String aduana) {
		this.aduana = aduana;
	}

	

	
	
	
	
		
	
}
