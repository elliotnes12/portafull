package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.CatalogoClaveUnidad;


public interface CatalogoClaveUnidadDao {
	
	public List<CatalogoClaveUnidad> findAll();
	
	public CatalogoClaveUnidad findById(Long id);
	
	public CatalogoClaveUnidad findByClave(String clave);
	
	public List<CatalogoClaveUnidad> findAllCatalogoClaveUnidad(String nombre);
	
	
}
