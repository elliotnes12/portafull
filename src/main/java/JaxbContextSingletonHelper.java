import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import mx.xpd.cfdi.domain.cfdi.pdf.ComprobantePDF;


public class JaxbContextSingletonHelper {

	private static JAXBContext jaxbContextXML;
	private static JAXBContext jaxbContextPDF;
	
	public static JAXBContext getInstanceXML() {
	      if(jaxbContextXML == null) { 
	    	  try {
	    		  jaxbContextXML = JAXBContext.newInstance(ComprobantePDF.class);
	    	  } catch(Exception e) {
	    		  System.out.println("\n\n\t\t\t######### Errror " + e);
	    	  }
	      }
	      return jaxbContextXML;
	}
	 
	public static JAXBContext getInstancePDF() {
	      if(jaxbContextPDF == null) { 
	    	  try {
	    		  jaxbContextPDF = JAXBContext.newInstance(mx.xpd.cfdi.domain.cfdi.Comprobante.class);
	    	  } catch(Exception e) {
	    		  System.out.println("\n\n\t\t\t######### Errror " + e);
	    	  }
	      }
	      return jaxbContextPDF;
	}
	
}
