package mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "PorCuentadeTerceros")
public class Terceros {

	private String version;
	private String rfcCuentaTerceros;
	private String nombreCuentaTerceros;
	private InformacionFiscalTercero informacionFiscalTercero;
	private InformacionAduaneraTercero informacionAduanera;
	private List<ParteTercero> parte;
	private CuentaPredial cuentaPredial;
	private ImpuestosTercero impuestos;
	
	public Terceros() {
		this.version = "1.1";
	}
	
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "rfc")
	public String getRfcCuentaTerceros() {
		return rfcCuentaTerceros;
	}

	public void setRfcCuentaTerceros(String rfcCuentaTerceros) {
		this.rfcCuentaTerceros = rfcCuentaTerceros;
	}

	@XmlAttribute(name = "nombre")
	public String getNombreCuentaTerceros() {
		return nombreCuentaTerceros;
	}

	public void setNombreCuentaTerceros(String nombreCuentaTerceros) {
		this.nombreCuentaTerceros = nombreCuentaTerceros;
	}
	
	
	@XmlElement(name = "InformacionFiscalTercero")
	public InformacionFiscalTercero getInformacionFiscalTercero() {
		return informacionFiscalTercero;
	}

	public void setInformacionFiscalTercero(InformacionFiscalTercero informacionFiscalTercero) {
		this.informacionFiscalTercero = informacionFiscalTercero;
	}
	
	
	@XmlElement(name = "InformacionAduaneraTercero")
	public InformacionAduaneraTercero getInformacionAduanera() {
		return informacionAduanera;
	}

	public void setInformacionAduanera(InformacionAduaneraTercero informacionAduanera) {
		this.informacionAduanera = informacionAduanera;
	}

	@XmlElement(name = "Parte")
	public List<ParteTercero> getParte() {
		return parte;
	}

	public void setParte(List<ParteTercero> parte) {
		this.parte = parte;
	}

	@XmlElement(name = "CuentaPredial")
	public CuentaPredial getCuentaPredial() {
		return cuentaPredial;
	}

	public void setCuentaPredial(CuentaPredial cuentaPredial) {
		this.cuentaPredial = cuentaPredial;
	}
	
	@XmlElement(name = "Impuestos")
	public ImpuestosTercero getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(ImpuestosTercero impuestos) {
		this.impuestos = impuestos;
	}
	
	
}
