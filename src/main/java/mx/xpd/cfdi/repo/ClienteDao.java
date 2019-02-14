package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.map.MapCliente;
import mx.xpd.cfdi.domain.map.MapClienteJSON;

public interface ClienteDao {
	
	public List<MapCliente> findAllMapDes();
	public void updateDes(MapCliente cliente);
	
	public void add(Cliente cliente);
	
	public void updateClaveDes(MapCliente cliente);
	
	public List<MapCliente> findClMapClaveDes(String tenant);
	
	public void update(Cliente cliente);
	
	public Boolean remove(String tenant, Long id);
	
	public List<Cliente> findAll(String tenant);
	
	public List<MapClienteJSON> findMapAll(String tenant);
	
	public Cliente findById(String tenant, Long id);
	
	public Cliente findByClave(String tenant, String clave);
	public Cliente findByRfcRS(String tenant, String rfc, String razonSocial);
	public Cliente findByRfc(String tenant, String rfc);
	
	public List<MapCliente> findAllMap(String tenant, String id);
	
	public List<MapCliente> findAllMapRfc(String tenant, String id);
	public List<MapCliente> findAllMapRFCDes(String tenant);
	public void updateRFCDes(MapCliente cliente, String tenant);
	
	public void setTenantId(String rfcTenant);
	public List<Cliente> findNuevos(String tenant, String fecha);

}
