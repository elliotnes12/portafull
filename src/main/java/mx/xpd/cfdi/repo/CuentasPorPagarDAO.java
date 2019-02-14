package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.RfcCuentasPorPagar;

public interface CuentasPorPagarDAO {

	public RfcCuentasPorPagar getByRfc(String rfc);
	public List<RfcCuentasPorPagar> getAll();
	public void add(RfcCuentasPorPagar obj);
	public void update(RfcCuentasPorPagar obj);
	
}