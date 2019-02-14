package mx.xpd.cfdi.domain.cfdi.pdf;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import mx.xpd.cfdi.domain.cfdi.pdf.ImpuestoTraslado;

public class ImpuestoTraslados {
	private List<ImpuestoTraslado> impuestoTraslado;

	public ImpuestoTraslados() {
		impuestoTraslado = new ArrayList<ImpuestoTraslado>();
	}
	@XmlElement(name = "Traslado")
	public List<ImpuestoTraslado> getImpuestoTraslado() {
		reduce();
		return impuestoTraslado;
	}

	public void setImpuestoTraslado(List<ImpuestoTraslado> impuestoTraslado) {
		this.impuestoTraslado = impuestoTraslado;
	}

	/**
	  * Reduce los traslados agrupandolos por Impuesto, TipoFactor, TasaOCuota
	  * los importes se suman
	  */
	private void reduce()
	{
		try{
			boolean blnSoloExentos = true;
			if (impuestoTraslado != null){
				
				
				for(ImpuestoTraslado t: impuestoTraslado){
					if (!t.getTipoFactor().equals("Exento")){
						blnSoloExentos = false;
					}
				}
				if (blnSoloExentos){
					impuestoTraslado = null;
				}
				else{
					if(impuestoTraslado.size() > 1){
		
						String key = "";
						Double importe = 0.0;
						DecimalFormat df = new DecimalFormat("#.000000"); 
						HashMap<String, Double> agrupados = new HashMap<String, Double>();
						for(ImpuestoTraslado t: impuestoTraslado){
							if (!t.getTipoFactor().equals("Exento")){
								key = t.getImpuesto() + "|" + t.getTipoFactor() + "|" + t.getTasaOCuota();
								importe = agrupados.get(key);
								if (importe != null){
									importe += Double.parseDouble(t.getImporte());
									importe = Double.valueOf(df.format(importe));
								} else {
									importe = Double.parseDouble(t.getImporte());
									importe = Double.valueOf(df.format(importe));
								}
								agrupados.put(key, importe);
							}
						}
						if(agrupados.size() > 0 && (agrupados.size() != impuestoTraslado.size())){
							List<ImpuestoTraslado> nuevaLista = new ArrayList<ImpuestoTraslado>();
							String[] args;
							ImpuestoTraslado i;
							for(String data: agrupados.keySet()){
								args = data.split("\\|");
								i = new ImpuestoTraslado();
								i.setImpuesto(args[0]);
								i.setTipoFactor(args[1]);
								i.setTasa(args[2]);
								i.setImporte(agrupados.get(data).toString());
								nuevaLista.add(i);
							}
							agrupados = null;
							impuestoTraslado = nuevaLista;
						}
					}
				
				}
			}
		}catch(Exception e){e.printStackTrace();}
	}
	
	
}
