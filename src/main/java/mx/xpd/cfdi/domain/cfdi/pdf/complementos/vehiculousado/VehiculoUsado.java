package mx.xpd.cfdi.domain.cfdi.pdf.complementos.vehiculousado;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




@XmlRootElement(name = "VehiculoUsado")
public class VehiculoUsado {

	private String version = "1.0";
	private String montoAdquisicion;
	private String montoEnajenacion;
	private String claveVehicular;
	private String marca;
	private String tipo;
	private String modelo;
	private String numeroMotor;
	private String numeroSerie;
	private String NIV;
	private String valor;
	private List<InformacionAduanera> informacionAduanera;
	
	

	public VehiculoUsado() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "montoAdquisicion")
	public String getMontoAdquisicion() {
		return montoAdquisicion;
	}

	public void setMontoAdquisicion(String montoAdquisicion) {
		this.montoAdquisicion = montoAdquisicion;
	}

	@XmlAttribute(name = "montoEnajenacion")
	public String getMontoEnajenacion() {
		return montoEnajenacion;
	}

	public void setMontoEnajenacion(String montoEnajenacion) {
		this.montoEnajenacion = montoEnajenacion;
	}

	@XmlAttribute(name = "claveVehicular")
	public String getClaveVehicular() {
		return claveVehicular;
	}

	public void setClaveVehicular(String claveVehicular) {
		this.claveVehicular = claveVehicular;
	}

	@XmlAttribute(name = "marca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@XmlAttribute(name = "tipo")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@XmlAttribute(name = "modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@XmlAttribute(name = "numeroMotor")
	public String getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	@XmlAttribute(name = "numeroSerie")
	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	@XmlAttribute(name = "NIV")
	public String getNIV() {
		return NIV;
	}

	public void setNIV(String nIV) {
		NIV = nIV;
	}

	@XmlAttribute(name = "valor")
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@XmlElement(name = "InformacionAduanera")
	public List<InformacionAduanera> getInformacionAduanera() {
		return informacionAduanera;
	}

	public void setInformacionAduanera(List<InformacionAduanera> informacionAduanera) {
		this.informacionAduanera = informacionAduanera;
	}

		
			
}
