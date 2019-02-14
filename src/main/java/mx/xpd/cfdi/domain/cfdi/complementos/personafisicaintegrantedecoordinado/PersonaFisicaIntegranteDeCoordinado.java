package mx.xpd.cfdi.domain.cfdi.complementos.personafisicaintegrantedecoordinado;


import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "PersonaFisicaIntegranteDeCoordinado")
public class PersonaFisicaIntegranteDeCoordinado {

	private String version = "1.0";
	private String claveVehicularPFIC;
	private String placa;
	private String RFCPF;
			
	public PersonaFisicaIntegranteDeCoordinado() {
		
	}

	@XmlAttribute(name = "version")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "ClaveVehicular")
	public String getClaveVehicularPFIC() {
		return claveVehicularPFIC;
	}

	public void setClaveVehicularPFIC(String claveVehicularPFIC) {
		this.claveVehicularPFIC = claveVehicularPFIC;
	}
	
	@XmlAttribute(name = "Placa")
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	@XmlAttribute(name = "RFCPF")
	public String getRFCPF() {
		return RFCPF;
	}

	public void setRFCPF(String RFCPF) {
		this.RFCPF = RFCPF;
	}
			
			
}