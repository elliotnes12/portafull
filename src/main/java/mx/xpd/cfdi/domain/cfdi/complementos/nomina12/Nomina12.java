package mx.xpd.cfdi.domain.cfdi.complementos.nomina12;

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
	
	private Emisor emisor;
	private Receptor receptor;
	private Percepciones percepciones;
	private Deducciones deducciones;
	private OtrosPagos otrosPagos;
	private Incapacidades incapacidades;
		
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
	public Emisor getEmisor() {
		return emisor;
	}
	
	public void setEmisor(Emisor emisor) {
		this.emisor = emisor;
	}
	
	@XmlElement(name = "Receptor")
	public Receptor getReceptor() {
		return receptor;
	}
	
	public void setReceptor(Receptor receptor) {
		this.receptor = receptor;
	}
	
	@XmlElement(name = "Percepciones")
	public Percepciones getPercepciones() {
		return percepciones;
	}
	
	public void setPercepciones(Percepciones percepciones) {
		this.percepciones = percepciones;
	}
	
	@XmlElement(name = "Deducciones")
	public Deducciones getDeducciones() {
		return deducciones;
	}
	
	public void setDeducciones(Deducciones deducciones) {
		this.deducciones = deducciones;
	}
	
	@XmlElement(name = "OtrosPagos")
	public OtrosPagos getOtrosPagos() {
		return otrosPagos;
	}
	
	public void setOtrosPagos(OtrosPagos otrosPagos) {
		this.otrosPagos = otrosPagos;
	}
		
	@XmlElement(name = "Incapacidades")
	public Incapacidades getIncapacidades() {
		return incapacidades;
	}
	
	public void setIncapacidades(Incapacidades incapacidades) {
		this.incapacidades = incapacidades;
	}
	
	
	
}
