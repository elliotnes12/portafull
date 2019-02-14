package mx.xpd.cfdi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

//@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
@Entity
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = "string"))
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id=:tenantId"))
public class AuditoriaCliente{
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	
	public AuditoriaCliente() {
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date()); 
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - AuditCliente");
		}
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	@Id
	@GeneratedValue
	private Long idAuditoria;
	
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	
	@NotNull
	@NotEmpty
	private String clave;
	
	@NotNull
	@NotEmpty
	private String razonSocial;
	
	@NotNull
	@NotEmpty
	private String rfc;
	
	//@NotEmpty
	private String residenciaFiscal;
	
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

	public String getTriggerActivadoPor() {
		return triggerActivadoPor;
	}

	public void setTriggerActivadoPor(String triggerActivadoPor) {
		this.triggerActivadoPor = triggerActivadoPor;
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

	
	public String getResidenciaFiscal() {
		return residenciaFiscal;
	}

	public void setResidenciaFiscal(String residenciaFiscal) {
		this.residenciaFiscal = residenciaFiscal;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
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

	public String getAccionRealizada() {
		return accionRealizada;
	}

	public void setAccionRealizada(String accionRealizada) {
		this.accionRealizada = accionRealizada;
	}
	
}
