package mx.xpd.cfdi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.util.SecurityUtil;

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
public class Usuario {
	
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	
//	private Logger log = Logger.getLogger(Usuario.class);
	
	private String clave;
	private String password;
	private String nombre;
	private Long grupo;
	private String codigoPostal;
	private String municipio;
	private String estado;
	private String email;
	private String comentarios;
	
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean eliminado;
	private Boolean semaforo;
	private Boolean bloqueado;
	private Integer intentos;
	private Date fechaIntento;
	private Date bloqueoHasta;
	private Date ultimoAcceso;
	private Date ultimoCambioPassword;
	private String password2;
	private String password3;
	private String codigoRescate;
	private Date vigenciaCodigoRescate;
		
	public Usuario() {
		this.fechaRegistro = new Date();
		this.ultimaActualizacion = new Date();
		this.fechaIntento = new Date();
		this.bloqueoHasta = new Date();
		this.ultimoAcceso = new Date();
		this.ultimoCambioPassword = new Date();
		this.password2 = "";
		this.password3 = "";
		this.intentos = 0;
		this.bloqueado = false;
		this.eliminado = false;
		this.semaforo = false;
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			// log.warn("tenantId null - Unidad");
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
	public String getPassword() throws LlavePrivadaException{
		if (password != null) {
			try {
				return SecurityUtil.decryptString(password);
			} catch (Exception e) {
				e.printStackTrace();
				throw new LlavePrivadaException("No fue posible desencriptar el password");
			}
		} else {
		return password;
		}

		//return password;
	}
	public void setPassword(String password) throws LlavePrivadaException{
		try {
			this.password = SecurityUtil.encryptString(password);
		} catch (Exception e) {
			throw new LlavePrivadaException("no fue posible encriptar el password");
		}
		// this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getGrupo() {
		return grupo;
	}
	public void setGrupo(Long grupo) {
		this.grupo = grupo;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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


	public Boolean getBloqueado() {
		return bloqueado;
	}
	
	public Boolean isBloqueado() {
		return bloqueado;
	}


	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}


	public Integer getIntentos() {
		return intentos;
	}


	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}


	public Date getFechaIntento() {
		return fechaIntento;
	}


	public void setFechaIntento(Date fechaIntento) {
		this.fechaIntento = fechaIntento;
	}


	public Date getBloqueoHasta() {
		return bloqueoHasta;
	}


	public void setBloqueoHasta(Date bloqueoHasta) {
		this.bloqueoHasta = bloqueoHasta;
	}


	public Date getUltimoAcceso() {
		return ultimoAcceso;
	}


	public void setUltimoAcceso(Date ultimoAcceso) {
		this.ultimoAcceso = ultimoAcceso;
	}


	public Date getUltimoCambioPassword() {
		return ultimoCambioPassword;
	}


	public void setUltimoCambioPassword(Date ultimoCambioPassword) {
		this.ultimoCambioPassword = ultimoCambioPassword;
	}

	public String getPassword2() throws LlavePrivadaException{
		if (password2 != null) {
			try {
				return SecurityUtil.decryptString(password2);
			} catch (Exception e) {
				throw new LlavePrivadaException("No fue posible desencriptar el password");
			}
		} else {
		return password2;
		}
		//return password2;
	}

	public void setPassword2(String password2) throws LlavePrivadaException{
		try {
			this.password2 = SecurityUtil.encryptString(password2);
		} catch (Exception e) {
			throw new LlavePrivadaException("no fue posible encriptar el password");
		}
		//this.password2 = password2;
	}

	public String getPassword3() throws LlavePrivadaException{
		if (password3 != null) {
			try {
				return SecurityUtil.decryptString(password3);
			} catch (Exception e) {
				throw new LlavePrivadaException("No fue posible desencriptar el password");
			}
		} else {
		return password3;
		}
		//return password3;
	}

	public void setPassword3(String password3) throws LlavePrivadaException{
		try {
			this.password3 = SecurityUtil.encryptString(password3);
		} catch (Exception e) {
			throw new LlavePrivadaException("no fue posible encriptar el password");
		}
		//this.password3 = password3;
	}
	
	public String getCodigoRescate() {
		return codigoRescate;
	}

	public void setCodigoRescate(String codigoRescate) {
		this.codigoRescate = codigoRescate;
	}
	
	public Date getVigenciaCodigoRescate() {
		return vigenciaCodigoRescate;
	}


	public void setVigenciaCodigoRescate(Date vigenciaCodigoRescate) {
		this.vigenciaCodigoRescate = vigenciaCodigoRescate;
	}
	
}
