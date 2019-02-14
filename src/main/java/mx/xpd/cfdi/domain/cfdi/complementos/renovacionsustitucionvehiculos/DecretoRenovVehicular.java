package mx.xpd.cfdi.domain.cfdi.complementos.renovacionsustitucionvehiculos;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "DecretoRenovVehicular")
@XmlType(propOrder={
		"vehiculosUsadosEnajenadoPermAlFab",
		"vehiculoNuvoSemEnajenadoFabAlPerm"
})
public class DecretoRenovVehicular{

	private String vehEnaj;
	private List<VehiculosUsadosEnajenadoPermAlFab> vehiculosUsadosEnajenadoPermAlFab;
	private VehiculoNuvoSemEnajenadoFabAlPerm vehiculoNuvoSemEnajenadoFabAlPerm;
	
	
	public DecretoRenovVehicular() {
		
	}
	
	@XmlAttribute(name = "VehEnaj")
	public String getVehEnaj() {
		return vehEnaj;
	}

	public void setVehEnaj(String vehEnaj) {
		this.vehEnaj = vehEnaj;
	}
	
	@XmlElement(name = "VehiculosUsadosEnajenadoPermAlFab")
	public List<VehiculosUsadosEnajenadoPermAlFab> getVehiculosUsadosEnajenadoPermAlFab() {
		return vehiculosUsadosEnajenadoPermAlFab;
	}

	public void setVehiculosUsadosEnajenadoPermAlFab(List<VehiculosUsadosEnajenadoPermAlFab> vehiculosUsadosEnajenadoPermAlFab) {
		this.vehiculosUsadosEnajenadoPermAlFab = vehiculosUsadosEnajenadoPermAlFab;
	}
	
	@XmlElement(name = "VehiculoNuvoSemEnajenadoFabAlPerm")
	public VehiculoNuvoSemEnajenadoFabAlPerm getVehiculoNuvoSemEnajenadoFabAlPerm() {
		return vehiculoNuvoSemEnajenadoFabAlPerm;
	}

	public void setVehiculoNuvoSemEnajenadoFabAlPerm(VehiculoNuvoSemEnajenadoFabAlPerm vehiculoNuvoSemEnajenadoFabAlPerm) {
		this.vehiculoNuvoSemEnajenadoFabAlPerm = vehiculoNuvoSemEnajenadoFabAlPerm;
	}
			
}