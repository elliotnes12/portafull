package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.Moneda;
import mx.xpd.cfdi.domain.map.MapMoneda;

public interface MonedaDao {
	
	public void add(Moneda moneda);
	
	public void update(Moneda moneda);
	
	public Boolean remove(Long id);
	
	public List<Moneda> findAll();
	
	public Moneda findById(Long id);
	
	public Moneda findByClave(String clave);
	
	public List<MapMoneda> findAllMap();

	public void setTenantId(String rfcTenant);
	
	public String findClaveMoneda(String strMoneda);
}
