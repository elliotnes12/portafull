package mx.xpd.cfdi.domain.cfdi.complementos.renovacionsustitucionvehiculos;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "VehiculoNuvoSemEnajenadoFabAlPerm")
public class VehiculoNuvoSemEnajenadoFabAlPerm{

	private String anioVehiculoNuvo;
	private String modeloVehiculoNuvo;
	private String numeroPlacasVehiculoNuvo;
	private String rfcVehiculoNuvo;

	
	public VehiculoNuvoSemEnajenadoFabAlPerm() {
		
	}
	
	@XmlAttribute(name = "Año")
	public String getAnioVehiculoNuvo() {
		return anioVehiculoNuvo;
	}

	public void setAnioVehiculoNuvo(String anioVehiculoNuvo) {
		this.anioVehiculoNuvo = anioVehiculoNuvo;
	}
	

	@XmlAttribute(name = "Modelo")
	public String getModeloVehiculoNuvo() {
		return modeloVehiculoNuvo;
	}

	public void setModeloVehiculoNuvo(String modeloVehiculoNuvo) {
		this.modeloVehiculoNuvo = modeloVehiculoNuvo;
	}
	
	@XmlAttribute(name = "NumPlacas")
	public String getNumeroPlacasVehiculoNuvo() {
		return numeroPlacasVehiculoNuvo;
	}

	public void setNumeroPlacasVehiculoNuvo(String numeroPlacasVehiculoNuvo) {
		this.numeroPlacasVehiculoNuvo = numeroPlacasVehiculoNuvo;
	}
	
	@XmlAttribute(name = "RFC")
	public String getRfcVehiculoNuvo() {
		return rfcVehiculoNuvo;
	}

	public void setRfcVehiculoNuvo(String rfcVehiculoNuvo) {
		this.rfcVehiculoNuvo = rfcVehiculoNuvo;
	}
				
}