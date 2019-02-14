package mx.xpd.cfdi.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.rpc.ServiceException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import mx.xpd.cfdi.domain.CancelacionScript;
import mx.xpd.cfdi.domain.CertificadoSelloDigital;
import mx.xpd.cfdi.domain.CfdEmitido;
import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.Email;
import mx.xpd.cfdi.domain.RetencionesEmitido;
import mx.xpd.cfdi.domain.Usuario;
import mx.xpd.cfdi.domain.map.MapCfdGrafica;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.CancelacionScriptDao;
import mx.xpd.cfdi.repo.CertificadoSelloDigitalDao;
import mx.xpd.cfdi.repo.ClienteDao;
import mx.xpd.cfdi.repo.ComprobanteDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.repo.RetencionesDao;
import mx.xpd.cfdi.repo.UsuarioDao;
import mx.xpd.cfdi.util.CancelacionUtil;
import mx.xpd.cfdi.util.SecurityUtil;
import mx.xpd.service.RespuestaCancelacion;
import mx.xpd.service.cancelacion.RespuestaCliente;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
/*
 * Cambio oohhh   
 * 
 * 
 * 
 */


@Controller
@RequestMapping(value = "/rest/comprobante")
public class ComprobanteRestController {

	private Logger log = Logger.getLogger(ComprobanteRestController.class);
	@Autowired
	private ComprobanteDao comprobanteDao;
	@Autowired
	private RetencionesDao retencionesDao;
	@Autowired
	private DatosEmisorDao emisorDao;
	@Autowired
	private CertificadoSelloDigitalDao csdDao;
	@Autowired
	private ParametroDao parametroDao;
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private CancelacionScriptDao cancelacionScriptDao;
	

