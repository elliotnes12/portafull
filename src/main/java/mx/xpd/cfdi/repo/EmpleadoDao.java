package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.Empleado;
import mx.xpd.cfdi.domain.map.MapEmpleado;

public interface EmpleadoDao {

	public List<Empleado> find(String tenant);
	
	public Empleado find(String tenant, Long id);
	
	public Empleado findByRfc(String tenant, String rfc);
	
	public boolean exists(String tenant, String numEmpleado, String rfc, String curp);
	
	public List<MapEmpleado> findByRazonSocial(String tenant, String razonSocial);
	
	public List<MapEmpleado> findAllMap(String tenant, String id);
	
	public void add(Empleado empleado);
	
	public void remove(Empleado empleado);
	
	public Boolean remove(String tenant, Long id);
	
	public void update(Empleado empleado);

}
