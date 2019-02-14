package mx.xpd.cfdi.mvc;


import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
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
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;

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
import javax.naming.spi.ObjectFactory;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;

import mx.xpd.cfdi.constantes.URLConstants;
import mx.xpd.cfdi.domain.Addenda;
import mx.xpd.cfdi.domain.CatalogosNomina;
import mx.xpd.cfdi.domain.CertificadoSelloDigital;
import mx.xpd.cfdi.domain.CfdEmitido;
import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.ComprobanteNoTimbrado;
import mx.xpd.cfdi.domain.ConfiguracionCFDI;
import mx.xpd.cfdi.domain.ConfiguracionPlantilla;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.Email;
import mx.xpd.cfdi.domain.Empleado;
import mx.xpd.cfdi.domain.LugarExpedicion;
import mx.xpd.cfdi.domain.ProductoServicio;
import mx.xpd.cfdi.domain.RegimenFiscal;
import mx.xpd.cfdi.domain.RetencionesEmitido;
import mx.xpd.cfdi.domain.RetencionesNoTimbrado;
import mx.xpd.cfdi.domain.RfcCuentasPorPagar;
import mx.xpd.cfdi.domain.cfdi.Comprobante;
import mx.xpd.cfdi.domain.cfdi.Conceptos;
import mx.xpd.cfdi.domain.cfdi.Emisor;
import mx.xpd.cfdi.domain.cfdi.Impuestos;
import mx.xpd.cfdi.domain.cfdi.Receptor;
import mx.xpd.cfdi.domain.cfdi.Retencion;
import mx.xpd.cfdi.domain.cfdi.Retenidos;
import mx.xpd.cfdi.domain.prefactura.CfdiRelacionado;
import mx.xpd.cfdi.domain.prefactura.ConstantesPrefactura;
import mx.xpd.cfdi.domain.prefactura.InformacionAduanera;
import mx.xpd.cfdi.domain.prefactura.Parte;
import mx.xpd.cfdi.domain.prefactura.Prefactura;
import mx.xpd.cfdi.domain.prefactura.ReadXMLFile;
import mx.xpd.cfdi.domain.prefactura.ResponsePrefactura;
import mx.xpd.cfdi.domain.prefactura.Traslado;
import mx.xpd.cfdi.domain.prefactura.ValidadorXml;
import mx.xpd.cfdi.domain.retenciones.Retenciones;
import mx.xpd.cfdi.domain.cfdi.TUbicacion;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.AlternateTradeItemIdentification;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.GrossPrice;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.NetPrice;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TotalLineAmount;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TotalLineAmount.GrossAmount;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TotalLineAmount.NetAmount;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TradeItemDescriptionInformation;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.LineItem.TradeItemIdentification;
import mx.xpd.cfdi.domain.cfdi.complementos.detallista.Detallista.SpecialInstruction;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Deduccion;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Deducciones;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Nomina;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Percepcion;
import mx.xpd.cfdi.domain.cfdi.complementos.nomina.Percepciones;
import mx.xpd.cfdi.domain.cfdi.pdf.Complemento;
import mx.xpd.cfdi.domain.retenciones.pdf.ComplementoRetenciones;
import mx.xpd.cfdi.domain.cfdi.pdf.ComprobantePDF;
import mx.xpd.cfdi.domain.cfdi.pdf.Concepto;
import mx.xpd.cfdi.domain.retenciones.pdf.RetencionesPDF;
import mx.xpd.cfdi.repo.CatalogoClaveUnidadDao;
import mx.xpd.cfdi.repo.CatalogoFormaPagoDao;
import mx.xpd.cfdi.repo.CatalogoImpuestoDao;
import mx.xpd.cfdi.repo.CatalogoMetodoPagoDao;
import mx.xpd.cfdi.repo.CatalogoMonedaDao;
import mx.xpd.cfdi.repo.CatalogoRegimenFiscalDao;
import mx.xpd.cfdi.repo.CatalogoTipoRelacionDao;
import mx.xpd.cfdi.repo.CatalogoUsoCFDIDao;
import mx.xpd.cfdi.repo.CatalogoZonaHorariaDao;
import mx.xpd.cfdi.repo.CertificadoSelloDigitalDao;
import mx.xpd.cfdi.repo.ClienteDao;
import mx.xpd.cfdi.repo.ColoniaDao;
import mx.xpd.cfdi.repo.ComprobanteDao;
import mx.xpd.cfdi.repo.CuentasPorPagarDAO;
import mx.xpd.cfdi.repo.EmpleadoDao;
import mx.xpd.cfdi.repo.FraccionArancelariaDao;
import mx.xpd.cfdi.repo.RetencionesDao;
import mx.xpd.cfdi.repo.ConfiguracionCFDIDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.LugarExpedicionDao;
import mx.xpd.cfdi.repo.PaisEstadoDao;
import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.repo.PlantillaDao;
import mx.xpd.cfdi.repo.ProductoServicioDao;
import mx.xpd.cfdi.repo.RegimenFiscalDao;
import mx.xpd.cfdi.repo.UnidadMedidaComercioExteriorDao;
import mx.xpd.cfdi.timbrado.service.Timbrado;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceSoapBindingStub;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceStub.RespuestaTimbrado;
import mx.xpd.cfdi.util.ComprobantePDFUtil;
import mx.xpd.cfdi.util.ComprobanteRetencionesPDFUtil;
import mx.xpd.cfdi.util.FechasUtil;
import mx.xpd.cfdi.util.JaxbContextSingletonHelper;
import mx.xpd.cfdi.util.NumberConverter;
import mx.xpd.cfdi.util.PDFExporter;
import mx.xpd.cfdi.util.PrefacturaUtil;
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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.text.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.codec.binary.Base64;

@Controller
@RequestMapping(value = "/comprobante")
public class ComprobanteController {
	
	private final static String regimenContratacion = "regimenContratacion";
	private final static String riesgoPuesto = "riesgoPuesto";
	private final static String tipoJornada = "tipoJornada";
	private final static String tipoContrato = "tipoContrato";
	private final static String banco = "banco";
	
	private final static String tipoNomina = "tipoNomina";
	private final static String origenRecurso = "origenRecurso";
	private final static String tipoRegimen = "tipoRegimen";
	private final static String periodicidadPago = "periodicidadPago";
	private final static String tipoPercepcion = "tipoPercepcion";
	private final static String tipoHoras = "tipoHoras";
	private final static String tipoDeduccion = "tipoDeduccion";
	private final static String tipoOtroPago = "tipoOtroPago";
	private final static String tipoIncapacidad = "tipoIncapacidad";
	
	 
	private Logger log = Logger.getLogger(ComprobanteController.class);

	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private DatosEmisorDao datosEmisorDao;
	@Autowired
	private ConfiguracionCFDIDao configuracionDao;
	@Autowired
	private ComprobanteDao comprobanteDao;
	@Autowired
	private RetencionesDao retencionesDao;
	@Autowired
	private CertificadoSelloDigitalDao csdDao;
	@Autowired
	private RegimenFiscalDao regimenFiscalDao;
	@Autowired
	private CatalogoRegimenFiscalDao catalogoRegimenFiscalDao;
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
	private CuentasPorPagarDAO cuentasPorPagarDAO;
	@Autowired
	private EmpleadoDao empleadoDao;
	@Autowired
	private ConfiguracionCFDIDao configuracionCFDIDao;
	@Autowired
	private FraccionArancelariaDao fraccionArancelariaDao;
	@Autowired
	private UnidadMedidaComercioExteriorDao unidadMedidaComercioExtDao;
	@Autowired
	private ColoniaDao coloniaDao;
	@Autowired
	private CatalogoMonedaDao catalogoMonedaDao;
	@Autowired
	private CatalogoClaveUnidadDao catalogoClaveUnidadDao;
	@Autowired
	private CatalogoFormaPagoDao catalogoFormaPagoDao;
	@Autowired
	private CatalogoMetodoPagoDao catalogoMetodoPagoDao;
	@Autowired
	private CatalogoTipoRelacionDao catalogoTipoRelacionDao;
	@Autowired
	private CatalogoUsoCFDIDao catalogoUsoCFDIDao;
	@Autowired
	private CatalogoImpuestoDao catalogoImpuestoDao;
	@Autowired
	private CatalogoZonaHorariaDao catalogoZonaHorariaDao;
	
	private FechasUtil fechasUtil;
		
	public boolean validarLCO(String rfc) { 
		try {
			String url = parametroDao.findByClave("URL_LCO").getValor() + rfc;
			// "http://timbrado.expidetufactura.com.mx:8080/LCO/rest/certificado/user/pwd/w";
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("GET");
			
			String result = new String(IOUtils.toByteArray(con.getInputStream()));
			
			if (result == null || result.equals("")) {
				return false;
			} else if (Integer.parseInt(result.substring(0, 3)) == 200) {
				return true;
			} 
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	
	@RequestMapping(value = "/reporte/{anio}/{mes}", method = RequestMethod.GET, produces = "application/vnd.ms-excel")
	 public void mostrarReporte(@PathVariable String anio,
			   @PathVariable String mes, Model model, HttpServletResponse response, 
			    HttpServletRequest request) throws JRException, IOException { 

		String urlPlantilla = "/home/cfdi/plantillas/cfdi.jrxml";
		
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		List<CfdEmitido> cfdis = comprobanteDao.findByDates(tenantID, anio,mes);
		
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
	
	@RequestMapping(value = "/nomina", method = RequestMethod.GET)
	public String nomina(Model model, HttpServletRequest request) throws ParseException {		
		return mostrar("tn", model, request);
	}
	 
	@RequestMapping(value = "/facturarPba/{tipoFactura}", method = RequestMethod.GET)
	public String mostrarPrueba(@PathVariable String tipoFactura, Model model, HttpServletRequest request) throws ParseException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		configuracionDao.setTenantId(tenantID);
		ConfiguracionCFDI config = configuracionDao.findAll(tenantID);
		datosEmisorDao.setTenantId(tenantID);
		DatosEmisor datos = datosEmisorDao.findEmisor(tenantID);
		if(datos.getPaso()== 0){
			return "redirect:/manifiesto";
		}
		lugarDao.setTenantId(tenantID);
		LugarExpedicion lugarExp = lugarDao.findLugarExpedicion(tenantID);
		if (lugarExp == null){
			return "redirect:/pasos/lugarExpedicion";
		}
		if (datos.getPaso() < 5) {
/*			
			if (datos.isProductivo() == false || validarLCO(datos.getRfc())) {
				datos.setPaso(5);
				datosEmisorDao.setTenantId(tenantID);
				datosEmisorDao.update(datos);
			} else {
				return "redirect:/pasos/lco";
			}
*/			
		}
		csdDao.setTenantId(tenantID);
		if (csdDao.findCurrent(tenantID) == null) {
			return "redirect:/pasos/certificado";
		}
		
		model.addAttribute("secure", request.isSecure());
		
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
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		if (tipoFactura.equals("rp")) {
			df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		}
		
		model.addAttribute("configuracion",config);
		if(config.getComplementosConfig().length() > 0) {
			String[] Campos = {
					"addenda",
					"firmas",
					"descuento",
					"impuestosLocalesYFederales",
					"detallista",
					"renovacionSustitucionVehiculos",
					"registroFiscal",
					"donatorias",
					"pagoEspecie",
					"notariosPublicos",
					"consumoCombustible",
					"vehiculoUsado",
					"valesDespensa",
					"serviciosParcialesConstruccion",
					"aerolineas",
					"divisas",
					"turistaPasajeroExtranjero",
					"personaFisicaIntegranteCoordinado",
					"ine",
					"leyendasFiscales",
					"enajenacionObrasArtesPlasticasAntiguedades",
					"certificadoDestruccion",
					"estadoCuentaCombustiblesMonederosElectronicosAutorizadosSAT12",
					"comercioExterior11",
					"conceptoCuentaTerceros",
					"conceptoInstitucionesEducativasPrivadas",
					"conceptoVentaVehiculos"
				};
			JsonParser parser = new JsonParser();
			JsonObject complementosConf = parser.parse(config.getComplementosConfig()).getAsJsonObject();
			
			for(String element: Campos) {
				if(complementosConf.has(element)) {
					model.addAttribute(element, true);
				} else {
					model.addAttribute(element, false);
				}
			}
		}
		model.addAttribute("regimenes", catalogoRegimenFiscalDao.findAll());
		lugarDao.setTenantId(tenantID);
		model.addAttribute("mapLugaresExpedicion", lugarDao.findAllMap());
		model.addAttribute("regimenes", catalogoRegimenFiscalDao.findAll());
		model.addAttribute("listaUnidades", catalogoClaveUnidadDao.findAll());
		model.addAttribute("formasPago", catalogoFormaPagoDao.findAll());
		model.addAttribute("metodosPago", catalogoMetodoPagoDao.findAll());
		model.addAttribute("tipoRelaciones", catalogoTipoRelacionDao.findAll());
		model.addAttribute("usosCFDI", catalogoUsoCFDIDao.findAll());
		model.addAttribute("listaImpuestos", catalogoImpuestoDao.findAll());
				
		if (tipoFactura.equals("rn")) {
			model.addAttribute("fecha", df.format(new Date()));
			model.addAttribute("datosE",datos);
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("paises", paisEstadosDao.findAllPais());
			model.addAttribute("estados", paisEstadosDao.findAllEstado());
			model.addAttribute("metodosPago", catalogoMetodoPagoDao.findAll());
			model.addAttribute("tipoComprobante", tipoFactura);
			model.addAttribute("tenantID", tipoFactura);
			model.addAttribute("regimenContratacion", comprobanteDao.findCatalogo(regimenContratacion));
			model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogo(riesgoPuesto));
			model.addAttribute("tipoJornada", comprobanteDao.findCatalogo(tipoJornada));
			model.addAttribute("tipoContrato", comprobanteDao.findCatalogo(tipoContrato));
			model.addAttribute("banco", comprobanteDao.findCatalogo(banco));
		}
		if (tipoFactura.equals("tn")) {
			model.addAttribute("fecha", df.format(new Date()));
			model.addAttribute("datosE",datos);
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("tipoNomina", comprobanteDao.findCatalogoNomina(tipoNomina));
			model.addAttribute("origenRecurso", comprobanteDao.findCatalogoNomina(origenRecurso));
			model.addAttribute("tipoContrato", comprobanteDao.findCatalogoNomina(tipoContrato));
			model.addAttribute("tipoJornada", comprobanteDao.findCatalogoNomina(tipoJornada));
			model.addAttribute("tipoRegimen", comprobanteDao.findCatalogoNomina(tipoRegimen));
			model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogoNomina(riesgoPuesto));
			model.addAttribute("periodicidadPago", comprobanteDao.findCatalogoNomina(periodicidadPago));
			model.addAttribute("banco", comprobanteDao.findCatalogoNomina(banco));
			model.addAttribute("claveEntFed", paisEstadosDao.findAllEstado());
			model.addAttribute("tipoPercepcion", comprobanteDao.findCatalogoNomina(tipoPercepcion));
			model.addAttribute("tipoHoras", comprobanteDao.findCatalogoNomina(tipoHoras));
			model.addAttribute("tipoDeduccion", comprobanteDao.findCatalogoNomina(tipoDeduccion));
			model.addAttribute("tipoOtroPago", comprobanteDao.findCatalogoNomina(tipoOtroPago));
			model.addAttribute("tipoIncapacidad", comprobanteDao.findCatalogoNomina(tipoIncapacidad));
			model.addAttribute("tipoComprobante", tipoFactura);
			model.addAttribute("tenantID", tipoFactura);
		
		}else{
			model.addAttribute("fecha", df.format(new Date()));
			model.addAttribute("datosE",datos);
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("paises", paisEstadosDao.findAllPais());
			model.addAttribute("estados", paisEstadosDao.findAllEstado());
			model.addAttribute("metodosPago", catalogoMetodoPagoDao.findAll());
			model.addAttribute("tipoComprobante", tipoFactura);
			model.addAttribute("tenantID", tipoFactura);
			model.addAttribute("regimenContratacion", comprobanteDao.findCatalogo(regimenContratacion));
			model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogo(riesgoPuesto));
			model.addAttribute("tipoJornada", comprobanteDao.findCatalogo(tipoJornada));
			model.addAttribute("tipoContrato", comprobanteDao.findCatalogo(tipoContrato));
			model.addAttribute("banco", comprobanteDao.findCatalogo(banco));
			
			model.addAttribute("estadoComercioExt", paisEstadosDao.findAllEstado());
			model.addAttribute("fraccionesArancelarias", fraccionArancelariaDao.findAll());
			model.addAttribute("unidadesMedidaComercioExt", unidadMedidaComercioExtDao.findAll());
		}
		
