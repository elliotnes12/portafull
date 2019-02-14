package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.Empleado;
import mx.xpd.cfdi.domain.Moneda;
import mx.xpd.cfdi.domain.map.MapCliente;
import mx.xpd.cfdi.domain.map.MapEmpleado;

@Repository
@Transactional
public class EmpleadoDaoImpl implements EmpleadoDao {

	
	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@Override
	public List<Empleado> find(String tenant) {
		String strQuery = "from Empleado where tenant_id = :tenant and eliminado = 0";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		return (List<Empleado>)query.getResultList();
		
	}
	
	
	public Empleado find(String tenant, Long id) {
		
		String strQuery = "from Empleado where tenant_id = :tenant and id = :id and eliminado = 0";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		query.setParameter("id", id);
		return (Empleado)query.getResultList().get(0);
	}
	
public Empleado findByRfc(String tenant, String rfc) {
		
		String strQuery = "from Empleado where tenant_id = :tenant and rfc = :rfc and eliminado = 0";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		query.setParameter("rfc", rfc);
		List<Empleado> emp = (List<Empleado>)query.getResultList();
		
		if (emp == null || emp.size() == 0) {
			return null;
		}
		return emp.get(0);
	
	}
	
	
	public boolean exists(String tenant, String numEmpleado, String rfc, String curp) {
		
		String strQuery = "SELECT COUNT(id) from Empleado where tenant_id = :tenant and numEmpleado = :numEmpleado and rfc = :rfc and curp = :curp and eliminado = 0";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		query.setParameter("numEmpleado", numEmpleado);
		query.setParameter("rfc", rfc);
		query.setParameter("curp", curp);
		Number count = (Number) query.getSingleResult(); 	
		
		return count.intValue() > 0 ? true : false;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapEmpleado> findByRazonSocial(String tenant, String razonSocial) {
		razonSocial = razonSocial.toUpperCase();
		String strQuery2 = "select id, concat(nombre, ' <-> ', numEmpleado) as razonSocial, tenant_id from Empleado where  tenant_id = :tenantId "
				+ " AND eliminado = 0" 
				+ " AND UPPER(nombre) LIKE :id"
				+ " limit 10";
		Query query2 = em.createNativeQuery(strQuery2, MapCliente.class);
		query2.setParameter("tenantId", tenant);
		query2.setParameter("id", "%" + razonSocial + "%");
		return (List<MapEmpleado>) query2.getResultList();
	}
		

	@Override
	public List<MapEmpleado> findAllMap(String tenant, String id) {
		String strQuery2 = "select id, concat(nombre, ' <-> ', curp) as razonSocial, tenant_id from Cliente where  tenant_id = :tenantId "
				+ " AND eliminado = 0 and semaforo = 0" 
				+ " AND UPPER(razonSocialDes) LIKE :id"
				+ " limit 10";
		Query query2 = em.createNativeQuery(strQuery2, MapCliente.class);
		query2.setParameter("tenantId", tenant);
		query2.setParameter("id", "%" + id + "%");
		return (List<MapEmpleado>) query2.getResultList();
	}

	@Override
	public void add(Empleado empleado) {
		em.persist(empleado);
	}

	@Override
	public void remove(Empleado empleado) {
		empleado.setEliminado(true);
		update(empleado);
	}
	
	@Override
	public Boolean remove(String tenant,Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenant);
		Empleado tmp = find(tenant, id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		tmp.setUltimaActualizacion(new Date());
		return true;
	}

	@Override
	public void update(Empleado empleado) {
		em.merge(empleado);
	}
	


}

