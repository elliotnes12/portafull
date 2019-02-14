package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.xpd.cfdi.domain.CodigoPostal;
import mx.xpd.cfdi.domain.Colonia;
import mx.xpd.cfdi.domain.Estado;
import mx.xpd.cfdi.domain.Localidad;
import mx.xpd.cfdi.domain.Municipio;
import mx.xpd.cfdi.domain.Pais;

@Repository
@Transactional
public class PaisEstadoDaoImpl implements PaisEstadoDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	
	@Override
	public List<Pais> findAllPais() {
		return em.createQuery("from Pais order by nombre asc").getResultList();
	}

	@Override
	public List<Estado> findAllEstado() {
		return em.createQuery("from Estado order by nombre asc").getResultList();
	}
	/*
	@Override
	public List<Estado> findAllCatalogoEstados() {
		return em.createQuery("from Estado order by indice asc").getResultList();
	}*/
	
	
	
	@SuppressWarnings("unchecked")
	public String findClavePais(String strPais) {
		String strQuery = "select id from Pais where nombre = :strPais";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("strPais", strPais);
		List<String> tmp = (List<String> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public String findClaveEstado(String strEstado) {
		String strQuery = "select id from Estado where nombre = :strEstado";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("strEstado", strEstado);
		List<String> tmp = (List<String> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public String findClaveMunicipio(String strMunicipio, String strEstado) {
		String strQuery = "select clave from Municipio where estado = :strEstado and nombre = :strMunicipio";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("strEstado", strEstado);
		query.setParameter("strMunicipio", strMunicipio);
		List<String> tmp = (List<String> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public String findClaveLocalidad(String strLocalidad, String strEstado) {
		String strQuery = "select clave from Localidad where estado = :strEstado and nombre = :strLocalidad";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("strEstado", strEstado);
		query.setParameter("strLocalidad", strLocalidad);
		List<String> tmp = (List<String> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Estado> findAllEstadoMap(String paisId) {
		String strQuery2 = "select id, nombre from Estado where pais = :paisId";
		Query query2 = em.createNativeQuery(strQuery2, Estado.class);
		query2.setParameter("paisId",  paisId);
		return (List<Estado>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Localidad> findAllLocalidadMap(String estadoId) {
		String strQuery2 = "select clave, nombre from Localidad where estado = :estadoId";
		Query query2 = em.createNativeQuery(strQuery2, Localidad.class);
		query2.setParameter("estadoId",  estadoId);
		return (List<Localidad>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Localidad> findAllMunicipioMap(String estadoId) {
		String strQuery2 = "select clave, nombre from Municipio where estado = :estadoId";
		Query query2 = em.createNativeQuery(strQuery2, Localidad.class);
		query2.setParameter("estadoId",  estadoId);
		return (List<Localidad>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CodigoPostal> findAllCodigoPostalMap(String estadoId) {
		String strQuery2 = "select cp from CodigoPostal where estado = :estadoId ";
		Query query2 = em.createNativeQuery(strQuery2, CodigoPostal.class);
		query2.setParameter("estadoId",  estadoId);
		return (List<CodigoPostal>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CodigoPostal> findAllCodigoPostalMap(String estadoId, String municipioId) {
		String strQuery2 = "select cp from CodigoPostal where estado = :estadoId and municipio = :municipioId";
		Query query2 = em.createNativeQuery(strQuery2, CodigoPostal.class);
		query2.setParameter("estadoId",  estadoId);
		query2.setParameter("municipioId",  municipioId);
		return (List<CodigoPostal>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CodigoPostal> findAllCodigoPostalMap(String estadoId, String municipioId, String localidadId) {
		String strQuery2 = "select cp from CodigoPostal where estado = :estadoId and municipio = :municipioId and (localidad = :localidadId or localidad = '')";
		Query query2 = em.createNativeQuery(strQuery2, CodigoPostal.class);
		query2.setParameter("estadoId",  estadoId);
		query2.setParameter("municipioId",  municipioId);
		query2.setParameter("localidadId",  localidadId);
		return (List<CodigoPostal>) query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Colonia> findAllColoniaMap(String codigoPostalId) {
		String strQuery2 = "select c_colonia, nombre from Colonia where c_CP = :codigoPostalId";
		Query query2 = em.createNativeQuery(strQuery2, Colonia.class);
		query2.setParameter("codigoPostalId",  codigoPostalId);
		return (List<Colonia>) query2.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Estado findById(String paisId) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenant);		
		String strQuery = "from Estado where pais = :paisId ";
		Query query = em.createQuery(strQuery);
		query.setParameter("paisId", paisId);
		List<Estado> estados = (List<Estado>)query.getResultList();
		if (estados == null || estados.size() == 0) {
			return null;
		}
		return estados.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public String findNombreMunicipio(String estadoId, String claveId) {
		String strQuery2 = "select nombre from Municipio where estado = :estadoId and clave = :claveId";
		Query query2 = em.createNativeQuery(strQuery2, Municipio.class);
		query2.setParameter("estadoId",  estadoId);
		query2.setParameter("claveId",  claveId);
		List<String> tmp = (List<String> )query2.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
}
