package mx.xpd.cfdi.mvc;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.constantes.URLConstants;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.Usuario;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.GrupoUsuarioDao;
import mx.xpd.cfdi.repo.PaisEstadoDao;
import mx.xpd.cfdi.repo.UsuarioDao;
import mx.xpd.cfdi.util.EmailUtil;
import mx.xpd.cfdi.util.PasswordGenerator;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	@Autowired
	private DatosEmisorDao datosEmisorDao;
	@Autowired
	private UsuarioDao daoUsuario;
	
	Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private GrupoUsuarioDao daoGrupoUsuarios;
	@Autowired
	private PaisEstadoDao paisEstadosDao;

	@RequestMapping(value = "/reiniciarContrasena", method=RequestMethod.GET)
	public String reiniciarPass(Model model) {
		return "usuario/reiniciarContrasena"; 
	}
	
	@RequestMapping(value = "/reset", method=RequestMethod.GET)
	public String reiniciarPass2(Model model) {
		return "usuario/reiniciarContrasena2"; 
	}
	
	@RequestMapping(value = "/generaCodigoRescate", method=RequestMethod.GET)
	public String generaCodigoRescate(Model model) {
		return "usuario/generaCodigoRescate"; 
	}
	
	@RequestMapping(value = "/password2", method=RequestMethod.POST)
	public String enviaPass2(Model model, HttpServletRequest request) throws LlavePrivadaException {
		String pass = PasswordGenerator.getPassword(8);
		String msg = "";
		String tenant = request.getParameter("rfc").toString();
		String usuario = request.getParameter("usuario").toString();
		String codigoRescate = request.getParameter("codigoRescate").toString();
		
		String email = "";
		
		if (true) {
			daoUsuario.setTenantId(tenant);
			Usuario usr = daoUsuario.findByClave(usuario, tenant);
			
			if (usr != null) {
				
				if ((usr.getCodigoRescate() != null)&&(usr.getCodigoRescate().equals(codigoRescate))){
					if (usr.getVigenciaCodigoRescate().after(new Date())){
						email = usr.getEmail();
						usr.setPassword(pass);
						usr.setPassword2(usr.getPassword());
						usr.setPassword3(usr.getPassword2());
						usr.setCodigoRescate(null);
						usr.setVigenciaCodigoRescate(null);
						daoUsuario.update(usr);
						
						DatosEmisor dE = datosEmisorDao.findEmisor(tenant);
						dE.setPaso(1);
						datosEmisorDao.update(dE);
						
						String texto = correoContrasena(tenant, pass); 
						EmailUtil.enviarCorreo("XPD - Reseteo contraseña.", texto, email);
						EmailUtil.enviarCorreo("XPD - Reseteo contraseña.", texto, dE.getEmail());
						msg = "<div class='alert alert-success'>Nueva contraseña enviada.</div>";
					}
					else{
						msg = "<div class='alert alert-error'>La vigencia del Código de Rescate asociado a su cuenta ha caducado, favor de generar un nuevo código.</div>";
					}
				}
				else{
					msg = "<div class='alert alert-error'>El Código de Rescate asociado a su cuenta no es correcto, favor de validar</div>";
				}
				
			} else {
				msg = "<div class='alert alert-error'>El usuario no existe para ese RFC</div>";
			}
		} else {
			msg = "<div class='alert alert-error'>Contraseña seguridad no valida.</div>";
		}
		model.addAttribute("mensaje", msg);
		return "usuario/reiniciarContrasena2";
	}
	
	@RequestMapping(value = "/password", method=RequestMethod.POST)
	public String enviaPass(Model model, HttpServletRequest request) throws LlavePrivadaException {
		String pass = PasswordGenerator.getPassword(8);
		String msg = "";
		String tenant = request.getParameter("rfc").toString();
		System.out.println(tenant);
		if (tenant.equals("AAA010101AAA")){
			msg = "<div class='alert alert-error'>No está permitido cambiar la contraseña al usuario Demo.</div>";
		}
		else{
			String usuario = request.getParameter("usuario").toString();
			String email = request.getParameter("email").toString();
			String password = request.getParameter("password").toString();
			
			if (password.equals("pLf#j_r74@jkhn5-")) {
				daoUsuario.setTenantId(tenant);
				Usuario usr = daoUsuario.findByClave(usuario, tenant);
				if (usr != null) {
					usr.setPassword(pass);
					usr.setPassword2(usr.getPassword());
					usr.setPassword3(usr.getPassword2());
					daoUsuario.update(usr);
					
					DatosEmisor dE = datosEmisorDao.findEmisor(tenant);
					dE.setPaso(1);
					datosEmisorDao.update(dE);
					
					String texto = correoContrasena(tenant, pass); 
					EmailUtil.enviarCorreo("XPD - Reseteo contraseña.", texto, email);
					msg = "<div class='alert alert-success'>Nueva contraseña enviada.</div>";
				} else {
					msg = "<div class='alert alert-error'>El usuario no existe para ese RFC</div>";
				}
			} else {
				msg = "<div class='alert alert-error'>Contraseña seguridad no valida.</div>";
			}
			
		}
		model.addAttribute("mensaje", msg);
		return "usuario/reiniciarContrasena";
	}
	
	private String correoContrasena(String rfc, String pass) {
		String texto = "<br>Su contraseña ha sido reiniciada";
		
		String	login = "<br><a href='" + URLConstants.CAMBIO_PASSWORD + "'>"
				+ " Da click aqui para que selecciones tu contrase&ntilde;a de acceso al sistema </a>";
		
		login = login.replace(":tenant", rfc);
		login = login.replace(":password", pass);

		texto += "<br>1.- " + login;
		texto += "<br>2.- Escribe la clave que seleccionaste y conservala en un lugar seguro.";
		texto += "<br>3.- Para entrar al portal de facturacion debes entrar a: " + URLConstants.LOGIN;
		
		texto += "<br> con tu clave de cliente: <b>" + rfc + "</b> y la contrase&ntilde;a que escribiste en el paso numero 1";
		texto += "<br><br> Si tiene alguna duda, envíe un mail a <a href='mailto:soporte@xpd.mx'>soporte@xpd.mx</a>";
		return texto;
	}
	
	private String correoCodigoRescate(String rfc, String codigoRescate, Calendar cal) {
		String texto = "<br>Está recibiendo este correo porque usted (o alguien más) ha solicitado el Código de Rescate para restablecer su contraseña en el Portal de Facturación.<br> <br>";
		texto = texto+ "Su código de Rescate es <b>"+ codigoRescate+"</b> y estará vigente hasta  <b> "+ cal.getTime().toLocaleString() +"</b>.";
						
		texto += "<br><br>Si no solicitó este proceso, ignore este correo y contacte a <a href='mailto:soporte@xpd.mx'>soporte@xpd.mx</a>";
		return texto;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String mostrar(Model model,  HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
				
		log.info("el tenant id es : " + tenantID );
		model.addAttribute("rfc", tenantID);
		model.addAttribute("usuario", new Usuario());
		daoUsuario.setTenantId(tenantID);
		model.addAttribute("usuarios", daoUsuario.findAll(tenantID));
		daoGrupoUsuarios.setTenantId(tenantID);
		model.addAttribute("mapGrupoUsuarios", daoGrupoUsuarios.findAllMap());
		model.addAttribute("paises", paisEstadosDao.findAllPais());
		model.addAttribute("estados", paisEstadosDao.findAllEstado());
		return "usuario/mostrar";
	}
	 	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) throws LlavePrivadaException {
		usuario.setPassword2("");
		usuario.setPassword3("");
		daoUsuario.add(usuario);
		return "redirect:/usuario/";
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable Long id, Model model,  HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		Usuario usuario = daoUsuario.findById(id, tenantID);
		if (usuario == null) {
			return "redirect:/usuario/";
		} 
		usuario.setPassword("");
		String tenant =  (String) RequestContextHolder
				.currentRequestAttributes().getAttribute("tenantId",
						RequestAttributes.SCOPE_SESSION);
		log.info("el tenant id es : " + tenant );
		model.addAttribute("rfc", tenant);
		model.addAttribute("mapGrupoUsuarios", daoGrupoUsuarios.findAllMap());
		model.addAttribute("usuario", usuario);
		model.addAttribute("estados", paisEstadosDao.findAllEstado());
		return "usuario/editar";
	}
	
	@RequestMapping(value="/detalle/{id}", method=RequestMethod.GET)
	public String detalle(@PathVariable Long id, Model model,  HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		Usuario usuario = daoUsuario.findById(id, tenantID);
		if (usuario == null) {
			return "redirect:/usuario/";
		} 
		model.addAttribute("usuario", usuario);
		model.addAttribute("mapGrupoUsuarios", daoGrupoUsuarios.findAllMap());
		model.addAttribute("estados", paisEstadosDao.findAllEstado());
		return "usuario/detalle";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		Usuario usuarioActual = daoUsuario.findById(usuario.getId(), tenantID);
		if(usuario.getPassword()==null || usuario.getPassword().length()==0){
			usuario.setPassword(usuarioActual.getPassword());
			usuario.setPassword2(usuarioActual.getPassword2());
			usuario.setPassword3(usuarioActual.getPassword3());
	    	usuario.setUltimaActualizacion(new Date());
			daoUsuario.update(usuario);
			return "redirect:/usuario/";
		}else {
			usuario.setPassword2(usuarioActual.getPassword());
			usuario.setPassword3(usuarioActual.getPassword2());
			usuario.setUltimoCambioPassword(new Date());
	    	usuario.setUltimaActualizacion(new Date());
			daoUsuario.update(usuario);
			return "redirect:/usuario/";
		}
	}
	
	
	@RequestMapping(value = "/generaCodigoRescate2", method=RequestMethod.POST)
	public String generaCodigoRescate(Model model, HttpServletRequest request) throws LlavePrivadaException {
		String codigoRescate = UUID.randomUUID().toString().replaceAll("-", "");
		String msg = "";
		String regresa = "";
		String tenant = request.getParameter("rfc").toString();
		String usuario = request.getParameter("usuario").toString();
				
		if (true) {
			daoUsuario.setTenantId(tenant);
			Usuario usr = daoUsuario.findByClave(usuario, tenant);
			
			if (usr != null) {
				DatosEmisor dE = datosEmisorDao.findEmisor(tenant);
				
				usr.setCodigoRescate(codigoRescate);
				Calendar cal = new GregorianCalendar();
				cal.add(Calendar.HOUR_OF_DAY, 1);
				
				usr.setVigenciaCodigoRescate(cal.getTime());
				daoUsuario.update(usr);
				
				String texto = correoCodigoRescate(tenant, codigoRescate, cal); 
				EmailUtil.enviarCorreo("XPD - Generación Código de Rescate.", texto, dE.getEmail());
				
				EmailUtil.enviarCorreo("XPD - Generación Código de Rescate.", texto, usr.getEmail());
				msg = "<div class='alert alert-success'>Código de Rescate enviado.</div>";
				regresa = "usuario/reiniciarContrasena2";
			} else {
				msg = "<div class='alert alert-error'>El usuario no existe para ese RFC</div>";
				regresa = "usuario/generaCodigoRescate";
			}
		} else {
			msg = "<div class='alert alert-error'>Contraseña seguridad no valida.</div>";
		}
		model.addAttribute("mensaje", msg);
		return regresa;
	}
	
	
}