		if (datos.getTipoPlan() == true)
			model.addAttribute("fechaVencimiento", datos.getFechaVencimiento().substring(0, 10));
		else{
			String strUltimaCompra = datos.getUltimaCompra();
			if (strUltimaCompra != null){
				strUltimaCompra = strUltimaCompra.substring(0, 11);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					
					Calendar calVigencia = Calendar.getInstance();
					calVigencia.setTime(formatter.parse(strUltimaCompra));
					calVigencia.add(Calendar.YEAR,1);
					
					strUltimaCompra = formatter.format(calVigencia.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.addAttribute("ultimaCompra", strUltimaCompra);
			}
		}
			
		
		if (tipoFactura.equals("cp")) {
			return "/cfdi";
		} else if (tipoFactura.equals("rp")) {
			return "retenciones/form";
		} else if (tipoFactura.equals("tn")) {
			return "nomina/form";
		} 
		
		return "/cfdi.xhtml";
	}
	@RequestMapping(value = "/retenciones", method = RequestMethod.GET)
	public String retenciones(Model model, HttpServletRequest request) throws ParseException {
		return mostrar("rp", model, request);
	}
	 
	@RequestMapping(value = "/{tipoFactura}", method = RequestMethod.GET)
	public String mostrar(@PathVariable String tipoFactura, Model model, HttpServletRequest request) throws ParseException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		configuracionDao.setTenantId(tenantID);
		ConfiguracionCFDI config = configuracionDao.findAll(tenantID);
		datosEmisorDao.setTenantId(tenantID);
		DatosEmisor datos = datosEmisorDao.findEmisor(tenantID);
		if(datos.getPaso()== 0){
			return "redirect:/manifiesto";
		}
		lugarDao.setTenantId(tenantID);
		LugarExpedicion lugarExp = lugarDao.findLugarExpedicion(tenantID);
		if (lugarExp == null){
			return "redirect:/pasos/lugarExpedicion";
		}
		if (datos.getPaso() < 5) {
/*			
			if (datos.isProductivo() == false || validarLCO(datos.getRfc())) {
				datos.setPaso(5);
				datosEmisorDao.setTenantId(tenantID);
				datosEmisorDao.update(datos);
			} else {
				return "redirect:/pasos/lco";
			}
*/			
		}
		csdDao.setTenantId(tenantID);
		if (csdDao.findCurrent(tenantID) == null) {
			return "redirect:/pasos/certificado";
		}
		
		model.addAttribute("secure", request.isSecure());
		
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
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		if (tipoFactura.equals("rp")) {
			df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		}
		
		model.addAttribute("configuracion",config);
		if(config.getComplementosConfig().length() > 0) {
			String[] Campos = {
					"addenda",
					"firmas",
					"descuento",
					"impuestosLocalesYFederales",
					"detallista",
					"renovacionSustitucionVehiculos",
					"registroFiscal",
					"donatorias",
					"pagoEspecie",
					"notariosPublicos",
					"consumoCombustible",
					"vehiculoUsado",
					"valesDespensa",
					"serviciosParcialesConstruccion",
					"aerolineas",
					"divisas",
					"turistaPasajeroExtranjero",
					"personaFisicaIntegranteCoordinado",
					"ine",
					"leyendasFiscales",
					"enajenacionObrasArtesPlasticasAntiguedades",
					"certificadoDestruccion",
					"estadoCuentaCombustiblesMonederosElectronicosAutorizadosSAT12",
					"comercioExterior11",
					"conceptoCuentaTerceros",
					"conceptoInstitucionesEducativasPrivadas",
					"conceptoVentaVehiculos"
				};
			JsonParser parser = new JsonParser();
			JsonObject complementosConf = parser.parse(config.getComplementosConfig()).getAsJsonObject();
			
			for(String element: Campos) {
				if(complementosConf.has(element)) {
					model.addAttribute(element, true);
				} else {
					model.addAttribute(element, false);
				}
			}
		}
		model.addAttribute("regimenes", catalogoRegimenFiscalDao.findAll());
		lugarDao.setTenantId(tenantID);
		model.addAttribute("mapLugaresExpedicion", lugarDao.findAllMap());
		model.addAttribute("regimenes", catalogoRegimenFiscalDao.findAll());
		model.addAttribute("listaUnidades", catalogoClaveUnidadDao.findAll());
		model.addAttribute("formasPago", catalogoFormaPagoDao.findAll());
		model.addAttribute("metodosPago", catalogoMetodoPagoDao.findAll());
		model.addAttribute("tipoRelaciones", catalogoTipoRelacionDao.findAll());
		model.addAttribute("usosCFDI", catalogoUsoCFDIDao.findAll());
		model.addAttribute("listaImpuestos", catalogoImpuestoDao.findAll());
				
