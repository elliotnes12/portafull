package mx.xpd.cfdi.domain.cfdi.complementos.valesdedespensa;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "ConceptoValesDespensa")
public class ConceptoValesDespensa{

	private String identificadorValesDespensa;
	private String fechaValesDespensa;
	private String rfcValesDespensa;
	private String curpValesDespensa;
	private String nombreValesDespensa;
	private String numSeguridadSocial;
	private String importeValesDespensa;
	
	public ConceptoValesDespensa() {
		
	}
	
	@XmlAttribute(name = "identificador")
	public String getIdentificadorValesDespensa() {
		return identificadorValesDespensa;
	}

	public void setIdentificadorValesDespensa(String identificadorValesDespensa) {
		this.identificadorValesDespensa = identificadorValesDespensa;
	}

	@XmlAttribute(name = "fecha")
	public String getFechaValesDespensa() {
		return fechaValesDespensa;
	}

	public void setFechaValesDespensa(String fechaValesDespensa) {
		this.fechaValesDespensa = fechaValesDespensa;
	}

	@XmlAttribute(name = "rfc")
	public String getRfcValesDespensa() {
		return rfcValesDespensa;
	}

	public void setRfcValesDespensa(String rfcValesDespensa) {
		this.rfcValesDespensa = rfcValesDespensa;
	}

	@XmlAttribute(name = "curp")
	public String getCurpValesDespensa() {
		return curpValesDespensa;
	}

	public void setCurpValesDespensa(String curpValesDespensa) {
		this.curpValesDespensa = curpValesDespensa;
	}

	@XmlAttribute(name = "nombre")
	public String getNombreValesDespensa() {
		return nombreValesDespensa;
	}

	public void setNombreValesDespensa(String nombreValesDespensa) {
		this.nombreValesDespensa = nombreValesDespensa;
	}

	@XmlAttribute(name = "numSeguridadSocial")
	public String getNumSeguridadSocial() {
		return numSeguridadSocial;
	}

	public void setNumSeguridadSocial(String numSeguridadSocial) {
		this.numSeguridadSocial = numSeguridadSocial;
	}

	@XmlAttribute(name = "importe")
	public String getImporteValesDespensa() {
		return importeValesDespensa;
	}

	public void setImporteValesDespensa(String importeValesDespensa) {
		this.importeValesDespensa = importeValesDespensa;
	}

			
	
}
