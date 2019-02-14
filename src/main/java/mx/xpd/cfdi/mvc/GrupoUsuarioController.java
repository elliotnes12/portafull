package mx.xpd.cfdi.mvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.GrupoUsuario;
import mx.xpd.cfdi.domain.Modulo;
import mx.xpd.cfdi.domain.Permiso;
import mx.xpd.cfdi.repo.GrupoUsuarioDao;
import mx.xpd.cfdi.repo.ModuloDao;
import mx.xpd.cfdi.repo.PermisoDao;

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
@RequestMapping(value = "/grupoUsuario")
public class GrupoUsuarioController {

	@Autowired
	private GrupoUsuarioDao daoGrupoUsuario;
	@Autowired
	private ModuloDao daoModulo;
	@Autowired
	private PermisoDao daoPermiso;
	private Logger log = Logger.getLogger(GrupoUsuarioController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model,  HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		GrupoUsuario grupoUsuario = new GrupoUsuario();
		List<Permiso> permisos = inicializarPermisos(grupoUsuario);
		grupoUsuario.setPermisos(permisos);
		daoGrupoUsuario.setTenantId(tenantID);
		model.addAttribute("listaGrupoUsuarios", daoGrupoUsuario.findAll());
		model.addAttribute("grupoUsuario", grupoUsuario);
		return "grupoUsuario/mostrar";
	}
	
	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public String addGrupoUsuario(
			@Valid @ModelAttribute("grupoUsuarioForm") GrupoUsuario nuevoGrupoUsuario,
			Model model) {
		log.info("nombre: " + nuevoGrupoUsuario.getNombre());
		log.info("grupoUsuario id: " + nuevoGrupoUsuario.getId());
		try {
			Date horaInicio = stringADate(nuevoGrupoUsuario.getHoraInicialJsp());
			Date horaFin = stringADate(nuevoGrupoUsuario.getHoraFinalJsp());
			nuevoGrupoUsuario.setHoraInicial(horaInicio);
			nuevoGrupoUsuario.setHoraFinal(horaFin);
		} catch (ParseException e) {
			e.printStackTrace();
			log.warn("Error en el formato de la hora");
			return "redirect:/grupoUsuario/";
		}
		log.info("antes de crear la lista de permisos");
		List<Permiso> permisos = nuevoGrupoUsuario.getPermisos();
		
		nuevoGrupoUsuario = daoGrupoUsuario.addOrUpdate(nuevoGrupoUsuario);
		List<Permiso> permisosTemp = inicializarPermisos(nuevoGrupoUsuario);
		//cuando se inserta a base de datos se pierde la info pero queremos obtener el id asignado
		int i = 0;
		for (Permiso permiso : permisosTemp) {
			permiso.setPermiso(permisos.get(i).getPermiso());
			log.info("Modulo " + permiso.getNombreModulo() + " - idModulo " + permiso.getIdModulo() + 
					" - Permiso " + permiso.getPermiso()+ " - idGrupoUsuario " + permiso.getIdGrupoUsuario());
			daoPermiso.add(permiso);
			i++;
		}
		return "redirect:/grupoUsuario/";
	}

