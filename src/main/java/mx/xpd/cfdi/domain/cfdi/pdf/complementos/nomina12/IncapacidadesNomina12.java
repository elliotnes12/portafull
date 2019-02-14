package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class IncapacidadesNomina12 {
	private List<IncapacidadNomina12> incapacidad;
	
	public IncapacidadesNomina12() {
		incapacidad = new ArrayList<IncapacidadNomina12>();
	}
	@XmlElement(name = "Incapacidad")
	public List<IncapacidadNomina12> getIncapacidad() {
		return incapacidad;
	}

	public void setIncapacidad(List<IncapacidadNomina12> incapacidad) {
		this.incapacidad = incapacidad;
	}
}
