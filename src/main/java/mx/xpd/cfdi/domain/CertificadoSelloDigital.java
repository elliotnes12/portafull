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
@Table(name = "certificado_sello_digital",uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class CertificadoSelloDigital {
	@Transient
	private Logger log = Logger.getLogger(CertificadoSelloDigital.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column
	private Date ultimaActualizacion;
	@Column(name = "modificado_por")
	private String modificadoPor;
	@NotNull
	private Boolean eliminado;
	@Column
	private Boolean semaforo;
	@Column
	private String tipo;
	
	public CertificadoSelloDigital(){
		this.setUsar(true);
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date());
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - CSD");
		}
	}

	
	
	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	//el getter del jsp recibe una exception y por eso falla
	public String getArchivoKey() throws LlavePrivadaException {
		if (archivoKey != null) {
			try {
				return SecurityUtil.decryptString(archivoKey);
			} catch (Exception e) {
				throw new LlavePrivadaException("No fue posible desencriptar la llave privada");
			}
		} else {
			return archivoKey;
		}
	}
	
	public void setArchivoKey(String archivoKey) throws LlavePrivadaException {
		try {
			this.archivoKey = SecurityUtil.encryptString(archivoKey);
		} catch (Exception e) {
			throw new LlavePrivadaException("no fue posible encriptar la llave privada");
		}
	}
	
	public String getCertificado() throws LlavePrivadaException {
		if (certificado != null) {
			try {
				return SecurityUtil.decryptString(certificado);
			} catch (Exception e) {
				throw new LlavePrivadaException("No fue posible desencriptar la llave privada");
			}
		} else {
			return certificado;
		}
	}
	public void setCertificado(String certificado) throws LlavePrivadaException {
		try {
			this.certificado = SecurityUtil.encryptString(certificado);
		} catch (Exception e) {
			throw new LlavePrivadaException("no fue posible encriptar la llave privada");
		}
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
}