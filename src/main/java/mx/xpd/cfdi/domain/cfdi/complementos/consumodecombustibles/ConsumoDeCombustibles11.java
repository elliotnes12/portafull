package mx.xpd.cfdi.domain.cfdi.complementos.consumodecombustibles;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




@XmlRootElement(name = "ConsumoDeCombustibles11")
public class ConsumoDeCombustibles11 {

	private String version = "1.1";
	private String tipoOperacion;
	private String numeroDeCuenta;
	private String subTotal;
	private String total;
	private Conceptos conceptos;
	
	

	public ConsumoDeCombustibles11() {
		
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

	@XmlAttribute(name = "numeroDeCuenta")
	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	@XmlAttribute(name = "subTotal")
	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal= subTotal;
	}

	@XmlAttribute(name = "total")
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@XmlElement(name = "Conceptos")
	public Conceptos getConceptos() {
		return conceptos;
	}

	public void setConceptos(Conceptos conceptos) {
		this.conceptos = conceptos;
	}

	
			
}
