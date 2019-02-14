package mx.xpd.cfdi.domain.cfdi.pdf;

import javax.xml.bind.annotation.XmlElement;

import mx.xpd.cfdi.domain.cfdi.pdf.complementos.pagos.Pagos;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12.Nomina12;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.leyendasfiscales.LeyendasFiscales;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.detallista.Detallista;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.divisas.Divisas;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.spei.Complemento_SPEI;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.turistapasajeroextranjero.TuristaPasajeroExtranjero;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.personafisicaintegrantedecoordinado.PersonaFisicaIntegranteDeCoordinado;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.pagoenespecie.PagoEnEspecie;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.parcialesconstruccion.ParcialesConstruccion;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.registroFiscal.CFDIRegistroFiscal;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.renovacionsustitucionvehiculos.RenovacionSustitucionVehiculos;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.notarios.NotariosPublicos;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.aerolineas.Aerolineas;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.certificadodestruccion.CertificadoDestruccion;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.comercioexterior.ComercioExterior;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.consumodecombustibles.ConsumoDeCombustibles11;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.donatarias.Donatarias;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.ecc12.EstadoDeCuentaCombustible12;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.impuestos.ImpuestosLocales;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.ine.INE;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina.Nomina;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.vehiculousado.VehiculoUsado;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.valesdedespensa.ValesDeDespensa;
import mx.xpd.cfdi.domain.cfdi.pdf.complementos.arteantiguedades.ObrasArteAntiguedades;
import mx.xpd.cfdi.domain.cfdi.pdf.timbre.TimbreFiscalDigital;

public class Complemento {
	
	private TimbreFiscalDigital timbreFiscalDigital;
	private ImpuestosLocales impuestosLocales;
	private Donatarias donatarias;
	private Nomina nomina;
	private Nomina12 nomina12;
	private NotariosPublicos notariosPublicos;
	private ConsumoDeCombustibles11 consumodecombustibles;
	private EstadoDeCuentaCombustible12 estadodecuentacombustible12;
	private VehiculoUsado vehiculousado;
	private PagoEnEspecie pagoEnEspecie;
	private CFDIRegistroFiscal registroFiscal;
	private ValesDeDespensa valesDespensa;
	private Aerolineas aerolineas;
	private ParcialesConstruccion parcialesConstruccion;
	private Divisas divisas;
	private TuristaPasajeroExtranjero turista;
	private PersonaFisicaIntegranteDeCoordinado pfic;
	private INE ine;
	private LeyendasFiscales leyendasFisc;
	private ObrasArteAntiguedades obrasarteantiguedades;
	private CertificadoDestruccion certificadodedestruccion;
	private Complemento_SPEI complemento_SPEI;
	private ComercioExterior comercioExterior;
	private Detallista detallista;
	private RenovacionSustitucionVehiculos renovacionysustitucionvehiculos;
	private Pagos pagos;
	
	@XmlElement(name = "CFDIRegistroFiscal")
	public CFDIRegistroFiscal getRegistroFiscal() {
		return registroFiscal;
	}

	public void setRegistroFiscal(CFDIRegistroFiscal registroFiscal) {
		this.registroFiscal = registroFiscal;
	}

	@XmlElement(name = "PagoEnEspecie")
	public PagoEnEspecie getPagoEnEspecie() {
		return pagoEnEspecie;
	}

	public void setPagoEnEspecie(PagoEnEspecie pagoEnEspecie) {
		this.pagoEnEspecie = pagoEnEspecie;
	}
	
	@XmlElement(name = "NotariosPublicos")
	public NotariosPublicos getNotariosPublicos() {
		return notariosPublicos;
	}
	public void setNotariosPublicos(NotariosPublicos notariosPublicos) {
		this.notariosPublicos = notariosPublicos;
	}
	
	@XmlElement
	public Detallista getDetallista() {
		return detallista;
	}
	public void setDetallista(Detallista detallista) {
		this.detallista = detallista;
	}
	
	@XmlElement(name = "TimbreFiscalDigital")
	public TimbreFiscalDigital getTimbreFiscalDigital() {
		return timbreFiscalDigital;
	}
	@XmlElement(name = "ImpuestosLocales")
	public ImpuestosLocales getImpuestosLocales() {
		return impuestosLocales;
	}
	
	@XmlElement(name = "Donatarias")
	public Donatarias getDonatarias() {
		return donatarias;
	}
	public void setDonatarias(Donatarias donatarias) {
		this.donatarias = donatarias;
	}
	
