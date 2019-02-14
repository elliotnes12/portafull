package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Receptor {
	private String curpReceptor;
	private String numSeguridadSocial;
	private String fechaInicioRelLaboral;
	private String antiguedad;
	private String tipoContrato;
	private String sindicalizado;
	private String tipoJornada;
	private String tipoRegimen;
	private String numEmpleado;
	private String departamento;
	private String puesto;
	private String riesgoPuesto;
	private String periodicidadPago;
	private String banco;
	private String cuentaBancaria;
	private String salarioBaseCotApor;
	private String salarioDiarioIntegrado;
	private String claveEntFed;
	
	private List<SubContratacion> subContratacion;
	
	public Receptor() {
		
	}
	
	@XmlAttribute(name = "Curp")
	public String getCurpReceptor() {
		return curpReceptor;
	}
	
	public void setCurpReceptor(String curpReceptor) {
		this.curpReceptor = curpReceptor;
	}
	
	@XmlAttribute(name = "NumSeguridadSocial")
	public String getNumSeguridadSocial() {
		return numSeguridadSocial;
	}
	
	public void setNumSeguridadSocial(String numSeguridadSocial) {
		this.numSeguridadSocial = numSeguridadSocial;
	}	
	
	@XmlAttribute(name = "FechaInicioRelLaboral")
	public String getFechaInicioRelLaboral() {
		return fechaInicioRelLaboral;
	}
	
	public void setFechaInicioRelLaboral(String fechaInicioRelLaboral) {
		this.fechaInicioRelLaboral = fechaInicioRelLaboral;
	}
	
	@XmlAttribute(name = "Antigüedad")
	public String getAntiguedad() {
		return antiguedad;
	}
	
	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	@XmlAttribute(name = "TipoContrato")
	public String getTipoContrato() {
		return tipoContrato;
	}
	
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
	@XmlAttribute(name = "Sindicalizado")
	public String getSindicalizado() {
		return sindicalizado;
	}
	
	public void setSindicalizado(String sindicalizado) {
		this.sindicalizado = sindicalizado;
	}
	
	@XmlAttribute(name = "TipoJornada")
	public String getTipoJornada() {
		return tipoJornada;
	}
	
	public void setTipoJornada(String tipoJornada) {
		this.tipoJornada = tipoJornada;
	}
	
	@XmlAttribute(name = "TipoRegimen")
	public String getTipoRegimen() {
		return tipoRegimen;
	}
	
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}
	
	@XmlAttribute(name = "NumEmpleado")
	public String getNumEmpleado() {
		return numEmpleado;
	}
	
	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	
	@XmlAttribute(name = "Departamento")
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	@XmlAttribute(name = "Puesto")
	public String getPuesto() {
		return puesto;
	}
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	@XmlAttribute(name = "RiesgoPuesto")
	public String getRiesgoPuesto() {
		return riesgoPuesto;
	}
	
	public void setRiesgoPuesto(String riesgoPuesto) {
		this.riesgoPuesto = riesgoPuesto;
	}
	
	@XmlAttribute(name = "PeriodicidadPago")
	public String getPeriodicidadPago() {
		return periodicidadPago;
	}
	
	public void setPeriodicidadPago(String periodicidadPago) {
		this.periodicidadPago = periodicidadPago;
	}
	
	@XmlAttribute(name = "Banco")
	public String getBanco() {
		return banco;
	}
	
	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	@XmlAttribute(name = "CuentaBancaria")
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}
	
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	@XmlAttribute(name = "SalarioBaseCotApor")
	public String getSalarioBaseCotApor() {
		return salarioBaseCotApor;
	}
	
	public void setSalarioBaseCotApor(String salarioBaseCotApor) {
		this.salarioBaseCotApor = salarioBaseCotApor;
	}
	
	@XmlAttribute(name = "SalarioDiarioIntegrado")
	public String getSalarioDiarioIntegrado() {
		return salarioDiarioIntegrado;
	}
	
	public void setSalarioDiarioIntegrado(String salarioDiarioIntegrado) {
		this.salarioDiarioIntegrado = salarioDiarioIntegrado;
	}
	
	@XmlAttribute(name = "ClaveEntFed")
	public String getClaveEntFed() {
		return claveEntFed;
	}
	
	public void setClaveEntFed(String claveEntFed) {
		this.claveEntFed = claveEntFed;
	}
	
	@XmlElement(name = "SubContratacion")
	public List<SubContratacion> getSubContratacion() {
		return subContratacion;
	}

	public void setSubContratacion(List<SubContratacion> subContratacion) {
		this.subContratacion = subContratacion;
	}
	
}
