package mx.xpd.cfdi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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
public class Permiso {
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	private Long idGrupoUsuario;
	private Long idModulo;
	private String nombreModulo;
//	private String claveModulo;
	private Integer permiso; //0 ver y editar, 1 ver, 2 acceso denegado
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private String modificadoPor;
	private Boolean eliminado;
	private Boolean semaforo;
	
	public Permiso(){
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date());
		//si lo descomento ya no funciona el login
//		log.info("tenantSession: " + (String) RequestContextHolder
//				.currentRequestAttributes().getAttribute("tenantId",
//						RequestAttributes.SCOPE_SESSION));
		try {
//			log.info("tenantId notNull - Permiso");
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - Permiso");
		}
	}

	public Permiso(Long grupoUsuario, Long modulo, Integer permiso) {
		this();
		this.idGrupoUsuario = grupoUsuario;
		this.idModulo = modulo;
		this.permiso = permiso;
	}
	
	public Permiso(Long grupoUsuario, Long modulo, Integer permiso, String nombreModulo, String claveModulo) {
		this(grupoUsuario, modulo, permiso);
		this.nombreModulo = nombreModulo;
//		this.claveModulo = claveModulo;
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
	public Long getIdGrupoUsuario() {
		return idGrupoUsuario;
	}
	public void setIdGrupoUsuario(Long idGrupoUsuario) {
		this.idGrupoUsuario = idGrupoUsuario;
	}
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}
	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	public Integer getPermiso() {
		return permiso;
	}

	public void setPermiso(Integer permiso) {
		this.permiso = permiso;
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
	public String getModificadoPor() {
		return modificadoPor;
	}
	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	public Boolean getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(Boolean semaforo) {
		this.semaforo = semaforo;
	}

//	public String getClaveModulo() {
//		return claveModulo;
//	}
//
//	public void setClaveModulo(String claveModulo) {
//		this.claveModulo = claveModulo;
//	}

}