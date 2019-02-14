package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.Permiso;

public interface PermisoDao {
	
	public Permiso findById(Long id);
	
	public List<Permiso> findByGrupoUsuarioId(Long id);
	
	public List<Permiso> findAll();
	
	public void add(Permiso permiso);
	
	public void addAll(List<Permiso> permisos);
	
	public void addOrUpdate(Permiso permiso);
	
	public Boolean remove(Long id);
	
	public void setTenantId(String rfcTenant);

}