	@RequestMapping(value = "/zipFile/{fecha}") //, method = RequestMethod.GET, produces = "application/json")
	public void zipFile(@PathVariable("fecha") String fecha, HttpServletRequest request, HttpServletResponse resp) throws Exception {
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
			
		List<CfdEmitido> cfdis = comprobanteDao.findByDates(tenantID, fecha.substring(0, 4), fecha.substring(5));
		
	
		ZipOutputStream zip = new ZipOutputStream(resp.getOutputStream());
		
		ZipEntry tmp = null;
		
		Path path = null;
		byte []data = null;
		
		String pathXML = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();
		String pathPDF = parametroDao.findByClave("PATH_EXTERNO_PDF_TIMBRADO").getValor();
		
		String pathS = "";
		
		for (CfdEmitido cfdi : cfdis) {
			
			pathS = pathXML + "/" + tenantID + "/" + cfdi.getUuid()  + ".xml";
				
				log.info(pathS);
				
				if (!(new File(pathS)).exists()) {
					continue;
				}
				
				tmp = new ZipEntry(cfdi.getUuid() + ".xml");
				zip.putNextEntry(tmp);
				data = Files.readAllBytes(Paths.get(pathS));
				zip.write(data);
				zip.closeEntry();
				
				pathS = pathPDF + "/" + tenantID + "/" + cfdi.getUuid()  + ".pdf";
				
				log.info(pathS);
				
				if (!(new File(pathS)).exists()) {
					continue;
				}
				
				tmp = new ZipEntry(cfdi.getUuid() + ".pdf");
				zip.putNextEntry(tmp);
				data = Files.readAllBytes(Paths.get(pathS));
				zip.write(data);
				zip.closeEntry();
		}
		
		zip.flush();
		zip.close();
		
		
		resp.setContentType("application/zip");
	    resp.setHeader("Content-Disposition","inline; filename=output.zip;");  
		// resp.getOutputStream().write(zip.);
		
	}
	@RequestMapping(value = "/xlsFileNomina/{fecha}") //, method = RequestMethod.GET, produces = "application/json")
	public void xlsFileNomina(@PathVariable("fecha") String fecha, HttpServletRequest request, HttpServletResponse resp) throws Exception {
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
			
		List<CfdEmitido> cfdis = comprobanteDao.findByDatesNomina(tenantID, fecha.substring(0, 4), fecha.substring(5));

		String pathXML = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();

		String pathS = "";


        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Workbook libro = new HSSFWorkbook();
        Sheet hoja = libro.createSheet("Reporte");

        int ff = 0;
        Cell celda;
        Row fila;
        fila = hoja.createRow(ff);

        int n = 0;
        celda = fila.createCell(n++);
        celda.setCellValue("Folio Fiscal");
        
        celda = fila.createCell(n++);
        celda.setCellValue("RFC (Emisor)");
       
        celda = fila.createCell(n++);
        celda.setCellValue("Razon Social (Emisor)");
        
        celda = fila.createCell(n++);
        celda.setCellValue("RFC (Receptor)");
       
        celda = fila.createCell(n++);
        celda.setCellValue("Razon Social (Receptor)");

        celda = fila.createCell(n++);
        celda.setCellValue("SubTotal");
        
        celda = fila.createCell(n++);
        celda.setCellValue("Total");

        celda = fila.createCell(n++);
        celda.setCellValue("Descuento");

        celda = fila.createCell(n++);
        celda.setCellValue("Percepcion");

        celda = fila.createCell(n++);
        celda.setCellValue("Importe Gravado");

        celda = fila.createCell(n++);
        celda.setCellValue("Importe Exento");
        
        celda = fila.createCell(n++);
        celda.setCellValue("Deduccion");
        
        celda = fila.createCell(n++);
        celda.setCellValue("Importe");

        
/*
        celda = fila.createCell(n++);
        celda.setCellValue("Serie");

        celda = fila.createCell(n++);
        celda.setCellValue("Folio");
*/
        
        celda = fila.createCell(n++);
        celda.setCellValue("Percepciones Total Gravado");
        
        celda = fila.createCell(n++);
        celda.setCellValue("Percepciones Total Exento");
        
        celda = fila.createCell(n++);
        celda.setCellValue("Total Impuestos Retenidos");
        
        celda = fila.createCell(n++);
        celda.setCellValue("Total Otras Deducciones");

        celda = fila.createCell(n++);
        celda.setCellValue("Fecha");

        celda = fila.createCell(n++);
        celda.setCellValue("Metodo Pago");

        celda = fila.createCell(n++);
        celda.setCellValue("TipoComprobante");

        celda = fila.createCell(n++);
        celda.setCellValue("Estado del CFDI");    
        
        celda = fila.createCell(n++);
        celda.setCellValue("Fecha Cancelación"); 
        
        celda = fila.createCell(n++);
        celda.setCellValue("Fecha Inicial Pago"); 
        
        ff++;
		
		for (CfdEmitido cfdi : cfdis) {
			
				   pathS = pathXML + "/" + tenantID + "/" + cfdi.getUuid()  + ".xml";
				
				   log.info(pathS);
				   File file = new File(pathS);
				
				    if (!file.exists()) {
					  continue;
			    	}
				
				 	n = 0;

	                fila = hoja.createRow(ff);
	                System.out.println("Procesando: " + file.getName());

	                Document doc = dBuilder.parse(file);

	                CellStyle style = libro.createCellStyle();
	                DataFormat format = libro.createDataFormat();
	                style.setDataFormat(format.getFormat("#,##0.00"));
	                
	            	NodeList nList00 = doc.getElementsByTagName("cfdi:Emisor");
	                Element emisor = (Element) nList00.item(0);

	                NodeList nList0 = doc.getElementsByTagName("cfdi:Receptor");
	                Element receptor = (Element) nList0.item(0);

	                NodeList nList1 = doc.getElementsByTagName("tfd:TimbreFiscalDigital");
	                Element eElement1 = (Element) nList1.item(0);
	                

	                String uuid = eElement1.getAttribute("UUID");
	                String rfcEmisor = emisor.getAttribute("Rfc");
	                String nameEmisor = emisor.getAttribute("Nombre");
	                String rfcReceptor = receptor.getAttribute("Rfc");
	                String nameReceptor = receptor.getAttribute("Nombre");


	                celda = fila.createCell(n++);
	                celda.setCellValue(uuid);

	                celda = fila.createCell(n++);
	                celda.setCellValue(rfcEmisor);

	                celda = fila.createCell(n++);
	                celda.setCellValue(nameEmisor);
	                
	                celda = fila.createCell(n++);
	                celda.setCellValue(rfcReceptor);

	                celda = fila.createCell(n++);
	                celda.setCellValue(nameReceptor);

	                Element parent = doc.getDocumentElement();

	                celda = fila.createCell(n++);
	                celda.setCellValue(Float.parseFloat(parent.getAttribute("SubTotal")));
	                
	                celda.setCellStyle(style);
	                celda = fila.createCell(n++);
	                celda.setCellValue(Float.parseFloat(parent.getAttribute("Total")));
	                

	                celda.setCellStyle(style);
	                celda = fila.createCell(n++);
	                celda.setCellValue(Float.parseFloat(parent.getAttribute("Descuento").isEmpty() ? "0" : parent.getAttribute("Descuento")));
	                celda.setCellStyle(style);
	                boolean istwo = false,banderaPerc = false,banderaDed = false;
	               
	                int takeRow = ff;
	                
		            NodeList nodoPercepcion = doc.getElementsByTagName("nomina12:Percepcion");
		            NodeList nodoDeduccion = doc.getElementsByTagName("nomina12:Deduccion");
		            
		            NodeList nodoPercepciones = doc.getElementsByTagName("nomina12:Percepciones");
		            Element percecionesElement = (Element) nodoPercepciones.item(0);
		            
		            NodeList nodoDeducciones = doc.getElementsByTagName("nomina12:Deducciones");
		            Element deduccionesElement = (Element) nodoDeducciones.item(0);
		            
		            
		            banderaPerc = nodoPercepcion.getLength() > 0? true : false;
		            banderaDed = nodoDeduccion.getLength() > 0? true : false;
		            
		            int total = 0;
		            		
		            if(nodoPercepcion.getLength() > nodoDeduccion.getLength())
		            {
		            	total = nodoPercepcion.getLength();
		            }
		            else if(nodoPercepcion.getLength() < nodoDeduccion.getLength())
		            {
		            	total = nodoDeduccion.getLength();
		            }
		            else if(nodoPercepcion.getLength() == nodoDeduccion.getLength())
		            {
		            	total = nodoPercepcion.getLength();
		            }
		            
		             for(int j = 0;j<total;j++){
	                		
	                		Element nodo =  (Element) nodoPercepcion.item(j);
	                		Element nodo1 =  (Element) nodoDeduccion.item(j);
	                		
	                	
	                			if(!istwo)
	                			{
	                				istwo = true;
	                			}
	                			else
	                			{
	                				if(hoja.getRow(++ff) != null)
			                	    {
			                		  fila.setRowNum(ff);
			                		}
			                		else
			                		{
			                		 fila = hoja.createRow(ff);
			                		}
	                			}
	                			

	                			if(nodo != null){
	                				
	                				n = 8;
	                				
	                				celda = fila.createCell(n++);
		                			celda.setCellValue(nodo.getAttribute("Concepto"));
		                			
		                			celda = fila.createCell(n++);
		                			celda.setCellStyle(style);
		                			celda.setCellValue(nodo.getAttribute("ImporteGravado"));
		                			
		                			celda = fila.createCell(n++);
		                			celda.setCellStyle(style);
		                			celda.setCellValue(nodo.getAttribute("ImporteExento"));
	                			}
	                			
	                			

                                if(nodo1 != null){
	                				
                                	n = 11;
                                	
	                				celda = fila.createCell(n++);
		                			celda.setCellValue(nodo1.getAttribute("Concepto"));
		                			
		                			celda = fila.createCell(n++);
		                			celda.setCellStyle(style);
		                			celda.setCellValue(nodo1.getAttribute("Importe"));
	                			}
	                			
	                		
	                	}
	                	
	                fila.setRowNum(takeRow);
	                
	                if(!banderaPerc)
	                {
	                	n = 8;
        				
        				celda = fila.createCell(n++);
            			celda.setCellValue("NA");
            			
            			celda = fila.createCell(n++);
            			celda.setCellStyle(style);
            			celda.setCellValue("NA");
            			
            			celda = fila.createCell(n++);
            			celda.setCellStyle(style);
            			celda.setCellValue("NA");
	                }
	                if(!banderaDed)
	                {
	                	n = 11;
        				celda = fila.createCell(n++);
            			celda.setCellValue("NA");
            			
            			celda = fila.createCell(n++);
            			celda.setCellValue("NA");
	                }
	                String totalGravado = "0.00",TotalExento = "0.00",TotalImpuestosR = "0.00",TotalOtrasDed = "0.00";
	             
	                if(percecionesElement != null)
	                {
	                	totalGravado = percecionesElement.getAttribute("TotalGravado").isEmpty()? "0.00" : percecionesElement.getAttribute("TotalGravado");
	                	TotalExento = percecionesElement.getAttribute("TotalExento").isEmpty()? "0.00" : percecionesElement.getAttribute("TotalExento") ;
	                }
	                
	                if(deduccionesElement != null)
	                {
	                	TotalImpuestosR = deduccionesElement.getAttribute("TotalImpuestosRetenidos").isEmpty()? "0.00" : deduccionesElement.getAttribute("TotalImpuestosRetenidos");
	                	TotalOtrasDed = deduccionesElement.getAttribute("TotalOtrasDeducciones").isEmpty()? "0.00" : deduccionesElement.getAttribute("TotalOtrasDeducciones");
	                }
	                n=13;
	                celda.setCellStyle(style);
	                celda = fila.createCell(n++);
	                celda.setCellValue(totalGravado);
	                
	                celda.setCellStyle(style);
	                celda = fila.createCell(n++);
	                celda.setCellValue(TotalExento);
	                
	                celda.setCellStyle(style);
	                celda = fila.createCell(n++);
	                celda.setCellValue(TotalImpuestosR);
	                
	                celda = fila.createCell(n++);
	                celda.setCellStyle(style);
	                celda.setCellValue(TotalOtrasDed);
	                
	                
	                celda.setCellStyle(style);
	                celda = fila.createCell(n++);
                    celda.setCellValue(parent.getAttribute("Fecha"));

	                celda = fila.createCell(n++);
	                celda.setCellValue(parent.getAttribute("MetodoPago"));

	                celda = fila.createCell(n++);	   
	                celda.setCellValue(parent.getAttribute("TipoDeComprobante"));

	                celda = fila.createCell(n++);	   
	                celda.setCellValue(cfdi.getEstatus());
	                
	                   
	                if (cfdi.getFechaCancelacion()!=null){
	                	celda = fila.createCell(n++);	
	                	celda.setCellValue(cfdi.getFechaCancelacion());
	                	CellStyle styleFecha = libro.createCellStyle();
	                	styleFecha.setDataFormat(format.getFormat("YYYY-MM-DDThh:mm:ss"));
		                celda.setCellStyle(styleFecha);
		            }
	                else
	                {
	                	celda = fila.createCell(n++);	
	                	celda.setCellValue("NA");
	                }
	                
	                
	                NodeList DatePg = doc.getElementsByTagName("nomina12:Nomina");
                    Element  DatepgE = (Element) DatePg.item(0);
	                
	                
	                celda = fila.createCell(n++);
	                celda.setCellValue(DatepgE.getAttribute("FechaInicialPago"));
	                
	                hoja.autoSizeColumn(n++);
		               
	                
	                ff++;
		}
		for (int i = 0; i < 17; i++) {
			hoja.autoSizeColumn(i);
        }
		
		

		
        resp.setContentType("APPLICATION/OCTET-STREAM");
	    resp.setHeader("Content-Disposition","inline; filename=" + fecha + ".xls;");  
	    libro.write(resp.getOutputStream());
	}
	
