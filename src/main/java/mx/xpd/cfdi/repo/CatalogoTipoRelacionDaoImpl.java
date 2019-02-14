package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.CatalogoTipoRelacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CatalogoTipoRelacionDaoImpl implements CatalogoTipoRelacionDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	
	@Override
	public List<CatalogoTipoRelacion> findAll() {
		return em.createQuery("from CatalogoTipoRelacion").getResultList();
	}

		
}
