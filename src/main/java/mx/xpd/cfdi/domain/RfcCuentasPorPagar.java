package mx.xpd.cfdi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="rfc_cuentas_por_pagar",uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class RfcCuentasPorPagar implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="rfc")
	private String rfc;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name="pais")
	private String pais;
	
	@Column(name="aprovisionado")
	private String aprovisionado;
	
	@Column(name="correo")
	private String correo;

	public RfcCuentasPorPagar(){}
	
	public RfcCuentasPorPagar(String rfc, String razonSocial, String pais,
			String aprovisionado, String correo) {
		super();
		this.rfc = rfc;
		this.razonSocial = razonSocial;
		this.pais = pais;
		this.aprovisionado = aprovisionado;
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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
	
}

