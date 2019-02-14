package mx.xpd.cfdi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class AuditoriaProductoServicio {
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
	@Size(min = 1, max = 15)
	private String clave;

	@NotNull
	@NotEmpty
	private String nombre;

	@NotNull
	@NotEmpty
	@Column(name = "codigo_moneda")
	private String codigoMoneda;

	@NotNull
	@Digits(fraction = 4, integer = 13)
	@Column(name = "precio_unitario")
	private Double precioUnitario;

	@Column(name = "iva_exento")
	private Boolean ivaExento;

	@Digits(fraction = 4, integer = 11)
	@Column(name = "tasa_iva")
	private Double tasaIva;

	@Column
	private String comentario;
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	@Column(name = "modificado_por")
	private String modificadoPor;
	@Column
	private Boolean eliminado;
	@Column
	private Boolean semaforo;
	private String triggerActivadoPor;
	private String accionRealizada;
	
	public Long getIdAuditoria() {
		return idAuditoria;
	}

	public void setIdAuditoria(Long idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public AuditoriaProductoServicio(){
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date()); 
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - AuditProd");
		}
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public Boolean getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Boolean semaforo) {
		this.semaforo = semaforo;
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

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Boolean getIvaExento() {
		return ivaExento;
	}

	public void setIvaExento(Boolean ivaExento) {
		this.ivaExento = ivaExento;
	}

	public Double getTasaIva() {
		return tasaIva;
	}

	public void setTasaIva(Double tasaIva) {
		this.tasaIva = tasaIva;
	}

	public String getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
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
