package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OtrosPagosNomina12 {
	private List<OtroPagoNomina12> otroPago;

	public OtrosPagosNomina12() {
		otroPago = new ArrayList<OtroPagoNomina12>();
	}
	
	@XmlElement(name = "OtroPago")
	public List<OtroPagoNomina12> getOtroPago() {
		return otroPago;
	}

	public void setOtroPago(List<OtroPagoNomina12> otroPago) {
		this.otroPago = otroPago;
	}
	
	
	
	
}
