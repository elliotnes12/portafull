package mx.xpd.cfdi.mvc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.xpd.cfdi.domain.CertificadoSelloDigital;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.exception.CertificadoException;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.exception.PasswordException;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.util.CertificadoUtil;
import mx.xpd.cfdi.util.Hash;
import mx.xpd.cfdi.util.KeyUtil;
import mx.xpd.cfdi.util.SelloCadena;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/manifiesto")
public class ManifiestoController {
	
	private final static int STATUS_NUEVO = 0;
	private final static int STATUS_FIRMADO = 2;
	
	private final static Logger log = Logger.getLogger(ManifiestoController.class);

	@Autowired
	private DatosEmisorDao datosEmisorDao;

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model, HttpServletRequest request) {
		String rfc = (String)request.getSession().getAttribute("tenantId");
		DatosEmisor emisor = datosEmisorDao.findByRfc(rfc);
		if(emisor.getPaso() == ManifiestoController.STATUS_NUEVO) {
			// return "manifiesto/mostrar";
			model.addAttribute("msg", request.getSession().getAttribute("msg"));
			request.getSession().removeAttribute("msg");
			model.addAttribute("error", request.getSession().getAttribute("error"));
			request.getSession().removeAttribute("error");
			return "manifiesto/mostrar";
		} else {
			request.getSession().setAttribute("phase2FromManifiesto", "Se ha firmado el manifiesto, agregue y habilite el CSD a utilizar.");
			return "redirect:/csd";
		}
	}
	
	@RequestMapping(value="/firmar", method = RequestMethod.POST)
	public String upload(
			@RequestParam("certificado") MultipartFile cert,
			@RequestParam("privada") MultipartFile key,
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException {
		CertificadoSelloDigital csd = new CertificadoSelloDigital();
		csd.setContrasena(request.getParameter("password"));
		
		String rfc = (String)request.getSession().getAttribute("tenantId");
		String resultado = this.procesarArchivo(csd, new MultipartFile[]{key,cert}, rfc);
		if(!resultado.equals("")) {
			// Error en validación del certificado
			request.getSession().setAttribute("msg", resultado);
			request.getSession().setAttribute("error", 1);
			return "redirect:/manifiesto";
		} else {
			// Certificado válido
			String Manifiesto = this.leerManifiesto();
			if (!Manifiesto.equals("")){
				
				String sello = "";
				String hash = "";
				
				Manifiesto = Manifiesto.replace("${rfc}", request.getParameter("rfc"));
				Manifiesto = Manifiesto.replace("${razonSocial}", request.getParameter("razonSocial"));
				Manifiesto = Manifiesto.replace("${domicilioFiscal}", request.getParameter("domicilioFiscal"));
				// Fecha de firmado del acuerdo
				DateFormat Yr = new SimpleDateFormat("yyyy");
				DateFormat Mth = new SimpleDateFormat("MM");
				DateFormat Day = new SimpleDateFormat("dd");
				String[] Months = {
						"ENERO", "FEBRERO", "MARZO", 
						"ABRIL", "MAYO", "JUNIO", 
						"JULIO", "AGOSTO", "SEPTIEMBRE",
						"OCTUBRE", "NOVIEMBRE", "DICIEMBRE"
						};
				Date date = new Date();
				Manifiesto = Manifiesto.replace("${dia}", "" + Day.format(date));
				Manifiesto = Manifiesto.replace("${mes}", "" + Months[ Integer.parseInt(Mth.format(date)) % 12 ]);
				Manifiesto = Manifiesto.replace("${anio}", "" + Yr.format(date));
				
				hash = Hash.sha1(Manifiesto);
				byte[] bytes = null;
				try {
					bytes = IOUtils.toByteArray(key.getInputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sello = SelloCadena.getSello(hash, request.getParameter("password"), bytes);
				if(sello  == null){
					// Error al obtener el sello
					request.getSession().setAttribute("msg", "No se pudo sellar la cadena del Manifiesto, por favor intente m&aacute;s tarde.");
					request.getSession().setAttribute("error", true);
					return "redirect:/manifiesto";
				}
				else {
					DatosEmisor emisor = datosEmisorDao.findByRfc(rfc);
					
					Calendar c = new GregorianCalendar();
					
					Map<String, Object> params = new HashMap<String, Object>();
				    params.put("rfc", request.getParameter("rfc"));
				    params.put("razonSocial", request.getParameter("razonSocial"));
				    params.put("domicilioFiscal", request.getParameter("domicilioFiscal"));
				    params.put("dia", "" + c.get(Calendar.DAY_OF_MONTH));
				    params.put("mes", "" + (c.get(Calendar.MONTH) + 1));
				    params.put("anio", "" + c.get(Calendar.YEAR));
				    params.put("sello", sello);
				    params.put("hash", hash);
				    response.setContentType("application/pdf");
				    // Actualizar el paso de los datos emisor
				    emisor.setPaso(1);
				    datosEmisorDao.update(emisor);
				    
				    toPDF("/home/cfdi33/plantillas/manifiesto.jrxml", params, response.getOutputStream(), request.getParameter("rfc"));
				    
				}
			} else {
				request.getSession().setAttribute("msg", "No se pud&oacute; obtener el manifiesto, por favor intentar m&aacute; tarde.");
				request.getSession().setAttribute("error", true);
				return "redirect:/manifiesto";
			}
		}
		return "manifiesto/mostrar";
	}
	
	private String procesarArchivo(CertificadoSelloDigital nuevoCsd, MultipartFile[] file, String tenant) {
		String error = "";
		boolean archivoVacio = false;

		if (file[0].isEmpty()) {
			archivoVacio = true;
			error += addError("Archivo .key Vacio");
		}
		if (file[1].isEmpty()) {
			archivoVacio = true;
			error += addError("Archivo .cer Vacio");
		}

		if (!archivoVacio) {
			try {
				nuevoCsd.setNombreArchivoKey(file[0].getOriginalFilename());
				nuevoCsd.setNombreArchivoCer(file[1].getOriginalFilename());
				KeyUtil keyUtil = new KeyUtil(file[0].getBytes(), false);
				CertificadoUtil certUtil = new CertificadoUtil(file[1].getBytes());
				

				if (nuevoCsd.getUsar()) {
					if (!certUtil.isVigente(new Date())) {
						log.info("certificado no vigente");
						error += addError("Certificado no vigente");
					}
				}
				
				DatosEmisor emisor = datosEmisorDao.findEmisor(tenant);
				if (!certUtil.getRfc().contains(emisor.getRfc())) {
			 		error += addError("El certificado no corresponde al RFC");
				}
				
				nuevoCsd.setNoSerie(certUtil.getNoSerie());
				nuevoCsd.setArchivoKey(keyUtil.getPemBase64(nuevoCsd.getContrasena()));
				nuevoCsd.setCertificado(certUtil.getCSDPemBase64(isPersonaFisica(emisor.getRfc())));
				nuevoCsd.setFechaInicio(certUtil.getCert().getNotBefore());
				nuevoCsd.setFechaFin(certUtil.getCert().getNotAfter());
				nuevoCsd.setUltimaActualizacion(new Date());
				if (!keyUtil.perteneceAlCert(certUtil.getCert())) {
					error += addError("El certificado y la llave no corresponden");
				}
			} catch (IOException e) {
				error += addError("Intentar de nuevo mas tarde");
			} catch (InterruptedException e) {
				error += addError("Intentar de nuevo mas tarde");
			} catch (LlavePrivadaException e) {
				error += addError("Archivo incorrecto");
			} catch (PasswordException e) {
				error += addError("Contraseña incorrecta");
			} catch (CertificateException e) {
				e.printStackTrace();
				error += addError("Certificado no es de tipo CSD");
			} catch (CertificadoException e) {
				e.printStackTrace();
				error += addError("Certificado no es de tipo CSD");
			} catch (InvalidKeySpecException e) {
				error += addError("Llave invalida");
			}
		} 

		return error;

	}
	
	private String addError(String mensaje) {
		return "<p>" + mensaje + "</p>";
	}
	
	private boolean isPersonaFisica(String tenant) {
		return tenant.length() == 13;
	}
	
	private String leerManifiesto() {
		Scanner sc;
		String texto = "";
		try {
			sc = new java.util.Scanner(new java.net.URL("http://portal.expidetufactura.com.mx:86/manifiesto/texto.txt").openStream());
		    while (sc.hasNext()) {
		        texto += sc.nextLine();
		        texto += "\n";
		    }
		    sc.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			log.error("URL erronea : ", e);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Error en la lectura del archivo : ", e);
			e.printStackTrace();
		}
	    return texto;
	}
	
	public static void toPDF(String urlPlantilla, Map<String, Object> params, OutputStream out, String rfc) {
		try {
			JasperReport report = JasperCompileManager.compileReport(urlPlantilla);
			JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
			JasperExportManager.exportReportToPdfStream(print, out);
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			String path = "/home/cfdi33/manifiesto/" + rfc + "-" +(sd.format(new Date())) + ".pdf";
			System.out.println("->" + path);
			FileOutputStream pdf = new FileOutputStream(path);
			JasperExportManager.exportReportToPdfStream(print, pdf);
			pdf.flush();
			pdf.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
