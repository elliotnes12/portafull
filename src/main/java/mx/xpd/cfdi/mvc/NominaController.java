package mx.xpd.cfdi.mvc;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import mx.xpd.cfdi.domain.Addenda;
import mx.xpd.cfdi.domain.CatalogosNomina;
import mx.xpd.cfdi.domain.CatalogosNomina12;
import mx.xpd.cfdi.domain.CertificadoSelloDigital;
import mx.xpd.cfdi.domain.CfdEmitido;
import mx.xpd.cfdi.domain.ConfiguracionCFDI;
import mx.xpd.cfdi.domain.ConfiguracionPlantilla;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.Email;
import mx.xpd.cfdi.domain.Empleado;
import mx.xpd.cfdi.domain.LugarExpedicion;
import mx.xpd.cfdi.domain.cfdi.Complemento;
import mx.xpd.cfdi.domain.cfdi.Comprobante;
import mx.xpd.cfdi.domain.cfdi.Concepto;
import mx.xpd.cfdi.domain.cfdi.Conceptos;
import mx.xpd.cfdi.domain.cfdi.Emisor;
import mx.xpd.cfdi.domain.cfdi.Impuesto;
import mx.xpd.cfdi.domain.cfdi.Impuestos;
import mx.xpd.cfdi.domain.cfdi.Receptor;
import mx.xpd.cfdi.domain.cfdi.Retencion;
import mx.xpd.cfdi.domain.cfdi.TUbicacion;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Deduccion;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Deducciones;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Nomina;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Percepcion;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Percepciones;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Nomina12;
import mx.xpd.cfdi.domain.cfdi.pdf.ComprobantePDF;
import mx.xpd.cfdi.domain.cfdi.Retenidos;
import mx.xpd.cfdi.repo.CertificadoSelloDigitalDao;
import mx.xpd.cfdi.repo.ClienteDao;
import mx.xpd.cfdi.repo.ComprobanteDao;
import mx.xpd.cfdi.repo.ConfiguracionCFDIDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.EmpleadoDao;
import mx.xpd.cfdi.repo.LugarExpedicionDao;
import mx.xpd.cfdi.repo.MonedaDao;
import mx.xpd.cfdi.repo.PaisEstadoDao;
import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.repo.PlantillaDao;
import mx.xpd.cfdi.repo.ProductoServicioDao;
import mx.xpd.cfdi.repo.RegimenFiscalDao;
import mx.xpd.cfdi.timbrado.service.Timbrado;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceSoapBindingStub;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub.RespuestaTimbrado;
import mx.xpd.cfdi.util.ComprobantePDFUtil;
import mx.xpd.cfdi.util.FechasUtil;
import mx.xpd.cfdi.util.NumberConverter;
import mx.xpd.cfdi.util.PDFExporter;
import mx.xpd.cfdi.util.QRGenerator;
import mx.xpd.cfdi.util.Sello;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/nominas")
public class NominaController {
	 
	private Logger log = Logger.getLogger(NominaController.class);

	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private DatosEmisorDao datosEmisorDao;
	@Autowired
	private ConfiguracionCFDIDao configuracionDao;
	@Autowired
	private ComprobanteDao comprobanteDao;
	@Autowired
	private MonedaDao monedaDao;
	@Autowired
	private CertificadoSelloDigitalDao csdDao;
	@Autowired
	private RegimenFiscalDao regimenFiscalDao;
	@Autowired
	private ParametroDao parametroDao;
	@Autowired
	private ProductoServicioDao productoDao;
	@Autowired
	private PlantillaDao plantillaDao;
	@Autowired
	private PaisEstadoDao paisEstadosDao;
	@Autowired
	private LugarExpedicionDao lugarDao;
	@Autowired
	private EmpleadoDao empleadoDao;
	private FechasUtil fechasUtil;
	
	
	@RequestMapping(value = "/reporte/{anio}/{mes}", method = RequestMethod.GET, produces = "application/vnd.ms-excel")
	public void mostrarReporte(@PathVariable String anio,
			   @PathVariable String mes, Model model, HttpServletResponse response, 
			    HttpServletRequest request) throws JRException, IOException { 

		String urlPlantilla = "/home/cfdi33/plantillas/cfdi.jrxml";
		
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		List<CfdEmitido> cfdis = comprobanteDao.findByDates(tenantID, anio, mes);
		
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(cfdis);
		JasperReport report = JasperCompileManager.compileReport(urlPlantilla);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cfdis", cfdis);
		
		JasperPrint print = JasperFillManager.fillReport(report, params, datasource);
			
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment; filename=" + "cfdis.xls");
		
		JRXlsExporter excelExporter = new JRXlsExporter();
		excelExporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
		excelExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
		excelExporter.exportReport();
		response.getOutputStream().flush();
	}
	
	@RequestMapping(value = "/ayuda" ,method = RequestMethod.GET)
	public String ayuda(Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		return "nominas/ayuda";
	}
	
	@RequestMapping(value = "/errores" ,method = RequestMethod.GET)
	public void errores(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=sample.xlsx");
		Path xls = Paths.get("/home/cfdi33/tmp/" + tenantID + ".xlsx");
		byte []data = Files.readAllBytes(xls);
		response.getOutputStream().write(data);
		
	}
	
	@RequestMapping(value = "/listar" ,method = RequestMethod.GET)
	public String listar(Model model, HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date dateActual = new Date();
				
		String strMesActual = Integer.toString(dateActual.getMonth()+1);
		if (strMesActual.length() == 1){
			strMesActual = "0" + strMesActual;
			
		}
		
		String strAnioActual = Integer.toString(dateActual.getYear()+1900);
		return filtrarPeriodo(strAnioActual, strMesActual, model, request);
	}
	
	@RequestMapping(value = "/" ,method = RequestMethod.GET)
	public String mostrar(Model model, HttpServletRequest request) {
		return "nominas/form"; 
	}
	
	@RequestMapping(value = "/filtrar/{anio}/{mes}", method = RequestMethod.GET)
	public String filtrarPeriodo(@PathVariable String anio, @PathVariable String mes, Model model, HttpServletRequest request) {		
			
	   final String tenantID = (String)request.getSession().getAttribute("tenantId");
	   List<CfdEmitido> cfds = comprobanteDao.findByDatesNomina(tenantID, anio, mes);
	   model.addAttribute("cfds", cfds);
	   model.addAttribute("mes", mes);
	   model.addAttribute("anio", anio);;
	   List<Addenda> addendas = comprobanteDao.findAddendas(tenantID);
	   model.addAttribute("tieneAddendas", (addendas == null) ? false : addendas.size() > 0);
	   model.addAttribute("addendas", addendas);
	   model.addAttribute("addendaSelect", "String");
	   datosEmisorDao.setTenantId(tenantID);
	   model.addAttribute("datosE",datosEmisorDao.findEmisor(tenantID));
	  return "nominas/listaCfd"; 
	 } 
	
	@RequestMapping(value = "/email/{uuid}/{fecha}", method = RequestMethod.GET)
	public String email(@PathVariable String uuid, @PathVariable String fecha, Model model, HttpServletRequest request) {		
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		ConfiguracionCFDI config = configuracionDao.findAll(tenantID);
		DatosEmisor emisor = datosEmisorDao.findEmisor(tenantID);
		CfdEmitido cfdi = comprobanteDao.findByUuid(uuid, tenantID, fecha);
		
		Email email = new Email();
		email.setTextoEnviar(config.getEmailConfig());
		email.setEmailEmisor("portal@xpd.mx");
		email.setEmailReceptor(cfdi.getEmail());
		email.setEmailReplyTo(emisor.getEmail());
		
		String asunto = "CFDI " + (cfdi.getFolio() == null ? "" : "No. " + cfdi.getFolio()) + 
				" de " + emisor.getRfc() + " para " +  cfdi.getRfcReceptor() + " con monto " + 
				NumberFormat.getCurrencyInstance().format(cfdi.getTotal());  
		
		email.setAsunto(asunto);
		model.addAttribute("uuid", uuid);
		model.addAttribute("email", email);
		return "/nominas/email";
	}
	
