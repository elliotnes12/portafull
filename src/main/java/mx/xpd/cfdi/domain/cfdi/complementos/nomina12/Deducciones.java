package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Deducciones {
	private String totalOtrasDeducciones;
	private String totalImpuestosRetenidos;
	private List<Deduccion> deduccion;

	public Deducciones() {
		deduccion = new ArrayList<Deduccion>();
	}
	
	@XmlAttribute(name = "TotalOtrasDeducciones")
	public String getTotalOtrasDeducciones() {
		return totalOtrasDeducciones;
	}
	
	public void setTotalOtrasDeducciones(String totalOtrasDeducciones) {
		this.totalOtrasDeducciones = totalOtrasDeducciones;
	}
	
	@XmlAttribute(name = "TotalImpuestosRetenidos")
	public String getTotalImpuestosRetenidos() {
		return totalImpuestosRetenidos;
	}
			
	public void setTotalImpuestosRetenidos(String totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}
	
	
	@XmlElement(name = "Deduccion")
	public List<Deduccion> getDeduccion() {
		return deduccion;
	}

	public void setDeduccion(List<Deduccion> deduccion) {
		this.deduccion = deduccion;
	}
	
	
	
	
}
