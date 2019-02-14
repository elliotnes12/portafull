package mx.xpd.cfdi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.jboss.logging.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Entity
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = "string"))
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id=:tenantId"))
@Table(name = "cancelacion_script", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class CancelacionScript {
	@Transient
	private Logger log = Logger.getLogger(CancelacionScript.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	private String estatus;
	private Date fechaRegistro;
	private Date fechaCancelacion;
	private Date fechaRespuestaCancelacion;
		
	
	public CancelacionScript(){
		this.setFechaCancelacion(new Date());
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - CancelacionScript");
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	public Date getFechaRespuestaCancelacion() {
		return fechaRespuestaCancelacion;
	}

	public void setFechaRespuestaCancelacion(Date fechaRespuestaCancelacion) {
		this.fechaRespuestaCancelacion = fechaRespuestaCancelacion;
	}
	
}
