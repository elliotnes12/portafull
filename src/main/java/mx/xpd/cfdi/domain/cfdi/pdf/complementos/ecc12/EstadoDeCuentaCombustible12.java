package mx.xpd.cfdi.domain.cfdi.pdf.complementos.ecc12;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




@XmlRootElement(name = "EstadoDeCuentaCombustible")
public class EstadoDeCuentaCombustible12 {

	private String version = "1.2";
	private String tipoOperacion;
	private String numeroDeCuenta;
	private String subTotal;
	private String total;
	private ConceptosConsumoCombustibles12 conceptos;
	
	

	public EstadoDeCuentaCombustible12() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "TipoOperacion")
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	@XmlAttribute(name = "NumeroDeCuenta")
	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	@XmlAttribute(name = "SubTotal")
	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal= subTotal;
	}

	@XmlAttribute(name = "Total")
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@XmlElement(name = "Conceptos")
	public ConceptosConsumoCombustibles12 getConceptos() {
		return conceptos;
	}

	public void setConceptos(ConceptosConsumoCombustibles12 conceptos) {
		this.conceptos = conceptos;
	}

	
			
}
