package mx.xpd.cfdi.marshaller;

import javax.xml.bind.annotation.XmlAttribute;

public class Receptor {

    private String rfc;
    private String nombre;
    private String residenciaFiscal;
    private String numRegIdTrib;
    private String usoCFDI;


    public Receptor() {
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

    @XmlAttribute(name = "ResidenciaFiscal")
    public String getResidenciaFiscal() {
        return residenciaFiscal;
    }

    @XmlAttribute(name = "NumRegIdTrib")
    public String getNumRegIdTrib() {
        return numRegIdTrib;
    }

    @XmlAttribute(name = "UsoCFDI")
    public String getUsoCFDI() {
        return usoCFDI;
    }



    ///////////// SETTERS ATRIBUTOS
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResidenciaFiscal(String residenciaFiscal) {
        this.residenciaFiscal = residenciaFiscal;
    }

    public void setNumRegIdTrib(String numRegIdTrib) {
        this.numRegIdTrib = numRegIdTrib;
    }

    public void setUsoCFDI(String usoCFDI) {
        this.usoCFDI = usoCFDI;
    }


}