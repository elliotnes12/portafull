package mx.xpd.cfdi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.xpd.cfdi.cxp.aprovisionamiento.DesEncryptJWT;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.Usuario;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.repo.UsuarioDao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

@Controller
@RequestMapping(value="/rest/static/login")
public class LoginCuentasPorPagarController {

	private Logger log = Logger.getLogger(this.getClass());
			
	@Autowired
	private DatosEmisorDao datosEmisorDao;	
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private ParametroDao parametroDao;
	
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	public String index(@RequestParam("jwt")String jwt, HttpServletRequest request, HttpServletResponse response) {
		log.info("JWT Recibido: "+jwt);
		
		try{
			
			DesEncryptJWT desEncryptJWT = new DesEncryptJWT();
			DatosEmisor datosEmisor;
			
			String rfc = desEncryptJWT.getRFCByJWT(parametroDao.findByClave("CERTIFICADO_CXP").getValor(), jwt);
			
			if(rfc != null)
			  datosEmisor = datosEmisorDao.findByRfcCxP(rfc);
			else
			  return "login";
			
			if(datosEmisor != null){
			   Usuario usr = usuarioDao.findByClave("admin", datosEmisor.getRfc().trim());			   
			   log.info("Redirigiendo...");
			   log.info("-- Datos --");
			   log.info("username: "+datosEmisor.getRfc().trim()+" password: "+usr.getPassword());
			   String url = "/j_spring_security_check?j_username="+URLEncoder.encode(datosEmisor.getRfc().trim(),"UTF-8")+"&j_password="+URLEncoder.encode(usr.getPassword(),"UTF-8")+"&rfc=admin";
			   return "redirect:"+url;
			}else{
			  return "login";
			}
		}catch(Exception e){
			log.error("Exception en "+this.getClass().getSimpleName());
			e.printStackTrace();
		}
		return "login";
	}
	
}
