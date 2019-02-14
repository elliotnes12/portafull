package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.GrupoUsuario;
import mx.xpd.cfdi.domain.map.MapGrupoUsuario;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GrupoUsuarioDaoImpl implements GrupoUsuarioDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	private String tenantId;


	@Override
	public void add(GrupoUsuario grupoUsuario) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.persist(grupoUsuario);
	}

	@Override
	public GrupoUsuario addOrUpdate(GrupoUsuario grupoUsuario) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		return em.merge(grupoUsuario);
	}

	@Override
	public Boolean remove(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		GrupoUsuario tmp = findById(id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		tmp.setUltimaActualizacion(new Date());
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<MapGrupoUsuario> findAllMap() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "select id, nombre from GrupoUsuario where eliminado = 0 and semaforo = 0";
		strQuery += " AND tenant_id = '" + tenantId  +  "'" ;
		return em.createNativeQuery(strQuery, MapGrupoUsuario.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<MapGrupoUsuario> findAllMap(String tenant) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "select id, nombre from GrupoUsuario where eliminado = 0 and semaforo = 0";
		strQuery += " AND tenant_id = '" + tenant  +  "'" ;
		return em.createNativeQuery(strQuery, MapGrupoUsuario.class).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<GrupoUsuario> findAll() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from GrupoUsuario where eliminado = 0 and semaforo = 0";
		return (List<GrupoUsuario>) em.createQuery(strQuery).getResultList();
	}

	@Override
	public GrupoUsuario findById(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from GrupoUsuario where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		try {
			return (GrupoUsuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public GrupoUsuario findByClave(String clave) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from GrupoUsuario where eliminado = 0 and semaforo = 0 and clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		try {
			return (GrupoUsuario) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void setTenantId(String rfcTenant) {
		this.tenantId = rfcTenant;
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
	}
}
