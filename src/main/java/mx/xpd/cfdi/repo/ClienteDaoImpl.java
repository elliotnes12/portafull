package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.map.MapCliente;
import mx.xpd.cfdi.domain.map.MapClienteJSON;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.util.SecurityUtil;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	private String tenantId;
	
	Logger log = LoggerFactory.getLogger(ClienteDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateClaveDes(MapCliente cliente) {
		String strQuery =  "UPDATE Cliente set claveDes = :claveDes where id = :id";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("claveDes", cliente.getName());
		query.setParameter("id", cliente.getId());
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateDes(MapCliente cliente) {
		String strQuery =  "UPDATE Cliente set razonSocialDes = :razonSocial where id = :id";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("razonSocial", cliente.getName());
		query.setParameter("id", cliente.getId());
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updateRFCDes(MapCliente cliente, String tenant) {
		String strQuery =  "UPDATE Cliente set rfcDes = :razonSocial where id = :id";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("razonSocial", cliente.getName());
		query.setParameter("id", cliente.getId());
		query.executeUpdate();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<MapCliente> findClMapClaveDes(String tenant) {
		String strQuery2 = "select id, clave as razonSocial, tenant_id from Cliente where eliminado = 0 and semaforo = 0"
				+ " and (claveDes is null or claveDes = '1') limit 2000";
		Query query2 = em.createNativeQuery(strQuery2, MapCliente.class);
		return (List<MapCliente>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapCliente> findAllMapRFCDes(String tenant) {
		String strQuery2 = "select id, rfc as razonSocial, tenant_id from Cliente where eliminado = 0 and semaforo = 0"
				+ " and (rfcDes is null or rfcDes = '') limit 2000";
		Query query2 = em.createNativeQuery(strQuery2, MapCliente.class);
		return (List<MapCliente>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findNuevos(String tenant, String fecha) {
		String strQuery2 = "select * from Cliente where tenant_id = '" + tenant + "' and fechaRegistro >= '" + fecha + "'";
		System.out.println(strQuery2);
		Query query2 = em.createNativeQuery(strQuery2, Cliente.class);
	//	query2.setParameter("tenant", tenant);
	//	query2.setParameter("fecha", fecha);
		return (List<Cliente>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapCliente> findAllMapDes() {
		String strQuery2 = "select id, razonSocial, tenant_id from Cliente where eliminado = 0 and semaforo = 0"
				+ " and (razonSocialDes is null or razonSocialDes = '') limit 2000";
		Query query2 = em.createNativeQuery(strQuery2, MapCliente.class);
		return (List<MapCliente>) query2.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(Cliente cliente) {
		try{
		cliente.setRazonSocialDes(cliente.getRazonSocial());
		log.info("entro a la parte de agregar cliente");
		log.info("valores que contiene el cliente son : " + cliente.getRazonSocial());
		log.info("y algun otro campos " + cliente.getResidenciaFiscal());
		em.persist(cliente);
		}catch(Exception e){
			log.info("excepcion " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Cliente cliente) {
		try {
			cliente.setRazonSocialDes(cliente.getRazonSocial());
			cliente.setRfcDes(cliente.getRfc());
			cliente.setClaveDes(cliente.getClave());
		} catch (LlavePrivadaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.merge(cliente);
	}

	@Override
	public Boolean remove(String tenant,Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenant);
		Cliente tmp = findById(tenant, id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		tmp.setUltimaActualizacion(new Date());
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll(String tenant) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Cliente where eliminado = 0 and semaforo = 0 "
				+ " and tenant_id = :tenant";		
		Query query = em.createQuery(strQuery, Cliente.class);
		query.setParameter("tenant", tenant);
		return (List<Cliente>) query.getResultList(); 
	}
	
	@SuppressWarnings("unchecked")
	public List<MapCliente> findAllMap(String tenant, String id) {
		id = id.toUpperCase();
		String strQuery2 = "select id, concat(razonSocialDes, ' <-> ', claveDes) as razonSocial, tenant_id from Cliente where  tenant_id = :tenantId "
				+ " AND eliminado = 0 and semaforo = 0" 
				+ " AND UPPER(razonSocialDes) LIKE :id"
				+ " limit 10";
		Query query2 = em.createNativeQuery(strQuery2, MapCliente.class);
		query2.setParameter("tenantId", tenant);
		query2.setParameter("id", "%" + id + "%");
		return (List<MapCliente>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapClienteJSON> findMapAll(String tenant) {
		String strQuery = "select id, claveDes as clave, rfcDes as rfc,"
				+ " razonSocialDes as razonSocial from Cliente "
				+ " where eliminado = 0 and semaforo = 0 and tenant_id = :tenant";		
		Query query = em.createNativeQuery(strQuery, MapClienteJSON.class);
		query.setParameter("tenant", tenant);
		return (List<MapClienteJSON>) query.getResultList(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cliente findById(String tenant, Long id) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenant);		
		String strQuery = "from Cliente where eliminado = 0 and semaforo = 0 and id = :id "
				+ " and tenant_id = :tenant";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		query.setParameter("tenant", tenant);
		List<Cliente> clientes = (List<Cliente>)query.getResultList();
		if (clientes == null || clientes.size() == 0) {
			return null;
		}
		return clientes.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<MapCliente> findAllMapRfc(String tenant, String id) {
		id = id.toUpperCase();
		String strQuery2 = "select id, rfcDes as razonSocial, tenant_id from Cliente where  tenant_id = :tenantId "
				+ " AND eliminado = 0 and semaforo = 0" 
				+ " AND UPPER(rfcDes) LIKE UPPER(:id)"
				+ " limit 10";
		
		Query query2 = em.createNativeQuery(strQuery2, MapCliente.class);
		query2.setParameter("tenantId", tenant);
		query2.setParameter("id", "%" + id + "%");
		return (List<MapCliente>) query2.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cliente findByClave(String tenant, String clave) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Cliente where eliminado = 0 and semaforo = 0 "
				+ " and tenant_id = :tenant and clave = :clave";
		Query query = em.createQuery(strQuery);
		try {
			String claveEncrypt = SecurityUtil.encryptString(clave);
			query.setParameter("clave", claveEncrypt);
			query.setParameter("tenant", tenant);
		} catch (Exception e) {
			log.info("error cuando se encripta la clave para hacer busqueda");
		}
		List<Cliente> tmp = (List<Cliente> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public Cliente findByRfc(String tenant, String rfc) {
		String strQuery = "from Cliente where eliminado = 0 and semaforo = 0 and tenant_id = :tenant and rfc = :rfc";
		Query query = em.createQuery(strQuery);
		try {
			String rfcEncrypt = SecurityUtil.encryptString(rfc);
			query.setParameter("tenant", tenant);
			query.setParameter("rfc", rfcEncrypt);
		} catch (Exception e) {
			log.info("error cuando se encripta el rfc o RS para hacer busqueda");
		}
		List<Cliente> tmp = (List<Cliente> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public Cliente findByRfcRS(String tenant, String rfc, String razonSocial) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Cliente where eliminado = 0 and semaforo = 0"
				+ " and tenant_id = :tenant and rfc = :rfc and razonSocial = :RS";
		Query query = em.createQuery(strQuery);
		try {
			String rfcEncrypt = SecurityUtil.encryptString(rfc);
			String rsEncrypt = SecurityUtil.encryptString(razonSocial);
			query.setParameter("rfc", rfcEncrypt);
			query.setParameter("RS", rsEncrypt);
			query.setParameter("tenant", tenant);
		} catch (Exception e) {
			log.info("error cuando se encripta el rfc o RS para hacer busqueda");
		}
		List<Cliente> tmp = (List<Cliente> )query.getResultList();
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
