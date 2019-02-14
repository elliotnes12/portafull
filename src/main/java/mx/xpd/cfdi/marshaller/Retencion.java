package mx.xpd.cfdi.marshaller;

import javax.xml.bind.annotation.XmlAttribute;

public class Retencion {

    private String base;
    private String impuesto;
    private String tipoFactor;
    private String tasaOCuota;
    private String importe;


    public Retencion() {
    }

    ///////////// GETTERS ATRIBUTOS
    @XmlAttribute(name = "Base")
    public String getBase() {
        return base;
    }

    @XmlAttribute(name = "Impuesto")
    public String getImpuesto() {
        return impuesto;
    }

    @XmlAttribute(name = "TipoFactor")
    public String getTipoFactor() {
        return tipoFactor;
    }

    @XmlAttribute(name = "TasaOCuota")
    public String getTasaOCuota() {
        return tasaOCuota;
    }

    @XmlAttribute(name = "Importe")
    public String getImporte() {
        return importe;
    }



    ///////////// SETTERS ATRIBUTOS
    public void setBase(String base) {
        this.base = base;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public void setTipoFactor(String tipoFactor) {
        this.tipoFactor = tipoFactor;
    }

    public void setTasaOCuota(String tasaOCuota) {
        this.tasaOCuota = tasaOCuota;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }


}
