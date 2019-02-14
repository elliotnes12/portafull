package mx.xpd.cfdi.domain.cfdi.pdf.complementos.certificadodestruccion;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "VehiculoDestruido")
public class VehiculoDestruido{

	private String marca;
	private String tipooClase;
	private String anio;
	private String modelo;
	private String niv;
	private String numSerie;
	private String numPlacas;
	private String numMotor;
	private String numFolTarjCir;
	
	
	public VehiculoDestruido() {
		
	}
	
	@XmlAttribute(name = "Marca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@XmlAttribute(name = "TipooClase")
	public String getTipooClase() {
		return tipooClase;
	}

	public void setTipooClase(String tipooClase) {
		this.tipooClase = tipooClase;
	}
	
	@XmlAttribute(name = "Año")
	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	@XmlAttribute(name = "Modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@XmlAttribute(name = "NIV")
	public String getNiv() {
		return niv;
	}

	public void setNiv(String niv) {
		this.niv = niv;
	}
	
	@XmlAttribute(name = "NumSerie")
	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	
	@XmlAttribute(name = "NumPlacas")
	public String getNumPlacas() {
		return numPlacas;
	}

	public void setNumPlacas(String numPlacas) {
		this.numPlacas = numPlacas;
	}
	
	@XmlAttribute(name = "NumMotor")
	public String getNumMotor() {
		return numMotor;
	}

	public void setNumMotor(String numMotor) {
		this.numMotor = numMotor;
	}
	
	@XmlAttribute(name = "NumFolTarjCir")
	public String getNumFolTarjCir() {
		return numFolTarjCir;
	}

	public void setNumFolTarjCir(String numFolTarjCir) {
		this.numFolTarjCir = numFolTarjCir;
	}
		
}