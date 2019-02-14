package mx.xpd.cfdi.marshaller.Nomina12;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class OtrosPagos {
	
	private List<OtroPago> otroPago;
	
	public OtrosPagos() {
		otroPago = new ArrayList<OtroPago>();
	}

	///////////// GETTERS NODOS
	@XmlElement(name = "OtroPago")
	public List<OtroPago> getOtroPago() {
		return otroPago;
	}

	///////////// SETTERS NODOS
	public void setOtroPago(List<OtroPago> otroPago) {
		this.otroPago = otroPago;
	}

}
