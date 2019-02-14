package mx.xpd.cfdi.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.CfdEmitido;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.ParametroDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/folios")
public class FoliosController {

	@Autowired
	private ParametroDao daoParam;
	@Autowired
	private DatosEmisorDao datosEmisorDao;
	
	@RequestMapping(value = "/agotados" ,method = RequestMethod.GET)
	public String agotados(Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		DatosEmisor datos = datosEmisorDao.findEmisor(tenantID);
		
		if(datos.getFoliosDisponibles() > 0) {
			return "redirect:/login/inicio";
		}
		
		String url = daoParam.findByClave("URL_CONTRATAR").getValor();
		model.addAttribute("urlContratar", url);
		return "folios/agotados";
	}
}
