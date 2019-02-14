package mx.xpd.cfdi.security;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.Modulo;
import mx.xpd.cfdi.domain.Permiso;
import mx.xpd.cfdi.domain.Usuario;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.ModuloDao;
import mx.xpd.cfdi.repo.PermisoDao;
import mx.xpd.cfdi.repo.UsuarioDao;

//import org.hibernate.service.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authenticationProvider")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioDao userDao;
	@Autowired
	private PermisoDao permisoDao;
	@Autowired 
	private ModuloDao moduloDao;
	@Autowired
	private HttpServletRequest request;

	private Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		//	CustomUserDetails customDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getCredentials();

		// log.info("->" + customDetails.getRfc());
		 
		
		//log.info("------------> " + request.getSession().getAttribute("j_username"));
		/**/
		// log.info("------------> " + request.getSession().getAttribute("tenant_id"));
		 
		//org.jboss.tools.example.springmvc.domain.User userBean = userDao.findByUsername(username);
		log.info("LOGINNNN: " + username);
		String []data = username.split("\\|");
		username   = data[0];
		String clave = data[1];
		//userDao.setTenantId(rfc);
		userDao.setTenantId(username);
		Usuario usuario = userDao.findByClave(clave, username);
		/*try {
			System.out.println(usuario.getPassword());
		} catch (LlavePrivadaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		String roles = "";
		// permisoDao.setTenantId(rfc);
		List<Permiso> listaPermiso = permisoDao.findByGrupoUsuarioId(usuario.getGrupo());
		List<Modulo> modulos = moduloDao.findAll();
		
		
		for(Permiso permiso: listaPermiso){
			for(int i = 0; i<modulos.size() ; i++){
				if(permiso.getIdModulo()==modulos.get(i).getId()){
					if(permiso.getPermiso() == 0){
						roles += modulos.get(i).getClave() + "_";
						roles = roles + "MANAGER,";
					}
					else if(permiso.getPermiso() == 1){
						roles += modulos.get(i).getClave() + "_";
						roles = roles + "USER,";
					}
				}
			}
		}
		roles = roles.substring(0,roles.length()-1);
		log.info(roles);
		
		try {
			return new User(usuario.getClave(), usuario.getPassword(), 
					AuthorityUtils.commaSeparatedStringToAuthorityList(roles));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("error al obtener el password " + e.getMessage());
		}
		return null;
	}
	
}
