package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.LugarExpedicion;
import mx.xpd.cfdi.domain.map.MapLugarExpedicion;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LugarExpedicionDaoImpl implements LugarExpedicionDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	private String tenantId;

	@Override
	public void add(LugarExpedicion lugar) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.persist(lugar);
	}

	@Override
	public void update(LugarExpedicion lugar) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.merge(lugar);
	}

	@Override
	public Boolean remove(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		LugarExpedicion tmp = findById(id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		//tmp.setUltimaActualizacion(new Date());
		return true;
	}

	@Override
	public List<LugarExpedicion> findAll() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from LugarExpedicion where eliminado = 0 and semaforo = 0";
		return (List<LugarExpedicion>) em.createQuery(strQuery).getResultList();
	}

	@Override
	public LugarExpedicion findById(Long id) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from LugarExpedicion where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<LugarExpedicion> tmp = (List<LugarExpedicion> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@Override
	public LugarExpedicion findByClave(String clave) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from LugarExpedicion where eliminado = 0 and semaforo = 0 and clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<LugarExpedicion> tmp = (List<LugarExpedicion> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public LugarExpedicion findLugarExpedicion(String tenant) {
		String strQuery = "from LugarExpedicion where eliminado = 0 and tenant_id = :tenant_id";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant_id", tenant); 
		List<LugarExpedicion> tmp = (List<LugarExpedicion> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<MapLugarExpedicion> findAllMap() {
		String strQuery = "select id, codigoPostal, nombre from LugarExpedicion where eliminado = 0 and semaforo = 0 and tenant_id = :tenant_id";
		return em.createNativeQuery(strQuery, MapLugarExpedicion.class).setParameter("tenant_id", tenantId).getResultList();
	}
	
	@Override
	public void setTenantId(String rfcTenant) {
		this.tenantId = rfcTenant;
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
	}
	
	
}
