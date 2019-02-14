package mx.xpd.cfdi.domain.prefactura;

import java.io.Serializable;
import java.util.List;

public class Impuestos implements Serializable {
	private static final long serialVersionUID = 4591864422874470089L;

	private List<Traslado> traslados;
	private List<Retencion> retenciones;

	public List<Traslado> getTraslados() {
		return traslados;
	}

	public void setTraslados(List<Traslado> traslados) {
		this.traslados = traslados;
	}

	public List<Retencion> getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(List<Retencion> retenciones) {
		this.retenciones = retenciones;
	}

}
