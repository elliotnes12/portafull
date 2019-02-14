package mx.xpd.cfdi.mvc;

import java.util.List;

import mx.xpd.cfdi.domain.GrupoUsuario;
import mx.xpd.cfdi.domain.map.MapGrupoUsuario;
import mx.xpd.cfdi.repo.GrupoUsuarioDao;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/grupoUsuario") 
public class GrupoUsuarioRestController {
	
	@Autowired
	private GrupoUsuarioDao daoGrupoUsuarios;
	private org.jboss.logging.Logger log = Logger.getLogger(GrupoUsuarioRestController.class);

	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.GET)
    public @ResponseBody Boolean eliminar(@PathVariable("id") Long id) {
		GrupoUsuario grupoUsuario =  daoGrupoUsuarios.findById(id);
		if (grupoUsuario.getClave().equals("admin")) {
			log.info("No es posible modificar los permisos para el grupo \"admin\"");
			return false;
		}
		return daoGrupoUsuarios.remove(id);
    }
	
	@RequestMapping(value="/listar/id", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MapGrupoUsuario> listarById() {
		 return daoGrupoUsuarios.findAllMap();
    }
	
	@RequestMapping(value="/existe/{clave}", method=RequestMethod.GET)
    public @ResponseBody Boolean existe(@PathVariable("clave") String clave) {
		if (daoGrupoUsuarios.findByClave(clave) != null) {
			return true;
		} 
		return false;
    }
	
}
