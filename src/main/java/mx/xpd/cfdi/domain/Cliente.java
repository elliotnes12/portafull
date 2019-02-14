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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "tenant_id", nullable = false, updatable = false)
	private String tenantId;

	private String clave = "";
	private String claveDes = "";

	private String razonSocial = "";
	private String razonSocialDes = "";

	private String rfc = "";
	private String rfcDes;

	// @NotEmpty
	private String residenciaFiscal = "";

	private String email = "";

	private String usoCFDI;
	private String numRegIdTrib;
	
	private Boolean eliminado;
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean semaforo;

	public Cliente() {
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date());
		this.setUltimaActualizacion(new Date());
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));
		} catch (Exception e) {
			log.warn("tenantId null - Cliente");
		}
	}

	public String getClaveDes() {
		return claveDes;
	}

	public void setClaveDes(String claveDes) {
		this.claveDes = claveDes;
	}

	public String getRazonSocialDes() {
		return razonSocialDes;
	}

	public void setRazonSocialDes(String razonSocialDes) {
		this.razonSocialDes = razonSocialDes;
	}

	public String getRfcDes() {
		return rfcDes;
	}

	public void setRfcDes(String rfcDes) {
		this.rfcDes = rfcDes;
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

	public String getClave() throws LlavePrivadaException {
		if (clave != null) {
			try {
				return SecurityUtil.decryptString(clave);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("No fue posible desencriptar la clave");
				return "";
			}
		} else {
			return clave;
		}
	}

	public void setClave(String clave) throws LlavePrivadaException {
		try {
			this.clave = SecurityUtil.encryptString(clave);
		} catch (Exception e) {
			log.info("no fue posible encriptar la clave");
		}
	}

	public String getResidenciaFiscal() throws LlavePrivadaException {
		if (residenciaFiscal != null) {
			try {
				return SecurityUtil.decryptString(residenciaFiscal);
			} catch (Exception e) {
				log.info("No fue posible desencriptar el pais");
				return "";
			}
		} else {
			return residenciaFiscal;
		}
	}

	public void setResidenciaFiscal(String residenciaFiscal)
			throws LlavePrivadaException {
		try {
			this.residenciaFiscal = SecurityUtil
					.encryptString(residenciaFiscal);
		} catch (Exception e) {
			log.info("no fue posible encriptar el pais");
		}
	}

	public String getRazonSocial() throws LlavePrivadaException {
		if (razonSocial != null) {
			try {
				return SecurityUtil.decryptString(razonSocial);
			} catch (Exception e) {
				log.info("No fue posible desencriptar la razonSocial");
				return "";
			}
		} else {
			return razonSocial;
		}
	}

	public void setRazonSocial(String razonSocial) throws LlavePrivadaException {
		try {
			this.razonSocial = SecurityUtil.encryptString(razonSocial);
		} catch (Exception e) {
			log.info("no fue posible encriptar la razonSocial");
		}
	}

	public String getRfc() throws LlavePrivadaException {
		if (rfc != null) {
			try {
				return SecurityUtil.decryptString(rfc);
			} catch (Exception e) {
				log.info("No fue posible desencriptar el rfc");
				return "";
			}
		} else {
			return rfc;
		}
	}

	public void setRfc(String rfc) throws LlavePrivadaException {
		try {
			this.rfc = SecurityUtil.encryptString(rfc);
		} catch (Exception e) {
			log.info("no fue posible encriptar el rfc");
		}
	}

	public String getEmail() throws LlavePrivadaException {
		if (email != null) {
			try {
				return SecurityUtil.decryptString(email);
			} catch (Exception e) {
				log.info("No fue posible desencriptar el email");
				return "";
			}
		} else {
			return email;
		}
	}

	public void setEmail(String email) throws LlavePrivadaException {
		try {
			this.email = SecurityUtil.encryptString(email);
		} catch (Exception e) {
			log.info("no fue posible encriptar el email");
		}
	}

	public String getUsoCFDI() {
		return usoCFDI;
	}
	public void setUsoCFDI(String usoCFDI) {
		this.usoCFDI = usoCFDI;
	}
	
	public String getNumRegIdTrib() {
		return numRegIdTrib;
	}
	public void setNumRegIdTrib(String numRegIdTrib) {
		this.numRegIdTrib = numRegIdTrib;
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", tenantId=" + tenantId + ", clave="
				+ clave + ", razonSocial=" + razonSocial + ", razonSocialDes="
				+ razonSocialDes + ", rfc=" + rfc + ", rfcDes=" + rfcDes
				+ ", residenciaFiscal=" + residenciaFiscal + ", email=" + email
				+ ", eliminado=" + eliminado + ", fechaRegistro="
				+ fechaRegistro + ", ultimaActualizacion="
				+ ultimaActualizacion + ", semaforo=" + semaforo + "]";
	}

}