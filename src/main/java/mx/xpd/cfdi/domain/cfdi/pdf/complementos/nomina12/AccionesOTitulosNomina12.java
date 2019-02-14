package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class AccionesOTitulosNomina12 {

	private String valorMercado;
	private String precioAlOtorgarse;
	
	public AccionesOTitulosNomina12() {
		
	}
		
	@XmlAttribute(name = "ValorMercado")
	public String getValorMercado() {
		return valorMercado;
	}

	public void setValorMercado(String valorMercado) {
		this.valorMercado = valorMercado;
	}
	
	@XmlAttribute(name = "PrecioAlOtorgarse")
	public String getPrecioAlOtorgarse() {
		return precioAlOtorgarse;
	}
	
	public void setPrecioAlOtorgarse(String precioAlOtorgarse) {
		this.precioAlOtorgarse = precioAlOtorgarse;
	}

	
}
