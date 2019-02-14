package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.Parametro;

public interface ParametroDao {
	
	public void add(Parametro parametro);

	public void update(Parametro parametro);
	
	public Boolean remove(Long id);
	
	public List<Parametro> findAll();
	
	public Parametro findById(Long id);
	
	public Parametro findByClave(String clave);
	
}
