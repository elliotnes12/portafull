package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Planesderetiro")
public class PlanesDeRetiro {

	private String version = "1.0";
	private String sistemaFinanc;
	private String montTotAportAnioInmAnterior;
	private String montIntRealesDevengAniooInmAnt;
	private String huboRetirosAnioInmAntPer;
	private String montTotRetiradoAnioInmAntPer;
	private String montTotExentRetiradoAnioInmAnt;
	private String montTotExedenteAnioInmAnt;
	private String huboRetirosAnioInmAnt;
	private String montTotRetiradoAnioInmAnt;
	
	public PlanesDeRetiro() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "SistemaFinanc")
	public String getSistemaFinanc() {
		return sistemaFinanc;
	}

	public void setSistemaFinanc(String sistemaFinanc) {
		this.sistemaFinanc = sistemaFinanc;
	}
	
	@XmlAttribute(name = "MontTotAportAnioInmAnterior")
	public String getMontTotAportAnioInmAnterior() {
		return montTotAportAnioInmAnterior;
	}

	public void setMontTotAportAnioInmAnterior(String montTotAportAnioInmAnterior) {
		this.montTotAportAnioInmAnterior = montTotAportAnioInmAnterior;
	}
	
	@XmlAttribute(name = "MontIntRealesDevengAniooInmAnt")
	public String getMontIntRealesDevengAniooInmAnt() {
		return montIntRealesDevengAniooInmAnt;
	}

	public void setMontIntRealesDevengAniooInmAnt(
			String montIntRealesDevengAniooInmAnt) {
		this.montIntRealesDevengAniooInmAnt = montIntRealesDevengAniooInmAnt;
	}

	@XmlAttribute(name = "HuboRetirosAnioInmAntPer")
	public String getHuboRetirosAnioInmAntPer() {
		return huboRetirosAnioInmAntPer;
	}

	public void setHuboRetirosAnioInmAntPer(String huboRetirosAnioInmAntPer) {
		this.huboRetirosAnioInmAntPer = huboRetirosAnioInmAntPer;
	}

	@XmlAttribute(name = "MontTotRetiradoAnioInmAntPer")
	public String getMontTotRetiradoAnioInmAntPer() {
		return montTotRetiradoAnioInmAntPer;
	}

	public void setMontTotRetiradoAnioInmAntPer(String montTotRetiradoAnioInmAntPer) {
		this.montTotRetiradoAnioInmAntPer = montTotRetiradoAnioInmAntPer;
	}

	@XmlAttribute(name = "MontTotExentRetiradoAnioInmAnt")
	public String getMontTotExentRetiradoAnioInmAnt() {
		return montTotExentRetiradoAnioInmAnt;
	}

	public void setMontTotExentRetiradoAnioInmAnt(
			String montTotExentRetiradoAnioInmAnt) {
		this.montTotExentRetiradoAnioInmAnt = montTotExentRetiradoAnioInmAnt;
	}

	@XmlAttribute(name = "MontTotExedenteAnioInmAnt")
	public String getMontTotExedenteAnioInmAnt() {
		return montTotExedenteAnioInmAnt;
	}

	public void setMontTotExedenteAnioInmAnt(String montTotExedenteAnioInmAnt) {
		this.montTotExedenteAnioInmAnt = montTotExedenteAnioInmAnt;
	}
	
	@XmlAttribute(name = "HuboRetirosAnioInmAnt")
	public String getHuboRetirosAnioInmAnt() {
		return huboRetirosAnioInmAnt;
	}

	public void setHuboRetirosAnioInmAnt(String huboRetirosAnioInmAnt) {
		this.huboRetirosAnioInmAnt = huboRetirosAnioInmAnt;
	}

	@XmlAttribute(name = "MontTotRetiradoAnioInmAnt")
	public String getMontTotRetiradoAnioInmAnt() {
		return montTotRetiradoAnioInmAnt;
	}

	public void setMontTotRetiradoAnioInmAnt(String montTotRetiradoAnioInmAnt) {
		this.montTotRetiradoAnioInmAnt = montTotRetiradoAnioInmAnt;
	}
	
	
	
}
