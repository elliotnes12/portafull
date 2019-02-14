package mx.xpd.cfdi.mvc;

import mx.xpd.cfdi.repo.CertificadoSelloDigitalDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/csd")
public class CertificadoSelloDigitalRestController {

	@Autowired
	private CertificadoSelloDigitalDao certificadoDao;
	
	@RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
	public @ResponseBody Boolean eliminar(@PathVariable("id") Long id) {
		Boolean valor = certificadoDao.remove(id);
		return valor;
	}
	
	
}
