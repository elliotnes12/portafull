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

import mx.xpd.cfdi.domain.cfdi.Receptor;

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
@Table(name = "cfd_emitido", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class CfdEmitido {
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	private String tipoComprobante;
	private String serie;
	private Integer folio;
	private String formaDePago;
	private Double subTotal;
	private Double total;
	private String fecha;
	private String email;
	private Date fechaDate;
	private String estatus;
	private String folioFiscalOrig;
	private String uuid;
	private String confirmacion;
	private Boolean enviado;
	private String razonSocialReceptor;
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean semaforo;
	private Boolean eliminado;
	@Transient
	private Receptor receptor;
	@Transient
	private Emisor emisor;
	//no se obitene a partir de comprobante
	private Double iva; 
	private Double isr;
	private String rfcReceptor;
	private String json;
	private Integer anio;
	private Date fechaCancelacion;
	//----------------------------	
	
	public CfdEmitido(){
		this.setEliminado(false);
		this.setSemaforo(false);
		this.setFechaRegistro(new Date()); 
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - CfdEmitido");
		}
	}
	
	
	public Double getIsr() {
		return isr;
	}


	public void setIsr(Double isr) {
		this.isr = isr;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getConfirmacion() {
		return confirmacion;
	}
	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
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
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public Integer getFolio() {
		return folio;
	}
	public void setFolio(Integer folio) {
		this.folio = folio;
	}
	public String getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("aaaa-MM-dd'T'hh:mm:ss");
			setFechaDate(sdf.parse(fecha));			
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		this.fecha = fecha;
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
	public Receptor getReceptor() {
		return receptor;
	}
	public void setReceptor(Receptor receptor) {
		this.rfcReceptor = receptor.getRfc();
		this.razonSocialReceptor = receptor.getNombre();
		this.receptor = receptor;
	}
	public Double getIva() {
		return iva;
	}
	public void setIva(Double iva) {
		this.iva = iva;
	}
	public String getRfcReceptor() {
		return this.rfcReceptor;
	}
	public void setRfcReceptor(String rfcReceptor) {
		this.rfcReceptor = rfcReceptor;
	}
	public String getFolioFiscalOrig() {
		return folioFiscalOrig;
	}
	public void setFolioFiscalOrig(String folioFiscalOrig) {
		this.folioFiscalOrig = folioFiscalOrig;
	}
	public Date getFechaDate() {
		return fechaDate;
	}
	public void setFechaDate(Date fechaDate) {
		this.fechaDate = fechaDate;
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
	
	public Integer getAnio() {
		return anio;
	}


	public void setAnio(Integer anio) {
		this.anio = anio;
	}


	public Date getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(Date fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}
	
}
