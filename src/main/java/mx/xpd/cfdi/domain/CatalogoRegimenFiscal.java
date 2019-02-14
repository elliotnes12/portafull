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
public class CatalogoRegimenFiscal implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	@Transient
	private Logger log = Logger.getLogger(Usuario.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clave;

	@NotNull
	@NotEmpty
	private String nombre;

	private Boolean fisica;
	private Boolean moral;
	
	private String inicioVigencia;
	private String finVigencia;
	
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

	public Boolean getFisica() {
		return fisica;
	}

	public void setFisica(Boolean fisica) {
		this.fisica = fisica;
	}
	
	public Boolean getMoral() {
		return moral;
	}

	public void setMoral(Boolean moral) {
		this.moral = moral;
	}
	
	public String getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigenciao(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public String getFinVigencia() {
		return finVigencia;
	}

	public void setFinVigencia(String finVigencia) {
		this.finVigencia = finVigencia;
	}

}