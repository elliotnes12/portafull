package mx.xpd.cfdi.domain.cfdi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ImpuestoRetenidos {
	private List<ImpuestoRetenciones> impuestoRetencion;

	public ImpuestoRetenidos() {
		impuestoRetencion = new ArrayList<ImpuestoRetenciones>();
	}
	@XmlElement(name = "Retencion")
	public List<ImpuestoRetenciones> getImpuestoRetencion() {
		reduce();
		return impuestoRetencion;
	}

	public void setImpuestoRetencion(List<ImpuestoRetenciones> impuestoRetencion) {
		this.impuestoRetencion = impuestoRetencion;
	}

	/**
	  * Reduce las retenciones agrupandolos por Impuesto
	  * los importes se suman
	  */
	private void reduce()
	{
		try{
		if(impuestoRetencion.size() > 1){
			String key = "";
			Double importe = 0.0;
			BigDecimal bd = new BigDecimal("0.0"); 
			HashMap<String, Double> agrupados = new HashMap<String, Double>();
			for(ImpuestoRetenciones t: impuestoRetencion){
				key = t.getImpuesto();
				importe = agrupados.get(key);
				if (importe != null){
					importe += Double.parseDouble(t.getImporte());
					bd = new BigDecimal(importe).setScale(6, RoundingMode.HALF_EVEN);
					importe = bd.doubleValue();
					
				} else {
					importe = Double.parseDouble(t.getImporte());
					bd = new BigDecimal(importe).setScale(6, RoundingMode.HALF_EVEN);
					importe = bd.doubleValue();
					
				}
				agrupados.put(key, importe);
			}
			if(agrupados.size() > 0 && (agrupados.size() != impuestoRetencion.size())){
				List<ImpuestoRetenciones> nuevaLista = new ArrayList<ImpuestoRetenciones>();
				ImpuestoRetenciones i;
				for(String data: agrupados.keySet()){
					i = new ImpuestoRetenciones();
					i.setImpuesto(data);
					i.setImporte(agrupados.get(data).toString());
					nuevaLista.add(i);
				}
				agrupados = null;
				impuestoRetencion = nuevaLista;
			}
		}
		}catch(Exception e){e.printStackTrace();}
	}
	
	
}
