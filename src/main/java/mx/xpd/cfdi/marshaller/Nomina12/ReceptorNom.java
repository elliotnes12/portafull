package mx.xpd.cfdi.marshaller.Nomina12;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ReceptorNom {
	
	private List<SubContratacion> subContratacion;
	private String curp;
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
	
	public ReceptorNom() {
		subContratacion = new ArrayList<SubContratacion>();
	}
	
	public ReceptorNom(String []data) {
		
		subContratacion = new ArrayList<SubContratacion>();
		
		curp = data[2].equals(" ") ? null : data[2];
		numSeguridadSocial = data[3].equals(" ") ? null : data[3];
		fechaInicioRelLaboral = data[4].equals(" ") ? null : data[4];
		antiguedad = data[5].equals(" ") ? null : data[5];
		tipoContrato = data[6].equals(" ") ? null : data[6];
		sindicalizado = data[7].equals(" ") ? null : data[7];
		tipoJornada = data[8].equals(" ") ? null : data[8];
		tipoRegimen = data[9].equals(" ") ? null : data[9];
		numEmpleado = data[10].equals(" ") ? null : data[10];
		departamento = data[11].equals(" ") ? null : data[11];
		puesto = data[12].equals(" ") ? null : data[12];
		riesgoPuesto = data[13].equals(" ") ? null : data[13];
		periodicidadPago = data[14].equals(" ") ? null : data[14];
		banco = data[15].equals(" ") ? null : data[15];
		cuentaBancaria = data[16].equals(" ") ? null : data[16];
		salarioBaseCotApor = data[17].equals(" ") ? null : (data[17]);
		salarioDiarioIntegrado = data[18].equals(" ") ? null : (data[18]);
		claveEntFed = data[19].equals(" ") ? null : data[19];
		
	}
	
	///////////// GETTERS NODOS
	@XmlElement(name = "SubContratacion")
	public List<SubContratacion> getSubContratacion() {
		return subContratacion;
	}

	///////////// GETTERS ATRIBUTOS
	@XmlAttribute(name = "Curp")
	public String getCurp() {
		if(curp==null){return null;}
		return curp.trim().equals("") ? null : curp.trim();
		//return curp;
	}

	@XmlAttribute(name = "NumSeguridadSocial")
	public String getNumSeguridadSocial() {
		if(numSeguridadSocial==null){return null;}
		return numSeguridadSocial.trim().equals("") ? null : numSeguridadSocial.trim();
		//return numSeguridadSocial;
	}

	@XmlAttribute(name = "FechaInicioRelLaboral")
	public String getFechaInicioRelLaboral() {
		if(fechaInicioRelLaboral==null){return null;}
		return fechaInicioRelLaboral.trim().equals("") ? null : fechaInicioRelLaboral.trim();
		//return fechaInicioRelLaboral;
	}

	@XmlAttribute(name = "Antigüedad")
	public String getAntiguedad() {
		if(antiguedad==null){return null;}
		return antiguedad.trim().equals("") ? null : antiguedad.trim();
		//return antiguedad;
	}

	@XmlAttribute(name = "TipoContrato")
	public String getTipoContrato() {
		if(tipoContrato==null){return null;}
		return tipoContrato.trim().equals("") ? null : tipoContrato.trim();
		//return tipoContrato;
	}

	@XmlAttribute(name = "Sindicalizado")
	public String getSindicalizado() {
		if(sindicalizado==null){return null;}
		return sindicalizado.trim().equals("") ? null : sindicalizado.trim();
		//return sindicalizado;
	}

	@XmlAttribute(name = "TipoJornada")
	public String getTipoJornada() {
		if(tipoJornada==null){return null;}
		return tipoJornada.trim().equals("") ? null : tipoJornada.trim();
		//return tipoJornada;
	}

	@XmlAttribute(name = "TipoRegimen")
	public String getTipoRegimen() {
		if(tipoRegimen==null){return null;}
		return tipoRegimen.trim().equals("") ? null : tipoRegimen.trim();
		//return tipoRegimen;
	}

	@XmlAttribute(name = "NumEmpleado")
	public String getNumEmpleado() {
		if(numEmpleado==null){return null;}
		return numEmpleado.trim().equals("") ? null : numEmpleado.trim();
		//return numEmpleado;
	}

	@XmlAttribute(name = "Departamento")
	public String getDepartamento() {
		if(departamento==null){return null;}
		return departamento.trim().equals("") ? null : departamento.trim();
		//return departamento;
	}

	@XmlAttribute(name = "Puesto")
	public String getPuesto() {
		if(puesto==null){return null;}
		return puesto.trim().equals("") ? null : puesto.trim();
		//return puesto;
	}

	@XmlAttribute(name = "RiesgoPuesto")
	public String getRiesgoPuesto() {
		if(riesgoPuesto==null){return null;}
		return riesgoPuesto.trim().equals("") ? null : riesgoPuesto.trim();
		//return riesgoPuesto;
	}

	@XmlAttribute(name = "PeriodicidadPago")
	public String getPeriodicidadPago() {
		if(periodicidadPago==null){return null;}
		return periodicidadPago.trim().equals("") ? null : periodicidadPago.trim();
		//return periodicidadPago;
	}

	@XmlAttribute(name = "Banco")
	public String getBanco() {
		if(banco==null){return null;}
		return banco.trim().equals("") ? null : banco.trim();
		//return banco;
	}

	@XmlAttribute(name = "CuentaBancaria")
	public String getCuentaBancaria() {
		if(cuentaBancaria==null){return null;}
		return cuentaBancaria.trim().equals("") ? null : cuentaBancaria.trim();
		//return cuentaBancaria;
	}

	@XmlAttribute(name = "SalarioBaseCotApor")
	public String getSalarioBaseCotApor() {
		if(salarioBaseCotApor==null){return null;}
		return salarioBaseCotApor.trim().equals("") ? null : salarioBaseCotApor.trim();
	}

	@XmlAttribute(name = "SalarioDiarioIntegrado")
	public String getSalarioDiarioIntegrado() {
		if(salarioDiarioIntegrado==null){return null;}
		return salarioDiarioIntegrado.trim().equals("") ? null : salarioDiarioIntegrado.trim();
	}

	@XmlAttribute(name = "ClaveEntFed")
	public String getClaveEntFed() {
		if(claveEntFed==null){return null;}
		return claveEntFed.trim().equals("") ? null : claveEntFed.trim();
		//return claveEntFed;
	}

	
	///////////// SETTERS NODOS
	public void setSubContratacion(List<SubContratacion> subContratacion) {
		this.subContratacion = subContratacion;
	}

	///////////// SETTERS ATRIBUTOS
	public void setCurp(String curp) {
		this.curp = curp;
	}

	public void setNumSeguridadSocial(String numSeguridadSocial) {
		this.numSeguridadSocial = numSeguridadSocial;
	}

	public void setFechaInicioRelLaboral(String fechaInicioRelLaboral) {
		this.fechaInicioRelLaboral = fechaInicioRelLaboral;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public void setSindicalizado(String sindicalizado) {
		this.sindicalizado = sindicalizado;
	}

	public void setTipoJornada(String tipoJornada) {
		this.tipoJornada = tipoJornada;
	}

	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}

	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public void setRiesgoPuesto(String riesgoPuesto) {
		this.riesgoPuesto = riesgoPuesto;
	}

	public void setPeriodicidadPago(String periodicidadPago) {
		this.periodicidadPago = periodicidadPago;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public void setSalarioBaseCotApor(String salarioBaseCotApor) {
		this.salarioBaseCotApor = salarioBaseCotApor;
	}

	public void setSalarioDiarioIntegrado(String salarioDiarioIntegrado) {
		this.salarioDiarioIntegrado = salarioDiarioIntegrado;
	}

	public void setClaveEntFed(String claveEntFed) {
		this.claveEntFed = claveEntFed;
	}
}