	@RequestMapping(value = "/zipFileNomina/{fecha}") //, method = RequestMethod.GET, produces = "application/json")
	public void zipFileNomina(@PathVariable("fecha") String fecha, HttpServletRequest request, HttpServletResponse resp) throws Exception {
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
			
		List<CfdEmitido> cfdis = comprobanteDao.findByDatesNomina(tenantID, fecha.substring(0, 4), fecha.substring(5));
			
		ZipOutputStream zip = new ZipOutputStream(resp.getOutputStream());
		
		ZipEntry tmp = null;
		
		Path path = null;
		byte []data = null;
		
		String pathXML = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();
		String pathPDF = parametroDao.findByClave("PATH_EXTERNO_PDF_TIMBRADO").getValor();
		
		
		
		String pathS = "";
		
		for (CfdEmitido cfdi : cfdis) {
				pathS = pathXML + "/" + tenantID + "/" + cfdi.getUuid()  + ".xml";
				//pathS = pathXML + "\\" + tenantID + "\\" + cfdi.getUuid()  + ".xml";
				
				log.info(pathS);
				
				if (!(new File(pathS)).exists()) {
					continue;
				}
				
				tmp = new ZipEntry(cfdi.getUuid() + ".xml");
				zip.putNextEntry(tmp);
				data = Files.readAllBytes(Paths.get(pathS));
				zip.write(data);
				zip.closeEntry();
				
				pathS = pathPDF + "/" + tenantID + "/" + cfdi.getUuid()  + ".pdf";
				//pathS = pathPDF + "\\" + tenantID + "\\" + cfdi.getUuid()  + ".pdf";
				
				log.info(pathS);
				
				if (!(new File(pathS)).exists()) {
					continue;
				}
				
				tmp = new ZipEntry(cfdi.getUuid() + ".pdf");
				zip.putNextEntry(tmp);
				data = Files.readAllBytes(Paths.get(pathS));
				zip.write(data);
				zip.closeEntry();
		}
		
		zip.flush();
		zip.close();
		
		
		resp.setContentType("application/zip");
	    resp.setHeader("Content-Disposition","inline; filename=output.zip;");  
		// resp.getOutputStream().write(zip.);
		
	}
	
