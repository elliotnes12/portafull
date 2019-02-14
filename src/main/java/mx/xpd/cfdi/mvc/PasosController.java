package mx.xpd.cfdi.mvc;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.service.rest.RecompraInterface;
import mx.xpd.service.rest.RecompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonObject;

@Controller
@RequestMapping(value = "/pasos")
public class PasosController {

	@Autowired
	private ParametroDao paramDao;

	@RequestMapping(value = "/vigencia", method = RequestMethod.GET)
	public String vigencia(Model model, HttpServletRequest request) {
		RecompraInterface recompra = new RecompraService();
		JsonObject obj = recompra.
				getAgente(
						paramDao.findByClave("URL_SERVICIO_BUSCA_DISTRIBUIDOR").getValor(),
						 (String) request.getSession().getAttribute("tenantId") );
		
		if(obj == null) {
			model.addAttribute("Nombre", paramDao.findByClave("DISTRIBUIDOR_DEFAULT_NOMBRE").getValor());
			model.addAttribute("Telefono", paramDao.findByClave("DISTRIBUIDOR_DEFAULT_TELEFONO").getValor());
			model.addAttribute("Email", paramDao.findByClave("DISTRIBUIDOR_DEFAULT_EMAIL").getValor());
		} else {
			model.addAttribute("Nombre", obj.get("Nombre").getAsString());
			model.addAttribute("Telefono", obj.get("Telefono").getAsString());
			model.addAttribute("Email", obj.get("Email").getAsString());
		}
		return "pasos/vigencia";
	}
	
	@RequestMapping(value = "/regimen", method = RequestMethod.GET)
	public String regimen(Model model) {
		return "pasos/regimen";
	}
	
	@RequestMapping(value = "/lugarExpedicion", method = RequestMethod.GET)
	public String lugarExpedicion(Model model) {
		return "pasos/lugarExpedicion";
	}
	
	@RequestMapping(value = "/lco", method = RequestMethod.GET)
	public String lco(Model model) {
		return "pasos/lco";
	}
	
	@RequestMapping(value = "/certificado", method = RequestMethod.GET)
	public String certificado(Model model) {
		return "pasos/certificado";
	}
	
}
