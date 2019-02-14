package mx.xpd.cfdi.domain.cfdi.complementos.valesdedespensa;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.complementos.valesdedespensa.Conceptos;




@XmlRootElement(name = "ValesDeDespensa")
public class ValesDeDespensa {

	private String version = "1.0";
	private String tipoOperacion;
	private String registroPatronal;
	private String numeroDeCuentaValesDespensa;
	private String totalValesDespensa;
	private Conceptos conceptos;
	
	

	public ValesDeDespensa() {
		
	}

	@XmlAttribute(name = "version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "tipoOperacion")
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	@XmlAttribute(name = "registroPatronal")
	public String getRegistroPatronal() {
		return registroPatronal;
	}

	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}

	@XmlAttribute(name = "numeroDeCuenta")
	public String getNumeroDeCuentaValesDespensa() {
		return numeroDeCuentaValesDespensa;
	}

	public void setNumeroDeCuenta(String numeroDeCuentaValesDespensa) {
		this.numeroDeCuentaValesDespensa = numeroDeCuentaValesDespensa;
	}

	@XmlAttribute(name = "total")
	public String getTotalValesDespensa() {
		return totalValesDespensa;
	}

	public void setTotalValesDespensa(String totalValesDespensa) {
		this.totalValesDespensa = totalValesDespensa;
	}

	@XmlElement(name = "Conceptos")
	public Conceptos getConceptos() {
		return conceptos;
	}

	public void setConceptos(Conceptos conceptos) {
		this.conceptos = conceptos;
	}
	
			
}
