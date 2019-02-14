package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.Permiso;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PermisoDaoImpl implements PermisoDao {
	
	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	private String tenantId;

	@SuppressWarnings("unchecked")
	@Override
	public Permiso findById(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Permiso where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<Permiso> permisos = (List<Permiso>)query.getResultList();
		if (permisos == null || permisos.isEmpty()) {
			return null;
		}
		return permisos.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Permiso> findByGrupoUsuarioId(Long grupoUsuarioId) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Permiso where eliminado = 0 and semaforo = 0 and idGrupoUsuario = :grupoUsuarioId";
		Query query = em.createQuery(strQuery);
		query.setParameter("grupoUsuarioId", grupoUsuarioId);
		List<Permiso> permisos = (List<Permiso>)query.getResultList();
		if (permisos.isEmpty() || permisos == null) {
			return null;
		}
		return permisos; 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Permiso> findAll() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Permiso where eliminado = 0 and semaforo = 0";
		return (List<Permiso>) em.createQuery(strQuery).getResultList();
	}

	@Override
	public void add(Permiso permiso) {
		em.persist(permiso);
	}
	
	@Override
	public void addAll(List<Permiso> permisos) {
		for (Permiso permiso : permisos) {
			add(permiso);
		}
	}

	@Override
	public void addOrUpdate(Permiso permiso) {
		em.merge(permiso);
	}

	@Override
	public Boolean remove(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		Permiso tmp = findById(id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		//tmp.setUltimaActualizacion(new Date());
		return true;
	}
	
	@Override
	public void setTenantId(String rfcTenant) {
		this.tenantId = rfcTenant;
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
	}

}
