package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;

public class Deduccion {
	
	private String tipoDeduccion;
	private String clave;
	private String concepto;
	private String importe;
	
	public Deduccion() {
		
	}
	
	public Deduccion(String []data) {
		
		tipoDeduccion = data[1].equals(" ") ? null : data[1];
		clave = data[2].equals(" ") ? null : data[2];
		concepto = data[3].equals(" ") ? null : data[3];
		importe = data[4].equals(" ") ? null : (data[4]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "TipoDeduccion")
	public String getTipoDeduccion() {
		if(tipoDeduccion==null){return null;}
		return tipoDeduccion.trim().equals("") ? null : tipoDeduccion.trim();
		//return tipoDeduccion;
	}

	@XmlAttribute(name = "Clave")
	public String getClave() {
		if(clave==null){return null;}
		return clave.trim().equals("") ? null : clave.trim();
		//return clave;
	}

	@XmlAttribute(name = "Concepto")
	public String getConcepto() {
		if(concepto==null){return null;}
		return concepto.trim().equals("") ? null : concepto.trim();
		//return concepto;
	}

	@XmlAttribute(name = "Importe")
	public String getImporte() {
		if(importe==null){return null;}
		return importe.trim().equals("") ? null : importe.trim();
	}

	
	///////////// SETTERS ATRIBUTOS
	public void setTipoDeduccion(String tipoDeduccion) {
		this.tipoDeduccion = tipoDeduccion;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

}
