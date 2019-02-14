package mx.xpd.cfdi.repo;

import javax.persistence.EntityManager;

import mx.xpd.cfdi.domain.CancelacionScript;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CancelacionScriptDaoImpl implements CancelacionScriptDao {
	
//	private Logger log = Logger.getLogger(ComprobanteDaoImpl.class);	
	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
			
	@Override
	public void merge(CancelacionScript cancelacionScript) {
		em.merge(cancelacionScript);
	}

	@Override
	public void add(CancelacionScript cancelacionScript) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.persist(cancelacionScript);
	}
	
	

}