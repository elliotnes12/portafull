package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Percepciones")
@XmlType(propOrder={
		"percepcion",
		"jubilacionPensionRetiro",
		"separacionIndemnizacion"
		
})

public class PercepcionesNomina12 {
	private String totalSueldos; 
	private String totalSeparacionIndemnizacion;
	private String totalJubilacionPensionRetiro;
	private String totalGravado;
	private String totalExento;
	
	private List<PercepcionNomina12> percepcion;
	private JubilacionPensionRetiroNomina12 jubilacionPensionRetiro;
	private SeparacionIndemnizacionNomina12 separacionIndemnizacion;
	

	public PercepcionesNomina12() {
		percepcion = new ArrayList<PercepcionNomina12>();
	}
	
	@XmlAttribute(name = "TotalSueldos")
	public String getTotalSueldos() {
		return totalSueldos;
	}
	
	public void setTotalSueldos(String totalSueldos) {
		this.totalSueldos = totalSueldos;
	}
	
	@XmlAttribute(name = "TotalSeparacionIndemnizacion")
	public String getTotalSeparacionIndemnizacion() {
		return totalSeparacionIndemnizacion;
	}
	
	public void setTotalSeparacionIndemnizacion(String totalSeparacionIndemnizacion) {
		this.totalSeparacionIndemnizacion = totalSeparacionIndemnizacion;
	}
	
	@XmlAttribute(name = "TotalJubilacionPensionRetiro")
	public String getTotalJubilacionPensionRetiro() {
		return totalJubilacionPensionRetiro;
	}
	
	public void setTotalJubilacionPensionRetiro(String totalJubilacionPensionRetiro) {
		this.totalJubilacionPensionRetiro = totalJubilacionPensionRetiro;
	}
	
	@XmlAttribute(name = "TotalGravado")
	public String getTotalGravado() {
		return totalGravado;
	}
			
	public void setTotalGravado(String totalGravado) {
		this.totalGravado = totalGravado;
	}	
	
	@XmlAttribute(name = "TotalExento")
	public String getTotalExento() {
		return totalExento;
	}
	
	public void setTotalExento(String totalExento) {
		this.totalExento = totalExento;
	}
	
	@XmlElement(name = "Percepcion")
	public List<PercepcionNomina12> getPercepcion() {
		return percepcion;
	}

	public void setPercepcion(List<PercepcionNomina12> percepcion) {
		this.percepcion = percepcion;
	}
	
	@XmlElement(name = "JubilacionPensionRetiro")
	public JubilacionPensionRetiroNomina12 getJubilacionPensionRetiro() {
		return jubilacionPensionRetiro;
	}

	public void setJubilacionPensionRetiro(JubilacionPensionRetiroNomina12 jubilacionPensionRetiro) {
		this.jubilacionPensionRetiro = jubilacionPensionRetiro;
	}
	
	@XmlElement(name = "SeparacionIndemnizacion")
	public SeparacionIndemnizacionNomina12 getSeparacionIndemnizacion() {
		return separacionIndemnizacion;
	}

	public void setSeparacionIndemnizacion(SeparacionIndemnizacionNomina12 separacionIndemnizacion) {
		this.separacionIndemnizacion = separacionIndemnizacion;
	}
	
	
}
