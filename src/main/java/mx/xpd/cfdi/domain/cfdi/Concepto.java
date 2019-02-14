package mx.xpd.cfdi.domain.cfdi;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.complementos.concepto.ComplementoConcepto;
import mx.xpd.cfdi.domain.cfdi.complementos.concepto.CuentaPredial;
@XmlType(propOrder={
		"impuestos",
		"informacionAduanera",
		"cuentaPredial",
		"complementoConcepto",
		"parte"
})

public class Concepto {
	private String claveProdServ;
	private String clave;
	private String cantidad;
	private String claveUnidad;
	private String unidad;
	private String descripcion;
	private String valorUnitario;
	private String importe;
	private String descuento;
	
	private ImpuestosConcepto impuestos;
	private List<InformacionAduanera> informacionAduanera;
	private List<Parte> parte;
	private ComplementoConcepto complementoConcepto;
	private CuentaPredial cuentaPredial;
	
	@XmlElement(name = "Impuestos")
	public ImpuestosConcepto getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(ImpuestosConcepto impuestos) {
		this.impuestos = impuestos;
	}
	
	@XmlElement(name = "InformacionAduanera")
	public List<InformacionAduanera> getInformacionAduanera() {
		return informacionAduanera;
	}
	
	public void setInformacionAduanera(List<InformacionAduanera> informacionAduanera) {
		this.informacionAduanera = informacionAduanera;
	}
	
	@XmlElement(name = "Parte")
	public List<Parte> getParte() {
		return parte;
	}
	
	public void setParte(List<Parte> parte) {
		this.parte = parte;
	}
	
	
	@XmlElement(name = "CuentaPredial")
	public CuentaPredial getCuentaPredial() {
		return cuentaPredial;
	}

	public void setCuentaPredial(CuentaPredial cuentaPredial) {
		this.cuentaPredial = cuentaPredial;
	}

	public Concepto() {
		this.complementoConcepto = new ComplementoConcepto();
	}
	
	@Override
	public String toString() {
		return "Concepto [claveProdServ=" + claveProdServ + " cantidad=" + cantidad + ", unidad=" + unidad
				+ ", noIdentificacion=" + clave + ", descripcion="
				+ descripcion + ", valorUnitario=" + valorUnitario
				+ ", importe=" + importe + "]";
	}
	@XmlElement(name = "ComplementoConcepto")
	public ComplementoConcepto getComplementoConcepto() {
		if ((complementoConcepto.getInstEducativas() == null) && (complementoConcepto.getVentaVehiculos() == null) && (complementoConcepto.getCuentaTerceros() == null)) {
			return null;
		}
		return complementoConcepto;
	}
	@XmlAttribute(name = "ClaveProdServ")
	public String getClaveProdServ() {
		return claveProdServ;
	}
	public void setClaveProdServ(String claveProdServ) {
		this.claveProdServ = claveProdServ;
	}
	
	@XmlAttribute(name = "NoIdentificacion")
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	@XmlAttribute(name = "Cantidad")
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	@XmlAttribute(name = "ClaveUnidad")
	public String getClaveUnidad() {
		return claveUnidad;
	}
	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
	}
	
	@XmlAttribute(name = "Unidad")
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	
	@XmlAttribute(name = "Descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@XmlAttribute(name = "ValorUnitario")
	public String getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@XmlAttribute(name = "Importe")
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	
	@XmlAttribute(name = "Descuento")
	public String getDescuento() {
		return descuento;
	}
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	
	/**********************/
	public void getComplementoConcepto(ComplementoConcepto complementoConcepto) {
		this.complementoConcepto = complementoConcepto;
	}
	
	
	
	
	
	
	
	
	
	
}
