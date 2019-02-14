package mx.xpd.cfdi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.util.SecurityUtil;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;


@Entity
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = "string"))
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id=:tenantId"))
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Transient
	private Logger log = Logger.getLogger(Empleado.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	
	
	private String antiguedad;
	private String banco;
	private String cuentaBancaria;
	@NotNull
	@NotEmpty
	private String curp;
	private String departamento;
	private boolean eliminado;
	private String fechaInicioRelLaboral;
	private Date fechaRegistro;
	private String nombre;
	@NotNull
	private Double numDiasPagados;
	@NotNull
	@NotEmpty
	private String numEmpleado;
	private String numSeguridadSocial;
	@NotNull
	@NotEmpty
	private String periodicidadPago;
	private String puesto;
	private String rfc;
	private String riesgoPuesto;
	private Double salarioBaseCotApor;
	private Double salarioDiarioIntegrado;
	@NotNull
	private String tipoContrato;
	private String tipoJornada;
	@NotNull
	private String tipoRegimen;
	private Date ultimaActualizacion;
	private String email;
	@NotNull
	private String claveEntFed;
	private String sindicalizado;
	private String usoCFDI;
	
	public Empleado(){
		this.setEliminado(false);
		this.setFechaRegistro(new Date());
		this.setUltimaActualizacion(new Date());
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - Empleado");
		}
	}
	
	public String getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	public String getFechaInicioRelLaboral() {
		return fechaInicioRelLaboral;
	}
	public void setFechaInicioRelLaboral(String fechaInicioRelLaboral) {
		this.fechaInicioRelLaboral = fechaInicioRelLaboral;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getNumDiasPagados() {
		return numDiasPagados;
	}
	public void setNumDiasPagados(Double numDiasPagados) {
		this.numDiasPagados = numDiasPagados;
	}
	public String getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public String getNumSeguridadSocial() {
		return numSeguridadSocial;
	}
	public void setNumSeguridadSocial(String numSeguridadSocial) {
		this.numSeguridadSocial = numSeguridadSocial;
	}
	public String getPeriodicidadPago() {
		return periodicidadPago;
	}
	public void setPeriodicidadPago(String periodicidadPago) {
		this.periodicidadPago = periodicidadPago;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getRiesgoPuesto() {
		return riesgoPuesto;
	}
	public void setRiesgoPuesto(String riesgoPuesto) {
		this.riesgoPuesto = riesgoPuesto;
	}
	public Double getSalarioBaseCotApor() {
		return salarioBaseCotApor;
	}
	public void setSalarioBaseCotApor(Double salarioBaseCotApor) {
		this.salarioBaseCotApor = salarioBaseCotApor;
	}
	public Double getSalarioDiarioIntegrado() {
		return salarioDiarioIntegrado;
	}
	public void setSalarioDiarioIntegrado(Double salarioDiarioIntegrado) {
		this.salarioDiarioIntegrado = salarioDiarioIntegrado;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public String getTipoJornada() {
		return tipoJornada;
	}
	public void setTipoJornada(String tipoJornada) {
		this.tipoJornada = tipoJornada;
	}
	public String getTipoRegimen() {
		return tipoRegimen;
	}
	public void setTipoRegimen(String tipoRegimen) {
		this.tipoRegimen = tipoRegimen;
	}
	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}
	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClaveEntFed() {
		return claveEntFed;
	}
	public void setClaveEntFed(String claveEntFed) {
		this.claveEntFed = claveEntFed;
	}
	public String getSindicalizado() {
		return sindicalizado;
	}
	public void setSindicalizado(String sindicalizado) {
		this.sindicalizado = sindicalizado;
	}
	public String getUsoCFDI() {
		return usoCFDI;
	}
	public void setUsoCFDI(String usoCFDI) {
		this.usoCFDI = usoCFDI;
	}
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", tenantId=" + tenantId + ", antiguedad="
				+ antiguedad + ", banco=" + banco + ", cuentaBancaria="
				+ cuentaBancaria + ", curp=" + curp + ", departamento="
				+ departamento + ", eliminado=" + eliminado + ", fechaInicioRelLaboral=" + fechaInicioRelLaboral
				+ ", fechaRegistro=" + fechaRegistro + ", nombre=" + nombre
				+ ", numDiasPagados=" + numDiasPagados + ", numEmpleado=" + numEmpleado
				+ ", numSeguridadSocial=" + numSeguridadSocial + ", periodicidadPago=" + periodicidadPago
				+ ", puesto=" + puesto + ", rfc=" + rfc + ", riesgoPuesto="
				+ riesgoPuesto + ", salarioBaseCotApor=" + salarioBaseCotApor + ", salarioDiarioIntegrado="
				+ salarioDiarioIntegrado + ", tipoContrato=" + tipoContrato + ", tipoJornada=" + tipoJornada
				+ ", tipoRegimen=" + tipoRegimen + ",ultimaActualizacion="
				+ ultimaActualizacion + "]";
	}
}
