package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.Usuario;

public interface UsuarioDao {

	public void add(Usuario usuario);
	
	public Usuario findByClave(String clave, String tenant);
	
	public void update(Usuario usuario);
	
	public Boolean remove(Long id);
	
	public List<Usuario> findAll(String tenant);
	
	public Usuario findById(Long id, String tenant);
	
	public Usuario findByClave(String clave);
	
	public Usuario findByUser(String name);
	
	public String accesoCorrecto(String username);
	
	public void intento(String username);
	
	public Boolean correcto(String name, String password);

	public void setTenantId(String rfcTenant);
}
