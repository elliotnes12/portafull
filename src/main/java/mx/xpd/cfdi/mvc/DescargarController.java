package mx.xpd.cfdi.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.ParametroDao;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/descargar")
public class DescargarController {
	
	@Autowired
	private DatosEmisorDao daoEmisor;
	@Autowired
	private ParametroDao daoParametro;
	
	@RequestMapping(value = "/xml/{uuid}/{fecha}")
	public void gatXML( @PathVariable("uuid") String uuid, @PathVariable String fecha, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pdfName =  uuid + ".xml"; 
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		getFile(pdfName, fecha, response.getOutputStream(), response, tenantID);
	}
	
	@RequestMapping(value = "/xmlRet/{uuid}")
	public void getXML( @PathVariable("uuid") String uuid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pdfName =  uuid + ".xml"; 
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		getFileRet(pdfName, response.getOutputStream(), response, tenantID);
	}
	
	@RequestMapping(value = "/pdf/{uuid}/{fecha}")
	public void getPDF( @PathVariable("uuid") String uuid, @PathVariable String fecha, HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		String pdfName =  uuid + ".pdf"; 
		getFile(pdfName, fecha, response.getOutputStream(), response, tenantID);
	}
	
	@RequestMapping(value = "/pdfRet/{uuid}")
	public void getPDFRet( @PathVariable("uuid") String uuid, HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");

		String pdfName =  uuid + ".pdf"; 
		getFileRet(pdfName, response.getOutputStream(), response, tenantID);
	}

	private void getFile(String pdfName, String fecha, OutputStream out, HttpServletResponse response, String tenant) {
		response.setContentType("application/force-download");
		//response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Content-Disposition","filename=" + pdfName);
		String path = null;
		
		
		if (pdfName.endsWith(".pdf")) {
				path = daoParametro.findByClave("PATH_EXTERNO_PDF_TIMBRADO").getValor();
			} else {
				path = daoParametro.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();
			}
		
		
		
		path += File.separatorChar +  daoEmisor.findEmisor(tenant).getRfc() + File.separatorChar + pdfName;
		Log.info(path);
		try {
			FileInputStream in = new FileInputStream(path);
			
			byte[] o = new byte[1024];
			int readed;
			while((readed = in.read(o)) != -1) {
				out.write(o, 0, readed);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void getFileRet(String pdfName, OutputStream out, HttpServletResponse response, String tenant) {
		response.setContentType("application/force-download");
		//response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Content-Disposition","filename=" + pdfName);
		String path = null;
		if (pdfName.endsWith(".pdf")) {
			path = daoParametro.findByClave("PATH_PDF_RETENCIONES_TIMBRADO").getValor();
		} else {
			path = daoParametro.findByClave("PATH_XML_RETENCIONES_TIMBRADO").getValor();
		}
		
		path += File.separatorChar +  daoEmisor.findEmisor(tenant).getRfc() + File.separatorChar + pdfName;
		Log.info(path);
		try {
			FileInputStream in = new FileInputStream(path);
			
			byte[] o = new byte[1024];
			int readed;
			while((readed = in.read(o)) != -1) {
				out.write(o, 0, readed);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
