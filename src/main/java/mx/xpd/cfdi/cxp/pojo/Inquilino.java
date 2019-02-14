package mx.xpd.cfdi.cxp.pojo;

public class Inquilino {

	private String razon_social;
	private String pais;
	private String rfc;
	private String aprovisionado;
	private String correo;
	
	public Inquilino(String razon_social, String pais, String rfc, String aprovisionado, String correo){
		this.razon_social = razon_social;
		this.pais = pais;
		this.rfc = rfc;
		this.aprovisionado = aprovisionado;
		this.correo = correo;
	}
	
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getAprovisionado() {
		return aprovisionado;
	}
	public void setAprovisionado(String aprovisionado) {
		this.aprovisionado = aprovisionado;
	}	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void print(){
		System.out.println(" -- Inquilino --");
		System.out.println("razon_social: "+razon_social);
		System.out.println("pais: "+pais);
		System.out.println("rfc: "+rfc);
		System.out.println("aprovisionado: "+aprovisionado);	
		System.out.println("correo: "+correo);
	}
	
}
