package mx.xpd.cfdi.domain.cfdi;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class CfdiRelacionado {
	
	private String uuid;
			
	public CfdiRelacionado() {
	
	}
		
	@XmlAttribute(name = "UUID")
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
		
	@Override
	public String toString() {
		return "CfdiRelacionado [uuid=" + uuid + "]";
	}
	
}