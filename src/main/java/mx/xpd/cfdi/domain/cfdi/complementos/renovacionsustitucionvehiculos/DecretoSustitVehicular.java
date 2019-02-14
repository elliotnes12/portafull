package mx.xpd.cfdi.domain.cfdi.complementos.renovacionsustitucionvehiculos;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "DecretoSustitVehicular")
@XmlType(propOrder={
		"vehiculoUsadoEnajenadoPermAlFab",
		"vehiculoNuvoSemEnajenadoFabAlPerm"
})
public class DecretoSustitVehicular{

	private String vehEnaj;
	private VehiculoUsadoEnajenadoPermAlFab vehiculoUsadoEnajenadoPermAlFab;
	private VehiculoNuvoSemEnajenadoFabAlPerm vehiculoNuvoSemEnajenadoFabAlPerm;
	
	public DecretoSustitVehicular() {
		
	}
	
	@XmlAttribute(name = "VehEnaj")
	public String getVehEnaj() {
		return vehEnaj;
	}

	public void setVehEnaj(String vehEnaj) {
		this.vehEnaj = vehEnaj;
	}
	
	@XmlElement(name = "VehiculoUsadoEnajenadoPermAlFab")
	public VehiculoUsadoEnajenadoPermAlFab getVehiculoUsadoEnajenadoPermAlFab() {
		return vehiculoUsadoEnajenadoPermAlFab;
	}

	public void setVehiculoUsadoEnajenadoPermAlFab(VehiculoUsadoEnajenadoPermAlFab vehiculoUsadoEnajenadoPermAlFab) {
		this.vehiculoUsadoEnajenadoPermAlFab = vehiculoUsadoEnajenadoPermAlFab;
	}
	
	@XmlElement(name = "VehiculoNuvoSemEnajenadoFabAlPerm")
	public VehiculoNuvoSemEnajenadoFabAlPerm getVehiculoNuvoSemEnajenadoFabAlPerm() {
		return vehiculoNuvoSemEnajenadoFabAlPerm;
	}

	public void setVehiculoNuvoSemEnajenadoFabAlPerm(VehiculoNuvoSemEnajenadoFabAlPerm vehiculoNuvoSemEnajenadoFabAlPerm) {
		this.vehiculoNuvoSemEnajenadoFabAlPerm = vehiculoNuvoSemEnajenadoFabAlPerm;
	}
			
}