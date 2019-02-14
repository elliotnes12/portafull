package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.FraccionArancelaria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class FraccionArancelariaDaoImpl implements FraccionArancelariaDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FraccionArancelaria> findAll() {
		String strQuery = "from FraccionArancelaria";
		return (List<FraccionArancelaria>) em.createQuery(strQuery).getResultList();
	}

	

}
