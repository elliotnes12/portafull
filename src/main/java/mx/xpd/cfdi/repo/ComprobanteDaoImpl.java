package mx.xpd.cfdi.repo;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mx.xpd.cfdi.domain.Addenda;
import mx.xpd.cfdi.domain.CatalogosNomina;
import mx.xpd.cfdi.domain.CatalogosNomina12;
import mx.xpd.cfdi.domain.CfdEmitido;
import mx.xpd.cfdi.domain.ComprobanteNoTimbrado;
import mx.xpd.cfdi.domain.map.MapCfdGrafica;
import mx.xpd.cfdi.domain.map.MapCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

@Repository
@Transactional
public class ComprobanteDaoImpl implements ComprobanteDao {
	
//	private Logger log = Logger.getLogger(ComprobanteDaoImpl.class);	
	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	
	@Autowired
	@Qualifier(value = "entityManagerHistorico33")
	private EntityManager emHistorico33;
	
	@Autowired
	@Qualifier(value = "entityManagerHistorico")
	private EntityManager emHistorico;
	
	public void addComprobanteNoTimbrado(ComprobanteNoTimbrado comp) {
		em.persist(comp);
	}
	
	
	public List<CatalogosNomina> findCatalogo(String tipo) {
		String strQuery = "from CatalogosNomina where tipo = :tipo";
		Query q = em.createQuery(strQuery);
		q.setParameter("tipo", tipo);
		return 	q.getResultList();
	}
	
