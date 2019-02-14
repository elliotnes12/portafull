package mx.xpd.cfdi.marshaller;

import javax.xml.bind.annotation.XmlAttribute;

public class CfdiRelacionado {

    private String uuid;


    public CfdiRelacionado() {
    }
    

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "UUID")
    public String getUuid() {
        return uuid;
    }



    ///////////// SETTERS ATRIBUTOS
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
