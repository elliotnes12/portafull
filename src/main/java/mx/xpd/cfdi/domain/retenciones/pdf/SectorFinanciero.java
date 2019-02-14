package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "SectorFinanciero")
public class SectorFinanciero {

	private String version = "1.0";
	private String idFideicom;
	private String nomFideicom;
	private String descripFideicom;
	
	public SectorFinanciero() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "IdFideicom")
	public String getIdFideicom() {
		return idFideicom;
	}

	public void setIdFideicom(String idFideicom) {
		this.idFideicom = idFideicom;
	}

	@XmlAttribute(name = "NomFideicom")
	public String getNomFideicom() {
		return nomFideicom;
	}

	public void setNomFideicom(String nomFideicom) {
		this.nomFideicom = nomFideicom;
	}

	@XmlAttribute(name = "DescripFideicom")
	public String getDescripFideicom() {
		return descripFideicom;
	}

	public void setDescripFideicom(String descripFideicom) {
		this.descripFideicom = descripFideicom;
	}

	
	
}
