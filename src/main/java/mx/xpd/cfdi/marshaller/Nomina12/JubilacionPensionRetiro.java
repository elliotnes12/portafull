package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;

public class JubilacionPensionRetiro {
	
	private String totalUnaExhibicion;
	private String totalParcialidad;
	private String montoDiario;
	private String ingresoAcumulable;
	private String ingresoNoAcumulable;
	
	public JubilacionPensionRetiro() {
		
	}
	
	public JubilacionPensionRetiro(String []data) {
		
		totalUnaExhibicion = data[1].equals(" ") ? null : (data[1]);
		totalParcialidad = data[2].equals(" ") ? null : (data[2]);
		montoDiario = data[3].equals(" ") ? null : (data[3]);
		ingresoAcumulable = data[4].equals(" ") ? null : (data[4]);
		ingresoNoAcumulable = data[5].equals(" ") ? null : (data[5]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "TotalUnaExhibicion")
	public String getTotalUnaExhibicion() {
		if(totalUnaExhibicion==null){return null;}
		return totalUnaExhibicion.trim().equals("") ? null : totalUnaExhibicion.trim();
	}

	@XmlAttribute(name = "TotalParcialidad")
	public String getTotalParcialidad() {
		if(totalParcialidad==null){return null;}
		return totalParcialidad.trim().equals("") ? null : totalParcialidad.trim();
	}

	@XmlAttribute(name = "MontoDiario")
	public String getMontoDiario() {
		if(montoDiario==null){return null;}
		return montoDiario.trim().equals("") ? null : montoDiario.trim();
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
	public void setTotalUnaExhibicion(String totalUnaExhibicion) {
		this.totalUnaExhibicion = totalUnaExhibicion;
	}

	public void setTotalParcialidad(String totalParcialidad) {
		this.totalParcialidad = totalParcialidad;
	}

	public void setMontoDiario(String montoDiario) {
		this.montoDiario = montoDiario;
	}

	public void setIngresoAcumulable(String ingresoAcumulable) {
		this.ingresoAcumulable = ingresoAcumulable;
	}

	public void setIngresoNoAcumulable(String ingresoNoAcumulable) {
		this.ingresoNoAcumulable = ingresoNoAcumulable;
	}

}
