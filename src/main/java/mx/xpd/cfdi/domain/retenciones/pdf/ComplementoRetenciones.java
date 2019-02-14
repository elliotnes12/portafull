package mx.xpd.cfdi.domain.retenciones.pdf;

import javax.xml.bind.annotation.XmlElement;

import mx.xpd.cfdi.domain.cfdi.pdf.timbre.TimbreFiscalDigital;
import mx.xpd.cfdi.domain.retenciones.pdf.ArrendamientoEnFideicomiso;
import mx.xpd.cfdi.domain.retenciones.pdf.Intereses;
import mx.xpd.cfdi.domain.retenciones.pdf.InteresesHipotecarios;
import mx.xpd.cfdi.domain.retenciones.pdf.OperacionesConDerivados;
import mx.xpd.cfdi.domain.retenciones.pdf.PlanesDeRetiro;
import mx.xpd.cfdi.domain.retenciones.pdf.Premios;
import mx.xpd.cfdi.domain.retenciones.pdf.SectorFinanciero;
import mx.xpd.cfdi.domain.retenciones.pdf.EnajenacionDeAcciones;
import mx.xpd.cfdi.domain.retenciones.pdf.PagosAExtranjeros;
import mx.xpd.cfdi.domain.retenciones.pdf.Dividendos;
import mx.xpd.cfdi.domain.retenciones.pdf.FideicomisoNoEmpresarial;

public class ComplementoRetenciones {
	
	private TimbreFiscalDigital timbreFiscalDigital;
	private ArrendamientoEnFideicomiso arrendamientoEnFideicomiso;
	private Intereses intereses;
	private InteresesHipotecarios intereseshipotecarios;
	private OperacionesConDerivados operacionesconderivados;
	private PlanesDeRetiro planesderetiro;
	private PlanesDeRetiro11 planesderetiro11;
	private Premios premios;
	private SectorFinanciero sectorFinanciero;
	private EnajenacionDeAcciones enajenaciondeAcciones;
	private PagosAExtranjeros pagosaExtranjeros;
	private Dividendos dividendos;
	private FideicomisoNoEmpresarial fideicomisonoempresarial;
	
	
	@XmlElement(name = "TimbreFiscalDigital")
	public TimbreFiscalDigital getTimbreFiscalDigital() {
		return timbreFiscalDigital;
	}
	public void setTimbreFiscalDigital(TimbreFiscalDigital timbreFiscalDigital) {
		this.timbreFiscalDigital = timbreFiscalDigital;
	}
	
	@XmlElement(name = "ArrendamientoEnFideicomiso")
	public ArrendamientoEnFideicomiso getArrendamientoEnFideicomiso() {
		return arrendamientoEnFideicomiso;
	}

	public void setArrendamientoEnFideicomiso(
			ArrendamientoEnFideicomiso arrendamientoEnFideicomiso) {
		this.arrendamientoEnFideicomiso = arrendamientoEnFideicomiso;
	}
	
	@XmlElement(name = "Intereses")
	public Intereses getIntereses() {
		return intereses;
	}

	public void setIntereses(Intereses intereses) {
		this.intereses = intereses;
	}
	
	@XmlElement(name = "InteresesHipotecarios")
	public InteresesHipotecarios getInteresesHipotecarios() {
		return intereseshipotecarios;
	}

	public void setInteresesHipotecarios(InteresesHipotecarios intereseshipotecarios) {
		this.intereseshipotecarios = intereseshipotecarios;
	}
	
	@XmlElement(name = "OperacionesConDerivados")
	public OperacionesConDerivados getOperacionesconderivados() {
		return operacionesconderivados;
	}

	public void setOperacionesconderivados(
			OperacionesConDerivados operacionesconderivados) {
		this.operacionesconderivados = operacionesconderivados;
	}
	
	@XmlElement(name = "PlanesDeRetiro")
	public PlanesDeRetiro getPlanesderetiro() {
		return planesderetiro;
	}

	public void setPlanesderetiro(PlanesDeRetiro planesderetiro) {
		this.planesderetiro = planesderetiro;
	}
	
	@XmlElement(name = "PlanesDeRetiro11")
	public PlanesDeRetiro11 getPlanesderetiro11() {
		return planesderetiro11;
	}

	public void setPlanesderetiro11(PlanesDeRetiro11 planesderetiro11) {
		this.planesderetiro11 = planesderetiro11;
	}
	
	@XmlElement(name = "Premios")
	public Premios getPremios() {
		return premios;
	}

	public void setPremios(Premios premios) {
		this.premios = premios;
	}
	
	@XmlElement(name = "SectorFinanciero")
	public SectorFinanciero getSectorFinanciero() {
		return sectorFinanciero;
	}

	public void setSectorFinanciero(SectorFinanciero sectorFinanciero) {
		this.sectorFinanciero = sectorFinanciero;
	}
	
	@XmlElement(name = "EnajenacionDeAcciones")
	public EnajenacionDeAcciones getEnajenacionDeAcciones() {
		return enajenaciondeAcciones;
	}

	public void setEnajenacionDeAcciones(EnajenacionDeAcciones enajenaciondeAcciones) {
		this.enajenaciondeAcciones = enajenaciondeAcciones;
	}
	
	@XmlElement(name = "PagosAExtranjeros")
	public PagosAExtranjeros getPagosaExtranjeros() {
		return pagosaExtranjeros;
	}

	public void setPagosaExtranjeros(PagosAExtranjeros pagosaExtranjeros) {
		this.pagosaExtranjeros = pagosaExtranjeros;
	}
	
	@XmlElement(name = "Dividendos")
	public Dividendos getDividendos() {
		return dividendos;
	}

	public void setDividendos(Dividendos dividendos) {
		this.dividendos = dividendos;
	}

	@XmlElement(name = "FideicomisoNoEmpresarial")
	public FideicomisoNoEmpresarial getFideicomisonoempresarial() {
		return fideicomisonoempresarial;
	}

	public void setFideicomisonoempresarial(
			FideicomisoNoEmpresarial fideicomisonoempresarial) {
		this.fideicomisonoempresarial = fideicomisonoempresarial;
	}
	
	
}
