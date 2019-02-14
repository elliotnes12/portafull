package mx.xpd.cfdi.domain.cfdi.complementos.pagos;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DoctoRelacionado")
public class DoctoRelacionado{

	private String idDocumento;
	private String serie;
	private String folio;
	private String monedaDR;
	private String tipoCambioDR;
	private String metodoDePagoDR;
	private String numParcialidad;
	private String impSaldoAnt;
	private String impPagado;
	private String impSaldoInsoluto;
	
	public DoctoRelacionado() {
		
	}
	
	@XmlAttribute(name = "IdDocumento")
	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	@XmlAttribute(name = "Serie")
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@XmlAttribute(name = "Folio")
	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	@XmlAttribute(name = "MonedaDR")
	public String getMonedaDR() {
		return monedaDR;
	}

	public void setMonedaDR(String monedaDR) {
		this.monedaDR = monedaDR;
	}

	@XmlAttribute(name = "TipoCambioDR")
	public String getTipoCambioDR() {
		return tipoCambioDR;
	}

	public void setTipoCambioDR(String tipoCambioDR) {
		this.tipoCambioDR = tipoCambioDR;
	}

	@XmlAttribute(name = "MetodoDePagoDR")
	public String getMetodoDePagoDR() {
		return metodoDePagoDR;
	}

	public void setMetodoDePagoDR(String metodoDePagoDR) {
		this.metodoDePagoDR = metodoDePagoDR;
	}

	@XmlAttribute(name = "NumParcialidad")
	public String getNumParcialidad() {
		return numParcialidad;
	}

	public void setNumParcialidad(String numParcialidad) {
		this.numParcialidad = numParcialidad;
	}

	@XmlAttribute(name = "ImpSaldoAnt")
	public String getImpSaldoAnt() {
		return impSaldoAnt;
	}

	public void setImpSaldoAnt(String impSaldoAnt) {
		this.impSaldoAnt = impSaldoAnt;
	}

	@XmlAttribute(name = "ImpPagado")
	public String getImpPagado() {
		return impPagado;
	}

	public void setImpPagado(String impPagado) {
		this.impPagado = impPagado;
	}

	@XmlAttribute(name = "ImpSaldoInsoluto")
	public String getImpSaldoInsoluto() {
		return impSaldoInsoluto;
	}

	public void setImpSaldoInsoluto(String impSaldoInsoluto) {
		this.impSaldoInsoluto = impSaldoInsoluto;
	}

		
}