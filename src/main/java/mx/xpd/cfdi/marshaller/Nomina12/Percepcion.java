package mx.xpd.cfdi.marshaller.Nomina12;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={
		"accionesOTitulos",
		"horasExtra",
})

public class Percepcion {
	
	private AccionesOTitulos accionesOTitulos;
	private List<HorasExtra> horasExtra;
	private String tipoPercepcion;
	private String clave;
	private String concepto;
	private String importeGravado;
	private String importeExento;
	
	public Percepcion() {
		
//		accionesOTitulos = new AccionesOTitulos();
//		horasExtra = new ArrayList<HorasExtra>();
		
	}
	
	public Percepcion(String []data) {
		
		accionesOTitulos = new AccionesOTitulos();
		horasExtra = new ArrayList<HorasExtra>();
		
		tipoPercepcion = data[2].equals(" ") ? null : data[2];
		clave = data[3].equals(" ") ? null : data[3];
		concepto = data[4].equals(" ") ? null : data[4];
		importeGravado = data[5].equals(" ") ? null : (data[5]);
		importeExento = data[6].equals(" ") ? null : (data[6]);
		
	}

	///////////// GETTERS NODOS
	@XmlElement(name = "AccionesOTitulos")
	public AccionesOTitulos getAccionesOTitulos() {
		return accionesOTitulos;
	}

	@XmlElement(name = "HorasExtra")
	public List<HorasExtra> getHorasExtra() {
		return horasExtra;
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "TipoPercepcion")
	public String getTipoPercepcion() {
		if(tipoPercepcion==null){return null;}
		return tipoPercepcion.trim().equals("") ? null : tipoPercepcion.trim();
		//return tipoPercepcion;
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

	@XmlAttribute(name = "ImporteGravado")
	public String getImporteGravado() {
		if(importeGravado==null){return null;}
		return importeGravado.trim().equals("") ? null : importeGravado.trim();
	}

	@XmlAttribute(name = "ImporteExento")
	public String getImporteExento() {
		if(importeExento==null){return null;}
		return importeExento.trim().equals("") ? null : importeExento.trim();
	}

	
	///////////// SETTERS NODOS
	public void setAccionesOTitulos(AccionesOTitulos accionesOTitulos) {
		this.accionesOTitulos = accionesOTitulos;
	}

	public void setHorasExtra(List<HorasExtra> horasExtra) {
		this.horasExtra = horasExtra;
	}

	///////////// SETTERS ATRIBUTOS
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
