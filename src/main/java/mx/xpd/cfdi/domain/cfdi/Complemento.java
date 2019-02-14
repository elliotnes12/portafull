package mx.xpd.cfdi.domain.cfdi;

import javax.xml.bind.annotation.XmlElement;

import mx.xpd.cfdi.domain.cfdi.complementos.aerolineas.Aerolineas;
import mx.xpd.cfdi.domain.cfdi.complementos.certificadodestruccion.CertificadoDestruccion;
import mx.xpd.cfdi.domain.cfdi.complementos.comercioexterior.ComercioExterior;
import mx.xpd.cfdi.domain.cfdi.complementos.consumodecombustibles.ConsumoDeCombustibles11;
import mx.xpd.cfdi.domain.cfdi.complementos.ecc12.EstadoDeCuentaCombustible12;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista;
import mx.xpd.cfdi.domain.cfdi.complementos.divisas.Divisas;
import mx.xpd.cfdi.domain.cfdi.complementos.arteantiguedades.ObrasArteAntiguedades;
import mx.xpd.cfdi.domain.cfdi.complementos.personafisicaintegrantedecoordinado.PersonaFisicaIntegranteDeCoordinado;
import mx.xpd.cfdi.domain.cfdi.complementos.donatarias.Donatarias;
import mx.xpd.cfdi.domain.cfdi.complementos.impuestos.ImpuestosLocales;
import mx.xpd.cfdi.domain.cfdi.complementos.ine.INE;
import mx.xpd.cfdi.domain.cfdi.complementos.leyendasfiscales.LeyendasFiscales;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Nomina;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Nomina12;
import mx.xpd.cfdi.domain.cfdi.complementos.notarios.NotariosPublicos;
import mx.xpd.cfdi.domain.cfdi.complementos.pagoenespecie.PagoEnEspecie;
import mx.xpd.cfdi.domain.cfdi.complementos.pagos.Pagos;
import mx.xpd.cfdi.domain.cfdi.complementos.parcialesconstruccion.ParcialesConstruccion;
import mx.xpd.cfdi.domain.cfdi.complementos.registroFiscal.CFDIRegistroFiscal;
import mx.xpd.cfdi.domain.cfdi.complementos.renovacionsustitucionvehiculos.RenovacionSustitucionVehiculos;
import mx.xpd.cfdi.domain.cfdi.complementos.spei.Complemento_SPEI;
import mx.xpd.cfdi.domain.cfdi.complementos.turistapasajeroextranjero.TuristaPasajeroExtranjero;
import mx.xpd.cfdi.domain.cfdi.complementos.valesdedespensa.ValesDeDespensa;
import mx.xpd.cfdi.domain.cfdi.complementos.vehiculousado.VehiculoUsado;
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
	private ParcialesConstruccion parcialesConstruccion;
	private Aerolineas aerolineas;
	private Divisas divisas;
	private TuristaPasajeroExtranjero turista;
	private PersonaFisicaIntegranteDeCoordinado pfic;
	private INE ine;
	private LeyendasFiscales leyendasFisc;
	private ObrasArteAntiguedades obrasarteantiguedades;
	private CertificadoDestruccion certificadodedestruccion;
	private Complemento_SPEI complemento_SPEI;
	private ComercioExterior comercioExterior;
	private RenovacionSustitucionVehiculos renovacionysustitucionvehiculos;
	private Detallista detallista;
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

	@XmlElement
	public NotariosPublicos getNotariosPublicos() {
		return notariosPublicos;
	}

	public void setNotariosPublicos(NotariosPublicos notariosPublicos) {
		this.notariosPublicos = notariosPublicos;
	}

	@XmlElement(name = "ConsumoDeCombustibles")
	public ConsumoDeCombustibles11 getConsumodecombustibles() {
		return consumodecombustibles;
	}

	public void setConsumodecombustibles(ConsumoDeCombustibles11 consumodecombustibles) {
		this.consumodecombustibles = consumodecombustibles;
	}

	@XmlElement(name = "EstadoDeCuentaCombustible12")
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

	public void setDetallista(Detallista detallista) {
		this.detallista = detallista;
	}

	@XmlElement
	public Detallista getDetallista() {
		return detallista;
	}

	@XmlElement
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

	@XmlElement(name = "Nomina")
	public Nomina getNomina() {
		return nomina;
	}
	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}
	
	@XmlElement(name = "Nomina")
	public Nomina12 getNomina12() {
		return nomina12;
	}
	public void setNomina12(Nomina12 nomina12) {
		this.nomina12 = nomina12;
	}
	
	@XmlElement(name = "ValesDeDespensa")
	public ValesDeDespensa getValesDespensa() {
		return valesDespensa;
	}

	public void setValesDespensa(ValesDeDespensa valesDespensa) {
		this.valesDespensa = valesDespensa;
	}

	/*	
	public void setDonatarias(Donatarias donatarias) {
		this.donatarias = donatarias;
	}
	public void setTimbreFiscalDigital(TimbreFiscalDigital timbreFiscalDigital) {
		this.timbreFiscalDigital = timbreFiscalDigital;
	}
*/
	public void setImpuestosLocales(ImpuestosLocales impuestosLocales) {
		this.impuestosLocales = impuestosLocales;
	}
	
	@XmlElement(name = "ParcialesConstruccion")
	public ParcialesConstruccion getParcialesConstruccion() {
		return parcialesConstruccion;
	}

	public void setParcialesConstruccion(ParcialesConstruccion parcialesConstruccion) {
		this.parcialesConstruccion = parcialesConstruccion;
	}

	@XmlElement(name = "Aerolineas")
	public Aerolineas getAerolineas() {
		return aerolineas;
	}

	public void setAerolineas(Aerolineas aerolineas) {
		this.aerolineas = aerolineas;
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

	public void setLeyendasFisc(LeyendasFiscales leyendasFisc) {
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
	
	@XmlElement(name = "comercioexterior")
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
	@XmlElement(name = "pagos")
	public Pagos getPagos() {
		return pagos;
	}

	public void setPagos(Pagos pagos) {
		this.pagos = pagos;
	}
}