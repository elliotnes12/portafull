package mx.xpd.cfdi.mvc;

import java.util.List;

import mx.xpd.cfdi.domain.map.MapCatalogoProductoServicio;
import mx.xpd.cfdi.repo.CatalogoClaveProdServDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/rest/catalogoClaveProductoServicio")
public class CatalogoClaveProductoServicioRestController {
	@Autowired
	private CatalogoClaveProdServDao catClaveProductoServicioDao;
	
	@RequestMapping(value="/buscar/{id}", method=RequestMethod.GET)
	public @ResponseBody List<MapCatalogoProductoServicio> buscar(@PathVariable("id") String id){
		return catClaveProductoServicioDao.findAllCatalogoClaveProdServ(id);
	}
}
