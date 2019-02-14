package mx.xpd.cfdi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CodigoPostal{

	private String cp;
		
	@Id
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	
	
}
