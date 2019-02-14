package mx.xpd.cfdi.marshaller;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;

@XmlType(propOrder={
        "retenciones",
        "traslados"
})
public class Impuestos {

    private String totalImpuestosRetenidos;
    private String totalImpuestosTrasladados;

    private Traslados traslados;
    private Retenciones retenciones;


    public Impuestos() {
    	traslados = new Traslados();
    	retenciones = new Retenciones();
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "TotalImpuestosRetenidos")
    public String getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    @XmlAttribute(name = "TotalImpuestosTrasladados")
    public String getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }



    ///////////// SETTERS ATRIBUTOS
    public void setTotalImpuestosRetenidos(String totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }

    public void setTotalImpuestosTrasladados(String totalImpuestosTrasladados) {
        this.totalImpuestosTrasladados = totalImpuestosTrasladados;
    }



    ///////////// GETTERS NODOS
    @XmlElement(name = "Traslados")
    public Traslados getTraslados() {
        return traslados;
    }

    @XmlElement(name = "Retenciones")
    public Retenciones getRetenciones() {
        return retenciones;
    }



    ///////////// SETTERS NODOS
    public void setTraslados(Traslados traslados) {
        this.traslados = traslados;
    }

    public void setRetenciones(Retenciones retenciones) {
        this.retenciones = retenciones;
    }


}
