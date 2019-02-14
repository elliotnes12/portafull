package mx.xpd.cfdi.marshaller;

import javax.xml.bind.annotation.XmlAttribute;

public class Emisor {

    private String rfc;
    private String nombre;
    private String regimenFiscal;


    public Emisor() {
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "Rfc")
    public String getRfc() {
        return rfc;
    }

    @XmlAttribute(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    @XmlAttribute(name = "RegimenFiscal")
    public String getRegimenFiscal() {
        return regimenFiscal;
    }



    ///////////// SETTERS ATRIBUTOS
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }


}