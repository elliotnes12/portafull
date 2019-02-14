package mx.xpd.cfdi.domain.cfdi.pdf.complementos.certificadodestruccion;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "InformacionAduanera")
public class InformacionAduaneraCertificadoDestruccion{

	private String numPedImp;
	private String fecha;
	private String aduana;
	
	public InformacionAduaneraCertificadoDestruccion() {
		
	}
	
	@XmlAttribute(name = "NumPedImp")
	public String getNumPedImp() {
		return numPedImp;
	}

	public void setNumPedImp(String numPedImp) {
		this.numPedImp = numPedImp;
	}

	@XmlAttribute(name = "Fecha")
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@XmlAttribute(name = "Aduana")
	public String getAduana() {
		return aduana;
	}

	public void setAduana(String aduana) {
		this.aduana = aduana;
	}

	

	
	
	
	
		
	
}
