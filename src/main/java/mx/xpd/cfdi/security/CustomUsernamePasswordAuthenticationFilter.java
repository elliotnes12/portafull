package mx.xpd.cfdi.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import mx.xpd.cfdi.util.XPDUsernamePasswordAuthenticationFilter;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.context.WebApplicationContext;

public class CustomUsernamePasswordAuthenticationFilter extends
		XPDUsernamePasswordAuthenticationFilter {

	@Autowired
	private ApplicationContext appContext;
	private Logger log = Logger
			.getLogger(CustomUsernamePasswordAuthenticationFilter.class);

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
	
	@Autowired
	private WebApplicationContext context;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

		// final String rfc = request.getParameter("rfc");
		final String rfc = request.getParameter("j_username");//  + "|" + request.getParameter("rfc");
		request.setAttribute("j_username", request.getParameter("j_username") + "|" + request.getParameter("rfc"));
		request.getSession().setAttribute("tenantId", rfc);

		request.setAttribute("j_username", request.getParameter("j_username") + "|" + request.getParameter("rfc"));
		request.getSession().setAttribute("origen", request.getParameter("origen"));
		
		System.out.println(request.getAttribute("j_username"));
		//System.out.println(request.getParameter("j_password")); 
		System.out.println(request.getParameter("j_password1"));
		
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
		configDao.setTenantId(rfc);

		datosEmisorDao.setTenantId(rfc);
		DatosEmisor emisor = datosEmisorDao.findEmisor(rfc);
		
		
		request.getSession().setAttribute("razonSocial", emisor.getRazonSocial());

		/*
		 * WrapperDataSource ds =
		 * (WrapperDataSource)appContext.getBean("dataSource"); // <property
		 * name="driverClassName" value="org.h2.Driver" /> // <property
		 * name="url" value="jdbc:h2:target/db/testdb" /> // <property
		 * name="username" value="sa" /> // <property name="password" value=""
		 * /> ds.setDriverClassName("com.mysql.jdbc.Driver");
		 * ds.setPassword("wip"); ds.setUsername("root");
		 * ds.setUrl("jdbc:mysql://localhost/xpd");
		 * 
		 * // mx.xpd.cfdi.security.CustomUsernamePasswordAuthenticationFilter c;
		 */

		
		if(request.getParameter("origen").equals("default")){
		   request.getSession().setAttribute("tipo","default");
		}
		else
		{
		   request.getSession().setAttribute("tipo","azumed");
		}
		
		// asignando el rfc como tenantId
		log.info("autenticando");
		clienteDao.setTenantId(rfc);
		Authentication auth = super.attemptAuthentication(request, response);
		
		log.info("autenticado");
		if (!auth.isAuthenticated()) {
			userDao.intento(request.getParameter("j_username"));
		}
		request.getSession().setAttribute("razonSocial", emisor.getRazonSocial());
		request.getSession().setAttribute("gratuito", emisor.getGratuito());
		 
		return auth;
	}

}
