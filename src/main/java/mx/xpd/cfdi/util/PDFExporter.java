package mx.xpd.cfdi.util;

import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.w3c.dom.Document;

public class PDFExporter {

	public static boolean xmlToPDF(String urlPlantilla, Map<String, Object> params, Document doc, OutputStream out) {
		try {
			JasperReport report = JasperCompileManager.compileReport(urlPlantilla);
			params.put("XML_DATA_DOCUMENT", doc);
			JasperPrint print = JasperFillManager.fillReport(report, params);
			JasperExportManager.exportReportToPdfStream(print, out);
			return true;
		} catch (JRException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