	@RequestMapping(value = "/xlsFile/{fecha}") //, method = RequestMethod.GET, produces = "application/json")
	public void xlsFile(@PathVariable("fecha") String fecha, HttpServletRequest request, HttpServletResponse resp) throws Exception {
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
			
		List<CfdEmitido> cfdis = comprobanteDao.findByDates(tenantID, fecha.substring(0, 4), fecha.substring(5));

		String pathXML = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();
		
		String pathS = "";

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Workbook libro = new HSSFWorkbook();
        Sheet hoja = libro.createSheet("Reporte");

        int ff = 0;
        Cell celda;
        Row fila;
        fila = hoja.createRow(ff);

        int n = 0;
        celda = fila.createCell(n++);
        celda.setCellValue("Folio Fiscal");
        
        celda = fila.createCell(n++);
        celda.setCellValue("RFC EMISOR");

        celda = fila.createCell(n++);
        celda.setCellValue("Razon social EMISOR");

        celda = fila.createCell(n++);
        celda.setCellValue("RFC RECEPTOR");

        celda = fila.createCell(n++);
        celda.setCellValue("Razon social Receptor");

        celda = fila.createCell(n++);
        celda.setCellValue("SubTotal");

        celda = fila.createCell(n++);
        celda.setCellValue("Descuento");
        
        celda = fila.createCell(n++);
        celda.setCellValue("Total");
        
        celda = fila.createCell(n++);
        celda.setCellValue("IEPS IMPORTE Retenido");
        
        celda = fila.createCell(n++);
        celda.setCellValue("IEPS TasaOcuota Retenido");
        
        celda = fila.createCell(n++);
        celda.setCellValue("IEPS IMPORTE Traslado");
        
        celda = fila.createCell(n++);
        celda.setCellValue("IEPS TasaOcuota Traslado");
        
        celda = fila.createCell(n++);
        celda.setCellValue("IVA Traslado");
        
        celda = fila.createCell(n++);
        celda.setCellValue("IVA Retenido");

        celda = fila.createCell(n++);
        celda.setCellValue("ISR Traslado");
        
        celda = fila.createCell(n++);
        celda.setCellValue("ISR Retenido");
        
        celda = fila.createCell(n++);
        celda.setCellValue("Serie");

        celda = fila.createCell(n++);
        celda.setCellValue("Folio");

        celda = fila.createCell(n++);
        celda.setCellValue("Fecha");

        celda = fila.createCell(n++);
        celda.setCellValue("Metodo Pago");

        celda = fila.createCell(n++);
        celda.setCellValue("TipoComprobante");

        celda = fila.createCell(n++);
        celda.setCellValue("Estado");        
        
        celda = fila.createCell(n++);
        celda.setCellValue("Fecha Cancelación");
        
        ff++;
		
		for (CfdEmitido cfdi : cfdis) {
				pathS = pathXML + "/" + tenantID + "/" + cfdi.getUuid()  + ".xml";
				
				     log.info(pathS);
				     File file = new File(pathS);
				
				     if (!file.exists()) {
					    continue;
			    	}
				
				 	n = 0;

	                fila = hoja.createRow(ff);

	                System.out.println("Procesando: " + file.getName());
	                
	                Document doc = dBuilder.parse(file);

	                NodeList nList00 = doc.getElementsByTagName("cfdi:Emisor");
	                Element emisor = (Element) nList00.item(0);

	                NodeList nList0 = doc.getElementsByTagName("cfdi:Receptor");
	                Element receptor = (Element) nList0.item(0);

	                Element lastNodeImp = null;
	                NodeList afterTraslados = null,afterRetencion = null;
	                NodeList nListImp = doc.getElementsByTagName("cfdi:Impuestos");
	                
	                if(nListImp != null)
                    {
	                	try {
	                		int size =  nListImp.getLength(); 
	                		 //obtiene el ultimo nodo de impuestos[tamaño - 1]
	                		 lastNodeImp = (Element) nListImp.item(size - 1);

	                         //Obtiene rama Traslado de Rama Padre Impuestos[length - 1]
	                        afterTraslados = lastNodeImp.getElementsByTagName("cfdi:Traslado");
	                         
	                	}
	                	catch(ArrayIndexOutOfBoundsException exception) {
	                	    //log.info(exception.getMessage());
	                	}
	                	
	                   
                    }
                
	                if(nListImp != null)
                    {
	                	try {
	                		int size =  nListImp.getLength(); 
	                		 //obtiene el ultimo nodo de impuestos[tamaño - 1]
	                		 lastNodeImp = (Element) nListImp.item(size - 1);

	                         //Obtiene rama Traslado de Rama Padre Impuestos[length - 1]
	                		 afterRetencion = lastNodeImp.getElementsByTagName("cfdi:Retencion");
	                         
	                	}
	                	catch(ArrayIndexOutOfBoundsException exception) {
	                	    //log.info(exception.getMessage()); =  (Element) trasladoIEPS.get(j);
	                	}
	                	
	                   
                    }

	                NodeList nList1 = doc.getElementsByTagName("tfd:TimbreFiscalDigital");
	                Element eElement1 = (Element) nList1.item(0);

	                String uuid = eElement1.getAttribute("UUID");
	                String rfcEmisor = emisor.getAttribute("Rfc");
	                String rfcReceptor = receptor.getAttribute("Rfc");


	                celda = fila.createCell(n++);
	                celda.setCellValue(uuid);

	                celda = fila.createCell(n++);
	                celda.setCellValue(rfcEmisor);

	                celda = fila.createCell(n++);
	                celda.setCellValue(emisor.getAttribute("Nombre"));
	                
	                celda = fila.createCell(n++);
	                celda.setCellValue(rfcReceptor);

	                celda = fila.createCell(n++);
	                celda.setCellValue(receptor.getAttribute("Nombre"));

	                Element parent = doc.getDocumentElement();

	                celda = fila.createCell(n++);
	                celda.setCellValue(parent.getAttribute("SubTotal"));

	                DataFormat format = libro.createDataFormat();

	                CellStyle style = libro.createCellStyle();
	                style.setDataFormat(format.getFormat("#,##0.00"));
	                
	                celda.setCellStyle(style);

	                celda = fila.createCell(n++);
	                celda.setCellValue(Float.parseFloat(parent.getAttribute("Descuento").isEmpty() ? "0" : parent.getAttribute("Descuento")));
	                celda.setCellStyle(style);
	                

	                celda = fila.createCell(n++);
	                celda.setCellValue(parent.getAttribute("Total"));

	          
	                Element eCon = null;
	                boolean banderaISRT = false,banderaIEPS = false,banderaIVA = false,banderaIVAR = false,banderaISRR = false,banderaIEPSRet = false;
	                int filatemporal = fila.getRowNum();
	                
	             
	               fila.setRowNum(filatemporal);
	               
	               int total = 0;
	               boolean istwo = false;
	        		
	                ArrayList<Element> retencionIEPS = new ArrayList<Element>();
	                ArrayList<Element> trasladoIEPS = new ArrayList<Element>();
	               
	                if(afterRetencion != null)
	                {
	                	for(int i =0;i<afterRetencion.getLength();i++){
	                		Element elemento = (Element) afterRetencion.item(i);
		                	  
		                	  if(elemento.getAttribute("Impuesto").equals("003"))
		                	  {
		                		  retencionIEPS.add(elemento);
		                	  }
		                
	                	}
	                }
	            	
	                if(afterTraslados != null)
	                {
	                	for(int i =0;i<afterTraslados.getLength();i++){
	 		            	
		                	  Element elemento = (Element) afterTraslados.item(i);
		                	  
		                	  if(elemento.getAttribute("Impuesto").equals("003"))
		                	  {
		                		  trasladoIEPS.add(elemento);
		                	  }
		                }
	                }
	               
	                
		            if(retencionIEPS.size() > trasladoIEPS.size())
		            {
		            	total = retencionIEPS.size();
		            }
		            else if(trasladoIEPS.size() > retencionIEPS.size())
		            {
		            	total = trasladoIEPS.size();
		            }
		            else if(retencionIEPS.size() == trasladoIEPS.size())
		            {
		            	total = retencionIEPS.size();
		            }
		            
		            
		            if(retencionIEPS != null)
		              banderaIEPSRet = retencionIEPS.size() < 1? false : true;
		         
		            if(trasladoIEPS != null)
		              banderaIEPS = trasladoIEPS.size() < 1? false : true;
		              
		            
		            for(int j = 0;j<total;j++){
                		
                		Element nodo = null;
                		Element nodo1 = null;
                		
                		 try
                		   {
                			 nodo1 =  (Element) trasladoIEPS.get(j);
                		   }
                	  	   catch(IndexOutOfBoundsException e)
                		   {
                		 	 nodo1 = null;
                		 	 
                		   }
                		 
                		 try
              		      {
              		    	 nodo = (Element) retencionIEPS.get(j);
              		      }
              	  	       catch(IndexOutOfBoundsException e)
              		      {
              		 	    nodo = null;
              		      }
                		
                
                			if(!istwo)
                			{
                				istwo = true;
                			} 
                			else
                			{
                				if(hoja.getRow(++ff) != null)
		                	    {
		                		  fila.setRowNum(ff);
		                		}
		                		else
		                		{
		                		 fila = hoja.createRow(ff);
		                		}
                			}
                			

                			if(nodo != null){
                				
                				n = 8;
                				
                				celda = fila.createCell(n++);
	                			celda.setCellValue(nodo.getAttribute("Importe"));
	                			
	                			celda = fila.createCell(n++);
	                			celda.setCellValue(nodo.getAttribute("TasaOCuota"));
	                			
                			}
                			

                            if(nodo1 != null){
                				
                            	n = 10;
                            	
                				celda = fila.createCell(n++);
	                			celda.setCellValue(nodo1.getAttribute("Importe"));
	                			
	                			celda = fila.createCell(n++);
	                			celda.setCellStyle(style);
	                			celda.setCellValue(nodo1.getAttribute("TasaOCuota"));
                			}

                		
                	}
	             
		            
	                //retornamos a la fila inicial 
	                fila.setRowNum(filatemporal);
	              
	                if(!banderaIEPSRet)
	                {
                      n = 8;
        		 	  celda = fila.createCell(n++);
           			  celda.setCellValue("NA");
           			
           			  celda = fila.createCell(n++);
           			  celda.setCellValue("NA");
	                }
	                
	                if(!banderaIEPS)
	                {
                      n = 10;
        		 	  celda = fila.createCell(n++);
           			  celda.setCellValue("NA");
           			
           			  celda = fila.createCell(n++);
           			  celda.setCellValue("NA");
	                }
	                
	                /*
	                 * Iva Traslado
	                 */
	                
	                if(afterTraslados != null)
		            {
		               for (int i = 0; i < afterTraslados.getLength(); i++) {
   	                       
		            	   eCon = (Element) afterTraslados.item(i);
	
		                    if (eCon.getAttribute("Impuesto").toUpperCase().equals("002")) {
		                    	  
		                    	    n= 12;
		                    		celda = fila.createCell(n++);
		        	                celda.setCellStyle(style);
		        	                celda.setCellValue(eCon.getAttribute("Importe"));
		        	                banderaIVA = true;
		                    }
		                    
		                  }
		           }
	               
	               if(!banderaIVA)
	               {
	            	  n = 12;
	            	  celda = fila.createCell(n++);
   	                  celda.setCellValue("NA");
	              }
	               
	              /*
	               * IVA Retenido
	               */
	             
	              if(afterRetencion != null)
	              {
	            	  for (int i = 0; i < afterRetencion.getLength(); i++) {
  	                       
		            	   eCon = (Element) afterRetencion.item(i);
	
		                    if (eCon.getAttribute("Impuesto").toUpperCase().equals("002")) {
		                    	
		                    	    n = 13;
		                    		celda = fila.createCell(n++);
		        	                celda.setCellStyle(style);
		        	                celda.setCellValue(eCon.getAttribute("Importe"));
		        	                banderaIVAR = true;
		                    }
		                    
		                  }
	              }
	              
	              if(!banderaIVAR)
	              {
	            	  n = 13;
	            	  celda = fila.createCell(n++);
   	                  celda.setCellValue("NA");
	              }
	              
	              
	              //ISR traslados
	                
	                if(afterTraslados != null)
		            {
		               for (int i = 0; i < afterTraslados.getLength(); i++) {
 	                       
		            	   eCon = (Element) afterTraslados.item(i);
	
		                    if (eCon.getAttribute("Impuesto").toUpperCase().equals("001")) {
		                    	   
		                    	    n = 14;
		                    		celda = fila.createCell(n++);
		        	                celda.setCellStyle(style);
		        	                celda.setCellValue(eCon.getAttribute("Importe"));
		        	                banderaISRT = true;
		                    }
		                    
		               }
		           }
	               
	               if(!banderaISRT)
	               {
	            	   n = 14;
	            	  celda = fila.createCell(n++);
 	                  celda.setCellValue("NA");
	              }
	              
	              /*
	               * ISR Retenido 001
	               */
	             
	              if(afterRetencion != null)
	              {
	            	  for (int i = 0; i < afterRetencion.getLength(); i++) {
  	                       
		            	   eCon = (Element) afterRetencion.item(i);
	
		                    if (eCon.getAttribute("Impuesto").toUpperCase().equals("001")) {
		                    	
		                    	    n = 15;
		                    		celda = fila.createCell(n++);
		        	                celda.setCellStyle(style);
		        	                celda.setCellValue(eCon.getAttribute("Importe"));
		        	                banderaISRR = true;
		                    }
		                    
		                  }
	              }
	              
	              if(!banderaISRR)
	              {
	            	  n = 15;
	            	 
	            	  celda = fila.createCell(n++);
   	                  celda.setCellStyle(style);
   	                  celda.setCellValue("NA");
	              }
	              
	              
	                
	                celda = fila.createCell(n++);
	                celda.setCellValue(parent.getAttribute("Serie"));

	                celda = fila.createCell(n++);
	                celda.setCellValue(parent.getAttribute("Folio"));

	                celda = fila.createCell(n++);
	                celda.setCellValue(parent.getAttribute("Fecha"));
	                
	                celda = fila.createCell(n++);
	                celda.setCellValue(parent.getAttribute("MetodoPago"));

	                celda = fila.createCell(n++);	   
	                celda.setCellValue(parent.getAttribute("TipoDeComprobante"));
	                
	                celda = fila.createCell(n++);	   
	                celda.setCellValue(cfdi.getEstatus());
	                
	                celda = fila.createCell(n++);	   
	                if (cfdi.getFechaCancelacion()!=null){
	                	celda.setCellValue(cfdi.getFechaCancelacion());
                 	    CellStyle styleFecha = libro.createCellStyle();
 	                	styleFecha.setDataFormat(format.getFormat("YYYY-MM-DDThh:mm:ss"));
		                celda.setCellStyle(styleFecha);
	                }
	                
	           ff++;
		}
		for (int i = 0; i < 19; i++) {
			hoja.autoSizeColumn(i);
        }
		
		
        resp.setContentType("APPLICATION/OCTET-STREAM");
	    resp.setHeader("Content-Disposition","inline; filename=" + fecha + ".xls;");  
	    libro.write(resp.getOutputStream());
	}

