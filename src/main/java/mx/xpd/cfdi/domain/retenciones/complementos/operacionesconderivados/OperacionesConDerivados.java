package mx.xpd.cfdi.domain.retenciones.complementos.operacionesconderivados;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "OperacionesConDerivados")
public class OperacionesConDerivados {

	private String version = "1.0";
	private String montGanAcum;
	private String montPerdDed;
	
	public OperacionesConDerivados() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "MontGanAcum")
	public String getMontGanAcum() {
		return montGanAcum;
	}

	public void setMontGanAcum(String montGanAcum) {
		this.montGanAcum = montGanAcum;
	}

	@XmlAttribute(name = "MontPerdDed")
	public String getMontPerdDed() {
		return montPerdDed;
	}
	
	public void setMontPerdDed(String montPerdDed) {
		this.montPerdDed = montPerdDed;
	}

	


	
}