	private String getXMLComprobante(Comprobante cfdi) {
		String result = null;
		log.info(cfdi);
		try {
			
			//DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    //dbf.setNamespaceAware(true);
		    //Document doc = dbf.newDocumentBuilder().newDocument();
		    JAXBContext jaxbContext = JAXBContext.newInstance(Comprobante.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, ""
					+ "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd ");
			
			if (cfdi.getComplemento() != null) {
				if (cfdi.getComplemento().getNomina12() != null) {
					jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, ""
							+ "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd "
							+ "http://www.sat.gob.mx/nomina12 http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina12.xsd ");
				}
			}
					

			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//jaxbMarshaller.marshal(cfdi, doc);
			
			StringWriter strXML = new StringWriter(); 
			jaxbMarshaller.marshal(cfdi, strXML);
			result = strXML.toString();
			result = result.replace("<instEducativas", "<iedu:instEducativas xsi:schemaLocation=\"http://www.sat.gob.mx/iedu http://www.sat.gob.mx/sitio_internet/cfd/iedu/iedu.xsd\" ");
			result = result.replace("cfdi:ImpuestosLocales", "implocal:ImpuestosLocales");
			result = result.replace("cfdi:Donatarias", "donat:Donatarias ");
			
			if (cfdi.getComplemento() != null){
				if (cfdi.getComplemento().getNomina12() != null) {
					result = result.replace("cfdi:Nomina", "nomina12:Nomina");
				}
			}
			if (cfdi.getComplemento() != null) {
				//			schema += "http://www.sat.gob.mx/Nominaiedu http://www.sat.gob.mx/cfd/iedu/iedu.xsd "
				if (cfdi.getComplemento().getNotariosPublicos() == null) {
					result = result.replace("xmlns:notariospublicos=\"http://www.sat.gob.mx/notariospublicos\"", "");
				}
				if (cfdi.getComplemento().getConsumodecombustibles() == null) {
					result = result.replace("xmlns:consumodecombustibles=\"http://www.sat.gob.mx/consumodecombustibles\"", "");
				}
				if (cfdi.getComplemento().getVehiculousado() == null) {
					result = result.replace("xmlns:vehiculousado=\"http://www.sat.gob.mx/vehiculousado\"", "");
				}
				if (cfdi.getComplemento().getNomina() == null) {
					result = result.replace("xmlns:nomina=\"http://www.sat.gob.mx/nomina\"", "");
				}
				if (cfdi.getComplemento().getNomina12() == null) {
					result = result.replace("xmlns:nomina12=\"http://www.sat.gob.mx/nomina12\"", "");
				}
				if (cfdi.getComplemento().getDetallista() == null) {
					result = result.replace("xmlns:detallista=\"http://www.sat.gob.mx/detallista\"", "");
				}
				if (cfdi.getComplemento().getDonatarias() == null) {
					result = result.replace("xmlns:donat=\"http://www.sat.gob.mx/donat\"", "");
				}
				if (cfdi.getComplemento().getImpuestosLocales() == null) {
					result = result.replace("xmlns:implocal=\"http://www.sat.gob.mx/implocal\"", "");
				}
				if (cfdi.getComplemento().getPagoEnEspecie() == null) {
					result = result.replace("xmlns:pagoenespecie=\"http://www.sat.gob.mx/pagoenespecie\"", "");
				}
				if (cfdi.getComplemento().getRegistroFiscal() == null) {
					result = result.replace("xmlns:registrofiscal=\"http://www.sat.gob.mx/registrofiscal\"", "");
				}
				if (cfdi.getComplemento().getValesDespensa() == null) {
					result = result.replace("xmlns:valesdedespensa=\"http://www.sat.gob.mx/valesdedespensa\"", "");
				}
				if (cfdi.getComplemento().getParcialesConstruccion() == null) {
					result = result.replace("xmlns:servicioparcial=\"http://www.sat.gob.mx/servicioparcialconstruccion\"", "");
				}
				if (cfdi.getComplemento().getAerolineas() == null) {
					result = result.replace("xmlns:aerolineas=\"http://www.sat.gob.mx/aerolineas\"", "");
				}
				if (cfdi.getComplemento().getDivisas() == null) {
					result = result.replace("xmlns:divisas=\"http://www.sat.gob.mx/divisas\"", "");
				}
				if (cfdi.getComplemento().getTurista() == null) {
					result = result.replace("xmlns:tpe=\"http://www.sat.gob.mx/TuristaPasajeroExtranjero\"", "");
				}
				if (cfdi.getComplemento().getPfic() == null) {
					result = result.replace("xmlns:pfic=\"http://www.sat.gob.mx/pfic\"", "");
				}
				if (cfdi.getComplemento().getIne() == null) {
					result = result.replace("xmlns:ine=\"http://www.sat.gob.mx/ine\"", "");
				}
				if (cfdi.getComplemento().getLeyendasFisc() == null) {
					result = result.replace("xmlns:leyendasFisc=\"http://www.sat.gob.mx/leyendasFiscales\"", "");
				}
				if (cfdi.getComplemento().getObrasArteAntiguedades() == null) {
					result = result.replace("xmlns:obrasarte=\"http://www.sat.gob.mx/arteantiguedades\"", "");
				}
				if (cfdi.getComplemento().getCertificadoDestruccion() == null) {
					result = result.replace("xmlns:destruccion=\"http://www.sat.gob.mx/certificadodestruccion\"", "");
				}
				if (cfdi.getComplemento().getEstadodecuentacombustible12() == null) {
					result = result.replace("xmlns:ecc12=\"http://www.sat.gob.mx/EstadoDeCuentaCombustible12\"", "");
				}
				if (cfdi.getComplemento().getComplemento_SPEI() == null) {
					result = result.replace("xmlns:spei=\"http://www.sat.gob.mx/spei\"", "");
				}
				if (cfdi.getComplemento().getComercioExterior() == null) {
					result = result.replace("xmlns:cce11=\"http://www.sat.gob.mx/ComercioExterior11\"", "");
				}
				result = result.replace("xmlns:iedu=\"http://www.sat.gob.mx/iedu\"", "");
				result = result.replace("xmlns:ventavehiculos=\"http://www.sat.gob.mx/ventavehiculos\"", "");
				result = result.replace("xmlns:terceros=\"http://www.sat.gob.mx/terceros\"", "");
				
			} else {
				result = result.replace("xmlns:notariospublicos=\"http://www.sat.gob.mx/notariospublicos\"", "");
				result = result.replace("xmlns:consumodecombustibles=\"http://www.sat.gob.mx/consumodecombustibles\"", "");
				result = result.replace("xmlns:vehiculousado=\"http://www.sat.gob.mx/vehiculousado\"", "");
				result = result.replace("xmlns:pagoenespecie=\"http://www.sat.gob.mx/pagoenespecie\"", "");
				result = result.replace("xmlns:registrofiscal=\"http://www.sat.gob.mx/registrofiscal\"", "");
				result = result.replace("xmlns:nomina=\"http://www.sat.gob.mx/nomina\"", "");
				result = result.replace("xmlns:nomina12=\"http://www.sat.gob.mx/nomina12\"", "");
				result = result.replace("xmlns:detallista=\"http://www.sat.gob.mx/detallista\"", "");
				result = result.replace("xmlns:donat=\"http://www.sat.gob.mx/donat\"", "");
				result = result.replace("xmlns:implocal=\"http://www.sat.gob.mx/implocal\"", "");
				result = result.replace("xmlns:valesdedespensa=\"http://www.sat.gob.mx/valesdedespensa\"", "");
				result = result.replace("xmlns:servicioparcial=\"http://www.sat.gob.mx/servicioparcialconstruccion\"", "");
				result = result.replace("xmlns:aerolineas=\"http://www.sat.gob.mx/aerolineas\"", "");
				result = result.replace("xmlns:divisas=\"http://www.sat.gob.mx/divisas\"", "");
				result = result.replace("xmlns:tpe=\"http://www.sat.gob.mx/TuristaPasajeroExtranjero\"", "");
				result = result.replace("xmlns:pfic=\"http://www.sat.gob.mx/pfic\"", "");
				result = result.replace("xmlns:ine=\"http://www.sat.gob.mx/ine\"", "");
				result = result.replace("xmlns:leyendasFisc=\"http://www.sat.gob.mx/leyendasFiscales\"", "");
				result = result.replace("xmlns:obrasarte=\"http://www.sat.gob.mx/arteantiguedades\"", "");
				result = result.replace("xmlns:destruccion=\"http://www.sat.gob.mx/certificadodestruccion\"", "");
				result = result.replace("xmlns:ecc11=\"http://www.sat.gob.mx/EstadoDeCuentaCombustible\"", "");
				result = result.replace("xmlns:spei=\"http://www.sat.gob.mx/spei\"", "");
				result = result.replace("xmlns:cce11=\"http://www.sat.gob.mx/ComercioExterior11\"", "");
				result = result.replace("xmlns:iedu=\"http://www.sat.gob.mx/iedu\"", "");
				result = result.replace("xmlns:ventavehiculos=\"http://www.sat.gob.mx/ventavehiculos\"", "");
				result = result.replace("xmlns:terceros=\"http://www.sat.gob.mx/terceros\"", "");
			}
			
//					+ "xsi:schemaLocation=\"http://www.sat.gob.mx/donat http://www.sat.gob.mx/sitio_internet/cfd/donat/donat11.xsd\""
//					+ "").replace("cfdi:ImpuestosLocales", "implocal:ImpuestosLocales");
			//result = new String(result.getBytes("UTF-8")); 
			
		} catch(Exception e) {
			log.error("Error: " + e);
			e.printStackTrace();
		} finally {
			return result;
		}
	}
   	
	
	
	
	private XSSFWorkbook crearRespuesta() {
		XSSFWorkbook workBook = null;
		try {
			workBook = new XSSFWorkbook(new FileInputStream("/home/cfdi33/files/layout.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return workBook;
	}
	
	
	
	
class NominaThread21 extends Thread {
        
		private HttpSession session;
		private String tenantID;
		private InputStream file;
		
		
		
        public void run() {
        	XSSFWorkbook wError = crearRespuesta();
        	try {
        		
        		int errores = 0;
    			DatosEmisor dE = datosEmisorDao.findEmisor(tenantID);
    			CertificadoSelloDigital csd = csdDao.findCurrent(tenantID);
    			ConfiguracionCFDI conf = configuracionDao.findAll(tenantID);
    			
    			Emisor emisor = new Emisor();
    			emisor.setRfc(dE.getRfc());
    			emisor.setNombre(dE.getRazonSocial());
    			emisor.setRegimenFiscal(dE.getRegimenFiscal());
    			
    			Comprobante cfdi = new Comprobante();
    			cfdi.setEmisor(emisor);
    			cfdi.setVersion("3.3");
    			cfdi.setLugarExpedicion(dE.getCodigoPostal());
    			cfdi.getEmisor().setRegimenFiscal(emisor.getRegimenFiscal());
    			
    			/* Certificado */ 
    			String cer = cleanCertificate(csd.getCertificado());
    			cer = cer.replaceAll(" ", "").replaceAll("\n", "");
    			cfdi.setNoCertificado(csd.getNoSerie());
    			cfdi.setCertificado(cer);
    			    			
    			cfdi.setTipoDeComprobante("N");
    			cfdi.setFormaPago("99");
    			
    			
    			log.info("ok");
    			
    			Complemento compĺemento = new Complemento();
    			Receptor receptor = null;
    			Concepto concepto;
    			Retencion retencion = null;
    			Nomina12 nomina = null;
    			
    			
    			XSSFCell cell = null;
    			XSSFWorkbook workBook =  new XSSFWorkbook(file);
    			XSSFSheet sheet = workBook.getSheetAt(1);
    			
    		
    			
    			Iterator rowIterator = sheet.rowIterator();
    			DecimalFormat df = new DecimalFormat("#######0.000000");
    			DecimalFormat df2 = new DecimalFormat("#######0.00");
    			if (!rowIterator.hasNext()) return;
    			rowIterator.next();
    			rowIterator.next();
    			while (rowIterator.hasNext()) {
    				XSSFRow hssfRow = (XSSFRow) rowIterator.next();
    				Iterator iterator = hssfRow.cellIterator();
    				
    								
    				
    				nomina = new Nomina12();
    				
    				/* Empleado */ 
    				receptor = new Receptor();
    				
    				cell = hssfRow.getCell(0);
    				receptor.setRfc(cell == null ? null : cell.toString());
    				
    				cell = hssfRow.getCell(1);
    				receptor.setNombre(cell == null ? null : cell.toString());
    				
    				/* DatosNomina */
    				cell = hssfRow.getCell(2);	
    				String tipoNomina = cell == null ? "" : cell.toString();
    				if (!tipoNomina.isEmpty()) {
    					nomina.setTipoNomina(cell.toString().substring(0, 1));
    				}
    				cell = hssfRow.getCell(3);	
    				String usoCFDI = cell == null ? "" : cell.toString();
    				if (!usoCFDI.isEmpty()) {
    					receptor.setUsoCFDI(cell.toString().substring(0, 3));
    				}
    				cell = hssfRow.getCell(16);
    				nomina.setFechaPago(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(17);
    				String inicio = (cell == null ? "" : cell.toString());
    				nomina.setFechaInicialPago(inicio);
    				cell = hssfRow.getCell(18);
    				String fin = (cell == null ? "" : cell.toString());
    				nomina.setFechaFinalPago(fin);
    				cell = hssfRow.getCell(19);
    				nomina.setNumDiasPagados(cell == null ? "" : cell.toString());
    				
    				//nomina Emisor
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Emisor emisorNomina = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Emisor();
    				cell = hssfRow.getCell(4);
    				emisorNomina.setCurp((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(5);
    				emisorNomina.setRegistroPatronal((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(6);
    				emisorNomina.setRfcPatronOrigen((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				nomina.setEmisor(emisorNomina);
    				
    				//EntidadSNCF
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.EntidadSNCF entidadSNCF = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.EntidadSNCF();
    				cell = hssfRow.getCell(7);
    				entidadSNCF.setOrigenRecurso((cell == null || cell.toString().length() == 0) ? null : cell.toString().substring(0, 2));
    				
    				
    				cell = hssfRow.getCell(8);
    				entidadSNCF.setMontoRecursoPropio((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				if (entidadSNCF.getOrigenRecurso() != null){
    					nomina.getEmisor().setEntidadSNCF(entidadSNCF);
    				}
    				
    				
    				//nomina Receptor
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Receptor receptorNomina = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Receptor();
    				cell = hssfRow.getCell(9);
    				receptorNomina.setCurpReceptor((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(11);
    				receptorNomina.setNumSeguridadSocial((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(20);
    				receptorNomina.setFechaInicioRelLaboral((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(21);
    				receptorNomina.setAntiguedad((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(12);
    				String tipoContrato = cell == null ? "" : cell.toString();
    				if (!tipoContrato.isEmpty()) {
    					receptorNomina.setTipoContrato(cell.toString().substring(0, 2));
    				}
    				cell = hssfRow.getCell(22);
    				receptorNomina.setSindicalizado((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(23);
    				String tipoJornada = cell == null ? "" : cell.toString();
    				if (!tipoJornada.isEmpty()) {
    					receptorNomina.setTipoJornada(cell.toString().substring(0, 2));
    				}
    				cell = hssfRow.getCell(13);
    				String tipoRegimen = cell == null ? "" : cell.toString();
    				if (!tipoRegimen.isEmpty()) {
    					receptorNomina.setTipoRegimen(cell.toString().substring(0, 2));
    				}
    				cell = hssfRow.getCell(10);
    				receptorNomina.setNumEmpleado((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(24);
    				receptorNomina.setDepartamento((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(25);
    				receptorNomina.setPuesto((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(26);
    				String riesgoPuesto = cell == null ? "" : cell.toString();
    				if (!riesgoPuesto.isEmpty()) {
    					riesgoPuesto = cell.toString().split("-")[0];
    					receptorNomina.setRiesgoPuesto(riesgoPuesto.substring(0, riesgoPuesto.length()-1));
    				}
    				cell = hssfRow.getCell(14);
    				String periodicidadPago = cell == null ? "" : cell.toString();
    				if (!periodicidadPago.isEmpty()) {
    					receptorNomina.setPeriodicidadPago(cell.toString().substring(0, 2));
    				}
    				cell = hssfRow.getCell(27);
    				String banco = cell == null ? "" : cell.toString();
    				if (!banco.isEmpty()) {
    					receptorNomina.setBanco(cell.toString().substring(0, 3));
    				}
    				cell = hssfRow.getCell(28);
    				receptorNomina.setCuentaBancaria((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(29);
    				String salarioBaseCotApor = cell == null ? "" : cell.toString();
    				if (!salarioBaseCotApor.isEmpty()) {
    					receptorNomina.setSalarioBaseCotApor(getDouble(cell.toString()));
    				}
    				cell = hssfRow.getCell(30);
    				String salarioDiarioIntegrado = cell == null ? "" : cell.toString();
    				if (!salarioDiarioIntegrado.isEmpty()) {
    					receptorNomina.setSalarioDiarioIntegrado(getDouble(cell.toString()));
    				}
    				cell = hssfRow.getCell(15);
    				String claveEntFed = cell == null ? "" : cell.toString();
    				if (!claveEntFed.isEmpty()) {
    					receptorNomina.setClaveEntFed(cell.toString().substring(0, 3));
    				}
    				nomina.setReceptor(receptorNomina);
    				
    				//SubContratacion
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.SubContratacion subContratacion = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.SubContratacion(); 
    				cell = hssfRow.getCell(31);
    				subContratacion.setRfcLabora((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				cell = hssfRow.getCell(32);
    				subContratacion.setPorcentajeTiempo((cell == null || cell.toString().length() == 0) ? null : cell.toString());
    				List<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.SubContratacion> subContrataciones =new ArrayList<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.SubContratacion>();
    				subContrataciones.add(subContratacion);
    				if (subContratacion.getRfcLabora() != null && subContratacion.getPorcentajeTiempo() != null){
    					nomina.getReceptor().setSubContratacion(subContrataciones);
    				}
    				
    				
    				
    				
    				/* Datos extras del CFDI */
    				cfdi.setTipoCambio("1");
    				cfdi.setMoneda("MXN");
    				cfdi.setMetodoPago("PUE");
    				
    				cell = hssfRow.getCell(34);
    				
    				concepto = new Concepto();
    				concepto.setCantidad("1");
    				concepto.setClaveUnidad("ACT");
    				concepto.setClaveProdServ("84111505");
    				concepto.setDescripcion(cell == null ? null : cell.toString());
    				
    				
    				
    				double totalExento, totalGravado, totalSueldos, totalSeparacionIndemnizacion, totalJubilacionPensionRetiro = 0;
    				
    				List<CatalogosNomina> cPercepciones = (List<mx.xpd.cfdi.domain.CatalogosNomina>)comprobanteDao.findCatalogoNomina("tipoPercepcion");
    				
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.JubilacionPensionRetiro jubilacionPensionRetiro = null;
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.SeparacionIndemnizacion separacionIndemnizacion = null;
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.AccionesOTitulos accionesOTitulos = null;
    				List<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.HorasExtras> horasExtras = null;
    				
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidades incapacidades = null;
    				List<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidad> listaIncapacidades = null;
    				
    				
    				totalExento = totalGravado = totalSueldos = totalSeparacionIndemnizacion = totalJubilacionPensionRetiro = 0;
    				List<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Percepcion> percepciones = new ArrayList<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Percepcion>();
    				int column = 38;
    				for (CatalogosNomina c : cPercepciones) {  
    					column++;
    					cell = hssfRow.getCell(column);
    					String c1 = cell == null ? null : cell.toString();
    					column++;
    					cell = hssfRow.getCell(column);
    					String c2 = cell == null ? null : cell.toString();
    					column++;
    					cell = hssfRow.getCell(column);
    					String c3 = cell == null ? null : cell.toString();
    					column++;
    					cell = hssfRow.getCell(column);
    					String c4 = cell == null ? null : cell.toString();
    					
    					mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Percepcion pTmp = validaPercepcion12(c.getClave(), c.getNombre(), c1, c2, c3, c4);
    					if (pTmp != null) {
    						totalExento += Double.parseDouble(pTmp.getImporteExento());
    						totalGravado += Double.parseDouble(pTmp.getImporteGravado());
    						
    						if ((!pTmp.getTipoPercepcion().equals("022"))&&(!pTmp.getTipoPercepcion().equals("023"))&&(!pTmp.getTipoPercepcion().equals("025"))&&
    								(!pTmp.getTipoPercepcion().equals("039"))&&(!pTmp.getTipoPercepcion().equals("044"))){
    							totalSueldos = totalSueldos + Double.parseDouble(pTmp.getImporteExento()) + Double.parseDouble(pTmp.getImporteGravado());
    						}
    						if (pTmp.getTipoPercepcion().equals("014")){
    							incapacidades = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidades();
    							listaIncapacidades = new ArrayList<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidad>();
    							mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidad incapacidad = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidad();
    							column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c5 = cell == null ? null : cell.toString();
        	    				incapacidad.setDiasIncapacidad(Integer.parseInt(c5));
        						column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c6 = cell == null ? null : cell.toString();
        	    				incapacidad.setTipoIncapacidad(c6.toString().substring(0, 2));
        						column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c7 = cell == null ? null : cell.toString();
        	    				incapacidad.setImporteMonetario(Double.parseDouble(c7));
        	    				listaIncapacidades.add(incapacidad);
        	    				incapacidades.setIncapacidad(listaIncapacidades);
    						}
    						if ((pTmp.getTipoPercepcion().equals("022"))||(pTmp.getTipoPercepcion().equals("023"))||(pTmp.getTipoPercepcion().equals("025"))){
    							totalSeparacionIndemnizacion = totalSeparacionIndemnizacion + Double.parseDouble(pTmp.getImporteExento()) + Double.parseDouble(pTmp.getImporteGravado());
    							
    							separacionIndemnizacion = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.SeparacionIndemnizacion();
        						column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c5 = cell == null ? null : cell.toString();
        	    				separacionIndemnizacion.setTotalPagado(c5);
        						column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c6 = cell == null ? null : cell.toString();
        	    				separacionIndemnizacion.setNumAniosServicio(c6);
        						column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c7 = cell == null ? null : cell.toString();
        	    				separacionIndemnizacion.setUltimoSueldoMensOrd(c7);
        	    				column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c8 = cell == null ? null : cell.toString();
        	    				separacionIndemnizacion.setIngresoAcumulableSeparacionIndemnizacion(c8);
        	    				column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c9 = cell == null ? null : cell.toString();
        	    				separacionIndemnizacion.setIngresoNoAcumulableSeparacionIndemnizacion(c9);
    						}
    						if ((pTmp.getTipoPercepcion().equals("039"))||(pTmp.getTipoPercepcion().equals("044"))){
    							totalJubilacionPensionRetiro = totalJubilacionPensionRetiro + Double.parseDouble(pTmp.getImporteExento()) + Double.parseDouble(pTmp.getImporteGravado());
    							if (pTmp.getTipoPercepcion().equals("039")){
    								jubilacionPensionRetiro = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.JubilacionPensionRetiro();
        							column++;
        	    					cell = hssfRow.getCell(column);
        	    					String c5 = cell == null ? null : cell.toString();
        							jubilacionPensionRetiro.setTotalUnaExhibicion(c5);
        							column++;
        	    					cell = hssfRow.getCell(column);
        	    					String c6 = cell == null ? null : cell.toString();
        							jubilacionPensionRetiro.setIngresoAcumulable(c6);
        							column++;
        	    					cell = hssfRow.getCell(column);
        	    					String c7 = cell == null ? null : cell.toString();
        							jubilacionPensionRetiro.setIngresoNoAcumulable(c7);
    							}
    							if (pTmp.getTipoPercepcion().equals("044")){
    								jubilacionPensionRetiro = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.JubilacionPensionRetiro();
        							column++;
        	    					cell = hssfRow.getCell(column);
        	    					String c5 = cell == null ? null : cell.toString();
        							jubilacionPensionRetiro.setTotalParcialidad(c5);
        							column++;
        	    					cell = hssfRow.getCell(column);
        	    					String c6 = cell == null ? null : cell.toString();
        							jubilacionPensionRetiro.setMontoDiario(c6);
        							column++;
        	    					cell = hssfRow.getCell(column);
        	    					String c7 = cell == null ? null : cell.toString();
        							jubilacionPensionRetiro.setIngresoAcumulable(c7);
        							column++;
        	    					cell = hssfRow.getCell(column);
        	    					String c8 = cell == null ? null : cell.toString();
        							jubilacionPensionRetiro.setIngresoNoAcumulable(c8);
    							}
    						}
    						if (pTmp.getTipoPercepcion().equals("045")){
    							accionesOTitulos = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.AccionesOTitulos();
    							column++;
    	    					cell = hssfRow.getCell(column);
    	    					String c5 = cell == null ? null : cell.toString();
    	    					accionesOTitulos.setValorMercado(c5);
    	    					column++;
    	    					cell = hssfRow.getCell(column);
    	    					String c6 = cell == null ? null : cell.toString();
    	    					accionesOTitulos.setPrecioAlOtorgarse(c6);
    	    					pTmp.setAccionesOTitulos(accionesOTitulos);
    						}
    						if (pTmp.getTipoPercepcion().equals("019")){
    							horasExtras = new ArrayList<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.HorasExtras>();
    							mx.xpd.cfdi.domain.cfdi.complementos.nomina12.HorasExtras horaExtra = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.HorasExtras();
    							column++;
    	    					cell = hssfRow.getCell(column);
    	    					String c5 = cell == null ? null : cell.toString();
    	    					horaExtra.setDias(Integer.parseInt(c5));
    	    					column++;
    	    					cell = hssfRow.getCell(column);
    	    					String c6 = cell == null ? null : cell.toString();
    	    					horaExtra.setTipoHoras(c6.toString().substring(0, 2));
    	    					column++;
    	    					cell = hssfRow.getCell(column);
    	    					String c7 = cell == null ? null : cell.toString();
    	    					horaExtra.setNumeroHorasExtra(Integer.parseInt(c7));
    	    					column++;
    	    					cell = hssfRow.getCell(column);
    	    					String c8 = cell == null ? null : cell.toString();
    	    					horaExtra.setImportePagado(Double.parseDouble(c8));
    	    					horasExtras.add(horaExtra);
    	    					pTmp.setHorasExtra(horasExtras);
    						}
	    					
	    					percepciones.add(pTmp);
	    					
	    				}
    					else{
    						if (c.getClave().equals("022")||c.getClave().equals("023")||c.getClave().equals("025")){
        						column = column + 5;
        					}
        					if (c.getClave().equals("039")){
        						column = column + 3;
        					}
        					if (c.getClave().equals("044")){
        						column = column + 4;
        					}
        					if (c.getClave().equals("045")){
        						column = column + 2;
        					}
        					if (c.getClave().equals("019")){
        						column = column + 4;
        					}
        					if (c.getClave().equals("014")){
        						column = column + 3;
        					}
    					}
    					
    					
    				}
    				if (!percepciones.isEmpty()) {
    					mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Percepciones per = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Percepciones();
    					per.setPercepcion(percepciones);
    					per.setTotalSueldos(df2.format(totalSueldos));
    					per.setTotalSeparacionIndemnizacion(df2.format(totalSeparacionIndemnizacion));
    					per.setTotalJubilacionPensionRetiro(df2.format(totalJubilacionPensionRetiro));
    					per.setTotalGravado(df2.format(totalGravado));
    					per.setTotalExento(df2.format(totalExento));
    					if (jubilacionPensionRetiro !=null){
    						per.setJubilacionPensionRetiro(jubilacionPensionRetiro);
    					}
    					if (separacionIndemnizacion !=null){
    						per.setSeparacionIndemnizacion(separacionIndemnizacion);
    					}
    					if (listaIncapacidades != null ){
    						nomina.setIncapacidades(incapacidades);
    					}
    					nomina.setPercepciones(per);
    					nomina.setTotalPercepciones(df2.format(totalSueldos + totalSeparacionIndemnizacion + totalJubilacionPensionRetiro));
    				}
    				
    				Double importe = totalExento + totalGravado;		
    				List<CatalogosNomina> cDeducciones = (List<mx.xpd.cfdi.domain.CatalogosNomina>)comprobanteDao.findCatalogoNomina("tipoDeduccion");
    				totalExento = totalGravado = 0;
    				
    				Double totalImpuestosRetenidos = 0.0;
    				Double totalOtrasDeducciones = 0.0;

    				List<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Deduccion> deducciones = new ArrayList<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Deduccion>();
    				for (CatalogosNomina c : cDeducciones) { 
    					if (!iterator.hasNext()) continue;
    					
    					column++;
    					cell = hssfRow.getCell(column);
    					String c1 = cell == null ? null : cell.toString();
    					column++;
    					cell = hssfRow.getCell(column);
    					String c2 = cell == null ? null : cell.toString();
    					column++;
    					cell = hssfRow.getCell(column);
    					String c3 = cell == null ? null : cell.toString();
    					
    					mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Deduccion dTmp = validaDeduccion12(c.getClave(), c.getNombre(), c1, c2, c3);
    					if (dTmp != null) {
    						if (dTmp.getTipoDeduccion().equals("002")) {
    							totalImpuestosRetenidos = totalImpuestosRetenidos + Double.parseDouble(dTmp.getImporteDeduccion());
    							
    						} else {
    							totalOtrasDeducciones = totalOtrasDeducciones + Double.parseDouble(dTmp.getImporteDeduccion());
    						}
    						if (dTmp.getTipoDeduccion().equals("006")) {
    							incapacidades = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidades();
    							listaIncapacidades = new ArrayList<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidad>();
    							mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidad incapacidad = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Incapacidad();
    							column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c4 = cell == null ? null : cell.toString();
        	    				incapacidad.setDiasIncapacidad(Integer.parseInt(c4));
        						column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c5 = cell == null ? null : cell.toString();
        	    				incapacidad.setTipoIncapacidad(c5.toString().substring(0, 2));
        						column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c6 = cell == null ? null : cell.toString();
        	    				incapacidad.setImporteMonetario(Double.parseDouble(c6));
        	    				listaIncapacidades.add(incapacidad);
        	    				incapacidades.setIncapacidad(listaIncapacidades);
    						}
    						deducciones.add(dTmp);
    					}
    					else{
    						if (c.getClave().equals("006")){
        						column = column + 3;
        					}
    					}

    				}
    				
    				String observaciones = cell != null ? cell.toString() : "";
    				if (!deducciones.isEmpty()) {
    					mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Deducciones dec = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Deducciones();
    					dec.setDeduccion(deducciones);
    					if (totalImpuestosRetenidos != 0.0){
    						dec.setTotalImpuestosRetenidos(df2.format(totalImpuestosRetenidos));
    					}
    					else{
    						dec.setTotalImpuestosRetenidos(null);
    					}
    					if (totalOtrasDeducciones != 0.0){
    						dec.setTotalOtrasDeducciones(df2.format(totalOtrasDeducciones));
    					}
    					else{
    						dec.setTotalOtrasDeducciones(null);
    					}
    					if (listaIncapacidades != null ){
    						nomina.setIncapacidades(incapacidades);
    					}
    					
    					nomina.setDeducciones(dec);
    					nomina.setTotalDeducciones(df2.format(totalImpuestosRetenidos + totalOtrasDeducciones));
    				}
    				
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.SubsidioAlEmpleo subsidioAlEmpleo = null;
    				mx.xpd.cfdi.domain.cfdi.complementos.nomina12.CompensacionSaldosAFavor compensacionSaldosAFavor = null;
    				List<CatalogosNomina> cOtrosPagos = (List<mx.xpd.cfdi.domain.CatalogosNomina>)comprobanteDao.findCatalogoNomina("tipoOtroPago");
    				Double totalOtrosPagos = 0.0;
    				List<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.OtroPago> otrosPagos = new ArrayList<mx.xpd.cfdi.domain.cfdi.complementos.nomina12.OtroPago>();
    				for (CatalogosNomina c : cOtrosPagos) { 
    					if (!iterator.hasNext()) continue;
    					
    					column++;
    					cell = hssfRow.getCell(column);
    					String c1 = cell == null ? null : cell.toString();
    					column++;
    					cell = hssfRow.getCell(column);
    					String c2 = cell == null ? null : cell.toString();
    					column++;
    					cell = hssfRow.getCell(column);
    					String c3 = cell == null ? null : cell.toString();
    					
    					mx.xpd.cfdi.domain.cfdi.complementos.nomina12.OtroPago oTmp = validaOtroPago12(c.getClave(), c.getNombre(), c1, c2, c3);
    					if (oTmp != null) {
    						totalOtrosPagos = totalOtrosPagos + Double.parseDouble(oTmp.getImporteOtroPago());
    						
    						if (oTmp.getTipoOtroPago().equals("002")) {
    							subsidioAlEmpleo = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.SubsidioAlEmpleo();
    							column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c4 = cell == null ? null : cell.toString();
        	    				subsidioAlEmpleo.setSubsidioCausado(c4);
        	    				oTmp.setSubsidioAlEmpleo(subsidioAlEmpleo);
    						}
    						if (oTmp.getTipoOtroPago().equals("004")) {
    							compensacionSaldosAFavor = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.CompensacionSaldosAFavor();
    							column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c4 = cell == null ? null : cell.toString();
        	    				compensacionSaldosAFavor.setSaldoAFavor(c4);
        	    				column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c5 = cell == null ? null : cell.toString();
        	    				compensacionSaldosAFavor.setAnioCompensacionSaldosAFavor(c5);
        	    				column++;
        	    				cell = hssfRow.getCell(column);
        	    				String c6 = cell == null ? null : cell.toString();
        	    				compensacionSaldosAFavor.setRemanenteSalFav(c6);
        	    				oTmp.setCompensacionSaldosAFavor(compensacionSaldosAFavor);
    						}
    						otrosPagos.add(oTmp);
    					}
    					else{
    						if (c.getClave().equals("002")){
        						column = column + 1;
        					}
    						if (c.getClave().equals("004")){
        						column = column + 3;
        					}
    					}
    				}
    				
    				column++;
    				cell = hssfRow.getCell(column);
    				
    				if (!otrosPagos.isEmpty()) {
    					mx.xpd.cfdi.domain.cfdi.complementos.nomina12.OtrosPagos op = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.OtrosPagos();
    					op.setOtroPago(otrosPagos);
    					nomina.setOtrosPagos(op);
    					
    					if (totalOtrosPagos != 0.0){
    						nomina.setTotalOtrosPagos(df2.format(totalOtrosPagos));
    					}
    					else{
    						nomina.setTotalOtrosPagos(null);
    					}
    					
    				}
    				
    				cfdi.setConceptos(new Conceptos());
    				
    				if (nomina.getTotalDeducciones() != null){
    					if (nomina.getTotalDeducciones().equals("0.0")){
        					concepto.setDescuento(null);
        				}
    					else{
        					concepto.setDescuento(nomina.getTotalDeducciones());
        				}
    				}
    				else{
    					concepto.setDescuento(null);
    				}
    				
    				
    				cfdi.getConceptos().getConceptos().add(concepto);
    				
    				DateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
    				Date dia1 = d1.parse(inicio);
    				Date dia2 = d1.parse(fin);
    				long dias = dia2.getTime() - dia1.getTime();
    				dias = dias / (24 * 60 * 60 * 1000);	  
    				//nomina.setNumDiasPagados(getDouble("" + (1D * dias)));
    				
    				
    				/* Fecha del CFDI */
    				DateFormat dfor = new SimpleDateFormat("yyyy-MM-dd'T'00:00:01");
    				cfdi.setFecha(dfor.format(new Date()));
    				
    				
    				
    				/* Asignamos el descuentos */
    				if (totalImpuestosRetenidos + totalOtrasDeducciones != 0.0){
    					cfdi.setDescuento(df2.format(totalImpuestosRetenidos + totalOtrasDeducciones));
    				}
    				else{
    					cfdi.setDescuento(null);
    				}
    				
    				
    				/* Datos del concepto */
    				cfdi.getConceptos().getConceptos().get(0).setImporte(df2.format(importe + totalOtrosPagos));
    				cfdi.getConceptos().getConceptos().get(0).setValorUnitario(df2.format(importe + totalOtrosPagos));
    				
    				/* Datos comprobante */
    				cfdi.setSubTotal(df2.format(importe + totalOtrosPagos));
    				//aqui faltaría agregar los de Otros Pagos
    				Double total = Double.parseDouble(nomina.getTotalPercepciones() != null ? nomina.getTotalPercepciones() : "0") + Double.parseDouble(nomina.getTotalOtrosPagos() != null ? nomina.getTotalOtrosPagos() : "0") - Double.parseDouble(nomina.getTotalDeducciones() != null ? nomina.getTotalDeducciones() : "0");
    				cfdi.setTotal(df2.format(total));
    				
    				/* Asignamos al empleado */
    				cfdi.setReceptor(receptor);
    				
    				/* Asignamos la nomina */
    				compĺemento.setNomina12(nomina);
    				cfdi.setComplemento(compĺemento);
    				
    				// log.info(getXMLComprobante(cfdi));
    				
    				InputStream input = new ByteArrayInputStream(getXMLComprobante(cfdi).getBytes("UTF-8"));
    				
    				String llave = cleanCertificate(csd.getArchivoKey());
    				String xslt = parametroDao.findByClave("PATH_XSLT_CADENA").getValor();
    				String sello = Sello.getSello(input, llave, xslt);
    				cfdi.setSello(sello);		
    				String xml = getXMLComprobante(cfdi);
    				log.info("XML NOMINA: \n" + xml);
    				
    				String rfcFecha = parametroDao.findByClave("RFC_FECHA").getValor();
    				
    				if (cfdi.getEmisor().getRfc().equals(rfcFecha)) {
    					cfdi.setFecha("2014-03-31T15:04:45");
    				}
    				
    				errores = timbrarXML(tenantID, cfdi, xml, wError, hssfRow, errores, session, observaciones);

    			}
    		} catch(Exception e) {
    			log.error(e);
    			e.printStackTrace();
    		}
    		
    		FileOutputStream sErrores = null;
    		try {
    			sErrores = new FileOutputStream("/home/cfdi33/tmp/" + tenantID +".xlsx");
    			wError.write(sErrores);
    			sErrores.flush();
    			sErrores.close();
    		} catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        
        }
    }

	
	@RequestMapping(value="/timbrar12", method=RequestMethod.POST)
	public String editar21(Model model, @RequestParam("file12") MultipartFile file, HttpServletRequest request) {
		HttpSession session = request.getSession();
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		
		try {
			DatosEmisor datos = datosEmisorDao.findEmisor(tenantID);
			if (!datos.isGratuito()) {
				Date fechaActual = new Date();
				SimpleDateFormat sds = new SimpleDateFormat("yyyy-MM-dd");
				if (!datos.getTipoPlan()){ // Si no es del Nuevo tipo de Plan = > es de los anteriores y hay validar numero de folios
					if (datos.getFoliosDisponibles() <= 0) {
						return "redirect:/folios/agotados";
					}
				
					if (datos.getUltimaCompra() != null) {
				        Calendar one_year_later = Calendar.getInstance();
						one_year_later.setTime(sds.parse(datos.getUltimaCompra())); 
				        one_year_later.add(Calendar.YEAR, 1);
				        one_year_later.add(Calendar.DAY_OF_YEAR, 1);
				        Date d1 = one_year_later.getTime();	
						
						if (d1.before(fechaActual)) {
							log.info("Vigencia.");
							sds = new SimpleDateFormat("yyyy-MM-dd");
							return "redirect:/pasos/vigencia/?vigencia=" + sds.format(sds.parse(datos.getUltimaCompra())); 
						}				
					}
				}
				if (datos.getTipoPlan()){ // Si es del Nuevo tipo de Plan 
					//validar aqui la fecha de vigencia
					if (datos.getFechaVencimiento() != null) {
						 Calendar actual = Calendar.getInstance();
						 actual.setTime(fechaActual);
						 sds = new SimpleDateFormat("yyyy-MM-dd");
				         Calendar fechaVencimiento = Calendar.getInstance();
				         fechaVencimiento.setTime(sds.parse(datos.getFechaVencimiento()));
				         fechaVencimiento.add(Calendar.DAY_OF_YEAR, 1);
						if (fechaVencimiento.before(actual)) {
							log.info("Vigencia.");
							return "redirect:/pasos/vigencia/?vigencia=" + sds.format(sds.parse(datos.getUltimaCompra())); 
						}
					}
				}
				
				
			}
			
			log.info(file.getOriginalFilename().toLowerCase());
			ByteArrayOutputStream st = new ByteArrayOutputStream();
			
			IOUtils.copy(file.getInputStream(), st);
			
			InputStream isFile = new ByteArrayInputStream(st.toByteArray());
			InputStream ff = new ByteArrayInputStream(st.toByteArray());
			
			
			
			XSSFWorkbook workBook;
			workBook = new XSSFWorkbook(isFile);
			XSSFSheet sheet = workBook.getSheetAt(1);
			Iterator rowIterator = sheet.rowIterator();
			if (!rowIterator.hasNext()) {
				return "redirect:/nominas/";
			}
			int totalFilas = 0;
			while (rowIterator.hasNext()) {
				XSSFRow row = (XSSFRow)rowIterator.next();
				if (row.getCell(0) != null) {
					XSSFCell cel = row.getCell(0);
					if (cel.toString().length() >= 13) {
						totalFilas++;
					}
				}
				
			}
			
			NominaThread21 nomT = new NominaThread21();
			nomT.file = ff;
			nomT.tenantID = tenantID;
			nomT.session = session;
			nomT.start();
			
			session.setAttribute("totalFilas", totalFilas);
			session.setAttribute("totalProcesar", 0);
			session.setAttribute("totalErrores", 0);
			
		} catch (IOException e) {
			session.setAttribute("totalFilas", 0);
			session.setAttribute("totalProcesar", 0);
			session.setAttribute("totalErrores", 0);
			log.error(e);
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/nominas/";
	}
	
	private int timbrarXML(String tenant, Comprobante cfdi, String xml, XSSFWorkbook WErr, XSSFRow fila, int errores, HttpSession session, String observaciones) throws IOException, SAXException, ParserConfigurationException, JRException {
		try {
			DatosEmisor emisor = datosEmisorDao.findEmisor(tenant);
			String endPoint = "";
			String usuario = "";
			String password = "";
			
			if (emisor.isProductivo()) {
				endPoint = parametroDao.findByClave("URL_TIMBRADO_PRODUCCION").getValor();
				// Si tiene cuenta Desktop, usamos la subcuenta correspondiente
				if (emisor.getpTimbrado() != null && !emisor.getpTimbrado().isEmpty()) {
					usuario  = emisor.getTenantId();
					password = emisor.getpTimbrado();
				} else {
					usuario  = parametroDao.findByClave("USUARIO_TIMBRADO_PRODUCCION").getValor();
					password = parametroDao.findByClave("PASSWORD_TIMBRADO_PRODUCCION").getValor();
				}
			} else {
				endPoint = parametroDao.findByClave("URL_TIMBRADO_PRUEBAS").getValor();
				usuario = parametroDao.findByClave("USUARIO_TIMBRADO_PRUEBAS").getValor();
				password = parametroDao.findByClave("PASSWORD_TIMBRADO_PRUEBAS").getValor();
			}
			
			TimbradoWSServiceSoapBindingStub timbrarStub =  new TimbradoWSServiceSoapBindingStub();
			timbrarStub.setUsername(usuario);
			timbrarStub.setPassword(password);
			String msg = "";
			String err = "";
			
			mx.xpd.cfdi.timbrado.service.RespuestaTimbrado respo = timbrarStub.timbrar(endPoint, usuario, password, xml.getBytes());
			File file = null; 
			
			log.info(respo.getCodigo() + " - " + respo.getMensaje());
			
			if (respo.getCodigo().equals("200")) {
				String rutaXML = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();
				file = new File(rutaXML + File.separatorChar + cfdi.getEmisor().getRfc());
				checarCarpeta(file);
				file = new File(file.getAbsolutePath() + File.separatorChar + respo.getUuid()  +".xml");
				BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
				String xmlResult = respo.getTimbre();
				
				if (!xmlResult.startsWith("<?xml version=")) {
					fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n");
				}
				
				fileWriter.write(xmlResult);
				fileWriter.flush();
				fileWriter.close();
				
				int procesar = Integer.parseInt(session.getAttribute("totalProcesar").toString()) + 1;
				System.out.println("procesar: " + procesar);
				session.setAttribute("totalProcesar", procesar);
				
				if (comprobanteDao.findByUuid(respo.getUuid()) != null) {
					return errores;
				}
				
				
				DatosEmisor emisor1 = datosEmisorDao.findEmisor(tenant);
				if (!emisor1.getTipoPlan()) {//Es de plan anterior, entonces hay que descontar folios
					emisor1.setFoliosDisponibles(emisor1.getFoliosDisponibles() - 1);
					datosEmisorDao.update(emisor1);
				}
				
				CfdEmitido cfdEmitido = new CfdEmitido();
				cfdEmitido.setEliminado(false);
				cfdEmitido.setEnviado(false);
				cfdEmitido.setEstatus("emitido");
				cfdEmitido.setFechaDate(new Date());
				cfdEmitido.setRazonSocialReceptor(cfdi.getReceptor().getNombre());
				cfdEmitido.setRfcReceptor(cfdi.getReceptor().getRfc());
				cfdEmitido.setFormaDePago(cfdi.getFormaPago());
				cfdEmitido.setIva(0D);
				cfdEmitido.setSemaforo(false);
				cfdEmitido.setSubTotal(Double.parseDouble(cfdi.getSubTotal()));
				cfdEmitido.setTipoComprobante("N");
				cfdEmitido.setTotal(Double.parseDouble(cfdi.getTotal()));
				cfdEmitido.setUltimaActualizacion(new Date());
				cfdEmitido.setTenantId(tenant);
				cfdEmitido.setFechaRegistro(new Date());
				cfdEmitido.setUuid(respo.getUuid());
				cfdEmitido.setJson("EXCEL");
				if (cfdi.getComplemento()!=null && cfdi.getComplemento().getNomina12() != null){
					if (cfdi.getComplemento().getNomina12().getDeducciones() != null &&cfdi.getComplemento().getNomina12().getDeducciones().getTotalImpuestosRetenidos() != null){
						cfdEmitido.setIsr(Double.parseDouble(cfdi.getComplemento().getNomina12().getDeducciones().getTotalImpuestosRetenidos()));
					}
					else{
						cfdEmitido.setIsr(0.0);
					}
				}else{
					cfdEmitido.setIsr(Double.parseDouble(cfdi.getImpuestos().getTotalImpuestosRetenidos()));
				}
				
				cfdEmitido.setAnio(new Date().getYear()+1900);
				
		
				String urlPlantilla = parametroDao.findByClave("RUTA_PLANTILLAS").getValor();
				ConfiguracionPlantilla configuracionPlantilla = plantillaDao.find(tenant);
				int numPlantilla = 200; //Plantilla por default para nóminas
				if (configuracionPlantilla != null)
					numPlantilla =  configuracionPlantilla.getNomina();
				else{
					String strMensaje ="No hay información en ConfiguracionPlantilla para el rfc:  "+tenant+", se usa la plantilla genérica 200"; 
					log.info(strMensaje);
					enviarMail("desarrollo4@xpd.mx", "Error ConfiguracionPlantilla", strMensaje);
				}
				if (parametroDao.findByClave("RFC_NOMINA").getValor().equals(cfdi.getEmisor().getRfc())) {
					numPlantilla = Integer.parseInt(parametroDao.findByClave("PLANTILLA_NOMINA").getValor());
				}
				
				JasperReport report;
				if (cfdi.getComplemento()!=null&&cfdi.getComplemento().getNomina12()!=null){
					report = JasperCompileManager.compileReport(urlPlantilla + File.separatorChar + numPlantilla + "N12" + File.separatorChar + "plantilla.jrxml");
				}
				else{
					report = JasperCompileManager.compileReport(urlPlantilla + File.separatorChar + numPlantilla +  File.separatorChar + "plantilla.jrxml");
				}
				
				
				
				
				
	//			JasperReport report = (JasperReport) JRLoader.loadObject(plantilla);
				
						
		
				
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				dbf.setNamespaceAware(false);
				
				Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xmlResult.getBytes("UTF-8")));
				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("XML_DATA_DOCUMENT", doc);
	
				String moneda = cfdi.getMoneda();
				
				String cantidadLetra = "";
				log.info(moneda);
				try {
					cantidadLetra = new java.util.Scanner(new java.net.URL("http://portal.expidetufactura.com.mx:86/ws/numero_a_letra_ireport.php?numero="+cfdi.getTotal()).openStream()).nextLine();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (moneda != null && !moneda.equals("MXN") && !moneda.equalsIgnoreCase("PESO")) {
					cantidadLetra = cantidadLetra.substring(0, cantidadLetra.length() - 4) + moneda;
					cantidadLetra = cantidadLetra.replace("pesos", moneda);
				}
				String pathLogo = parametroDao.findByClave("PATH_IMG_LOGO").getValor() + tenant + ".png";
				
				
				
				String pathPdf = parametroDao.findByClave("PATH_EXTERNO_PDF_TIMBRADO").getValor();
				params.put("cantidadLetra", cantidadLetra);
				
				Double d = Double.parseDouble(cfdi.getTotal());
				String textQR = "re=" + cfdi.getEmisor().getRfc()
						+ "&rr=" + cfdi.getEmisor().getRfc()
						+ "&tt=" + (new DecimalFormat( "#########0.00000" ).format(d));
					textQR  += "&id=" + respo.getUuid();
				params.put("imagenQR", QRGenerator.getQR(textQR));
				
				if ((new File(pathLogo).exists())) {
					params.put("logo", pathLogo);
				}
				
				if (observaciones != null && !observaciones.isEmpty()) {
					params.put("observaciones", observaciones);
				}
				
	
				JasperPrint print = JasperFillManager.fillReport(report, params);
	
				ByteArrayOutputStream out = new ByteArrayOutputStream();
	//			
	//			JRExporter exporter = new JRPdfExporter();
	//			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);  
	//	        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);   
	//	        exporter.exportReport();
				
				File rutaPdfPath = new File( pathPdf + File.separatorChar + tenant + File.separatorChar);
				
				if (!rutaPdfPath.exists()) {
					rutaPdfPath.mkdir();
				}
				
				JasperExportManager.exportReportToPdfStream(print, out);
				String pathPDF = pathPdf + File.separatorChar + tenant + File.separatorChar + respo.getUuid() + ".pdf";
				log.info(pathPDF);
				FileOutputStream fP = new FileOutputStream(pathPDF);
	
				fP.write(out.toByteArray());
				fP.flush();
				fP.close();
				
				
				CfdEmitido tmp1 = comprobanteDao.findByUuid(respo.getUuid());
				if (respo.getCodigo().equals("200") || (respo.getCodigo().equals("504") && tmp1 == null)) {
					if (cfdi.getComplemento().getNomina12() != null){
						Empleado emp = empleadoDao.findByRfc(cfdi.getEmisor().getRfc(), cfdi.getReceptor().getRfc());
						if (emp != null ){
							if (emp.getEmail() !=null) {
								if (!emp.getEmail().equals("")){
									log.info("Se va a enviar el correo electronico de la nómina "+respo.getUuid()+".xml");
									String strSubject = "CFDI " + (cfdi.getFolio() == null ? "" : "No. " + cfdi.getFolio()) + 
											" de " + emisor.getRfc() + " para " +  cfdi.getReceptor().getRfc() + " con monto " + 
											NumberFormat.getCurrencyInstance().format(Double.parseDouble(cfdi.getTotal()));  
									String strCorreoEmisor = datosEmisorDao.findEmisor(cfdi.getEmisor().getRfc()).getEmail();
									
									String strCuerpoCorreo = configuracionDao.findAll(cfdi.getEmisor().getRfc()).getEmailConfig();
									
									if (enviarMailNomina(emp.getEmail(), strCorreoEmisor, cfdi.getEmisor().getRfc() ,respo.getUuid(), rutaXML.substring(0, 10), strSubject, strCuerpoCorreo)){
										cfdEmitido.setEnviado(true);
									}
									else{
										cfdEmitido.setEnviado(false);
									}
								}
							}
						}
					}
					else{
						Empleado emp = empleadoDao.findByRfc(cfdi.getEmisor().getRfc(), cfdi.getReceptor().getRfc());
						if (emp != null ){
							if (emp.getEmail() !=null) {
								if (!emp.getEmail().equals("")){
									log.info("Se va a enviar el correo electronico de la nómina "+respo.getUuid()+".xml");
									String strSubject = "CFDI " + (cfdi.getFolio() == null ? "" : "No. " + cfdi.getFolio()) + 
											" de " + emisor.getRfc() + " para " +  cfdi.getReceptor().getRfc() + " con monto " + 
											NumberFormat.getCurrencyInstance().format(Double.parseDouble(cfdi.getTotal()));  
									String strCorreoEmisor = datosEmisorDao.findEmisor(cfdi.getEmisor().getRfc()).getEmail();
								
									String strCuerpoCorreo = configuracionDao.findAll(cfdi.getEmisor().getRfc()).getEmailConfig();
								
									if (enviarMailNomina(emp.getEmail(), strCorreoEmisor, cfdi.getEmisor().getRfc() ,respo.getUuid(), rutaXML.substring(0, 10), strSubject, strCuerpoCorreo)){
										cfdEmitido.setEnviado(true);
									}
									else{
										cfdEmitido.setEnviado(false);
									}
								}
							}
						}
					}
					
					comprobanteDao.add(cfdEmitido);
				}
				
				
			} else {
				XSSFSheet sheet = WErr.getSheetAt(2);
						
				XSSFRow row =  sheet.createRow((short)fila.getRowNum());
				row.createCell(0).setCellValue(fila.getCell(0).toString());
				row.createCell(1).setCellValue(respo.getCodigo() + " - " + respo.getMensaje());
				
				row = fila;
						
				
				int procesar = Integer.parseInt(session.getAttribute("totalErrores").toString()) + 1;
				session.setAttribute("totalErrores", procesar);
				
				
				errores++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			errores++;
		}
		return errores;
	}
	
	public Deduccion validaDeduccion(String tipo, String con, String clave, String concepto, String importeGravado, String importeExento) {
		Deduccion deduccion = null;
		System.out.println(clave + " - " + concepto);
		String iG = getDouble(importeGravado);
		String iE = getDouble(importeExento);
		
		if (clave != null && (iG != null || iE != null)) {
			deduccion = new Deduccion();
			deduccion.setTipoDeduccion(tipo);
			deduccion.setClave(clave);
			deduccion.setConcepto((concepto == null || concepto.trim().isEmpty()) ? con : concepto);
			deduccion.setImporteGravado(iG == null ? "0" : iG);
			deduccion.setImporteExento(iE == null ? "0" : iE);
		}
		
		return deduccion;
	}
	
	
	public Percepcion validaPercepcion(String tipo, String con, String clave, String concepto, String importeGravado, String importeExento) {
		Percepcion percepcion = null;
		String iG = getDouble(importeGravado);
		String iE = getDouble(importeExento);
		
		if (iG != null || iE != null) {
			percepcion = new Percepcion();
			percepcion.setTipoPercepcion(tipo);
			percepcion.setClave(clave);
			percepcion.setConcepto(concepto == null || concepto.trim().isEmpty() ? con : concepto);
			percepcion.setImporteGravado(iG == null ? "0" : iG);
			percepcion.setImporteExento(iE == null ? "0" : iE);
		}
		
		return percepcion;
	}
	
	public mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Percepcion validaPercepcion12(String tipo, String con, String clave, String concepto, String importeGravado, String importeExento) {
		mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Percepcion percepcion = null;
		String iG = getDouble(importeGravado);
		String iE = getDouble(importeExento);
		
		if (iG != null || iE != null) {
			percepcion = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Percepcion();
			percepcion.setTipoPercepcion(tipo);
			percepcion.setClave(clave);
			percepcion.setConcepto(concepto == null || concepto.trim().isEmpty() ? con : concepto);
			percepcion.setImporteGravado(iG == null ? "0" : iG);
			percepcion.setImporteExento(iE == null ? "0" : iE);
		}
		
		return percepcion;
	}
	
	public mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Deduccion validaDeduccion12(String tipo, String con, String clave, String concepto, String importe) {
		mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Deduccion deduccion = null;
		String importeD = getDouble(importe);
		
		if (clave != null && (importeD != null )) {
			deduccion = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.Deduccion();
			deduccion.setTipoDeduccion(tipo);
			deduccion.setClaveDeduccion(clave);
			deduccion.setConceptoDeduccion((concepto == null || concepto.trim().isEmpty()) ? con : concepto);
			deduccion.setImporteDeduccion(importeD == null ? "0" : importeD);
			
		}
		
		return deduccion;
	}
	
	public mx.xpd.cfdi.domain.cfdi.complementos.nomina12.OtroPago validaOtroPago12(String tipo, String con, String clave, String concepto, String importe) {
		mx.xpd.cfdi.domain.cfdi.complementos.nomina12.OtroPago otroPago = null;
		String importeP = getDouble(importe);
		
		if (clave != null && (importeP != null )) {
			otroPago = new mx.xpd.cfdi.domain.cfdi.complementos.nomina12.OtroPago();
			otroPago.setTipoOtroPago(tipo);
			otroPago.setClaveOtroPago(clave);
			otroPago.setConceptoOtroPago((concepto == null || concepto.trim().isEmpty()) ? con : concepto);
			otroPago.setImporteOtroPago(importeP == null ? "0" : importeP);
			
		}
		
		return otroPago;
	}
	
	
	
	public String getDouble(String  numero) {
		if (numero == null || numero.isEmpty()) {
			return null;
		}
		try {
			//Double ret = Double.parseDouble(numero);
			DecimalFormat df = new DecimalFormat("########.######");
			return df.format(Double.parseDouble(numero));
		} catch(Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> getParams(ComprobantePDF cfdi) {
		return this.getParams(cfdi, null);
	}
	
	public Map<String, Object> getParams(ComprobantePDF cfdi, String tipoComprobante) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tipoComprobante", (tipoComprobante == null ? "PRE-FACTURA" : tipoComprobante));
		
		// cfdi.setTotal(("" + cfdi.getTotal()).replace(".", "\n"));
		
		String total = "" + cfdi.getTotal();
		
		log.info(total.substring(total.indexOf(".")));
		if (total.substring(total.indexOf(".")).length() == 1) {
			total += "0";
		}
		NumberConverter NumberConverter1 = new NumberConverter();
		String cantidadLetra = "";
		try {
			cantidadLetra = new java.util.Scanner(new java.net.URL("http://portal.expidetufactura.com.mx:86/ws/numero_a_letra_ireport.php?numero="+total).openStream()).nextLine();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
				
				//NumberConverter1.convertNumberToLetter(total);
		
		if (cfdi.getMoneda() != null && !cfdi.getMoneda().equals("MXN") && !cfdi.getMoneda().equalsIgnoreCase("PESO")) {
			cantidadLetra = cantidadLetra.substring(0, cantidadLetra.length() - 4) + cfdi.getMoneda();
			cantidadLetra = cantidadLetra.replace("pesos", cfdi.getMoneda());
			
		}
		cantidadLetra = cantidadLetra.toUpperCase();
		params.put("cantidadLetra", cantidadLetra); 
		String textQR = "?re=" + cfdi.getEmisor().getRfc()
				+ "&rr=" + cfdi.getReceptor().getRfc()
				+ "&tt=" + (new DecimalFormat( "#########0.000000" ).format(cfdi.getTotal()));
		if (cfdi.getComplemento() != null && cfdi.getComplemento().getTimbreFiscalDigital() != null) {
			textQR  += "&id=" + cfdi.getComplemento().getTimbreFiscalDigital().getUuid();
			//log.info(textQR);
		} else {
			textQR  += "&id=Comprobante sin timbrar.";
		}
		params.put("imagenQR", QRGenerator.getQR(textQR));
		return params;
	}
	
	public void checarCarpeta(File file) {
		if (!file.exists()) {
			file.mkdir();
		}
	}
	
	private ComprobantePDF generaPDF(ComprobantePDF cfdi, OutputStream out, String tenant) {
		return generaPDF(cfdi, out, null, tenant);
	}
	
	private ComprobantePDF getComprobantePDF(String strComprobante, String tenant) {
		Gson gson = new Gson();
		ComprobantePDF cfdi  = gson.fromJson(strComprobante,  ComprobantePDF.class);	
		return cfdi;
	}
	
	private ComprobantePDF generaPDF(ComprobantePDF cfdi, OutputStream out, File xmlFile, String tenant) {
		try {
			plantillaDao.setTenantId(tenant);
			ConfiguracionPlantilla plantilla = plantillaDao.find(tenant);
			
			
			
			String tipoCfdi;
			
			if (plantilla == null) {
				plantilla = new ConfiguracionPlantilla();
			}
			int numPlantilla;
			String xt = cfdi.getTipoDeComprobante();
			/*
			switch () {
				case "rh" : tipoCfdi = "RECIBO DE HONORARIOS"; 
							numPlantilla = plantilla.getReciboHonorarios(); break;
				case "ra" : tipoCfdi = "RECIBO DE ARRENDAMIENTO"; 
							numPlantilla = plantilla.getFactura(); break;
				case "ca" : tipoCfdi = "NOTA DE CARGO"; 
							numPlantilla = plantilla.getNotaCargo(); break;
				case "cp" : tipoCfdi = "CARTA PORTE"; 
							numPlantilla = plantilla.getCartaPorte(); break;
				case "cr" : tipoCfdi = "NOTA DE CRÉDITO";
							numPlantilla = plantilla.getNotaCredito(); break;
				case "rd" : tipoCfdi = "RECIBO DE DONATIVO"; 
							numPlantilla = plantilla.getFactura(); break;
				case "fa" : 
				default: tipoCfdi = "FACTURA";
						numPlantilla = plantilla.getFactura(); break;
			}
			*/									
			tipoCfdi = "";
			numPlantilla = 0;
		if ("rh".equals(xt)) {
			tipoCfdi = "RECIBO DE HONORARIOS";
			numPlantilla = plantilla.getReciboHonorarios();
		} else if("ra".equals(xt)) { 
			tipoCfdi = "RECIBO DE ARRENDAMIENTO";
			numPlantilla = plantilla.getFactura(); 
		} else if ("ca".equals(xt)) {
			tipoCfdi = "NOTA DE CARGO";
			numPlantilla = plantilla.getNotaCargo(); 
		} else if ("cp".equals(xt)) {
			tipoCfdi = "CARTA PORTE";
			numPlantilla = plantilla.getCartaPorte(); 
		} else if ("cr".equals(xt)) {
			tipoCfdi = "NOTA DE CREDITO";
			numPlantilla = plantilla.getNotaCredito(); 
		} else if ("ct".equals(xt)) {
			tipoCfdi = "CONSTANCIA DE RETENCION";
			numPlantilla = plantilla.getNotaCredito(); 
		} else if ("rd".equals(xt)) { 
			tipoCfdi = "RECIBO DE DONATIVO";
			numPlantilla = plantilla.getFactura();
		} else if ("rn".equals(xt)) {
			tipoCfdi = "RECIBO DE NOMINA";
			numPlantilla =  200;	
		} else {
			tipoCfdi = "FACTURA";
			numPlantilla =  plantilla.getFactura();
		}
		
		if ("rn".equals(xt) && parametroDao.findByClave("RFC_NOMINA").getValor().equals(cfdi.getEmisor().getRfc())) {
			numPlantilla = Integer.parseInt(parametroDao.findByClave("PLANTILLA_NOMINA").getValor());
		}
		
			cfdi.setTipoComprobante(tipoCfdi);
			// DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");		
			// cfdi.setFecha(df.format(new Date()));
			cfdi.setVersion(parametroDao.findByClave("VERSION_XML").getValor());
			
			ConfiguracionCFDI config = configuracionDao.findAll(tenant);
			
			//SE QUITA LO DE ExpedidoEn
			
			Map<String, Object> params = null;
			
			/*******************************/
			if (xmlFile != null) {
				if (cfdi.getComplemento() == null) {
					cfdi.setComplemento(new mx.xpd.cfdi.domain.cfdi.pdf.Complemento());
				}
				cfdi.getComplemento().setTimbreFiscalDigital(ComprobantePDFUtil.getTimbre(xmlFile));
				csdDao.setTenantId(tenant);
				cfdi.setNoCertificado(csdDao.findCurrent(tenant).getNoSerie());
				params = this.getParams(cfdi, cfdi.getTipoComprobante());
				
			} else {
				params = this.getParams(cfdi);
			}
			
			String pathLogo = parametroDao.findByClave("PATH_IMG_LOGO").getValor() + tenant + ".png";
			File logoFile = new File(pathLogo);
			
			if (logoFile.exists()) {
				params.put("logo", logoFile.getAbsolutePath());
			} 
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    dbf.setNamespaceAware(true);
		    Document doc = dbf.newDocumentBuilder().newDocument();
		    JAXBContext jaxbContext = JAXBContext.newInstance(ComprobantePDF.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd");
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(cfdi, doc);
			StringWriter strXML = new StringWriter(); 
			jaxbMarshaller.marshal(cfdi, strXML);
			jaxbMarshaller.marshal(cfdi, System.out);
			
			// log.info(strXML.toString());
			String urlPlantilla = parametroDao.findByClave("RUTA_PLANTILLAS").getValor();
			
			
			if (cfdi.getTipoDeComprobante().equals("cp")) {
				urlPlantilla += "/" + numPlantilla + "/cartaPorte.jrxml";
			} else {
				urlPlantilla += "/" + numPlantilla + "/plantilla.jrxml";
			}
			params.put("observaciones", cfdi.getObservaciones());
			PDFExporter.xmlToPDF(urlPlantilla, params, doc, out);
			return cfdi;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String cleanCertificate(String cer) {
		return cer.replace("-----BEGIN CERTIFICATE-----",	"").replace("-----END CERTIFICATE-----", "")
				.replace("-----BEGIN RSA PRIVATE KEY-----",	"").replace("-----END RSA PRIVATE KEY-----", "")
				.replace("-----END PRIVATE KEY-----", "").replace("-----BEGIN PRIVATE KEY-----", "").trim();
	}
	
	public boolean enviarMailNomina(String mailEmpleado, String mailEmisor, String tenantID, String uuid, String ruta, String strSubject, String strCuerpoCorreo) throws javax.mail.SendFailedException{
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
			message.setFrom(new InternetAddress( "portal@xpd.mx" ));
			
			InternetAddress [] arregloReplyTo = new InternetAddress[1];
			arregloReplyTo[0] = new InternetAddress(mailEmisor);
			
			message.setReplyTo(arregloReplyTo);			
			
			InternetAddress [] arregloDestinatarios = new InternetAddress[1];
			arregloDestinatarios[0] = new InternetAddress(mailEmpleado);
			
			
			message.setRecipients(Message.RecipientType.TO,	arregloDestinatarios);
			message.setSubject(strSubject);
			
			Multipart mp = new MimeMultipart();
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
			banner    = strCuerpoCorreo;
			texto.setContent(banner, "text/html");
			
			mp.addBodyPart(texto);
			ruta = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();
			String rutaXML = ruta + File.separatorChar + tenantID + File.separatorChar;
			rutaXML+= uuid + ".xml";
			ruta = parametroDao.findByClave("PATH_EXTERNO_PDF_TIMBRADO").getValor();
			String rutaPDF = ruta + File.separatorChar + tenantID + File.separatorChar;
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
			log.info("Archivo enviado: "+rutaXML+" al correo "+mailEmpleado);
			return true;
		} catch (Exception e) {
			log.info("cacho una excepcion : " +  e.getMessage());
			e.printStackTrace();
			log.debug("Error enviando correo electronico = "+e.getMessage());
			return false;
			//e.printStackTrace();
		}
	}
	
	public boolean enviarMail(String mailDestino, String strSubject, String strCuerpoCorreo) throws javax.mail.SendFailedException{
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
			message.setFrom(new InternetAddress( "portal@xpd.mx" ));
			
			InternetAddress [] arregloReplyTo = new InternetAddress[1];
			
			InternetAddress [] arregloDestinatarios = new InternetAddress[1];
			arregloDestinatarios[0] = new InternetAddress(mailDestino);
			
			
			message.setRecipients(Message.RecipientType.TO,	arregloDestinatarios);
			message.setSubject(strSubject);
			
			Multipart mp = new MimeMultipart();
			String banner = strCuerpoCorreo;
			// Texto del mensaje
			BodyPart texto = new MimeBodyPart();
			texto.setContent(banner, "text/html");
			
			mp.addBodyPart(texto);
			
			message.setContent(mp);
			message.saveChanges();
			// Enviar el mensaje
			Transport.send(message);
			
			return true;
		} catch (Exception e) {
			log.info("cacho una excepcion : " +  e.getMessage());
			e.printStackTrace();
			log.debug("Error enviando correo electronico = "+e.getMessage());
			return false;
			//e.printStackTrace();
		}
	}

}
