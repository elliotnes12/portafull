package mx.xpd.cfdi.domain.cfdi.pdf.complementos.arteantiguedades;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "ObrasArteAntiguedades")
public class ObrasArteAntiguedades {

	private String version = "1.0";
	private String tipoBien;
	private String otrosTipoBien;
	private String tituloAdquirido;
	private String otrosTituloAdquirido;
	private String subtotal;
	private String iva;
	private String fechaAdquisicion;
	private String característicasDeObraoPieza;
		
	public ObrasArteAntiguedades() {
		
	}

	@XmlAttribute(name = "Version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "TipoBien")
	public String getTipoBien() {
		return tipoBien;
	}

	public void setTipoBien(String tipoBien) {
		this.tipoBien = tipoBien;
	}	
	
	@XmlAttribute(name = "OtrosTipoBien")
	public String getOtrosTipoBien() {
		return otrosTipoBien;
	}

	public void setOtrosTipoBien(String otrosTipoBien) {
		this.otrosTipoBien = otrosTipoBien;
	}	
		
	@XmlAttribute(name = "TituloAdquirido")
	public String getTituloAdquirido() {
		return tituloAdquirido;
	}

	public void setTituloAdquirido(String tituloAdquirido) {
		this.tituloAdquirido = tituloAdquirido;
	}	
	
	@XmlAttribute(name = "OtrosTituloAdquirido")
	public String getOtrosTituloAdquirido() {
		return otrosTituloAdquirido;
	}

	public void setOtrosTituloAdquirido(String otrosTituloAdquirido) {
		this.otrosTituloAdquirido = otrosTituloAdquirido;
	}	
	
	@XmlAttribute(name = "Subtotal")
	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	
	@XmlAttribute(name = "IVA")
	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}
	
	@XmlAttribute(name = "FechaAdquisicion")
	public String getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(String fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	
	@XmlAttribute(name = "CaracterísticasDeObraoPieza")
	public String getCaracterísticasDeObraoPieza() {
		return característicasDeObraoPieza;
	}

	public void setCaracterísticasDeObraoPieza(String característicasDeObraoPieza) {
		this.característicasDeObraoPieza = característicasDeObraoPieza;
	}
			
}