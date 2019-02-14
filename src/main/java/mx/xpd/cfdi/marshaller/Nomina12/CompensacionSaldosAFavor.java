package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;

public class CompensacionSaldosAFavor {
	
	private String saldoAFavor;
	private String anio;
	private String remanenteSalFav;
	
	public CompensacionSaldosAFavor() {
		
	}
	
	public CompensacionSaldosAFavor(String []data) {
		
		saldoAFavor = data[1].equals(" ") ? null : (data[1]);
		anio = data[2].equals(" ") ? null : (data[2]);
		remanenteSalFav = data[3].equals(" ") ? null : (data[3]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "SaldoAFavor")
	public String getSaldoAFavor() {
		if(saldoAFavor==null){return null;}
		return saldoAFavor.trim().equals("") ? null : saldoAFavor.trim();
	}

	@XmlAttribute(name = "Año")
	public String getAnio() {
		if(anio==null){return null;}
		return anio.trim().equals("") ? null : anio.trim();
	}

	@XmlAttribute(name = "RemanenteSalFav")
	public String getRemanenteSalFav() {
		if(remanenteSalFav==null){return null;}
		return remanenteSalFav.trim().equals("") ? null : remanenteSalFav.trim();
	}

	
	///////////// SETTERS ATRIBUTOS
	public void setSaldoAFavor(String saldoAFavor) {
		this.saldoAFavor = saldoAFavor;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public void setRemanenteSalFav(String remanenteSalFav) {
		this.remanenteSalFav = remanenteSalFav;
	}

}
