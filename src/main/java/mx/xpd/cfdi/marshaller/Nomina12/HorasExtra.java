package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;

public class HorasExtra {
	
	private Integer dias;
	private String tipoHoras;
	private Integer numeroHorasExtra;
	private String importePagado;
	
	public HorasExtra() {
		
	}
	
	public HorasExtra(String []data) {
		
		dias =  data[1].equals(" ") ? null : Integer.valueOf(data[1]);
		tipoHoras = data[2].equals(" ") ? null : data[2];
		numeroHorasExtra =  data[3].equals(" ") ? null : Integer.valueOf(data[3]);
		importePagado = data[4].equals(" ") ? null : (data[4]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "Dias")
	public Integer getDias() {
		if(dias==null){return null;}
		return dias;
	}

	@XmlAttribute(name = "TipoHoras")
	public String getTipoHoras() {
		if(tipoHoras==null){return null;}
		return tipoHoras.trim().equals("") ? null : tipoHoras.trim();
		//return tipoHoras;
	}

	@XmlAttribute(name = "HorasExtra")
	public Integer getNumeroHorasExtra() {
		if(numeroHorasExtra==null){return null;}
		return numeroHorasExtra;
	}

	@XmlAttribute(name = "ImportePagado")
	public String getImportePagado() {
		if(importePagado==null){return null;}
		return importePagado.trim().equals("") ? null : importePagado.trim();
	}

	///////////// SETTERS ATRIBUTOS
	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public void setTipoHoras(String tipoHoras) {
		this.tipoHoras = tipoHoras;
	}

	public void setNumeroHorasExtra(Integer numeroHorasExtra) {
		this.numeroHorasExtra = numeroHorasExtra;
	}

	public void setImportePagado(String importePagado) {
		this.importePagado = importePagado;
	}

}
