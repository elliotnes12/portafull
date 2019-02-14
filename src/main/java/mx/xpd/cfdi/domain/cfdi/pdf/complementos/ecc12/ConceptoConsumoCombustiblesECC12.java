package mx.xpd.cfdi.domain.cfdi.pdf.complementos.ecc12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "ConceptoConsumoCombustibles")
public class ConceptoConsumoCombustiblesECC12 {

	private String identificadorECC12;
	private String fechaExpOperECC12;
	private String rfcEnajCombustibleECC12;
	private String claveEstacionECC12;
	private String cantidadConceptoECC12;
	private String noIdentificacionConceptoECC12;
	private String unidadConceptoECC12;
	private String nombreCombustibleECC12;
	private String folioOperacionECC12;
	private String precioUnitarioECC12;
	private String importeCombustibleECC12;
	private TrasladosConsumoCombustibles12 traslados;
	
	public ConceptoConsumoCombustiblesECC12() {
		
	}

	@XmlAttribute(name = "Identificador")
	public String getIdentificadorECC12() {
		return identificadorECC12;
	}

	public void setIdentificadorECC12(String identificadorECC12) {
		this.identificadorECC12 = identificadorECC12;
	}

	@XmlAttribute(name = "Fecha")
	public String getFechaExpOperECC12() {
		return fechaExpOperECC12;
	}

	public void setFechaExpOperECC12(String fechaExpOperECC12) {
		this.fechaExpOperECC12 = fechaExpOperECC12;
	}

	@XmlAttribute(name = "Rfc")
	public String getRfcEnajCombustibleECC12() {
		return rfcEnajCombustibleECC12;
	}

	public void setRfcEnajCombustibleECC12(String rfcEnajCombustibleECC12) {
		this.rfcEnajCombustibleECC12 = rfcEnajCombustibleECC12;
	}

	@XmlAttribute(name = "ClaveEstacion")
	public String getClaveEstacionECC12() {
		return claveEstacionECC12;
	}

	public void setClaveEstacionECC12(String claveEstacionECC12) {
		this.claveEstacionECC12 = claveEstacionECC12;
	}
	
	@XmlAttribute(name = "Cantidad")
	public String getCantidadConceptoECC12() {
		return cantidadConceptoECC12;
	}

	public void setCantidadConceptoECC12(String cantidadConceptoECC12) {
		this.cantidadConceptoECC12 = cantidadConceptoECC12;
	}

	@XmlAttribute(name = "TipoCombustible")
	public String getNoIdentificacionConceptoECC12() {
		return noIdentificacionConceptoECC12;
	}

	public void setNoIdentificacionConceptoECC12(String noIdentificacionConceptoECC12) {
		this.noIdentificacionConceptoECC12 = noIdentificacionConceptoECC12;
	}
	
	@XmlAttribute(name = "Unidad")
	public String getUnidadConceptoECC12() {
		return unidadConceptoECC12;
	}

	public void setUnidadConceptoECC12(String unidadConceptoECC12) {
		this.unidadConceptoECC12 = unidadConceptoECC12;
	}
	
	@XmlAttribute(name = "NombreCombustible")
	public String getNombreCombustibleECC12() {
		return nombreCombustibleECC12;
	}

	public void setNombreCombustibleECC12(String nombreCombustibleECC12) {
		this.nombreCombustibleECC12 = nombreCombustibleECC12;
	}

	@XmlAttribute(name = "FolioOperacion")
	public String getFolioOperacionECC12() {
		return folioOperacionECC12;
	}

	public void setFolioOperacionECC12(String folioOperacionECC12) {
		this.folioOperacionECC12 = folioOperacionECC12;
	}

	@XmlAttribute(name = "ValorUnitario")
	public String getPrecioUnitarioECC12() {
		return precioUnitarioECC12;
	}

	public void setPrecioUnitarioECC12(String precioUnitarioECC12) {
		this.precioUnitarioECC12 = precioUnitarioECC12;
	}

	@XmlAttribute(name = "Importe")
	public String getImporteCombustibleECC12() {
		return importeCombustibleECC12;
	}

	public void setImporteCombustibleECC12(String importeCombustibleECC12) {
		this.importeCombustibleECC12 = importeCombustibleECC12;
	}

	@XmlElement(name = "Traslados")
	public TrasladosConsumoCombustibles12 getTraslados() {
		return traslados;
	}

	public void setTraslados(TrasladosConsumoCombustibles12 traslados) {
		this.traslados = traslados;
	}
	
	
	
}
