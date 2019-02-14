package mx.xpd.cfdi.domain.cfdi.complementos.comercioexterior;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Mercancia")
public class Mercancia {

	private String noIdentificacion;
	private String fraccionArancelaria;
	private String cantidadAduana;
	private String unidadAduana;
	private String valorUnitarioAduana;
	private String valorDolares;
	private List<DescripcionesEspecificas> descripcionesEspecificas;
	
	
	public Mercancia() {
		
	}

	@XmlAttribute(name = "NoIdentificacion")
	public String getNoIdentificacion() {
		return noIdentificacion;
	}

	public void setNoIdentificacion(String noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}

	@XmlAttribute(name = "FraccionArancelaria")
	public String getFraccionArancelaria() {
		return fraccionArancelaria;
	}

	public void setFraccionArancelaria(String fraccionArancelaria) {
		this.fraccionArancelaria = fraccionArancelaria;
	}

	@XmlAttribute(name = "CantidadAduana")
	public String getCantidadAduana() {
		return cantidadAduana;
	}

	public void setCantidadAduana(String cantidadAduana) {
		this.cantidadAduana = cantidadAduana;
	}

	@XmlAttribute(name = "UnidadAduana")
	public String getUnidadAduana() {
		return unidadAduana;
	}

	public void setUnidadAduana(String unidadAduana) {
		this.unidadAduana = unidadAduana;
	}
	
	@XmlAttribute(name = "ValorUnitarioAduana")
	public String getValorUnitarioAduana() {
		return valorUnitarioAduana;
	}

	public void setValorUnitarioAduana(String valorUnitarioAduana) {
		this.valorUnitarioAduana = valorUnitarioAduana;
	}

	@XmlAttribute(name = "ValorDolares")
	public String getValorDolares() {
		return valorDolares;
	}

	public void setValorDolares(String valorDolares) {
		this.valorDolares = valorDolares;
	}

	@XmlElement(name = "DescripcionesEspecificas")
	public List<DescripcionesEspecificas> getDescripcionesEspecificas() {
		return descripcionesEspecificas;
	}
	
	public void setDescripcionesEspecificas(
			List<DescripcionesEspecificas> descripcionesEspecificas) {
		this.descripcionesEspecificas = descripcionesEspecificas;
	}
	
	
}
