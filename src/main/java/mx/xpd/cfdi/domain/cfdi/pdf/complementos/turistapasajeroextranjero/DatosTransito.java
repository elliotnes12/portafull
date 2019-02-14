package mx.xpd.cfdi.domain.cfdi.pdf.complementos.turistapasajeroextranjero;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "datosTransito")
public class DatosTransito{

	private String via;
	private String tipoIdTurista;
	private String numeroIdTurista;
	private String nacionalidadTurista;
	private String empresaTransporte;
	private String idTransporteTurista;
	
	
	public DatosTransito() {
		
	}
	
	@XmlAttribute(name = "Via")
	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}
	
	@XmlAttribute(name = "TipoId")
	public String getTipoIdTurista() {
		return tipoIdTurista;
	}

	public void setTipoIdTurista(String tipoIdTurista) {
		this.tipoIdTurista = tipoIdTurista;
	}
	
	@XmlAttribute(name = "NumeroId")
	public String getNumeroIdTurista() {
		return numeroIdTurista;
	}

	public void setNumeroIdTurista(String numeroIdTurista) {
		this.numeroIdTurista = numeroIdTurista;
	}
	
	@XmlAttribute(name = "Nacionalidad")
	public String getNacionalidadTurista() {
		return nacionalidadTurista;
	}

	public void setNacionalidadTurista(String nacionalidadTurista) {
		this.nacionalidadTurista = nacionalidadTurista;
	}
	
	@XmlAttribute(name = "EmpresaTransporte")
	public String getEmpresaTransporte() {
		return empresaTransporte;
	}

	public void setEmpresaTransporte(String empresaTransporte) {
		this.empresaTransporte = empresaTransporte;
	}
	
	@XmlAttribute(name = "IdTransporte")
	public String getIdTransporteTurista() {
		return idTransporteTurista;
	}

	public void setIdTransporteTurista(String idTransporteTurista) {
		this.idTransporteTurista = idTransporteTurista;
	}

	

		
}