		if (tipoFactura.equals("rn")) {
			model.addAttribute("fecha", df.format(new Date()));
			model.addAttribute("datosE",datos);
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("paises", paisEstadosDao.findAllPais());
			model.addAttribute("estados", paisEstadosDao.findAllEstado());
			model.addAttribute("metodosPago", catalogoMetodoPagoDao.findAll());
			model.addAttribute("tipoComprobante", tipoFactura);
			model.addAttribute("tenantID", tipoFactura);
			model.addAttribute("regimenContratacion", comprobanteDao.findCatalogo(regimenContratacion));
			model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogo(riesgoPuesto));
			model.addAttribute("tipoJornada", comprobanteDao.findCatalogo(tipoJornada));
			model.addAttribute("tipoContrato", comprobanteDao.findCatalogo(tipoContrato));
			model.addAttribute("banco", comprobanteDao.findCatalogo(banco));
		}
		if (tipoFactura.equals("tn")) {
			model.addAttribute("fecha", df.format(new Date()));
			model.addAttribute("datosE",datos);
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("tipoNomina", comprobanteDao.findCatalogoNomina(tipoNomina));
			model.addAttribute("origenRecurso", comprobanteDao.findCatalogoNomina(origenRecurso));
			model.addAttribute("tipoContrato", comprobanteDao.findCatalogoNomina(tipoContrato));
			model.addAttribute("tipoJornada", comprobanteDao.findCatalogoNomina(tipoJornada));
			model.addAttribute("tipoRegimen", comprobanteDao.findCatalogoNomina(tipoRegimen));
			model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogoNomina(riesgoPuesto));
			model.addAttribute("periodicidadPago", comprobanteDao.findCatalogoNomina(periodicidadPago));
			model.addAttribute("banco", comprobanteDao.findCatalogoNomina(banco));
			model.addAttribute("claveEntFed", paisEstadosDao.findAllEstado());
			model.addAttribute("tipoPercepcion", comprobanteDao.findCatalogoNomina(tipoPercepcion));
			model.addAttribute("tipoHoras", comprobanteDao.findCatalogoNomina(tipoHoras));
			model.addAttribute("tipoDeduccion", comprobanteDao.findCatalogoNomina(tipoDeduccion));
			model.addAttribute("tipoOtroPago", comprobanteDao.findCatalogoNomina(tipoOtroPago));
			model.addAttribute("tipoIncapacidad", comprobanteDao.findCatalogoNomina(tipoIncapacidad));
			model.addAttribute("tipoComprobante", tipoFactura);
			model.addAttribute("tenantID", tipoFactura);
		
		}else{
			model.addAttribute("fecha", df.format(new Date()));
			model.addAttribute("datosE",datos);
			model.addAttribute("listaMonedas", catalogoMonedaDao.findAll());
			model.addAttribute("paises", paisEstadosDao.findAllPais());
			model.addAttribute("estados", paisEstadosDao.findAllEstado());
			model.addAttribute("metodosPago", catalogoMetodoPagoDao.findAll());
			model.addAttribute("tipoComprobante", tipoFactura);
			model.addAttribute("tenantID", tipoFactura);
			model.addAttribute("regimenContratacion", comprobanteDao.findCatalogo(regimenContratacion));
			model.addAttribute("riesgoPuesto", comprobanteDao.findCatalogo(riesgoPuesto));
			model.addAttribute("tipoJornada", comprobanteDao.findCatalogo(tipoJornada));
			model.addAttribute("tipoContrato", comprobanteDao.findCatalogo(tipoContrato));
			model.addAttribute("banco", comprobanteDao.findCatalogo(banco));
			
			model.addAttribute("estadoComercioExt", paisEstadosDao.findAllEstado());
			model.addAttribute("fraccionesArancelarias", fraccionArancelariaDao.findAll());
			model.addAttribute("unidadesMedidaComercioExt", unidadMedidaComercioExtDao.findAll());
		}
		
		if (datos.getTipoPlan() == true)
			model.addAttribute("fechaVencimiento", datos.getFechaVencimiento().substring(0, 10));
		else{
			String strUltimaCompra = datos.getUltimaCompra();
			if (strUltimaCompra != null){
				strUltimaCompra = strUltimaCompra.substring(0, 11);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					
					Calendar calVigencia = Calendar.getInstance();
					calVigencia.setTime(formatter.parse(strUltimaCompra));
					calVigencia.add(Calendar.YEAR,1);
					
					strUltimaCompra = formatter.format(calVigencia.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.addAttribute("ultimaCompra", strUltimaCompra);
			}
		}
			
		
		if (tipoFactura.equals("cp")) {
			return "/cfdi";
		} else if (tipoFactura.equals("rp")) {
			return "retenciones/form";
		} else if (tipoFactura.equals("tn")) {
			return "nomina/form";
		} 
		
		return "/cfdi.jsp";
	}
	
	@RequestMapping(value = "/addenda/{addenda}/{uuid}", method = RequestMethod.GET)
	public String addenda(@PathVariable String addenda, @PathVariable String uuid, HttpServletRequest request) {		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		return "redirect:" + URLConstants.ADDENDAS + addenda + ".php?rfc=" + tenantID + "&uuid=" + uuid;
	}
	
	@RequestMapping(value = "/addendaRetenciones/{addenda}/{uuid}", method = RequestMethod.GET)
	public String addendaRetenciones(@PathVariable String addenda, @PathVariable String uuid, HttpServletRequest request) {		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		//return "redirect:http://portal.expidetufactura.com.mx/addendasRetenciones/" + addenda + ".php?rfc=" + tenantID + "&uuid=" + uuid;
		return "redirect:" + URLConstants.ADDENDAS_RETENCIONES + addenda + ".php?rfc=" + tenantID + "&uuid=" + uuid;
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
	

	@RequestMapping(value = "/filtrar/{anio}/{mes}", method = RequestMethod.GET)
	public String filtrarPeriodo(@PathVariable String anio, @PathVariable String mes, Model model, HttpServletRequest request) {		
			
	   final String tenantID = (String)request.getSession().getAttribute("tenantId");
	   List<CfdEmitido> cfds = comprobanteDao.findByDates(tenantID, anio, mes);
	   model.addAttribute("cfds", cfds);
	   List<Addenda> addendas = comprobanteDao.findAddendas(tenantID);
	   model.addAttribute("tieneAddendas", (addendas == null) ? false : addendas.size() > 0);
	   model.addAttribute("addendas", addendas);
	   model.addAttribute("mes", mes);
	   model.addAttribute("anio", anio);
	   model.addAttribute("addendaSelect", "String");
	   model.addAttribute("addendaSelect", "String");
	   
	   String msg = (String)request.getParameter("msg");
	   String error = (String)request.getParameter("error");
	   if(msg != null && msg.length() > 0) {
		   model.addAttribute("msg", msg);
		   model.addAttribute("error", error);
	   }
	   datosEmisorDao.setTenantId(tenantID);
	   model.addAttribute("datosE",datosEmisorDao.findEmisor(tenantID));
	  return "comprobante/listaCfd";
	 } 
	
	@RequestMapping(value = "/filtrarRetenciones/{datemin}/{datemax}", method = RequestMethod.GET)
	public String filtrarPeriodoRetenciones(@PathVariable String datemin,
	   @PathVariable String datemax, Model model, HttpServletRequest request) {		
			
	   final String tenantID = (String)request.getSession().getAttribute("tenantId");
	   // -- Se obtienen el primer y ultimo dia del mes para hacer la consulta.
	   fechasUtil = new FechasUtil();
	   String arrayMin[] = datemin.split("-");
	   int primerDiaMes = fechasUtil.getPrimerDiaDelMes(Integer.parseInt(arrayMin[0]), Integer.parseInt(arrayMin[1]));
	   int ultimoDiaMes = fechasUtil.getUltimoDiaDelMes(Integer.parseInt(arrayMin[0]), Integer.parseInt(arrayMin[1]));
	   // ---------------------------------------------------------------------
	   List<RetencionesEmitido> retenciones = retencionesDao.findByDates(tenantID, datemin+"-"+primerDiaMes, datemax+"-"+ultimoDiaMes);
	   model.addAttribute("retenciones", retenciones);
	   List<Addenda> addendas = comprobanteDao.findAddendas(tenantID);
	   model.addAttribute("tieneAddendas", (addendas == null) ? false : addendas.size() > 0);
	   model.addAttribute("addendas", addendas);
	   model.addAttribute("mes", datemin.substring(5, 7));
	   model.addAttribute("anio", datemin.substring(0, 4));
	   model.addAttribute("addendaSelect", "String");
	   model.addAttribute("addendaSelect", "String");
	   
	   String msg = (String)request.getParameter("msg");
	   String error = (String)request.getParameter("error");
	   if(msg != null && msg.length() > 0) {
		   model.addAttribute("msg", msg);
		   model.addAttribute("error", error);
	   }
	   datosEmisorDao.setTenantId(tenantID);
	   model.addAttribute("datosE",datosEmisorDao.findEmisor(tenantID));
	  return "retenciones/listaRetenciones";
	 } 
	
	@RequestMapping(value = "/agregar", method = RequestMethod.GET)
	public String agregar( @ModelAttribute("comprobante") String strComprobante, BindingResult result, Model model) {
		return "/comprobante/id";
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
		model.addAttribute("fecha", fecha);
		return "/comprobante/email";
	}
	
	private String getXMLComprobante(Comprobante cfdi) {
		String result = null;
		try {
			JAXBContext jaxbContext = JaxbContextSingletonHelper.getInstanceXML();
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			StringBuilder schema = new StringBuilder();

			schema.append("http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd ");
/*
			schema += "http://www.sat.gob.mx/implocal http://www.sat.gob.mx/sitio_internet/cfd/implocal/implocal.xsd ";
			schema += "http://www.sat.gob.mx/notariospublicos http://www.sat.gob.mx/sitio_internet/cfd/notariospublicos/notariospublicos.xsd ";
			schema += "http://www.sat.gob.mx/nomina http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina11.xsd ";
			schema += "http://www.sat.gob.mx/donat http://www.sat.gob.mx/sitio_internet/cfd/donat/donat11.xsd";
			schema += "http://www.sat.gob.mx/detallista http://www.sat.gob.mx/sitio_internet/cfd/detallista/detallista.xsd ";
			http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd 
*/
			boolean blnHayCompComercioExterior= false;
			if (cfdi.getComplemento() != null) {
	//			schema += "http://www.sat.gob.mx/iedu http://www.sat.gob.mx/cfd/iedu/iedu.xsd "
				if (cfdi.getComplemento().getNotariosPublicos() != null) {
					schema.append(" http://www.sat.gob.mx/notariospublicos http://www.sat.gob.mx/sitio_internet/cfd/notariospublicos/notariospublicos.xsd");
				}
				if (cfdi.getComplemento().getNomina12() != null) {
					schema.append(" http://www.sat.gob.mx/nomina12 http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina12.xsd");
				}
				if (cfdi.getComplemento().getDetallista() != null) {
					schema.append(" http://www.sat.gob.mx/detallista http://www.sat.gob.mx/sitio_internet/cfd/detallista/detallista.xsd");
				}
				if (cfdi.getComplemento().getDonatarias() != null) {
					schema.append(" http://www.sat.gob.mx/donat http://www.sat.gob.mx/sitio_internet/cfd/donat/donat11.xsd");
				}
				if (cfdi.getComplemento().getConsumodecombustibles() != null) {
					schema.append(" http://www.sat.gob.mx/ConsumoDeCombustibles11 http://www.sat.gob.mx/sitio_internet/cfd/ConsumoDeCombustibles/consumodeCombustibles11.xsd");
				}
				if (cfdi.getComplemento().getVehiculousado() != null) {
					schema.append(" http://www.sat.gob.mx/vehiculousado http://www.sat.gob.mx/sitio_internet/cfd/vehiculousado/vehiculousado.xsd");
				}
				if (cfdi.getComplemento().getImpuestosLocales() != null) {
					schema.append(" http://www.sat.gob.mx/implocal http://www.sat.gob.mx/sitio_internet/cfd/implocal/implocal.xsd");
				}
				if (cfdi.getComplemento().getPagoEnEspecie() != null) {
					schema.append(" http://www.sat.gob.mx/pagoenespecie http://www.sat.gob.mx/sitio_internet/cfd/pagoenespecie/pagoenespecie.xsd");
				}
				if (cfdi.getComplemento().getRegistroFiscal() != null) {
					schema.append(" http://www.sat.gob.mx/registrofiscal http://www.sat.gob.mx/sitio_internet/cfd/cfdiregistrofiscal/cfdiregistrofiscal.xsd");
				}
				if (cfdi.getComplemento().getValesDespensa() != null) {
					schema.append(" http://www.sat.gob.mx/valesdedespensa http://www.sat.gob.mx/sitio_internet/cfd/valesdedespensa/valesdedespensa.xsd");
				}
				if (cfdi.getComplemento().getParcialesConstruccion() != null) {
					schema.append(" http://www.sat.gob.mx/servicioparcialconstruccion http://www.sat.gob.mx/sitio_internet/cfd/servicioparcialconstruccion/servicioparcialconstruccion.xsd");
				}
				if (cfdi.getComplemento().getAerolineas() != null) {
					schema.append(" http://www.sat.gob.mx/aerolineas http://www.sat.gob.mx/sitio_internet/cfd/aerolineas/aerolineas.xsd");
				}
				if (cfdi.getComplemento().getDivisas() != null) {
					schema.append(" http://www.sat.gob.mx/divisas http://www.sat.gob.mx/sitio_internet/cfd/divisas/divisas.xsd");
				}
				if (cfdi.getComplemento().getTurista() != null) {
					schema.append(" http://www.sat.gob.mx/TuristaPasajeroExtranjero http://www.sat.gob.mx/sitio_internet/cfd/TuristaPasajeroExtranjero/TuristaPasajeroExtranjero.xsd");
				}
				if (cfdi.getComplemento().getPfic() != null) {
					schema.append(" http://www.sat.gob.mx/pfic http://www.sat.gob.mx/sitio_internet/cfd/pfic/pfic.xsd");
				}
				if (cfdi.getComplemento().getIne() != null) {
					schema.append(" http://www.sat.gob.mx/ine http://www.sat.gob.mx/sitio_internet/cfd/ine/ine11.xsd");
				}
				if (cfdi.getComplemento().getLeyendasFisc() != null) {
					schema.append(" http://www.sat.gob.mx/leyendasFiscales http://www.sat.gob.mx/sitio_internet/cfd/leyendasFiscales/leyendasFisc.xsd");
				}
				if (cfdi.getComplemento().getObrasArteAntiguedades() != null) {
					schema.append(" http://www.sat.gob.mx/arteantiguedades http://www.sat.gob.mx/sitio_internet/cfd/arteantiguedades/obrasarteantiguedades.xsd");
				}
				if (cfdi.getComplemento().getCertificadoDestruccion() != null) {
					schema.append(" http://www.sat.gob.mx/certificadodestruccion http://www.sat.gob.mx/sitio_internet/cfd/certificadodestruccion/certificadodedestruccion.xsd");
				}
				if (cfdi.getComplemento().getEstadodecuentacombustible12() != null) {
					schema.append(" http://www.sat.gob.mx/EstadoDeCuentaCombustible12 http://www.sat.gob.mx/sitio_internet/cfd/EstadoDeCuentaCombustible/ecc12.xsd");
				}
				if (cfdi.getComplemento().getComplemento_SPEI() != null) {
					schema.append(" http://www.sat.gob.mx/spei http://www.sat.gob.mx/sitio_internet/cfd/spei/spei.xsd");
				}
				if (cfdi.getComplemento().getRenovacionysustitucionvehiculos() != null) {
					schema.append(" http://www.sat.gob.mx/renovacionysustitucionvehiculos http://www.sat.gob.mx/sitio_internet/cfd/renovacionysustitucionvehiculos/renovacionysustitucionvehiculos.xsd");
				}
				if (cfdi.getComplemento().getComercioExterior() != null) {
					blnHayCompComercioExterior = true;
					schema.append(" http://www.sat.gob.mx/ComercioExterior11 http://www.sat.gob.mx/sitio_internet/cfd/ComercioExterior11/ComercioExterior11.xsd");
				}
				if (cfdi.getComplemento().getPagos() != null) {
					schema.append(" http://www.sat.gob.mx/Pagos http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos10.xsd");
				}
			}
			
			boolean blnHayCompInsEducativas = false;
			boolean blnHayCompVentaVehiculos= false;
			boolean blnHayCompCuentaTerceros= false;
			boolean blnHayCompCertDestruccion= false;
			
			for (int i=0;i<cfdi.getConceptos().getConceptos().size();i++){
				if (cfdi.getConceptos().getConceptos().get(i).getComplementoConcepto() != null){
					if (cfdi.getConceptos().getConceptos().get(i).getComplementoConcepto().getInstEducativas() != null ) {
						blnHayCompInsEducativas = true;
					}
					if (cfdi.getConceptos().getConceptos().get(i).getComplementoConcepto().getVentaVehiculos() != null ) {
						blnHayCompVentaVehiculos = true;
					}
					if (cfdi.getConceptos().getConceptos().get(i).getComplementoConcepto().getCuentaTerceros() != null ) {
						blnHayCompCuentaTerceros = true;
					}
				}
			}
			 
			if (blnHayCompInsEducativas){
				schema.append(" http://www.sat.gob.mx/iedu http://www.sat.gob.mx/sitio_internet/cfd/iedu/iedu.xsd");
			}
			if (blnHayCompVentaVehiculos){
				schema.append(" http://www.sat.gob.mx/ventavehiculos http://www.sat.gob.mx/sitio_internet/cfd/ventavehiculos/ventavehiculos11.xsd");
			}
			if (blnHayCompCuentaTerceros){
				schema.append(" http://www.sat.gob.mx/terceros http://www.sat.gob.mx/sitio_internet/cfd/terceros/terceros11.xsd");
			}
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schema.toString());
				
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//jaxbMarshaller.marshal(cfdi, doc);
			
			StringWriter strXML = new StringWriter(); 
			jaxbMarshaller.marshal(cfdi, strXML);
			result = strXML.toString();
			result = result.replace("<instEducativas", "<iedu:instEducativas");
			result = result.replace("cfdi:ImpuestosLocales", "implocal:ImpuestosLocales");
			result = result.replace("cfdi:Donatarias", "donat:Donatarias ");
			if (cfdi.getComplemento() != null){
				if (cfdi.getComplemento().getNomina12() != null) {
					result = result.replace("cfdi:Nomina", "nomina12:Nomina");
				}
			}
			
			result = result.replace("cfdi:notariosPublicos", "notariospublicos:NotariosPublicos");
			result = result.replace("cfdi:ConsumoDeCombustibles", "consumodecombustibles11:ConsumoDeCombustibles");
			result = result.replace("cfdi:VehiculoUsado", "vehiculousado:VehiculoUsado");
			result = result.replace("cfdi:PagoEnEspecie", "pagoenespecie:PagoEnEspecie");
			result = result.replace("cfdi:CFDIRegistroFiscal", "registrofiscal:CFDIRegistroFiscal");
			result = result.replace("cfdi:detallista", "detallista:detallista");
			result = result.replace("VentaVehiculos", "ventavehiculos:VentaVehiculos");
			result = result.replace("cfdi:ValesDeDespensa", "valesdedespensa:ValesDeDespensa");
			result = result.replace("cuentaTerceros", "terceros:PorCuentadeTerceros");
			result = result.replace("cfdi:ParcialesConstruccion", "servicioparcial:parcialesconstruccion");
			result = result.replace("cfdi:Aerolineas", "aerolineas:Aerolineas");
			result = result.replace("cfdi:Divisas", "divisas:Divisas");
			result = result.replace("cfdi:TuristaPasajeroExtranjero", "tpe:TuristaPasajeroExtranjero");
			result = result.replace("cfdi:PersonaFisicaIntegranteDeCoordinado", "pfic:PFintegranteCoordinado");
			result = result.replace("cfdi:INE", "ine:INE");
			result = result.replace("cfdi:LeyendasFiscales", "leyendasFisc:LeyendasFiscales");
			result = result.replace("cfdi:ObrasArteAntiguedades", "obrasarte:obrasarteantiguedades");
			result = result.replace("cfdi:CertificadoDestruccion", "destruccion:certificadodedestruccion");
			result = result.replace("cfdi:EstadoDeCuentaCombustible12", "ecc12:EstadoDeCuentaCombustible");
			result = result.replace("cfdi:Complemento_SPEI", "spei:Complemento_SPEI");
			result = result.replace("cfdi:renovacionSustitucionVehiculos", "decreto:renovacionysustitucionvehiculos");
			result = result.replace("cfdi:comercioexterior", "cce11:ComercioExterior");
			result = result.replace("cfdi:pagos", "pago10:Pagos");
			
			
//					+ "xsi:schemaLocation=\"http://www.sat.gob.mx/donat http://www.sat.gob.mx/sitio_internet/cfd/donat/donat11.xsd\""
//					+ "").replace("cfdi:ImpuestosLocales", "implocal:ImpuestosLocales");
			//result = new String(result.getBytes("UTF-8")); 
			
			if (cfdi.getComplemento() != null) {
	//			schema += "http://www.sat.gob.mx/Nominaiedu http://www.sat.gob.mx/cfd/iedu/iedu.xsd "
				if (cfdi.getComplemento().getNotariosPublicos() == null) {
					result = result.replace("xmlns:notariospublicos=\"http://www.sat.gob.mx/notariospublicos\"", "");
				}
				if (cfdi.getComplemento().getConsumodecombustibles() == null) {
					result = result.replace("xmlns:consumodecombustibles11=\"http://www.sat.gob.mx/ConsumoDeCombustibles11\"", "");
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
				if (cfdi.getComplemento().getRenovacionysustitucionvehiculos() == null) {
					result = result.replace("xmlns:decreto=\"http://www.sat.gob.mx/renovacionysustitucionvehiculos\"", "");
				}
				if (cfdi.getComplemento().getComercioExterior() == null) {
					result = result.replace("xmlns:cce11=\"http://www.sat.gob.mx/ComercioExterior11\"", "");
				}
				if (cfdi.getComplemento().getPagos() == null) {
					result = result.replace("xmlns:pago10=\"http://www.sat.gob.mx/Pagos\"", "");
				}
				
				
			} else {
				result = result.replace("xmlns:notariospublicos=\"http://www.sat.gob.mx/notariospublicos\"", "");
				result = result.replace("xmlns:consumodecombustibles11=\"http://www.sat.gob.mx/ConsumoDeCombustibles11\"", "");
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
				result = result.replace("xmlns:ecc12=\"http://www.sat.gob.mx/EstadoDeCuentaCombustible12\"", "");
				result = result.replace("xmlns:spei=\"http://www.sat.gob.mx/spei\"", "");
				result = result.replace("xmlns:decreto=\"http://www.sat.gob.mx/renovacionysustitucionvehiculos\"", "");
				result = result.replace("xmlns:cce11=\"http://www.sat.gob.mx/ComercioExterior11\"", "");
				result = result.replace("xmlns:pago10=\"http://www.sat.gob.mx/Pagos\"", "");
			}
			if (!blnHayCompInsEducativas){
				result = result.replace("xmlns:iedu=\"http://www.sat.gob.mx/iedu\"", "");
			}
			if (!blnHayCompVentaVehiculos){
				result = result.replace("xmlns:ventavehiculos=\"http://www.sat.gob.mx/ventavehiculos\"", "");
			}
			if (!blnHayCompCuentaTerceros){
				result = result.replace("xmlns:terceros=\"http://www.sat.gob.mx/terceros\"", "");
			}
			
			if (cfdi.getComplemento() != null) {
				if (cfdi.getComplemento().getPagoEnEspecie() != null) {
					String strAux = result;
					result = strAux.replace("amp;amp;", "amp;");
				}
			}
			
			if (result.contains("<cfdi:Traslados/>")){
				result = result.replace("<cfdi:Traslados/>", "");
			}
			
			//Se arregla el xml de certificado destruccion
			if (cfdi.getComplemento() != null) {
				if (cfdi.getComplemento().getCertificadoDestruccion() != null) {
					String strAuxVehiculoDestruido ="";
					String strAuxInformacionAduanera ="";
									
					int intInicioTag = result.indexOf("<destruccion:certificadodedestruccion");
					int intInicioTagVehiculoDestruido = result.indexOf("<destruccion:VehiculoDestruido");
					int intInicioTagInformacionAduanera = result.indexOf("<destruccion:InformacionAduanera");
					
					if (intInicioTagVehiculoDestruido > 0){
						strAuxVehiculoDestruido = result.substring(intInicioTagVehiculoDestruido, result.indexOf("/>", intInicioTagVehiculoDestruido)+2);
					}
					if (intInicioTagInformacionAduanera > 0){
						strAuxInformacionAduanera = result.substring(intInicioTagInformacionAduanera, result.indexOf("/>", intInicioTagInformacionAduanera)+2);
					}
	
					result = result.replaceAll(strAuxVehiculoDestruido, "");
					result = result.replaceFirst(strAuxInformacionAduanera, "");
					
					int intAgregaRamas = result.indexOf(">", intInicioTag)+1;
					String strPart1 = result.substring(0, intAgregaRamas);
					StringBuffer sb = new StringBuffer();
					sb.append(strPart1);
					if (intInicioTagVehiculoDestruido > 0){
						sb.append(strAuxVehiculoDestruido);
					}
					if (intInicioTagInformacionAduanera > 0){
						sb.append(strAuxInformacionAduanera);
					}
					
					String strPart2 = result.substring(intAgregaRamas);
					sb.append(strPart2);
					System.out.println(sb);
					result = sb.toString();
					
					
					
				}
			}
			
		} catch(Exception e) {
			log.error("Error: " + e);
			e.printStackTrace();
		} finally {
			return result;
		}
	}

	@RequestMapping(value = "/timbrarComprobante", method = RequestMethod.POST) 
	public String timbrar(@Valid @ModelAttribute("strComprobante") String strComprobante, 
			BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		final String rfc = (String)session.getAttribute("tenantId");
		
		Comprobante cfdi  = gson.fromJson(strComprobante,  Comprobante.class);
		String strZona = catalogoZonaHorariaDao.findZonaHoraria(cfdi.getLugarExpedicion()); 
		if (strZona != null){//Cambiar hora por TZ
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			sdf.setTimeZone(TimeZone.getTimeZone(strZona));
						
			Calendar calendar = new GregorianCalendar();
						
			cfdi.setFecha(sdf.format(calendar.getTime()));
		}
		if (cfdi.getComplemento() !=null){
			if (cfdi.getComplemento().getNotariosPublicos() !=null){
				//Se validan posibles datos opcionales de la rama Notario
				if (cfdi.getComplemento().getNotariosPublicos().getDatosNotario().getAdscripcion().equals("")){
					cfdi.getComplemento().getNotariosPublicos().getDatosNotario().setAdscripcion(null);
				}
				//Se validan posibles datos opcionales de la rama DescInmueble
				for (int i=0;i<cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().size();i++){
					if (cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).getNoExterior().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).setNoExterior(null);
					}
					if (cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).getNoInterior().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).setNoInterior(null);
					}
					if (cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).getColonia().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).setColonia(null);
					}
					if (cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).getLocalidad().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).setLocalidad(null);
					}
					if (cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).getReferencia().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDescInmuebles().getDescInmueble().get(i).setReferencia(null);
					}
					
				}
				
				
				//Se validan posibles datos opcionales de la rama DatosUnEnajenante
				if (cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosUnEnajenante()!=null){
					if (cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosUnEnajenante().getApellidoMaterno().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosUnEnajenante().setApellidoMaterno(null);
					}
				}
				
				
				//Se barre la rama DatosEnajenanteCopSC
				if (cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosEnajenantesCopSC()!=null){
					for (int i=0;i<cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosEnajenantesCopSC().getDatosEnajenanteCopSC().size();i++){
						if (cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosEnajenantesCopSC().getDatosEnajenanteCopSC().get(i).getApellidoPaterno().equals("")){
							cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosEnajenantesCopSC().getDatosEnajenanteCopSC().get(i).setApellidoPaterno(null);
						}
						if (cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosEnajenantesCopSC().getDatosEnajenanteCopSC().get(i).getApellidoMaterno().equals("")){
							cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosEnajenantesCopSC().getDatosEnajenanteCopSC().get(i).setApellidoMaterno(null);
						}
						if (cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosEnajenantesCopSC().getDatosEnajenanteCopSC().get(i).getCURP().equals("")){
							cfdi.getComplemento().getNotariosPublicos().getDatosEnajenante().getDatosEnajenantesCopSC().getDatosEnajenanteCopSC().get(i).setCURP(null);
						}
					}
				}
				
				//Se validan posibles datos opcionales de la rama DatosUnAdquiriente
				if (cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosUnAdquiriente()!=null){
					if (cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosUnAdquiriente().getApellidoPaterno().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosUnAdquiriente().setApellidoPaterno(null);
					}
					if (cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosUnAdquiriente().getApellidoMaterno().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosUnAdquiriente().setApellidoMaterno(null);
					}
					if (cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosUnAdquiriente().getCURP().equals("")){
						cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosUnAdquiriente().setCURP(null);
					}
				}
				
				//Se barre la rama DatosAdquirientesCopSC
				if (cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosAdquirientesCopSC()!=null){
					for (int i=0;i<cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosAdquirientesCopSC().getDatosAdquirienteCopSC().size();i++){
						if (cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosAdquirientesCopSC().getDatosAdquirienteCopSC().get(i).getApellidoPaterno().equals("")){
							cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosAdquirientesCopSC().getDatosAdquirienteCopSC().get(i).setApellidoPaterno(null);
						}
						if (cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosAdquirientesCopSC().getDatosAdquirienteCopSC().get(i).getApellidoMaterno().equals("")){
							cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosAdquirientesCopSC().getDatosAdquirienteCopSC().get(i).setApellidoMaterno(null);
						}
						if (cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosAdquirientesCopSC().getDatosAdquirienteCopSC().get(i).getCURP().equals("")){
							cfdi.getComplemento().getNotariosPublicos().getDatosAdquiriente().getDatosAdquirientesCopSC().getDatosAdquirienteCopSC().get(i).setCURP(null);
						}
						
					}
				}
			}
		}
		
		
		cfdi.setVersion(parametroDao.findByClave("VERSION_XML").getValor());
		if (cfdi.getTipoDeComprobante().equals("rn")){
			
			if (cfdi.getComplemento().getNomina().getBanco()!=null){
				if (cfdi.getComplemento().getNomina().getBanco().length() == 1){
					cfdi.getComplemento().getNomina().setBanco("00"+cfdi.getComplemento().getNomina().getBanco());
				}
				if (cfdi.getComplemento().getNomina().getBanco().length() == 2){
					cfdi.getComplemento().getNomina().setBanco("0"+cfdi.getComplemento().getNomina().getBanco()); 
				}
			}
		}
		String tipoCfdi;
		String tCase = cfdi.getTipoDeComprobante();
		
		if (tCase.equals("cr") || tCase.equals("rn") || tCase.equals("ct") || tCase.equals("co")) {
			tipoCfdi = "E";
		} else if (tCase.equals("tn")) {
			tipoCfdi = "N";
		}else if (tCase.equals("cp")) {
			tipoCfdi = "T";
		}else if (tCase.equals("pa")) {
			tipoCfdi = "P";
		} 
		else {
			tipoCfdi = "I";
		}
		
		cfdi.setTipoDeComprobante(tipoCfdi);
		mx.xpd.cfdi.domain.cfdi.RegimenFiscal regimen = null;


		/* Agregamos lugar de ExpidedoEn */
		configuracionDao.setTenantId(rfc);
		ConfiguracionCFDI config = configuracionDao.findAll(rfc);
		//SE AUITÓ LO DE ExpedidoEn
		
	
		/*
		 * Agramos certificado y sello
		 * */
		
			
		csdDao.setTenantId(rfc);		
		CertificadoSelloDigital csd = csdDao.findCurrent(rfc);
		String cer = cleanCertificate(csd.getCertificado());
		cer = cer.replaceAll(" ", "").replaceAll("\n", "");
		
		cfdi.setCertificado(cer);
		cfdi.setNoCertificado(csd.getNoSerie());
		
		InputStream input = new ByteArrayInputStream(getXMLComprobante(cfdi).getBytes("UTF-8"));
		
		String llave = cleanCertificate(csd.getArchivoKey());
		String xslt = parametroDao.findByClave("PATH_XSLT_CADENA").getValor();
			
		String sello = Sello.getSello(input, llave, xslt);
		
		cfdi.setSello(sello);		
		
		CfdEmitido cfdEmitido = new CfdEmitido();
		cfdEmitido.setFechaDate(new Date());
		cfdEmitido.setSerie(cfdi.getSerie());
		cfdEmitido.setTenantId(rfc);
		cfdEmitido.setAnio(new Date().getYear()+1900);
		if (cfdi.getComplemento() != null && cfdi.getComplemento().getDetallista() != null) {
			
			SpecialInstruction s = new SpecialInstruction();
			
			s.setCode("ZZZ");
			String text = new java.util.Scanner(new java.net.URL(URLConstants.WS_NUMERO_LETRA
							+ cfdi.getComplemento().getDetallista().getTotalAmount().getAmount()).openStream()).nextLine();
			s.setText(text);
			
			cfdi.getComplemento().getDetallista().getSpecialInstruction().add(s);
			
			
			LineItem li = new LineItem();
			
			TradeItemIdentification t = new TradeItemIdentification();
			t.setGtin("1");
			li.setTradeItemIdentification(t);
			AlternateTradeItemIdentification a = new AlternateTradeItemIdentification();
			a.setType("BUYER_ASSIGNED");
			a.setValue("1");
			TradeItemDescriptionInformation td =  new TradeItemDescriptionInformation();
			td.setLanguage("ES");
			td.setLongText("Perro Chihuahua");
			
			GrossPrice p = new GrossPrice();
			p.setAmount(new BigDecimal(500));
			
			NetPrice n = new NetPrice();
			n.setAmount(new BigDecimal(500));
			
			
			TotalLineAmount tl = new TotalLineAmount();
			
			GrossAmount ga = new GrossAmount();
			ga.setAmount(new BigDecimal(1500));
			
			NetAmount na = new NetAmount();
			ga.setAmount(new BigDecimal(1500));
			
			
			tl.setGrossAmount(ga);
			tl.setNetAmount(na);
			li.setTotalLineAmount(tl);
			
			li.setGrossPrice(p);
			
		}
		
		
		comprobanteDao.add(cfdEmitido);
		
		String xml = getXMLComprobante(cfdi);
				
		String endPoint = "";
		String usuario = "";
		String password = "";
		
		datosEmisorDao.setTenantId(rfc);
		DatosEmisor emisor = datosEmisorDao.findEmisor(rfc);
		
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
		
		String rfcFecha = parametroDao.findByClave("RFC_FECHA").getValor();
		
		if (rfcFecha != null && rfcFecha.contains(rfc)) {
			endPoint = parametroDao.findByClave("URL_TIMBRADO_ERROR_FECHA").getValor();
		}
		
		parametroDao.findByClave("PATH_XSLT_CADENA").getValor();
		
		TimbradoWSServiceSoapBindingStub timbrarStub =  new TimbradoWSServiceSoapBindingStub();
		timbrarStub.setUsername(usuario);
		timbrarStub.setPassword(password);
		String msg = "";
		String err = "";
		
		mx.xpd.cfdi.timbrado.service.RespuestaTimbrado respo = timbrarStub.timbrar(endPoint, usuario, password, xml.getBytes());
		File file = null; 
		gson = new Gson();
		
		if (respo.getCodigo().equals("200") || respo.getCodigo().equals("200")) {
			String rutaXML = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();
			file = new File(rutaXML + File.separatorChar + cfdi.getEmisor().getRfc());
			checarCarpeta(file);
			file = new File(file.getAbsolutePath() + File.separatorChar + respo.getUuid()  +".xml");
			BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), "UTF8"));
			String xmlResult = respo.getTimbre();
			
			String strRFCEscapados = parametroDao.findByClave("LISTA_RFC_CARACTERES_ESCAPADOS").getValor();
			if (strRFCEscapados != null && strRFCEscapados.contains(rfc)) {//Si es un cliente que necesita caracteres escapados
				xmlResult = cambiaCaracteres(xmlResult, cfdi.getConceptos().getConceptos());
			}
			
			if (!xmlResult.startsWith("<?xml version=")) {
				fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n");
			}
			
			fileWriter.write(xmlResult);
			fileWriter.flush();
			fileWriter.close();
			
			cfdEmitido.setTipoComprobante(cfdi.getTipoDeComprobante());
			cfdEmitido.setFolio(cfdi.getFolio() == null ? null : Integer.parseInt(cfdi.getFolio()));
			cfdEmitido.setSerie(cfdi.getSerie() == null ? null : cfdi.getSerie());
			cfdEmitido.setFormaDePago(cfdi.getFormaPago());
			cfdEmitido.setSubTotal(Double.parseDouble(cfdi.getSubTotal()));
			cfdEmitido.setTotal(Double.parseDouble(""  + cfdi.getTotal()));
			cfdEmitido.setRazonSocialReceptor(cfdi.getReceptor().getNombre());
			cfdEmitido.setUuid(respo.getUuid());
			cfdEmitido.setConfirmacion(cfdi.getConfirmacion());
			cfdEmitido.setEstatus("emitido");
			
			if (cfdi.getImpuestos() != null)
				if (cfdi.getImpuestos().getTotalImpuestosTrasladados() == null){
				cfdEmitido.setIva(null);
			}
			else{
				cfdEmitido.setIva(Double.parseDouble(cfdi.getImpuestos().getTotalImpuestosTrasladados()));
			}

			cfdEmitido.setRfcReceptor(cfdi.getReceptor().getRfc());
			
			cfdEmitido.setJson(strComprobante);
			
			comprobanteDao.merge(cfdEmitido);
			
			if (!emisor.isGratuito()) {
				if (!emisor.getTipoPlan()) {//Es de plan anterior, entonces hay que descontar folios
					emisor.setFoliosDisponibles(emisor.getFoliosDisponibles() - 1);
					datosEmisorDao.setTenantId(rfc);
					datosEmisorDao.update(emisor);
				}
			}
			
			msg = "Comprobante generado correctamente";
			err = "0";
			
			rutaXML = parametroDao.findByClave("PATH_EXTERNO_PDF_TIMBRADO").getValor();
			File pdfFile = new File(rutaXML + File.separatorChar + cfdi.getEmisor().getRfc());
			checarCarpeta(pdfFile);
			pdfFile = new File(pdfFile.getAbsolutePath() + File.separatorChar + respo.getUuid()  +".pdf");
			FileOutputStream out = new FileOutputStream(pdfFile);
			
			ComprobantePDF cfdiPDF = null;
			

			plantillaDao.setTenantId(rfc);
			try {
				
				cfdiPDF = getComprobantePDF(strComprobante, rfc);
				
				cfdiPDF.setFolio(cfdi.getFolio());
				cfdiPDF = generaPDF(cfdiPDF, out, file, rfc);
				
				out.flush();
				out.close();
				
				cfdEmitido.setEmail(cfdiPDF.getReceptor().getEmail());
				comprobanteDao.merge(cfdEmitido);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (cfdi.getComplemento() != null){
				if (cfdi.getComplemento().getNomina12() != null){//Es una nómina web 1.2
					Empleado emp = empleadoDao.findByRfc(cfdi.getEmisor().getRfc(), cfdi.getReceptor().getRfc());
					if (emp != null ){
						if (emp.getEmail() !=null) {
							if (!emp.getEmail().equals("")){
								log.info("Se va a enviar el correo electronico de la nómina "+respo.getUuid()+".xml");
								String strSubject = "CFDI " + (cfdi.getFolio() == null ? "" : "No. " + cfdi.getFolio()) + 
										" de " + emisor.getRfc() + " para " +  cfdi.getReceptor().getRfc() + " con monto " + 
										NumberFormat.getCurrencyInstance().format(Double.parseDouble(cfdi.getTotal()));  
								String strCorreoEmisor = datosEmisorDao.findEmisor(cfdi.getEmisor().getRfc()).getEmail();
								
								String strCuerpoCorreo = configuracionCFDIDao.findAll(cfdi.getEmisor().getRfc()).getEmailConfig();
							
								if (enviarMailNomina(emp.getEmail(), strCorreoEmisor, cfdi.getEmisor().getRfc() ,respo.getUuid(), rutaXML, strSubject, strCuerpoCorreo)){
									cfdEmitido.setEnviado(true);
								}
								else{
									cfdEmitido.setEnviado(false);
								}
							}
						}
					}
				}
			}
			else{
				// AGREGAR CLIENTE DESDE LA PARTE DE COMPROBANTE
				clienteDao.setTenantId(rfc);
				if (cfdi.getTipoDeComprobante() != null && !cfdi.getTipoDeComprobante().equals("N") &&	cfdiPDF != null && cfdiPDF.getReceptor() != null){
					Cliente cte = new Cliente();
					if (cfdiPDF.getReceptor().getNombre() == null){
						cte = clienteDao.findByRfc(rfc,	cfdiPDF.getReceptor().getRfc());
					}
					else{
						cte = clienteDao.findByRfcRS(rfc,	cfdiPDF.getReceptor().getRfc(), cfdiPDF.getReceptor().getNombre());
					}
					if (cte == null){
						Cliente nuevoCliente = new Cliente();
						if(cfdiPDF.getReceptor().getRfc()!=null){
							nuevoCliente.setRfc(cfdiPDF.getReceptor().getRfc());
							nuevoCliente.setRfcDes(cfdiPDF.getReceptor().getRfc());
						}
						if(cfdiPDF.getReceptor().getNombre()!=null){
							nuevoCliente.setRazonSocial(cfdiPDF.getReceptor().getNombre());	
							nuevoCliente.setRazonSocialDes(cfdiPDF.getReceptor().getNombre());
						}
						if(cfdiPDF.getReceptor().getResidenciaFiscal() != null) {
							nuevoCliente.setResidenciaFiscal(cfdiPDF.getReceptor().getResidenciaFiscal());
						}
						
						if(cfdiPDF.getReceptor().getNumRegIdTrib()!=null){
							nuevoCliente.setNumRegIdTrib(cfdiPDF.getReceptor().getNumRegIdTrib());
						}
						
						if(cfdiPDF.getReceptor().getUsoCFDI()!=null){
							nuevoCliente.setUsoCFDI(cfdiPDF.getReceptor().getUsoCFDI());
						}
						
						if(cfdiPDF.getReceptor().getEmail()!=null){
							nuevoCliente.setEmail(cfdiPDF.getReceptor().getEmail());
						}
						//Aqui se genera una contraseña aleatoria con las primeras 3 letras del RFC
						//y generando un numero al azar entre 1 y 10 000
						int numero = (int)(Math.random()*10000+1) + 50000;
						String sub = nuevoCliente.getRfc().substring(0, 3);
						String nuevaClave = sub + numero;
						log.info("la nueva clave es : " + nuevaClave);
						clienteDao.setTenantId(rfc);
						while(clienteDao.findByClave(rfc,nuevaClave)!=null){
							numero = (int)(Math.random()*10000+1) +  50000;
							nuevaClave = sub + numero;
						}
						nuevoCliente.setClave(nuevaClave);
						//aqui va lo del mail nuevoCliente.setEstado(cfdiPDF.getReceptor().getDomicilio().getEstado());
						clienteDao.setTenantId(rfc);
						clienteDao.add(nuevoCliente);
						// log.info("agregando cliente: " + nuevoCliente.getId());
					}
					else {
						if(!cfdi.getTipoDeComprobante().equals("N")) {
							clienteDao.setTenantId(rfc);
							if (cfdiPDF != null) {
								Cliente clienteActualizar = new Cliente();
								if (cfdiPDF.getReceptor().getNombre() == null){
									clienteActualizar = clienteDao.findByRfc(rfc,	cfdiPDF.getReceptor().getRfc());
								}
								else{
									clienteActualizar = clienteDao.findByRfcRS(rfc,	cfdiPDF.getReceptor().getRfc(), cfdiPDF.getReceptor().getNombre());
								}
								
								log.info("actualizando cliente: " + clienteActualizar.getId());
							
								if (cfdiPDF.getReceptor().getEmail() != null) { 
									clienteActualizar.setEmail(cfdiPDF.getReceptor().getEmail());
								}
								if (cfdiPDF.getReceptor().getUsoCFDI() != null) { 
									clienteActualizar.setUsoCFDI(cfdiPDF.getReceptor().getUsoCFDI());
								}
								if (cfdiPDF.getReceptor().getNumRegIdTrib() != null) { 
									clienteActualizar.setNumRegIdTrib(cfdiPDF.getReceptor().getNumRegIdTrib());
								}
								if (cfdiPDF.getReceptor().getResidenciaFiscal() != null) { 
									clienteActualizar.setResidenciaFiscal(cfdiPDF.getReceptor().getResidenciaFiscal());
								}
							
							clienteDao.setTenantId(rfc);
							clienteDao.update(clienteActualizar);
							}
						}
					}
				}
			}
			
			configuracionDao.setTenantId(rfc);
			config = configuracionDao.findAll(rfc); //configuracionDao.findAll().get(0);
			if (cfdiPDF != null && config != null && config.getGuardarProductos()) {
				//AGREGAR PRODUCTO DESDE LA PARTE DEL COMPROBANTE
				ProductoServicio producto = new ProductoServicio();
				String claveMoneda = "";
				
				
				List<Concepto> listaConceptos = cfdiPDF.getConceptos().getConceptos();
				String nuevaClaveProducto;
				int numeroProd;
				String subProd;
				//List<ProductoServicio> listaProductos = productoDao.findAll();
				producto = new ProductoServicio();
				producto.setCodigoMoneda(cfdiPDF.getMoneda());
				for(Concepto concepto : listaConceptos){
					productoDao.setTenantId(rfc);
					if(!productoDao.existeProducto(concepto.getDescripcion(), rfc)){
							producto.setCodigoMoneda(cfdiPDF.getMoneda());
							producto.setNombre(concepto.getDescripcion());
							producto.setPrecioUnitario(concepto.getValorUnitario());
							configuracionDao.setTenantId(rfc);
							/*if( configuracionDao.findAll().get(0).getIva() == 0 && configuracionDao.findAll().get(0).getIvaExento() == true){
								producto.setTasaIva(null);
								producto.setIvaExento(true);
							}else{
								configuracionDao.setTenantId(rfc);
								producto.setTasaIva(configuracionDao.findAll().get(0).getIva());
								producto.setIvaExento(false);
							}*/
							
							clienteDao.setTenantId(rfc);
							
							producto.setClave(concepto.getClave()==null?"":concepto.getClave());
							producto.setClaveProdServ(concepto.getClaveProdServ());
														
							producto.setClaveUnidad(concepto.getClaveUnidad());
							producto.setUnidad(concepto.getUnidad());
							productoDao.setTenantId(rfc);
							productoDao.add(producto);
							producto = new ProductoServicio();
							
					}
				}
			}
			
			
		} else {
			//model.addAttribute("codigo", respo.getCodigo());
			//model.addAttribute("mensaje", respo.getMensaje());
			
			
			comprobanteDao.remove(cfdEmitido.getId());
			
			
				ComprobanteNoTimbrado cmp = new ComprobanteNoTimbrado();
				cmp.setCodigo(respo.getCodigo());
				cmp.setFechaRegistro(new Date());
				cmp.setTenant_id(rfc);
				cmp.setJson(strComprobante);
				cmp.setMensaje(respo.getMensaje());
				cmp.setXml(xml);
				comprobanteDao.addComprobanteNoTimbrado(cmp);
			
			
			
			log.info(respo.getCodigo() + " | " + respo.getMensaje());
			log.info(strComprobante);
			log.info(xml);
			msg = respo.getMensaje();
			msg = msg.replace("{", "").replace("}", "");
			err = "1";
		}
		if (cfdEmitido.getEstatus() == null) {
			comprobanteDao.remove(cfdEmitido.getId());
		}
		msg = msg.replaceAll("(\\r|\\n)", "");
		if (tipoCfdi.equals("N")){
			return "redirect:/comprobante/nomina?msg=" + msg + "&err=" + err;
		}
		else{
			return "redirect:/comprobante/"+ tCase +"?msg=" + msg + "&err=" + err;
		}
	}

	public Map<String, Object> getParams(ComprobantePDF cfdi) {
		return this.getParams(cfdi, null);
	}
	
	public Map<String, Object> getParamsRetenciones(RetencionesPDF retenciones) {
		return this.getParamsRetenciones(retenciones, null);
	}
	
	public Map<String, Object> getParams(ComprobantePDF cfdi, String tipoComprobante) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tipoComprobante", (tipoComprobante == null ? "PRE-FACTURA" : tipoComprobante));
	
		String total = "" + cfdi.getTotal();
		log.info(cfdi.getTotal());
		
		//log.info(total.substring(total.indexOf(".")));
		
		if (total.indexOf(".") > -1 && total.substring(total.indexOf(".")).length() == 1) {
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
		String textQR = null;
		textQR = "https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx?";
		if (cfdi.getComplemento() != null && cfdi.getComplemento().getTimbreFiscalDigital() != null) {
			textQR  += "id=" + cfdi.getComplemento().getTimbreFiscalDigital().getUuid();
		}
		else{
			textQR  += "id=Comprobante sin timbrar.";
		}
		textQR += "&re=" + cfdi.getEmisor().getRfc() 				
				+ "&rr=" + cfdi.getReceptor().getRfc()
				+ "&tt=" + cfdi.getTotal();
		if (cfdi.getComplemento() != null && cfdi.getComplemento().getTimbreFiscalDigital() != null) {
			textQR  += "&fe=" + cfdi.getComplemento().getTimbreFiscalDigital().getSelloCFD().substring(cfdi.getComplemento().getTimbreFiscalDigital().getSelloCFD().length() - 8 );
		} else {
			textQR  += "&fe=Comprobante sin timbrar.";
		}
				
		params.put("imagenQR", QRGenerator.getQR(textQR));
		return params;
	}
	
	public Map<String, Object> getParamsRetenciones(RetencionesPDF retenciones, String tipoComprobante) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tipoComprobante", (tipoComprobante == null ? "PRE-FACTURA" : tipoComprobante));
	
		String total = "" + retenciones.getTotales().getMontoTotOperacion();
		log.info(retenciones.getTotales().getMontoTotOperacion());
		
		//log.info(total.substring(total.indexOf(".")));
		
		if (total.indexOf(".") > -1 && total.substring(total.indexOf(".")).length() == 1) {
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
		
		cantidadLetra = cantidadLetra.toUpperCase();
		params.put("cantidadLetra", cantidadLetra);
		String textQR ="";
		if (retenciones.getReceptor().getNacionalidad().equals("Nacional")){
			textQR = textQR + "?re=" + retenciones.getEmisor().getRFCEmisor()
					+ "&rr=" + retenciones.getReceptor().getReceptorNacional().getRfcRecep()
					+ "&tt=" + (new DecimalFormat( "0000000000.000000" ).format(Double.parseDouble(retenciones.getTotales().getMontoTotOperacion())));
		}
		if (retenciones.getReceptor().getNacionalidad().equals("Extranjero")){
			textQR = textQR + "?re=" + retenciones.getEmisor().getRFCEmisor()
					+ "&nr=" + retenciones.getReceptor().getReceptorExtranjero().getNumRegIdTrib()
					+ "&tt=" + (new DecimalFormat( "0000000000.000000" ).format(Double.parseDouble(retenciones.getTotales().getMontoTotOperacion())));
		}
		
		if (retenciones.getComplemento() != null && retenciones.getComplemento().getTimbreFiscalDigital() != null) {
			textQR  += "&id=" + retenciones.getComplemento().getTimbreFiscalDigital().getUuid();
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
	
	@RequestMapping(value = "/vistaPrevia", method = RequestMethod.POST)
	public void vistaPrevia( @Valid @ModelAttribute("strComprobante") String strComprobante, 
			BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) throws JAXBException, IOException, JRException, ParserConfigurationException {
		response.setHeader("Content-Disposition","filename=vistaPrevia.pdf");
		
		HttpSession session = request.getSession();
		final String tenant = (String)session.getAttribute("tenantId");
		ComprobantePDF cfdi = getComprobantePDF(strComprobante, tenant);
		generaPDF(cfdi, response.getOutputStream(), tenant);
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
		} else if ("co".equals(xt)) {
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
		} else if ("tn".equals(xt)) {
			tipoCfdi = "RECIBO DE NOMINA";
			numPlantilla = plantilla.getNomina();	
		} else if ("pa".equals(xt)) {
			tipoCfdi = "PAGOS";
			numPlantilla = plantilla.getFactura();	
		} 
		else {
			tipoCfdi = "FACTURA";
			numPlantilla =  plantilla.getFactura();
		}
		
		
		
		
			cfdi.setTipoComprobante(tipoCfdi);
			// DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");		
			// cfdi.setFecha(df.format(new Date()));
			cfdi.setVersion(parametroDao.findByClave("VERSION_XML").getValor());
		/*	
			mx.xpd.cfdi.domain.cfdi.pdf.RegimenFiscal regimen = null;
			regimenFiscalDao.setTenantId(tenant);	
			for(String strRegimen : regimenFiscalDao.getRegimienFiscal(tenant)) {
				regimen = new mx.xpd.cfdi.domain.cfdi.pdf.RegimenFiscal();
				regimen.setRegimen(strRegimen);
				cfdi.getEmisor().getRegimenFiscal().add(regimen);
			}
		*/
			ConfiguracionCFDI config = configuracionDao.findAll(tenant);
			
			//SE QUITO LO DE ExpedidoEn
			
			Map<String, Object> params = null;
			
			/*******************************/
			if (xmlFile != null) {
				if (cfdi.getComplemento() == null) {
					cfdi.setComplemento(new Complemento());
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
		   
		    JAXBContext jaxbContext = JaxbContextSingletonHelper.getInstancePDF();
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd");
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(cfdi, doc);
			StringWriter strXML = new StringWriter(); 
			jaxbMarshaller.marshal(cfdi, strXML);
			String urlPlantilla = parametroDao.findByClave("RUTA_PLANTILLAS").getValor();
			
			
			if (cfdi.getTipoDeComprobante().equals("cp")) {
				urlPlantilla += "/" + numPlantilla + "/cartaPorte.jrxml";
			} else if (cfdi.getComplemento() != null && cfdi.getComplemento().getNotariosPublicos() != null) {
				urlPlantilla += "/" + numPlantilla + "/notarios.jrxml";
			} else if (cfdi.getComplemento() != null && cfdi.getComplemento().getComercioExterior() != null) {
				urlPlantilla += "/" + numPlantilla + "/cce.jrxml";
			} else if (cfdi.getComplemento() != null && cfdi.getComplemento().getPagos() != null) {
				urlPlantilla += "/" + numPlantilla + "/pagos.jrxml";
			} else {
				urlPlantilla += "/" + numPlantilla + "/plantilla.jrxml";
			}
			
			if (cfdi.getComplemento()!=null&&cfdi.getComplemento().getNomina12()!=null){
				urlPlantilla = parametroDao.findByClave("RUTA_PLANTILLAS").getValor();
				urlPlantilla += "/" + numPlantilla+"N12" + "/plantilla.jrxml";
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
	
	
	@RequestMapping(value = "/timbrarRetenciones", method = RequestMethod.POST) 
	public String timbrarRetenciones(@Valid @ModelAttribute("strRetenciones") String strRetenciones, 
			BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		final String rfc = (String)session.getAttribute("tenantId");
		log.info("strRetenciones "+strRetenciones);
		Retenciones retenciones  = gson.fromJson(strRetenciones,  Retenciones.class);
		log.info("retenciones "+retenciones.toString());
				
		retenciones.setVersion("1.0");
		
		/*
		 * Agregamos certificado y sello
		 * */
					
		csdDao.setTenantId(rfc);		
		CertificadoSelloDigital csd = csdDao.findCurrent(rfc);
		String cer = cleanCertificate(csd.getCertificado());
		cer = cer.replaceAll(" ", "").replaceAll("\n", "");
		
		retenciones.setCert(cer);
		retenciones.setNoCertificado(csd.getNoSerie());
		
		RetencionesEmitido retencionesEmitido = new RetencionesEmitido();
		retencionesEmitido.setFechaRegistro(new Date());
		int folio = Integer.parseInt(retenciones.getFolioInt());
		
		if (retencionesDao.existeFolio(folio, rfc)) {
			folio++;
			retenciones.setFolioInt("" + folio);
		}
		
		retencionesEmitido.setFolio(folio);
		retencionesEmitido.setTenantId(rfc);
		retencionesEmitido.setEjercicio(retenciones.getPeriodo().getEjerc());
		retencionesEmitido.setMontoTotalOperacion(Double.valueOf(retenciones.getTotales().getMontoTotOperacion()));
		retencionesEmitido.setMontoTotalRetenciones(Double.valueOf(retenciones.getTotales().getMontoTotRet()));
		
		InputStream input = new ByteArrayInputStream(getXMLRetenciones(retenciones).getBytes("UTF-8"));
		String llave = cleanCertificate(csd.getArchivoKey());
		String xslt = parametroDao.findByClave("PATH_XSLT_CADENA_RETENCIONES").getValor();
		
		String sello = Sello.getSelloRetenciones(input, llave, xslt);
		
		retenciones.setSello(sello);		
				
		retencionesDao.add(retencionesEmitido);
		
		String xml = getXMLRetenciones(retenciones);
		
		String endPoint = "";
		String usuario = "";
		String password = "";
		
		datosEmisorDao.setTenantId(rfc);
		DatosEmisor emisor = datosEmisorDao.findEmisor(rfc);

		if (emisor.isProductivo()) {
			endPoint = parametroDao.findByClave("URL_TIMBRADO_RETENCIONES_PRODUCCION").getValor();
			// Si tiene cuenta Desktop, usamos la subcuenta correspondiente
			if (emisor.getpTimbrado() != null && !emisor.getpTimbrado().isEmpty()) {
				usuario  = emisor.getTenantId();
				password = emisor.getpTimbrado();
			} else {
				usuario  = parametroDao.findByClave("USUARIO_TIMBRADO_RETENCIONES_PRODUCCION").getValor();
				password = parametroDao.findByClave("PASSWORD_TIMBRADO_RETENCIONES_PRODUCCION").getValor();
			}
		} else {
			endPoint = parametroDao.findByClave("URL_TIMBRADO_RETENCIONES_PRUEBAS").getValor();
			usuario = parametroDao.findByClave("USUARIO_TIMBRADO_RETENCIONES_PRUEBAS").getValor();
			password = parametroDao.findByClave("PASSWORD_TIMBRADO_RETENCIONES_PRUEBAS").getValor();
		}
		/*String rfcFecha = parametroDao.findByClave("RFC_FECHA").getValor();
		
		if (rfcFecha != null && rfcFecha.contains(rfc)) {
			endPoint = parametroDao.findByClave("URL_TIMBRADO_ERROR_FECHA").getValor();
		}*/
		
		
		parametroDao.findByClave("PATH_XSLT_CADENA_RETENCIONES").getValor();
		
		TimbradoWSServiceSoapBindingStub timbrarStub =  new TimbradoWSServiceSoapBindingStub();
		timbrarStub.setUsername(usuario);
		timbrarStub.setPassword(password);
		String msg = "";
		String err = "";
		
		mx.xpd.cfdi.timbrado.service.RespuestaTimbrado respo = timbrarStub.timbrar(endPoint, usuario, password, xml.getBytes());
		File file = null; 
		gson = new Gson();
		
		if (respo.getCodigo().equals("200") || respo.getCodigo().equals("200")) {
			String rutaXML = parametroDao.findByClave("PATH_XML_RETENCIONES_TIMBRADO").getValor();
			file = new File(rutaXML + File.separatorChar + retenciones.getEmisor().getRFCEmisor());
			checarCarpeta(file);
			file = new File(file.getAbsolutePath() + File.separatorChar + respo.getUuid()  +".xml");
			BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), "UTF8"));
			String xmlResult = respo.getTimbre();
			
			if (!xmlResult.startsWith("<?xml version=")) {
				fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n");
			}
			
			fileWriter.write(xmlResult);
			fileWriter.flush();
			fileWriter.close();
			
			rutaXML = parametroDao.findByClave("PATH_PDF_RETENCIONES_TIMBRADO").getValor();
			File pdfFile = new File(rutaXML + File.separatorChar + retenciones.getEmisor().getRFCEmisor());
			checarCarpeta(pdfFile);
			pdfFile = new File(pdfFile.getAbsolutePath() + File.separatorChar + respo.getUuid()  +".pdf");
			FileOutputStream out = new FileOutputStream(pdfFile);
			
			RetencionesPDF retencionesPDF = null;
			

			plantillaDao.setTenantId(rfc);
			try {
				retencionesPDF = getRetencionesPDF(strRetenciones, rfc);

				retencionesPDF.setFolio("" + folio);
				retencionesPDF = generaRetencionesPDF(retencionesPDF, out, file, rfc);
				
				out.flush();
				out.close();
				
				retencionesEmitido.setFolio(retencionesPDF.getFolio() == null ? null : Integer.parseInt(retencionesPDF.getFolio()));
				
				if (retencionesPDF.getReceptor().getNacionalidad().equals("Nacional"))
				retencionesEmitido.setRazonSocialReceptor(retencionesPDF.getReceptor().getReceptorNacional().getNomDenRazSocR());
				if (retencionesPDF.getReceptor().getNacionalidad().equals("Extranjero"))
						retencionesEmitido.setRazonSocialReceptor(retencionesPDF.getReceptor().getReceptorExtranjero().getNomDenRazSocREx());
				//retencionesEmitido.setEmail(retencionesPDF.getReceptor().getEmail());
				
				retencionesEmitido.setUuid(retencionesPDF.getComplemento().getTimbreFiscalDigital().getUuid());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			retencionesEmitido.setEstatus("emitido");
			retencionesEmitido.setJson(strRetenciones);
			retencionesEmitido.setReceptor(retencionesPDF.getReceptor());
			retencionesEmitido.setEmisor(retencionesPDF.getEmisor());
			
			retencionesDao.merge(retencionesEmitido);
			
			if (!emisor.isGratuito()) {
				if (!emisor.getTipoPlan()) {//Es de plan anterior, entonces hay que descontar folios
					emisor.setFoliosDisponibles(emisor.getFoliosDisponibles() - 1);
					datosEmisorDao.setTenantId(rfc);
					datosEmisorDao.update(emisor);
				}
			}
			
			msg = "Retenciones generadas correctamente";
			err = "0";
		} else {
				retencionesDao.remove(retencionesEmitido.getId());
			
			
				RetencionesNoTimbrado ret = new RetencionesNoTimbrado();
				ret.setCodigo(respo.getCodigo());
				ret.setFechaRegistro(new Date());
				ret.setTenant_id(rfc);
				ret.setJson(strRetenciones);
				ret.setMensaje(respo.getMensaje());
				ret.setXml(xml);
				retencionesDao.addRetencionesNoTimbrado(ret);
			
			
			
			log.info(respo.getCodigo() + " | " + respo.getMensaje());
			log.info(strRetenciones);
			log.info(xml);
			msg = respo.getMensaje();
			err = "1";
		}
		if (retencionesEmitido.getEstatus() == null) {
			retencionesDao.remove(retencionesEmitido.getId());
		}
		
		return "redirect:/comprobante/listarRetenciones/?msg=" + msg + "&err=" + err;
	}
	
	@RequestMapping(value = "/vistaPreviaRetenciones", method = RequestMethod.POST)
	public void vistaPreviaRetenciones( @Valid @ModelAttribute("strRetenciones") String strRetenciones, 
			BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) throws JAXBException, IOException, JRException, ParserConfigurationException {
		response.setHeader("Content-Disposition","filename=vistaPrevia.pdf");
		
		HttpSession session = request.getSession();
		final String tenant = (String)session.getAttribute("tenantId");
		System.out.println("strRetenciones "+strRetenciones);
		RetencionesPDF retenciones = getRetencionesPDF(strRetenciones, tenant);
		log.info("retenciones "+retenciones);
		generaPDF(retenciones, response.getOutputStream(), tenant);
	}
	
	private RetencionesPDF generaPDF(RetencionesPDF retenciones, OutputStream out, String tenant) {
		return generaRetencionesPDF(retenciones, out, null, tenant);
	}
	
	private RetencionesPDF getRetencionesPDF(String strRetenciones, String tenant) {
		Gson gson = new Gson();	
		RetencionesPDF retenciones  = gson.fromJson(strRetenciones,  RetencionesPDF.class);	
		return retenciones;
	}
	
	private RetencionesPDF generaRetencionesPDF(RetencionesPDF retenciones, OutputStream out, File xmlFile, String tenant) {
		try {
			plantillaDao.setTenantId(tenant);
			ConfiguracionPlantilla plantilla = plantillaDao.find(tenant);
			String tipoCfdi = "RETENCIONES_PAGOS";
			
			if (plantilla == null) {
				plantilla = new ConfiguracionPlantilla();
			}
			int numPlantilla = 400; 
		
					
			retenciones.setVersion("1.0");
			Map<String, Object> params = null;
			
			
			if (xmlFile != null) {
				if (retenciones.getComplemento() == null) {
					retenciones.setComplemento(new ComplementoRetenciones());
				}
				retenciones.getComplemento().setTimbreFiscalDigital(ComprobanteRetencionesPDFUtil.getTimbre(xmlFile));
				csdDao.setTenantId(tenant);
				retenciones.setNoCertificado(csdDao.findCurrent(tenant).getNoSerie());
				params = this.getParamsRetenciones(retenciones, tipoCfdi);
								
			} else {
				params = this.getParamsRetenciones(retenciones);
			}
			
			String pathLogo = parametroDao.findByClave("PATH_IMG_LOGO").getValor() + tenant + ".png";
			File logoFile = new File(pathLogo);
			
			if (logoFile.exists()) {
				params.put("logo", logoFile.getAbsolutePath());
			} 
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		    dbf.setNamespaceAware(true);
		    Document doc = dbf.newDocumentBuilder().newDocument();
		   
		    JAXBContext jaxbContext = JAXBContext.newInstance(RetencionesPDF.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.sat.gob.mx/esquemas/retencionpago/1 http://www.sat.gob.mx/esquemas/retencionpago/1/retencionpagov1.xsd");
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(retenciones, doc);
			StringWriter strXML = new StringWriter(); 
			jaxbMarshaller.marshal(retenciones, strXML);
			String urlPlantilla = parametroDao.findByClave("RUTA_PLANTILLAS").getValor();
					
			
			urlPlantilla += "/" + numPlantilla + "/plantillaRetenciones.jrxml";
						
			
			PDFExporter.xmlToPDF(urlPlantilla, params, doc, out);
			return retenciones;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/listarRetenciones" ,method = RequestMethod.GET)
	public String listarRetenciones(Model model, HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date datemin = new Date();
		fechasUtil = new FechasUtil();
		String date = sdf.format(datemin);
		// -- Se obtienen el primer y ultimo dia del mes para hacer la consulta.
		String array[] = date.split("-");
		int primerDiaMes = fechasUtil.getPrimerDiaDelMes(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
		int ultimoDiaMes = fechasUtil.getUltimoDiaDelMes(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
		// ---------------------------------------------------------------------
		return filtrarPeriodoRetenciones(date + "-"+primerDiaMes, date + "-"+ultimoDiaMes, model, request);
	}
		
	private String getXMLRetenciones(Retenciones retenciones) {
		String result = null;
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Retenciones.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
						
			StringBuilder schema = new StringBuilder();
						
			schema.append("http://www.sat.gob.mx/esquemas/retencionpago/1 http://www.sat.gob.mx/esquemas/retencionpago/1/retencionpagov1.xsd ");
			
			if (retenciones.getComplemento() != null) {
				if (retenciones.getComplemento().getArrendamientoEnFideicomiso() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/arrendamientoenfideicomiso http://www.sat.gob.mx/esquemas/retencionpago/1/arrendamientoenfideicomiso/arrendamientoenfideicomiso.xsd");
				}
				if (retenciones.getComplemento().getIntereses() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/intereses http://www.sat.gob.mx/esquemas/retencionpago/1/intereses/intereses.xsd");
				}
				if (retenciones.getComplemento().getInteresesHipotecarios() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/intereseshipotecarios http://www.sat.gob.mx/esquemas/retencionpago/1/intereseshipotecarios/intereseshipotecarios.xsd");
				}
				if (retenciones.getComplemento().getOperacionesconderivados() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/operacionesconderivados http://www.sat.gob.mx/esquemas/retencionpago/1/operacionesconderivados/operacionesconderivados.xsd");
				}
				if (retenciones.getComplemento().getPlanesderetiro() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro/planesderetiro.xsd");
				}
				if (retenciones.getComplemento().getPlanesderetiro11() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro11 http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro11/planesderetiro.xsd");
				}
				if (retenciones.getComplemento().getPremios() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/premios http://www.sat.gob.mx/esquemas/retencionpago/1/premios/premios.xsd");
				}
				if (retenciones.getComplemento().getSectorFinanciero() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/sectorfinanciero http://www.sat.gob.mx/esquemas/retencionpago/1/sectorfinanciero/sectorfinanciero.xsd");
				}
				if (retenciones.getComplemento().getEnajenacionDeAcciones() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/enajenaciondeacciones http://www.sat.gob.mx/esquemas/retencionpago/1/enajenaciondeacciones/enajenaciondeacciones.xsd");
				}
				if (retenciones.getComplemento().getPagosaExtranjeros() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros/pagosaextranjeros.xsd");
				}
				if (retenciones.getComplemento().getDividendos() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos/dividendos.xsd");
				}
				if (retenciones.getComplemento().getFideicomisonoempresarial() != null) {
					schema.append(" http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial/fideicomisonoempresarial.xsd");
				}

			}
						
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schema.toString());
				
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//jaxbMarshaller.marshal(cfdi, doc);
			if (retenciones.getDescRetenc()!=null){
				if (retenciones.getDescRetenc().equals(""))
					retenciones.setDescRetenc(null);
				if (retenciones.getEmisor().getNomDenRazSocE().equals(""))
					retenciones.getEmisor().setNomDenRazSocE(null);
				if (retenciones.getEmisor().getCURPE() !=null){
					if (retenciones.getEmisor().getCURPE().equals(""))
						retenciones.getEmisor().setCURPE(null);
				}
				
				if (retenciones.getReceptor().getNacionalidad().equals("Nacional")){
					if (retenciones.getReceptor().getReceptorNacional().getNomDenRazSocR() !=null){
						if (retenciones.getReceptor().getReceptorNacional().getNomDenRazSocR().equals(""))
							retenciones.getReceptor().getReceptorNacional().setNomDenRazSocR(null);
					}
					if (retenciones.getReceptor().getReceptorNacional().getCurpR() != null){
						if (retenciones.getReceptor().getReceptorNacional().getCurpR().equals(""))	
							retenciones.getReceptor().getReceptorNacional().setCurpR(null);
					}
				}
				if (retenciones.getReceptor().getNacionalidad().equals("Extranjero")){
					if (retenciones.getReceptor().getReceptorExtranjero().getNumRegIdTrib() !=null){
						if (retenciones.getReceptor().getReceptorExtranjero().getNumRegIdTrib().equals(""))
							retenciones.getReceptor().getReceptorExtranjero().setNumRegIdTrib(null);
					}
				}
				for (int i=0;i<retenciones.getTotales().getImpuestos().size();i++){
					if (retenciones.getTotales().getImpuestos().get(i).getBaseRet() != null){
						if (retenciones.getTotales().getImpuestos().get(i).getBaseRet().equals(""))
							retenciones.getTotales().getImpuestos().get(i).setBaseRet(null);
					}
					if (retenciones.getTotales().getImpuestos().get(i).getImpuesto() != null){
						if (retenciones.getTotales().getImpuestos().get(i).getImpuesto().equals(""))
							retenciones.getTotales().getImpuestos().get(i).setImpuesto(null);
					}
				}
				
			}
			
			
			StringWriter strXML = new StringWriter(); 
			jaxbMarshaller.marshal(retenciones, strXML);
			result = strXML.toString();
						
			result = result.replace("retenciones:ArrendamientoEnFideicomiso", "arrendamientoenfideicomiso:Arrendamientoenfideicomiso");
			result = result.replace("retenciones:InteresesHipotecarios", "intereseshipotecarios:Intereseshipotecarios");
			result = result.replace("retenciones:Intereses", "intereses:Intereses");
			result = result.replace("retenciones:OperacionesConDerivados", "operacionesconderivados:Operacionesconderivados");
			result = result.replace("retenciones:PlanesDeRetiro11", "planesderetiro11:Planesderetiro");
			result = result.replace("retenciones:PlanesDeRetiro", "planesderetiro:Planesderetiro");
			result = result.replace("retenciones:Premios", "premios:Premios");
			result = result.replace("retenciones:SectorFinanciero", "sectorfinanciero:SectorFinanciero");
			result = result.replace("retenciones:EnajenacionDeAcciones", "enajenaciondeacciones:EnajenaciondeAcciones");
			result = result.replace("retenciones:PagosAExtranjeros", "pagosaextranjeros:Pagosaextranjeros");
			result = result.replace("<NoBeneficiario", "<pagosaextranjeros:NoBeneficiario");
			result = result.replace("<Beneficiario", "<pagosaextranjeros:Beneficiario");
			result = result.replace("retenciones:Dividendos", "dividendos:Dividendos");
			result = result.replace("<Remanente", "<dividendos:Remanente");
			result = result.replace("<DividOUtil", "<dividendos:DividOUtil");
			result = result.replace("retenciones:FideicomisoNoEmpresarial", "fideicomisonoempresarial:Fideicomisonoempresarial");
			result = result.replaceAll("IngresosOEntradas", "fideicomisonoempresarial:IngresosOEntradas");
			result = result.replaceAll("IntegracIngresos", "fideicomisonoempresarial:IntegracIngresos");
			result = result.replaceAll("DeduccOSalidas", "fideicomisonoempresarial:DeduccOSalidas");
			result = result.replaceAll("IntegracEgresos", "fideicomisonoempresarial:IntegracEgresos");
			result = result.replaceAll("RetEfectFideicomiso", "fideicomisonoempresarial:RetEfectFideicomiso");
			result = result.replaceAll("AportacionesODepositos", "planesderetiro11:AportacionesODepositos");
			
			if (retenciones.getComplemento() != null) {
				if (retenciones.getComplemento().getFideicomisonoempresarial() != null) {
					StringBuffer sb =  new StringBuffer();
					sb.append(result.substring(0,result.indexOf("<fideicomisonoempresarial:DeduccOSalidas")));
					sb.append(result.substring(result.indexOf("<fideicomisonoempresarial:IngresosOEntradas"), result.indexOf("<fideicomisonoempresarial:RetEfectFideicomiso")));
					sb.append(result.substring(result.indexOf("<fideicomisonoempresarial:DeduccOSalidas"), result.indexOf("<fideicomisonoempresarial:IngresosOEntradas")));
					sb.append(result.substring(result.indexOf("<fideicomisonoempresarial:RetEfectFideicomiso")));
				
					result = sb.toString();
				}
			}
			 
			
			
			if (retenciones.getComplemento() != null) {
				if (retenciones.getComplemento().getArrendamientoEnFideicomiso() == null) {
					result = result.replace("xmlns:arrendamientoenfideicomiso=\"http://www.sat.gob.mx/esquemas/retencionpago/1/arrendamientoenfideicomiso\"", "");
				}
				if (retenciones.getComplemento().getIntereses() == null) {
					result = result.replace("xmlns:intereses=\"http://www.sat.gob.mx/esquemas/retencionpago/1/intereses\"", "");
				}
				if (retenciones.getComplemento().getInteresesHipotecarios() == null) {
					result = result.replace("xmlns:intereseshipotecarios=\"http://www.sat.gob.mx/esquemas/retencionpago/1/intereseshipotecarios\"", "");
				}
				if (retenciones.getComplemento().getOperacionesconderivados() == null) {
					result = result.replace("xmlns:operacionesconderivados=\"http://www.sat.gob.mx/esquemas/retencionpago/1/operacionesconderivados\"", "");
				}
				if (retenciones.getComplemento().getPlanesderetiro() == null) {
					result = result.replace("xmlns:planesderetiro=\"http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro\"", "");
				}
				if (retenciones.getComplemento().getPlanesderetiro11() == null) {
					result = result.replace("xmlns:planesderetiro11=\"http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro11\"", "");
				}
				if (retenciones.getComplemento().getPremios() == null) {
					result = result.replace("xmlns:premios=\"http://www.sat.gob.mx/esquemas/retencionpago/1/premios\"", "");
				}
				if (retenciones.getComplemento().getSectorFinanciero() == null) {
					result = result.replace("xmlns:sectorfinanciero=\"http://www.sat.gob.mx/esquemas/retencionpago/1/sectorfinanciero\"", "");
				}
				if (retenciones.getComplemento().getEnajenacionDeAcciones() == null) {
					result = result.replace("xmlns:enajenaciondeacciones=\"http://www.sat.gob.mx/esquemas/retencionpago/1/enajenaciondeacciones\"", "");
				}
				if (retenciones.getComplemento().getPagosaExtranjeros() == null) {
					result = result.replace("xmlns:pagosaextranjeros=\"http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros\"", "");
				}
				if (retenciones.getComplemento().getDividendos() == null) {
					result = result.replace("xmlns:dividendos=\"http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos\"", "");
				}
				if (retenciones.getComplemento().getFideicomisonoempresarial() == null) {
					result = result.replace("xmlns:fideicomisonoempresarial=\"http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial\"", "");
				}
			
				
				
			} else {
				
				result = result.replace("xmlns:arrendamientoenfideicomiso=\"http://www.sat.gob.mx/esquemas/retencionpago/1/arrendamientoenfideicomiso\"", "");
				result = result.replace("xmlns:intereseshipotecarios=\"http://www.sat.gob.mx/esquemas/retencionpago/1/intereseshipotecarios\"", "");
				result = result.replace("xmlns:intereses=\"http://www.sat.gob.mx/esquemas/retencionpago/1/intereses\"", "");
				result = result.replace("xmlns:operacionesconderivados=\"http://www.sat.gob.mx/esquemas/retencionpago/1/operacionesconderivados\"", "");
				result = result.replace("xmlns:planesderetiro=\"http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro\"", "");
				result = result.replace("xmlns:planesderetiro11=\"http://www.sat.gob.mx/esquemas/retencionpago/1/planesderetiro11\"", "");
				result = result.replace("xmlns:premios=\"http://www.sat.gob.mx/esquemas/retencionpago/1/premios\"", "");
				result = result.replace("xmlns:sectorfinanciero=\"http://www.sat.gob.mx/esquemas/retencionpago/1/sectorfinanciero\"", "");
				result = result.replace("xmlns:enajenaciondeacciones=\"http://www.sat.gob.mx/esquemas/retencionpago/1/enajenaciondeacciones\"", "");
				result = result.replace("xmlns:pagosaextranjeros=\"http://www.sat.gob.mx/esquemas/retencionpago/1/pagosaextranjeros\"", "");
				result = result.replace("xmlns:dividendos=\"http://www.sat.gob.mx/esquemas/retencionpago/1/dividendos\"", "");
				result = result.replace("xmlns:fideicomisonoempresarial=\"http://www.sat.gob.mx/esquemas/retencionpago/1/fideicomisonoempresarial\"", "");
				
			}
			
		} catch(Exception e) {
			log.error("Error: " + e);
			e.printStackTrace();
		} finally {
			return result;
		}
	}
	
	
	@RequestMapping(value="/timbrarRetencionesFile", method=RequestMethod.POST)
	public String editar(Model model, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
		HttpSession session = request.getSession();
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		
		try {
			DatosEmisor datos = datosEmisorDao.findEmisor(tenantID);
			
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
				return "redirect:/comprobante/listarRetenciones/";
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
			
			RetencionesThread nomT = new RetencionesThread();
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/comprobante/listarRetenciones/";
	}
	
class RetencionesThread extends Thread {
        
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
    			
    			
    			TUbicacion domicilio = new TUbicacion();
    			BeanUtils.copyProperties(domicilio, dE);
    			domicilio.setMunicipio(dE.getDelegacionMunicipio());
    			Emisor emisor = new Emisor();
    			emisor.setRfc(dE.getRfc());
    			emisor.setNombre(dE.getRazonSocial());
    			emisor.setDomicilioFiscal(domicilio);
    			emisor.setRegimenFiscal(dE.getRegimenFiscal());
    			
    			Retenciones retenc = new Retenciones();
    			//retenc.setEmisor(emisor);
    			retenc.setVersion("1.0");
    			
    			
    			/* Certificado */ 
    			String cer = cleanCertificate(csd.getCertificado());
    			cer = cer.replaceAll(" ", "").replaceAll("\n", "");
    			retenc.setNoCertificado(csd.getNoSerie());
    			    			
    			//cfdi.setTipoDeComprobante("egreso");
    			//cfdi.setFormaDePago("PAGO EN UNA SOLA EXHIBICIÓN");
    			
    			
    			log.info("ok");
    			
    			Complemento compĺemento = new Complemento();
    			Receptor receptor = null;
    			Concepto concepto;
    			Retencion retencion = null;
    			//Nomina nomina = null;
    			
    			
    			XSSFCell cell = null;
    			XSSFWorkbook workBook =  new XSSFWorkbook(file);
    			XSSFSheet sheet = workBook.getSheetAt(1);
    			
    		
    			
    			Iterator rowIterator = sheet.rowIterator();
    			DecimalFormat df = new DecimalFormat("#######0.000000");
    			if (!rowIterator.hasNext()) return;
    			rowIterator.next();
    			rowIterator.next();
    			while (rowIterator.hasNext()) {
    				XSSFRow hssfRow = (XSSFRow) rowIterator.next();
    				Iterator iterator = hssfRow.cellIterator();
    				
    								
    				
    				retenc = new Retenciones();
    				
    				/* Empleado */ 
    				receptor = new Receptor();
    				
    				cell = hssfRow.getCell(0);
    				receptor.setRfc(cell == null ? null : cell.toString());
    				
    				cell = hssfRow.getCell(1);
    				receptor.setNombre(cell == null ? null : cell.toString());
    				
    				/* DatosNomina */
    				cell = hssfRow.getCell(1);	
    				retenc.setCveRetenc(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(3);
    				
    				/*nomina.setNumEmpleado(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(4);
    				nomina.setCurp(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(5); // TODO: tipoRegimen
    				String tipoRegimen = cell == null ? "" : cell.toString();
    				if (!tipoRegimen.isEmpty()) {
    					nomina.setTipoRegimen(Integer.parseInt(cell.toString().substring(0, 1)));
    				}
    				cell = hssfRow.getCell(6);
    				nomina.setNumSeguridadSocial(cell == null ? null : "" + cell.toString());
    				cell = hssfRow.getCell(7);
    				nomina.setFechaPago(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(8);
    				String inicio = (cell == null ? "" : cell.toString());
    				nomina.setFechaInicialPago(inicio);
    				cell = hssfRow.getCell(9);
    				String fin = (cell == null ? "" : cell.toString());
    				nomina.setFechaFinalPago(fin);
    				cell = hssfRow.getCell(10);
    				nomina.setNumDiasPagados(getDouble(cell.toString()));
    				cell = hssfRow.getCell(11);
    				nomina.setDepartamento(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(12);
    				String clabe = cell == null || cell.toString().trim().isEmpty() ? null : cell.toString();
    				
    				if (clabe != null) {
    					//BigDecimal bg = new BigDecimal(clabe);
    					
    					nomina.setClabe(clabe);
    				}
    				cell = hssfRow.getCell(13); // TODO: Banco
    				String banco = cell == null ? "" : cell.toString();
    				if (!banco.isEmpty()) {
    					nomina.setBanco(cell.toString().substring(0, 3));
    				}
    				
    				cell = hssfRow.getCell(14);
    				nomina.setFechaInicioRelLaboral(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(15); // TODO: Angiguedad
    				String antiguedad = cell == null || cell.toString().trim().isEmpty() ? "" : cell.toString();
    				if (!antiguedad.isEmpty()) {
    					nomina.setAntiguedad((new Double(antiguedad)).intValue());
    				}
    				cell = hssfRow.getCell(16);
    				nomina.setPuesto(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(17); // TODO: tipoContrato
   					nomina.setTipoContrato(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(18); // TODO: tiopoJornada
    				nomina.setTipoJornada(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(19);
    				nomina.setPeriodicidadPago(cell == null ? null : cell.toString());
    				cell = hssfRow.getCell(20);
    				String salarioActorado = cell == null ? "" : cell.toString();
    				if (!salarioActorado.isEmpty()) {
    					nomina.setSalarioBaseCotApor(getDouble(cell.toString()));
    				}
    				cell = hssfRow.getCell(21); // TODO: Riesgo
    				String riesgo = cell == null ? "" : cell.toString();
    				if (!riesgo.isEmpty()) {
    					nomina.setRiesgoPuesto(Integer.parseInt(cell.toString().substring(0, 1)));
    				}
    				cell = hssfRow.getCell(22);
    				String salario = cell == null ? "" : cell.toString();
    				if (!salario.isEmpty()) {
    					nomina.setSalarioDiarioIntegrado(getDouble(cell.toString()));
    				}
    				
    				
    				
    				/* Fecha del CFDI */
    				DateFormat dfor = new SimpleDateFormat("yyyy-MM-dd'T'00:00:01");
    				retenc.setFechaExp(dfor.format(new Date()));
    				
    				
    				
    				
    				
    				
    				
    				InputStream input = new ByteArrayInputStream(getXMLRetenciones(retenc).getBytes("UTF-8"));
    				
    				String llave = cleanCertificate(csd.getArchivoKey());
    				String xslt = parametroDao.findByClave("PATH_XSLT_CADENA").getValor();
    				String sello = Sello.getSello(input, llave, xslt);
    				retenc.setSello(sello);		
    				String xml = getXMLRetenciones(retenc);
    				log.info("XML NOMINA: \n" + xml);
    				
    				
    				
    				errores = timbrarXMLRetenciones(tenantID, retenc, xml, wError, hssfRow, errores, session);

    			}
    		} catch(Exception e) {
    			log.error(e);
    			e.printStackTrace();
    		}
    		
    		FileOutputStream sErrores = null;
    		try {
    			sErrores = new FileOutputStream("/home/cfdi/tmp/" + tenantID +".xlsm");
    			wError.write(sErrores);
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

private XSSFWorkbook crearRespuesta() {
	XSSFWorkbook workBook = null;
	try {
		workBook = new XSSFWorkbook(new FileInputStream("/home/cfdi/files/layout.xlsm"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return workBook;
}

private int timbrarXMLRetenciones(String tenant, Retenciones retenciones, String xml, XSSFWorkbook WErr, XSSFRow fila, int errores, HttpSession session) throws IOException, SAXException, ParserConfigurationException, JRException {
	try {
		DatosEmisor emisor = datosEmisorDao.findEmisor(tenant);
		String endPoint = "";
		String usuario = "";
		String password = "";
		
		if (emisor.isProductivo()) {
			endPoint = parametroDao.findByClave("URL_TIMBRADO_RETENCIONES_PRODUCCION").getValor();
			usuario  = parametroDao.findByClave("USUARIO_TIMBRADO_RETENCIONES_PRODUCCION").getValor();
			password = parametroDao.findByClave("PASSWORD_TIMBRADO_RETENCIONES_PRODUCCION").getValor();
		} else {
			endPoint = parametroDao.findByClave("URL_TIMBRADO_RETENCIONES_PRUEBAS").getValor();
			usuario = parametroDao.findByClave("USUARIO_TIMBRADO_RETENCIONES_PRUEBAS").getValor();
			password = parametroDao.findByClave("PASSWORD_TIMBRADO_RETENCIONES_PRUEBAS").getValor();
		}
		
		TimbradoWSServiceSoapBindingStub timbrarStub =  new TimbradoWSServiceSoapBindingStub();
		timbrarStub.setUsername(usuario);
		timbrarStub.setPassword(password);
		String msg = "";
		String err = "";
		
		mx.xpd.cfdi.timbrado.service.RespuestaTimbrado respo = timbrarStub.timbrar(endPoint, usuario, password, xml.getBytes());
		File file = null; 
		
		log.info(respo.getCodigo() + " - " + respo.getMensaje());
		
		if (respo.getCodigo().equals("200") || respo.getCodigo().equals("504")) {
			String rutaXML = parametroDao.findByClave("PATH_EXTERNO_XML_TIMBRADO").getValor();
			file = new File(rutaXML + File.separatorChar + retenciones.getEmisor().getRFCEmisor());
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
			emisor1.setFoliosDisponibles(emisor.getFoliosDisponibles() - 1);
			datosEmisorDao.update(emisor1);
			
			CfdEmitido cfdEmitido = new CfdEmitido();
			cfdEmitido.setEliminado(false);
			cfdEmitido.setEnviado(false);
			cfdEmitido.setEstatus("emitido");
			cfdEmitido.setFechaDate(new Date());
			//cfdEmitido.setRazonSocialReceptor(cfdi.getReceptor().getNombre());
			//cfdEmitido.setRfcReceptor(cfdi.getReceptor().getRfc());
			//cfdEmitido.setFormaDePago(cfdi.getFormaDePago());
			cfdEmitido.setIva(0D);
			cfdEmitido.setSemaforo(false);
			//cfdEmitido.setSubTotal(Double.parseDouble(cfdi.getSubTotal()));
			cfdEmitido.setTipoComprobante("RETENCIONES");
			//cfdEmitido.setTotal(Double.parseDouble(cfdi.getTotal()));
			cfdEmitido.setUltimaActualizacion(new Date());
			cfdEmitido.setTenantId(tenant);
			cfdEmitido.setFechaRegistro(new Date());
			cfdEmitido.setUuid(respo.getUuid());
			cfdEmitido.setJson("EXCEL");
			//cfdEmitido.setIsr(Double.parseDouble(cfdi.getImpuestos().getTotalImpuestosRetenidos()));
			
	
			
			CfdEmitido tmp1 = comprobanteDao.findByUuid(respo.getUuid());
			if (respo.getCodigo().equals("200") || (respo.getCodigo().equals("504") && tmp1 == null)) {
				comprobanteDao.add(cfdEmitido);
			}
			
			
			String urlPlantilla = parametroDao.findByClave("RUTA_PLANTILLAS").getValor();
			int numPlantilla =  plantillaDao.find(tenant).getNomina();
			
			if (parametroDao.findByClave("RFC_NOMINA").getValor().equals(retenciones.getEmisor().getRFCEmisor())) {
				numPlantilla = Integer.parseInt(parametroDao.findByClave("PLANTILLA_NOMINA").getValor());
			}
			
			
			JasperReport report = JasperCompileManager.compileReport(urlPlantilla + File.separatorChar + numPlantilla +  File.separatorChar + "plantilla.jrxml");
			
			
			
//			JasperReport report = (JasperReport) JRLoader.loadObject(plantilla);
			
					
	
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(false);
			
			Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xmlResult.getBytes("UTF-8")));
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("XML_DATA_DOCUMENT", doc);

						
			String cantidadLetra = "";
			
			try {
				cantidadLetra = new java.util.Scanner(new java.net.URL("http://portal.expidetufactura.com.mx:86/ws/numero_a_letra_ireport.php?numero="+retenciones.getTotales().getMontoTotOperacion()).openStream()).nextLine();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cantidadLetra = cantidadLetra.toUpperCase();
			params.put("cantidadLetra", cantidadLetra);
			
			String pathLogo = parametroDao.findByClave("PATH_IMG_LOGO").getValor() + tenant + ".png";
			
			
			
			String pathPdf = parametroDao.findByClave("PATH_EXTERNO_PDF_TIMBRADO").getValor();
			
			String textQR ="";
			if (retenciones.getReceptor().getNacionalidad().equals("Nacional")){
				textQR = "?re=" + retenciones.getEmisor().getRFCEmisor()
						+ "&rr=" + retenciones.getReceptor().getReceptorNacional().getRfcRecep()
						+ "&tt=" + (new DecimalFormat( "0000000000.000000" ).format(Double.parseDouble(retenciones.getTotales().getMontoTotOperacion())));
			}
			if (retenciones.getReceptor().getNacionalidad().equals("Extranjero")){
				textQR = "?re=" + retenciones.getEmisor().getRFCEmisor()
						+ "&rr=" + retenciones.getReceptor().getReceptorExtranjero().getNomDenRazSocREx()
						+ "&tt=" + (new DecimalFormat( "0000000000.000000" ).format(Double.parseDouble(retenciones.getTotales().getMontoTotOperacion())));
			}
			
			if (retenciones.getComplemento() != null && retenciones.getComplemento().getTimbreFiscalDigital() != null) {
				textQR  += "&id=" + retenciones.getComplemento().getTimbreFiscalDigital().getUuid();
				//log.info(textQR);
			} else {
				textQR  += "&id=Comprobante sin timbrar.";
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
			
			
		} else {
			XSSFSheet sheet = WErr.getSheetAt(1);
			XSSFRow row =  sheet.createRow(errores + 2);
			Iterator it = fila.iterator();
			
			int cellnum = 0;
			while (it.hasNext()) {
				
				XSSFCell cell = row.createCell(cellnum++);
				cell.setCellValue(((XSSFCell)it.next()).toString());
				
			}
			int procesar = Integer.parseInt(session.getAttribute("totalErrores").toString()) + 1;
			session.setAttribute("totalErrores", procesar);
			
			row = fila;
			errores++;
		}
	} catch (Exception e) {
		e.printStackTrace();
		errores++;
	}
	return errores;
}

	public void enviarMailCuentasPorPagar(String mailCxP, String tenantID, String uuid, String ruta) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.expidetufactura.com.mx");
		props.put("mail.smtp.port",  25);
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
			from[0] = new InternetAddress( "cfdi@portal.expidetufactura.com.mx" );
			message.setFrom(new InternetAddress( "cfdi@portal.expidetufactura.com.mx" ));
			
			message.setReplyTo(from);
			
			InternetAddress [] arregloDestinatarios = new InternetAddress[1];
			//arregloDestinatarios[0] = new InternetAddress(tenantID+"@cuentasporpagar.com");
			arregloDestinatarios[0] = new InternetAddress(mailCxP);
			
			
			message.setRecipients(Message.RecipientType.TO,	arregloDestinatarios);
			message.setSubject("Envio Factura desde XPD");
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
			String mensaje = "Mensaje del correo";
			banner    = mensaje;
			texto.setContent(banner, "text/html");
			
			mp.addBodyPart(texto);
			String rutaXML = ruta + File.separatorChar + "xml"+ File.separatorChar + tenantID + File.separatorChar;
			rutaXML+= uuid + ".xml";
			String rutaPDF = ruta + File.separatorChar + "pdf" + File.separatorChar + tenantID + File.separatorChar;
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
			log.info("Archivo enviado: "+rutaXML+" al correo "+mailCxP);
		} catch (Exception e) {
			log.info("cacho una excepcion : " +  e.getMessage());
			e.printStackTrace();
			log.debug("Error enviando correo electronico = "+e.getMessage());
			//e.printStackTrace();
		}
	}
	
	public boolean enviarMailNomina(String mailEmpleado, String mailEmisor, String tenantID, String uuid, String ruta, String strSubject, String strCuerpoCorreo) throws javax.mail.SendFailedException{
		Properties props = new Properties();
		props.put("mail.smtp.host", "mail.expidetufactura.com.mx");
		props.put("mail.smtp.port",  25);
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
	
	String cambiaCaracteres(String xmlResult, List<mx.xpd.cfdi.domain.cfdi.Concepto> conceptos){
		String xmlResultCambiado = org.apache.commons.lang3.StringEscapeUtils.unescapeHtml3(xmlResult);
		
		String strReceptorOrig = xmlResult.substring(xmlResult.indexOf("<cfdi:Receptor"), xmlResult.indexOf(">", xmlResult.indexOf("<cfdi:Receptor")));
		String strReceptorCambiado = xmlResultCambiado.substring(xmlResultCambiado.indexOf("<cfdi:Receptor"), xmlResultCambiado.indexOf(">", xmlResultCambiado.indexOf("<cfdi:Receptor")));
		
		xmlResultCambiado = xmlResultCambiado.replaceAll(strReceptorCambiado, strReceptorOrig);
		boolean blnCambiarConceptos  = false;
		
		for (int i=0;i <conceptos.size();i++){
			String strDesc = conceptos.get(i).getDescripcion();
			if (conceptos.get(i).getDescripcion().contains("&")){
				blnCambiarConceptos = true;
				strDesc = strDesc.replaceAll("&", "&amp;");
			}
			if (conceptos.get(i).getDescripcion().contains("\"")){
				blnCambiarConceptos = true;
				strDesc = strDesc.replaceAll("\"", "&quot;");
			}
			if (conceptos.get(i).getDescripcion().contains("<")){
				blnCambiarConceptos = true;
				strDesc = strDesc.replaceAll("<", "&lt;");
			}
			if (conceptos.get(i).getDescripcion().contains(">")){
				blnCambiarConceptos = true;
				strDesc = strDesc.replaceAll(">", "&gt;");
			}
			if (blnCambiarConceptos){
				xmlResultCambiado = xmlResultCambiado.replace( conceptos.get(i).getDescripcion(), strDesc );
				
			}	
		}

		return xmlResultCambiado;
	}
	
	
	String cambiaPais(String strPais){
		if (strPais.equals("México")){
			strPais = "MEX";
		}
		else
			if (strPais.equals("Estados Unidos")){
				strPais = "USA";
			}
			else{
				strPais = paisEstadosDao.findClavePais(strPais);
			}
		return strPais;
	}
	
	String cambiaEstado(String strEstado){
		strEstado = paisEstadosDao.findClaveEstado(strEstado);
		return strEstado;
	}
	
	String cambiaMunicipio(String strMunicipio, String strEstado){
		strMunicipio = paisEstadosDao.findClaveMunicipio(strMunicipio, strEstado);
		return strMunicipio;
	}
	
	String cambiaLocalidad(String strLocalidad, String strEstado){
		strLocalidad = paisEstadosDao.findClaveLocalidad(strLocalidad, strEstado);
		return strLocalidad;
	}
	
	String cambiaColonia(String cp, String colonia){
		colonia = coloniaDao.findByCPNombre(cp, colonia);
		return colonia;
	}
	
	String cambiaUnidadMedida(String strUnidadMedida){
		 if (strUnidadMedida.equals("Kilogramo")){
			 strUnidadMedida = "KILO";
		 }
		 if (strUnidadMedida.equals("Metro")){
			 strUnidadMedida = "METRO LINEAL";
		 }
		 if (strUnidadMedida.equals("Metro cuadrado")){
			 strUnidadMedida = "METRO CUADRADO";
		 }
		 if (strUnidadMedida.equals("Metro cúbico")){
			 strUnidadMedida = "METRO CUBICO";
		 }
		 if (strUnidadMedida.equals("Litro")){
			 strUnidadMedida = "LITRO";
		 }
		 if (strUnidadMedida.equals("Tonelada")){
			 strUnidadMedida = "TONELADA";
		 }
		 if (strUnidadMedida.equals("Pieza")){
			 strUnidadMedida = "6";
		 }
		return strUnidadMedida;
	}

	@RequestMapping(value = "/cargarxmlprefactura", method = RequestMethod.POST)
	public @ResponseBody Prefactura cargarxmlprefactura(@RequestBody String xml)
			throws JAXBException, IOException, JRException, ParserConfigurationException {
		PrefacturaUtil prefacturaUtil = new PrefacturaUtil();
		
		//xml = new String(Base64.decodeBase64(xml.getBytes("UTF8")));
		xml = new String(Base64.decodeBase64(xml.getBytes("ISO-8859-1")), "ISO-8859-1");
		System.err.println(xml);
		Prefactura prefactura = new Prefactura();
		ValidadorXml validadorXml = prefacturaUtil.validarSintaxisXml(xml);
		
		if(validadorXml.isCorrecto()){
			ReadXMLFile handdlerCfdi = new ReadXMLFile(xml);
			try {
				XMLReader reader = XMLReaderFactory.createXMLReader();
				InputSource is = new InputSource();
				is.setCharacterStream(new StringReader(xml));

				reader.setContentHandler(handdlerCfdi);
				reader.parse(is);

				prefactura = handdlerCfdi.getPrefactura();
				
				validadorXml = prefacturaUtil.validarCamposRequeridos(prefactura);
				
				prefactura.setRespuesta(validadorXml);
			} catch (SAXException localSAXException) {
				localSAXException.printStackTrace();
			} catch (IOException localIOException) {
				localIOException.printStackTrace();
			}
		}else
			prefactura.setRespuesta(validadorXml);
		
		return prefactura;
	}

	@RequestMapping(value = "/descargarplantilla", method = RequestMethod.POST)
	public @ResponseBody String descargaplantilla(@RequestBody String jsonB64)
			throws JAXBException, IOException, JRException, ParserConfigurationException {
		ResponsePrefactura response = new ResponsePrefactura();
		Prefactura comprobante = null;
		String json = "";
		String xml = "";
		PrefacturaUtil prefacturaUtil = new PrefacturaUtil();
		try {
			System.err.println("Entrada: " + jsonB64);
			json = new String(Base64.decodeBase64(jsonB64.getBytes("ISO-8859-1")), "ISO-8859-1");
			comprobante = new Gson().fromJson(json, Prefactura.class);
			xml = prefacturaUtil.buildXml(comprobante);
			
			response.setXml(xml);
			response.setMensaje("Descargar plantilla");
			response.setEmisorRfc(comprobante.getEmisorRfc());
			System.err.println(jsonB64);
		} catch (Exception e) {
			xml = "Datos de entrada: " + jsonB64 + ". JSON: "  + json;
			response.setXml(xml);
			response.setMensaje("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return new String(Base64.encodeBase64(response.getXml().getBytes()));
	}
}