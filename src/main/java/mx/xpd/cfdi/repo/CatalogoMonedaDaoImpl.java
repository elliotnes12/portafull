package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.CatalogoMoneda;
import mx.xpd.cfdi.domain.map.MapCatalogoMoneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CatalogoMonedaDaoImpl implements CatalogoMonedaDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@Override
	public List<CatalogoMoneda> findAll() {
		String strQuery = "from CatalogoMoneda";
		return (List<CatalogoMoneda>) em.createQuery(strQuery).getResultList();
	}

	@Override
	public CatalogoMoneda findById(Long id) {
		String strQuery = "from CatalogoMoneda where id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<CatalogoMoneda> tmp = (List<CatalogoMoneda> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@Override
	public CatalogoMoneda findByClave(String clave) {
		String strQuery = "from CatalogoMoneda where clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<CatalogoMoneda> tmp = (List<CatalogoMoneda> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	

	
	@SuppressWarnings("unchecked")
	public String findClaveCatalogoMoneda(String strMoneda) {
		String strQuery = "select id from CatalogoMoneda where nombre = :strMoneda";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("strMoneda", strMoneda);
		List<String> tmp = (List<String> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
}
