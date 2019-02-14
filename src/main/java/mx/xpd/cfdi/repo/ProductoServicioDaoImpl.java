package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import mx.xpd.cfdi.domain.ProductoServicio;
import mx.xpd.cfdi.domain.map.MapProductoServicio;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProductoServicioDaoImpl implements ProductoServicioDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	private String tenantId;

	@SuppressWarnings("unchecked")
	@Override
	public ProductoServicio findById(Long id) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from ProductoServicio where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<ProductoServicio> tmp = (List<ProductoServicio> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<MapProductoServicio> findAllMap(String id) {
		String strQuery = "select id, nombre, clave from producto_servicio where tenant_id = :tenantId "
				+ " and eliminado = 0 and semaforo = 0"
				+ " and nombre like :id limit 10";
		
		Query query = em.createNativeQuery(strQuery, MapProductoServicio.class);
		query.setParameter("tenantId", tenantId);
		query.setParameter("id", "%" + id + "%");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<MapProductoServicio> findAllMapByClave(String clave) {
		String strQuery = "select id, nombre, clave from producto_servicio where tenant_id = :tenantId "
				+ " and eliminado = 0 and semaforo = 0"
				+ " and clave like :clave limit 10";
		
		Query query = em.createNativeQuery(strQuery, MapProductoServicio.class);
		query.setParameter("tenantId", tenantId);
		query.setParameter("clave", "%" + clave + "%");
		return query.getResultList();
	}

	@Override
	public ProductoServicio findByClave(String clave) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ProductoServicio> criteria = builder
				.createQuery(ProductoServicio.class);
		Root<ProductoServicio> productoServicio = criteria
				.from(ProductoServicio.class);
		criteria.select(productoServicio).where(
				builder.equal(productoServicio.get("clave"), clave),
				builder.equal(productoServicio.get("eliminado"), 0));
		// criteria.where(builder.equal(productoServicio.get("eliminado"), 0));
		List<ProductoServicio> productos = em.createQuery(criteria)
				.getResultList();
		if (!productos.isEmpty()) {
			return productos.get(0);
		}
		return null;
	}

	@Override
	public List<ProductoServicio> findAll(String tenant) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		/*CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProductoServicio> criteria = cb
				.createQuery(ProductoServicio.class);
		Root<ProductoServicio> productoServicio = criteria
				.from(ProductoServicio.class);
		criteria.select(productoServicio).where(
				cb.equal(productoServicio.get("eliminado"), 0));
		criteria.orderBy(cb.asc(productoServicio.get("clave")));
		// criteria.select(productoServicio).orderBy(cb.asc(productoServicio.get("clave")));
		return em.createQuery(criteria).getResultList();
		*/
		Query query = em.createQuery("from ProductoServicio where tenant_id = :tenant and eliminado = 0");
		query.setParameter("tenant", tenant);
		return query.getResultList();
	}

	@Override
	public void add(ProductoServicio productoServicio) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.persist(productoServicio);
	}

	@Override
	public void addOrUpdate(ProductoServicio productoServicio) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		productoServicio.setUltimaActualizacion(new Date());
		em.merge(productoServicio);
	}
	/*
	@Override
	public Boolean exists(Long id) {
		Query query = em
				.createQuery("from ProductoServicio where id = :id and eliminado = 0");
		query.setParameter("id", id);
		List<ProductoServicio> productos = query.getResultList();
		return productos.isEmpty() ? false : true;
	}
	
	@Override
	public Boolean existe(String clave) {
		Query query = em
				.createQuery("from ProductoServicio where clave = :clave and eliminado = 0");
		query.setParameter("clave", clave);
		List<ProductoServicio> productos = query.getResultList();
		return productos.isEmpty() ? false : true;
	}
	*/
	
	@Override
	public Boolean remove(Long id) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ProductoServicio> criteria = cb
				.createQuery(ProductoServicio.class);
		Root<ProductoServicio> producto = criteria.from(ProductoServicio.class);
		criteria.select(producto).where(cb.equal(producto.get("id"), id));
		List<ProductoServicio> productos = em.createQuery(criteria)
				.getResultList();
		if (!productos.isEmpty()) {
			productos.get(0).setEliminado(true);
			return true;
		}
		return false;
	}
	
	@Override
	public void setTenantId(String rfcTenant) {
		this.tenantId = rfcTenant;
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
	}
	
	@Override
	public Boolean existeProducto(String nombre, String tenant) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		Query query = em.createQuery("from ProductoServicio where tenant_id = :tenant and nombre = :nombre and eliminado = 0");
		query.setParameter("nombre", nombre);
		query.setParameter("tenant", tenant);
		List<ProductoServicio> productos = query.getResultList();
		return productos.isEmpty() ? false : true;
	}
	
}
