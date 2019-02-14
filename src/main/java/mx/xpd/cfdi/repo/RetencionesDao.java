package mx.xpd.cfdi.repo;

import java.util.Date;
import java.util.List;

import mx.xpd.cfdi.domain.Addenda;
import mx.xpd.cfdi.domain.CatalogosNomina;
import mx.xpd.cfdi.domain.RetencionesEmitido;
import mx.xpd.cfdi.domain.RetencionesNoTimbrado;
import mx.xpd.cfdi.domain.map.MapCfdGrafica;

public interface RetencionesDao {
	
	public boolean existeFolio(Integer folio, String tenant);
	
	public Integer getFolio(String serie, String tenant);
	
	public void add(RetencionesEmitido retenciones);
	
	public void merge(RetencionesEmitido retenciones);
	
	public Boolean remove(Long id);
		
	public void addRetencionesNoTimbrado(RetencionesNoTimbrado comp);
	
	public List<RetencionesEmitido> findByDates(String tenant, String min, String max);
	
	public List<RetencionesEmitido> findByDates(String tenant, Date min, Date max);
	
	public RetencionesEmitido findById(Long id);
	
	public void cancelar(RetencionesEmitido retenciones);
	
	//public List<CatalogosNomina> findCatalogo(String tipo);
	
	
		
	//public CfdEmitido findByUuid(String uuid, String tenant);
	
	//public List<CfdEmitido> findAll(String tenant);
	//public List<Addenda> findAddendas(String tenant);
	
	
	
	
	
	
	
	//public CfdEmitido findByUuid(String uuid);
	
	
	
	//public void actualizaEnviado(CfdEmitido comprobante);
	
	//public void actualizaEliminado(CfdEmitido comprobante);
	
	
	
	//public void updateEnvuadi(CfdEmitido comprobante);
	
	//public List<MapCfdGrafica> findByYear(Integer year, String estatus, String tenant);
	
	
	
}
