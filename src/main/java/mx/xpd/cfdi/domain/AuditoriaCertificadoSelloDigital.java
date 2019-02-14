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
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Entity
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = "string"))
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id=:tenantId"))
public class AuditoriaCertificadoSelloDigital {
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue
	private Long idAuditoria;
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	@Transient
	private String contrasena;
	@NotNull
	@NotEmpty
	@Column(length = 10000)
	private String archivoKey;
	@NotNull
	@NotEmpty
	@Column(length = 10000)
	private String certificado;
	@Column(name = "nombre_archivo_cer")
	private String nombreArchivoCer;
	@Column(name = "nombre_archivo_key")
	private String nombreArchivoKey;
	@NotNull
	@NotEmpty
	private String  noSerie;
	@NotNull
	private Date  fechaInicio;
	@NotNull
	private Date fechaFin;
	@NotNull
	private Boolean usar;
	private String comentario;
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	@Column(name = "modificado_por")
	private String modificadoPor;
	@NotNull
	private Boolean eliminado;
	private Boolean semaforo;
	private String triggerActivadoPor;
	private String accionRealizada;
	
	public AuditoriaCertificadoSelloDigital(){
		setUsar(true);
		setFechaRegistro(new Date());
		setEliminado(false);
		setSemaforo(false);
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - auditCertificado");
		}
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	public Long getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(Long idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getArchivoKey() {
		return archivoKey;
	}
	public void setArchivoKey(String archivoKey) {
		this.archivoKey = archivoKey;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	/*
	public byte getContenidoArchivoKey() {
		return contenidoArchivoKey;
	}
	public void setContenidoArchivoKey(byte contenidoArchivoKey) {
		this.contenidoArchivoKey = contenidoArchivoKey;
	}
	public byte getContenidoArchivoCer() {
		return contenidoArchivoCer;
	}
	public void setContenidoArchivoCer(byte contenidoArchivoCer) {
		this.contenidoArchivoCer = contenidoArchivoCer;
	}
	public byte getHashArchivoKey() {
		return hashArchivoKey;
	}
	public void setHashArchivoKey(byte hashArchivoKey) {
		this.hashArchivoKey = hashArchivoKey;
	}
	public byte getHashArchivoCer() {
		return hashArchivoCer;
	}
	public void setHashArchivoCer(byte hashArchivoCer) {
		this.hashArchivoCer = hashArchivoCer;
	}
	*/
	public String getNoSerie() {
		return noSerie;
	}
	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Boolean getUsar() {
		return usar;
	}
	public void setUsar(Boolean usar) {
		this.usar = usar;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}
	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	public String getNombreArchivoCer() {
		return nombreArchivoCer;
	}
	public void setNombreArchivoCer(String nombreArchivoCer) {
		this.nombreArchivoCer = nombreArchivoCer;
	}
	public String getNombreArchivoKey() {
		return nombreArchivoKey;
	}
	public void setNombreArchivoKey(String nombreArchivoKey) {
		this.nombreArchivoKey = nombreArchivoKey;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
