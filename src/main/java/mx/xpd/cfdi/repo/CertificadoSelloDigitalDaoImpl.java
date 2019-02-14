package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mx.xpd.cfdi.domain.CertificadoSelloDigital;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CertificadoSelloDigitalDaoImpl implements CertificadoSelloDigitalDao{
	
//	private Logger log = Logger.getLogger(CertificadoSelloDigitalDaoImpl.class);

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	private String tenantId;
	
	@SuppressWarnings("unchecked")
	@Override
	public CertificadoSelloDigital findById(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from CertificadoSelloDigital where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<CertificadoSelloDigital> tmp = (List<CertificadoSelloDigital>)query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public CertificadoSelloDigital findCurrent(String tenant) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from CertificadoSelloDigital where eliminado = 0 and semaforo = 0 and usar = 1 "
				+ " and tenant_id = :tenant";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		List<CertificadoSelloDigital> tmp = (List<CertificadoSelloDigital>)query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null; 
		}
		return tmp.get(0);
	}
	
	

	@Override
	public List<CertificadoSelloDigital> findAll() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CertificadoSelloDigital> criteria = cb.createQuery(CertificadoSelloDigital.class);
		Root<CertificadoSelloDigital> csd = criteria.from(CertificadoSelloDigital.class);
		criteria.select(csd).where(cb.equal(csd.get("eliminado"), 0))
		.orderBy(cb.asc(csd.get("fechaRegistro")));
		return em.createQuery(criteria).getResultList();
	}

	@Override
	public void add(CertificadoSelloDigital csd) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		if (csd.getUsar()) {
			setAllUsarNo();
		}
		em.persist(csd);
	}

	@Override
	public void addOrUpdate(CertificadoSelloDigital csd) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		if (csd.getUsar()) {
			setAllUsarNo();
		}
		csd.setUltimaActualizacion(new Date());
		em.merge(csd);
	}

	/*
	@Override
	public Boolean exists(Long id) {
		Query query = em
				.createQuery("from certificado_sello_digital where id = :id and eliminado = 0");
		query.setParameter("id", id);
		List<CertificadoSelloDigital> csd = query.getResultList();
		return csd.isEmpty() ? false : true;
	}
	*/
	
	@Override
	public Boolean remove(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CertificadoSelloDigital> criteria = cb.createQuery(CertificadoSelloDigital.class);
		Root<CertificadoSelloDigital> csd = criteria.from(CertificadoSelloDigital.class);
		criteria.select(csd).where(cb.equal(csd.get("id"), id));
		List<CertificadoSelloDigital> csds = em.createQuery(criteria).getResultList();
		if (csds.isEmpty()){
			return false;
		}
		csds.get(0).setEliminado(true);
		return true;
	}
	
	private void setAllUsarNo(){
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "update CertificadoSelloDigital set usar = 0";
		Query query = em.createQuery(strQuery);
		query.executeUpdate();
	}
	
	/*
	@Override
	public Boolean existe(String clave) {
		Query query = em
				.createQuery("from CertificadoSelloDigital where clave = :clave and eliminado = 0");
		query.setParameter("clave", clave);
		List<CertificadoSelloDigital> csd = query.getResultList();
		return csd.isEmpty() ? false : true;
	}
	*/
	
	@Override
	public void setTenantId(String rfcTenant) {
		this.tenantId = rfcTenant;
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
	}
	
}
