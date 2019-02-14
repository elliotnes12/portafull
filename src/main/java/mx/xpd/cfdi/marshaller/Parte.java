package mx.xpd.cfdi.marshaller;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlType(propOrder={
        "informacionAduanera"
})
public class Parte {

    private String claveProdServ;
    private String noIdentificacion;
    private String cantidad;
    private String unidad;
    private String descripcion;
    private String valorUnitario;
    private String importe;

    private List<InformacionAduanera> informacionAduanera;


    public Parte() {
    	informacionAduanera = new ArrayList<InformacionAduanera>();
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "ClaveProdServ")
    public String getClaveProdServ() {
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



    ///////////// GETTERS NODOS ITERATIVOS
    @XmlElement(name = "InformacionAduanera")
    public List<InformacionAduanera> getInformacionAduanera() {
        return informacionAduanera;
    }



    ///////////// SETTERS NODOS ITERATIVOS
    public void setInformacionAduanera(List<InformacionAduanera> informacionAduanera) {
        this.informacionAduanera = informacionAduanera;
    }


}