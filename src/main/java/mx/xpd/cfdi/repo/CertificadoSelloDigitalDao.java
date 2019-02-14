package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.CertificadoSelloDigital;

public interface CertificadoSelloDigitalDao {
	
	public CertificadoSelloDigital findById(Long id);
	
	public List<CertificadoSelloDigital> findAll();
	
	public void add(CertificadoSelloDigital unidad);
	
	public void addOrUpdate(CertificadoSelloDigital csd);
	
//	public Boolean existe(String clave);
	
	public CertificadoSelloDigital findCurrent(String tenant);
	
	public Boolean remove(Long id);

	public void setTenantId(String rfcTenant);
}
