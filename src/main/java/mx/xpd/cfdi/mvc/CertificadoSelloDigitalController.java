package mx.xpd.cfdi.mvc;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.CertificadoSelloDigital;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.exception.CertificadoException;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.exception.PasswordException;
import mx.xpd.cfdi.repo.CertificadoSelloDigitalDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.util.CertificadoUtil;
import mx.xpd.cfdi.util.KeyUtil;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/csd")
public class CertificadoSelloDigitalController {

	@Autowired
	private CertificadoSelloDigitalDao certificadoDao;
	@Autowired
	private DatosEmisorDao datosEmisorDao;
	private Logger log = Logger
			.getLogger(CertificadoSelloDigitalController.class);

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView mostrar(Model model, HttpServletRequest request) {
		String msg = (String)request.getParameter("msg");
		String error = (String)request.getParameter("error");
		if(msg != null && msg.length() > 0) {
			model.addAttribute("msg", msg);
			model.addAttribute("error", error);
		}
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		certificadoDao.setTenantId(tenantID);
		List<CertificadoSelloDigital> csds = certificadoDao.findAll();
		model.addAttribute("listaCSDs", csds);
		String deManifiesto = (String) request.getSession().getAttribute("phase2FromManifiesto");
		if(deManifiesto != null) {
			log.info("Redireccionado de manifiesto : [" + deManifiesto + "]");
			model.addAttribute("msg", deManifiesto);
			request.getSession().removeAttribute("phase2FromManifiesto");
		}
		return new ModelAndView("csd/mostrar");
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)//método get?
	public ModelAndView nuevoCsd() {
		return new ModelAndView("csd/nuevo", "csd",
				new CertificadoSelloDigital());
	}

	@RequestMapping(value = "/agregar")
	public ModelAndView agregar(
			@ModelAttribute("csd") CertificadoSelloDigital nuevoCsd,
			@RequestParam("archivo[]") MultipartFile file[], Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		String error = "";
		String url = "";
		error += this.procesarArchivo(nuevoCsd, file, tenantID);
		if (!error.equals("")) {
			model.addAttribute("nuevoCSD", nuevoCsd);
			model.addAttribute("error", error);
			return new ModelAndView("csd/nuevo");
		}

		certificadoDao.setTenantId(tenantID);
		certificadoDao.add(nuevoCsd);

		String msg = "CSD guardado correctamente";
		error = "0";
		url = "?msg=" + msg + "&error=" + error;
		return new ModelAndView("redirect:/csd");
	}

	@RequestMapping(value = "/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id, Model model) {
		CertificadoSelloDigital csd = certificadoDao.findById(id);
		return new ModelAndView("csd/editar", "csd", csd);
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(
			@ModelAttribute(value = "csd") CertificadoSelloDigital csdNuevo,
			@RequestParam("id")Long id,
			Model model) {
		CertificadoSelloDigital csdViejo = certificadoDao.findById(id);
		CertificadoSelloDigital csdTemp = new CertificadoSelloDigital();
		BeanUtils.copyProperties(csdViejo, csdTemp);
		csdTemp.setUsar(csdNuevo.getUsar());
		csdTemp.setComentario(csdNuevo.getComentario());
		certificadoDao.addOrUpdate(csdTemp);
		// mensaje agregado satisfactoriamente
		return new ModelAndView("redirect:/csd");
	}

	@RequestMapping(value = "/detalle/{id}")
	public ModelAndView detalle(@PathVariable("id")Long id, Model model) {
		CertificadoSelloDigital csd = certificadoDao.findById(id);
		if (csd ==  null) {
			return new ModelAndView("redirect:/csd"); 
		}
		return new ModelAndView("csd/detalle", "csd", csd);
	}

	private String addError(String mensaje) {
		return "<p>" + mensaje + "</p>";
	}

	private String procesarArchivo(CertificadoSelloDigital nuevoCsd, MultipartFile[] file, String tenant) {
		String error = "";
		boolean archivoVacio = false;

		if (file[0].isEmpty()) {
			archivoVacio = true;
			error += addError("Archivo .key Vacio");
		}
		if (file[1].isEmpty()) {
			archivoVacio = true;
			error += addError("Archivo .cer Vacio");
		}

		if (!archivoVacio) {
			try {
				nuevoCsd.setNombreArchivoKey(file[0].getOriginalFilename());
				nuevoCsd.setNombreArchivoCer(file[1].getOriginalFilename());
				KeyUtil keyUtil = new KeyUtil(file[0].getBytes(), false);
				CertificadoUtil certUtil = new CertificadoUtil(file[1].getBytes());
				

				if (nuevoCsd.getUsar()) {
					if (!certUtil.isVigente(new Date())) {
						log.info("certificado no vigente");
						error += addError("Certificado no vigente");
					}
				}
				
				DatosEmisor emisor = datosEmisorDao.findEmisor(tenant);
				
				if (!certUtil.getRfc().contains(emisor.getRfc())) {
			 		error += addError("El certificado no corresponde al RFC");
				}
				
				nuevoCsd.setNoSerie(certUtil.getNoSerie());
				nuevoCsd.setArchivoKey(keyUtil.getPemBase64(nuevoCsd.getContrasena()));
				nuevoCsd.setCertificado(certUtil.getCSDPemBase64(isPersonaFisica(emisor.getRfc())));
				nuevoCsd.setFechaInicio(certUtil.getCert().getNotBefore());
				nuevoCsd.setFechaFin(certUtil.getCert().getNotAfter());
				nuevoCsd.setUltimaActualizacion(new Date());
				if (!keyUtil.perteneceAlCert(certUtil.getCert())) {
					error += addError("El certificado y la llave no corresponden");
				}
			} catch (IOException e) {
				error += addError("Intentar de nuevo mas tarde");
			} catch (InterruptedException e) {
				error += addError("Intentar de nuevo mas tarde");
			} catch (LlavePrivadaException e) {
				error += addError("Archivo incorrecto");
			} catch (PasswordException e) {
				error += addError("Contraseña incorrecta");
			} catch (CertificateException e) {
				e.printStackTrace();
				error += addError("Certificado no es de tipo CSD");
			} catch (CertificadoException e) {
				e.printStackTrace();
				error += addError("Certificado no es de tipo CSD");
			} catch (InvalidKeySpecException e) {
				error += addError("Llave invalida");
			}
		} 

		return error;

	}
	
	private boolean isPersonaFisica(String tenant) {
		return tenant.length() == 13;
	}
}