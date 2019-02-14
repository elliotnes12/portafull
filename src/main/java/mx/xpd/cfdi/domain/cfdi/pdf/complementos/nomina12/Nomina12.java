package mx.xpd.cfdi.domain.cfdi.pdf.complementos.nomina12;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="Nomina")
@XmlType(propOrder={
		"emisor",
		"receptor",
		"percepciones",
		"deducciones",
		"otrosPagos",
		"incapacidades"
		
})
public class Nomina12 {
	
	private String version;
	private String tipoNomina;
	private String fechaPago;
	private String fechaInicialPago;
	private String fechaFinalPago;
	private String numDiasPagados;
	
	private String totalPercepciones;
	private String totalDeducciones;
	private String totalOtrosPagos;
	
	private EmisorNomina12 emisor;
	private ReceptorNomina12 receptor;
	private PercepcionesNomina12 percepciones;
	private DeduccionesNomina12 deducciones;
	private OtrosPagosNomina12 otrosPagos;
	private IncapacidadesNomina12 incapacidades;
		
	public Nomina12() {
		
	}
	
	@XmlAttribute(name = "Version")
	public String getVersion() {
		return "1.2";
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	@XmlAttribute(name = "TipoNomina")
	public String getTipoNomina() {
		return (tipoNomina == null || tipoNomina.trim().equals("")) ? null : tipoNomina.trim();
	}
	
	public void setTipoNomina(String tipoNomina) {
		this.tipoNomina = tipoNomina;
	}
	
	@XmlAttribute(name = "FechaPago")
	public String getFechaPago() {
		return (fechaPago == null || fechaPago.trim().equals("")) ? null : fechaPago.trim();
	}
	
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	@XmlAttribute(name = "FechaInicialPago")
	public String getFechaInicialPago() {
		return (fechaInicialPago == null || fechaInicialPago.trim().equals("")) ? null : fechaInicialPago.trim();
	}
	
	public void setFechaInicialPago(String fechaInicialPago) {
		this.fechaInicialPago = fechaInicialPago;
	}
	
	@XmlAttribute(name = "FechaFinalPago")
	public String getFechaFinalPago() {
		return (fechaFinalPago == null || fechaFinalPago.trim().equals("")) ? null : fechaFinalPago.trim();
	}
	
	public void setFechaFinalPago(String fechaFinalPago) {
		this.fechaFinalPago = fechaFinalPago;
	}
	
	@XmlAttribute(name = "NumDiasPagados")
	public String getNumDiasPagados() {
		return numDiasPagados;
	}
	
	public void setNumDiasPagados(String numDiasPagados) {
		this.numDiasPagados = numDiasPagados;
	}
	
	@XmlAttribute(name = "TotalPercepciones")
	public String getTotalPercepciones() {
		return (totalPercepciones == null || totalPercepciones.trim().equals("")) ? null : totalPercepciones.trim();
	}
	
	public void setTotalPercepciones(String totalPercepciones) {
		this.totalPercepciones = totalPercepciones;
	}
	
	@XmlAttribute(name = "TotalDeducciones")
	public String getTotalDeducciones() {
		return (totalDeducciones == null || totalDeducciones.trim().equals("")) ? null : totalDeducciones.trim();
	}
	
	public void setTotalDeducciones(String totalDeducciones) {
		this.totalDeducciones = totalDeducciones;
	}
	
	@XmlAttribute(name = "TotalOtrosPagos")
	public String getTotalOtrosPagos() {
		return (totalOtrosPagos == null || totalOtrosPagos.trim().equals("")) ? null : totalOtrosPagos.trim();
	}
	
	public void setTotalOtrosPagos(String totalOtrosPagos) {
		this.totalOtrosPagos = totalOtrosPagos;
	}
	
	@XmlElement(name = "Emisor")
	public EmisorNomina12 getEmisor() {
		return emisor;
	}
	
	public void setEmisor(EmisorNomina12 emisor) {
		this.emisor = emisor;
	}
	
	@XmlElement(name = "Receptor")
	public ReceptorNomina12 getReceptor() {
		return receptor;
	}
	
	public void setReceptor(ReceptorNomina12 receptor) {
		this.receptor = receptor;
	}
	
	@XmlElement(name = "Percepciones")
	public PercepcionesNomina12 getPercepciones() {
		return percepciones;
	}
	
	public void setPercepciones(PercepcionesNomina12 percepciones) {
		this.percepciones = percepciones;
	}
	
	@XmlElement(name = "Deducciones")
	public DeduccionesNomina12 getDeducciones() {
		return deducciones;
	}
	
	public void setDeducciones(DeduccionesNomina12 deducciones) {
		this.deducciones = deducciones;
	}
	
	@XmlElement(name = "OtrosPagos")
	public OtrosPagosNomina12 getOtrosPagos() {
		return otrosPagos;
	}
	
	public void setOtrosPagos(OtrosPagosNomina12 otrosPagos) {
		this.otrosPagos = otrosPagos;
	}
		
	@XmlElement(name = "Incapacidades")
	public IncapacidadesNomina12 getIncapacidades() {
		return incapacidades;
	}
	
	public void setIncapacidades(IncapacidadesNomina12 incapacidades) {
		this.incapacidades = incapacidades;
	}
	
	
	
}
