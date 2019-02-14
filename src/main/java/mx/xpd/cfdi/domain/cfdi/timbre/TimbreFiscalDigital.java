package mx.xpd.cfdi.domain.cfdi.timbre;

import javax.xml.bind.annotation.XmlAttribute;

public class TimbreFiscalDigital {

	private String fechaTimrbado;
	private String uuid;
	private String noCertificadoSAT;
	private String selloCFD;
	private String selloSAT;
	private String version;
	
	@XmlAttribute
	public String getFechaTimrbado() {
		return fechaTimrbado;
	}
	@XmlAttribute
	public String getUuid() {
		return uuid;
	}
	@XmlAttribute
	public String getNoCertificadoSAT() {
		return noCertificadoSAT;
	}
	@XmlAttribute
	public String getSelloCFD() {
		return selloCFD;
	}
	@XmlAttribute
	public String getSelloSAT() {
		return selloSAT;
	}
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	/************************************************/
	public void setFechaTimrbado(String fechaTimrbado) {
		this.fechaTimrbado = fechaTimrbado;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setNoCertificadoSAT(String noCertificadoSAT) {
		this.noCertificadoSAT = noCertificadoSAT;
	}
	public void setSelloCFD(String selloCFD) {
		this.selloCFD = selloCFD;
	}
	public void setSelloSAT(String selloSAT) {
		this.selloSAT = selloSAT;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}
