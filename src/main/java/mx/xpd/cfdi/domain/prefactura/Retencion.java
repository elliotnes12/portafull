package mx.xpd.cfdi.domain.prefactura;

import java.io.Serializable;

public class Retencion implements Serializable {

	private static final long serialVersionUID = -6019743532273086743L;
	private String base;
	private String importe;
	private String impuesto;
	private String tasaOCuota;
	private String tipoFactor;

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getImporte() {
		return importe;
	}

	public void setImporte(String importe) {
		this.importe = importe;
	}

	public String getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(String impuesto) {
		this.impuesto = impuesto;
	}

	public String getTasaOCuota() {
		return tasaOCuota;
	}

	public void setTasaOCuota(String tasaOCuota) {
		this.tasaOCuota = tasaOCuota;
	}

	public String getTipoFactor() {
		return tipoFactor;
	}

	public void setTipoFactor(String tipoFactor) {
		this.tipoFactor = tipoFactor;
	}

}
