package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.retenciones.EmisorRetenciones;
import mx.xpd.cfdi.domain.retenciones.ImpuestosRetenciones;
import mx.xpd.cfdi.domain.retenciones.PeriodoRetenciones;
import mx.xpd.cfdi.domain.retenciones.pdf.ReceptorRetenciones;
import mx.xpd.cfdi.domain.retenciones.pdf.TotalesRetenciones;


@XmlRootElement(name="Retenciones")
@XmlType(propOrder={
		"emisor",
		"receptor",
		"periodo",
		"totales", 
		"complemento"
})
public class RetencionesPDF {
	
	private String version; //
	private String serie;
	private String folio;
	// Se expresa en la forma aaaa-mm-ddThh:mm:ss, de acuerdo con la especificación ISO 8601
	private String fecha;
	private String sello;  
	private String noCertificado;
	private String certificado; //
	
	private String CveRetenc;
	private String DescRetenc;
	
	private EmisorRetenciones emisor;
	private ReceptorRetenciones receptor;
	private PeriodoRetenciones periodo;
	private TotalesRetenciones totales;
	private ComplementoRetenciones complemento;
		
	
	
	

	@XmlAttribute
	public String getVersion() {
		return version;
	}
	@XmlAttribute
	public String getFolio() {
		return folio;
	}
	@XmlAttribute
	public String getFecha() {
		return fecha;
	}
	@XmlAttribute
	public String getSello() {
		return sello;
	}
	@XmlAttribute
	public String getNoCertificado() {
		return noCertificado;
	}
	@XmlAttribute
	public String getCertificado() {
		return certificado;
	}
	@XmlAttribute(name = "CveRetenc")
	public String getCveRetenc() {
		return CveRetenc;
	}
	@XmlAttribute(name = "DescRetenc")
	public String getDescRetenc() {
		return DescRetenc;
	}
	
	@XmlElement(name = "Complemento")
	public ComplementoRetenciones getComplemento() {
		return complemento;
	}
	
	@XmlElement(name = "Emisor")
	public EmisorRetenciones getEmisor() {
		return emisor;
	}
	@XmlElement(name = "Receptor")
	public ReceptorRetenciones getReceptor() {
		return receptor;
	}
	@XmlElement(name = "Periodo")
	public PeriodoRetenciones getPeriodo() {
		return periodo;
	}
	@XmlElement(name = "Totales")
	public TotalesRetenciones getTotales() {
		return totales;
	}
	
	
	
	
	public void setTotales(TotalesRetenciones totales) {
		this.totales = totales;
	}
	public void setPeriodo(PeriodoRetenciones periodo) {
		this.periodo = periodo;
	}
	public void setEmisor(EmisorRetenciones emisor) {
		this.emisor = emisor;
	}
	public void setReceptor(ReceptorRetenciones receptor) {
		this.receptor = receptor;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setSello(String sello) {
		this.sello = sello;
	}
	
	public void setNoCertificado(String noCertificado) {
		this.noCertificado = noCertificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public void setCveRetenc(String cveRetenc) {
		this.CveRetenc = cveRetenc;
	}
	public void setDescRetenc(String descRetenc) {
		this.DescRetenc = descRetenc;
	}
	public void setComplemento(ComplementoRetenciones complemento) {
		this.complemento = complemento;
	}
	
	@Override
	public String toString() {
		return "Comprobante [version=" + version + ", serie=" + serie
				+ ", folio=" + folio + ", fecha=" + fecha + ", sello=" + sello
				+ ", noCertificado="
				+ noCertificado + ", certificado=" + certificado
				+ ", emisor=" + emisor + ", receptor=" + receptor+"]";
	}
	
}
