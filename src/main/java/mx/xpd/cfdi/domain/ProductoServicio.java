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
@Table(name = "producto_servicio", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class ProductoServicio {
	@Transient
	private Logger log = Logger.getLogger(ProductoServicio.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;

	@Column
	private String clave;
	
	@Size(min = 1, max = 15)
	private String claveProdServ;

	@NotNull
	@NotEmpty
	private String nombre;


//	@NotNull
//	@NotEmpty
	@Column(name = "codigo_moneda")
	private String codigoMoneda;

	@NotNull
	@Digits(fraction = 6, integer = 15)
	@Column(name = "precio_unitario")
	private Double precioUnitario;

	@Column(name = "iva_exento")
	private Boolean ivaExento;

	@Digits(fraction = 6, integer = 11)
	@Column(name = "tasa_iva")
	private Double tasaIva;

	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	@Column(name = "modificado_por")
	private String modificadoPor;
	@Column
	private Boolean eliminado;
	@Column
	private Boolean semaforo;
	@Column(name = "iepsTrasladado") 
	private String iepsTrasladado;
	@Column
	private String complementoAIncluir;
	@Column 
	private String claveUnidad;
	@Column 
	private String unidad;
	

	
	

	public ProductoServicio(){
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date()); // es correcto poner esto en el constructor?
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - producto");
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

	public String getClaveProdServ() {
		return claveProdServ;
	}

	public void setClaveProdServ(String claveProdServ) {
		this.claveProdServ = claveProdServ;
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
	
	public String getClaveUnidad() {
		return claveUnidad;
	}

	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
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
	
	public String getIepsTrasladado() {
		return iepsTrasladado;
	}

	public void setIepsTrasladado(String iepsTrasladado) {
		this.iepsTrasladado = iepsTrasladado;
	}

	public String getComplementoAIncluir() {
		return complementoAIncluir;
	}

	public void setComplementoAIncluir(String complementoAIncluir) {
		this.complementoAIncluir = complementoAIncluir;
	}
	
	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}