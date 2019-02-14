package mx.xpd.cfdi.domain.cfdi;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder={
		"retenciones",
		"traslados",
		"impuestoRetenciones",
		"impuestoTraslados"
})
public class Impuestos {
	
	private Traslados traslados;
	private Retenidos retenciones;
	private ImpuestoTraslados impuestoTraslados;
	private ImpuestoRetenidos impuestoRetenciones;
	
	private String totalImpuestosRetenidos;
	private String totalImpuestosTrasladados;
	
	
	
	@XmlElement(name = "Traslados")
	public Traslados getTraslados() {
		boolean blnSoloExentos = true;
		if (traslados!= null){
			if (traslados.getTraslado() != null){
				for (int i=0;i<traslados.getTraslado().size();i++){
					if (!traslados.getTraslado().get(i).getTipoFactor().equals("Exento")){
						blnSoloExentos = false;
					}
				}
			}
		}
		if (blnSoloExentos){
			traslados = null;
		}
		return traslados;
	}
	
	@XmlElement(name = "Retenciones")
	public Retenidos getRetenciones() {
		return retenciones;
	}
	
	@XmlElement(name = "Traslados")
	public ImpuestoTraslados getImpuestoTraslados() {
		return impuestoTraslados;
	}
	
	@XmlElement(name = "Retenciones")
	public ImpuestoRetenidos getImpuestoRetenciones() {
		return impuestoRetenciones;
	}
	/*
	public  boolean isExento() {
		if ((getRetenidos() == null) && (getTraslados() == null))
			return true;
		return false;
	}*/


	@XmlAttribute(name = "TotalImpuestosRetenidos")
	public String getTotalImpuestosRetenidos() {
		return totalImpuestosRetenidos;
	}
	@XmlAttribute(name = "TotalImpuestosTrasladados")
	public String getTotalImpuestosTrasladados() {
		
		boolean blnSoloExentos = true;
		if (impuestoTraslados!= null){
			if (impuestoTraslados.getImpuestoTraslado() != null){
				for (int i=0;i<impuestoTraslados.getImpuestoTraslado().size();i++){
					if (!impuestoTraslados.getImpuestoTraslado().get(i).getTipoFactor().equals("Exento")){
						blnSoloExentos = false;
					}
				}
			}
		}
		if ((blnSoloExentos)&&(totalImpuestosTrasladados ==null || totalImpuestosTrasladados.equals("0.00"))){
			return null;
		}
		else
			return totalImpuestosTrasladados;
		
		
	}
	
	

	public void setRetenciones(Retenidos retenciones) {
		this.retenciones = retenciones;
	}
	
	public void setImpuestoRetenciones(ImpuestoRetenidos impuestoRetenciones) {
		this.impuestoRetenciones = impuestoRetenciones;
	}	
	
	public void setImpuestoTraslados(ImpuestoTraslados impuestoTraslados) {
		this.impuestoTraslados = impuestoTraslados;
	}


	public void setTotalImpuestosRetenidos(String totalImpuestosRetenidos) {
		this.totalImpuestosRetenidos = totalImpuestosRetenidos;
	}

	public void setTotalImpuestosTrasladados(String totalImpuestosTrasladados) {
		this.totalImpuestosTrasladados = totalImpuestosTrasladados;
	}

	public void setTraslados(Traslados traslados) {
		this.traslados = traslados;
	}
	
	
	
	
	
}
