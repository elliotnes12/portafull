package mx.xpd.cfdi.domain.cfdi;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Parte")
public class Parte{

	private String claveProdServ;
	private String noIdentificacion;
	private String cantidad;
	private String unidad;
	private String descripcion;
	private String valorUnitario;
	private String importe;
	private List<InformacionAduanera> informacionAduanera;
	
	public Parte() {
		
	}
	
	@XmlAttribute(name = "ClaveProdServ")
	public String getClaveProdServ() {
		return claveProdServ;
	}

	public void setClaveProdServ(String claveProdServ) {
		this.claveProdServ = claveProdServ;
	}
	
	@XmlAttribute(name = "NoIdentificacion")
	public String getNoIdentificacion() {
		return noIdentificacion;
	}

	public void setNoIdentificacion(String noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}
	
	@XmlAttribute(name = "Cantidad")
	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@XmlAttribute(name = "Unidad")
	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@XmlAttribute(name = "Descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@XmlAttribute(name = "ValorUnitario")
	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@XmlAttribute(name = "Importe")
	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe= importe;
	}


	@XmlElement(name = "InformacionAduanera")
	public List<InformacionAduanera> getInformacionAduanera() {
		return informacionAduanera;
	}

	public void setInformacionAduanera(List<InformacionAduanera> informacionAduanera) {
		this.informacionAduanera = informacionAduanera;
	}

	

	
	
	
	
		
	
}
