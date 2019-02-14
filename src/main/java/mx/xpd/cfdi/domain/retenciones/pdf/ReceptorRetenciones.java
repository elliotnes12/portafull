package mx.xpd.cfdi.domain.retenciones.pdf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ReceptorRetenciones {
	
	private String nacionalidad;
	private ReceptorNacionalRetenciones receptorNacional;
	private ReceptorExtranjeroRetenciones receptorExtranjero;
	
		
	

	public ReceptorRetenciones() {
		
	}
	
	@XmlAttribute(name="Nacionalidad")
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String Nacionalidad) {
		nacionalidad = nacionalidad;
	}
	
	@XmlElement(name = "Nacional")
	public ReceptorNacionalRetenciones getReceptorNacional() {
		return receptorNacional;
	}

	public void setReceptorNacional(ReceptorNacionalRetenciones receptorNacional) {
		this.receptorNacional = receptorNacional;
	}
	
	@XmlElement(name = "Extranjero")
	public ReceptorExtranjeroRetenciones getReceptorExtranjero() {
		return receptorExtranjero;
	}

	public void setReceptorExtranjero(ReceptorExtranjeroRetenciones receptorExtranjero) {
		this.receptorExtranjero = receptorExtranjero;
	}
		
	
	
	@Override
	public String toString() {
		return "Receptor [Nacionalidad=" + nacionalidad + "]";
	}
	
}