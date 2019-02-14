package mx.xpd.cfdi.mvc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.LugarExpedicion;
import mx.xpd.cfdi.repo.LugarExpedicionDao;
import mx.xpd.cfdi.repo.PaisEstadoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/lugarExpedicion")
public class LugarExpedicionController {
	
	//Logger log = org.slf4j.LoggerFactory.getLogger(LugarEmisionController.class);

	@Autowired
	private LugarExpedicionDao lugarDao;
	@Autowired
	private PaisEstadoDao paisEstadosDao;

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		model.addAttribute("lugar", new LugarExpedicion());
		lugarDao.setTenantId(tenantID);
		model.addAttribute("lugares", lugarDao.findAll());
		model.addAttribute("estados", paisEstadosDao.findAllEstadoMap("MEX"));
		
		String msg = (String)request.getParameter("msg");
		String error = (String)request.getParameter("error");
		if(msg != null && msg.length() > 0) {
			model.addAttribute("msg", msg);
			model.addAttribute("error", error);
		}
		return "lugarExpedicion/mostrar";
	}

	@RequestMapping(value="/agregar", method = RequestMethod.POST)
	public String Agregar( @Valid @ModelAttribute("lugar") LugarExpedicion nuevoLugar, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			nuevoLugar.setDelegacionMunicipio(nuevoLugar.getDelegacionMunicipio().equals("default")?"":nuevoLugar.getDelegacionMunicipio());
			nuevoLugar.setLocalidad(nuevoLugar.getLocalidad().equals("default")?"":nuevoLugar.getLocalidad());
			lugarDao.add(nuevoLugar);
			String msg = "Lugar Expedición guardado correctamente";
			String error = "0";
			String url = "?msg=" + msg + "&error=" + error;
			return "redirect:/lugarExpedicion/" + url;
		}else {
			model.addAttribute("lugares", lugarDao.findAll());
			
			return "lugarExpedicion/mostrar";
		}
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable Long id, Model model) {
		LugarExpedicion lugarExpedicion = lugarDao.findById(id);
		if (lugarExpedicion == null) {
			return "redirect:/lugarExpedicion/";
		}
		
		model.addAttribute("estados", paisEstadosDao.findAllEstadoMap("MEX"));
		model.addAttribute("lugar", lugarExpedicion);
		model.addAttribute("delegacionesMunicipio", paisEstadosDao.findAllMunicipioMap(lugarExpedicion.getEstado()));
		model.addAttribute("localidades", paisEstadosDao.findAllLocalidadMap(lugarExpedicion.getEstado()));
		if (lugarExpedicion.getDelegacionMunicipio() == null){
			model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(lugarExpedicion.getEstado()));
		}
		if (lugarExpedicion.getLocalidad().equals("")){
			model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(lugarExpedicion.getEstado(), lugarExpedicion.getDelegacionMunicipio()));
		}
		else{
			model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(lugarExpedicion.getEstado(), lugarExpedicion.getDelegacionMunicipio(), lugarExpedicion.getLocalidad()));
		}
		
		return "lugarExpedicion/editar";
	}
	
	@RequestMapping(value="/detalle/{id}", method=RequestMethod.GET)
	public String detalle(@PathVariable Long id, Model model) {
		LugarExpedicion lugarExpedicion = lugarDao.findById(id);
		if (lugarExpedicion == null) {
			return "redirect:/lugarExpedicion/";
		}
		
		model.addAttribute("lugar", lugarExpedicion);
		model.addAttribute("estados", paisEstadosDao.findAllEstadoMap("MEX"));
		model.addAttribute("delegacionesMunicipio", paisEstadosDao.findAllMunicipioMap(lugarExpedicion.getEstado()));
		model.addAttribute("localidades", paisEstadosDao.findAllLocalidadMap(lugarExpedicion.getEstado()));
		if (lugarExpedicion.getDelegacionMunicipio() == null){
			model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(lugarExpedicion.getEstado()));
		}
		if (lugarExpedicion.getLocalidad().equals("")){
			model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(lugarExpedicion.getEstado(), lugarExpedicion.getDelegacionMunicipio()));
		}
		else{
			model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(lugarExpedicion.getEstado(), lugarExpedicion.getDelegacionMunicipio(), lugarExpedicion.getLocalidad()));
		}
		
		return "lugarExpedicion/detalle";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("lugar") LugarExpedicion lugarExpedicion, BindingResult result, Model model) {
		lugarExpedicion.setUltimaActualizacion(new Date());
		lugarExpedicion.setDelegacionMunicipio(lugarExpedicion.getDelegacionMunicipio().equals("default")?"":lugarExpedicion.getDelegacionMunicipio());
		lugarExpedicion.setLocalidad(lugarExpedicion.getLocalidad().equals("default")?"":lugarExpedicion.getLocalidad());
		lugarDao.update(lugarExpedicion);
		return "redirect:/lugarExpedicion/";
	}

}
