package mx.xpd.cfdi.mvc;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.BannerPopup;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.Usuario;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.BannerPopupDao;
import mx.xpd.cfdi.repo.ComprobanteDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.repo.UsuarioDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	private final int SESSION_TIMEOUT = 10;
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private DatosEmisorDao emisorDao;
	@Autowired
	private ComprobanteDao comprobanteDao;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ParametroDao parametroDao;
	@Autowired
	private BannerPopupDao bannerPopupDao;
	
	@RequestMapping(value="/primerLogin/{tenant}/{pass}", method=RequestMethod.GET)
	public void primerLogin(Model model, HttpServletRequest request, HttpServletResponse response,
			@PathVariable("tenant") String tenant,
			@PathVariable("pass") String pass) throws ServletException, IOException {
		
		String url = "/CFDI33/j_spring_security_check";
		
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher(url);
		request.setAttribute("j_username", tenant);
		request.setAttribute("j_password", pass);
		
		dispatcher.forward(request, response);
		
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
		return "login.jsp";
	}
  
	@RequestMapping(value="", method=RequestMethod.GET)
	public String home2(Model model,HttpServletRequest request) {
		
		String view = "login";
	
		if(request != null)
		{
		  if(request.getSession().getAttribute("tipo") != null)
			{
				HttpSession session= request.getSession(false);
				
				if(session != null)
				 {
					session.invalidate();
				 }
			}
		}
		
		return view;
		
	}

	@RequestMapping(value="/autenticar", method=RequestMethod.GET)
	public String loginForm(Model model) {
		return "login.jsp";
	}

	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
		model.addAttribute("loginError", "true");
		return "login.jsp";
	}
	
	@RequestMapping(value="/contrato", method = RequestMethod.GET)
	public String contrato(Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		DatosEmisor emisor = emisorDao.findEmisor(tenantID);
		model.addAttribute("emisor", emisor);
		return "pasos/contrato";
	}

	@RequestMapping(value="/loginSuccessful")
	public String loginSuccessful(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		User user = null;
		log.debug("loginSuccessful");
		try { 
			user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		} catch (Exception e) { return "redirect:/"; }
		
		DatosEmisor emisor = emisorDao.findEmisor(tenantID);
		
		if(emisor.getPaso()== 0){
			request.getSession().setAttribute("resetearPassword", "si");
			return "redirect:/manifiesto";
		}
		
		if(emisor.getPaso()==1){
			request.getSession().setAttribute("resetearPassword", "si");
			return "redirect:/login/cambiarPassword/" + user.getUsername();
		}

		Usuario usuario = usuarioDao.findByClave(user.getUsername(), tenantID);
		Date nuevoIntento = new Date();
		Calendar cal = new GregorianCalendar();
		//AQUI SE VALIDARA CAMBIO DE CONTRASE�A DESPUES DE 3 MESES.
		cal.setTimeInMillis(usuario.getUltimoCambioPassword().getTime());
		cal.add(Calendar.MONTH, 3);
		if(nuevoIntento.compareTo(cal.getTime())>=1){
			request.getSession().setAttribute("resetearPassword", "si");
			return "redirect:/login/cambiarPassword/" + usuario.getClave();
		}

		//AQUI SE HARA LA VALIDACION DE SI HAN PASADO MAS DE 6 MESES DESDE EL ULTIMO ACCESO
		cal.setTimeInMillis(usuario.getUltimoAcceso().getTime());
		//cal.add(Calendar.MONTH, 6);
		cal.add(Calendar.MONTH, 6);
		log.info("fecha de la ultima vez ingresado + 6 meses " + cal.getTime());
		if(nuevoIntento.compareTo(cal.getTime())>=1){
			request.getSession().setAttribute("resetearPassword", "si");
			return "redirect:/login/cambiarPassword/" + usuario.getClave();
		}
		usuarioDao.accesoCorrecto(usuario.getNombre());
		
		// Se especifica la duracion de la sesion
		setSessionTimeout(request.getSession());
		return "redirect:/login/inicio";
	}

	@RequestMapping(value="/cambiarPassword/{usuario}", method = RequestMethod.GET)
	public String cambiar(@PathVariable("usuario") String username, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenant = (String)request.getSession().getAttribute("tenantId");
		Usuario usuario = usuarioDao.findByClave(username, tenant);
		usuario.setPassword("");
		model.addAttribute("rfc", tenant);
		model.addAttribute("usuario", usuario);
		return "cambiarPassword";
	}

	@RequestMapping(value="/passwordEditado", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		DatosEmisor emisor = emisorDao.findEmisor(tenantID);
		if(emisor.getPaso()==1){
			emisor.setPaso(2);
			emisorDao.update(emisor);
		}
		Usuario cambiado = usuarioDao.findById(usuario.getId(), tenantID);
		if (cambiado != null) {
			cambiado.setPassword2(cambiado.getPassword());
			cambiado.setPassword3(cambiado.getPassword2());
			cambiado.setPassword(usuario.getPassword());
			cambiado.setUltimoCambioPassword(new Date());
			cambiado.setUltimaActualizacion(new Date());
			request.getSession().setAttribute("resetearPassword", "no");
			usuarioDao.update(cambiado);
			usuarioDao.accesoCorrecto(cambiado.getNombre());
			
			
		}
		return "inicio";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		final String rfc = (String)session.getAttribute("tenantId");
		
		//COMENTADO PARA QUE NO HAGA CALCULOS DE EMITIDOS Y CANCELADOS
		//List<CfdEmitido> cfds =  comprobanteDao.findAll(rfc);
		emisorDao.setTenantId(rfc);
		if (emisorDao.findEmisor(rfc) == null) {
			return "redirect:/";
		}
		
		Integer foliosEmitidos = 0;
		Integer foliosCancelados = 0;

		emisorDao.setTenantId(rfc);
		Integer foliosDisponibles = emisorDao.findEmisor(rfc).getFoliosDisponibles();
		String strUltimaCompra = emisorDao.findEmisor(rfc).getUltimaCompra();
		if (strUltimaCompra != null){
			strUltimaCompra = strUltimaCompra.substring(0, 11);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				
				Calendar calVigencia = Calendar.getInstance();
				calVigencia.setTime(formatter.parse(strUltimaCompra));
				calVigencia.add(Calendar.YEAR,1);
				
				strUltimaCompra = formatter.format(calVigencia.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
				
		//COMENTADO PARA QUE NO HAGA CALCULOS DE EMITIDOS Y CANCELADOS
		/*for (CfdEmitido cfd : cfds) {
			// if (cfd.getEstatus().equals("emitido"))
			foliosEmitidos++;
			if (cfd.getEstatus() == null) {
				continue;
			}
				
			if (cfd.getEstatus().equals("cancelado"))
				foliosCancelados++;
		}*/
		//Opciones de gráfica: desde el inicio de los tiempos, los últimos 12 meses, los últimos 6 meses
		//y los últimos 3 meses
		model.addAttribute("foliosDisponibles", foliosDisponibles);
		model.addAttribute("foliosEmitidos", foliosEmitidos);
		model.addAttribute("foliosCancelados", foliosCancelados);
		model.addAttribute("ultimaCompra", strUltimaCompra);
		model.addAttribute("tipo",request.getSession().getAttribute("tipo"));
		// Banner para el popup
		try{
			BannerPopup banner = bannerPopupDao.findActive();
			if(banner != null) {
				model.addAttribute("banner", banner.toString());
			}
		}catch(Exception e){
			log.info("Error al accesar a la tabla BannerPopup");
		}
		return "inicio.jsp";
	}
	
	private void setSessionTimeout(HttpSession session) {
		// tiempo por default de la sesion
		Integer sessionTimeout = null;
		String sMinutos = null;
		
		try {
			sMinutos = parametroDao.findByClave("SESSION_TIMEOUT").getValor();
			   	
			log.info("Duracion de la session ID [ " + session.getId() + " ] sin actividad " + sMinutos + " minutos");
					
			if(sMinutos != null && !sMinutos.equals("")) {
						
				sessionTimeout = Integer.parseInt(sMinutos);
					   
			}
		} catch(NumberFormatException nf) {
			
			log.error("Formato de numero incorrecto");
			sessionTimeout = SESSION_TIMEOUT;
			
			log.info("Formato de numero no correcto");
				
		} catch(Exception e) {
				
			e.printStackTrace();
			sessionTimeout = SESSION_TIMEOUT;
		}		
			
		session.setMaxInactiveInterval(sessionTimeout*60);
	}
}
