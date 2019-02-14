package mx.xpd.cfdi.marshaller.Nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Incapacidades {
	
	private List<Incapacidad> incapacidad;
	
	public Incapacidades() {
		incapacidad = new ArrayList<Incapacidad>();
	}

	///////////// GETTERS NODOS
	@XmlElement(name = "Incapacidad")
	public List<Incapacidad> getIncapacidad() {
		return incapacidad;
	}

	///////////// SETTERS NODOS
	public void setIncapacidad(List<Incapacidad> incapacidad) {
		this.incapacidad = incapacidad;
	}

}
