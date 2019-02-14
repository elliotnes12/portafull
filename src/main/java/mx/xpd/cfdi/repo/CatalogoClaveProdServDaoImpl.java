package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.CatalogoClaveProdServ;
import mx.xpd.cfdi.domain.Colonia;
import mx.xpd.cfdi.domain.map.MapCatalogoProductoServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CatalogoClaveProdServDaoImpl implements CatalogoClaveProdServDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@Override
	public List<CatalogoClaveProdServ> findAll() {
		String strQuery = "from CatalogoClaveProdServ";
		return (List<CatalogoClaveProdServ>) em.createQuery(strQuery).getResultList();
	}

	@Override
	public CatalogoClaveProdServ findById(Long id) {
		String strQuery = "from CatalogoClaveProdServ where id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<CatalogoClaveProdServ> tmp = (List<CatalogoClaveProdServ> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@Override
	public CatalogoClaveProdServ findByClave(String clave) {
		String strQuery = "from CatalogoClaveProdServ where clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<CatalogoClaveProdServ> tmp = (List<CatalogoClaveProdServ> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<MapCatalogoProductoServicio> findAllCatalogoClaveProdServ(String nombre) {
		String strQuery2 = "select * from CatalogoClaveProdServ where nombre like :nombre or clave like :clave";
		Query query2 = em.createNativeQuery(strQuery2, MapCatalogoProductoServicio.class);
		query2.setParameter("nombre",  "%"+nombre+"%");
		query2.setParameter("clave",  "%"+nombre+"%");
		return (List<MapCatalogoProductoServicio>) query2.getResultList();
	}
}
	
	