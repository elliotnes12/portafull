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
public class CatalogoFormaPago implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;
	@Transient
	private Logger log = Logger.getLogger(CatalogoFormaPago.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clave;

	@NotNull
	@NotEmpty
	private String descripcion;

	private String bancarizado;
	private String numOperacion;
	
	private String rfcEmisorOrdenante;
	private String cuentaOrdenante;
	private String patronCuentaOrdenante;
	private String rfcEmisorBeneficiario;
	private String cuentaBeneficiario;
	private String patronCuentaBeneficario;
	private String tipoCadenaPago;
	private String nombreBancoEmisor;
	
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

	public String getBancarizado() {
		return bancarizado;
	}

	public void setBancarizado(String bancarizado) {
		this.bancarizado = bancarizado;
	}

	public String getRfcEmisorOrdenante() {
		return rfcEmisorOrdenante;
	}

	public void setRfcEmisorOrdenante(String rfcEmisorOrdenante) {
		this.rfcEmisorOrdenante = rfcEmisorOrdenante;
	}

	public String getCuentaOrdenante() {
		return cuentaOrdenante;
	}

	public void setCuentaOrdenante(String cuentaOrdenante) {
		this.cuentaOrdenante = cuentaOrdenante;
	}

	public String getPatronCuentaOrdenante() {
		return patronCuentaOrdenante;
	}

	public void setPatronCuentaOrdenante(String patronCuentaOrdenante) {
		this.patronCuentaOrdenante = patronCuentaOrdenante;
	}

	public String getRfcEmisorBeneficiario() {
		return rfcEmisorBeneficiario;
	}

	public void setRfcEmisorBeneficiario(String rfcEmisorBeneficiario) {
		this.rfcEmisorBeneficiario = rfcEmisorBeneficiario;
	}

	public String getCuentaBeneficiario() {
		return cuentaBeneficiario;
	}

	public void setCuentaBeneficiario(String cuentaBeneficiario) {
		this.cuentaBeneficiario = cuentaBeneficiario;
	}

	public String getPatronCuentaBeneficario() {
		return patronCuentaBeneficario;
	}

	public void setPatronCuentaBeneficario(String patronCuentaBeneficario) {
		this.patronCuentaBeneficario = patronCuentaBeneficario;
	}

	public String getTipoCadenaPago() {
		return tipoCadenaPago;
	}

	public void setTipoCadenaPago(String tipoCadenaPago) {
		this.tipoCadenaPago = tipoCadenaPago;
	}

	public String getNombreBancoEmisor() {
		return nombreBancoEmisor;
	}

	public void setNombreBancoEmisor(String nombreBancoEmisor) {
		this.nombreBancoEmisor = nombreBancoEmisor;
	}

	

}