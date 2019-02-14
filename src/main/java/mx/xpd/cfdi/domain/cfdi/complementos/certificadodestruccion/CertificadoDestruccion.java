package mx.xpd.cfdi.domain.cfdi.complementos.certificadodestruccion;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.complementos.aerolineas.OtrosCargos;


@XmlRootElement(name = "CertificadoDestruccion")
public class CertificadoDestruccion {

	private String version = "1.0";
	private String serie;
	private String numFolDesVeh;
	private VehiculoDestruido vehiculoDestruido;
	private InformacionAduanera informacionAduanera; 
		
	public CertificadoDestruccion() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "Serie")
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}	
	
	@XmlAttribute(name = "NumFolDesVeh")
	public String getNumFolDesVeh() {
		return numFolDesVeh;
	}

	public void setNumFolDesVeh(String numFolDesVeh) {
		this.numFolDesVeh = numFolDesVeh;
	}	
	
	@XmlElement(name = "VehiculoDestruido")
	public VehiculoDestruido getVehiculoDestruido() {
		return vehiculoDestruido;
	}

	public void setVehiculoDestruido(VehiculoDestruido vehiculoDestruido) {
		this.vehiculoDestruido = vehiculoDestruido;
	}
	
	@XmlElement(name = "InformacionAduanera")
	public InformacionAduanera getInformacionAduanera() {
		return informacionAduanera;
	}

	public void setInformacionAduanera(InformacionAduanera informacionAduanera) {
		this.informacionAduanera = informacionAduanera;
	}
		
	
			
}