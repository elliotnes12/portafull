package mx.xpd.cfdi.marshaller.Nomina12;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="Nomina")
@XmlType(propOrder={
		"emisor",
		"receptor",
		"percepciones",
		"deducciones",
		"otrosPagos",
		"incapacidades"
})

public class Nomina {
	
	private String version;
	private String tipoNomina;
	//Se expresa en la forma AAAA-MM-DD de acuerdo al tipo t_Fecha
	private String fechaPago;
	//Se expresa en la forma AAAA-MM-DD de acuerdo al tipo t_Fecha
	private String fechaInicialPago;
	//Se expresa en la forma AAAA-MM-DD de acuerdo al tipo t_Fecha
	private String fechaFinalPago;
	private String numDiasPagados;
	private String totalPercepciones;
	private String totalDeducciones;
	private String totalOtrosPagos;
	
	private EmisorNom emisor;
	private ReceptorNom receptor;
	private Percepciones percepciones;
	private Deducciones deducciones;
	private OtrosPagos otrosPagos;
	private Incapacidades incapacidades;
	
	public Nomina() {
		
	}
	
	public Nomina(String []data) {
		
		 version = data[1].equals(" ") ? null : data[1];
		 tipoNomina = data[2].equals(" ") ? null : data[2];
		 fechaPago = data[3].equals(" ") ? null : data[3];
		 fechaInicialPago = data[4].equals(" ") ? null : data[4];
		 fechaFinalPago = data[5].equals(" ") ? null : data[5];
		 numDiasPagados = data[6].equals(" ") ? null : data[6];
		 totalPercepciones = data[7].equals(" ") ? null : (data[7]);
		 totalDeducciones = data[8].equals(" ") ? null : (data[8]);
		 totalOtrosPagos = data[9].equals(" ") ? null : (data[9]);
		
	}
	
	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "Version")
	public String getVersion() {
		if(version==null){return null;}
		return version.trim().equals("") ? null : version.trim();
		//return version;
	}
	
	@XmlAttribute(name = "TipoNomina")
	public String getTipoNomina() {
		if(tipoNomina==null){return null;}
		return tipoNomina.trim().equals("") ? null : tipoNomina.trim();
		//return tipoNomina;
	}
	
	@XmlAttribute(name = "FechaPago")
	public String getFechaPago() {
		if(fechaPago==null){return null;}
		return fechaPago.trim().equals("") ? null : fechaPago.trim();
		//return fechaPago;
	}
	
	@XmlAttribute(name = "FechaInicialPago")
	public String getFechaInicialPago() {
		if(fechaInicialPago==null){return null;}
		return fechaInicialPago.trim().equals("") ? null : fechaInicialPago.trim();
		//return fechaInicialPago;
	}
	
	@XmlAttribute(name = "FechaFinalPago")
	public String getFechaFinalPago() {
		if(fechaFinalPago==null){return null;}
		return fechaFinalPago.trim().equals("") ? null : fechaFinalPago.trim();
		//return fechaFinalPago;
	}
	
	@XmlAttribute(name = "NumDiasPagados")
	public String getNumDiasPagados() {
		if(numDiasPagados==null){return null;}
		return numDiasPagados.trim().equals("") ? null : numDiasPagados.trim();
		//return numDiasPagados;
	}
	
	@XmlAttribute(name = "TotalPercepciones")
	public String getTotalPercepciones() {
		if(totalPercepciones==null){return null;}
		return totalPercepciones.trim().equals("") ? null : totalPercepciones.trim();
	}
	
	@XmlAttribute(name = "TotalDeducciones")
	public String getTotalDeducciones() {
		if(totalDeducciones==null){return null;}
		return totalDeducciones.trim().equals("") ? null : totalDeducciones.trim();
	}
	
	@XmlAttribute(name = "TotalOtrosPagos")
	public String getTotalOtrosPagos() {
		if(totalOtrosPagos==null){return null;}
		return totalOtrosPagos.trim().equals("") ? null : totalOtrosPagos.trim();
	}
	
	///////////// SETTERS ATRIBUTOS
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void setTipoNomina(String tipoNomina) {
		this.tipoNomina = tipoNomina;
	}
	
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public void setFechaInicialPago(String fechaInicialPago) {
		this.fechaInicialPago = fechaInicialPago;
	}
	
	public void setFechaFinalPago(String fechaFinalPago) {
		this.fechaFinalPago = fechaFinalPago;
	}
	
	public void setNumDiasPagados(String numDiasPagados) {
		this.numDiasPagados = numDiasPagados;
	}
	
	public void setTotalPercepciones(String totalPercepciones) {
		this.totalPercepciones = totalPercepciones;
	}
	
	public void setTotalDeducciones(String totalDeducciones) {
		this.totalDeducciones = totalDeducciones;
	}
	
	public void setTotalOtrosPagos(String totalOtrosPagos) {
		this.totalOtrosPagos = totalOtrosPagos;
	}

	
	///////////// GETTERS NODOS
	@XmlElement(name = "Emisor")
	public EmisorNom getEmisor() {
		return emisor;
	}

	@XmlElement(name = "Receptor")
	public ReceptorNom getReceptor() {
		return receptor;
	}

	@XmlElement(name = "Percepciones")
	public Percepciones getPercepciones() {
		return percepciones;
	}

	@XmlElement(name = "Deducciones")
	public Deducciones getDeducciones() {
		return deducciones;
	}

	@XmlElement(name = "OtrosPagos")
	public OtrosPagos getOtrosPagos() {
		return otrosPagos;
	}

	@XmlElement(name = "Incapacidades")
	public Incapacidades getIncapacidades() {
		return incapacidades;
	}

	///////////// SETTERS NODOS
	public void setEmisor(EmisorNom emisor) {
		this.emisor = emisor;
	}

	public void setReceptor(ReceptorNom receptor) {
		this.receptor = receptor;
	}

	public void setPercepciones(Percepciones percepciones) {
		this.percepciones = percepciones;
	}

	public void setDeducciones(Deducciones deducciones) {
		this.deducciones = deducciones;
	}

	public void setOtrosPagos(OtrosPagos otrosPagos) {
		this.otrosPagos = otrosPagos;
	}

	public void setIncapacidades(Incapacidades incapacidades) {
		this.incapacidades = incapacidades;
	}

}