package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.RegimenFiscal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RegimenFiscalDaoImpl implements RegimenFiscalDao {
	
	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	private String tenantId;
	
	@Override
	public void add(RegimenFiscal regimenFiscal) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.persist(regimenFiscal);
	}

	@Override
	public void update(RegimenFiscal regimenFiscal) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.merge(regimenFiscal);
	}
	
	@Override
	public Boolean remove(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		RegimenFiscal tmp = findById(id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		tmp.setUltimaActualizacion(new Date());
		return true;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<RegimenFiscal> findAll(String tenant) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from RegimenFiscal where eliminado = 0 and semaforo = 0 "
				+ " and tenant_id = :tenant";
		 
		Query query =  em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		return (List<RegimenFiscal>)query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public RegimenFiscal findById(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from RegimenFiscal where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<RegimenFiscal> tmp = (List<RegimenFiscal>) query.getResultList();
		if(tmp == null || tmp.size()==0){
			return null;
		}
		return tmp.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public RegimenFiscal findByClave(String clave) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from RegimenFiscal where eliminado = 0 and semaforo = 0 and clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<RegimenFiscal> tmp = (List<RegimenFiscal>) query.getResultList();
		if(tmp == null || tmp.size()==0){
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public void setTenantId(String rfcTenant) {
		this.tenantId = rfcTenant;
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
	}
}
