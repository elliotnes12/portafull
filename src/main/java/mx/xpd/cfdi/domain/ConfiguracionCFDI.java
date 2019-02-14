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
@Table
public class ConfiguracionCFDI implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	private String serie;
	private String lugarDeExpedicion;
	private String metodoDePago;
	private String formaPago;
	private String moneda;
	private String tipoCambio;
	private Boolean usarDescuento; 
	private Boolean usarClave;
	private String unidadMedida;
	private double iva;
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean eliminado;
	private Boolean semaforo;
	private String emailConfig;
	private int numeroDecimales;
	private Boolean guardarProductos;
	private Boolean descuentoPorcentaje;
	private String tipoComprobante;
	private String complementosConfig;
	
	public String getComplementosConfig() {
		return complementosConfig;
	}

	public void setComplementosConfig(String complementosConfig) {
		this.complementosConfig = complementosConfig;
	}

	public ConfiguracionCFDI() {
		this.fechaRegistro = new Date();
		this.ultimaActualizacion = new Date();
		this.setEliminado(false);
		this.setSemaforo(false);
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - ConfigCfdi");
		}
		numeroDecimales = 2;
	}
 	
	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public Boolean getDescuentoPorcentaje() {
		return descuentoPorcentaje;
	}

	public void setDescuentoPorcentaje(Boolean descuentoPorcentaje) {
		this.descuentoPorcentaje = descuentoPorcentaje;
	}

	public Boolean getGuardarProductos() {
		return guardarProductos; 
	}

	public void setGuardarProductos(Boolean guardarProductos) {
		this.guardarProductos = guardarProductos;
	}

	public String getTenantId() {
		return tenantId;
	}

	public int getNumeroDecimales() {
		return numeroDecimales;
	}

	public void setNumeroDecimales(int numeroDecimales) {
		this.numeroDecimales = numeroDecimales;
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

	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getLugarDeExpedicion() {
		return lugarDeExpedicion;
	}
	public void setLugarDeExpedicion(String lugarDeExpedicion) {
		this.lugarDeExpedicion = lugarDeExpedicion;
	}
	public String getMetodoDePago() {
		return metodoDePago;
	}
	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}
	public String getFormaPago() {
		return formaPago;
	}
	

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String  getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(String  tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
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
	public Boolean getUsarDescuento() {
		return usarDescuento;
	}
	public void setUsarDescuento(Boolean usarDescuento) {
		this.usarDescuento = usarDescuento;
	}
	public Boolean getUsarClave() {
		return usarClave;
	}
	public void setUsarClave(Boolean usarClave) {
		this.usarClave = usarClave;
	}
	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getEmailConfig() {
		return emailConfig;
	}

	public void setEmailConfig(String emailConfig) {
		this.emailConfig = emailConfig;
	}

	}