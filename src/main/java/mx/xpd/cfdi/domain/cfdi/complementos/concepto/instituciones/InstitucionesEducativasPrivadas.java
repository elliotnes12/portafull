package mx.xpd.cfdi.domain.cfdi.complementos.concepto.instituciones;

import javax.xml.bind.annotation.XmlAttribute;

public class InstitucionesEducativasPrivadas {

	private String version;
	private String nombreAlumno;
	private String curp;
	private String nivelEducativo;
	private String autRVOE;
	private String rfcPago;
	
	public InstitucionesEducativasPrivadas() {
		this.version = "1.0";
	}
	
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	@XmlAttribute
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	@XmlAttribute(name = "CURP")
	public String getCurp() {
		return curp;
	}
	@XmlAttribute
	public String getNivelEducativo() {
		return nivelEducativo;
	}
	@XmlAttribute
	public String getAutRVOE() {
		return autRVOE;
	}
	@XmlAttribute
	public String getRfcPago() {
		return rfcPago;
	}
	/********************************/
	public void setVersion(String version) {
		this.version = version;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public void setNivelEducativo(String nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}
	public void setAutRVOE(String autRVOE) {
		this.autRVOE = autRVOE;
	}
	public void setRfcPago(String rfcPago) {
		this.rfcPago = rfcPago;
	}
	
	
	
}
