package mx.xpd.cfdi.marshaller.Nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Deducciones {
	
	private List<Deduccion> deduccion;
	private String totalOtrasDeducciones;
	private String totalImpuestosRetenidos;
	
	public Deducciones() {
		
		deduccion = new ArrayList<Deduccion>();
		
	}
	
	public Deducciones(String []data) {
		
		deduccion = new ArrayList<Deduccion>();
		
		totalOtrasDeducciones = data[2].equals(" ") ? null : (data[2]);
		totalImpuestosRetenidos = data[3].equals(" ") ? null : (data[3]);
		
	}

	///////////// GETTERS NODOS
	@XmlElement(name = "Deduccion")
	public List<Deduccion> getDeduccion() {
		return deduccion;
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "TotalOtrasDeducciones")
	public String getTotalOtrasDeducciones() {
		if(totalOtrasDeducciones==null){return null;}
		return totalOtrasDeducciones.trim().equals("") ? null : totalOtrasDeducciones.trim();
	}

	@XmlAttribute(name = "TotalImpuestosRetenidos")
	public String getTotalImpuestosRetenidos() {
		if(totalImpuestosRetenidos==null){return null;}
		return totalImpuestosRetenidos.trim().equals("") ? null : totalImpuestosRetenidos.trim();
	}

	
	///////////// SETTERS NODOS
	public void setDeduccion(List<Deduccion> deduccion) {
		this.deduccion = deduccion;
	}

	///////////// SETTERS ATRIBUTOS
	public void setTotalOtrasDeducciones(String totalOtrasDeducciones) {
		this.totalOtrasDeducciones = totalOtrasDeducciones;
	}

	public void setTotalImpuestosRetenidos(String totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}

}
