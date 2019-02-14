package mx.xpd.cfdi.marshaller;

import mx.xpd.cfdi.marshaller.timbreFiscal.TimbreFiscalDigital;
import mx.xpd.cfdi.marshaller.Nomina12.*;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Complemento {

	private List<Nomina> nomina;
        private TimbreFiscalDigital timbre;
        
	public Complemento() {
//		pagos = new Pagos();
	}
	
	@XmlElement(name = "Nomina", namespace="http://www.sat.gob.mx/nomina12")
	public List<Nomina> getNomina() {
		return nomina;
	}
        
        public void setTimbreFiscalDigital(TimbreFiscalDigital timbre)
        {
            this.timbre = timbre;
        }
        @XmlElement(name = "TimbreFiscalDigital",namespace="http://www.sat.gob.mx/TimbreFiscalDigital")
	public TimbreFiscalDigital getTimbreFiscalDigital() {
		return timbre;
	}

	public void setNomina(List<Nomina> nomina) {
		this.nomina = nomina;
	}
	
}
