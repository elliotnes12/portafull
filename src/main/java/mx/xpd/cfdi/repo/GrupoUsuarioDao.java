package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.GrupoUsuario;
import mx.xpd.cfdi.domain.map.MapGrupoUsuario;

public interface GrupoUsuarioDao {

	public void add(GrupoUsuario grupoUsuario);
	
	public GrupoUsuario addOrUpdate(GrupoUsuario grupoUsuario);
	
	public Boolean remove(Long id);
	
	public List<GrupoUsuario> findAll();
	
	public GrupoUsuario findById(Long id);
	
	public GrupoUsuario findByClave(String clave);
	
	public List<MapGrupoUsuario> findAllMap();
	
	public List<MapGrupoUsuario> findAllMap(String tenant);

	public void setTenantId(String rfcTenant);
}
