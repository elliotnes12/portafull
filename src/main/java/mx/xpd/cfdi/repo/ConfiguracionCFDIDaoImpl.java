package mx.xpd.cfdi.repo;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.ConfiguracionCFDI;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ConfiguracionCFDIDaoImpl implements ConfiguracionCFDIDao
{
    @Autowired
    @Qualifier(value = "entityManager")
    private EntityManager em;
    private String tenantId;
    
//    private static final Logger log = Logger.getLogger("ConfiguracionCFDIDaoImpl");
    
    @Override
    public void update(ConfiguracionCFDI configuracionCFDI){
    	// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
    	em.merge(configuracionCFDI);
    }
    
    @Override
   	@SuppressWarnings("unchecked")
    public ConfiguracionCFDI findAll(String tenant) {
       	//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
   		String strQuery = "from ConfiguracionCFDI where eliminado = 0 and semaforo = 0 "
   				+ " and tenant_id = :tenant";
   		Query query = em.createQuery(strQuery); 
   		query.setParameter("tenant", tenant);
   		return (ConfiguracionCFDI) query.getResultList().get(0);
   	}
    
    @Override
	@SuppressWarnings("unchecked")
	public List<ConfiguracionCFDI> findAll() {
    	em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from ConfiguracionCFDI where eliminado = 0 and semaforo = 0";
		return (List<ConfiguracionCFDI>) em.createQuery(strQuery).getResultList();
	}
    
	@Override
	@SuppressWarnings("unchecked")
	public ConfiguracionCFDI findById(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from ConfiguracionCFDI where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<ConfiguracionCFDI> tmp = (List<ConfiguracionCFDI> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public ConfiguracionCFDI find() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from ConfiguracionCFDI where eliminado = 0 and semaforo = 0";
		Query query = em.createQuery(strQuery);		
		List<ConfiguracionCFDI> tmp = (List<ConfiguracionCFDI> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
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
