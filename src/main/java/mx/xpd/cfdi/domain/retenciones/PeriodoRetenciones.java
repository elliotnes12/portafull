package mx.xpd.cfdi.domain.retenciones;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PeriodoRetenciones {
	
	private String mesIni;
	private String mesFin;
	private String ejerc;
			
	public PeriodoRetenciones() {
		
	}
	
	@XmlAttribute(name="MesIni")
	public String getMesIni() {
		return mesIni;
	}

	public void setMesIni(String mesIni) {
		mesIni = mesIni;
	}
		
	@XmlAttribute(name="MesFin")
	public String getMesFin() {
		return mesFin;
	}

	public void setMesFin(String mesFin) {
		this.mesFin = mesFin;
	}
	
	@XmlAttribute(name="Ejerc")
	public String getEjerc() {
		return ejerc;
	}

	public void setEjerc(String ejerc) {
		this.ejerc = ejerc;
	}
	
	
		
	
	@Override
	public String toString() {
		return "PeriodoRetenciones [mesIni=" + mesIni + ", mesFin=" + mesFin + ", ejerc=" + ejerc +"]";
	}
	
}