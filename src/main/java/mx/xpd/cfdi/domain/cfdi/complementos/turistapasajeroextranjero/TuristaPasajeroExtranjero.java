package mx.xpd.cfdi.domain.cfdi.complementos.turistapasajeroextranjero;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "TuristaPasajeroExtranjero")
public class TuristaPasajeroExtranjero {

	private String version = "1.0";
	private String fechadeTransito;
	private String tipoTransito;
	private DatosTransito datosTransito;
		
	public TuristaPasajeroExtranjero() {
		
	}

	@XmlAttribute(name = "version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "fechadeTransito")
	public String getFechadeTransito() {
		return fechadeTransito;
	}

	public void setFechadeTransito(String fechadeTransito) {
		this.fechadeTransito = fechadeTransito;
	}
	
	@XmlAttribute(name = "tipoTransito")
	public String getTipoTransito() {
		return tipoTransito;
	}

	public void setTipoTransito(String tipoTransito) {
		this.tipoTransito = tipoTransito;
	}
	
	@XmlElement(name = "datosTransito")
	public DatosTransito getDatosTransito() {
		return datosTransito;
	}

	public void setDatosTransito(DatosTransito datosTransito) {
		this.datosTransito = datosTransito;
	}

	



		
			
}