	public List<CatalogosNomina> findCatalogoNomina(String tipo) {
		List<CatalogosNomina> result =  new ArrayList<CatalogosNomina>();
		String strQuery = "select * from CatalogosNomina where tipo = :tipo";
		Query q = em.createNativeQuery(strQuery, CatalogosNomina.class);
		q.setParameter("tipo", tipo);
		result = (List<CatalogosNomina>)q.getResultList();
		return 	result;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public CfdEmitido findById(Long id, String fecha) {
		Date dateActual = new Date();
		
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		
		String strMesComprobante = fecha.substring(5);
		String strAnioComprobante = fecha.substring(0,4);
		
		
		boolean blnHistorico = false;
		StringBuffer sbQuery = new StringBuffer("");
		
		if ((strAnioActual.equals(strAnioComprobante))&&(strMesActual.equals(strMesComprobante))){
			sbQuery.append("from CfdEmitido ");
		}
		else{
			sbQuery.append("select id, eliminado, enviado, estatus, fecha, folio, formaDePago, iva, rfcReceptor, semaforo, serie, subTotal, tipoComprobante, total, ultimaActualizacion, folioFiscalOrig, fechaDate, tenant_id, fechaRegistro, razonSocialReceptor, email, json, uuid, confirmacion, isr, anio, fechaCancelacion from cfd_emitido_").append(strAnioComprobante).append("_").append(strMesComprobante);
			blnHistorico = true;
		}
		
		sbQuery.append(" where id = :id and eliminado = 0 and semaforo = 0");  
		
		List<CfdEmitido> result =  new ArrayList<CfdEmitido>();
		
		Query query;
		if (!blnHistorico){
			query = em.createQuery(sbQuery.toString());
		}
		else{
			query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
		
		}	
		
		query.setParameter("id", id);
		result = (List<CfdEmitido>)query.getResultList();
		return result.get(0);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Addenda> findAddendas(String tenant) {
		String strQuery = "from Addenda where tenant_id = :tenant and eliminado = 0 and semaforo = 0";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant", tenant);
		return (List<Addenda>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CfdEmitido findByUuid(String uuid) {
		StringBuffer sbQuery = new StringBuffer("");
		
		String strQuery = "from CfdEmitido where uuid = :uuid and eliminado = 0 and semaforo = 0 order by fechaRegistro desc";
		Query query = em.createQuery(strQuery);
		query.setParameter("uuid", uuid);
		List<CfdEmitido> cfds = query.getResultList();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date datemin = new Date();
		String date = sdf.format(datemin);
		String array[] = date.split("-");
		int anio = Integer.parseInt(array[0]);
		int mes = Integer.parseInt(array[1]);
		String strMes = Integer.toString(mes);
		while (cfds == null || cfds.isEmpty()) {
			if (mes == 1){
				mes = 12;
				anio--;
			}
			else{
				mes--;
			}
			strMes = Integer.toString(mes);
			if (strMes.length() == 1){
				strMes = "0" + strMes;
				
			}
			if ((anio == 2017) && (mes == 10))
				break;
			
			sbQuery = new StringBuffer("select id, eliminado, enviado, estatus, fecha, folio, formaDePago, iva, rfcReceptor, semaforo, serie, subTotal, tipoComprobante, total, ultimaActualizacion, folioFiscalOrig, fechaDate, tenant_id, fechaRegistro, razonSocialReceptor, email, json, uuid, isr, anio, fechaCancelacion from cfd_emitido_").append(anio).append("_").append(strMes).append(" where uuid = :uuid and eliminado = 0 and semaforo = 0 order by fechaRegistro desc");
			query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
			query.setParameter("uuid", uuid);
			cfds = query.getResultList();
			
		}
		
		if (cfds.size() == 0)
			return null;
		return cfds.get(0);
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public CfdEmitido findByUuid(String uuid, String tenant, String fecha) {
		Date dateActual = new Date();
		
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		
		String strMesComprobante = fecha.substring(5);
		String strAnioComprobante = fecha.substring(0,4);
		
		
		boolean blnHistorico = false;
		StringBuffer sbQuery = new StringBuffer("");
		if ((strAnioActual.equals(strAnioComprobante))&&(strMesActual.equals(strMesComprobante))){
			sbQuery.append("from CfdEmitido ");
		}
		else{
			sbQuery.append("select id, eliminado, enviado, estatus, fecha, folio, formaDePago, iva, rfcReceptor, semaforo, serie, subTotal, tipoComprobante, total, ultimaActualizacion, folioFiscalOrig, fechaDate, tenant_id, fechaRegistro, razonSocialReceptor, email, json, uuid, confirmacion, isr, anio, fechaCancelacion from cfd_emitido_").append(strAnioComprobante).append("_").append(strMesComprobante);
			blnHistorico = true;
		}
		
		
		sbQuery.append(" where uuid = :uuid and eliminado = 0 and semaforo = 0 and tenant_id = :tenant order by fechaRegistro desc");  
		
		List<CfdEmitido> result =  new ArrayList<CfdEmitido>();
		
		Query query;
		if (!blnHistorico){
			query = em.createQuery(sbQuery.toString());
		}
		else{
			query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
		
		}	
				
		query.setParameter("uuid", uuid);
		query.setParameter("tenant", tenant);
		result = (List<CfdEmitido>)query.getResultList();
		
		return result.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CfdEmitido> findAll(String tenant) {
		List<CfdEmitido> result =  new ArrayList<CfdEmitido>();
		String strQuery = "from CfdEmitido where eliminado = 0 and semaforo = 0 and estatus is not null and fechaRegistro is not null "
				+ " and tenant_id = :tenant_id order by fechaRegistro desc";
		Query query = em.createQuery(strQuery);
		query.setParameter("tenant_id", tenant);
		List<CfdEmitido> tmp = query.getResultList();
		
		if (tmp != null) {
			result.addAll(tmp);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date datemin = new Date();
		String date = sdf.format(datemin);
		String array[] = date.split("-");
		int anio = Integer.parseInt(array[0]);
		int mes = Integer.parseInt(array[1]);
		String strMes = Integer.toString(mes);
		
		List<CfdEmitido> cfds = new ArrayList<CfdEmitido>();
		while ((anio != 2011) && (mes != 5)) {
			if (mes == 1){
				mes = 12;
				anio--;
			}
			else{
				mes--;
			}
			strMes = Integer.toString(mes);
			if (strMes.length() == 1){
				strMes = "0" + strMes;
				
			}
						
			StringBuffer sbQuery = new StringBuffer("select id, eliminado, enviado, estatus, fecha, folio, formaDePago, iva, rfcReceptor, semaforo, serie, subTotal, tipoComprobante, total, ultimaActualizacion, folioFiscalOrig, fechaDate, tenant_id, fechaRegistro, razonSocialReceptor, email, json, uuid, isr, anio, fechaCancelacion from cfd_emitido_").append(anio).append("_").append(strMes).append(" where eliminado = 0 and semaforo = 0 and estatus is not null and fechaRegistro is not null  and tenant_id = :tenant_id order by fechaRegistro desc");
			query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
			query.setParameter("tenant_id", tenant);
			cfds = query.getResultList();
			if (cfds != null) {
				result.addAll(cfds);
			}
			
		}
		
		return result;
	
	}
	
	public List<CfdEmitido> findByDatesNomina(String tenant, String anio, String mes) {
		
			Date dateActual = new Date();
			
			String strMesActual = Integer.toString(dateActual.getMonth()+1);
			if (strMesActual.length() == 1){
				strMesActual = "0" + strMesActual;
				
			}
			
			String strAnioActual = Integer.toString(dateActual.getYear()+1900);
			
			boolean blnHistorico = false;
			StringBuffer sbQuery = new StringBuffer("");
			
			if ((strAnioActual.equals(anio))&&(strMesActual.equals(mes))){
				sbQuery.append("from CfdEmitido ");
			}
			else{
				sbQuery.append("select id, eliminado, enviado, estatus, fecha, folio, formaDePago, iva, rfcReceptor, semaforo, serie, subTotal, tipoComprobante, total, ultimaActualizacion, folioFiscalOrig, fechaDate, tenant_id, fechaRegistro, razonSocialReceptor, email, json, uuid, confirmacion, isr, anio, fechaCancelacion from cfd_emitido_").append(anio).append("_").append(mes);
				blnHistorico = true;
			}
			
			sbQuery.append(" where tenant_id = :tenant_id and eliminado = 0 and semaforo = 0 and tipoComprobante = 'N' order by fechaRegistro desc");  

			List<CfdEmitido> result =  new ArrayList<CfdEmitido>();
			
			Query query;
			if (!blnHistorico){
				query = em.createQuery(sbQuery.toString());
			}
			else{
				query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
			}
			
			query.setParameter("tenant_id", tenant);
			result = (List<CfdEmitido>)query.getResultList();
			
			return result;
			
	}
	
	@Override
	public List<CfdEmitido> findByDates(String tenant, String anio, String mes) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		Date dateActual = new Date();
		
		int intAnio = Integer.parseInt(anio);
		int intMes = Integer.parseInt(mes);
						
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
			
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		
		boolean blnHistorico = false;
		StringBuffer sbQuery = new StringBuffer("");
		List<CfdEmitido> result =  new ArrayList<CfdEmitido>();
		Query query = null;
		if ((strAnioActual.equals(anio))&&(strMesActual.equals(mes))){
			sbQuery.append("from CfdEmitido ");
			sbQuery.append(" where tenant_id = :tenant_id and eliminado = 0 and semaforo = 0 and tipoComprobante != 'N' order by fechaRegistro desc");
			query = em.createQuery(sbQuery.toString());
			query.setParameter("tenant_id", tenant);
			result = (List<CfdEmitido>)query.getResultList();
		}
		else{
			if ((intAnio > 2017)||((intAnio == 2017) && (intMes >= 11))){ //solo se busca a partir de Noviembre de 2017, el primer historico de cfdi33 es Noviembre 2017
				sbQuery.append("select id, eliminado, enviado, estatus, fecha, folio, formaDePago, iva, rfcReceptor, semaforo, serie, subTotal, tipoComprobante, total, ultimaActualizacion, folioFiscalOrig, fechaDate, tenant_id, fechaRegistro, razonSocialReceptor, email, json, uuid, confirmacion, isr, anio, fechaCancelacion from cfd_emitido_").append(anio).append("_").append(mes);
				sbQuery.append(" where tenant_id = :tenant_id and eliminado = 0 and semaforo = 0 and tipoComprobante != 'N' order by fechaRegistro desc");
				query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
				query.setParameter("tenant_id", tenant);
				blnHistorico = true;
				result = (List<CfdEmitido>)query.getResultList();
			}
			
		}
			
		return result;
	}
	
		
	@Override
	public void merge(CfdEmitido comprobante) {
		em.merge(comprobante);
	}

	@Override
	public void add(CfdEmitido comprobante) {
		//em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		em.persist(comprobante);
	}
	
	@Override
	public boolean existeFolio(String serie, Integer folio, String tenant) {
		String strQuery =  "SELECT folio FROM cfd_emitido WHERE tenant_id = :tenantId AND serie = :serie ";
		strQuery += "AND folio = :folio AND eliminado = 0";
		
		//System.out.println(strQuery.replace(":serie", serie).replace(":tenantId", tenant).replace(":folio", (" " + folio)));
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("serie", serie);
		query.setParameter("folio", "" + folio);
		query.setParameter("tenantId", tenant);
		List result = query.getResultList();
		System.out.println(result.size());
		if (result == null || result.size() == 0) {//busca en cfdi33_historico
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date datemin = new Date();
			String date = sdf.format(datemin);
			String array[] = date.split("-");
			int anio = Integer.parseInt(array[0]);
			int mes = Integer.parseInt(array[1]);
			String strMes = Integer.toString(mes);
			while (result == null || result.size() == 0) {
				if (mes == 1){
					mes = 12;
					anio--;
				}
				else{
					mes--;
				}
				strMes = Integer.toString(mes);
				if (strMes.length() == 1){
					strMes = "0" + strMes;
					
				}
				
				if ((anio > 2017)||((anio == 2017) && (mes >= 11))) //solo se busca a partir de Noviembre de 2017, el primer historico de cfdi33 es Noviembre 2017
					result = existeFolioHistorico33(tenant, folio, serie, anio, strMes);
				else{
					break;
				}
			}
		}
		if (result == null || result.size() == 0) {//busca en cfdi_historico
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date datemin = new Date();
			String date = sdf.format(datemin);
			String array[] = date.split("-");
			int anio = Integer.parseInt(array[0]);
			int mes = Integer.parseInt(array[1]);
			String strMes = Integer.toString(mes);
			while (result == null || result.size() == 0) {
				if (anio == 2018){ //que empiece a buscar en 2017/12 
					anio = 2017;
					mes = 13;
				}
				if (mes == 1){
					mes = 12;
					anio--;
				}
				else{
					mes--;
				}
				strMes = Integer.toString(mes);
				if (strMes.length() == 1){
					strMes = "0" + strMes;
					
				}
				if ((anio == 2011) && (mes == 5))
					break;
				
				result = existeFolioHistorico(tenant, folio, serie, anio, strMes);
			}
		}
		if (result == null || result.size() == 0) {
			return false;
		}
		else{
			return true;
		}
			
		
		// return ((BigInteger).get(0)).intValue();
	}
	
	@Override
	public Integer getFolio(String serie, String tenant) {
		Integer intFolio = 0;
		String strQuery = "";
		if (serie.equals("")){
			strQuery =  "SELECT IFNULL(MAX(folio) + 1, 1) FROM cfd_emitido WHERE tenant_id = :tenantId AND serie is Null AND eliminado = 0";
		}
		else{
			strQuery =  "SELECT IFNULL(MAX(folio) + 1, 1) FROM cfd_emitido WHERE tenant_id = :tenantId AND serie = :serie AND eliminado = 0";
		}
		
		Query query = em.createNativeQuery(strQuery);
		if (serie.equals("")){
			query.setParameter("tenantId", tenant);
		}
		else{
			query.setParameter("serie", serie);
			query.setParameter("tenantId", tenant);
		}
		
		intFolio = ((BigInteger)query.getResultList().get(0)).intValue();
		
		/*if (intFolio == 1){ //busca en cfdi.cfd_emitido
			intFolio = buscaFolioTrabajo32(tenant, serie);
		}*/
		if (intFolio == 1){//busca en cfdi33_historico
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date datemin = new Date();
			String date = sdf.format(datemin);
			String array[] = date.split("-");
			int anio = Integer.parseInt(array[0]);
			int mes = Integer.parseInt(array[1]);
			String strMes = Integer.toString(mes);
			while (intFolio == 1){
				if (mes == 1){
					mes = 12;
					anio--;
				}
				else{
					mes--;
				}
				strMes = Integer.toString(mes);
				if (strMes.length() == 1){
					strMes = "0" + strMes;
					
				}
				
				if ((anio > 2017)||((anio == 2017) && (mes >= 11))) //solo se busca a partir de Noviembre de 2017, el primer historico de cfdi33 es Noviembre 2017
					intFolio = buscaFolioHistorico33(tenant, serie, anio, strMes);
				else
					break;
			}
			
			
			
		}
		if (intFolio == 1){//busca en cfdi_historico
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
			Date datemin = new Date();
			String date = sdf.format(datemin);
			String array[] = date.split("-");
			int anio = Integer.parseInt(array[0]);
			int mes = Integer.parseInt(array[1]);
			String strMes = Integer.toString(mes);
			while (intFolio == 1){
				if (anio == 2018){ //que empiece a buscar en 2017/12 
					anio = 2017;
					mes = 13;
				}
				if (mes == 1){
					mes = 12;
					anio--;
				}
				else{
					mes--;
				}
				strMes = Integer.toString(mes);
				if (strMes.length() == 1){
					strMes = "0" + strMes;
					
				}
				if ((anio == 2011) && (mes == 5))
					break;
				
				
				intFolio = buscaFolioHistorico(tenant, serie, anio, strMes);
			}
			
			return intFolio;
			
		}
		
		return intFolio;
		
	}




	
	@Override
	public Integer getFolioRet(String tenant) {
		String strQuery =  "SELECT IFNULL(MAX(folio) + 1, 1) FROM retenciones_emitido WHERE tenant_id = :tenantId ";
		strQuery += " AND eliminado = 0";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("tenantId", tenant);
		return ((BigInteger)query.getResultList().get(0)).intValue();
		
		
	}

	@Override
	public void cancelar(CfdEmitido comprobante, String fecha) {
		comprobante.setUltimaActualizacion(new Date());
		
		Date dateActual = new Date();
		
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		
		String strMesComprobante = fecha.substring(5);
		String strAnioComprobante = fecha.substring(0,4);
		
		
		boolean blnHistorico = false;
		StringBuffer sbQuery = new StringBuffer("");
		
		if ((strAnioActual.equals(strAnioComprobante))&&(strMesActual.equals(strMesComprobante))){
			sbQuery.append("SELECT id from cfd_emitido where uuid = :uuid ");
		}
		else{
			sbQuery.append("select id from cfd_emitido_").append(strAnioComprobante).append("_").append(strMesComprobante).append(" where uuid = :uuid");
			blnHistorico = true;
		}
		
				
		Query query;
		if (!blnHistorico){
			query = em.createNativeQuery(sbQuery.toString());
		}
		else{
			query = emHistorico33.createNativeQuery(sbQuery.toString());
		
		}	
				
		query.setParameter("uuid", comprobante.getUuid());
		List<CfdEmitido> cfds = (List<CfdEmitido>)query.getResultList();
		if(!cfds.isEmpty()) {
			
			if (!blnHistorico){
				sbQuery = new StringBuffer("UPDATE cfd_emitido set estatus = :estatus, fechaCancelacion = :fechaCancelacion, ultimaActualizacion = :ultimaActualizacion where id = :id");
			}
			else{
				sbQuery = new StringBuffer("UPDATE cfd_emitido_").append(strAnioComprobante).append("_").append(strMesComprobante).append(" set estatus = :estatus, fechaCancelacion = :fechaCancelacion, ultimaActualizacion = :ultimaActualizacion where id = :id");
			}
		
			if (!blnHistorico){
				query = em.createNativeQuery(sbQuery.toString());
			}
			else{
				query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
			
			}	
			
						
			query.setParameter("estatus", comprobante.getEstatus());
			query.setParameter("fechaCancelacion", comprobante.getUltimaActualizacion());
			query.setParameter("ultimaActualizacion", comprobante.getUltimaActualizacion());
			query.setParameter("id", comprobante.getId());
				
			query.executeUpdate();
			
		}
		
	}
	
	@Override
	public void enProceso(CfdEmitido comprobante, String fecha) {
		comprobante.setUltimaActualizacion(new Date());
		
		Date dateActual = new Date();
		
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		
		String strMesComprobante = fecha.substring(5);
		String strAnioComprobante = fecha.substring(0,4);
		
		
		boolean blnHistorico = false;
		StringBuffer sbQuery = new StringBuffer("");
		
		if ((strAnioActual.equals(strAnioComprobante))&&(strMesActual.equals(strMesComprobante))){
			sbQuery.append("SELECT id from cfd_emitido where uuid = :uuid ");
		}
		else{
			sbQuery.append("select id from cfd_emitido_").append(strAnioComprobante).append("_").append(strMesComprobante).append(" where uuid = :uuid");
			blnHistorico = true;
		}
		
				
		Query query;
		if (!blnHistorico){
			query = em.createNativeQuery(sbQuery.toString());
		}
		else{
			query = emHistorico33.createNativeQuery(sbQuery.toString());
		
		}	
				
		query.setParameter("uuid", comprobante.getUuid());
		List<CfdEmitido> cfds = (List<CfdEmitido>)query.getResultList();
		if(!cfds.isEmpty()) {
			
			if (!blnHistorico){
				sbQuery = new StringBuffer("UPDATE cfd_emitido set estatus = :estatus, ultimaActualizacion = :ultimaActualizacion where id = :id");
			}
			else{
				sbQuery = new StringBuffer("UPDATE cfd_emitido_").append(strAnioComprobante).append("_").append(strMesComprobante).append(" set estatus = :estatus, ultimaActualizacion = :ultimaActualizacion where id = :id");
			}
		
			if (!blnHistorico){
				query = em.createNativeQuery(sbQuery.toString());
			}
			else{
				query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
			
			}	
			
						
			query.setParameter("estatus", comprobante.getEstatus());
			query.setParameter("ultimaActualizacion", comprobante.getUltimaActualizacion());
			query.setParameter("id", comprobante.getId());
				
			query.executeUpdate();
			
		}
		
	}
	
	@Override
	public void actualizaEnviado(CfdEmitido comprobante, String fecha) {
		comprobante.setUltimaActualizacion(new Date());
		
		Date dateActual = new Date();
		
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		
		String strMesComprobante = fecha.substring(5);
		String strAnioComprobante = fecha.substring(0,4);
		
		
		boolean blnHistorico = false;
		StringBuffer sbQuery = new StringBuffer("");
		
		if ((strAnioActual.equals(strAnioComprobante))&&(strMesActual.equals(strMesComprobante))){
			sbQuery.append("select id from cfd_emitido ");
		}
		else{
			sbQuery.append("select id from cfd_emitido_").append(strAnioComprobante).append("_").append(strMesComprobante);
			blnHistorico = true;
		}
		
		sbQuery.append(" where uuid = :uuid");
		
		Query query;
		if (!blnHistorico){
			query = em.createNativeQuery(sbQuery.toString());
		}
		else{
			query = emHistorico33.createNativeQuery(sbQuery.toString());
		
		}	
		
		query.setParameter("uuid", comprobante.getUuid());
		List<CfdEmitido> cfds = query.getResultList();
		if(!cfds.isEmpty()) {
			if (!blnHistorico){
				sbQuery =  new StringBuffer("UPDATE cfd_emitido set enviado = :enviado, ultimaActualizacion = :ultimaActualizacion where id = :id");
				query = em.createNativeQuery(sbQuery.toString());
			}
			else{
				sbQuery =  new StringBuffer("UPDATE cfd_emitido_").append(strAnioComprobante).append("_").append(strMesComprobante).append(" set enviado = :enviado, ultimaActualizacion = :ultimaActualizacion where id = :id");
				query = emHistorico33.createNativeQuery(sbQuery.toString());
			}
			
		}
				
		query.setParameter("enviado", comprobante.getEnviado());
		query.setParameter("ultimaActualizacion", comprobante.getUltimaActualizacion());
		query.setParameter("id", comprobante.getId());
			
		query.executeUpdate();
		
		
	}
	
	@Override
	public void actualizaEliminado(CfdEmitido comprobante) {
		comprobante.setUltimaActualizacion(new Date());
		
		String strQueryUpdate ="";
		//1= cfd_emitido, 2= cfd_emitido_octubre, 3= cfd_emitido_junio
		String strQuery = "SELECT id from cfd_emitido where id = :id";
		Query query = em.createNativeQuery(strQuery);
		query.setParameter("id", comprobante.getId());
		List<CfdEmitido> cfds = query.getResultList();
		if(!cfds.isEmpty()) {
			strQueryUpdate = "UPDATE cfd_emitido set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
		}
		else{
			strQuery = "SELECT id from cfd_emitido_marzo where id = :id";
			query = em.createNativeQuery(strQuery);
			query.setParameter("id", comprobante.getId());
			cfds = query.getResultList();
			if(!cfds.isEmpty()) {
				strQueryUpdate = "UPDATE cfd_emitido_marzo set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
			}
			else{
				strQuery = "SELECT id from cfd_emitido_octubre where id = :id";
				query = em.createNativeQuery(strQuery);
				query.setParameter("id", comprobante.getId());
				cfds = query.getResultList();
				if(!cfds.isEmpty()) {
					strQueryUpdate = "UPDATE cfd_emitido_octubre set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
				}
				else{
					strQueryUpdate = "UPDATE cfd_emitido_junio set set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
				}
			}
		}
		
			
		
		query = em.createNativeQuery(strQueryUpdate);
		query.setParameter("eliminado", true);
		query.setParameter("ultimaActualizacion", comprobante.getUltimaActualizacion());
		query.setParameter("id", comprobante.getId());
			
		query.executeUpdate();
		
		
	}
	
	

	@Override
	public void updateEnvuadi(CfdEmitido comprobante) {
		String query = "UPDATE cfd_emitido";
		query += " SET enviado = 1 WHERE id = :id";
		Query q = em.createNativeQuery(query);
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean remove(Long id) {
		// em.unwrap(Session.class).enableFilter("tenantFilter").setParameter("tenantId", tenantId);
		String strQuery = "from CfdEmitido where id = :id and eliminado = 0 and semaforo = 0";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", id);
		List<CfdEmitido> comprobantes = query.getResultList();
		if (comprobantes == null || comprobantes.isEmpty()) {
			return false;
		}
		CfdEmitido comp = comprobantes.get(0);
				
		String strQueryUpdate = "UPDATE cfd_emitido set eliminado = :eliminado, ultimaActualizacion = :ultimaActualizacion where id = :id";
		query = em.createNativeQuery(strQueryUpdate);
		query.setParameter("eliminado", true);
		query.setParameter("ultimaActualizacion", new Date());
		query.setParameter("id", comp.getId());
			
		query.executeUpdate();
		
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapCfdGrafica> findByYear(Integer year, String estatus, String tenant) {
		//TODO agregar tenantId, eliminado y semáforo
		List<MapCfdGrafica> result = new ArrayList<MapCfdGrafica>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date datemin = new Date();
		String date = sdf.format(datemin);
		String array[] = date.split("-");
		int anio = Integer.parseInt(array[0]);
		int mes = Integer.parseInt(array[1]);
		String strMes = Integer.toString(mes);
		
		Query query = null;
		if (anio == year){
			String strQuery = "SELECT Date_Format( fechaRegistro, '%c' ) AS mes, Date_Format( fechaRegistro, '%Y' ) AS anio, count( * ) AS suma, estatus "+
					" FROM cfd_emitido WHERE tenant_id = :tenantId AND estatus = :estatus AND anio = :year AND eliminado = 0 AND semaforo = 0 GROUP BY mes";
				
		
			query = em.createNativeQuery(strQuery, MapCfdGrafica.class);
			query.setParameter("year", year);
			query.setParameter("estatus", estatus);
			query.setParameter("tenantId", tenant);
			List<MapCfdGrafica> tmp = query.getResultList();
			
			if (tmp != null) {
				result.addAll(tmp);
			}
		}
		else{
			mes = 13;
		}
		
		List<MapCfdGrafica> cfds = new ArrayList<MapCfdGrafica>();
		
		mes--;
		while (mes >= 1){
			strMes = Integer.toString(mes);
			if (strMes.length() == 1){
				strMes = "0" + strMes;
				
			}
			
			if ((anio > 2017)||((anio == 2017) && (mes >= 11))){ //solo se busca a partir de Noviembre de 2017, el primer historico de cfdi33 es Noviembre 2017
				StringBuffer sbQuery = new StringBuffer("SELECT Date_Format( fechaRegistro, '%c' ) AS mes, Date_Format( fechaRegistro, '%Y' ) AS anio, count( * ) AS suma, estatus FROM cfd_emitido_").append(year).append("_").append(strMes);
				sbQuery.append(" WHERE tenant_id = :tenantId AND estatus = :estatus AND anio = :year AND eliminado = 0 AND semaforo = 0 GROUP BY mes");
				query = emHistorico33.createNativeQuery(sbQuery.toString(), MapCfdGrafica.class);
				query.setParameter("year", year);
				query.setParameter("estatus", estatus);
				query.setParameter("tenantId", tenant);
			
				cfds = query.getResultList();
				if (cfds != null) {
					result.addAll(cfds);
				}
			}
			mes--;
			
		}	
		return result;
		
	}



	private Integer buscaFolioHistorico(String tenantId, String serie, int anio, String mes){
		
		StringBuffer sbQuery = new StringBuffer("SELECT IFNULL(MAX(folio) + 1, 1) FROM cfd_emitido_");
		sbQuery.append(anio).append("_").append(mes);
		if (serie.equals("")){
			sbQuery.append(" WHERE tenant_id = :tenantId AND serie is Null AND eliminado = 0");
		}
		else{
			sbQuery.append(" WHERE tenant_id = :tenantId AND serie = :serie AND eliminado = 0");
		}
		
		
		Query query = emHistorico.createNativeQuery(sbQuery.toString());
		if (serie.equals("")){
			query.setParameter("tenantId", tenantId);
		}
		else{
			query.setParameter("serie", serie);
			query.setParameter("tenantId", tenantId);
		}
		
		return ((BigInteger)query.getResultList().get(0)).intValue();
		
	}
	
private Integer buscaFolioHistorico33(String tenantId, String serie, int anio, String mes){
		
		StringBuffer sbQuery = new StringBuffer("SELECT IFNULL(MAX(folio) + 1, 1) FROM cfd_emitido_");
		sbQuery.append(anio).append("_").append(mes);
		if (serie.equals("")){
			sbQuery.append(" WHERE tenant_id = :tenantId AND serie is Null AND eliminado = 0");
		}
		else{
			sbQuery.append(" WHERE tenant_id = :tenantId AND serie = :serie AND eliminado = 0");
		}
		
		
		Query query = emHistorico33.createNativeQuery(sbQuery.toString());
		if (serie.equals("")){
			query.setParameter("tenantId", tenantId);
		}
		else{
			query.setParameter("serie", serie);
			query.setParameter("tenantId", tenantId);
		}
		
		return ((BigInteger)query.getResultList().get(0)).intValue();
		
	}

	/*private Integer buscaFolioTrabajo32(String tenantId, String serie){
		
		StringBuffer sbQuery = new StringBuffer("SELECT IFNULL(MAX(folio) + 1, 1) FROM cfd_emitido");
		if (serie.equals("")){
			sbQuery.append(" WHERE tenant_id = :tenantId AND serie is Null AND eliminado = 0");
		}
		else{
			sbQuery.append(" WHERE tenant_id = :tenantId AND serie = :serie AND eliminado = 0");
		}
		
		
		Query query = em32.createNativeQuery(sbQuery.toString());
		if (serie.equals("")){
			query.setParameter("tenantId", tenantId);
		}
		else{
			query.setParameter("serie", serie);
			query.setParameter("tenantId", tenantId);
		}
		
		return ((BigInteger)query.getResultList().get(0)).intValue();
		
	}*/
	
	private List existeFolioHistorico(String tenantId, Integer folio, String serie, int anio, String mes){
		StringBuffer sbQuery = new StringBuffer("SELECT folio FROM cfd_emitido_");
		sbQuery.append(anio).append("_").append(mes);
		sbQuery.append(" WHERE tenant_id = :tenantId AND serie = :serie AND folio = :folio AND eliminado = 0");
		
		Query query = emHistorico.createNativeQuery(sbQuery.toString());
		query.setParameter("serie", serie);
		query.setParameter("tenantId", tenantId);
		query.setParameter("folio", folio);
		return query.getResultList();
		
	}
	
	private List existeFolioHistorico33(String tenantId, Integer folio, String serie, int anio, String mes){
		StringBuffer sbQuery = new StringBuffer("SELECT folio FROM cfd_emitido_");
		sbQuery.append(anio).append("_").append(mes);
		sbQuery.append(" WHERE tenant_id = :tenantId AND serie = :serie AND folio = :folio AND eliminado = 0");
		
		Query query = emHistorico33.createNativeQuery(sbQuery.toString());
		query.setParameter("serie", serie);
		query.setParameter("tenantId", tenantId);
		query.setParameter("folio", folio);
		return query.getResultList();
		
	}
	@Override
	public CfdEmitido findByUuidCancelacion(String uuid) {
		StringBuffer sbQuery = new StringBuffer("");
		//
		String strQuery = "from CfdEmitido where uuid = :uuid and eliminado = 0 and semaforo = 0 order by fechaRegistro desc";
		Query query = em.createQuery(strQuery);
		query.setParameter("uuid", uuid);
		List<CfdEmitido> cfds = query.getResultList();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date datemin = new Date();
		String date = sdf.format(datemin);
		String array[] = date.split("-");
		
		int anio = Integer.parseInt(array[0]);
		int mes = Integer.parseInt(array[1]);
		String strMes = Integer.toString(mes);
		while (cfds == null || cfds.isEmpty()) {
			if (mes == 1){
				mes = 12;
				anio--;
			}
			else{
				mes--;
			}
			strMes = Integer.toString(mes);
			if (strMes.length() == 1){
				strMes = "0" + strMes;
				
			}
			if ((anio == 2017) && (mes == 10))
				break;
			
			sbQuery = new StringBuffer("select id, eliminado, enviado, estatus, fecha, folio, formaDePago, iva, rfcReceptor, semaforo, serie, subTotal, tipoComprobante, total, ultimaActualizacion, folioFiscalOrig, fechaDate, tenant_id, fechaRegistro, razonSocialReceptor, email, json, uuid, confirmacion , isr, anio,fechaCancelacion from cfd_emitido_").append(anio).append("_").append(strMes).append(" where uuid = :uuid and eliminado = 0 and semaforo = 0 order by fechaRegistro desc");
			query = emHistorico33.createNativeQuery(sbQuery.toString(), CfdEmitido.class);
			query.setParameter("uuid", uuid);
			cfds = query.getResultList();
			
			
		}
		
		if (cfds.size() == 0)
			return null;
		return cfds.get(0);
	}

}