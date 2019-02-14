package mx.xpd.cfdi.security;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.xpd.cfdi.constantes.URLConstants;
import mx.xpd.cfdi.domain.ConfiguracionCFDI;
import mx.xpd.cfdi.domain.DatosEmisor;
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
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomSecurityInterceptor implements HandlerInterceptor {

	private Logger log = LoggerFactory
			.getLogger(CustomSecurityInterceptor.class);

	@Autowired
	private DatosEmisorDao daoEmisor;
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
	private ConfiguracionCFDIDao confDao;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		final String rfc = (String)session.getAttribute("tenantId");	
	
		
		if (request.getServletPath().contains("/static/")) {
			return true;
		}

		if (request.getServletPath().equals("/login/")
				|| request.getServletPath().equals("/login")
				|| request.getServletPath().equals("/azumedLogin")
				|| request.getServletPath().contains("XPD")
				|| request.getServletPath().equals("/j_spring_security_check")
				|| request.getServletPath().contains("/rest/usuario/bloqueado/")
				|| request.getServletPath().contains("/registrarUsuario/registrar")
				|| request.getServletPath().contains("/usuario/reiniciarContrasena")
				|| request.getServletPath().contains("/usuario/password")
				|| request.getServletPath().contains("/usuario/reset")
				|| request.getServletPath().contains("/usuario/generaCodigoRescate")
				|| request.getServletPath().contains("/rest/cliente/nuevos")
				|| request.getServletPath().contains("/rest/cliente/agregar")
				|| request.getServletPath().contains("/registrarUsuario")
				|| request.getServletPath().contains("/rest/estado")
				|| request.getServletPath().contains("descargarplantilla")) {
			datosEmisorDao.setTenantId(rfc);
			return true;
		}

		if (session.getAttribute("tenantId") == null) {
			log.info("Acceso denegado.");
			response.sendRedirect(request.getContextPath() + "/login/");
		} else {
			
			
			userDao.setTenantId(rfc);
			auditoriaDao.setTenantId(rfc);
			csdDao.setTenantId(rfc);
			clienteDao.setTenantId(rfc);
			configDao.setTenantId(rfc);
			datosEmisorDao.setTenantId(rfc);
			grupoUsuarioDao.setTenantId(rfc);
			lugarExpedicionDao.setTenantId(rfc);
			monedaDao.setTenantId(rfc);
			permisoDao.setTenantId(rfc);
			plantillaDao.setTenantId(rfc);
			productoDao.setTenantId(rfc);
			regimenFiscalDao.setTenantId(rfc);
			
			datosEmisorDao.setTenantId(rfc);
			DatosEmisor emisor = daoEmisor.findEmisor(rfc);
			configDao.setTenantId(rfc);
			ConfiguracionCFDI confCfdi = configDao.find();
			
			if (emisor != null) {
				if (emisor.getPaso() == -1) {
					emisor.setPaso(5);
					daoEmisor.update(emisor);
					response.sendRedirect(URLConstants.FIRMAR_MANIFIESTO);
				}
				
				session.setAttribute("gratuito", emisor.isGratuito());
				session.setAttribute("rfc", rfc);
				session.setAttribute("razonSocial", emisor.getRazonSocial());
				session.setAttribute("foliosDisponibles", emisor.getFoliosDisponibles());
				session.setAttribute("tipoComprobante", confCfdi.getTipoComprobante());
				session.setAttribute("tipoPlan", emisor.getTipoPlan());
				if (emisor.getTipoPlan() == true)
					session.setAttribute("fechaVencimiento", emisor.getFechaVencimiento().substring(0, 10));
				else{
					String strUltimaCompra = emisor.getUltimaCompra();
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
						session.setAttribute("ultimaCompra", strUltimaCompra);
					}
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}