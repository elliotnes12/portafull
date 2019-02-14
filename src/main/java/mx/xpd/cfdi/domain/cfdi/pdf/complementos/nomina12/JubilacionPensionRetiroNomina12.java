package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class JubilacionPensionRetiroNomina12 {

	private String totalUnaExhibicion;
	private String totalParcialidad;
	private String montoDiario;
	private String ingresoAcumulable;
	private String ingresoNoAcumulable;
	
	public JubilacionPensionRetiroNomina12() {
		
	}
			
	@XmlAttribute(name = "TotalUnaExhibicion")
	public String getTotalUnaExhibicion() {
		return totalUnaExhibicion;
	}

	public void setTotalUnaExhibicion(String totalUnaExhibicion) {
		this.totalUnaExhibicion = totalUnaExhibicion;
	}
	
	@XmlAttribute(name = "TotalParcialidad")
	public String getTotalParcialidad() {
		return totalParcialidad;
	}
	
	public void setTotalParcialidad(String totalParcialidad) {
		this.totalParcialidad = totalParcialidad;
	}

	@XmlAttribute(name = "MontoDiario")
	public String getMontoDiario() {
		return montoDiario;
	}

	public void setMontoDiario(String montoDiario) {
		this.montoDiario = montoDiario;
	}
		
	@XmlAttribute(name = "IngresoAcumulable")
	public String getIngresoAcumulable() {
		return ingresoAcumulable;
	}
	
	public void setIngresoAcumulable(String ingresoAcumulable) {
		this.ingresoAcumulable = ingresoAcumulable;
	}

	@XmlAttribute(name = "IngresoNoAcumulable")
	public String getIngresoNoAcumulable() {
		return ingresoNoAcumulable;
	}

	public void setIngresoNoAcumulable(String ingresoNoAcumulable) {
		this.ingresoNoAcumulable = ingresoNoAcumulable;
	}
}
