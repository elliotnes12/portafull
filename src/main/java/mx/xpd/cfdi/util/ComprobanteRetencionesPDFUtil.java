package mx.xpd.cfdi.util;

import java.io.File;
import java.io.IOException;
import mx.xpd.cfdi.domain.cfdi.pdf.timbre.TimbreFiscalDigital;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

public class ComprobanteRetencionesPDFUtil {

	public static TimbreFiscalDigital getTimbre(File xmlFile) {
		TimbreFiscalDigital timbre = null;
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document;
			document = (Document) builder.build(xmlFile);
			Element e = null;
			Namespace ns = Namespace.getNamespace("retenciones", "http://www.sat.gob.mx/esquemas/retencionpago/1");
			e = document.getRootElement().getChild("Complemento", ns);
			
			ns = Namespace.getNamespace("tfd", "http://www.sat.gob.mx/TimbreFiscalDigital");
			e = e.getChild("TimbreFiscalDigital", ns);
			
			timbre = new TimbreFiscalDigital();
			timbre.setFechaTimbrado(e.getAttributeValue("FechaTimbrado"));
			timbre.setUuid(e.getAttributeValue("UUID"));
			timbre.setNoCertificadoSAT(e.getAttributeValue("noCertificadoSAT"));
			timbre.setSelloCFD(e.getAttributeValue("selloCFD"));
			timbre.setSelloSAT(e.getAttributeValue("selloSAT"));
			timbre.setVersion(e.getAttributeValue("version"));
		} catch (JDOMException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return timbre;
	}
	
}
