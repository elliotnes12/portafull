package mx.xpd.cfdi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.ConfiguracionCFDI;
import mx.xpd.cfdi.repo.CatalogoClaveUnidadDao;
import mx.xpd.cfdi.repo.CatalogoFormaPagoDao;
import mx.xpd.cfdi.repo.CatalogoMetodoPagoDao;
import mx.xpd.cfdi.repo.ConfiguracionCFDIDao;
import mx.xpd.cfdi.repo.LugarExpedicionDao;
import mx.xpd.cfdi.repo.CatalogoMonedaDao;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonObject;

@Controller
@RequestMapping(value = "/configuracionCFDI")
public class ConfiguracionCFDIController {
	@Autowired
	private ConfiguracionCFDIDao configuracionCFDIDao;
	
	@Autowired
	private LugarExpedicionDao lugarExpedicionDao;
	
	@Autowired
	private CatalogoMonedaDao catalogoMonedaDao;
	
	@Autowired
	private CatalogoFormaPagoDao catalogoFormaPagoDao;
	
	@Autowired
	private CatalogoMetodoPagoDao catalogoMetodoPagoDao;
	
	@Autowired
	private CatalogoClaveUnidadDao catalogoClaveUnidadDao;
		
	private static final Logger log = Logger.getLogger("ConfiguracionCFDIController");

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		configuracionCFDIDao.setTenantId(tenantID);
		if(configuracionCFDIDao.find() != null){
			configuracionCFDIDao.setTenantId(tenantID);
			ConfiguracionCFDI configuracionCFDI= configuracionCFDIDao.find();
			log.info("hay un registro");
			model.addAttribute("configuracionCFDI", configuracionCFDI);
			lugarExpedicionDao.setTenantId(tenantID);
			model.addAttribute("mapLugaresEmision", lugarExpedicionDao.findAllMap());
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("metodosPago", catalogoMetodoPagoDao.findAll());
			model.addAttribute("formasPago", catalogoFormaPagoDao.findAll());
			model.addAttribute("listaUnidades", catalogoClaveUnidadDao.findAll());
			model.addAttribute("complementosConfig", configuracionCFDI.getComplementosConfig());
		}
		else{
			model.addAttribute("configuracionCFDI", new ConfiguracionCFDI());
			model.addAttribute("mapLugaresExpedicion", lugarExpedicionDao.findAllMap());
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("metodosPago", catalogoMetodoPagoDao.findAll());
			model.addAttribute("formasPago", catalogoFormaPagoDao.findAll());
			model.addAttribute("listaUnidades", catalogoClaveUnidadDao.findAll());
			model.addAttribute("complementosConfig", "{}");
			log.info("no hay registros");
		}
		return "configuracionCFDI/mostrar";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(
			@Valid @ModelAttribute("configuracionCFDI") ConfiguracionCFDI configuracionCFDI, 
			BindingResult result, 
			Model model,
			HttpServletRequest request){

		if (configuracionCFDI.getGuardarProductos() == null) {
			configuracionCFDI.setGuardarProductos(false);
		}
		// Configuración de complementos sobre un objeto JSON
		JsonObject complementosConf = new JsonObject();
		String[] Campos = {
				"addenda",
				"firmas",
				"descuento",
				"impuestosLocalesYFederales",
				"detallista",
				"renovacionSustitucionVehiculos",
				"registroFiscal",
				"donatorias",
				"pagoEspecie",
				"notariosPublicos",
				"consumoCombustible",
				"vehiculoUsado",
				"valesDespensa",
				"serviciosParcialesConstruccion",
				"aerolineas",
				"divisas",
				"turistaPasajeroExtranjero",
				"personaFisicaIntegranteCoordinado",
				"ine",
				"leyendasFiscales",
				"enajenacionObrasArtesPlasticasAntiguedades",
				"certificadoDestruccion",
				"estadoCuentaCombustiblesMonederosElectronicosAutorizadosSAT",
				"estadoCuentaCombustiblesMonederosElectronicosAutorizadosSAT12",
				"comercioExterior11",
				"conceptoCuentaTerceros",
				"conceptoInstitucionesEducativasPrivadas",
				"conceptoVentaVehiculos"
			};
		for(String campo : Campos) {
			if(request.getParameter("complementos[" + campo + "]") != null) {
				complementosConf.addProperty(campo, request.getParameter("complementos[" + campo + "]"));
			}
		}
		if(complementosConf.toString().length() > 1000) {
			log.error("La configuración de la base de datos solo soporta la cantidad de 1000 caracteres en el campo complementosConfig.");
		} else {
			configuracionCFDI.setComplementosConfig(complementosConf.toString());
		}
		configuracionCFDIDao.update(configuracionCFDI);
		return "redirect:/configuracionCFDI/";
		}
}

