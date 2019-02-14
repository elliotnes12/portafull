package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.RegimenFiscal;

public interface RegimenFiscalDao {
	
	public void add(RegimenFiscal regimenFiscal);

	public void update(RegimenFiscal regimenFiscal);
	
	public Boolean remove(Long id);
	
	public List<RegimenFiscal> findAll(String tenant);

	public RegimenFiscal findById(Long id);

	public RegimenFiscal findByClave(String clave);
	
	public void setTenantId(String rfcTenant);
}
