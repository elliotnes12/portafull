package mx.xpd.cfdi.mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import mx.xpd.cfdi.domain.CatalogoRegimenFiscal;
import mx.xpd.cfdi.domain.LugarExpedicion;
import mx.xpd.cfdi.repo.CatalogoRegimenFiscalDao;
import mx.xpd.cfdi.repo.LugarExpedicionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Component
@ManagedBean(eager = true, name = "listar")
@ViewScoped
public class ComboListar extends SpringBeanAutowiringSupport {

	private static final long serialVersionUID = 1L;
	private String selectedItem;
	@Autowired
	private LugarExpedicionDao lugarDao;
	
	@Autowired
	private CatalogoRegimenFiscalDao catalogoRegimenFiscalDao;

	public List<SelectItem> getListRegimen() {

		List<SelectItem> items = new ArrayList<SelectItem>();


		if(lugarDao != null)
		{
			for(CatalogoRegimenFiscal regimen:catalogoRegimenFiscalDao.findAll()) {
				items.add(new SelectItem(regimen.getNombre()));
			}
		}
         
		
		return items;

	}
	
	public List<SelectItem> getListLocalizaciones() {

		List<SelectItem> items = new ArrayList<SelectItem>();


		if(lugarDao != null)
		{
			for(LugarExpedicion lugar:lugarDao.findAll()) {
				items.add(new SelectItem(lugar.getNombre()));
			}
		}
         
		
		return items;

	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}


}
