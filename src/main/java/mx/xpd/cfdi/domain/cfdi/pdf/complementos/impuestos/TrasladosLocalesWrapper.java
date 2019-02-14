package mx.xpd.cfdi.domain.cfdi.pdf.complementos.impuestos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

public class TrasladosLocalesWrapper {

	private List<TrasladosLocales> trasladosLocales;
	
	
	public TrasladosLocalesWrapper() {
		trasladosLocales = new ArrayList<TrasladosLocales>();
	}
	
	public void setTrasladosLocales(List<TrasladosLocales> trasladosLocales) {
		this.trasladosLocales = trasladosLocales;
	}
	@Transient
	public List<TrasladosLocales> getTrasladosLocales() {
		return trasladosLocales;
	}
	
}
