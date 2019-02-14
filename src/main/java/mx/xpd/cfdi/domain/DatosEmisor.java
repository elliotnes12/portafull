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
import org.hibernate.validator.constraints.Email;
import org.jboss.logging.Logger;

@Entity
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = "string"))
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id=:tenantId"))
@Table
public class DatosEmisor implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	private String razonSocial;
	private String rfc;
	private String codigoPostal;
	private String delegacionMunicipio;
	private String estado;
	private String localidad;
	private String distribuidor;
	private String pTimbrado;
		
	private Integer distribuidorID;
	private String ultimaCompra;
	
	private Integer foliosDisponibles;
	private Boolean gratuito;
	private Boolean productivo;
			
	private String email;
	private String logo;
	private Integer paso;
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean eliminado;
	private Boolean semaforo;
	
	private String fechaVencimiento;
	private Boolean tipoPlan;
	
	private String regimenFiscal;

	public DatosEmisor() {
		this.fechaRegistro = new Date();
		this.ultimaActualizacion = new Date();
		this.setEliminado(false);
		this.setSemaforo(false);
		this.paso = 1;
	}
	
	public String getpTimbrado() {
		return pTimbrado;
	}

	public void setpTimbrado(String pTimbrado) {
		this.pTimbrado = pTimbrado;
	}

	public Integer getDistribuidorID() {
		return distribuidorID;
	}

	public void setDistribuidorID(Integer distribuidorID) {
		this.distribuidorID = distribuidorID;
	}

	public String getUltimaCompra() {
		return ultimaCompra;
	}

	public void setUltimaCompra(String ultimaCompra) {
		this.ultimaCompra = ultimaCompra;
	}

	public String getDistribuidor() {
		return distribuidor;
	}
	
	public void setDistribuidor(String ditribuidor) {
		this.distribuidor = ditribuidor;
	}
	
	public Boolean getProductivo() {
		return productivo;
	}
	
	public Boolean isProductivo() {
		return productivo;
	}
	
	public void setProductivo(Boolean productivo) {
		this.productivo = productivo;
	}
	
	public Boolean getGratuito() {
		return gratuito;
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

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRfc() {
		return rfc.trim();
	}
	
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}

	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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


	public Integer getFoliosDisponibles() {
		return foliosDisponibles;
	}

	public void setFoliosDisponibles(Integer foliosDisponibles) {
		this.foliosDisponibles = foliosDisponibles;
	}

	public Integer getPaso() {
		return paso;
	}

	public void setPaso(Integer paso) {
		this.paso = paso;
	}

	public Boolean isGratuito() {
		return gratuito;
	}

	public void setGratuito(Boolean gratuito) {
		this.gratuito = gratuito;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public Boolean getTipoPlan() {
		return tipoPlan;
	}


	public void setTipoPlan(Boolean tipoPlan) {
		this.tipoPlan = tipoPlan;
	}

	public String getRegimenFiscal() {
		return regimenFiscal;
	}

	public void setRegimenFiscal(String regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}

	@Override
	public String toString() {
		return "DatosEmisor [log=" + log + ", id=" + id + ", tenantId="
				+ tenantId + ", razonSocial=" + razonSocial + ", rfc=" + rfc
				+ ", codigoPostal=" + codigoPostal
				+ ", delegacionMunicipio=" + delegacionMunicipio + ", estado=" + estado
				+ ", foliosDisponibles=" + foliosDisponibles 
				+ ", gratuito=" + gratuito + ", email="	+ email 
				+ ", logo=" + logo + ", fechaRegistro=" + fechaRegistro 
				+ ", ultimaActualizacion=" + ultimaActualizacion + ", eliminado=" + eliminado
				+ ", semaforo=" + semaforo + "]";
	}
	
	
	
}