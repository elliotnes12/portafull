package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Incapacidades {
	private List<Incapacidad> incapacidades;
	
	public Incapacidades() {
		incapacidades = new ArrayList<Incapacidad>();
	}
	@XmlElement(name = "Incapacidad")
	public List<Incapacidad> getIncapacidades() {
		return incapacidades;
	}

	public void setIncapacidades(List<Incapacidad> incapacidades) {
		this.incapacidades = incapacidades;
	}
}