	@RequestMapping(value = "/detalle/{id}", method = RequestMethod.GET)
	public ModelAndView detalle(@PathVariable("id") Long id, Model model) {
		GrupoUsuario grupoUsuario = daoGrupoUsuario.findById(id);
		if (grupoUsuario == null) {
			log.info("no se encontró ningún producto");
			return new ModelAndView("redirect:/grupoUsuario/");
		}
		List<Permiso> permisos = daoPermiso.findByGrupoUsuarioId(id);
		if (permisos == null) {
			log.warn("no se encontraron permisos para el grupoId: " + id);
			return new ModelAndView("redirect:/grupoUsuario/");
		}		
		grupoUsuario.setPermisos(permisos);
		model.addAttribute("grupoUsuario", grupoUsuario);
		return new ModelAndView("grupoUsuario/detalle");
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id, Model model) {
		GrupoUsuario grupoUsuario = daoGrupoUsuario.findById(id);
		if (grupoUsuario == null) {
			return new ModelAndView("redirect:/grupoUsuario"); 
		}
		if (grupoUsuario.getClave().equals("admin")) {
			log.warn("No es posible modificar los permisos para el grupo \"admin\"");
			return new ModelAndView("redirect:/grupoUsuario");
		}
		List<Permiso> permisos = daoPermiso.findByGrupoUsuarioId(id);
		if (permisos == null) {
			log.warn("no se encontraron permisos para el grupoId: " + id);
			return new ModelAndView("redirect:/grupoUsuario/");
		}
		grupoUsuario.setPermisos(permisos);
		model.addAttribute("grupoUsuario", grupoUsuario);
		return new ModelAndView("grupoUsuario/editar");
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(
			@Valid @ModelAttribute("grupoUsuarioForm") GrupoUsuario nuevoGrupoUsuario,
			BindingResult result, Model model) {
		try {
			Date horaInicial = stringADate(nuevoGrupoUsuario.getHoraInicialJsp());
			Date horaFinal = stringADate(nuevoGrupoUsuario.getHoraFinalJsp());
			nuevoGrupoUsuario.setHoraInicial(horaInicial);
			nuevoGrupoUsuario.setHoraFinal(horaFinal);
		} catch (ParseException e) {
			e.printStackTrace();
			log.warn("Error en el formato de la hora");
			return new ModelAndView("redirect:/grupoUsuario/");
		}
		if (result.hasErrors()) {
			log.info("binding result tiene errores");
			return new ModelAndView("editar/" + nuevoGrupoUsuario.getId());
		}
		List<Permiso> permisosNuevos =  nuevoGrupoUsuario.getPermisos();
		List<Permiso> permisosViejos = daoPermiso.findByGrupoUsuarioId(nuevoGrupoUsuario.getId());
		int i = 0;
		for (Permiso permiso : permisosViejos) {
			permiso.setPermiso(permisosNuevos.get(i).getPermiso());
			daoPermiso.addOrUpdate(permiso);
			i++;
		}
		daoGrupoUsuario.addOrUpdate(nuevoGrupoUsuario);
		// mensaje agregado satisfactoriamente
		return new ModelAndView("redirect:/grupoUsuario");
	}

	private Date stringADate(String horaString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
		return sdf.parse(horaString);
	}


	private List<Permiso> inicializarPermisos(GrupoUsuario grupoUsuario) {
		List<Modulo> modulos = daoModulo.findAll();
		List<Permiso> permisos = new ArrayList<Permiso>();
		Permiso permiso ;
		for (Modulo modulo : modulos) {
			// acceso = 2 es para denegar todo acceso
			if(!modulo.getClave().equals("parametro")){
				if(modulo.getClave().equals("base")){
					log.info("entra al modulo base");
					permiso = new Permiso(grupoUsuario.getId(), modulo.getId(), 0, modulo.getNombre(), modulo.getClave());
					permisos.add(permiso);
				} else {
					permiso = new Permiso(grupoUsuario.getId(), modulo.getId(), 2, modulo.getNombre(), modulo.getClave());
					permisos.add(permiso);
				}
			}
		}
		log.info("los permisos que tiene son : " + permisos.size());
		return permisos;
	}
	
	/*
	private void grupoAForm(GrupoUsuario grupoUsuario, GrupoUsuarioForm grupoForm) {
		grupoForm.setClave(grupoUsuario.getClave());
		grupoForm.setHoraFinalJsp(grupoUsuario.getHoraFinalJsp());
		grupoForm.setHoraInicialJsp(grupoUsuario.getHoraInicialJsp());
		grupoForm.setId(grupoUsuario.getId());
		grupoForm.setNombre(grupoUsuario.getNombre());
		grupoForm.setPermisos(grupoUsuario.getPermisos());	}

	private void formAGrupo(GrupoUsuarioForm form, GrupoUsuario grupo) {
		grupo.setClave(form.getClave());
		grupo.setHoraFinalJsp(form.getHoraFinalJsp());
		grupo.setHoraInicialJsp(form.getHoraInicialJsp());
		grupo.setId(form.getId());
		grupo.setNombre(form.getNombre());
		grupo.setPermisos(form.getPermisos());
	}
	*/
}

