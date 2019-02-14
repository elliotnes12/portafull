package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OtroPagoNomina12 {

	private String tipoOtroPago;
	private String claveOtroPago;
	private String conceptoOtroPago;
	private String importeOtroPago;
	
	private SubsidioAlEmpleoNomina12 subsidioAlEmpleo;
	private CompensacionSaldosAFavorNomina12 compensacionSaldosAFavor;
		
	public OtroPagoNomina12() {
		
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
	public SubsidioAlEmpleoNomina12 getSubsidioAlEmpleo() {
		return subsidioAlEmpleo;
	}

	public void setSubsidioAlEmpleo(SubsidioAlEmpleoNomina12 subsidioAlEmpleo) {
		this.subsidioAlEmpleo = subsidioAlEmpleo;
	}
	
	@XmlElement(name = "CompensacionSaldosAFavor")
	public CompensacionSaldosAFavorNomina12 getCompensacionSaldosAFavor() {
		return compensacionSaldosAFavor;
	}

	public void setCompensacionSaldosAFavor(CompensacionSaldosAFavorNomina12 compensacionSaldosAFavor) {
		this.compensacionSaldosAFavor = compensacionSaldosAFavor;
	}
}
