package mx.xpd.cfdi.domain.cfdi.pdf.complementos.consumodecombustibles;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Determinados")
public class Determinados{

	private List<Determinado> determinado;
	
	public Determinados() {
		
	}

	@XmlElement(name = "Determinado")
	public List<Determinado> getDeterminado() {
		return determinado;
	}

	public void setDeterminado(List<Determinado> determinado) {
		this.determinado = determinado;
	}

	
	
	
	
		
	
}
