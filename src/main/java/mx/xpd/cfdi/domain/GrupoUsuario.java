package mx.xpd.cfdi.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

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
public class GrupoUsuario {
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	@NotNull
	private String clave;
	@NotNull
	private String nombre;
	private Date horaInicial;
	private Date horaFinal;
	
	@Transient
	private List<Permiso> permisos;
	
	@Transient
	private String horaInicialJsp;
	@Transient
	private String horaFinalJsp;
	
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean eliminado;
	private Boolean semaforo;
	
	public GrupoUsuario() {
		this.fechaRegistro = new Date();
		this.ultimaActualizacion = new Date();
		this.eliminado = false;
		this.semaforo = false;
//		this.permisos = inicializarPermisos(); //se cambió al controlador donde se puede ocupar dao autowired
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - GrupoU");
		}
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	public GrupoUsuario(List<Permiso> permisos) {
		this();
		this.permisos = permisos;
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
	public Date getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}
	public Date getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
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

	public String getHoraInicialJsp() {
		if (horaInicial != null) {
			horaInicialJsp = formatHora(horaInicial);
		}
		return horaInicialJsp;
	}

	public void setHoraInicialJsp(String horaInicialJsp) {
		this.horaInicialJsp = horaInicialJsp;
	}

	public String getHoraFinalJsp() {
		if (horaFinal != null) {
			horaFinalJsp = formatHora(horaFinal);
		}
		return horaFinalJsp;
	}

	public void setHoraFinalJsp(String horaFinalJsp) {
		this.horaFinalJsp = horaFinalJsp;
	}
	
	private String formatHora(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		return sdf.format(date);
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}
	
//	private List<Permiso> inicializarPermisos() {
//		PermisoDao daoPermiso = new PermisoDaoImpl();
//		return daoPermiso.findAll();
//	}

}