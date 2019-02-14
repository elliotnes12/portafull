package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

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

public class Percepciones {
	private String totalSueldos; 
	private String totalSeparacionIndemnizacion;
	private String totalJubilacionPensionRetiro;
	private String totalGravado;
	private String totalExento;
	
	private List<Percepcion> percepcion;
	private JubilacionPensionRetiro jubilacionPensionRetiro;
	private SeparacionIndemnizacion separacionIndemnizacion;
	

	public Percepciones() {
		percepcion = new ArrayList<Percepcion>();
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
	public List<Percepcion> getPercepcion() {
		return percepcion;
	}

	public void setPercepcion(List<Percepcion> percepcion) {
		this.percepcion = percepcion;
	}
	
	@XmlElement(name = "JubilacionPensionRetiro")
	public JubilacionPensionRetiro getJubilacionPensionRetiro() {
		return jubilacionPensionRetiro;
	}

	public void setJubilacionPensionRetiro(JubilacionPensionRetiro jubilacionPensionRetiro) {
		this.jubilacionPensionRetiro = jubilacionPensionRetiro;
	}
	
	@XmlElement(name = "SeparacionIndemnizacion")
	public SeparacionIndemnizacion getSeparacionIndemnizacion() {
		return separacionIndemnizacion;
	}

	public void setSeparacionIndemnizacion(SeparacionIndemnizacion separacionIndemnizacion) {
		this.separacionIndemnizacion = separacionIndemnizacion;
	}
	
	
}
