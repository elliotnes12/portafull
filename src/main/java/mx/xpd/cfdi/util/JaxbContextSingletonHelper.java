package mx.xpd.cfdi.util;

import javax.xml.bind.JAXBContext;

import org.apache.log4j.Logger;

import mx.xpd.cfdi.domain.cfdi.Comprobante;
import mx.xpd.cfdi.domain.cfdi.pdf.ComprobantePDF;


public class JaxbContextSingletonHelper {
	
	private static Logger log = Logger.getLogger(JaxbContextSingletonHelper.class);

	private static JAXBContext jaxbContextXML;
	private static JAXBContext jaxbContextPDF;
	
	public static JAXBContext getInstanceXML() {
	      if(jaxbContextXML == null) { 
	    	  try {
	    		  jaxbContextXML = JAXBContext.newInstance(Comprobante.class);
	    	  } catch(Exception e) {
	    		  log.error("Error: " + e);
	    		  e.printStackTrace();
	    	  }
	      }
	      return jaxbContextXML;
	}
	 
	public static JAXBContext getInstancePDF() {
	      if(jaxbContextPDF == null) { 
	    	  try {
	    		  jaxbContextPDF = JAXBContext.newInstance(ComprobantePDF.class);
	    	  } catch(Exception e) {
	    		  log.error("Error: " + e);
	    		  e.printStackTrace();
	    	  }
	      }
	      return jaxbContextPDF;
	}
	
}
