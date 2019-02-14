package mx.xpd.cfdi.domain.retenciones;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ReceptorExtranjeroRetenciones {
	
	private String numRegIdTrib;
	private String nomDenRazSocREx;
		
		
	public ReceptorExtranjeroRetenciones() {
		
	}
	
	@XmlAttribute(name = "NumRegIdTrib")
	public String getNumRegIdTrib() {
		return numRegIdTrib;
	}

	public void setNumRegIdTrib(String numRegIdTrib) {
		this.numRegIdTrib = numRegIdTrib;
	}
	
	@XmlAttribute(name = "NomDenRazSocR")
	public String getNomDenRazSocREx() {
		return nomDenRazSocREx;
	}

	public void setNomDenRazSocREx(String nomDenRazSocREx) {
		this.nomDenRazSocREx = nomDenRazSocREx;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ReceptorExtranjeroRetenciones [numRegIdTrib=" + numRegIdTrib + ",nomDenRazSocREx=" + nomDenRazSocREx +"]";
	}
	
}