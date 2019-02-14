package mx.xpd.cfdi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.ConfiguracionPlantilla;
import mx.xpd.cfdi.repo.PlantillaDao;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/plantilla")
public class PlantillaController {
	@Autowired
	private PlantillaDao plantillaDao;
	
	private static final Logger log = Logger.getLogger("PlantillaController");

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		plantillaDao.setTenantId(tenantID);
		ConfiguracionPlantilla plantilla = plantillaDao.find(); 
		plantillaDao.setTenantId(tenantID);
		model.addAttribute("plantillas", plantillaDao.findAllPlantillas());
		String msg = (String)request.getParameter("msg");
		model.addAttribute("msg", msg);
		if(plantilla != null){
			model.addAttribute("plantilla", plantilla);
		}
		else{
			model.addAttribute("plantilla", new ConfiguracionPlantilla());
			log.info("no hay plantillas");  
		}
		return "plantilla/mostrar";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("plantilla") ConfiguracionPlantilla plantilla,  BindingResult result, Model model){
		plantillaDao.update(plantilla);
		return "redirect:/plantilla/?msg=Su plantilla ha sido guardada correctamente.";
	}
}

