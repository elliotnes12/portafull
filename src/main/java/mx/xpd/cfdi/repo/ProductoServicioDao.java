package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.ProductoServicio;
import mx.xpd.cfdi.domain.map.MapProductoServicio;

public interface ProductoServicioDao {

	public ProductoServicio findById(Long id);
	
	public ProductoServicio findByClave(String clave);
	
	public List<ProductoServicio> findAll(String tenant);
	
	public void add(ProductoServicio productoServicio);
	
	public void addOrUpdate(ProductoServicio productoServicio);
	
	public List<MapProductoServicio> findAllMap(String id);
	
	public List<MapProductoServicio> findAllMapByClave(String id);
	
//	public Boolean exists(Long id);
	
//	public Boolean existe(String clave);
	
	public Boolean remove(Long id);
	
	public Boolean existeProducto(String nombre, String tenant);
	
	public void setTenantId(String rfcTenant);
}