package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.retenciones.ReceptorExtranjeroRetenciones;
import mx.xpd.cfdi.domain.retenciones.ReceptorNacionalRetenciones;


@XmlRootElement(name = "Fideicomisonoempresarial")
public class FideicomisoNoEmpresarial {

	private String version = "1.0";
	private IngresosOEntradas ingresosOEntradas;
	private DeduccOSalidas deduccOSalidas;
	private RetEfectFideicomiso retEfectFideicomiso; 
	
	public FideicomisoNoEmpresarial() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlElement(name = "IngresosOEntradas")
	public IngresosOEntradas getIngresosOEntradas() {
		return ingresosOEntradas;
	}

	public void setIngresosOEntradas(IngresosOEntradas ingresosOEntradas) {
		this.ingresosOEntradas = ingresosOEntradas;
	}

	@XmlElement(name = "DeduccOSalidas")
	public DeduccOSalidas getDeduccOSalidas() {
		return deduccOSalidas;
	}

	public void setDeduccOSalidas(DeduccOSalidas deduccOSalidas) {
		this.deduccOSalidas = deduccOSalidas;
	}

	@XmlElement(name = "RetEfectFideicomiso")
	public RetEfectFideicomiso getRetEfectFideicomiso() {
		return retEfectFideicomiso;
	}

	public void setRetEfectFideicomiso(RetEfectFideicomiso retEfectFideicomiso) {
		this.retEfectFideicomiso = retEfectFideicomiso;
	}

	
	
}
