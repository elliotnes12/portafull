package mx.xpd.cfdi.domain.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.util.SecurityUtil;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;

@Entity
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id=:tenantId"))
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class MapEmpleado {

	@Id
	private Long id;
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	@Column(name = "nombre")
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		/*if (name != null) {
			try {
				return SecurityUtil.decryptString(name);
			} catch (Exception e) {
				throw new LlavePrivadaException("No fue posible desencriptar la clave");
			}
		} else {
			return name;
		}*/
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
}
