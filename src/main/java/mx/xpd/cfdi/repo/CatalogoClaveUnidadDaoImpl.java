package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.CatalogoClaveUnidad;
import mx.xpd.cfdi.domain.Colonia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CatalogoClaveUnidadDaoImpl implements CatalogoClaveUnidadDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@Override
	public List<CatalogoClaveUnidad> findAll() {
		String strQuery = "from CatalogoClaveUnidad";
		return (List<CatalogoClaveUnidad>) em.createQuery(strQuery).getResultList();
	}

	@Override
	public CatalogoClaveUnidad findById(Long id) {
		String strQuery = "from CatalogoClaveUnidad where id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<CatalogoClaveUnidad> tmp = (List<CatalogoClaveUnidad> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@Override
	public CatalogoClaveUnidad findByClave(String clave) {
		String strQuery = "from CatalogoClaveUnidad where clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<CatalogoClaveUnidad> tmp = (List<CatalogoClaveUnidad> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<CatalogoClaveUnidad> findAllCatalogoClaveUnidad(String nombre) {
		String strQuery2 = "select * from CatalogoClaveUnidad where nombre like :nombre";
		Query query2 = em.createNativeQuery(strQuery2, CatalogoClaveUnidad.class);
		query2.setParameter("nombre",  nombre);
		return (List<CatalogoClaveUnidad>) query2.getResultList();
	}
}
	
	