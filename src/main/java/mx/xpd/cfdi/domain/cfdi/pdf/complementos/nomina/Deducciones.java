package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Deducciones {
	private List<Deduccion> deducciones;
	private Double totalExento;
	private Double totalGravado;

	public Deducciones() {
		deducciones = new ArrayList<Deduccion>();
	}
	@XmlElement(name = "Deduccion")
	public List<Deduccion> getDeducciones() {
		return deducciones;
	}

	public void setDeducciones(List<Deduccion> deducciones) {
		this.deducciones = deducciones;
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
