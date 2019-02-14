package mx.xpd.cfdi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Logger;

@Entity
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = "string"))
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id=:tenantId"))
public class CatalogoClaveProdServ{
	@Transient
	private Logger log = Logger.getLogger(CatalogoClaveProdServ.class);
	@Id
	@NotNull
	@NotEmpty
	private String clave;
	
	@NotNull
	@NotEmpty
	private String nombre;

	private String inicioVigencia;
	private String finVigencia;
	private String ivaTrasladado;
	private String iepsTrasladado;
	private String complementoAIncluir;

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
	
	public String getInicioVigencia() {
		return inicioVigencia;
	}
	
	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}
	
	public String getFinVigencia() {
		return finVigencia;
	}

	public void setFinVigencia(String finVigencia) {
		this.finVigencia = finVigencia;
	}
	
	public String getIvaTrasladado() {
		return ivaTrasladado;
	}

	public void setIvaTrasladado(String ivaTrasladado) {
		this.ivaTrasladado = ivaTrasladado;
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

		
}