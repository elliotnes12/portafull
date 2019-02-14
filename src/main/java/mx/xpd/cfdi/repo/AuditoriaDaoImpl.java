package mx.xpd.cfdi.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.AuditoriaCertificadoSelloDigital;
import mx.xpd.cfdi.domain.AuditoriaCliente;
import mx.xpd.cfdi.domain.AuditoriaDatosEmisor;
import mx.xpd.cfdi.domain.AuditoriaGrupoUsuario;
import mx.xpd.cfdi.domain.AuditoriaLugarEmision;
import mx.xpd.cfdi.domain.AuditoriaMoneda;
import mx.xpd.cfdi.domain.AuditoriaProductoServicio;
import mx.xpd.cfdi.domain.AuditoriaUsuario;
import mx.xpd.cfdi.domain.Moneda;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class AuditoriaDaoImpl implements AuditoriaDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;

	private String tenantId;
	
	@Override
	public List<AuditoriaCliente> findAllCliente() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaCliente where eliminado = 0 and semaforo = 0";
		return (List<AuditoriaCliente>) em.createQuery(strQuery).getResultList();
	}
	
	@Override
	public List<AuditoriaLugarEmision> findAllLugar() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaLugarEmision where eliminado = 0 and semaforo = 0";
		return (List<AuditoriaLugarEmision>) em.createQuery(strQuery).getResultList();
	}
	
	@Override
	public List<AuditoriaMoneda> findAllMoneda() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaMoneda where eliminado = 0 and semaforo = 0";
		return (List<AuditoriaMoneda>) em.createQuery(strQuery).getResultList();
	}
	
	@Override
	public List<AuditoriaProductoServicio> findAllProducto() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaProductoServicio where eliminado = 0 and semaforo = 0";
		return (List<AuditoriaProductoServicio>) em.createQuery(strQuery).getResultList();
	}
	
	@Override
	public List<AuditoriaDatosEmisor> findAllDatos() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaDatosEmisor where eliminado = 0 and semaforo = 0";
		return (List<AuditoriaDatosEmisor>) em.createQuery(strQuery).getResultList();
	}
	
	@Override
	public List<AuditoriaCertificadoSelloDigital> findAllCSD() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaCertificadoSelloDigital where eliminado = 0 and semaforo = 0";
		return (List<AuditoriaCertificadoSelloDigital>) em.createQuery(strQuery).getResultList();
	}
	
	@Override
	public List<AuditoriaUsuario> findAllUsuario() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaUsuario where eliminado = 0 and semaforo = 0";
		return (List<AuditoriaUsuario>) em.createQuery(strQuery).getResultList();
	}
	
	@Override
	public List<AuditoriaGrupoUsuario> findAllGrupoUsuario() {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaGrupoUsuario where eliminado = 0 and semaforo = 0";
		return (List<AuditoriaGrupoUsuario>) em.createQuery(strQuery).getResultList();
	}

	@Override
	public AuditoriaMoneda findByIdMoneda(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaMoneda where eliminado = 0 and semaforo = 0 and idAuditoria = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<AuditoriaMoneda> tmp = (List<AuditoriaMoneda> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}		
		return tmp.get(0);
	}
	
	@Override
	public AuditoriaCliente findByIdCliente(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaCliente where eliminado = 0 and semaforo = 0 and idAuditoria = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<AuditoriaCliente> tmp = (List<AuditoriaCliente> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public AuditoriaLugarEmision findByIdLugar(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaLugarEmision where eliminado = 0 and semaforo = 0 and idAuditoria = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<AuditoriaLugarEmision> tmp = (List<AuditoriaLugarEmision> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public AuditoriaDatosEmisor findByIdDatos(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaDatosEmisor where eliminado = 0 and semaforo = 0 and idAuditoria = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<AuditoriaDatosEmisor> tmp = (List<AuditoriaDatosEmisor> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public AuditoriaCertificadoSelloDigital findByIdCSD(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaCertificadoSelloDigital where eliminado = 0 and semaforo = 0 and idAuditoria = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<AuditoriaCertificadoSelloDigital> tmp = (List<AuditoriaCertificadoSelloDigital> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	
	@Override
	public AuditoriaUsuario findByIdUsuario(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaUsuario where eliminado = 0 and semaforo = 0 and idAuditoria = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<AuditoriaUsuario> tmp = (List<AuditoriaUsuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public AuditoriaGrupoUsuario findByIdGrupoUsuario(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaGrupoUsuario where eliminado = 0 and semaforo = 0 and idAuditoria = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<AuditoriaGrupoUsuario> tmp = (List<AuditoriaGrupoUsuario> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}
	
	@Override
	public AuditoriaProductoServicio findByIdProductoServicio(Long id) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from AuditoriaProductoServicio where eliminado = 0 and semaforo = 0 and idAuditoria = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<AuditoriaProductoServicio> tmp = (List<AuditoriaProductoServicio> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@Override
	public Moneda findByClave(String clave) {
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from Moneda where eliminado = 0 and semaforo = 0 and clave = :clave";
		Query query = em.createQuery(strQuery);
		query.setParameter("clave", clave);
		List<Moneda> tmp = (List<Moneda> )query.getResultList();
		if (tmp == null || tmp.size() == 0) {
			return null;
		}
		return tmp.get(0);
	}

	@Override
	public void setTenantId(String rfcTenant) {
		this.tenantId = rfcTenant;
		em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
	}

}
