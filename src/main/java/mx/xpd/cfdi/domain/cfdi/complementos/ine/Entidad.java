package mx.xpd.cfdi.domain.cfdi.complementos.ine;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Entidad")
public class Entidad{

	private String claveEntidad;
	private String ambito;
	private List<Contabilidad> contabilidad;
	
	public Entidad() {
		
	}
	
	@XmlAttribute(name = "ClaveEntidad")
	public String getClaveEntidad() {
		return claveEntidad;
	}

	public void setClaveEntidad(String claveEntidad) {
		this.claveEntidad = claveEntidad;
	}
	
	@XmlAttribute(name = "Ambito")
	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	@XmlElement(name = "Contabilidad")
	public List<Contabilidad> getContabilidad() {
		return contabilidad;
	}

	public void setContabilidad(List<Contabilidad> contabilidad) {
		this.contabilidad = contabilidad;
	}

		
}