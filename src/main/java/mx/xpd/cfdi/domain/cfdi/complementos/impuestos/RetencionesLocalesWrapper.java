package mx.xpd.cfdi.domain.cfdi.complementos.impuestos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

public class RetencionesLocalesWrapper {

	private List<RetencionesLocales> retencionesLocales;
	
	
	public RetencionesLocalesWrapper() {
		retencionesLocales = new ArrayList<RetencionesLocales>();
	}
	
	public void setRetencionesLocales(List<RetencionesLocales> retencionesLocales) {
		this.retencionesLocales = retencionesLocales;
	}
	@Transient
	public List<RetencionesLocales> getRetencionesLocales() {
		return retencionesLocales;
	}
	
}
