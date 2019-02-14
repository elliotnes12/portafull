package mx.xpd.cfdi.domain.cfdi.pdf.complementos.aerolineas;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "OtrosCargos")
public class OtrosCargos{

	private String totalCargos;
	private List<Cargo> cargo;
	
	public OtrosCargos() {
		
	}
	
	@XmlAttribute(name = "TotalCargos")
	public String getTotalCargos() {
		return totalCargos;
	}

	public void setTotalCargos(String totalCargos) {
		this.totalCargos = totalCargos;
	}

	@XmlElement(name = "Cargo")
	public List<Cargo> getCargo() {
		return cargo;
	}

	public void setCargo(List<Cargo> cargo) {
		this.cargo = cargo;
	}

		
}