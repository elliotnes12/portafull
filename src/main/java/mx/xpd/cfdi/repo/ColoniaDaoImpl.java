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
public class ColoniaDaoImpl implements ColoniaDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public String findByCPNombre(String cp, String nombre) {
		String strQuery = "select c_colonia from ColoniaComercioExterior where c_CP = :cp and nombre = :nombre";
		Query q = em.createNativeQuery(strQuery);
		q.setParameter("cp", cp);
		q.setParameter("nombre", nombre);
		List<String> tmp = (List<String> )q.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	

}
