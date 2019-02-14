package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="Nomina")
@XmlType(propOrder={
		"percepciones",
		"deducciones",
		"incapacidades",
		"horasExtras"
})
public class Nomina {
	
	private String version; //
	private String registroPatronal;
	private String numEmpleado;
	private String curp;
	private Integer tipoRegimen;
	private String numSeguridadSocial;
	// La forma aaaa-mm-ddThh:mm:ss, de acuerdo con la especificación ISO 8601
	private String fechaPago;
	private String fechaInicialPago;
	private String fechaFinalPago;
	///////////////////
	private Double numDiasPagados;
	private String departamento;
	private String clabe;
	private String banco;
	// La forma aaaa-mm-ddThh:mm:ss, de acuerdo con la especificación ISO 8601
	private String fechaInicioRelLaboral;
	private Integer antiguedad;
	private String puesto;
	private String tipoContrato;
	private String tipoJornada;
	private String periodicidadPago;
	private Double salarioBaseCotApor;
	private Integer riesgoPuesto;
	private Double salarioDiarioIntegrado;
	
	/////////////////
	private Percepciones percepciones;
	private Deducciones deducciones;
	private Incapacidades incapacidades;
	private HorasExtras horasExtras;
	
	public Nomina() {
		
	}
	public Nomina(String []data) {
		version = data[0];
		registroPatronal = data[1];
		numEmpleado = data[2];
		curp = data[3];
		tipoRegimen = Integer.valueOf(data[4]);
		numSeguridadSocial = data[5];
		fechaPago = data[6];
		fechaInicialPago = data[7];
		fechaFinalPago = data[8];
		numDiasPagados = Double.parseDouble(data[9]);
		departamento = data[10].equals(" ") ? null : data[10];
		clabe = data[11].equals(" ") ? null : data[11];
		banco = data[12].equals(" ") ? null : data[12];
		fechaInicioRelLaboral = data[13];
		antiguedad = Integer.valueOf(data[14]);
		puesto = data[15];
		tipoContrato = data[16];
		tipoJornada = data[17];
		periodicidadPago = data[18];
		salarioBaseCotApor = Double.parseDouble(data[19]);
		riesgoPuesto = Integer.valueOf(data[20]);
		salarioDiarioIntegrado = Double.parseDouble(data[21]);
	}
	
	
	/////////////GETTERS
	@XmlAttribute(name = "Version")
	public String getVersion() {
		return "1.1";
		//return version;
	}
	
	@XmlAttribute(name = "RegistroPatronal")
	public String getRegistroPatronal() {
		return (registroPatronal == null || registroPatronal.trim().equals("")) ? null : registroPatronal.trim();
		//return registroPatronal;
	}
	
	@XmlAttribute(name = "NumEmpleado")
	public String getNumEmpleado() {
		return (numEmpleado == null || numEmpleado.trim().equals("")) ? null : numEmpleado.trim();
		//return numEmpleado;
	}
	
	@XmlAttribute(name = "CURP")
	public String getCurp() {
		return (curp == null || curp.trim().equals("")) ? null : curp.trim();
	}
	
	@XmlAttribute(name = "TipoRegimen")
	public Integer getTipoRegimen() {
		return tipoRegimen;
	}
	
	@XmlAttribute(name = "NumSeguridadSocial")
	public String getNumSeguridadSocial() {
		return (numSeguridadSocial == null || numSeguridadSocial.trim().equals("")) ? null : numSeguridadSocial.trim();
		//return numSeguridadSocial;
	}
	
	@XmlAttribute(name = "FechaPago")
	public String getFechaPago() {
		return (fechaPago == null || fechaPago.trim().equals("")) ? null : fechaPago.trim();
		//return fechaPago;
	}
	
	@XmlAttribute(name = "FechaInicialPago")
	public String getFechaInicialPago() {
		return (fechaInicialPago == null || fechaInicialPago.trim().equals("")) ? null : fechaInicialPago.trim();
		//return fechaInicialPago;
	}
	
	@XmlAttribute(name = "FechaFinalPago")
	public String getFechaFinalPago() {
		return (fechaFinalPago == null || fechaFinalPago.trim().equals("")) ? null : fechaFinalPago.trim();
	}
	
	@XmlAttribute(name = "NumDiasPagados")
	public Double getNumDiasPagados() {
		return numDiasPagados;
	}
	
	@XmlAttribute(name = "Departamento")
	public String getDepartamento() {
		if(departamento==null){
			return null;
		}
		return departamento.trim().equals("") ? null : departamento.trim();
		//return departamento;
	}
	
	@XmlAttribute(name = "CLABE")
	public String getClabe() {
		if(clabe==null){
			return null;
		}
		return clabe.trim().equals("") ? null : clabe.trim();
		//return clabe;
	}
	
	@XmlAttribute(name = "Banco")
	public String getBanco() {
		if(banco==null){
			return null;
		}
		return banco.trim().equals("") ? null : banco.trim();
	}
	
	@XmlAttribute(name = "FechaInicioRelLaboral")
	public String getFechaInicioRelLaboral() {
		return (fechaInicioRelLaboral == null || fechaInicioRelLaboral.trim().equals("")) ? null : fechaInicioRelLaboral.trim();
		//return fechaInicioRelLaboral;
	}
	
