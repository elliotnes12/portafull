package mx.xpd.cfdi.mvc;

import javax.validation.Valid;

import mx.xpd.cfdi.domain.Parametro;
import mx.xpd.cfdi.repo.ParametroDao;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/parametro")
public class ParametroController {
	Logger log = org.slf4j.LoggerFactory.getLogger(MonedaController.class);

	@Autowired
	private ParametroDao parametroDao;

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model) {
		model.addAttribute("parametro", new Parametro());
		model.addAttribute("parametros", parametroDao.findAll());
		return "parametro/mostrar";
	}

	@RequestMapping(value="/agregar", method = RequestMethod.POST)
	public String Agregar( @Valid @ModelAttribute("parametro") Parametro nuevoParametro, BindingResult result, Model model) {
		parametroDao.add(nuevoParametro);
		return "redirect:/parametro/";
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable Long id, Model model) {
		Parametro parametro = parametroDao.findById(id);
		if (parametro == null) {
			return "redirect:/parametro/";
		} 
		model.addAttribute("parametro", parametro);
		return "parametro/editar";
	}
	
	@RequestMapping(value="/detalle/{id}", method=RequestMethod.GET)
	public String detalle(@PathVariable Long id, Model model) {
		Parametro parametro = parametroDao.findById(id);
		if (parametro == null) {
			return "redirect:/parametro/";
		} 
		model.addAttribute("parametro", parametro);
		return "parametro/detalle";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("parametro") Parametro parametro, BindingResult result, Model model) {
		parametroDao.update(parametro);
		return "redirect:/parametro/";
	}

}
