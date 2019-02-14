package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AportacionesODepositos")
public class AportacionesODepositos{

	private String tipoAportacionODeposito;
	private String montAportODep;
	private String rfcFiduciaria;
	
	
	public AportacionesODepositos() {
		
	}
	
	@XmlAttribute(name = "TipoAportacionODeposito")
	public String getTipoAportacionODeposito() {
		return tipoAportacionODeposito;
	}

	public void setTipoAportacionODeposito(String tipoAportacionODeposito) {
		this.tipoAportacionODeposito = tipoAportacionODeposito;
	}
	
	@XmlAttribute(name = "MontAportODep")
	public String getMontAportODep() {
		return montAportODep;
	}

	public void setMontAportODep(String montAportODep) {
		this.montAportODep = montAportODep;
	}
	
	@XmlAttribute(name = "RFCFiduciaria")
	public String getRfcFiduciaria() {
		return rfcFiduciaria;
	}

	public void setRfcFiduciaria(String rfcFiduciaria) {
		this.rfcFiduciaria = rfcFiduciaria;
	}

	
		
}