package mx.xpd.cfdi.domain.cfdi.complementos.nomina;

import javax.xml.bind.annotation.XmlAttribute;

public class Percepcion {

	private String tipoPercepcion;
	private String clave;
	private String concepto;
	private String importeGravado;
	private String importeExento;
	
	public Percepcion() {
		
	}
	
	public Percepcion(String []data) {
		tipoPercepcion = data[1];
		clave = data[2];
		concepto = data[3];
		importeGravado = data[4];
		importeExento = data[5];		
	}
	
	@XmlAttribute(name = "TipoPercepcion")
	public String getTipoPercepcion() {
		return tipoPercepcion.trim().equals("") ? null : tipoPercepcion.trim();
	}

	@XmlAttribute(name = "Clave")
	public String getClave() {
		return clave.trim().equals("") ? null : clave.trim();
	}

	@XmlAttribute(name = "Concepto")
	public String getConcepto() {
		return concepto.trim().equals("") ? null : concepto.trim();
	}

	@XmlAttribute(name = "ImporteGravado")
	public String getImporteGravado() {
		return importeGravado;
	}

	@XmlAttribute(name = "ImporteExento")
	public String getImporteExento() {
		return importeExento;
	}

	public void setTipoPercepcion(String tipoPercepcion) {
		this.tipoPercepcion = tipoPercepcion;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public void setImporteGravado(String importeGravado) {
		this.importeGravado = importeGravado;
	}

	public void setImporteExento(String importeExento) {
		this.importeExento = importeExento;
	}
}
