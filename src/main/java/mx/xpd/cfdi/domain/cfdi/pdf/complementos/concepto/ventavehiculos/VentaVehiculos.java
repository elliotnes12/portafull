package mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.ventavehiculos;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mx.xpd.cfdi.domain.cfdi.pdf.complementos.vehiculousado.InformacionAduanera;



@XmlRootElement(name = "VentaVehiculos")
public class VentaVehiculos {

	private String version;
	private String ClaveVehicularVentaVehiculos;
	private String NivVentaVehiculos;
	private List<InformacionAduanera> informacionAduanera;
	private List<Parte> parte;
	
	public VentaVehiculos() {
		this.version = "1.1";
	}
	
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "ClaveVehicular")
	public String getClaveVehicularVentaVehiculos() {
		return ClaveVehicularVentaVehiculos;
	}
	
	public void setClaveVehicularVentaVehiculos(String ClaveVehicularVentaVehiculos) {
		this.ClaveVehicularVentaVehiculos = ClaveVehicularVentaVehiculos;
	}

	@XmlAttribute(name = "Niv")
	public String getNivVentaVehiculos() {
		return NivVentaVehiculos;
	}

	public void setNivVentaVehiculos(String NivVentaVehiculos) {
		this.NivVentaVehiculos = NivVentaVehiculos;
	}

	@XmlElement(name = "InformacionAduanera")
	public List<InformacionAduanera> getInformacionAduanera() {
		return informacionAduanera;
	}

	public void setInformacionAduanera(List<InformacionAduanera> informacionAduanera) {
		this.informacionAduanera = informacionAduanera;
	}
	
	@XmlElement(name = "Parte")
	public List<Parte> getParte() {
		return parte;
	}

	public void setParte(List<Parte> parte) {
		this.parte = parte;
	}
	
	
	
}
