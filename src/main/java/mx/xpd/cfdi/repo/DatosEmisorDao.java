package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.DatosEmisor;

public interface DatosEmisorDao
{    
	public void recarga(DatosEmisor datosEmisor);
	
    public void update(DatosEmisor datosEmisor);
    
    public List<DatosEmisor> findAll();
    
    public DatosEmisor findEmisor(String tenant);
    
    public DatosEmisor findByRfc(String rfc);
    
    public void setTenantId(String rfcTenant);
    
    public DatosEmisor findByRfcCxP(String rfc);
}
