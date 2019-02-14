package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.xpd.cfdi.domain.RfcCuentasPorPagar;

@Repository
@Transactional
public class CuentasPorPagarDAOImp implements CuentasPorPagarDAO {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public RfcCuentasPorPagar getByRfc(String rfc){
		String strQuery = "select id, rfc, razon_social, pais, aprovisionado, correo from rfc_cuentas_por_pagar where rfc = :pRfc";
   		Query query = em.createNativeQuery(strQuery, RfcCuentasPorPagar.class); 
   		query.setParameter("pRfc", rfc.trim());   		
		List<RfcCuentasPorPagar> listaObj = (List<RfcCuentasPorPagar>) query.getResultList();   		
   		return listaObj.size()>0?listaObj.get(0):null;   		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RfcCuentasPorPagar> getAll() {
		String strQuery = "from RfcCuentasPorPagar";
   		Query query = em.createQuery(strQuery); 
   		return (List<RfcCuentasPorPagar>) query.getResultList();
	}

	@Override
	public void add(RfcCuentasPorPagar obj) {
	    em.persist(obj);	
	}

	@Override
	public void update(RfcCuentasPorPagar obj){
		em.merge(obj);
	}
	
}
