package mx.xpd.cfdi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.Moneda;
import mx.xpd.cfdi.repo.MonedaDao;

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
@RequestMapping(value = "/moneda")
public class MonedaController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(MonedaController.class);

	@Autowired
	private MonedaDao monedaDao;

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model, HttpServletRequest request) {
		String msg = (String)request.getParameter("msg");
		String error = (String)request.getParameter("error");
		if(msg != null && msg.length() > 0) {
			model.addAttribute("msg", msg);
			model.addAttribute("error", error);
		}
		model.addAttribute("moneda", new Moneda());
		model.addAttribute("monedas", monedaDao.findAll());
		return "moneda/mostrar";
	}

	@RequestMapping(value="/agregar", method = RequestMethod.POST)
	public String Agregar( @Valid @ModelAttribute("moneda") Moneda nuevaMoneda, BindingResult result, Model model) {
		monedaDao.add(nuevaMoneda);
		String url = "";
		String msg = "Moneda guardada correctamente";
		String error = "0";
		url = "?msg=" + msg + "&error=" + error;
		return "redirect:/moneda/" + url;
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable Long id, Model model) {
		Moneda moneda = monedaDao.findById(id);
		if (moneda == null) {
			return "redirect:/moneda/";
		} 
		model.addAttribute("moneda", moneda);
		return "moneda/editar";
	}
	
	@RequestMapping(value="/detalle/{id}", method=RequestMethod.GET)
	public String detalle(@PathVariable Long id, Model model) {
		Moneda moneda = monedaDao.findById(id);
		if (moneda == null) {
			return "redirect:/moneda/";
		} 
		model.addAttribute("moneda", moneda);
		return "moneda/detalle";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("moneda") Moneda moneda, BindingResult result, Model model) {
		monedaDao.update(moneda);
		return "redirect:/moneda/";
	}

}
