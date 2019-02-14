package mx.xpd.cfdi.domain.cfdi.pdf.complementos.spei;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import mx.xpd.cfdi.domain.cfdi.complementos.leyendasfiscales.Leyenda;

@XmlRootElement(name = "Complemento_SPEI")
public class Complemento_SPEI {

	private List<SPEI_Tercero> SPEI_Tercero;
		
	public Complemento_SPEI() {
		
	}

	@XmlElement(name = "SPEI_Tercero")
	public List<SPEI_Tercero> getSPEI_Tercero() {
		return SPEI_Tercero;
	}

	public void setSPEI_Tercero(List<SPEI_Tercero> SPEI_Tercero) {
		this.SPEI_Tercero = SPEI_Tercero;
	}

	



		
			
}