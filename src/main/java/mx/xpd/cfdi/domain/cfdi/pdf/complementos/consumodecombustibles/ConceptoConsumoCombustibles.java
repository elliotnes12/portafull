package mx.xpd.cfdi.domain.cfdi.pdf.complementos.consumodecombustibles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "ConceptoConsumoCombustibles")
public class ConceptoConsumoCombustibles {

	private String identificador;
	private String fechaExpOper;
	private String rfcEnajCombustible;
	private String claveEstacion;
	private String tipoCombustibleCC11;
	private String volumen;
	private String nombreCombustible;
	private String folioOperacion;
	private String precioUnitario;
	private String importeCombustible;
	private Determinados determinados;
	
	public ConceptoConsumoCombustibles() {
		
	}

	@XmlAttribute(name = "identificador")
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@XmlAttribute(name = "fecha")
	public String getFechaExpOper() {
		return fechaExpOper;
	}

	public void setFechaExpOper(String fechaExpOper) {
		this.fechaExpOper = fechaExpOper;
	}

	@XmlAttribute(name = "rfc")
	public String getRfcEnajCombustible() {
		return rfcEnajCombustible;
	}

	public void setRfcEnajCombustible(String rfcEnajCombustible) {
		this.rfcEnajCombustible = rfcEnajCombustible;
	}

	@XmlAttribute(name = "claveEstacion")
	public String getClaveEstacion() {
		return claveEstacion;
	}

	public void setClaveEstacion(String claveEstacion) {
		this.claveEstacion = claveEstacion;
	}
	
	@XmlAttribute(name = "tipoCombustible")
	public String getTipoCombustibleCC11() {
		return tipoCombustibleCC11;
	}

	public void setTipoCombustibleCC11(String tipoCombustibleCC11) {
		this.tipoCombustibleCC11 = tipoCombustibleCC11;
	}
	
	@XmlAttribute(name = "cantidad")
	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	@XmlAttribute(name = "nombreCombustible")
	public String getNombreCombustible() {
		return nombreCombustible;
	}

	public void setNombreCombustible(String nombreCombustible) {
		this.nombreCombustible = nombreCombustible;
	}

	@XmlAttribute(name = "folioOperacion")
	public String getFolioOperacion() {
		return folioOperacion;
	}

	public void setFolioOperacion(String folioOperacion) {
		this.folioOperacion = folioOperacion;
	}

	@XmlAttribute(name = "valorUnitario")
	public String getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@XmlAttribute(name = "importe")
	public String getImporteCombustible() {
		return importeCombustible;
	}

	public void setImporteCombustible(String importeCombustible) {
		this.importeCombustible = importeCombustible;
	}

	@XmlElement(name = "Determinados")
	public Determinados getDeterminados() {
		return determinados;
	}

	public void setDeterminados(Determinados determinados) {
		this.determinados = determinados;
	}
	
	
	
}
