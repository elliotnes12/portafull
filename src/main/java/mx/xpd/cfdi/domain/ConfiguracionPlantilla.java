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
public class ConfiguracionPlantilla implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	private int factura = 1;
	private int notaCredito = 1;
	private int notaCargo = 1;
	private int reciboHonorarios = 1; 
	private int reciboArrendamiento = 1;
	private int reciboDonativos = 1;
	private int cartaPorte = 1;
	private int nomina = 200;
	
	
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean eliminado;
	private Boolean semaforo;
	
	public ConfiguracionPlantilla(){
		this.fechaRegistro = new Date();
		this.ultimaActualizacion = new Date();
		this.setEliminado(false);
		this.setSemaforo(false);
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - Plantilla");
		}
	}

	
	
	public int getNomina() {
		return nomina;
	}



	public void setNomina(int nomina) {
		this.nomina = nomina;
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
	public int getFactura() {
		return factura;
	}
	public void setFactura(int factura) {
		this.factura = factura;
	}
	public int getNotaCredito() {
		return notaCredito;
	}
	public void setNotaCredito(int notaCredito) {
		this.notaCredito = notaCredito;
	}
	public int getNotaCargo() {
		return notaCargo;
	}
	public void setNotaCargo(int notaCargo) {
		this.notaCargo = notaCargo;
	}
	public int getReciboHonorarios() {
		return reciboHonorarios;
	}
	public void setReciboHonorarios(int reciboHonorarios) {
		this.reciboHonorarios = reciboHonorarios;
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

	public int getReciboArrendamiento() {
		return reciboArrendamiento;
	}

	public void setReciboArrendamiento(int reciboArrendamiento) {
		this.reciboArrendamiento = reciboArrendamiento;
	}

	public int getReciboDonativos() {
		return reciboDonativos;
	}

	public void setReciboDonativos(int reciboDonativos) {
		this.reciboDonativos = reciboDonativos;
	}

	public int getCartaPorte() {
		return cartaPorte;
	}

	public void setCartaPorte(int cartaPorte) {
		this.cartaPorte = cartaPorte;
	}
	
	
}