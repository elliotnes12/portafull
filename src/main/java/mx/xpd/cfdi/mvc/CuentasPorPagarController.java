package mx.xpd.cfdi.mvc;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.xpd.cfdi.cxp.aprovisionamiento.JSONJWT;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.ParametroDao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nimbusds.jose.JOSEException;

@Controller
@RequestMapping(value = "/cuentasPorPagarLogin")
public class CuentasPorPagarController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	DatosEmisorDao datosEmisorDao;
	
	@Autowired
	ParametroDao parametroDao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String rfc = (String)session.getAttribute("tenantId");
		//-- Se eliminan espacios si llegara a tener;
		rfc = rfc.trim();
		log.info("RFC a loguearse en CxP: "+rfc);
		DatosEmisor datosEmisor = datosEmisorDao.findByRfcCxP(rfc);
		
		JSONJWT jsonjwt = new JSONJWT();
						
		String cadenaJSON = jsonjwt.getJWT(parametroDao.findByClave("PATH_PRIVATE_KEY_XPD").getValor(), 
				                           "expidetufactura.com.mx", 
				                           datosEmisor.getEmail(), 
				                           20);
		
		String urlLoginCxP = parametroDao.findByClave("URL_LOGIN_XPD_CXP").getValor();
		//-- Se reemplaza la palabra rfc por el RFC del usuario para el Rest.
		urlLoginCxP = urlLoginCxP.replace("rfc", rfc);
		//-- Se agrega el JWT serializado
		urlLoginCxP += cadenaJSON;
		
		log.info("URL login CxP: "+urlLoginCxP);		
		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", urlLoginCxP);
		response.setHeader("Connection", "close");
		response.setHeader("Cache-Control", "no-cache");
		return null;
	}

}
