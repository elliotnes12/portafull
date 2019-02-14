package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Incapacidades {
	private List<Incapacidad> incapacidad;
	
	public Incapacidades() {
		incapacidad = new ArrayList<Incapacidad>();
	}
	@XmlElement(name = "Incapacidad")
	public List<Incapacidad> getIncapacidad() {
		return incapacidad;
	}

	public void setIncapacidad(List<Incapacidad> incapacidad) {
		this.incapacidad = incapacidad;
	}
}
