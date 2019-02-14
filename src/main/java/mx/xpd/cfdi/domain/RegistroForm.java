package mx.xpd.cfdi.domain;

public class RegistroForm {
	
	private String codigoPostal;
	private String delegacionMunicipio;
	private String localidad;
	private String estado;
	private String rfc;
	private String email;
	private String residenciaFiscal;
	private String razonSocial;
	private String foliosDisponibles;
	private String distribuidor;
	private Boolean gratuito;
	private String password;
	private String nomina;
	private Boolean tipoPlan;
	private String fechaVencimiento;
	private String tenant_creador;
	
	
	public String getNomina() {
		return nomina;
	}
	public void setNomina(String nomina) {
		this.nomina = nomina;
	}
	
	public String getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResidenciaFiscal() {
		return residenciaFiscal;
	}
	public void setResidenciaFiscal(String residenciaFiscal) {
		this.residenciaFiscal = residenciaFiscal;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getFoliosDisponibles() {
		return foliosDisponibles;
	}
	public void setFoliosDisponibles(String foliosDisponibles) {
		this.foliosDisponibles = foliosDisponibles;
	}
	public Boolean getGratuito() {
		return gratuito;
	}
	public void setGratuito(Boolean gratuito) {
		this.gratuito = gratuito;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getTipoPlan() {
		return tipoPlan;
	}
	public void setTipoPlan(Boolean tipoPlan) {
		this.tipoPlan = tipoPlan;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTenant_creador() {
		return tenant_creador;
	}
	public void setTenant_creador(String tenant_creador) {
		this.tenant_creador = tenant_creador;
	}

}
