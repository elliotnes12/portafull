package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.LugarExpedicion;
import mx.xpd.cfdi.domain.map.MapLugarExpedicion;

public interface LugarExpedicionDao {
	
	public void add(LugarExpedicion lugar);
	
	public void update(LugarExpedicion lugar);
	
	public Boolean remove(Long id);
	
	public List<LugarExpedicion> findAll();
	
	public LugarExpedicion findById(Long id);
	
	public LugarExpedicion findByClave(String clave);
	
	public List<MapLugarExpedicion> findAllMap();
	
	public void setTenantId(String rfcTenant);
	
	public LugarExpedicion findLugarExpedicion(String tenant_id);
	

}
