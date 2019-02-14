package mx.xpd.cfdi.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Email{
	@Transient
	private Logger log = Logger.getLogger(Email.class);
	
	@Column(name="tenant_id", nullable=false, updatable=false)
	private String tenantId;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotEmpty
	private String emailReceptor;
	
	@NotNull
	@NotEmpty
	private String emailEmisor;
	
	@NotNull
	private String emailReplyTo;
	
	private String asunto;

	private String textoEnviar;
	
	public Email(){
		try {
			this.setTenantId((String) RequestContextHolder
					.currentRequestAttributes().getAttribute("tenantId",
							RequestAttributes.SCOPE_SESSION));			
		} catch (Exception e) {
			log.warn("tenantId null - LugarEmision");
		}
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getEmailReceptor() {
		return emailReceptor;
	}

	public void setEmailReceptor(String emailReceptor) {
		this.emailReceptor = emailReceptor;
	}

	public String getEmailEmisor() {
		return emailEmisor;
	}

	public void setEmailEmisor(String emailEmisor) {
		this.emailEmisor = emailEmisor;
	}
	
	public String getEmailReplyTo() {
		return emailReplyTo;
	}

	public void setEmailReplyTo(String emailReplyTo) {
		this.emailReplyTo = emailReplyTo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTextoEnviar() {
		return textoEnviar;
	}

	public void setTextoEnviar(String textoEnviar) {
		this.textoEnviar = textoEnviar;
	}

	
}