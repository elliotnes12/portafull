package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.CatalogoMoneda;
import mx.xpd.cfdi.domain.map.MapCatalogoMoneda;

public interface CatalogoMonedaDao {
	
	public List<CatalogoMoneda> findAll();
	
	public CatalogoMoneda findById(Long id);
	
	public CatalogoMoneda findByClave(String clave);
	
	public String findClaveCatalogoMoneda(String strMoneda);
}
