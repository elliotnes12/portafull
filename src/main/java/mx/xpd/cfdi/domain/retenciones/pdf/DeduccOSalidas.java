package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "DeduccOSalidas")
public class DeduccOSalidas {

	private String montTotEgresPeriodo;
	private String partPropDelFideicom;
	private String propDelMontTot;
	private IntegracEgresos integracEgresos;

	
	public DeduccOSalidas() {
		
	}
	
	@XmlAttribute(name = "MontTotEgresPeriodo")
	public String getMontTotEgresPeriodo() {
		return montTotEgresPeriodo;
	}

	public void setMontTotEgresPeriodo(String montTotEgresPeriodo) {
		this.montTotEgresPeriodo = montTotEgresPeriodo;
	}

	@XmlAttribute(name = "PartPropDelFideicom")
	public String getPartPropDelFideicom() {
		return partPropDelFideicom;
	}

	public void setPartPropDelFideicom(String partPropDelFideicom) {
		this.partPropDelFideicom = partPropDelFideicom;
	}

	@XmlAttribute(name = "PropDelMontTot")
	public String getPropDelMontTot() {
		return propDelMontTot;
	}

	public void setPropDelMontTot(String propDelMontTot) {
		this.propDelMontTot = propDelMontTot;
	}

	@XmlElement(name = "IntegracEgresos")
	public IntegracEgresos getIntegracEgresos() {
		return integracEgresos;
	}

	public void setIntegracEgresos(IntegracEgresos integracEgresos) {
		this.integracEgresos = integracEgresos;
	}

	
}
