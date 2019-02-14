package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.retenciones.ReceptorExtranjeroRetenciones;
import mx.xpd.cfdi.domain.retenciones.ReceptorNacionalRetenciones;


@XmlRootElement(name = "Dividendos")
public class Dividendos {

	private String version = "1.0";
	private DividOUtil dividOUtil;
	private Remanente remanente;
	
	public Dividendos() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlElement(name = "DividOUtil")
	public DividOUtil getDividOUtil() {
		return dividOUtil;
	}

	public void setDividOUtil(DividOUtil dividOUtil) {
		this.dividOUtil = dividOUtil;
	}

	@XmlElement(name = "Remanente")
	public Remanente getRemanente() {
		return remanente;
	}

	public void setRemanente(Remanente remanente) {
		this.remanente = remanente;
	}

	
	
}
