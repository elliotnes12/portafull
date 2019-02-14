package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.Usuario;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	private String tenantId;
	
	private Logger log = Logger.getLogger(UsuarioDaoImpl.class);
	
	@Override
	public void add(Usuario Usuario) {
		em.persist(Usuario);
	}

	@Override
	public void update(Usuario Usuario) {
		em.merge(Usuario);
	}

	@Override
	public Boolean remove(Long id) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		Usuario tmp = findById(id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		tmp.setUltimaActualizacion(new Date());
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll(String tenant) {
//		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Usuario where eliminado = 0 and semaforo = 0 "
				+ " and tenant_id = :tenant" ;
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		return (List<Usuario>) query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Usuario findById(Long id, String tenant) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Usuario where eliminado = 0 and semaforo = 0 and id = :id "
				+ " and tenant_id = :tenant";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		query.setParameter("tenant", tenant);
		List<Usuario> tmp = (List<Usuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	

	public Usuario findById(Long id) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Usuario where eliminado = 0 and semaforo = 0 and id = :id ";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<Usuario> tmp = (List<Usuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Usuario findByUser(String name) {
//		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Usuario where eliminado = 0 and semaforo = 0 and clave = :name";
		Query query = em.createQuery(strQuery);
		query.setParameter("name", name);
		List<Usuario> tmp = (List<Usuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Usuario findByClave(String clave, String tenant) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Usuario where eliminado = 0 and semaforo = 0 and clave = :clave "
				+ " and tenant_id = :tenant";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		query.setParameter("tenant", tenant);
		// query.setParameter("clave", "admin");
		List<Usuario> tmp = (List<Usuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public Usuario findByClave(String clave) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Usuario where eliminado = 0 and semaforo = 0 and clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<Usuario> tmp = (List<Usuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Boolean correcto(String name, String password) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Usuario where eliminado = 0 and semaforo = 0 and clave = :name and password = :password";
		Query query = em.createQuery(strQuery);
		query.setParameter("name", name);
		query.setParameter("password", password);
		List<Usuario> tmp = (List<Usuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			log.info("no se encontro el usuario" + name);
			return false;
		}
		return true;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public String accesoCorrecto(String username) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Usuario where eliminado = 0 and semaforo = 0 and clave = :username";
		Query query = em.createQuery(strQuery);
		query.setParameter("username", username);
		List<Usuario> tmp = (List<Usuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return "errorLogin";
		}
		Usuario usuario = (Usuario) tmp.get(0);
		Date nuevo = new Date();
		usuario.setFechaIntento(nuevo);
		usuario.setBloqueoHasta(nuevo);
		usuario.setIntentos(0);
		usuario.setUltimoAcceso(nuevo);
		update(usuario);
		return "correcto";
	}
	
	@Override
	public void intento(String username) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		Usuario usuario = findByClave(username);
		if (usuario == null) {
			return ;
		}
		//usuario = tmp.get(0);
		int intentos = usuario.getIntentos();
		Date nuevaFecha = new Date();
		Date fechaIntento = new Date();
		fechaIntento.setTime(usuario.getFechaIntento().getTime() + 900000); 
		
		log.info("la fecha de intento + 15 minutos = " + fechaIntento);
		if(nuevaFecha.compareTo(fechaIntento) >= 1){
			intentos = 0;
		}
		
		if(usuario.getBloqueado()==true){
			if(nuevaFecha.compareTo(usuario.getBloqueoHasta())>=0){
				usuario.setBloqueado(false);
			}
		}
		if(usuario.getBloqueado()==true){
			return;
		}
		intentos +=1;
		usuario.setIntentos(intentos);
		usuario.setFechaIntento(new Date());
		if(intentos>3){
			usuario.setIntentos(0);
			usuario.setBloqueado(true);
			Date bloqueadoHasta = new Date();
			bloqueadoHasta.setTime(usuario.getFechaIntento().getTime() + 900000);
			usuario.setBloqueoHasta(bloqueadoHasta);
		}
		update(usuario);
		return ;
	}

	@Override
	public void setTenantId(String rfcTenant) {
		// ("tenantId: " + rfcTenant);
		this.tenantId = rfcTenant;
	}
	
}
