package mx.xpd.cfdi.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import mx.xpd.cfdi.domain.retenciones.EmisorRetenciones;
import mx.xpd.cfdi.domain.retenciones.pdf.ReceptorRetenciones;

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
@Table(name = "retenciones_emitido", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class RetencionesEmitido {
	@Transient
	private Logger log = Logger.getLogger(RetencionesEmitido.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	private Integer folio;
	private String estatus;
	private String uuid;
	private Boolean enviado;
	private String razonSocialReceptor;
	private String ejercicio;
	private Double montoTotalOperacion;
	private Double montoTotalRetenciones;
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean semaforo;
	private Boolean eliminado;
	private String email;
	@Transient
	private ReceptorRetenciones receptor;
	@Transient
	private EmisorRetenciones emisor;
	private String json;
	private Date fechaCancelacion;
	//----------------------------	
	
	public RetencionesEmitido(){
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date()); 
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - RetencionesEmitido");
		}
	}
	
	
	
	
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public Boolean getEnviado() {
		return enviado;
	}
	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
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
	public Boolean getEliminado() {
		return eliminado;
	}
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}
	public ReceptorRetenciones getReceptor() {
		return receptor;
	}
	public void setReceptor(ReceptorRetenciones receptor) {
		if (receptor.getNacionalidad().equals("Nacional"))
			this.razonSocialReceptor = receptor.getReceptorNacional().getNomDenRazSocR();
		if (receptor.getNacionalidad().equals("Extranjero"))
			this.razonSocialReceptor = receptor.getReceptorExtranjero().getNomDenRazSocREx();
		this.receptor = receptor;
	}
	
	public EmisorRetenciones getEmisor() {
		return emisor;
	}
	public void setEmisor(EmisorRetenciones emisor) {
		this.emisor = emisor;
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getRazonSocialReceptor() {
		return razonSocialReceptor;
	}

	public void setRazonSocialReceptor(String razonSocialReceptor) {
		this.razonSocialReceptor = razonSocialReceptor;
	}
	
	public String getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	
	public Double getMontoTotalOperacion() {
		return montoTotalOperacion;
	}

	public void setMontoTotalOperacion(Double montoTotalOperacion) {
		this.montoTotalOperacion = montoTotalOperacion;
	}
	
	public Double getMontoTotalRetenciones() {
		return montoTotalRetenciones;
	}

	public void setMontoTotalRetenciones(Double montoTotalRetenciones) {
		this.montoTotalRetenciones = montoTotalRetenciones;
	}
	
	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	
}
