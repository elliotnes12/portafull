package mx.xpd.cfdi.marshaller;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlType(propOrder={
        "retencion"
})
public class Retenciones {


    private List<Retencion> retencion;


    public Retenciones() {
        retencion = new ArrayList<Retencion>();
    }

    public Retenciones(String []data) {
    }

    ///////////// GETTERS NODOS ITERATIVOS
    @XmlElement(name = "Retencion")
    public List<Retencion> getRetencion() {
        return retencion;
    }



    ///////////// SETTERS NODOS ITERATIVOS
    public void setRetencion(List<Retencion> retencion) {
        this.retencion = retencion;
    }


}