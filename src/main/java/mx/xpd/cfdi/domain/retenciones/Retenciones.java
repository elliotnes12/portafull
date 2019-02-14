package mx.xpd.cfdi.domain.retenciones;

import java.io.UnsupportedEncodingException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name="Retenciones")
@XmlType(propOrder={
		"emisor",
		"receptor",
		"periodo",
		"totales",
		"complemento"
		//"addenda"
})
@XmlSeeAlso({Retenciones.class}) 
public class Retenciones {
	
	private String Version; 
	private String FolioInt;
	private String sello;
	private String noCertificado;
	private String cert;
	// Se expresa en la forma aaaa-mm-ddThh:mm:ss, de acuerdo con la especificación ISO 8601
	private String FechaExp;
	
		
	private String CveRetenc;
	private String DescRetenc;
	
		
	private EmisorRetenciones emisor;
	private ReceptorRetenciones receptor;
	private PeriodoRetenciones periodo;
	private TotalesRetenciones totales;
	
	private ComplementoRetenciones complemento;
	//private Addenda addenda;
	
	
	@XmlAttribute(name="Version")
	public String getVersion() {
		return Version;
	}
	
	public void setVersion(String Version) {
		this.Version = Version;
	}
	
	@XmlAttribute(name="FolioInt")
	public String getFolioInt() {
		return FolioInt;
	}
	
	public void setFolioInt(String FolioInt) {
		this.FolioInt = FolioInt;
	}
	
	@XmlAttribute(name="Sello")
	public String getSello() {
		return sello;
	}
	
	public void setSello(String sello) {
		this.sello = sello;
	}
	
	@XmlAttribute(name="NumCert")
	public String getNoCertificado() {
		return noCertificado;
	}
	
	public void setNoCertificado(String noCertificado) {
		this.noCertificado = noCertificado;
	}
	
	@XmlAttribute(name="Cert")
	public String getCert() {
		return cert;
	}
	
	public void setCert(String cert) {
		this.cert = cert;
	}
	
	@XmlAttribute(name="FechaExp")
	public String getFechaExp() {
		return FechaExp;
	}
	
	public void setFechaExp(String FechaExp) {
		this.FechaExp = FechaExp;
	}
	
		
	@XmlAttribute(name="CveRetenc")
	public String getCveRetenc() {
		return CveRetenc;
	}
	
	public void setCveRetenc(String CveRetenc) {
		this.CveRetenc = CveRetenc;
	}
	
	@XmlAttribute(name="DescRetenc")
	public String getDescRetenc() {
		return DescRetenc;
	}
	
	public void setDescRetenc(String DescRetenc) {
		this.DescRetenc = DescRetenc;
	}
	
		
	@XmlElement(name = "Emisor")
	public EmisorRetenciones getEmisor() {
		return emisor;
	}
	
	public void setEmisor(EmisorRetenciones emisor) {
		this.emisor = emisor;
	}
	
	@XmlElement(name = "Receptor")
	public ReceptorRetenciones getReceptor() {
		return receptor;
	}
	
	public void setReceptor(ReceptorRetenciones receptor) {
		this.receptor = receptor;
	}
	
	@XmlElement(name = "Periodo")
	public PeriodoRetenciones getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(PeriodoRetenciones periodo) {
		this.periodo = periodo;
	}
	
	@XmlElement(name = "Totales")
	public TotalesRetenciones getTotales() {
		return totales;
	}
	
	public void setTotales(TotalesRetenciones totales) {
		this.totales = totales;
	}
	
	
	
	@XmlElement(name = "Complemento")
	public ComplementoRetenciones getComplemento() {
		return complemento;
	}

	public void setComplemento(ComplementoRetenciones complemento) {
		this.complemento = complemento;
	}
	/*
	@XmlElement(name = "Addenda")
	public Addenda getAddenda() {
		return addenda;
	}

	public void setAddenda(Addenda addenda) {
		this.addenda = addenda;
	}
	*/
	@Override
	public String toString() {
		return "Retenciones [Version=" + Version + ", FolioInt=" + FolioInt + ", sello=" + sello 
				+ ", noCertificado=" + noCertificado + ", cert=" + cert 
				+ ", FechaExp=" + FechaExp + ", CveRetenc=" +CveRetenc 
				+ ", DescRetenc=" + DescRetenc 
				+ ", emisor=" + emisor 
				+ ", receptor=" + receptor
				+ ", periodo=" + periodo 
				//+ ",totales=" + totales
				//+ ", complemento=" + complemento + ",addenda=" + addenda+ 
				+"]";
	}
	
}