	@XmlElement(name = "Nomina")
	public Nomina getNomina() {
		return nomina;
	}
	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}
	
	@XmlElement(name = "ConsumoDeCombustibles")
	public ConsumoDeCombustibles11 getConsumodecombustibles() {
		return consumodecombustibles;
	}
	public void setConsumodecombustibles(ConsumoDeCombustibles11 consumodecombustibles) {
		this.consumodecombustibles = consumodecombustibles;
	}

	@XmlElement(name = "EstadoDeCuentaCombustible")
	public EstadoDeCuentaCombustible12 getEstadodecuentacombustible12() {
		return estadodecuentacombustible12;
	}

	public void setEstadodecuentacombustible12(EstadoDeCuentaCombustible12 estadodecuentacombustible12) {
		this.estadodecuentacombustible12 = estadodecuentacombustible12;
	}
	
	@XmlElement(name = "VehiculoUsado")
	public VehiculoUsado getVehiculousado() {
		return vehiculousado;
	}
	public void setVehiculousado(VehiculoUsado vehiculousado) {
		this.vehiculousado = vehiculousado;
	}
	
	@XmlElement(name = "ValesDeDespensa")
	public ValesDeDespensa getValesDespensa() {
		return valesDespensa;
	}
	public void setValesDespensa(ValesDeDespensa valesDespensa) {
		this.valesDespensa = valesDespensa;
	}
	
	@XmlElement(name = "Aerolineas")
	public Aerolineas getAerolineas() {
		return aerolineas;
	}
	public void setAerolineas(Aerolineas aerolineas) {
		this.aerolineas = aerolineas;
	}
	
	@XmlElement(name = "ParcialesConstruccion")
	public ParcialesConstruccion getParcialesConstruccion() {
		return parcialesConstruccion;
	}

	public void setParcialesConstruccion(ParcialesConstruccion parcialesConstruccion) {
		this.parcialesConstruccion = parcialesConstruccion;
	}
	
	public void setTimbreFiscalDigital(TimbreFiscalDigital timbreFiscalDigital) {
		this.timbreFiscalDigital = timbreFiscalDigital;
	}
	public void setImpuestosLocales(ImpuestosLocales impuestosLocales) {
		this.impuestosLocales = impuestosLocales;
	}
	
	@XmlElement(name = "Divisas")
	public Divisas getDivisas() {
		return divisas;
	}
	public void setDivisas(Divisas divisas) {
		this.divisas = divisas;
	}
	
	@XmlElement(name = "TuristaPasajeroExtranjero")
	public TuristaPasajeroExtranjero getTurista() {
		return turista;
	}

	public void setTurista(TuristaPasajeroExtranjero turista) {
		this.turista = turista;
	}
	
	@XmlElement(name = "PersonaFisicaIntegranteDeCoordinado")
	public PersonaFisicaIntegranteDeCoordinado getPfic() {
		return pfic;
	}

	public void setPfic(PersonaFisicaIntegranteDeCoordinado pfic) {
		this.pfic = pfic;
	}
	
	@XmlElement(name = "INE")
	public INE getIne() {
		return ine;
	}

	public void setINE(INE ine) {
		this.ine = ine;
	}
	
	@XmlElement(name = "LeyendasFiscales")
	public LeyendasFiscales getLeyendasFisc() {
		return leyendasFisc;
	}

	public void setLeyendasFisc(LeyendasFiscales pfic) {
		this.leyendasFisc = leyendasFisc;
	}
	
	@XmlElement(name = "ObrasArteAntiguedades")
	public ObrasArteAntiguedades getObrasArteAntiguedades() {
		return obrasarteantiguedades;
	}

	public void setObrasArteAntiguedades(ObrasArteAntiguedades obrasarteantiguedades) {
		this.obrasarteantiguedades = obrasarteantiguedades;
	}
	
	@XmlElement(name = "CertificadoDestruccion")
	public CertificadoDestruccion getCertificadoDestruccion() {
		return certificadodedestruccion;
	}

	public void setCertificadoDestruccion(CertificadoDestruccion certificadodedestruccion) {
		this.certificadodedestruccion = certificadodedestruccion;
	}
	
	@XmlElement(name = "Complemento_SPEI")
	public Complemento_SPEI getComplemento_SPEI() {
		return complemento_SPEI;
	}

	public void setComplemento_SPEI(Complemento_SPEI complemento_SPEI) {
		this.complemento_SPEI = complemento_SPEI;
	}
	
	@XmlElement(name = "Nomina")
	public Nomina12 getNomina12() {
		return nomina12;
	}
	public void setNomina12(Nomina12 nomina12) {
		this.nomina12 = nomina12;
	}
	
	@XmlElement(name = "ComercioExterior")
	public ComercioExterior getComercioExterior() {
		return comercioExterior;
	}

	public void setComercioExterior(ComercioExterior comercioExterior) {
		this.comercioExterior = comercioExterior;
	}
	
	@XmlElement(name = "renovacionSustitucionVehiculos")
	public RenovacionSustitucionVehiculos getRenovacionysustitucionvehiculos() {
		return renovacionysustitucionvehiculos;
	}

	public void setrenovacionysustitucionvehiculos(RenovacionSustitucionVehiculos renovacionysustitucionvehiculos) {
		this.renovacionysustitucionvehiculos = renovacionysustitucionvehiculos;
	}
	
	@XmlElement(name = "Pagos")
	public Pagos getPagos() {
		return pagos;
	}

	public void setPagos(Pagos pagos) {
		this.pagos = pagos;
	}
}
