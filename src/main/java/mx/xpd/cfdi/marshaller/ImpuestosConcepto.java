package mx.xpd.cfdi.marshaller;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlType(propOrder={
        "traslados",
        "retenciones"
})
public class ImpuestosConcepto {

    private Traslados traslados;
    private Retenciones retenciones;


    public ImpuestosConcepto() {
    	traslados = new Traslados();
    	retenciones = new Retenciones();
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
