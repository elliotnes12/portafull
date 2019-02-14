package mx.xpd.cfdi.marshaller;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlType(propOrder={
        "cfdiRelacionado"
})
public class CfdiRelacionados {

    private String tipoRelacion;

    private List<CfdiRelacionado> cfdiRelacionado;


    public CfdiRelacionados() {
        cfdiRelacionado = new ArrayList<CfdiRelacionado>();
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "TipoRelacion")
    public String getTipoRelacion() {
        return tipoRelacion;
    }



    ///////////// SETTERS ATRIBUTOS
    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }



    ///////////// GETTERS NODOS ITERATIVOS
    @XmlElement(name = "CfdiRelacionado")
    public List<CfdiRelacionado> getCfdiRelacionado() {
        return cfdiRelacionado;
    }



    ///////////// SETTERS NODOS ITERATIVOS
    public void setCfdiRelacionado(List<CfdiRelacionado> cfdiRelacionado) {
        this.cfdiRelacionado = cfdiRelacionado;
    }


}