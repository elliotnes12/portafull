package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OtrosPagos {
	private List<OtroPago> otroPago;

	public OtrosPagos() {
		otroPago = new ArrayList<OtroPago>();
	}
	
	@XmlElement(name = "OtroPago")
	public List<OtroPago> getOtroPago() {
		return otroPago;
	}

	public void setOtroPago(List<OtroPago> otroPago) {
		this.otroPago = otroPago;
	}
	
	
	
	
}
