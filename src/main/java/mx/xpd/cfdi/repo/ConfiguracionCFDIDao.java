package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.ConfiguracionCFDI;

public interface ConfiguracionCFDIDao
{    
    public void update(ConfiguracionCFDI configuracionCFDI);
    
    public List<ConfiguracionCFDI> findAll();
    
    public ConfiguracionCFDI findById(Long id);
    
    public void setTenantId(String rfcTenant);
    
    public ConfiguracionCFDI find();
    
    public ConfiguracionCFDI findAll(String tenant);
}
