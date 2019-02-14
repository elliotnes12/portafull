package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PercepcionNomina12 {

	private String tipoPercepcion;
	private String clave;
	private String concepto;
	private String importeGravado;
	private String importeExento;
	
	private AccionesOTitulosNomina12 accionesOTitulos;
	private List<HorasExtrasNomina12> horasExtra;
	
	public PercepcionNomina12() {
		
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
	
	@XmlElement(name = "AccionesOTitulos")
	public AccionesOTitulosNomina12 getAccionesOTitulos() {
		return accionesOTitulos;
	}

	public void setAccionesOTitulos(AccionesOTitulosNomina12 accionesOTitulos) {
		this.accionesOTitulos = accionesOTitulos;
	}
	
	@XmlElement(name = "HorasExtra")
	public List<HorasExtrasNomina12> getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(List<HorasExtrasNomina12> horasExtra) {
		this.horasExtra = horasExtra;
	}
}
