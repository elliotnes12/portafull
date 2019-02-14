package mx.xpd.cfdi.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/errores")
public class ErroresController {
	
	@RequestMapping(value="/noPermisos")
	public String ayuda(Model model) {
		return "errores/noPermisos";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String algo(Model model) {
		return "errores/noPermisos";
	}
	
}
