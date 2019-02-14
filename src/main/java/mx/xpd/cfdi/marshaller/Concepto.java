package mx.xpd.cfdi.marshaller;


import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

@XmlType(propOrder={
        "impuestos",
        "informacionAduanera",
        "cuentaPredial",
        "parte"
})
public class Concepto {

    private String claveProdServ;
    private String noIdentificacion;
    private String cantidad;
    private String claveUnidad;
    private String unidad;
    private String descripcion;
    private String valorUnitario;
    private String importe;
    private String descuento;

    private List<InformacionAduanera> informacionAduanera;

    private ImpuestosConcepto impuestos;
    private CuentaPredial cuentaPredial;
    private List<Parte> parte;


    public Concepto() {
//    	informacionAduanera = new ArrayList<InformacionAduanera>();
//    	impuestos = new ImpuestosConcepto();
//    	cuentaPredial = new CuentaPredial();
//    	parte = new ArrayList<Parte>();
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "ClaveProdServ")
    public String getClaveProdServ() {
        if (claveProdServ.isEmpty() || claveProdServ == null)
            return null;
        return claveProdServ;
    }

    @XmlAttribute(name = "NoIdentificacion")
    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    @XmlAttribute(name = "Cantidad")
    public String getCantidad() {
        return cantidad;
    }

    @XmlAttribute(name = "ClaveUnidad")
    public String getClaveUnidad() {
        return claveUnidad;
    }

    @XmlAttribute(name = "Unidad")
    public String getUnidad() {
        return unidad;
    }

    @XmlAttribute(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    @XmlAttribute(name = "ValorUnitario")
    public String getValorUnitario() {
        return valorUnitario;
    }

    @XmlAttribute(name = "Importe")
    public String getImporte() {
        return importe;
    }

    @XmlAttribute(name = "Descuento")
    public String getDescuento() {
        return descuento;
    }



    ///////////// SETTERS ATRIBUTOS
    public void setClaveProdServ(String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }



    ///////////// GETTERS NODOS
    @XmlElement(name = "Impuestos")
    public ImpuestosConcepto getImpuestos() {
        return impuestos;
    }

    @XmlElement(name = "CuentaPredial")
    public CuentaPredial getCuentaPredial() {
        return cuentaPredial;
    }



    ///////////// SETTERS NODOS
    public void setImpuestos(ImpuestosConcepto impuestosConcepto) {
        this.impuestos = impuestosConcepto;
    }

    public void setCuentaPredial(CuentaPredial cuentaPredial) {
        this.cuentaPredial = cuentaPredial;
    }



    ///////////// GETTERS NODOS ITERATIVOS
    @XmlElement(name = "InformacionAduanera")
    public List<InformacionAduanera> getInformacionAduanera() {
        return informacionAduanera;
    }
    
    @XmlElement(name = "Parte")
    public List<Parte> getParte() {
        return parte;
    }



    ///////////// SETTERS NODOS ITERATIVOS
    public void setInformacionAduanera(List<InformacionAduanera> informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }
    
    public void setParte(List<Parte> parte) {
        this.parte = parte;
    }


}