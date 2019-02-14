package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.Modulo;

public interface ModuloDao {
	
	public List<Modulo> findAll();
	
	public Modulo findById(Long id);

}
