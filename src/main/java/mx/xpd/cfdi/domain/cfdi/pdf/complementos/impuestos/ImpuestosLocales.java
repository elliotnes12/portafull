package mx.xpd.cfdi.domain.cfdi.pdf.complementos.impuestos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;
import javax.validation.constraints.DecimalMax;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlTransient;

public class ImpuestosLocales {

	
	private String version;
	
	@DecimalMax(value = "2")
	private Double totalDeTraslados;
	@DecimalMax(value = "2")
	
	private Double totalDeRetenciones;
	
	private List<Object> retenciones;
	
	@XmlTransient
	private TrasladosLocalesWrapper trasladosLocales;
	@XmlTransient
	private RetencionesLocalesWrapper retencionesLocales;

	@Transient
	public RetencionesLocalesWrapper getRetencionesLocales() {
		return null;
	}
	public void setRetencionesLocales(RetencionesLocalesWrapper retencionesLocales) {
		this.retencionesLocales = retencionesLocales;
	}
	public ImpuestosLocales() {
		version = "1.0";
	}
	@XmlAttribute
	public String getVersion() {
		return version;
	}
	@XmlAttribute(name = "TotaldeTraslados")
	public Double getTotalDeTraslados() {
		return totalDeTraslados;
	}
	@XmlAttribute(name = "TotaldeRetenciones")
	public Double getTotalDeRetenciones() {
		return totalDeRetenciones;
	}


	@XmlElements({
		 @XmlElement(name = "TrasladosLocales", type = TrasladosLocales.class),
		 @XmlElement(name = "RetencionesLocales", type = RetencionesLocales.class)
	})
	public List<Object> getRetenciones() {
		retenciones = null;
		if (retencionesLocales != null) {
			retenciones = new ArrayList<Object>();
			retenciones.addAll(retencionesLocales.getRetencionesLocales());
		}
		if (trasladosLocales != null) {
			if (retenciones == null) {
				retenciones = new ArrayList<Object>();
			}
			retenciones.addAll(trasladosLocales.getTrasladosLocales());
		}
		return retenciones;
	}
	
	public void setRetenciones(List<Object> retenciones) {
		this.retenciones = retenciones;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setTotalDeTraslados(Double totalDeTraslados) {
		this.totalDeTraslados = totalDeTraslados;
	}
	public void setTotalDeRetenciones(Double totalDeRetenciones) {
		this.totalDeRetenciones = totalDeRetenciones;
	}


	
}
