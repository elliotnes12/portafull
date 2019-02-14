package mx.xpd.cfdi.domain.cfdi.pdf.complementos.comercioexterior;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DescripcionesEspecificas")
public class DescripcionesEspecificas{

	private String marca;
	private String modelo;
	private String subModelo;
	private String numeroSerie;
	
	
	public DescripcionesEspecificas() {
		
	}
	
	@XmlAttribute(name = "Marca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	@XmlAttribute(name = "Modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@XmlAttribute(name = "SubModelo")
	public String getSubModelo() {
		return subModelo;
	}

	public void setSubModelo(String subModelo) {
		this.subModelo = subModelo;
	}
	
	@XmlAttribute(name = "NumeroSerie")
	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
				
}