package mx.xpd.cfdi.domain.cfdi.complementos.comercioexterior;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.complementos.aerolineas.Cargo;
import mx.xpd.cfdi.domain.cfdi.complementos.aerolineas.OtrosCargos;


@XmlRootElement(name = "ComercioExterior")
@XmlType(propOrder={
		"emisor",
		"propietario",
		"receptor",
		"destinatario",
		"mercancias"
})
public class ComercioExterior {

	private String version = "1.1";
	private String motivoTraslado;
	private String tipoOperacion;
	private String claveDePedimento;
	private String certificadoOrigen;
	private String numCertificadoOrigen;
	private String numeroExportadorConfiable;
	private String incoterm;
	private String subdivision;
	private String observaciones;
	private String tipoCambioUSD;
	private String totalUSD;
	private Emisor emisor;
	private List<Propietario> propietario;
	private Receptor receptor;
	private List<Destinatario> destinatario;
	private Mercancias mercancias;
		
	public ComercioExterior() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "MotivoTraslado")
	public String getMotivoTraslado() {
		return motivoTraslado;
	}

	public void setMotivoTraslado(String motivoTraslado) {
		this.motivoTraslado = motivoTraslado;
	}
	
	@XmlAttribute(name = "TipoOperacion")
	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	@XmlAttribute(name = "ClaveDePedimento")
	public String getClaveDePedimento() {
		return claveDePedimento;
	}

	public void setClaveDePedimento(String claveDePedimento) {
		this.claveDePedimento = claveDePedimento;
	}
	
	@XmlAttribute(name = "CertificadoOrigen")
	public String getCertificadoOrigen() {
		return certificadoOrigen;
	}

	public void setCertificadoOrigen(String certificadoOrigen) {
		this.certificadoOrigen = certificadoOrigen;
	}
	
	@XmlAttribute(name = "NumCertificadoOrigen")
	public String getNumCertificadoOrigen() {
		return numCertificadoOrigen;
	}

	public void setNumCertificadoOrigen(String numCertificadoOrigen) {
		this.numCertificadoOrigen = numCertificadoOrigen;
	}
	
	@XmlAttribute(name = "NumeroExportadorConfiable")
	public String getNumeroExportadorConfiable() {
		return numeroExportadorConfiable;
	}

	public void setNumeroExportadorConfiable(String numeroExportadorConfiable) {
		this.numeroExportadorConfiable = numeroExportadorConfiable;
	}
	
	@XmlAttribute(name = "Incoterm")
	public String getIncoterm() {
		return incoterm;
	}

	public void setIncoterm(String incoterm) {
		this.incoterm = incoterm;
	}
	
	@XmlAttribute(name = "Subdivision")
	public String getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}
	
	@XmlAttribute(name = "Observaciones")
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@XmlAttribute(name = "TipoCambioUSD")
	public String getTipoCambioUSD() {
		return tipoCambioUSD;
	}

	public void setTipoCambioUSD(String tipoCambioUSD) {
		this.tipoCambioUSD = tipoCambioUSD;
	}
	
	@XmlAttribute(name = "TotalUSD")
	public String getTotalUSD() {
		return totalUSD;
	}

	public void setTotalUSD(String totalUSD) {
		this.totalUSD = totalUSD;
	}
	
	@XmlElement(name = "Emisor")
	public Emisor getEmisor() {
		return emisor;
	}

	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}
	
	@XmlElement(name = "Propietario")
	public List<Propietario> getPropietario() {
		return propietario;
	}
	
	public void setPropietario(
			List<Propietario> propietario) {
		this.propietario = propietario;
	}
	
	@XmlElement(name = "Receptor")
	public Receptor getReceptor() {
		return receptor;
	}

	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	
	@XmlElement(name = "Destinatario")
	public List<Destinatario> getDestinatario() {
		return destinatario;
	}
	
	public void setDestinatario(List<Destinatario> destinatario) {
		this.destinatario = destinatario;
	}
	
	@XmlElement(name = "Mercancias")
	public Mercancias getMercancias() {
		return mercancias;
	}

	public void setMercancias(Mercancias mercancias) {
		this.mercancias = mercancias;
	}

	



		
			
}