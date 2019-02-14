package mx.xpd.cfdi.marshaller;
import javax.xml.bind.annotation.XmlAttribute;

public class InformacionAduanera {

    private String numeroPedimento;


    public InformacionAduanera() {
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "NumeroPedimento")
    public String getNumeroPedimento() {
        return numeroPedimento;
    }



    ///////////// SETTERS ATRIBUTOS
    public void setNumeroPedimento(String numeroPedimento) {
        this.numeroPedimento = numeroPedimento;
    }


}