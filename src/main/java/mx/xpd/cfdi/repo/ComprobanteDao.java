package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import mx.xpd.cfdi.domain.Addenda;
import mx.xpd.cfdi.domain.CatalogosNomina;
import mx.xpd.cfdi.domain.CatalogosNomina12;
import mx.xpd.cfdi.domain.CfdEmitido;
import mx.xpd.cfdi.domain.ComprobanteNoTimbrado;
import mx.xpd.cfdi.domain.map.MapCfdGrafica;

public interface ComprobanteDao {
	
	
	public void addComprobanteNoTimbrado(ComprobanteNoTimbrado comp);
	public List<CatalogosNomina> findCatalogo(String tipo);
	public List<CfdEmitido> findByDatesNomina(String tenant, String min, String max);
	public CfdEmitido findById(Long id, String fecha);
	public boolean existeFolio(String serie, Integer folio, String tenant);	
	public CfdEmitido findByUuid(String uuid, String tenant, String fecha);
	public CfdEmitido findByUuidCancelacion(String uuid);
	public List<CfdEmitido> findAll(String tenant);
	public List<Addenda> findAddendas(String tenant);
	public List<CfdEmitido> findByDates(String tenant, String min, String max);
	
	public void add(CfdEmitido comprobante);
	
	public void merge(CfdEmitido comprobante);
	
	public CfdEmitido findByUuid(String uuid);
	
	public void cancelar(CfdEmitido comprobante, String fecha);
	
	public void actualizaEnviado(CfdEmitido comprobante, String fecha);
	
	public void actualizaEliminado(CfdEmitido comprobante);
	
	public Boolean  remove(Long id);
	
	public void updateEnvuadi(CfdEmitido comprobante);
	
	public List<MapCfdGrafica> findByYear(Integer year, String estatus, String tenant);
	
	public Integer getFolio(String serie, String tenant);
	
	public Integer getFolioRet(String tenant);
	
	public List<CatalogosNomina> findCatalogoNomina(String tipo);
	
	public void enProceso(CfdEmitido comprobante, String fecha);
	
}
