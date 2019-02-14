package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.Parametro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ParametroDaoImpl implements ParametroDao{
	
	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;

	@Override
	public void add(Parametro parametro) {
		em.persist(parametro);
	}
	
	@Override
	public void update(Parametro parametro) {
		em.merge(parametro);
	}
	
	@Override
	public Boolean remove(Long id) {
		Parametro tmp = findById(id);
		if (tmp == null) {
			return false;
		}
		tmp.setEliminado(true);
		tmp.setUltimaActualizacion(new Date());
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Parametro> findAll() {
		String strQuery = "from Parametro where eliminado = 0 and semaforo = 0";
		return (List<Parametro>) em.createQuery(strQuery).getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Parametro findById(Long id) {
		String strQuery = "from Parametro where eliminado = 0 and semaforo = 0 and id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<Parametro> tmp = (List<Parametro>) query.getResultList();
		if(tmp == null || tmp.size()==0){
			return null;
		}
		return tmp.get(0);
	}
	@Override
	@SuppressWarnings("unchecked")
	public Parametro findByClave(String clave) {
		String strQuery = "from Parametro where eliminado = 0 and semaforo = 0 and clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<Parametro> tmp = (List<Parametro>) query.getResultList();
		if(tmp == null || tmp.size()==0){
			return null;
		}
		return tmp.get(0);
	}
	
	
	
}
