package mx.xpd.cfdi.mvc;

import mx.xpd.cfdi.repo.MonedaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/moneda")
public class MonedaRestController {

	@Autowired
	private MonedaDao monedaDao;

	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.GET)
    public @ResponseBody boolean eliminar(@PathVariable("id") Long id) {
		return monedaDao.remove(id);
    }
	
	/*@RequestMapping(value="/listar/id", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MapGrupoUsuario> listarById() {
		// return daoUsuarios.findAllMap();
		return null;
    }*/
	
	@RequestMapping(value="/existe/{clave}", method=RequestMethod.GET)
    public @ResponseBody Boolean existe(@PathVariable("clave") String clave) {
		if (monedaDao.findByClave(clave) != null) {
			return true;
		} 
		return false;
	}
}
