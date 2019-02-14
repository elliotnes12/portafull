package mx.xpd.cfdi.marshaller;
import javax.xml.bind.annotation.XmlAttribute;

public class CuentaPredial {

    private String numero;


    public CuentaPredial() {
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "Numero")
    public String getNumero() {
        return numero;
    }
    
    ///////////// SETTERS ATRIBUTOS
    public void setNumero(String numero) {
        this.numero = numero;
    }


}
