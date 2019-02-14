package mx.xpd.cfdi.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class MenuController {

	@RequestMapping(value="/configuracion")
	public String configuracion(Model model) {
		return "layout/configuracion";
	}
	
	@RequestMapping(value="/catalogos")
	public String catalogos(Model model) {
		return "layout/catalogos";
	}
	
	@RequestMapping(value="/ayuda")
	public String ayuda(Model model) {
		return "layout/ayuda";
	}
	
}
