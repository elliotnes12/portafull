package mx.xpd.cfdi.domain.prefactura;

import java.io.Serializable;

public class CfdiRelacionado implements Serializable {

	private static final long serialVersionUID = -7930911774926475600L;
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
