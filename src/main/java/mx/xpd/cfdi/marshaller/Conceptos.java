package mx.xpd.cfdi.marshaller;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElement;

@XmlType(propOrder={
        "concepto"
})
public class Conceptos {


    private List<Concepto> concepto;


    public Conceptos() {
        concepto = new ArrayList<Concepto>();
    }

    public Conceptos(String []data) {
    }

    ///////////// GETTERS NODOS ITERATIVOS
    @XmlElement(name = "Concepto")
    public List<Concepto> getConcepto() {
        return concepto;
    }



    ///////////// SETTERS NODOS ITERATIVOS
    public void setConcepto(List<Concepto> concepto) {
        this.concepto = concepto;
    }


}