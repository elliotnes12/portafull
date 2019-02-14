package mx.xpd.cfdi.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.Usuario;
import mx.xpd.cfdi.domain.map.MapGrupoUsuario;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.AuditoriaDao;
import mx.xpd.cfdi.repo.CertificadoSelloDigitalDao;
import mx.xpd.cfdi.repo.ClienteDao;
import mx.xpd.cfdi.repo.ComprobanteDao;
import mx.xpd.cfdi.repo.ConfiguracionCFDIDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.GrupoUsuarioDao;
import mx.xpd.cfdi.repo.LugarExpedicionDao;
import mx.xpd.cfdi.repo.MonedaDao;
import mx.xpd.cfdi.repo.PermisoDao;
import mx.xpd.cfdi.repo.PlantillaDao;
import mx.xpd.cfdi.repo.ProductoServicioDao;
import mx.xpd.cfdi.repo.RegimenFiscalDao;
import mx.xpd.cfdi.repo.UsuarioDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
@RequestMapping("/rest/usuario")
public class UsuarioRestController {
	
	@Autowired
	private AuditoriaDao auditoriaDao;
	@Autowired
	private CertificadoSelloDigitalDao csdDao;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private ComprobanteDao comprobanteDao;
	@Autowired
	private ConfiguracionCFDIDao configDao;
	@Autowired
	private DatosEmisorDao datosEmisorDao;
	@Autowired
	private GrupoUsuarioDao grupoUsuarioDao;
	@Autowired
	private LugarExpedicionDao lugarExpedicionDao;
	@Autowired
	private MonedaDao monedaDao;
	@Autowired
	private PermisoDao permisoDao;
	@Autowired
	private PlantillaDao plantillaDao;
	@Autowired
	private ProductoServicioDao productoDao;
	@Autowired
	private RegimenFiscalDao regimenFiscalDao;
	@Autowired
	private UsuarioDao userDao;

	@Autowired
	private UsuarioDao daoUsuarios;
	
	Logger log = LoggerFactory.getLogger(UsuarioRestController.class);

	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.GET)
    public @ResponseBody Boolean eliminar(@PathVariable("id") Long id) {
		return daoUsuarios.remove(id);
    }
	
	@RequestMapping(value="/listar/id", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MapGrupoUsuario> listarById() {
		// return daoUsuarios.findAllMap();
		return null;
    }
	
	@RequestMapping(value="/existe/{clave}", method=RequestMethod.GET)
    public @ResponseBody Boolean existe(@PathVariable("clave") String clave) {
		if (daoUsuarios.findByClave(clave) != null) {
			return true;
		} 
		return false;
	}
	
	@RequestMapping(value="/{id}/{pass}", method=RequestMethod.GET)
    public @ResponseBody String checaPass(@PathVariable("id") Long id, @PathVariable("pass") String password,
    		HttpServletRequest request) throws LlavePrivadaException {
		
			
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		if (daoUsuarios.findById(id, tenantID) != null) {
			Usuario usuario =daoUsuarios.findById(id, tenantID);
			if(password.equals(usuario.getPassword()) || password.equals(usuario.getPassword2()) || password.equals(usuario.getPassword3()) ){
				return "passwordDuplicado";
			}
			else
				return "passwordCorrecto";
		} 
		return "noExisteUsuario";
	}
	
	@RequestMapping(value="/bloqueado/{username}/{rfc}/{origen}", method=RequestMethod.GET)
    public @ResponseBody String bloqueado(
    			@PathVariable("username") String username,
    			@PathVariable("rfc") String rfc,
    			@PathVariable("origen") String origen) {	
		userDao.setTenantId(rfc);
		/*
		RequestContextHolder.currentRequestAttributes().setAttribute(
								"tenantId", rfc, RequestAttributes.SCOPE_SESSION);
		
		userDao.setTenantId(rfc);
		auditoriaDao.setTenantId(rfc);
		csdDao.setTenantId(rfc);
		clienteDao.setTenantId(rfc);
		comprobanteDao.setTenantId(rfc);
		configDao.setTenantId(rfc);
		datosEmisorDao.setTenantId(rfc);
		grupoUsuarioDao.setTenantId(rfc);
		lugarEmisionDao.setTenantId(rfc);
		monedaDao.setTenantId(rfc);
		permisoDao.setTenantId(rfc);
		plantillaDao.setTenantId(rfc);
		productoDao.setTenantId(rfc);
		regimenFiscalDao.setTenantId(rfc);
		unidadDao.setTenantId(rfc);
		*/
		Date nuevoIntento = new Date();
		daoUsuarios.intento(username);
		Usuario usuario = daoUsuarios.findByClave(username);			
		
		if (usuario != null) {
			log.info("" + usuario.isBloqueado());
			if (usuario.isBloqueado()) {
				return "bloqueado";
			} else {
				return "correcto";
			}
		}
		return "noExiste";
	}
	
	

}
