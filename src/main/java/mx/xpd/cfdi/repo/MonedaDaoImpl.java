package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.Moneda;
import mx.xpd.cfdi.domain.map.MapMoneda;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MonedaDaoImpl implements MonedaDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	private String tenantId;

	@Override
	public void add(Moneda moneda) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.persist(moneda);
	}

	@Override
	public void update(Moneda moneda) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.merge(moneda);
	}

	@Override
	public Boolean remove(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		Moneda tmp = findById(id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		tmp.setUltimaActualizacion(new Date());
		return true;
	}

	@Override
	public List<Moneda> findAll() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Moneda where eliminado = 0 and semaforo = 0";
		return (List<Moneda>) em.createQuery(strQuery).getResultList();
	}

	@Override
	public Moneda findById(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Moneda where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<Moneda> tmp = (List<Moneda> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@Override
	public Moneda findByClave(String clave) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Moneda where eliminado = 0 and semaforo = 0 and clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<Moneda> tmp = (List<Moneda> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<MapMoneda> findAllMap() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "select id, nombreCorto, tipoCambio from Moneda where eliminado = 0 and semaforo = 0"
				+ " AND tenant_id = :tenantID ";
		Query query = em.createNativeQuery(strQuery, MapMoneda.class);
		query.setParameter("tenantID", tenantId);
		return query.getResultList();
	}
	
	@Override
	public void setTenantId(String rfcTenant) {
		this.tenantId = rfcTenant;
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
	}
	
	@SuppressWarnings("unchecked")
	public String findClaveMoneda(String strMoneda) {
		String strQuery = "select id from MonedaComercioExterior where nombre = :strMoneda";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("strMoneda", strMoneda);
		List<String> tmp = (List<String> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
}
