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
public class CatalogoMoneda{
	@Transient
	private Logger log = Logger.getLogger(CatalogoMoneda.class);
	@Id
	@NotNull
	@NotEmpty
	private String clave;
	
	@NotNull
	@NotEmpty
	private String nombre;

	private int decimales;

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}


	public int getDecimales() {
		return decimales;
	}

	public void setDecimales(int decimales) {
		this.decimales = decimales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

		
}