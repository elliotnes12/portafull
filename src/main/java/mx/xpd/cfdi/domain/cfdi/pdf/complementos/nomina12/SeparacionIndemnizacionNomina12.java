package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class SeparacionIndemnizacionNomina12 {

	private String totalPagado;
	private String numAniosServicio;
	private String ultimoSueldoMensOrd;
	private String ingresoAcumulableSeparacionIndemnizacion;
	private String ingresoNoAcumulableSeparacionIndemnizacion;
	
	public SeparacionIndemnizacionNomina12() {
		
	}
		
	@XmlAttribute(name = "TotalPagado")
	public String getTotalPagado() {
		return totalPagado;
	}

	public void setTotalPagado(String totalPagado) {
		this.totalPagado = totalPagado;
	}
	
	@XmlAttribute(name = "NumAñosServicio")
	public String getNumAniosServicio() {
		return numAniosServicio;
	}
	
	public void setNumAniosServicio(String numAniosServicio) {
		this.numAniosServicio = numAniosServicio;
	}

	@XmlAttribute(name = "UltimoSueldoMensOrd")
	public String getUltimoSueldoMensOrd() {
		return ultimoSueldoMensOrd;
	}

	public void setUltimoSueldoMensOrd(String ultimoSueldoMensOrd) {
		this.ultimoSueldoMensOrd = ultimoSueldoMensOrd;
	}
		
	@XmlAttribute(name = "IngresoAcumulable")
	public String getIngresoAcumulableSeparacionIndemnizacion() {
		return ingresoAcumulableSeparacionIndemnizacion;
	}
	
	public void setIngresoAcumulableSeparacionIndemnizacion(String ingresoAcumulableSeparacionIndemnizacion) {
		this.ingresoAcumulableSeparacionIndemnizacion = ingresoAcumulableSeparacionIndemnizacion;
	}

	@XmlAttribute(name = "IngresoNoAcumulable")
	public String getIngresoNoAcumulableSeparacionIndemnizacion() {
		return ingresoNoAcumulableSeparacionIndemnizacion;
	}

	public void setIngresoNoAcumulableSeparacionIndemnizacion(String ingresoNoAcumulableSeparacionIndemnizacion) {
		this.ingresoNoAcumulableSeparacionIndemnizacion = ingresoNoAcumulableSeparacionIndemnizacion;
	}
}
