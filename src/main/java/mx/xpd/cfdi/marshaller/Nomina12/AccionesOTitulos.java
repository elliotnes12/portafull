package mx.xpd.cfdi.marshaller.Nomina12;

import javax.xml.bind.annotation.XmlAttribute;

public class AccionesOTitulos {
	
	private Double valorMercado;
	private Double precioAlOtorgarse;
	
	public AccionesOTitulos() {
		
	}
	
	public AccionesOTitulos(String []data) {
		
		valorMercado = Double.parseDouble(data[1]);
		precioAlOtorgarse = Double.parseDouble(data[2]);
		
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "ValorMercado")
	public Double getValorMercado() {
		if(valorMercado==null){return null;}
		return valorMercado;
	}

	@XmlAttribute(name = "PrecioAlOtorgarse")
	public Double getPrecioAlOtorgarse() {
		if(precioAlOtorgarse==null){return null;}
		return precioAlOtorgarse;
	}

	///////////// SETTERS ATRIBUTOS
	public void setValorMercado(Double valorMercado) {
		this.valorMercado = valorMercado;
	}

	public void setPrecioAlOtorgarse(Double precioAlOtorgarse) {
		this.precioAlOtorgarse = precioAlOtorgarse;
	}
	
}
