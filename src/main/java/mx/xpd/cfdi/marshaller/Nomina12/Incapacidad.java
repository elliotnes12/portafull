package mx.xpd.cfdi.marshaller.Nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class Incapacidad {
	
	private Integer diasIncapacidad;
	private String tipoIncapacidad;
	private String importeMonetario;
	
	public Incapacidad() {
		
	}
	
	public Incapacidad(String []data) {
		
		diasIncapacidad = data[1].equals(" ") ? null : Integer.valueOf(data[1]);
		tipoIncapacidad = data[2].equals(" ") ? null : data[2];
		importeMonetario = data[3].equals(" ") ? null : (data[3]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "DiasIncapacidad")
	public Integer getDiasIncapacidad() {
		if(diasIncapacidad==null){return null;}
		return diasIncapacidad;
	}

	@XmlAttribute(name = "TipoIncapacidad")
	public String getTipoIncapacidad() {
		if(tipoIncapacidad==null){return null;}
		return tipoIncapacidad.trim().equals("") ? null : tipoIncapacidad.trim();
		//return tipoIncapacidad;
	}

	@XmlAttribute(name = "ImporteMonetario")
	public String getImporteMonetario() {
		if(importeMonetario==null){return null;}
		return importeMonetario.trim().equals("") ? null : importeMonetario.trim();
	}

	
	///////////// SETTERS ATRIBUTOS
	public void setDiasIncapacidad(Integer diasIncapacidad) {
		this.diasIncapacidad = diasIncapacidad;
	}

	public void setTipoIncapacidad(String tipoIncapacidad) {
		this.tipoIncapacidad = tipoIncapacidad;
	}

	public void setImporteMonetario(String importeMonetario) {
		this.importeMonetario = importeMonetario;
	}

}
