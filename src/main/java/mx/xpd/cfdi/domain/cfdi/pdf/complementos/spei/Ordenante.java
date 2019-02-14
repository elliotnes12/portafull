package mx.xpd.cfdi.domain.cfdi.pdf.complementos.spei;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "Ordenante")
public class Ordenante{

	private String bancoOrdenante;
	private String nombreOrdenanteSpei;
	private String tipoCuentaOrdenanteSpei;
	private String cuentaOrdenanteSpei;
	private String rfcOrdenanteSpei;
	
	
	public Ordenante() {
		
	}
	
	@XmlAttribute(name = "BancoEmisor")
	public String getBancoOrdenante() {
		return bancoOrdenante;
	}

	public void setBancoOrdenante(String bancoOrdenante) {
		this.bancoOrdenante = bancoOrdenante;
	}
	
	@XmlAttribute(name = "Nombre")
	public String getNombreOrdenanteSpei() {
		return nombreOrdenanteSpei;
	}

	public void setNombreOrdenanteSpei(String nombreOrdenanteSpei) {
		this.nombreOrdenanteSpei = nombreOrdenanteSpei;
	}
	
	@XmlAttribute(name = "TipoCuenta")
	public String getTipoCuentaOrdenanteSpei() {
		return tipoCuentaOrdenanteSpei;
	}

	public void setTipoCuentaOrdenanteSpei(String tipoCuentaOrdenanteSpei) {
		this.tipoCuentaOrdenanteSpei = tipoCuentaOrdenanteSpei;
	}
	
	@XmlAttribute(name = "Cuenta")
	public String getCuentaOrdenanteSpei() {
		return cuentaOrdenanteSpei;
	}

	public void setCuentaOrdenanteSpei(String cuentaOrdenanteSpei) {
		this.cuentaOrdenanteSpei = cuentaOrdenanteSpei;
	}
	
	@XmlAttribute(name = "RFC")
	public String getRfcOrdenanteSpei() {
		return rfcOrdenanteSpei;
	}

	public void setRfcOrdenanteSpei(String rfcOrdenanteSpei) {
		this.rfcOrdenanteSpei = rfcOrdenanteSpei;
	}
		
}