package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.Modulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ModuloDaoImpl implements ModuloDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Modulo> findAll() {
		String strQuery = "from Modulo where eliminado = 0 and semaforo = 0";
		return (List<Modulo>) em.createQuery(strQuery).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Modulo findById(Long id) {
		String strQuery = "from Modulo where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<Modulo> tmp = (List<Modulo>)query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

}
