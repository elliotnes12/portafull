package mx.xpd.cfdi.domain.cfdi.complementos.nomina;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class HorasExtras {
	private List<HorasExtra> horasExtra;

	public HorasExtras() {
		horasExtra = new ArrayList<HorasExtra>();
	}
	@XmlElement(name = "HorasExtra")
	public List<HorasExtra> getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(List<HorasExtra> horasExtra) {
		this.horasExtra = horasExtra;
	}
}
