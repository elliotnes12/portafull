package mx.xpd.cfdi.domain.retenciones.complementos.pagosaextranjeros;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "NoBeneficiario")
public class NoBeneficiario {

	private String paisDeResidParaEfecFisc;
	private String conceptoPago;
	private String descripcionConcepto;

	
	public NoBeneficiario() {
		
	}
	
	@XmlAttribute(name = "PaisDeResidParaEfecFisc")
	public String getPaisDeResidParaEfecFisc() {
		return paisDeResidParaEfecFisc;
	}

	public void setPaisDeResidParaEfecFisc(String paisDeResidParaEfecFisc) {
		this.paisDeResidParaEfecFisc = paisDeResidParaEfecFisc;
	}

	@XmlAttribute(name = "ConceptoPago")
	public String getConceptoPago() {
		return conceptoPago;
	}

	public void setConceptoPago(String conceptoPago) {
		this.conceptoPago = conceptoPago;
	}

	@XmlAttribute(name = "DescripcionConcepto")
	public String getDescripcionConcepto() {
		return descripcionConcepto;
	}

	public void setDescripcionConcepto(String descripcionConcepto) {
		this.descripcionConcepto = descripcionConcepto;
	}

	

	

	
}
