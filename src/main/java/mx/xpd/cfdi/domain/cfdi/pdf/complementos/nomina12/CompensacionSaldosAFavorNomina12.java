package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class CompensacionSaldosAFavorNomina12 {

	private String saldoAFavor;
	private String anioCompensacionSaldosAFavor;
	private String remanenteSalFav;
	
	public CompensacionSaldosAFavorNomina12() {
		
	}
			
	@XmlAttribute(name = "SaldoAFavor")
	public String getSaldoAFavor() {
		return saldoAFavor;
	}

	public void setSaldoAFavor(String saldoAFavor) {
		this.saldoAFavor = saldoAFavor;
	}
	
	@XmlAttribute(name = "Año")
	public String getAnioCompensacionSaldosAFavor() {
		return anioCompensacionSaldosAFavor;
	}

	public void setAnioCompensacionSaldosAFavor(String anioCompensacionSaldosAFavor) {
		this.anioCompensacionSaldosAFavor = anioCompensacionSaldosAFavor;
	}
	
	@XmlAttribute(name = "RemanenteSalFav")
	public String getRemanenteSalFav() {
		return remanenteSalFav;
	}

	public void setRemanenteSalFav(String remanenteSalFav) {
		this.remanenteSalFav = remanenteSalFav;
	}
	
	
}

