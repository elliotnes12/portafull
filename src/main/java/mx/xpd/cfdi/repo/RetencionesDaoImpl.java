package mx.xpd.cfdi.repo;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.Addenda;
import mx.xpd.cfdi.domain.CatalogosNomina;
import mx.xpd.cfdi.domain.CfdEmitido;
import mx.xpd.cfdi.domain.ComprobanteNoTimbrado;
import mx.xpd.cfdi.domain.RetencionesEmitido;
import mx.xpd.cfdi.domain.RetencionesNoTimbrado;
import mx.xpd.cfdi.domain.map.MapCfdGrafica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

@Repository
@Transactional
public class RetencionesDaoImpl implements RetencionesDao {
	
//	private Logger log = Logger.getLogger(ComprobanteDaoImpl.class);	
	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	
	@Override
	public boolean existeFolio(Integer folio, String tenant) {
		String strQuery =  "SELECT folio FROM retenciones_emitido WHERE tenant_id = :tenantId AND folio = :folio AND eliminado = 0";
	
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("folio", "" + folio);
		query.setParameter("tenantId", tenant);
		List result = query.getResultList();
		System.out.println(result.size());
		if (result == null || result.size() == 0) {
			return false;
		}
		else{
			return true;
		}
		
		
	}
	
	@Override
	public Integer getFolio(String serie, String tenant) {
		String strQuery =  "SELECT IFNULL(MAX(folio) + 1, 1) FROM retenciones_emitido WHERE tenant_id = :tenantId ";
		strQuery += " AND eliminado = 0";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("tenantId", tenant);
		
		return ((BigInteger)query.getResultList().get(0)).intValue();
		
	}
	
