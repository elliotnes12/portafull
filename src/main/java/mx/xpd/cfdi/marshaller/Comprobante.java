package mx.xpd.cfdi.marshaller;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlRootElement(name="Comprobante")
@XmlType(propOrder={
        "cfdiRelacionados",
        "emisor",
        "receptor",
        "conceptos",
        "impuestos",
        "complemento"
})
public class Comprobante {

    private String version;
    private String serie;
    private String folio;
    private String fecha;
    private String sello;
    private String formaPago;
    private String noCertificado;
    private String certificado;
    private String condicionesDePago;
    private String subTotal;
    private String descuento;
    private String moneda;
    private String tipoCambio;
    private String total;
    private String tipoDeComprobante;
    private String metodoPago;
    private String lugarExpedicion;
    private String confirmacion;

    private CfdiRelacionados cfdiRelacionados;
    private Emisor emisor;
    private Receptor receptor;
    private Conceptos conceptos;
    private Impuestos impuestos;
    private Complemento complemento;

    public Comprobante() {
//    	cfdiRelacionados = new CfdiRelacionados();
//    	emisor = new Emisor();
//    	receptor =  new Receptor();
//    	conceptos = new Conceptos();
//    	impuestos = new Impuestos();
//    	complemento = new Complemento();
//    	addenda = new Addenda();
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "Version")
    public String getVersion() {
        return version;
    }

    @XmlAttribute(name = "Serie")
    public String getSerie() {
        return serie;
    }

    @XmlAttribute(name = "Folio")
    public String getFolio() {
        return folio;
    }

    @XmlAttribute(name = "Fecha")
    public String getFecha() {
        return fecha;
    }

    @XmlAttribute(name = "Sello")
    public String getSello() {
        return sello;
    }

    @XmlAttribute(name = "FormaPago")
    public String getFormaPago() {
        return formaPago;
    }

    @XmlAttribute(name = "NoCertificado")
    public String getNoCertificado() {
        return noCertificado;
    }

    @XmlAttribute(name = "Certificado")
    public String getCertificado() {
        return certificado;
    }

    @XmlAttribute(name = "CondicionesDePago")
    public String getCondicionesDePago() {
        return condicionesDePago;
    }

    @XmlAttribute(name = "SubTotal")
    public String getSubTotal() {
        return subTotal;
    }

    @XmlAttribute(name = "Descuento")
    public String getDescuento() {
        return descuento;
    }

    @XmlAttribute(name = "Moneda")
    public String getMoneda() {
        return moneda;
    }

    @XmlAttribute(name = "TipoCambio")
    public String getTipoCambio() {
        return tipoCambio;
    }

    @XmlAttribute(name = "Total")
    public String getTotal() {
        return total;
    }

    @XmlAttribute(name = "TipoDeComprobante")
    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    @XmlAttribute(name = "MetodoPago")
    public String getMetodoPago() {
        return metodoPago;
    }

    @XmlAttribute(name = "LugarExpedicion")
    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    @XmlAttribute(name = "Confirmacion")
    public String getConfirmacion() {
        return confirmacion;
    }

    ///////////// SETTERS ATRIBUTOS
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

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public void setCondicionesDePago(String condicionesDePago) {
        this.condicionesDePago = condicionesDePago;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }



    ///////////// GETTERS NODOS
    @XmlElement(name = "CfdiRelacionados")
    public CfdiRelacionados getCfdiRelacionados() {
        return cfdiRelacionados;
    }

    @XmlElement(name = "Emisor")
    public Emisor getEmisor() {
        return emisor;
    }

    @XmlElement(name = "Receptor")
    public Receptor getReceptor() {
        return receptor;
    }

    @XmlElement(name = "Conceptos")
    public Conceptos getConceptos() {
        return conceptos;
    }

    @XmlElement(name = "Impuestos")
    public Impuestos getImpuestos() {
        return impuestos;
    }

    @XmlElement(name = "Complemento")
    public Complemento getComplemento() {
        return complemento;
    }
    ///////////// SETTERS NODOS
    public void setCfdiRelacionados(CfdiRelacionados cfdiRelacionados) {
        this.cfdiRelacionados = cfdiRelacionados;
    }

    public void setEmisor(Emisor emisor) {
        this.emisor = emisor;
    }

    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }

    public void setConceptos(Conceptos conceptos) {
        this.conceptos = conceptos;
    }

    public void setImpuestos(Impuestos impuestos) {
        this.impuestos = impuestos;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }


}