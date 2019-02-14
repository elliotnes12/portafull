package mx.xpd.cfdi.marshaller.Nomina12;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={
		"percepcion",
		"jubilacionPensionRetiro",
		"separacionIndemnizacion",
})

public class Percepciones {
	
	private List<Percepcion> percepcion;
	private JubilacionPensionRetiro jubilacionPensionRetiro;
	private SeparacionIndemnizacion separacionIndemnizacion;
	private String totalSueldos;
	private String totalSeparacionIndemnizacion;
	private String totalJubilacionPensionRetiro;
	private String totalGravado;
	private String totalExento;
	
	public Percepciones() {
		
		percepcion = new ArrayList<Percepcion>();
//		jubilacionPensionRetiro = new JubilacionPensionRetiro();
//		separacionIndemnizacion = new SeparacionIndemnizacion();
		
	}
	
	public Percepciones(String []data) {
		
		percepcion = new ArrayList<Percepcion>();
		jubilacionPensionRetiro = new JubilacionPensionRetiro();
		separacionIndemnizacion = new SeparacionIndemnizacion();
		
		totalSueldos = data[2].equals(" ") ? null : (data[2]);
		totalSeparacionIndemnizacion = data[3].equals(" ") ? null : (data[3]);
		totalJubilacionPensionRetiro = data[4].equals(" ") ? null : (data[4]);
		totalGravado = data[5].equals(" ") ? null : (data[5]);
		totalExento = data[6].equals(" ") ? null : (data[6]);
		
	}

	///////////// GETTERS NODOS
	@XmlElement(name = "Percepcion")
	public List<Percepcion> getPercepcion() {
		return percepcion;
	}

	@XmlElement(name = "JubilacionPensionRetiro")
	public JubilacionPensionRetiro getJubilacionPensionRetiro() {
		return jubilacionPensionRetiro;
	}

	@XmlElement(name = "SeparacionIndemnizacion")
	public SeparacionIndemnizacion getSeparacionIndemnizacion() {
		return separacionIndemnizacion;
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "TotalSueldos")
	public String getTotalSueldos() {
		if(totalSueldos==null){return null;}
		return totalSueldos.trim().equals("") ? null : totalSueldos.trim();
	}

	@XmlAttribute(name = "TotalSeparacionIndemnizacion")
	public String getTotalSeparacionIndemnizacion() {
		if(totalSeparacionIndemnizacion==null){return null;}
		return totalSeparacionIndemnizacion.trim().equals("") ? null : totalSeparacionIndemnizacion.trim();
	}

	@XmlAttribute(name = "TotalJubilacionPensionRetiro")
	public String getTotalJubilacionPensionRetiro() {
		if(totalJubilacionPensionRetiro==null){return null;}
		return totalJubilacionPensionRetiro.trim().equals("") ? null : totalJubilacionPensionRetiro.trim();
	}

	@XmlAttribute(name = "TotalGravado")
	public String getTotalGravado() {
		if(totalGravado==null){return null;}
		return totalGravado.trim().equals("") ? null : totalGravado.trim();
	}

	@XmlAttribute(name = "TotalExento")
	public String getTotalExento() {
		if(totalExento==null){return null;}
		return totalExento.trim().equals("") ? null : totalExento.trim();
	}

	
	///////////// SETTERS NODOS
	public void setPercepcion(List<Percepcion> percepcion) {
		this.percepcion = percepcion;
	}

	public void setJubilacionPensionRetiro(
			JubilacionPensionRetiro jubilacionPensionRetiro) {
		this.jubilacionPensionRetiro = jubilacionPensionRetiro;
	}

	public void setSeparacionIndemnizacion(
			SeparacionIndemnizacion separacionIndemnizacion) {
		this.separacionIndemnizacion = separacionIndemnizacion;
	}

	///////////// SETTERS ATRIBUTOS
	public void setTotalSueldos(String totalSueldos) {
		this.totalSueldos = totalSueldos;
	}

	public void setTotalSeparacionIndemnizacion(String totalSeparacionIndemnizacion) {
		this.totalSeparacionIndemnizacion = totalSeparacionIndemnizacion;
	}

	public void setTotalJubilacionPensionRetiro(String totalJubilacionPensionRetiro) {
		this.totalJubilacionPensionRetiro = totalJubilacionPensionRetiro;
	}

	public void setTotalGravado(String totalGravado) {
		this.totalGravado = totalGravado;
	}

	public void setTotalExento(String totalExento) {
		this.totalExento = totalExento;
	}

}
