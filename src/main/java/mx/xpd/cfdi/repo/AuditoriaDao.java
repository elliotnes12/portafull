package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.AuditoriaCertificadoSelloDigital;
import mx.xpd.cfdi.domain.AuditoriaCliente;
import mx.xpd.cfdi.domain.AuditoriaDatosEmisor;
import mx.xpd.cfdi.domain.AuditoriaGrupoUsuario;
import mx.xpd.cfdi.domain.AuditoriaLugarEmision;
import mx.xpd.cfdi.domain.AuditoriaMoneda;
import mx.xpd.cfdi.domain.AuditoriaProductoServicio;
import mx.xpd.cfdi.domain.AuditoriaUsuario;
import mx.xpd.cfdi.domain.Moneda;

public interface AuditoriaDao {

	public List<AuditoriaCliente> findAllCliente();
	public List<AuditoriaLugarEmision> findAllLugar();
	public List<AuditoriaMoneda> findAllMoneda();
	public List<AuditoriaProductoServicio> findAllProducto();
	public List<AuditoriaDatosEmisor> findAllDatos();
	public List<AuditoriaCertificadoSelloDigital> findAllCSD();
	public List<AuditoriaUsuario> findAllUsuario();
	public List<AuditoriaGrupoUsuario> findAllGrupoUsuario();
	//public List<cfd> findAll();
	//public List<csd> findAll();
	//public List<producto> findAll();
	public AuditoriaMoneda findByIdMoneda(Long id);
	public AuditoriaCliente findByIdCliente(Long id);
	public AuditoriaLugarEmision findByIdLugar(Long id);
	public AuditoriaDatosEmisor findByIdDatos(Long id);
	public AuditoriaCertificadoSelloDigital findByIdCSD(Long id);
	public AuditoriaUsuario findByIdUsuario(Long id);
	public AuditoriaGrupoUsuario findByIdGrupoUsuario(Long id);
	public AuditoriaProductoServicio findByIdProductoServicio(Long id);
	public void setTenantId(String rfcTenant);

	
	public Moneda findByClave(String clave);

}