	@XmlAttribute(name = "Antiguedad")
	public Integer getAntiguedad() {
		return antiguedad;
	}
	
	@XmlAttribute(name = "Puesto")
	public String getPuesto() {
		return (puesto == null || puesto.trim().equals("")) ? null : puesto.trim();
		//return puesto;
	}
	
	@XmlAttribute(name = "TipoContrato")
	public String getTipoContrato() {
		return (tipoContrato == null || tipoContrato.trim().equals("")) ? null : tipoContrato.trim();
		//return tipoContrato;
	}
	
	@XmlAttribute(name = "TipoJornada")
	public String getTipoJornada() {
		return (tipoJornada == null || tipoJornada.trim().equals("")) ? null : tipoJornada.trim();
		//return tipoJornada;
	}
	
	@XmlAttribute(name = "PeriodicidadPago")
	public String getPeriodicidadPago() {
		return (periodicidadPago == null || periodicidadPago.trim().equals("")) ? null : periodicidadPago.trim();
		//return periodicidadPago;
	}
	
	@XmlAttribute(name = "SalarioBaseCotApor")
	public Double getSalarioBaseCotApor() {
		return salarioBaseCotApor;
	}
	
	@XmlAttribute(name = "RiesgoPuesto")
	public Integer getRiesgoPuesto() {
		return riesgoPuesto;
	}
	
	@XmlAttribute(name = "SalarioDiarioIntegrado")
	public Double getSalarioDiarioIntegrado() {
		return salarioDiarioIntegrado;
	}
	
	
	// SETTERS
	public void setVersion(String version) {
		this.version = version;
	}
	
	public void setRegistroPatronal(String registroPatronal) {
		this.registroPatronal = registroPatronal;
	}
	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public void setTipoRegimen(Integer tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}
	public void setNumSeguridadSocial(String numSeguridadSocial) {
		this.numSeguridadSocial = numSeguridadSocial;
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
	public void setNumDiasPagados(Double numDiasPagados) {
		this.numDiasPagados = numDiasPagados;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public void setFechaInicioRelLaboral(String fechaInicioRelLaboral) {
		this.fechaInicioRelLaboral = fechaInicioRelLaboral;
	}
	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public void setTipoJornada(String tipoJornada) {
		this.tipoJornada = tipoJornada;
	}
	public void setPeriodicidadPago(String periodicidadPago) {
		this.periodicidadPago = periodicidadPago;
	}
	public void setSalarioBaseCotApor(Double salarioBaseCotApor) {
		this.salarioBaseCotApor = salarioBaseCotApor;
	}
	public void setRiesgoPuesto(Integer riesgoPuesto) {
		this.riesgoPuesto = riesgoPuesto;
	}
	public void setSalarioDiarioIntegrado(Double salarioDiarioIntegrado) {
		this.salarioDiarioIntegrado = salarioDiarioIntegrado;
	}
	
	
	
	/////////////////////////////////////////////////////////
	
	@XmlElement(name = "Percepciones")
	public Percepciones getPercepciones() {
		return percepciones;
	}
	
	@XmlElement(name = "Deducciones")
	public Deducciones getDeducciones() {
		return deducciones;
	}
	
	@XmlElement(name = "Incapacidades")
	public Incapacidades getIncapacidades() {
		return incapacidades;
	}
	
	@XmlElement(name = "HorasExtras")
	public HorasExtras getHorasExtras() {
		return horasExtras;
	}
	
	
	public void setPercepciones(Percepciones percepciones) {
		this.percepciones = percepciones;
	}
	public void setDeducciones(Deducciones deducciones) {
		this.deducciones = deducciones;
	}
	public void setIncapacidades(Incapacidades incapacidades) {
		this.incapacidades = incapacidades;
	}
	public void setHorasExtras(HorasExtras horasExtras) {
		this.horasExtras = horasExtras;
	}	
	
	
	/*@Override
	public String toString() {
		return "Nomina [version=" + version + ", registroPatronal =" + registroPatronal
				+ ", folio=" + folio + ", fecha=" + fecha + ", sello=" + sello
				+ ", formaDePago=" + formaDePago + ", noCertificado="
				+ noCertificado + ", certificado=" + certificado
				+ ", condicionesDePago=" + condicionesDePago + ", subTotal="
				+ subTotal + ", descuento=" + descuento + ", motivoDescuento="
				+ motivoDescuento + ", tipoCambio=" + tipoCambio + ", moneda="
				+ moneda + ", total=" + total + ", tipoComprobante="
				+ tipoDeComprobante + ", metodoDePago=" + metodoDePago
				+ ", LugarExpedicion=" + lugarExpedicion + ", NumCtaPago="
				+ numCtaPago + ", FolioFiscalOrig=" + folioFiscalOrig
				+ ", SerieFolioFiscalOrig=" + serieFolioFiscalOrig
				+ ", FechaFolioFiscalOrig=" + fechaFolioFiscalOrig
				+ ", MontoFolioFiscalOrig=" + montoFolioFiscalOrig
				+ ", emisor=" + emisor + ", receptor=" + receptor
				+ ", conceptos=" + conceptos + "]";
	}*/
	
}
