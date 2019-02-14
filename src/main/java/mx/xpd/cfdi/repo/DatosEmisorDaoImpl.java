package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.DatosEmisor;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DatosEmisorDaoImpl implements DatosEmisorDao
{
    @Autowired
    @Qualifier(value = "entityManager")
    private EntityManager em;
    private String tenantId;

    @Override
    public void update(DatosEmisor datosEmisor){
    	// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
    	em.merge(datosEmisor);
    }

    @Override
    public void recarga(DatosEmisor datosEmisor) {
    	em.merge(datosEmisor);
    }
    
    @Override
	@SuppressWarnings("unchecked")
	public List<DatosEmisor> findAll() {
    	em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from DatosEmisor where eliminado = 0 and semaforo = 0";
		return (List<DatosEmisor>) em.createQuery(strQuery).getResultList();
	}
    
	@Override
	@SuppressWarnings("unchecked")
	public DatosEmisor findEmisor(String tenant) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from DatosEmisor where eliminado = 0 and semaforo = 0 "
				+ "and tenant_id = :tenant_id";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant_id", tenant); 
		List<DatosEmisor> tmp = (List<DatosEmisor> )query.getResultList();
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

	@Override
	public DatosEmisor findByRfc(String rfc) {
		String strQuery = "from DatosEmisor where eliminado = 0 and semaforo = 0 and tenant_id = :rfc";
		Query query = em.createQuery(strQuery);
		query.setParameter("rfc", rfc);
		List<DatosEmisor> tmp = (List<DatosEmisor> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public DatosEmisor findByRfcCxP(String rfc) {
		String strQuery = "from DatosEmisor where eliminado = 0 and semaforo = 0 and cuentasPorPagar = 1 and tenant_id = :rfc";
		Query query = em.createQuery(strQuery);
		query.setParameter("rfc", rfc);
		List<DatosEmisor> tmp = (List<DatosEmisor> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
}
