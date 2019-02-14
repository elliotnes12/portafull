package mx.xpd.cfdi.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import mx.xpd.cfdi.domain.CertificadoSelloDigital;
import mx.xpd.cfdi.domain.cfdi.Comprobante;
import mx.xpd.cfdi.domain.cfdi.pdf.ComprobantePDF;
import mx.xpd.cfdi.domain.cfdi.pdf.timbre.TimbreFiscalDigital;
import mx.xpd.cfdi.timbrado.service.Timbrado;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub.RespuestaTimbrado;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

import com.google.gson.Gson;



public class ComprobantePDFUtil {

	public static TimbreFiscalDigital getTimbre(File xmlFile) {
		TimbreFiscalDigital timbre = null;
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document;
			document = (Document) builder.build(xmlFile);
			Element e = null;
			Namespace ns = Namespace.getNamespace("cfdi", "http://www.sat.gob.mx/cfd/3");
			e = document.getRootElement().getChild("Complemento", ns);
			
			ns = Namespace.getNamespace("tfd", "http://www.sat.gob.mx/TimbreFiscalDigital");
			e = e.getChild("TimbreFiscalDigital", ns);
			
			timbre = new TimbreFiscalDigital();
			timbre.setFechaTimbrado(e.getAttributeValue("FechaTimbrado"));
			timbre.setUuid(e.getAttributeValue("UUID"));
			timbre.setNoCertificadoSAT(e.getAttributeValue("NoCertificadoSAT"));
			timbre.setSelloCFD(e.getAttributeValue("SelloCFD"));
			timbre.setSelloSAT(e.getAttributeValue("SelloSAT"));
			timbre.setVersion(e.getAttributeValue("Version"));
			timbre.setRfcProvCertif(e.getAttributeValue("RfcProvCertif"));
			timbre.setLeyenda(e.getAttributeValue("Leyenda"));
			
			
		} catch (JDOMException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return timbre;
	}
	
}
