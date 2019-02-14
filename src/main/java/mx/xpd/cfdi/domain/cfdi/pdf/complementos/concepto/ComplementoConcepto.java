package mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto;

import javax.xml.bind.annotation.XmlElement;


import mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.ventavehiculos.VentaVehiculos;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.concepto.terceros.Terceros;


public class ComplementoConcepto {

	private InstitucionesEducativasPrivadas instEducativas;
	private VentaVehiculos ventaVehiculos;
	private Terceros cuentaTerceros;
	
	public ComplementoConcepto() {
		this.instEducativas = new InstitucionesEducativasPrivadas();
		this.ventaVehiculos = new VentaVehiculos();
		this.cuentaTerceros = new Terceros();
	}

	@XmlElement(name = "instEducativas")
	public InstitucionesEducativasPrivadas getInstEducativas() {
		
		if (instEducativas.getCurp() == null || instEducativas.getAutRVOE() == null) {
			return null;
		}
		
		return instEducativas;
	}

	public void setInstEducativas(InstitucionesEducativasPrivadas instEducativas) {
		this.instEducativas = instEducativas;
	}
	
	@XmlElement(name = "VentaVehiculos")
	public VentaVehiculos getVentaVehiculos() {
		
		if (ventaVehiculos.getClaveVehicularVentaVehiculos() == null || ventaVehiculos.getNivVentaVehiculos() == null) {
			return null;
		}
		
		return ventaVehiculos;
	}

	public void setVentaVehiculos(VentaVehiculos ventaVehiculos) {
		this.ventaVehiculos = ventaVehiculos;
	}
	
	@XmlElement(name = "cuentaTerceros")
	public Terceros getCuentaTerceros() {
		if (cuentaTerceros.getRfcCuentaTerceros() == null) {
			return null;
		}
		return cuentaTerceros;
	}

	public void setCuentaTerceros(Terceros cuentaTerceros) {
		this.cuentaTerceros = cuentaTerceros;
	}
	
}
