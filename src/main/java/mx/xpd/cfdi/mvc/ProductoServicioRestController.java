package mx.xpd.cfdi.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.ProductoServicio;
import mx.xpd.cfdi.domain.map.MapProductoServicio;
import mx.xpd.cfdi.repo.ProductoServicioDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/productoServicio")
public class ProductoServicioRestController {
	
	@Autowired
	private ProductoServicioDao productoDao;
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public @ResponseBody Boolean eliminar(@PathVariable("id") Long id) {
		Boolean valor = productoDao.remove(id);
		return valor;
	}
	
	@RequestMapping(value="/find/{id}", method=RequestMethod.GET, produces = "application/json")
	public @ResponseBody ProductoServicio findById(@PathVariable("id") Long id) {
		return productoDao.findById(id);
    }
	
	@RequestMapping(value="/listarAll/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ProductoServicio> listarAll(@PathVariable("id")String id, HttpServletRequest request) {
		return productoDao.findAll(id);
    }
	
	
	@RequestMapping(value="/listar/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MapProductoServicio> listarById(@PathVariable("id")String id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		productoDao.setTenantId(tenantID);
		return productoDao.findAllMap(id);
    }
	
	@RequestMapping(value="/findByClave/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MapProductoServicio> findByClave(@PathVariable("id")String id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		productoDao.setTenantId(tenantID);
		return productoDao.findAllMapByClave(id);
    }
	
	@RequestMapping(value = "/existe/{clave}", method = RequestMethod.GET)
	public @ResponseBody Boolean existe(@PathVariable("clave")String clave) {
		if (productoDao.findByClave(clave) != null ) {
			return true;
		}
		return false;
	}

}
