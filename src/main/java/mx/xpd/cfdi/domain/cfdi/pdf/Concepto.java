package mx.xpd.cfdi.domain.cfdi.pdf;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.pdf.Parte;
import mx.xpd.cfdi.domain.cfdi.pdf.ImpuestosConcepto;
import mx.xpd.cfdi.domain.cfdi.complementos.concepto.CuentaPredial;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.ComplementoConcepto;

@XmlRootElement(name="Concepto")
@XmlType(propOrder={
		"impuestos",
		"informacionAduanera",
		"parte",
		"complementoConcepto",
		"cuentaPredial"
})
public class Concepto {
	private String claveProdServ;
	private String clave;
	private Double cantidad;
	private String claveUnidad;
	private String unidad;
	private String descripcion;
	private Double valorUnitario;
	private Double importe;
	private Double descuento;
	
	private ImpuestosConcepto impuestos;
	private java.util.List<InformacionAduanera> informacionAduanera;
	private List<Parte> parte;
	private ComplementoConcepto complementoConcepto;
	private CuentaPredial cuentaPredial;
	
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
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
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
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@XmlAttribute(name = "Importe")
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	@XmlAttribute(name = "Descuento")
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	
	@XmlElement(name = "Impuestos")
	public ImpuestosConcepto getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(ImpuestosConcepto impuestos) {
		this.impuestos = impuestos;
	}
	
	@XmlElement(name = "InformacionAduanera")
	public java.util.List<InformacionAduanera> getInformacionAduanera() {
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
	
	
	@XmlElement(name = "ComplementoConcepto")
	public ComplementoConcepto getComplementoConcepto() {
		if ((complementoConcepto.getInstEducativas() == null)&&(complementoConcepto.getVentaVehiculos() == null) && (complementoConcepto.getCuentaTerceros() == null)) {
			return null;
		}
		return complementoConcepto;
	}
	public void setComplementoConcepto(ComplementoConcepto complementoConcepto) {
		this.complementoConcepto = complementoConcepto;
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
		return "Concepto [cantidad=" + cantidad + ", unidad=" + unidad
				+ ", noIdentificacion=" + clave + ", descripcion="
				+ descripcion + ", valorUnitario=" + valorUnitario
				+ ", importe=" + importe + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
