package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Percepcion {

	private String tipoPercepcion;
	private String clave;
	private String concepto;
	private String importeGravado;
	private String importeExento;
	
	private AccionesOTitulos accionesOTitulos;
	private List<HorasExtras> horasExtra;
	
	public Percepcion() {
		
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
	public AccionesOTitulos getAccionesOTitulos() {
		return accionesOTitulos;
	}

	public void setAccionesOTitulos(AccionesOTitulos accionesOTitulos) {
		this.accionesOTitulos = accionesOTitulos;
	}
	
	@XmlElement(name = "HorasExtra")
	public List<HorasExtras> getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(List<HorasExtras> horasExtra) {
		this.horasExtra = horasExtra;
	}
}
