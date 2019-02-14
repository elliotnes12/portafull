package mx.xpd.cfdi.domain.prefactura;

public class ResponsePrefactura {

	private String xml;
	private String mensaje;
	private String emisorRfc;

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEmisorRfc() {
		return emisorRfc;
	}

	public void setEmisorRfc(String emisorRfc) {
		this.emisorRfc = emisorRfc;
	}
	

}
