package mx.xpd.cfdi.domain.prefactura;

import java.io.Serializable;
import java.util.List;

public class Concepto implements Serializable {

	private static final long serialVersionUID = 4174924570529428380L;
	private String cantidad;
	private String claveProdServ;
	private String claveUnidad;
	private String descripcion;
	private String descuento;
	private String ieps;
	private String importe;
	private String iva;
	private String ivaRetenido;
	private String unidad;
	private String valorUnitario;
	private String noIdentificacion;
	private CuentaPredial cuentaPredial;
	private List<Parte> partes;
	private List<InformacionAduanera> informacionAduanera;

	private Impuestos impuestos;

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getClaveProdServ() {
		return claveProdServ;
	}

	public void setClaveProdServ(String claveProdServ) {
		this.claveProdServ = claveProdServ;
	}

	public String getClaveUnidad() {
		return claveUnidad;
	}

	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getIeps() {
		return ieps;
	}

	public void setIeps(String ieps) {
		this.ieps = ieps;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Impuestos getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Impuestos impuestos) {
		this.impuestos = impuestos;
	}

	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}

	public String getNoIdentificacion() {
		return noIdentificacion;
	}

	public void setNoIdentificacion(String noIdentificacion) {
		this.noIdentificacion = noIdentificacion;
	}

	public String getIvaRetenido() {
		return ivaRetenido;
	}

	public void setIvaRetenido(String ivaRetenido) {
		this.ivaRetenido = ivaRetenido;
	}

	public List<InformacionAduanera> getInformacionAduanera() {
		return informacionAduanera;
	}

	public void setInformacionAduanera(List<InformacionAduanera> informacionAduanera) {
		this.informacionAduanera = informacionAduanera;
	}

	public CuentaPredial getCuentaPredial() {
		return cuentaPredial;
	}

	public void setCuentaPredial(CuentaPredial cuentaPredial) {
		this.cuentaPredial = cuentaPredial;
	}

	
}
