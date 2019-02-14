package mx.xpd.cfdi.domain.cfdi.complementos.nomina;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Deducciones {
	private List<Deduccion> deducciones;
	private String totalExento;
	private String totalGravado;

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
