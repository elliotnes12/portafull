package mx.xpd.cfdi.marshaller.Nomina12;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={
		"subsidioAlEmpleo",
		"compensacionSaldosAFavor",
})

public class OtroPago {
	
	private SubsidioAlEmpleo subsidioAlEmpleo;
	private CompensacionSaldosAFavor compensacionSaldosAFavor;
	private String tipoOtroPago;
	private String clave;
	private String concepto;
	private String importe;
	
	public OtroPago() {
		
		subsidioAlEmpleo = new SubsidioAlEmpleo();
		compensacionSaldosAFavor = new CompensacionSaldosAFavor();
		
	}
	
	public OtroPago(String []data) {
		
		subsidioAlEmpleo = new SubsidioAlEmpleo();
		compensacionSaldosAFavor = new CompensacionSaldosAFavor();
		
                
		tipoOtroPago = data[1].equals(" ") ? null : data[1];
		clave = data[2].equals(" ") ? null : data[2];
		concepto = data[3].equals(" ") ? null : data[3];
		importe = data[4].equals(" ") ? null : (data[4]);
		
	}

	///////////// GETTERS NODOS
	@XmlElement(name = "SubsidioAlEmpleo")
	public SubsidioAlEmpleo getSubsidioAlEmpleo() {
		return subsidioAlEmpleo;
	}

	@XmlElement(name = "CompensacionSaldosAFavor")
	public CompensacionSaldosAFavor getCompensacionSaldosAFavor() {
		return compensacionSaldosAFavor;
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "TipoOtroPago")
	public String getTipoOtroPago() {
		if(tipoOtroPago==null){return null;}
		return tipoOtroPago.trim().equals("") ? null : tipoOtroPago.trim();
		//return tipoOtroPago;
	}

	@XmlAttribute(name = "Clave")
	public String getClave() {
		if(clave==null){return null;}
		return clave.trim().equals("") ? null : clave.trim();
		//return clave;
	}

	@XmlAttribute(name = "Concepto")
	public String getConcepto() {
		if(concepto==null){return null;}
		return concepto.trim().equals("") ? null : concepto.trim();
		//return concepto;
	}

	@XmlAttribute(name = "Importe")
	public String getImporte() {
		if(importe==null){return null;}
		return importe.trim().equals("") ? null : importe.trim();
	}

	
	///////////// SETTERS NODOS
	public void setSubsidioAlEmpleo(SubsidioAlEmpleo subsidioAlEmpleo) {
		this.subsidioAlEmpleo = subsidioAlEmpleo;
	}

	public void setCompensacionSaldosAFavor(
			CompensacionSaldosAFavor compensacionSaldosAFavor) {
		this.compensacionSaldosAFavor = compensacionSaldosAFavor;
	}

	///////////// SETTERS ATRIBUTOS
	public void setTipoOtroPago(String tipoOtroPago) {
		this.tipoOtroPago = tipoOtroPago;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

}
