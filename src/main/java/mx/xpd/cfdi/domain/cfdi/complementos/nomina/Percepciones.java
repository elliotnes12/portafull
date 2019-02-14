package mx.xpd.cfdi.domain.cfdi.complementos.nomina;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Percepciones {
	private List<Percepcion> percepciones;
	private String totalExento;
	private String totalGravado;

	public Percepciones() {
		percepciones = new ArrayList<Percepcion>();
	}
	@XmlElement(name = "Percepcion")
	public List<Percepcion> getPercepciones() {
		return percepciones;
	}

	public void setPercepciones(List<Percepcion> percepciones) {
		this.percepciones = percepciones;
	}
	
	@XmlAttribute(name = "TotalExento")
	public String getTotalExento() {
		return totalExento;
	}
	
	@XmlAttribute(name = "TotalGravado")
	public String getTotalGravado() {
		return totalGravado;
	}
	
	public void setTotalExento(String totalExento) {
		this.totalExento = totalExento;
	}
	
	public void setTotalGravado(String totalGravado) {
		this.totalGravado = totalGravado;
	}	
}
