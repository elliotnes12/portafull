package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Percepciones {
	private List<Percepcion> percepciones;
	private Double totalExento;
	private Double totalGravado;

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
	public Double getTotalExento() {
		return totalExento;
	}
	
	@XmlAttribute(name = "TotalGravado")
	public Double getTotalGravado() {
		return totalGravado;
	}
	
	public void setTotalExento(Double totalExento) {
		this.totalExento = totalExento;
	}
	
	public void setTotalGravado(Double totalGravado) {
		this.totalGravado = totalGravado;
	}	
}
