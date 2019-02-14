package mx.xpd.cfdi.domain.cfdi.pdf.complementos.parcialesconstruccion;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.xpd.cfdi.domain.cfdi.complementos.vehiculousado.InformacionAduanera;




@XmlRootElement(name = "ParcialesConstruccion")
public class ParcialesConstruccion {

	private String version = "1.0";
	private String numPerLicoAut;
	private Inmueble inmueble;
	
	
	

	public ParcialesConstruccion() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "NumPerLicoAut")
	public String getNumPerLicoAut() {
		return numPerLicoAut;
	}

	public void setNumPerLicoAut(String numPerLicoAut) {
		this.numPerLicoAut = numPerLicoAut;
	}
	
	@XmlElement(name = "Inmueble")
	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	



		
			
}
