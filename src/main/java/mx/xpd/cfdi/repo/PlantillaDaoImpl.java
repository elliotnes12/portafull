package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.ConfiguracionPlantilla;
import mx.xpd.cfdi.domain.Plantilla;

import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PlantillaDaoImpl implements PlantillaDao
{
    @Autowired
    @Qualifier(value = "entityManager")
    private EntityManager em;
    private String tenantId;
    
    private static final Logger log = Logger.getLogger("PlantillaDaoImpl");
    
    @Override
    public void update(ConfiguracionPlantilla plantilla){
    	em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
    	em.merge(plantilla);
    }

    @Override
	@SuppressWarnings("unchecked")
	public List<ConfiguracionPlantilla> findAll() {
    	em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from ConfiguracionPlantilla where eliminado = 0 and semaforo = 0";
		return (List<ConfiguracionPlantilla>) em.createQuery(strQuery).getResultList();
	}
    
    @Override
	@SuppressWarnings("unchecked")
	public ConfiguracionPlantilla find() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from ConfiguracionPlantilla where eliminado = 0 and semaforo = 0";
		Query query = em.createQuery(strQuery);
		List<ConfiguracionPlantilla> tmp = (List<ConfiguracionPlantilla> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
    
    @Override
	@SuppressWarnings("unchecked")
	public ConfiguracionPlantilla find(String tenant) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from ConfiguracionPlantilla where eliminado = 0 and semaforo = 0 "
				+ " AND tenant_id = :tenant";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		List<ConfiguracionPlantilla> tmp = (List<ConfiguracionPlantilla> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
    
	@Override
	@SuppressWarnings("unchecked")
	public ConfiguracionPlantilla findById(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from ConfiguracionPlantilla where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<ConfiguracionPlantilla> tmp = (List<ConfiguracionPlantilla> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Plantilla> findAllPlantillas() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Plantilla where eliminado = 0 and semaforo = 0";
		return (List<Plantilla>)em.createQuery(strQuery).getResultList();
	}
	
	@Override
    public void setTenantId(String rfcTenant) {
    	this.tenantId = rfcTenant;
    	em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
    }
}
