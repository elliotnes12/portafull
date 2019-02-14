package mx.xpd.cfdi.domain.prefactura;

import java.io.Serializable;

public class ValidadorXml implements Serializable {

	private static final long serialVersionUID = -3221994097274982607L;

	private String mensaje;
	private boolean correcto;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

}
