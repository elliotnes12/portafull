package mx.xpd.cfdi.marshaller;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlType(propOrder={
        "traslado"
})
public class Traslados {


    private List<Traslado> traslado;


    public Traslados() {
        traslado = new ArrayList<Traslado>();
    }

    ///////////// GETTERS NODOS ITERATIVOS
    @XmlElement(name = "Traslado")
    public List<Traslado> getTraslado() {
        return traslado;
    }



    ///////////// SETTERS NODOS ITERATIVOS
    public void setTraslado(List<Traslado> traslado) {
        this.traslado = traslado;
    }


}
