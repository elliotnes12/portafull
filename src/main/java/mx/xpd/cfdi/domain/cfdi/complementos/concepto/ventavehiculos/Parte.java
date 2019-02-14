package mx.xpd.cfdi.domain.cfdi.complementos.concepto.ventavehiculos;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Parte")
public class Parte{

	private String cantidad;
	private String unidad;
	private String noIdentificacion;
	private String descripcion;
	private String valorUnitario;
	private String importe;
	private List<InformacionAduanera> infoAduana;
	
	public Parte() {
		
	}
	
	@XmlAttribute(name = "cantidad")
	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@XmlAttribute(name = "unidad")
	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@XmlAttribute(name = "noIdentificacion")
	public String getNoIdentificacion() {
		return noIdentificacion;
	}

	public void setNoIdentificacion(String noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}

	@XmlAttribute(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@XmlAttribute(name = "valorUnitario")
	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@XmlAttribute(name = "importe")
	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}


	@XmlElement(name = "InformacionAduanera")
	public List<InformacionAduanera> getInfoAduana() {
		return infoAduana;
	}

	public void setInfoAduana(List<InformacionAduanera> infoAduana) {
		this.infoAduana = infoAduana;
	}

	

	
	
	
	
		
	
}
