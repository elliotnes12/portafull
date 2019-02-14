/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.xpd.cfdi.marshaller.timbreFiscal;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TimbreFiscalDigital")

public class TimbreFiscalDigital  {
    
    private String NoCertificadoSAT;
    private String UUID;
    private String FechaTimbrado;
    private String RfcProvCertif;
    private String Version; 
    private String SelloSat;
    private String SelloCFD;
    private String Leyenda;
    
    public TimbreFiscalDigital()
    {
    
    }
    @XmlAttribute(name = "Leyenda") 
    public String getLeyenda() {
        return Leyenda;
    }

    public void setLeyenda(String Leyenda) {
        this.Leyenda = Leyenda;
    }
    @XmlAttribute(name = "SelloCFD") 
    public String getSelloCFD() {
        return SelloCFD;
    }

    public void setSelloCFD(String SelloCFD) {
        this.SelloCFD = SelloCFD;
    }
    @XmlAttribute(name = "NoCertificadoSAT") 
    public String getNoCertificadoSAT() {
        return NoCertificadoSAT;
    }

    public void setNoCertificadoSAT(String NoCertificadoSAT) {
        this.NoCertificadoSAT = NoCertificadoSAT;
    }
    @XmlAttribute(name = "RfcProvCertif") 
    public String getRfcProvCertif() {
        return RfcProvCertif;
    }

    public void setRfcProvCertif(String RfcProvCertif) {
        this.RfcProvCertif = RfcProvCertif;
    }
    @XmlAttribute(name = "Version")
    public String getVersion() {
        return Version;
    }

    public void setVersion(String Version) {
        this.Version = Version;
    }
    @XmlAttribute(name = "SelloSAT")
    public String getSelloSat() {
        return SelloSat;
    }

    public void setSelloSat(String SelloSat) {
        this.SelloSat = SelloSat;
    }

    @XmlAttribute(name = "UUID")
    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    @XmlAttribute(name = "FechaTimbrado")
    public String getFechaTimbrado() {
        return FechaTimbrado;
    }

    public void setFechaTimbrado(String FechaTimbrado) {
        this.FechaTimbrado = FechaTimbrado;
    }
    
    
}
