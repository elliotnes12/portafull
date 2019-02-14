package mx.xpd.cfdi.domain.cfdi.pdf.complementos.ine;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "ine")
public class INE {

	private String version = "1.1";
	private String tipoProceso;
	private String tipoComite;
	private String idContabilidad;
	private List<Entidad> entidad;
		
	public INE() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "TipoProceso")
	public String getTipoProceso() {
		return tipoProceso;
	}

	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}
	
	@XmlAttribute(name = "TipoComite")
	public String getTipoComite() {
		return tipoComite;
	}

	public void setTipoComite(String tipoComite) {
		this.tipoComite = tipoComite;
	}
	
	@XmlAttribute(name = "IdContabilidad")
	public String getIdContabilidad() {
		return idContabilidad;
	}

	public void setIdContabilidad(String idContabilidad) {
		this.idContabilidad = idContabilidad;
	}
	
	@XmlElement(name = "Entidad")
	public List<Entidad> getEntidad() {
		return entidad;
	}

	public void setEntidad(List<Entidad> entidad) {
		this.entidad = entidad;
	}

	



		
			
}