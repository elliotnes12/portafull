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
import javax.validation.constraints.NotNull;

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
@Table
public class CatalogoImpuesto implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	@Transient
	private Logger log = Logger.getLogger(CatalogoImpuesto.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clave;

	@NotNull
	@NotEmpty
	private String descripcion;

	private Boolean retencion;
	private Boolean traslado;
	
	private String localFederal;
	private String entidadAplica;
	
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

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getRetencion() {
		return retencion;
	}

	public void setRetencion(Boolean retencion) {
		this.retencion = retencion;
	}
	
	public Boolean getTraslado() {
		return traslado;
	}

	public void setTraslado(Boolean traslado) {
		this.traslado = traslado;
	}
	
	public String getLocalFederal() {
		return localFederal;
	}

	public void setLocalFederal(String localFederal) {
		this.localFederal = localFederal;
	}

	public String getEntidadAplica() {
		return entidadAplica;
	}

	public void setEntidadAplica(String entidadAplica) {
		this.entidadAplica = entidadAplica;
	}

}