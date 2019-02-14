package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CatalogoZonaHorariaDaoImpl implements CatalogoZonaHorariaDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public String findZonaHoraria(String cp) {
		String strQuery = "SELECT zona FROM CatalogoZonaHoraria WHERE codigo_postal = :cp";
		Query q = em.createNativeQuery(strQuery);
		q.setParameter("cp", cp);
		List<String> tmp = (List<String> )q.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	

}
