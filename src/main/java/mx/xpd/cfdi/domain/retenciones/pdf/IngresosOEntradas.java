package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "IngresosOEntradas")
public class IngresosOEntradas {

	private String montTotEntradasPeriodo;
	private String partPropAcumDelFideicom;
	private String propDelMontTot;
	private IntegracIngresos integracIngresos;

	
	public IngresosOEntradas() {
		
	}
	
	@XmlAttribute(name = "MontTotEntradasPeriodo")
	public String getMontTotEntradasPeriodo() {
		return montTotEntradasPeriodo;
	}

	public void setMontTotEntradasPeriodo(String montTotEntradasPeriodo) {
		this.montTotEntradasPeriodo = montTotEntradasPeriodo;
	}

	@XmlAttribute(name = "PartPropAcumDelFideicom")
	public String getPartPropAcumDelFideicom() {
		return partPropAcumDelFideicom;
	}

	public void setPartPropAcumDelFideicom(String partPropAcumDelFideicom) {
		this.partPropAcumDelFideicom = partPropAcumDelFideicom;
	}

	@XmlAttribute(name = "PropDelMontTot")
	public String getPropDelMontTot() {
		return propDelMontTot;
	}

	public void setPropDelMontTot(String propDelMontTot) {
		this.propDelMontTot = propDelMontTot;
	}

	@XmlElement(name = "IntegracIngresos")
	public IntegracIngresos getIntegracIngresos() {
		return integracIngresos;
	}

	public void setIntegracIngresos(IntegracIngresos integracIngresos) {
		this.integracIngresos = integracIngresos;
	}

	

	

	
}
