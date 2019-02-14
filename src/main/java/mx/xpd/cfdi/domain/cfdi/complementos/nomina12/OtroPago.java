package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OtroPago {

	private String tipoOtroPago;
	private String claveOtroPago;
	private String conceptoOtroPago;
	private String importeOtroPago;
	
	private SubsidioAlEmpleo subsidioAlEmpleo;
	private CompensacionSaldosAFavor compensacionSaldosAFavor;
		
	public OtroPago() {
		
	}
			
	@XmlAttribute(name = "TipoOtroPago")
	public String getTipoOtroPago() {
		return tipoOtroPago;
	}

	public void setTipoOtroPago(String tipoOtroPago) {
		this.tipoOtroPago = tipoOtroPago;
	}
	
	@XmlAttribute(name = "Clave")
	public String getClaveOtroPago() {
		return claveOtroPago;
	}

	public void setClaveOtroPago(String claveOtroPago) {
		this.claveOtroPago = claveOtroPago;
	}
	
	@XmlAttribute(name = "Concepto")
	public String getConceptoOtroPago() {
		return conceptoOtroPago;
	}
	
	public void setConceptoOtroPago(String conceptoOtroPago) {
		this.conceptoOtroPago = conceptoOtroPago;
	}

	@XmlAttribute(name = "Importe")
	public String getImporteOtroPago() {
		return importeOtroPago;
	}

	public void setImporteOtroPago(String importeOtroPago) {
		this.importeOtroPago = importeOtroPago;
	}
	
	@XmlElement(name = "SubsidioAlEmpleo")
	public SubsidioAlEmpleo getSubsidioAlEmpleo() {
		return subsidioAlEmpleo;
	}

	public void setSubsidioAlEmpleo(SubsidioAlEmpleo subsidioAlEmpleo) {
		this.subsidioAlEmpleo = subsidioAlEmpleo;
	}
	
	@XmlElement(name = "CompensacionSaldosAFavor")
	public CompensacionSaldosAFavor getCompensacionSaldosAFavor() {
		return compensacionSaldosAFavor;
	}

	public void setCompensacionSaldosAFavor(CompensacionSaldosAFavor compensacionSaldosAFavor) {
		this.compensacionSaldosAFavor = compensacionSaldosAFavor;
	}
}
