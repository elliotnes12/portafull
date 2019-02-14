package mx.xpd.cfdi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Entity
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = "string"))
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id=:tenantId"))
public class AuditoriaLugarEmision{
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue
	private Long idAuditoria;
	
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9]*", message = "No debe contener caracteres especiales")
	private String clave;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "No debe contener caracteres especiales")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "No debe contener caracteres especiales")
	private String calle;
	
	@Digits(fraction = 0, integer = 5)
	private int numeroInterior;
	
	@Digits(fraction = 0, integer = 5)
	private int numeroExterior;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "No debe contener caracteres especiales")
	private String Colonia;
	
	@Digits(fraction = 0, integer = 5)
	private int codigoPostal;
	
	private String referencia;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "No debe contener caracteres especiales")
	private String estado;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "No debe contener caracteres especiales")
	private String municipio;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "No debe contener caracteres especiales")
	private String pais;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "No debe contener caracteres especiales")
	private String ciudad;
	
	private String telefono;
	
	@NotNull
	@NotEmpty
	@Email
	private String email;
	
	private Boolean eliminado;
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean semaforo;
	private String triggerActivadoPor;
	private String accionRealizada;
	
	public Long getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(Long idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public AuditoriaLugarEmision(){
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date());
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - AuditLugar");
		}
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(int numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public int getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(int numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getColonia() {
		return Colonia;
	}

	public void setColonia(String colonia) {
		Colonia = colonia;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	public Boolean getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Boolean semaforo) {
		this.semaforo = semaforo;
	}

	public String getTriggerActivadoPor() {
		return triggerActivadoPor;
	}

	public void setTriggerActivadoPor(String triggerActivadoPor) {
		this.triggerActivadoPor = triggerActivadoPor;
	}

	public String getAccionRealizada() {
		return accionRealizada;
	}

	public void setAccionRealizada(String accionRealizada) {
		this.accionRealizada = accionRealizada;
	}
	
}
