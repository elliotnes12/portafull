package mx.xpd.cfdi.domain.cfdi.complementos.renovacionsustitucionvehiculos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.complementos.aerolineas.Cargo;
import mx.xpd.cfdi.domain.cfdi.complementos.aerolineas.OtrosCargos;


@XmlRootElement(name = "RenovacionSustitucionVehiculos")
public class RenovacionSustitucionVehiculos {

	private String version = "1.0";
	private String tipoDeDecreto;
	private DecretoRenovVehicular decretoRenovVehicular;
	private DecretoSustitVehicular decretoSustitVehicular;

	
	
		
	public RenovacionSustitucionVehiculos() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "TipoDeDecreto")
	public String getTipoDeDecreto() {
		return tipoDeDecreto;
	}

	public void setTipoDeDecreto(String tipoDeDecreto) {
		this.tipoDeDecreto = tipoDeDecreto;
	}
	
		
	@XmlElement(name = "DecretoRenovVehicular")
	public DecretoRenovVehicular getDecretoRenovVehicular() {
		return decretoRenovVehicular;
	}

	public void setDecretoRenovVehicular(DecretoRenovVehicular decretoRenovVehicular) {
		this.decretoRenovVehicular = decretoRenovVehicular;
	}
	
	@XmlElement(name = "DecretoSustitVehicular")
	public DecretoSustitVehicular getDecretoSustitVehicular() {
		return decretoSustitVehicular;
	}

	public void setDecretoSustitVehicular(DecretoSustitVehicular decretoSustitVehicular) {
		this.decretoSustitVehicular = decretoSustitVehicular;
	}
	
	
			
}