	@RequestMapping(value = "/getEmitidos/{rfc}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<CfdEmitido> getEmitidos(@PathVariable("rfc") String rfc, HttpServletRequest request) throws Exception {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		Date dateActual = new Date();
		
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		
		List<CfdEmitido> cfdis = comprobanteDao.findByDates(rfc, strAnioActual, strMesActual);
		
		return cfdis;
	}
	
	@RequestMapping(value = "/folio/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Integer getFolioSinSerie(HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		return comprobanteDao.getFolio("", tenantID);
	}
	
	@RequestMapping(value = "/getPasss/{rfc}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getPasss(@PathVariable("rfc") String rfc, HttpServletRequest request) throws Exception {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		Usuario usr = usuarioDao.findByClave("admin", rfc);
		
		return usr.getPassword();
	}
		
	@RequestMapping(value = "/folio/{serie}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Integer getFolio(@PathVariable("serie") String serie, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		return comprobanteDao.getFolio(serie, tenantID);
	}
	
	@RequestMapping(value = "/folioRet/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Integer getFolioRet(HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		return comprobanteDao.getFolioRet(tenantID);
	}

	@RequestMapping(value = "/cancelar/{id}/{fecha}", method = RequestMethod.GET)
	public @ResponseBody String cancelar(@PathVariable("id") Long id, @PathVariable("fecha") String fecha, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		try {
			CfdEmitido cfd = comprobanteDao.findById(id, fecha);
			if (cfd == null) {
				return "500 - Folio no encontrado";
			}
			String uuid = cfd.getUuid();
			emisorDao.setTenantId(tenantID);
			DatosEmisor emisor = emisorDao.findEmisor(tenantID);
			String rfc = emisor.getRfc();
			if (rfc.contains("&")){
				rfc = rfc.replace("&", "&amp;");
			}
			csdDao.setTenantId(tenantID);
			CertificadoSelloDigital csd = csdDao.findCurrent(tenantID);
			String llavePrivadaPem = csd.getArchivoKey();
			String certificadoPem = csd.getCertificado();

			CancelacionUtil cancelacion = new CancelacionUtil();
			RespuestaCancelacion respuesta = null;
			String ambiente = "PRUEBAS";
			try {
				if (emisor.isProductivo()) {
					ambiente = "PRODUCCION";
				}
				respuesta = cancelacion.cancelarFolio(ambiente, rfc, uuid, llavePrivadaPem, certificadoPem);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String codString = respuesta.getCodEstatus().trim().replaceAll(" -", "");
			Integer codEstatus = Integer.parseInt(codString);
			if (codEstatus.equals(200)) {
				Integer codUuid = Integer.parseInt(respuesta.getEstatusUUIDs(0));
				switch (codUuid) {
				case 201:
					cfd.setEstatus("cancelado");
					cfd.setFechaCancelacion(new Date());
					comprobanteDao.cancelar(cfd, fecha);	
					String filePath ="/mnt/portal_remoto/pdf/" + tenantID + "/" + cfd.getUuid() + ".pdf";
					agregarCanceladoPDF(filePath);
					return "201 - Folio cancelado";
				case 202:
					cfd.setEstatus("cancelado");
					comprobanteDao.cancelar(cfd, fecha);
					return "202 - Folio previamente cancelado";
				case 203:
					return "203 - Folio no corresponde al emisor";
				case 204:
					return "204 - Folio no aplicable para cancelación";
				case 205:
					return "205 - Folio no existe/Intente nuevamente más tarde";

				default:
					return "500 - Intente de nuevo más tarde";
				}
			} else if(!codEstatus.equals(500)) {
				switch (codEstatus) {
				case 301:
					return "301 - Xml malformado";
				case 302:
					return "302 - Sello malformado o inválido";
				case 303:
					return "303 - Sello no corresponde al emisor o caduco";
				case 304:
					return "304 - Certificado revocado o caduco";
				case 305:
					return "305 - Fecha de emisión no vigente con el CSD";
				case 306:
					return "306 - El certificado no es de tipo CSD";
				case 307:
					return "307 - CFDI contiene un timbre previo";
				case 308:
					return "308 - Certificado no expedido por el SAT";
				} 
			} else {
				return codEstatus + " - " + respuesta.getCodMensaje();
			}

		} catch (LlavePrivadaException e) {
			e.printStackTrace();
			log.warn("Error al procesar la llave privada");
			return "500 - Error al procesar la llave privada";
		} catch (CertificateException e) {
			e.printStackTrace();
			log.warn("Error al procesar el certificado");
			return "500 - Error al procesar el certificado";
		} catch (InvalidKeySpecException e) {
			log.warn("Llave invalida");
			e.printStackTrace();
			return "500 - Error al procesar la llave privada";
		} catch (TransformerException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (IOException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (SAXException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (MarshalException e) {
			log.warn("Error en el proceso de firmado");
			e.printStackTrace();
			return "500 - Error en el proceso de firmado";
		} catch (XMLSignatureException e) {
			log.warn("Error en el proceso de firmado");
			e.printStackTrace();
			return "500 - Error en el proceso de firmado";
		}

		return "500 - Intente de nuevo más tarde";
	}
	
	
	@RequestMapping(value = "/cancelarNuevoEsquema/{id}/{fecha}/{rfcReceptor}/{total}/{uuid}", method = RequestMethod.GET)
	public @ResponseBody String cancelarNuevoEsquema(@PathVariable("id") Long id, @PathVariable("fecha") String fecha, @PathVariable("rfcReceptor") String rfcReceptor, @PathVariable("total") String total, @PathVariable("uuid") String uuid, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		final String COMPROBANTE_OBTENIDO_OK = "S Comprobante obtenido satisfactoriamente.";
		final String CANCELADO_SIN_ACEPTACION = "Cancelado sin aceptación";
		final String CANCELADO_CON_ACEPTACION = "Cancelado con aceptación";
		final String CANCELADO = "cancelado";
		final String EN_PROCESO = "En proceso";
		final String PLAZO_VENCIDO = "Plazo vencido";
		final String VIGENTE = "Vigente";
		final String RECHAZADA_POR_RECEPTOR = "La solicitud de Cancelación fue rechazada por el Receptor";
		final String YA_RECHAZADA = "La solicitud de cancelación para este CFDI ya fue rechazada anteriormente, póngase en contacto con el Receptor";
		final String INTENTE_MAS_TARDE_500 = "500 - Intente de nuevo más tarde";
		final String ERROR_500 = "500";
		final String NO_ENCONTRADO = "No Encontrado";
		final String NO_CANCELABLE = "No Cancelable";
		final String str500FolioNoEncontrado = "500 - Folio no encontrado";
		final String strYaCancelado = "Este CFDI ya fue cancelado con anterioridad";
		final String strSinEstatusCancelacion = "En espera de confirmación de cancelación por parte del SAT, intente cancelar más tarde el CFDI para confirmar el estatus.";
		
		try {
			CfdEmitido cfd = comprobanteDao.findById(id, fecha);
			if (cfd == null) {
				return str500FolioNoEncontrado;
			}
			
			emisorDao.setTenantId(tenantID);
			DatosEmisor emisor = emisorDao.findEmisor(tenantID);
			String rfc = emisor.getRfc();
			if (rfc.contains("&")){
				rfc = rfc.replace("&", "&amp;");
			}
			
			if (cfd.getEstatus().equals(CANCELADO)){
				return strYaCancelado;
			}
			
			csdDao.setTenantId(tenantID);
			CertificadoSelloDigital csd = csdDao.findCurrent(tenantID);
						
			CancelacionUtil cancelacion = new CancelacionUtil();
			RespuestaCliente respuesta = null;
			String ambiente = "PRUEBAS";
			try {
				if (emisor.isProductivo()) {
					ambiente = "PRODUCCION";
				}
				respuesta = cancelacion.cancelarFolioNuevoEsquema(ambiente, rfc, csd.getNoSerie(), rfcReceptor, uuid, total, cfd.getEmail(), emisor.getEmail());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if ((respuesta != null) && (respuesta.getCodigo() != null)){
				String strEstatus= "",strXmlRel = "";
				String codString = respuesta.getCodigo().trim().replaceAll(" -", "");
				if (codString.equals(COMPROBANTE_OBTENIDO_OK)){
					if (respuesta.getResponseConsulta() != null){
						String strRespuesta =  obtieneEstatusCancelacion(respuesta.getResponseConsulta());
						if (strRespuesta.equals(CANCELADO_SIN_ACEPTACION)){
							cfd.setEstatus(CANCELADO);
							cfd.setFechaCancelacion(new Date());
							comprobanteDao.cancelar(cfd, fecha);	
							String filePath ="/mnt/portal_remoto/pdf/" + tenantID + "/" + cfd.getUuid() + ".pdf";
							//String filePath ="/home/cfdi33/pdf/" + tenantID + "/" + cfd.getUuid() + ".pdf";
							agregarCanceladoPDFNuevoEsquema(filePath);
							return strRespuesta;
						}
						if (strRespuesta.equals(EN_PROCESO) && respuesta.getXmlRelacionados() == null ){
							String strEsCancelable = obtieneEsCancelable(respuesta.getResponseConsulta());
							cfd.setEstatus(EN_PROCESO);
							comprobanteDao.enProceso(cfd, fecha);	
							
							CancelacionScript cancelacionScript = new CancelacionScript();
							cancelacionScript.setTenantId(tenantID);
							cancelacionScript.setUuid(cfd.getUuid());
							cancelacionScript.setEstatus(EN_PROCESO);
							cancelacionScript.setFechaRegistro(cfd.getFechaRegistro());
							cancelacionScriptDao.add(cancelacionScript);							
							
							return strRespuesta + " "+ strEsCancelable;
						}
						if (strRespuesta.equals(PLAZO_VENCIDO)){
							cfd.setEstatus(CANCELADO);
							cfd.setFechaCancelacion(new Date());
							comprobanteDao.cancelar(cfd, fecha);
							String filePath ="/mnt/portal_remoto/pdf/" + tenantID + "/" + cfd.getUuid() + ".pdf";
							//String filePath ="/home/cfdi33/pdf/" + tenantID + "/" + cfd.getUuid() + ".pdf";
							agregarCanceladoPDFNuevoEsquema(filePath);
							return respuesta.getMensaje() + " " + strRespuesta;
						}
						if ((respuesta.getMensaje().equals(VIGENTE))&&(strRespuesta.equals(""))  && respuesta.getXmlRelacionados() == null ){
							return RECHAZADA_POR_RECEPTOR;
						}
						if ((respuesta.getMensaje().equals(VIGENTE))&&(obtieneEstado(respuesta.getResponseConsulta()).equals(VIGENTE)) &&  respuesta.getXmlRelacionados() == null){
							return YA_RECHAZADA;
						}
						if (strRespuesta.equals(CANCELADO_CON_ACEPTACION) && (respuesta.getMensaje().equalsIgnoreCase(CANCELADO))){
							cfd.setEstatus(CANCELADO);
							cfd.setFechaCancelacion(new Date());
							comprobanteDao.cancelar(cfd, fecha);	
							return strRespuesta;
						}
						if (strRespuesta.equals(CANCELADO) &&  (respuesta.getMensaje().equals(EN_PROCESO) )){
							cfd.setEstatus(EN_PROCESO);
							cfd.setFechaCancelacion(new Date());
							comprobanteDao.cancelar(cfd, fecha);	
							return strRespuesta;
						}
						if (strRespuesta.equals(EN_PROCESO) && respuesta.getXmlRelacionados() != null  ){
							
							cfd.setEstatus("En proceso");
				        	
				        	for(int i = 0;i<respuesta.getXmlRelacionados().length;i++)
					    	 {
					    		 CfdEmitido cfdi = comprobanteDao.findByUuidCancelacion(respuesta.getXmlRelacionados(i).getUuid());
					    		 if(cfdi != null){
						    		 String f = DateFormat.getDateInstance().format(cfdi.getFechaRegistro());
						    		 String date[] = f.split("/");
						    		 if(i < respuesta.getXmlRelacionados().length  - 1)
						    		   {
						    			 strXmlRel += "?CFDI33?descargar?xml?"+cfdi.getUuid()+"?"+date[2]+"-"+date[1]+"-"+date[0]+",";
						    		   }
						    		 else
						    		   {
						    			 strXmlRel += "?CFDI33?descargar?xml?"+cfdi.getUuid()+"?"+date[2]+"-"+date[1]+"-"+date[0];
						    		    }
					    		 }
					    	 }
						    return "c=["+respuesta.getCodigo() +"] - m=[No Cancelable] - rel=["+strXmlRel+"]";
						}
						if ((respuesta.getMensaje().equals(VIGENTE))&&(strRespuesta != "") && respuesta.getXmlRelacionados() != null){
							
					        if(respuesta.getXmlRelacionados() != null){
					        	
					        	cfd.setEstatus("En proceso");
					        	
					        	for(int i = 0;i<respuesta.getXmlRelacionados().length;i++)
						    	 {
						    		 CfdEmitido cfdi = comprobanteDao.findByUuidCancelacion(respuesta.getXmlRelacionados(i).getUuid());
						    		 if(cfdi != null){
							    		 String f = DateFormat.getDateInstance().format(cfdi.getFechaRegistro());
							    		 String date[] = f.split("/");
							    		 if(i < respuesta.getXmlRelacionados().length  - 1)
							    		   {
							    			 strXmlRel += "?CFDI33?descargar?xml?"+cfdi.getUuid()+"?"+date[2]+"-"+date[1]+"-"+date[0]+",";
							    		   }
							    		 else
							    		   {
							    			 strXmlRel += "?CFDI33?descargar?xml?"+cfdi.getUuid()+"?"+date[2]+"-"+date[1]+"-"+date[0];
							    		    }
						    		 }
						    	 }
						    }
							
						    return "c=["+respuesta.getCodigo() +"] - m=[No Cancelable] - rel=["+strXmlRel+"]";
						}
						
						if (strRespuesta.equals("SinEstatusCancelacion")){
							CancelacionScript cancelacionScript = new CancelacionScript();
							cancelacionScript.setTenantId(tenantID);
							cancelacionScript.setUuid(cfd.getUuid());
							cancelacionScript.setEstatus(EN_PROCESO);
							cancelacionScript.setFechaRegistro(cfd.getFechaRegistro());
							cancelacionScriptDao.add(cancelacionScript);
							
							return strSinEstatusCancelacion;
						}
						
					}
					else{
						return INTENTE_MAS_TARDE_500;
					}
				}
				if (codString.equals(ERROR_500)){
					return respuesta.getCodigo() +" - "+  respuesta.getMensaje();
				}
				if (respuesta.getMensaje().equals(NO_ENCONTRADO)){
					return respuesta.getCodigo();
				}
				 
			}
			
		}catch (CertificateException e) {
			e.printStackTrace();
			log.warn("Error al procesar el certificado");
			return "500 - Error al procesar el certificado";
		} catch (InvalidKeySpecException e) {
			log.warn("Llave invalida");
			e.printStackTrace();
			return "500 - Error al procesar la llave privada";
		} catch (TransformerException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (IOException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (SAXException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (MarshalException e) {
			log.warn("Error en el proceso de firmado");
			e.printStackTrace();
			return "500 - Error en el proceso de firmado";
		} catch (XMLSignatureException e) {
			log.warn("Error en el proceso de firmado");
			e.printStackTrace();
			return "500 - Error en el proceso de firmado";
		}

		return INTENTE_MAS_TARDE_500;
	}
	
	@RequestMapping(value = "/cancelarRetenciones/{id}", method = RequestMethod.GET)
	public @ResponseBody String cancelarRetenciones(@PathVariable("id") Long id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		try {
			RetencionesEmitido ret = retencionesDao.findById(id);
			if (ret == null) {
				return "500 - Folio no encontrado";
			}
			String uuid = ret.getUuid();
			emisorDao.setTenantId(tenantID);
			DatosEmisor emisor = emisorDao.findEmisor(tenantID);
			String rfc = emisor.getRfc();
			csdDao.setTenantId(tenantID);
			CertificadoSelloDigital csd = csdDao.findCurrent(tenantID);
			String llavePrivadaPem = csd.getArchivoKey();
			String certificadoPem = csd.getCertificado();

			CancelacionUtil cancelacion = new CancelacionUtil();
			RespuestaCancelacion respuesta = null;
			String ambiente = "PRUEBAS";
			try {
				if (emisor.isProductivo()) {
					ambiente = "PRODUCCION";
				}
				respuesta = cancelacion.cancelarFolioRetenciones(ambiente, rfc, uuid, llavePrivadaPem, certificadoPem);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String codString = respuesta.getCodEstatus().trim().replaceAll(" -", "");
			Integer codEstatus = Integer.parseInt(codString);
			if (codEstatus.equals(200)) {
				Integer codUuid = Integer.parseInt(respuesta.getEstatusUUIDs(0));
				switch (codUuid) {
				case 1201:
					ret.setEstatus("cancelado");
					ret.setFechaCancelacion(new Date());
					retencionesDao.cancelar(ret);				
					String filePath ="/mnt/portal_remoto/retenciones/pdf/" + tenantID + "/" + ret.getUuid() + ".pdf";
					
					agregarCanceladoPDF(filePath);
					return "1201 - Folio cancelado";
				case 1202:
					ret.setEstatus("cancelado");
					retencionesDao.cancelar(ret);
					return "1202 - Folio previamente cancelado";
				case 1203:
					return "1203 - Folio no corresponde al emisor";
				case 1205:
					return "1205 - Folio no existe/Intente nuevamente más tarde";

				default:
					return "500 - Intente de nuevo más tarde";
				}
			} else if(!codEstatus.equals(500)) {
				switch (codEstatus) {
				case 1300:
					return "1300 - Autenticación no válida";
				case 1301:
					return "1301 - Xml malformado";
				case 1302:
					return "1302 - Estructura de folios no válida";
				case 1303:
					return "1303 - Estructura de RFC no válida";
				case 1304:
					return "1304 - Estructura de fecha no válida";
				case 1305:
					return "1305 - Certificado no corresponde con el emisor";
				case 1306:
					return "1306 - Certificado no vigente";
				case 1307:
					return "1307 - Uso de FIEL no permitido";
				case 1308:
					return "1308 - Certificado revocado o caduco";
				case 1309:
					return "1309 - Firma mal formada o inválida";
				} 
			} else {
				return codEstatus + " - " + respuesta.getCodMensaje();
			}

		} catch (LlavePrivadaException e) {
			e.printStackTrace();
			log.warn("Error al procesar la llave privada");
			return "500 - Error al procesar la llave privada";
		} catch (CertificateException e) {
			e.printStackTrace();
			log.warn("Error al procesar el certificado");
			return "500 - Error al procesar el certificado";
		} catch (InvalidKeySpecException e) {
			log.warn("Llave invalida");
			e.printStackTrace();
			return "500 - Error al procesar la llave privada";
		} catch (TransformerException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (IOException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (SAXException e) {
			log.warn("No se generó correctamente el xml de cancelacion");
			e.printStackTrace();
			return "500 - No se generó correctamente el xml de cancelacion";
		} catch (MarshalException e) {
			log.warn("Error en el proceso de firmado");
			e.printStackTrace();
			return "500 - Error en el proceso de firmado";
		} catch (XMLSignatureException e) {
			log.warn("Error en el proceso de firmado");
			e.printStackTrace();
			return "500 - Error en el proceso de firmado";
		}

		return "500 - Intente de nuevo más tarde";
	}
	
	@RequestMapping(value="/enviarEmail/{uuid}/{fecha}", method=RequestMethod.POST)
	public String enviarEmail(@Valid @ModelAttribute("email") Email email, @PathVariable String uuid, @PathVariable String fecha, BindingResult result, 
			Model model, HttpServletRequest request, HttpServletResponse response){
		functionEnviarMail(email, uuid, fecha, result, model, request, response);
		return "redirect:/comprobante/listar";
	}
	
	@RequestMapping(value="/listarCfdi/{anio}/{mes}", method=RequestMethod.POST, produces = "application/json")
    public @ResponseBody List<CfdEmitido> listarCfdi(@PathVariable("anio") String anio,@PathVariable("mes") String mes, HttpServletRequest request) {
		  
		 final String tenantID = (String)request.getSession().getAttribute("tenantId");
		 List<CfdEmitido> cfds = comprobanteDao.findByDates(tenantID, anio, mes);
		
		
		 return cfds;		 
    }
	
	@RequestMapping(value="/enviarEmailNomina/{uuid}/{fecha}", method=RequestMethod.POST)
	public String enviarEmailNomina(@Valid @ModelAttribute("email") Email email, @PathVariable String uuid, @PathVariable String fecha, BindingResult result, 
			Model model, HttpServletRequest request, HttpServletResponse response){
		functionEnviarMail(email, uuid, fecha, result, model, request, response);
		return "redirect:/nominas/listar";
	}

	
	public void functionEnviarMail(@Valid @ModelAttribute("email") Email email, @PathVariable String uuid, @PathVariable String fecha, BindingResult result, 
			Model model, HttpServletRequest request, HttpServletResponse response) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.expidetufactura.com.mx");
		props.put("mail.smtp.port", 25);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("portal@xpd.mx", "P0rt4l_XPD$-$2015");
			}
		});
		
		try {
			
			Message message = new MimeMessage(session);
			// Rellenar los atributos y el contenido
			InternetAddress [] from = new InternetAddress[1];
			InternetAddress [] replyTo = new InternetAddress[1];
			from[0] = new InternetAddress( email.getEmailEmisor() );
			replyTo[0] = new InternetAddress( email.getEmailReplyTo() );
			message.setFrom(new InternetAddress( email.getEmailEmisor() ));
			
			message.setReplyTo(replyTo);
			
			String[] parts = email.getEmailReceptor().split(";");
			InternetAddress [] arregloDestinatarios = new InternetAddress[parts.length];
			for(int i = 0; i<parts.length;i++){
				arregloDestinatarios[i] = new InternetAddress(parts[i]);
			}
			
			message.setRecipients(Message.RecipientType.TO,	arregloDestinatarios);
			message.setSubject(email.getAsunto());
			Multipart mp = new MimeMultipart();
			/*String banner = "<html> <head> <title>:: Expidetufactura.com.mx ::</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">" +
                "</head> <body bgcolor=\"#FFFFFF\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">" +
                "<table id=\"Table_01\" width=\"750\" height=\"244\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
                "<tr><td width=\"750\"><img src=\"http://www.expidetufactura.com.mx/pub/membrete/images/cabecera.gif\" alt=\"\" width=\"750\" height=\"68\" border=\"0\" usemap=\"#Map\"></td>" +
                "</tr><tr><td width=\"750\"><p>%s</p><p>&nbsp;</p></td></tr><tr>" +
                "<td width=\"750\"><img src=\"http://www.expidetufactura.com.mx/pub/membrete/images/m_gustavo_mariscal.gif\" alt=\"\" width=\"750\" height=\"135\" border=\"0\" usemap=\"#Map2\">"+
                "<map name=\"Map2\"><area shape=\"rect\" coords=\"215,104,422,139\" href=\"http://www.xpd.mx\" target=\"_blank\">"+
                "</map></td></tr></table><map name=\"Map\">" +
                "<area shape=\"rect\" coords=\"477,1,716,54\" href=\"http://www.xpd.mx\" target=\"_blank\">" +
                "</map></body></html>";*/
			String banner = "<html> <head> <title>:: Expidetufactura.com.mx ::</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">" +
	                "</head> <body bgcolor=\"#FFFFFF\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">" +
	                "<table id=\"Table_01\" width=\"750\" height=\"244\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">"+
	                "<tr><td width=\"750\"><img src=\"http://www.expidetufactura.com.mx/pub/membrete/images/cabecera.gif\" alt=\"\" width=\"750\" height=\"68\" border=\"0\" usemap=\"#Map\"></td>" +
	                "</tr><tr><td width=\"750\"><p>%s</p><p>&nbsp;</p></td></tr><tr>" +
	                "<td width=\"750\"><img src=\"%s\" alt=\"\" width=\"750\" height=\"135\" border=\"0\" usemap=\"#Map2\">"+
	                "<map name=\"Map2\"><area shape=\"rect\" coords=\"215,104,422,139\" href=\"http://www.xpd.mx\" target=\"_blank\">"+
	                "</map></td></tr></table><map name=\"Map\">" +
	                "<area shape=\"rect\" coords=\"477,1,716,54\" href=\"http://www.xpd.mx\" target=\"_blank\">" +
	                "</map></body></html>";
			// Texto del mensaje
			BodyPart texto = new MimeBodyPart();
			String mensaje = email.getTextoEnviar();
			//TODO: Checar cual sera el nombre del membrete que tiene que jalar y si se jalara de la ruta
			//http://www.expidetufactura.com.mx/pub/membrete/images/*
			/*String rutaBanner = parametroDao.findByClave("PATH_BANNERS").getValor();
			rutaBanner += tenant + ".gif";
			log.info("la ruta que trae es : " + rutaBanner);
			banner    = String.format(banner, mensaje, rutaBanner);*/
			//banner    = String.format(banner, mensaje, "http://www.expidetufactura.com.mx/pub/membrete/banner_xpd_900pxs.jpg");
			banner    = mensaje;
			texto.setContent(banner, "text/html");
			
			mp.addBodyPart(texto);
			String rfc = (String)request.getSession().getAttribute("rfc");
			
			String rutaXML = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor() + File.separatorChar + rfc.toUpperCase() + File.separatorChar; 
			String rutaPDF = rutaPDF = parametroDao.findByClave("PATH_EXTERNO_PDF_TIMBRADO").getValor() + File.separatorChar + rfc.toUpperCase() + File.separatorChar; 
	
				
			
			
			rutaXML+= uuid + ".xml";
			
			rutaPDF += uuid + ".pdf";
			// Adjunta el xml
			MimeBodyPart xml = new MimeBodyPart();
			MimeBodyPart pdf = new MimeBodyPart();
			xml.attachFile(rutaXML); 
			pdf.attachFile(rutaPDF);
			mp.addBodyPart(xml);
			mp.addBodyPart(pdf);
			message.setContent(mp);
			message.saveChanges();
			// Enviar el mensaje
			Transport.send(message);

			CfdEmitido cfdi = comprobanteDao.findByUuid(uuid, tenantID, fecha);
			cfdi.setEnviado(true);
			comprobanteDao.actualizaEnviado(cfdi, fecha);
		} catch (Exception e) {
			log.info("cacho una excepcion : " +  e.getMessage());
			e.printStackTrace();
			log.debug("Error enviando correo electronico = "+e.getMessage());
			//e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/listarTablaPagos",method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CfdEmitido> listaTablePagos(HttpServletRequest request)
    {
    	Date dateActual = new Date();
        final String tenantID = (String)request.getSession().getAttribute("tenantId");

		
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
			
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		
		List<CfdEmitido> cfds = comprobanteDao.findByDates(tenantID, strAnioActual, strMesActual);
        return cfds;
    }
	
	
	@RequestMapping(value = "/foliosPorMes/{year}", method = RequestMethod.GET)
	public @ResponseBody Object[] foliosPorMes(@PathVariable("year") Integer year, HttpServletRequest request) {
		if (year == null || year.equals("")) {
			Calendar cal = Calendar.getInstance();
			year = cal.get(Calendar.YEAR);
		}
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		List<MapCfdGrafica> cfdsEmitidos = comprobanteDao.findByYear(year, "emitido", tenantID);
		List<MapCfdGrafica> cfdsCancelados = comprobanteDao.findByYear(year, "cancelado", tenantID);
		
		String meses[] = this.getMesesOrden(0);
		int numeroEmitidos[] = separarPorMes(cfdsEmitidos);
		int numeroCancelados[] = separarPorMes(cfdsCancelados);
 
		
		return new Object[]{meses, numeroEmitidos, numeroCancelados};
//		return numeroFolios;
	}

	private String[] getMesesOrden(int mes){
		int i = mes;
		List<String> meses = new ArrayList<String>();
		do {
			switch (i) {
			case 0:
				meses.add("Enero");
				break;
			case 1:
				meses.add("Feb");
				break;
			case 2:
				meses.add("Marzo");
				break;
			case 3:
				meses.add("Abril");
				break;
			case 4:
				meses.add("Mayo");
				break;
			case 5:
				meses.add("Junio");
				break;
			case 6:
				meses.add("Julio");
				break;
			case 7:
				meses.add("Agosto");
				break;
			case 8:
				meses.add("Sept");
				break;
			case 9:
				meses.add("Oct");
				break;
			case 10:
				meses.add("Nov");
				break;
			case 11:
				meses.add("Dic");
				break;
			default:
				meses.add("Mes " + i);
				break;
			}
			i++;
			if (i > 11)
				i = 0;
		} while (i != mes);
		return meses.toArray(new String[meses.size()]);
	}

	private int[] separarPorMes(List<MapCfdGrafica> cfds) {
		int numeroFolios[] = new int[12];
		for (MapCfdGrafica cfd : cfds) {
			switch (cfd.getMes()) { 
			case 1:
				numeroFolios[0] = cfd.getSuma(); //Enero
				break;
			case 2:
				numeroFolios[1] = cfd.getSuma();
				break;
			case 3:
				numeroFolios[2] = cfd.getSuma();
				break;
			case 4:
				numeroFolios[3] = cfd.getSuma();
				break;
			case 5:
				numeroFolios[4] = cfd.getSuma();
				break;
			case 6:
				numeroFolios[5] = cfd.getSuma();
				break;
			case 7:
				numeroFolios[6] = cfd.getSuma();
				break;
			case 8:
				numeroFolios[7] = cfd.getSuma();
				break;
			case 9:
				numeroFolios[8] = cfd.getSuma();
				break;
			case 10:
				numeroFolios[9] = cfd.getSuma();
				break;
			case 11:
				numeroFolios[10] = cfd.getSuma();
				break;
			case 12:
				numeroFolios[11] = cfd.getSuma(); //Diciembre
				break;
			default:
				log.warn("Error en la lectura de mes del cfd");
				break;
			}
		}
		return numeroFolios;
	}
	
	  private  void agregarCanceladoPDF(String pathFile)  {
		    try {
		      PdfReader pdfReader = new PdfReader(pathFile);
		      
		      PdfStamper pdfStamper = new PdfStamper(pdfReader,
		            new FileOutputStream(pathFile + "2"));

		      Image image = Image.getInstance("/home/cfdi33/pdf/cancelada.png");

		      for(int i=1; i<= pdfReader.getNumberOfPages(); i++){

		          PdfContentByte content = pdfStamper.getOverContent(i);
		          
		          image.setAbsolutePosition(150f, 300f);
		          
		          content.addImage(image);
		          
		      }
		      pdfStamper.close();
		      pdfReader.close();
		      File file = new File(pathFile + "2");
		      file.renameTo(new File(pathFile));
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (DocumentException e) {
		      e.printStackTrace();
		    }
		  }
	  
	  private  void agregarCanceladoPDFNuevoEsquema(String pathFile)  {
		    try {
		      PdfReader pdfReader = new PdfReader(pathFile);
		      
		      PdfStamper pdfStamper = new PdfStamper(pdfReader,
		            new FileOutputStream(pathFile + "2"));

		      Image image = Image.getInstance("/home/cfdi33/pdf/cancelado.png");

		      for(int i=1; i<= pdfReader.getNumberOfPages(); i++){

		          PdfContentByte content = pdfStamper.getOverContent(i);
		          
		          image.setAbsolutePosition(150f, 300f);
		          
		          content.addImage(image);
		          
		      }
		      pdfStamper.close();
		      pdfReader.close();
		      File file = new File(pathFile + "2");
		      file.renameTo(new File(pathFile));
		    } catch (IOException e) {
		      e.printStackTrace();
		    } catch (DocumentException e) {
		      e.printStackTrace();
		    }
		  }
	  
	  String obtieneEstatusCancelacion(String strRespuesta){
		  String strRes = "";
		  int intInicio, intFin = 0;
		  
		  if (strRespuesta.indexOf("<a:EstatusCancelacion/>") > 0){
			  strRes = "SinEstatusCancelacion";
		  }
		  else{
			  intInicio = strRespuesta.indexOf("<a:EstatusCancelacion>") + 22;
			  intFin = strRespuesta.indexOf("</a:EstatusCancelacion>");
			  strRes = strRespuesta.substring(intInicio, intFin); 
		  }
		  
		  
		  return strRes;
	  }
	  
	  String obtieneEsCancelable(String strRespuesta){
		  String strRes = "";
		  int intInicio, intFin = 0;
		  intInicio = strRespuesta.indexOf("<a:EsCancelable>") + 16;
		  intFin = strRespuesta.indexOf("</a:EsCancelable>");
		  strRes = strRespuesta.substring(intInicio, intFin);
		  
		  return strRes;
	  }
	  
	  String obtieneEstado(String strRespuesta){
		  String strRes = "";
		  int intInicio, intFin = 0;
		  intInicio = strRespuesta.indexOf("<a:Estado>") + 10;
		  intFin = strRespuesta.indexOf("</a:Estado>");
		  strRes = strRespuesta.substring(intInicio, intFin);
		  
		  return strRes;
	  }

}