package mx.xpd.cfdi.marshaller.Nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class SeparacionIndemnizacion {
	
	private String totalPagado;
	private Integer numAniosServicio;
	private String ultimoSueldoMensOrd;
	private String ingresoAcumulable;
	private String ingresoNoAcumulable;
	
	public SeparacionIndemnizacion() {
		
	}
	
	public SeparacionIndemnizacion(String []data) {
		
		totalPagado = data[1].equals(" ") ? null : (data[1]);
		numAniosServicio = data[2].equals(" ") ? null : Integer.valueOf(data[2]);
		ultimoSueldoMensOrd = data[3].equals(" ") ? null : (data[3]);
		ingresoAcumulable = data[4].equals(" ") ? null : (data[4]);
		ingresoNoAcumulable = data[5].equals(" ") ? null : (data[5]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "TotalPagado")
	public String getTotalPagado() {
		if(totalPagado==null){return null;}
		return totalPagado.trim().equals("") ? null : totalPagado.trim();
	}

	@XmlAttribute(name = "NumAñosServicio")
	public Integer getNumAniosServicio() {
		if(numAniosServicio==null){return null;}
		return numAniosServicio;
	}

	@XmlAttribute(name = "UltimoSueldoMensOrd")
	public String getUltimoSueldoMensOrd() {
		if(ultimoSueldoMensOrd==null){return null;}
		return ultimoSueldoMensOrd.trim().equals("") ? null : ultimoSueldoMensOrd.trim();
	}

	@XmlAttribute(name = "IngresoAcumulable")
	public String getIngresoAcumulable() {
		if(ingresoAcumulable==null){return null;}
		return ingresoAcumulable.trim().equals("") ? null : ingresoAcumulable.trim();
	}

	@XmlAttribute(name = "IngresoNoAcumulable")
	public String getIngresoNoAcumulable() {
		if(ingresoNoAcumulable==null){return null;}
		return ingresoNoAcumulable.trim().equals("") ? null : ingresoNoAcumulable.trim();
	}

	
	///////////// SETTERS ATRIBUTOS
	public void setTotalPagado(String totalPagado) {
		this.totalPagado = totalPagado;
	}

	public void setNumAniosServicio(Integer numAniosServicio) {
		this.numAniosServicio = numAniosServicio;
	}

	public void setUltimoSueldoMensOrd(String ultimoSueldoMensOrd) {
		this.ultimoSueldoMensOrd = ultimoSueldoMensOrd;
	}

	public void setIngresoAcumulable(String ingresoAcumulable) {
		this.ingresoAcumulable = ingresoAcumulable;
	}

	public void setIngresoNoAcumulable(String ingresoNoAcumulable) {
		this.ingresoNoAcumulable = ingresoNoAcumulable;
	}

}
