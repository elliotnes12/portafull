package mx.xpd.cfdi.domain.cfdi.pdf.timbre;

import javax.xml.bind.annotation.XmlAttribute;

public class TimbreFiscalDigital {

	private String fechaTimbrado;
	private String uuid;
	private String noCertificadoSAT;
	private String selloCFD;
	private String selloSAT;
	private String version;
	private String rfcProvCertif;
	private String leyenda;
	
	@XmlAttribute(name = "FechaTimbrado")
	public String getFechaTimbrado() {
		return fechaTimbrado;
	}
	@XmlAttribute(name = "UUID")
	public String getUuid() {
		return uuid;
	}
	@XmlAttribute(name = "NoCertificadoSAT")
	public String getNoCertificadoSAT() {
		return noCertificadoSAT;
	}
	@XmlAttribute(name = "SelloCFD")
	public String getSelloCFD() {
		return selloCFD;
	}
	@XmlAttribute(name = "SelloSAT")
	public String getSelloSAT() {
		return selloSAT;
	}
	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}
	@XmlAttribute(name = "RfcProvCertif")
	public String getRfcProvCertif() {
		return rfcProvCertif;
	}
	@XmlAttribute(name = "Leyenda")
	public String getLeyenda() {
		return leyenda;
	}
	/************************************************/
	public void setFechaTimbrado(String fechaTimbrado) {
		this.fechaTimbrado = fechaTimbrado;
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
	public void setRfcProvCertif(String rfcProvCertif) {
		this.rfcProvCertif = rfcProvCertif;
	}
	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}
	
}
