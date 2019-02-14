package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class DeduccionesNomina12 {
	private String totalOtrasDeducciones;
	private String totalImpuestosRetenidos;
	private List<DeduccionNomina12> deduccion;

	public DeduccionesNomina12() {
		deduccion = new ArrayList<DeduccionNomina12>();
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
	public List<DeduccionNomina12> getDeduccion() {
		return deduccion;
	}

	public void setDeduccion(List<DeduccionNomina12> deduccion) {
		this.deduccion = deduccion;
	}
	
	
	
	
}
