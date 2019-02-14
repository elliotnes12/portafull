package mx.xpd.cfdi.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.ConfiguracionCFDI;
import mx.xpd.cfdi.domain.Moneda;
import mx.xpd.cfdi.domain.ProductoServicio;
import mx.xpd.cfdi.repo.CatalogoClaveProdServDao;
import mx.xpd.cfdi.repo.CatalogoClaveUnidadDao;
import mx.xpd.cfdi.repo.CatalogoMonedaDao;
import mx.xpd.cfdi.repo.ConfiguracionCFDIDao;
import mx.xpd.cfdi.repo.ProductoServicioDao;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/productoServicio")
public class ProductoServicioController {
	@Autowired
	private CatalogoClaveProdServDao catalogoClaveProdServDao;
	@Autowired
	private ProductoServicioDao productoDao;
	@Autowired
	private CatalogoMonedaDao catalogoMonedaDao;
	@Autowired
	private CatalogoClaveUnidadDao catalogoClaveUnidadDao;
	@Autowired
	private ConfiguracionCFDIDao configuracionCFDIDao;
	
	private Logger log = Logger.getLogger(ProductoServicioController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView mostrar(Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		configuracionCFDIDao.setTenantId(tenantID);
		ConfiguracionCFDI configuracionCFDI = configuracionCFDIDao.find();
		String msg = (String)request.getParameter("msg");
		String error = (String)request.getParameter("error");
		if(msg != null && msg.length() > 0) {
			model.addAttribute("msg", msg);
			model.addAttribute("error", error);
		}
		productoDao.setTenantId(tenantID);
		model.addAttribute("listaProductosServicios", productoDao.findAll(tenantID));
		model.addAttribute("productoServicio", new ProductoServicio());
		model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
		model.addAttribute("listaUnidades", catalogoClaveUnidadDao.findAll());
		model.addAttribute("configuracionCFDI", configuracionCFDI);
		return new ModelAndView("productoServicio/mostrar");
	}

	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public ModelAndView agregar(
			@Valid @ModelAttribute("ProductoServicio") ProductoServicio nuevoProductoServicio,
			BindingResult result, Model model, HttpServletRequest request) {
		String url = "";
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		configuracionCFDIDao.setTenantId(tenantID);
		ConfiguracionCFDI configuracionCFDI = configuracionCFDIDao.find();
		productoDao.setTenantId(tenantID);
		if (result.hasErrors()) {
			log.info("tiene errores");
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("configuracionCFDI", configuracionCFDI);
		} else {
			productoDao.add(nuevoProductoServicio);
			String msg = "Producto guardado correctamente";
			String error = "0";
			url = "?msg=" + msg + "&error=" + error;
		}
		ModelAndView v = new ModelAndView("redirect:/productoServicio" + url);
		v.addObject("error", "Guardado corrrectamente");
		return v;
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		productoDao.setTenantId(tenantID);
		configuracionCFDIDao.setTenantId(tenantID);
		ConfiguracionCFDI configuracionCFDI = configuracionCFDIDao.find();
		ProductoServicio productoServicio = productoDao.findById(id);
		if (productoServicio == null) {
			model.addAttribute("productoServicio", new ProductoServicio());
			return new ModelAndView("redirect:/productoServicio"); // TODO poner diagonal al final?
		}
		
		model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
		model.addAttribute("productoServicio", productoServicio);
		model.addAttribute("listaUnidades", catalogoClaveUnidadDao.findAll());
		model.addAttribute("configuracionCFDI", configuracionCFDI);
		return new ModelAndView("productoServicio/editar");
	}

	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalle(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		productoDao.setTenantId(tenantID);
		ProductoServicio productoServicio = productoDao.findById(id);
		configuracionCFDIDao.setTenantId(tenantID);
		ConfiguracionCFDI configuracionCFDI = configuracionCFDIDao.find();
		if (productoServicio == null) {
			log.info("no se encontró ningún producto");
			return new ModelAndView("redirect:/productoServicio/");// TODO poner diagonal al final?
		}
		
		model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
		model.addAttribute("listaUnidades", catalogoClaveUnidadDao.findAll());
		model.addAttribute("productoServicio", productoServicio);
		model.addAttribute("configuracionCFDI", configuracionCFDI);
		return new ModelAndView("productoServicio/detalle");
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(
			@Valid @ModelAttribute("productoServicio") ProductoServicio nuevoProductoServicio,
			BindingResult result,
			Model model
			, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		productoDao.setTenantId(tenantID);
		if (result.hasErrors()) {
			log.info("binding result tiene errores");
			return new ModelAndView("editar/" + nuevoProductoServicio.getId());
		}
		productoDao.addOrUpdate(nuevoProductoServicio);
		//mensaje agregado satisfactoriamente
		return new ModelAndView("redirect:/productoServicio");
	}
	

}