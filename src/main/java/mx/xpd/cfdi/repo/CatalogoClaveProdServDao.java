package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.CatalogoClaveProdServ;
import mx.xpd.cfdi.domain.map.MapCatalogoProductoServicio;


public interface CatalogoClaveProdServDao {
	
	public List<CatalogoClaveProdServ> findAll();
	
	public CatalogoClaveProdServ findById(Long id);
	
	public CatalogoClaveProdServ findByClave(String clave);
	
	public List<MapCatalogoProductoServicio> findAllCatalogoClaveProdServ(String nombre);
	
}
