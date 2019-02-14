package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.ConfiguracionPlantilla;
import mx.xpd.cfdi.domain.Plantilla;

public interface PlantillaDao {
	
	public ConfiguracionPlantilla find(String tenant);
	
    public void update(ConfiguracionPlantilla plantilla);
    
    public List<ConfiguracionPlantilla> findAll();
    
    public ConfiguracionPlantilla find();
    
    public ConfiguracionPlantilla findById(Long id);
    
    public void setTenantId(String rfcTenant);
    
    public List<Plantilla> findAllPlantillas();
    
}
