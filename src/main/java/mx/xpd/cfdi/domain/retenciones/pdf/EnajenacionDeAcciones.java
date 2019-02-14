package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "EnajenaciondeAcciones")
public class EnajenacionDeAcciones {

	private String version = "1.0";
	private String contratoIntermediacion;
	private String ganancia;
	private String perdida;
	
	
	public EnajenacionDeAcciones() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "ContratoIntermediacion")
	public String getContratoIntermediacion() {
		return contratoIntermediacion;
	}

	public void setContratoIntermediacion(String contratoIntermediacion) {
		this.contratoIntermediacion = contratoIntermediacion;
	}

	@XmlAttribute(name = "Ganancia")
	public String getGanancia() {
		return ganancia;
	}

	public void setGanancia(String ganancia) {
		this.ganancia = ganancia;
	}

	@XmlAttribute(name = "Perdida")
	public String getPerdida() {
		return perdida;
	}

	public void setPerdida(String perdida) {
		this.perdida = perdida;
	}


	


	
}