	@Override
	public void add(RetencionesEmitido retenciones) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.persist(retenciones);
	}
	
	@Override
	public void merge(RetencionesEmitido retenciones) {
		em.merge(retenciones);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean remove(Long id) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "Select * from retenciones_emitido where id = :id and eliminado = 0 and semaforo = 0";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("id", id);
		List<RetencionesEmitido> retenciones = query.getResultList();
		if (retenciones == null || retenciones.isEmpty()) {
			return false;
		}
		
				
		String strQueryUpdate = "UPDATE retenciones_emitido set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
		query = em.createNativeQuery(strQueryUpdate);
		query.setParameter("eliminado", true);
		query.setParameter("ultimaActualizacion", new Date());
		query.setParameter("id", id);
			
		query.executeUpdate();
		
		return true;
	}
	
	
	public void addRetencionesNoTimbrado(RetencionesNoTimbrado ret) {
		em.persist(ret);
	}
	
	@Override
	public List<RetencionesEmitido> findByDates(String tenant, String min, String max) {	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return findByDates(tenant, sdf.parse(min), sdf.parse(max));
		} catch (ParseException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<RetencionesEmitido> findByDates(String tenant, Date min, Date max) {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		
		df = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		
				
		String strQuery = "from RetencionesEmitido where tenant_id = :tenant_id  " +
				" and eliminado = 0 and semaforo = 0 " +
				" and fechaRegistro between :fecha1 and :fecha2  " +
				" order by fechaRegistro desc";
		
		
		System.out.println("-----------");
		System.out.println(min);
		System.out.println(df.format(max));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(max);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		List<RetencionesEmitido> result =  new ArrayList<RetencionesEmitido>();
		
		Query query = em.createQuery(strQuery);
		
		try {
			max = df.parse(df.format(max));
			
			
			query.setParameter("fecha1", df.parse(df.format(min)));
			query.setParameter("fecha2", cal.getTime());
		
			query.setParameter("tenant_id", tenant);
			List<RetencionesEmitido> tmp = query.getResultList();
			
			result =  new ArrayList<RetencionesEmitido>();
			result.addAll(tmp);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RetencionesEmitido findById(Long id) {
		String strQuery = "from RetencionesEmitido where id = :id and eliminado = 0 and semaforo = 0";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<RetencionesEmitido> ret = query.getResultList();
		
		return ret.get(0);
	}
	
	@Override
	public void cancelar(RetencionesEmitido retenciones) {
		retenciones.setUltimaActualizacion(new Date());
		
		String strQueryUpdate ="";
		String strQuery = "SELECT id from retenciones_emitido where uuid = :uuid";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("uuid", retenciones.getUuid());
		List<RetencionesEmitido> rets = query.getResultList();
		if(!rets.isEmpty()) {
			strQueryUpdate = "UPDATE retenciones_emitido set estatus = :estatus, fechaCancelacion = :fechaCancelacion, ultimaActualizacion = :ultimaActualizacion where id = :id";
		}
		
		
		query = em.createNativeQuery(strQueryUpdate);
		
		query.setParameter("estatus", retenciones.getEstatus());
		query.setParameter("fechaCancelacion", retenciones.getUltimaActualizacion());
		query.setParameter("ultimaActualizacion", retenciones.getUltimaActualizacion());
		query.setParameter("id", retenciones.getId());
			
		query.executeUpdate();
		
		
	}
	/*
	
	public List<CatalogosNomina> findCatalogo(String tipo) {
		String strQuery = "from CatalogosNomina where tipo = :tipo";
		Query q = em.createQuery(strQuery);
		q.setParameter("tipo", tipo);
		return 	q.getResultList();
	}
	

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Addenda> findAddendas(String tenant) {
		String strQuery = "from Addenda where tenant_id = :tenant and eliminado = 0 and semaforo = 0";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		return (List<Addenda>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CfdEmitido findByUuid(String uuid) {
		String strQuery = "from CfdEmitido where uuid = :uuid and eliminado = 0 and semaforo = 0 order by fechaRegistro desc";
		Query query = em.createQuery(strQuery);
		query.setParameter("uuid", uuid);
		List<CfdEmitido> cfds = query.getResultList();
		if(cfds == null || cfds.isEmpty()) {
			strQuery = "select * from cfd_emitido_octubre where uuid = :uuid and eliminado = 0 and semaforo = 0 order by fechaRegistro desc";
			query = em.createNativeQuery(strQuery, CfdEmitido.class);
			query.setParameter("uuid", uuid);
			cfds = query.getResultList();
			if(cfds == null || cfds.isEmpty()) {
				strQuery = "select * from cfd_emitido_junio where uuid = :uuid and eliminado = 0 and semaforo = 0 order by fechaRegistro desc";
				query = em.createNativeQuery(strQuery, CfdEmitido.class);
				query.setParameter("uuid", uuid);
				cfds = query.getResultList();
				if(cfds == null || cfds.isEmpty()) {
					return null;
				}
			}
		}
		return cfds.get(0);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public CfdEmitido findByUuid(String uuid, String tenant) {
		String strQuery = "from CfdEmitido where uuid = :uuid and eliminado = 0 and semaforo = 0 "
				+ " and tenant_id = :tenant order by fechaRegistro desc";
		Query query = em.createQuery(strQuery);
		query.setParameter("uuid", uuid);
		query.setParameter("tenant", tenant);
		List<CfdEmitido> cfds = query.getResultList();
		if(cfds == null || cfds.isEmpty()) {
			strQuery = "select * from cfd_emitido_octubre where uuid = :uuid and eliminado = 0 and semaforo = 0 "
					+ " and tenant_id = :tenant order by fechaRegistro desc";
			query = em.createNativeQuery(strQuery, CfdEmitido.class);
			query.setParameter("uuid", uuid);
			query.setParameter("tenant", tenant);
			cfds = query.getResultList();
			if(cfds == null || cfds.isEmpty()) {
				strQuery = "select * from cfd_emitido_junio where uuid = :uuid and eliminado = 0 and semaforo = 0 "
						+ " and tenant_id = :tenant order by fechaRegistro desc";
				query = em.createNativeQuery(strQuery, CfdEmitido.class);
				query.setParameter("uuid", uuid);
				query.setParameter("tenant", tenant);
				cfds = query.getResultList();
				if(cfds == null || cfds.isEmpty()) {
					return null;
			}
			
			}
		}
		return cfds.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CfdEmitido> findAll(String tenant) {
		List<CfdEmitido> result =  new ArrayList<CfdEmitido>();
		String strQuery = "from CfdEmitido where eliminado = 0 and semaforo = 0 and estatus is not null and fechaRegistro is not null "
				+ " and tenant_id = :tenant_id order by fechaRegistro desc";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant_id", tenant);
		List<CfdEmitido> tmp = query.getResultList();
		
		strQuery = "select * from cfd_emitido_octubre where eliminado = 0 and semaforo = 0 and estatus is not null and fechaRegistro is not null "
				+ " and tenant_id = :tenant_id order by fechaRegistro desc";
		query = em.createNativeQuery(strQuery, CfdEmitido.class);
		query.setParameter("tenant_id", tenant);
		List<CfdEmitido> tmp2 = query.getResultList();
		
		strQuery = "select * from cfd_emitido_junio where eliminado = 0 and semaforo = 0 and estatus is not null and fechaRegistro is not null "
				+ " and tenant_id = :tenant_id order by fechaRegistro desc";
		query = em.createNativeQuery(strQuery, CfdEmitido.class);
		query.setParameter("tenant_id", tenant);
		List<CfdEmitido> tmp3 = query.getResultList();
		
		if (tmp != null) {
			result.addAll(tmp);
		}
		
		if (tmp2 != null) {
			result.addAll(tmp2);
		}
		
		if (tmp3 != null) {
			result.addAll(tmp2);
		}
		return result;
	
	}
	
	
	
	
	
	
	
	

	
	*/
	
/*
	
	
	@Override
	public void actualizaEnviado(CfdEmitido comprobante) {
		comprobante.setUltimaActualizacion(new Date());
		
		String strQueryUpdate ="";
		String strQuery = "SELECT id from cfd_emitido where uuid = :uuid";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("uuid", comprobante.getUuid());
		List<CfdEmitido> cfds = query.getResultList();
		if(!cfds.isEmpty()) {
			strQueryUpdate = "UPDATE cfd_emitido set enviado = :enviado, ultimaActualizacion = :ultimaActualizacion where id = :id";
		}
		else{
			strQuery = "SELECT id from cfd_emitido_octubre where uuid = :uuid";
			query = em.createNativeQuery(strQuery);
			query.setParameter("uuid", comprobante.getUuid());
			cfds = query.getResultList();
			if(!cfds.isEmpty()) {
				strQueryUpdate = "UPDATE cfd_emitido_octubre set enviado = :enviado, ultimaActualizacion = :ultimaActualizacion where id = :id";
			}
			else{
				strQueryUpdate = "UPDATE cfd_emitido_junio set set enviado = :enviado, ultimaActualizacion = :ultimaActualizacion where id = :id";
			}
			
		}
		
				
		query = em.createNativeQuery(strQueryUpdate);
		query.setParameter("enviado", comprobante.getEnviado());
		query.setParameter("ultimaActualizacion", comprobante.getUltimaActualizacion());
		query.setParameter("id", comprobante.getId());
			
		query.executeUpdate();
		
		
	}
	
	@Override
	public void actualizaEliminado(CfdEmitido comprobante) {
		comprobante.setUltimaActualizacion(new Date());
		
		String strQueryUpdate ="";
		//1= cfd_emitido, 2= cfd_emitido_octubre, 3= cfd_emitido_junio
		String strQuery = "SELECT id from cfd_emitido where id = :id";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("id", comprobante.getId());
		List<CfdEmitido> cfds = query.getResultList();
		if(!cfds.isEmpty()) {
			strQueryUpdate = "UPDATE cfd_emitido set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
		}
		else{
			strQuery = "SELECT id from cfd_emitido_octubre where id = :id";
			query = em.createNativeQuery(strQuery);
			query.setParameter("id", comprobante.getId());
			cfds = query.getResultList();
			if(!cfds.isEmpty()) {
				strQueryUpdate = "UPDATE cfd_emitido_octubre set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
			}
			else{
				strQueryUpdate = "UPDATE cfd_emitido_junio set set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
			}
			
		}
		
			
		
		query = em.createNativeQuery(strQueryUpdate);
		query.setParameter("eliminado", true);
		query.setParameter("ultimaActualizacion", comprobante.getUltimaActualizacion());
		query.setParameter("id", comprobante.getId());
			
		query.executeUpdate();
		
		
	}
	
	

	@Override
	public void updateEnvuadi(CfdEmitido comprobante) {
		String query = "UPDATE cfd_emitido";
		query += " SET enviado = 1 WHERE id = :id";
		Query q = em.createNativeQuery(query);
		q.executeUpdate();
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapCfdGrafica> findByYear(Integer year, String estatus, String tenant) {
		//TODO agregar tenantId, eliminado y semáforo
		String strQuery = 	"SELECT Date_Format(fechaRegistro, '%c') as mes, " +
							"Date_Format(fechaRegistro, '%Y') as anio, count(*) as suma, estatus " +
							"FROM cfd_emitido where tenant_id = :tenantId and estatus = :estatus and " +
							"eliminado = 0 and semaforo = 0 " +
							"group by mes having anio = :year";
		String ini = "" + year + "-01-01";
		String fin = "" + year + "-12-31";
		
		strQuery = "SELECT Date_Format(fechaRegistro, '%c') as mes,  Date_Format(fechaRegistro, '%Y') as anio, "
				+ " count(*) as suma, estatus FROM cfd_emitido where tenant_id = :tenantId "
				+ " and fechaRegistro >= '" + ini + "' and fechaRegistro <= '" + fin + "' and estatus = :estatus "
				+ " and eliminado = 0 and semaforo = 0 group by mes having anio = :year and mes is not null";
		
		
		Query query = em.createNativeQuery(strQuery, MapCfdGrafica.class);
		query.setParameter("year", year);
		query.setParameter("estatus", estatus);
		query.setParameter("tenantId", tenant);
		List<MapCfdGrafica> tmp = query.getResultList();
		
		strQuery = "SELECT Date_Format(fechaRegistro, '%c') as mes,  Date_Format(fechaRegistro, '%Y') as anio, "
				+ " count(*) as suma, estatus FROM cfd_emitido_octubre where tenant_id = :tenantId "
				+ " and fechaRegistro >= '" + ini + "' and fechaRegistro <= '" + fin + "' and estatus = :estatus "
				+ " and eliminado = 0 and semaforo = 0 group by mes having anio = :year and mes is not null";
		
		
		query = em.createNativeQuery(strQuery, MapCfdGrafica.class);
		query.setParameter("year", year);
		query.setParameter("estatus", estatus);
		query.setParameter("tenantId", tenant);
		List<MapCfdGrafica> tmp2 = query.getResultList();
		
	
		strQuery = "SELECT Date_Format(fechaRegistro, '%c') as mes,  Date_Format(fechaRegistro, '%Y') as anio, "
				+ " count(*) as suma, estatus FROM cfd_emitido_junio where tenant_id = :tenantId "
				+ " and fechaRegistro >= '" + ini + "' and fechaRegistro <= '" + fin + "' and estatus = :estatus "
				+ " and eliminado = 0 and semaforo = 0 group by mes having anio = :year and mes is not null";
		
		
		query = em.createNativeQuery(strQuery, MapCfdGrafica.class);
		query.setParameter("year", year);
		query.setParameter("estatus", estatus);
		query.setParameter("tenantId", tenant);
		List<MapCfdGrafica> tmp3 = query.getResultList();
		
		List<MapCfdGrafica> result = new ArrayList<MapCfdGrafica>();
		
		if (tmp != null) { 
			result.addAll(tmp);
		}
		
		if (tmp2 != null) { 
			result.addAll(tmp2);
		}
		
		if (tmp3 != null) { 
			result.addAll(tmp3);
		}
		return result;
	}
*/
	
	
}
