package mx.xpd.cfdi.domain.prefactura;

import java.io.Serializable;

public class InformacionAduanera implements Serializable {

	private static final long serialVersionUID = -3994497326934410204L;
	private String numeroPedimento;

	public String getNumeroPedimento() {
		return numeroPedimento;
	}

	public void setNumeroPedimento(String numeroPedimento) {
		this.numeroPedimento = numeroPedimento;
	}

}
