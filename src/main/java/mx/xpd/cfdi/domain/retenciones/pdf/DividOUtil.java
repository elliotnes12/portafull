package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "DividOUtil")
public class DividOUtil {

	private String cveTipDivOUtil;
	private String montISRAcredRetMexico;
	private String montISRAcredRetExtranjero;
	private String montRetExtDivExt;
	private String tipoSocDistrDiv;
	private String montISRAcredNal;
	private String montDivAcumNal;
	private String montDivAcumExt;
	
	public DividOUtil() {
		
	}
	
	@XmlAttribute(name = "CveTipDivOUtil")
	public String getCveTipDivOUtil() {
		return cveTipDivOUtil;
	}

	public void setCveTipDivOUtil(String cveTipDivOUtil) {
		this.cveTipDivOUtil = cveTipDivOUtil;
	}

	@XmlAttribute(name = "MontISRAcredRetMexico")
	public String getMontISRAcredRetMexico() {
		return montISRAcredRetMexico;
	}

	public void setMontISRAcredRetMexico(String montISRAcredRetMexico) {
		this.montISRAcredRetMexico = montISRAcredRetMexico;
	}

	@XmlAttribute(name = "MontISRAcredRetExtranjero")
	public String getMontISRAcredRetExtranjero() {
		return montISRAcredRetExtranjero;
	}

	public void setMontISRAcredRetExtranjero(String montISRAcredRetExtranjero) {
		this.montISRAcredRetExtranjero = montISRAcredRetExtranjero;
	}

	@XmlAttribute(name = "MontRetExtDivExt")
	public String getMontRetExtDivExt() {
		return montRetExtDivExt;
	}

	public void setMontRetExtDivExt(String montRetExtDivExt) {
		this.montRetExtDivExt = montRetExtDivExt;
	}

	@XmlAttribute(name = "TipoSocDistrDiv")
	public String getTipoSocDistrDiv() {
		return tipoSocDistrDiv;
	}

	public void setTipoSocDistrDiv(String tipoSocDistrDiv) {
		this.tipoSocDistrDiv = tipoSocDistrDiv;
	}

	@XmlAttribute(name = "MontISRAcredNal")
	public String getMontISRAcredNal() {
		return montISRAcredNal;
	}

	public void setMontISRAcredNal(String montISRAcredNal) {
		this.montISRAcredNal = montISRAcredNal;
	}

	@XmlAttribute(name = "MontDivAcumNal")
	public String getMontDivAcumNal() {
		return montDivAcumNal;
	}

	public void setMontDivAcumNal(String montDivAcumNal) {
		this.montDivAcumNal = montDivAcumNal;
	}

	@XmlAttribute(name = "MontDivAcumExt")
	public String getMontDivAcumExt() {
		return montDivAcumExt;
	}

	public void setMontDivAcumExt(String montDivAcumExt) {
		this.montDivAcumExt = montDivAcumExt;
	}	
}
