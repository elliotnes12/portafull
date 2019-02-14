package mx.xpd.cfdi.mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.xpd.cfdi.domain.RegistroForm;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.PaisEstadoDao;
import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.repo.RegistroDao;
import mx.xpd.cfdi.util.EmailUtil;
import mx.xpd.cfdi.util.PasswordGenerator;
import mx.xpd.cfdi.util.SecurityUtil;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "registrarUsuario")
public class RegistroController {

	private Logger log = Logger.getLogger(RegistroController.class);
	@Autowired
	private PaisEstadoDao paisEstadoDao;
	@Autowired
	private ParametroDao parametroDao;
	@Autowired
	private RegistroDao registroDao;
	@Autowired
	private DatosEmisorDao emisorDao;

	@RequestMapping(method = RequestMethod.GET)
	public String capturarDatos(Model model) {
		log.info("/registrarUsuario");
		cargarModel(model, null, null);
		return "nuevoUsuario";
	}
	
	@RequestMapping(value = "/{distribuidor}", method = RequestMethod.GET)
	public String capturarDatosDist(@PathVariable("distribuidor") String distribuidor, Model model) {
		log.info("/registrarUsuario");
		cargarModel(model, null, null);
		model.addAttribute("distribuidor", distribuidor);
		return "nuevoUsuario";
	}


	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public String registrarUsuario(Model model,
			@ModelAttribute("registroForm") RegistroForm registroForm,
			HttpServletRequest request,
			HttpServletResponse response) {

		// String rfcUser = request.getParameter("rfc");
		
		// String passwd = parametroDao.findByClave("CLAVE_ACTIVAR").getValor();
		// String auth = parametroDao.findByClave("RFC_AUTH").getValor();
		
		//if (!rfcUser.equalsIgnoreCase(auth)) {
		//	return "redirect:/errores/noPermisos";
		//}
		//
		//if (!registroForm.getPassword().equals(passwd)) {
		//	cargarModel(model, "Contraseña incorrecta", registroForm);
		//	return "nuevoUsuario";
		//}

		try {
			String rfc = registroForm.getRfc();
			
			if (emisorDao.findByRfc(rfc) != null) {
				cargarModel(model, "RFC registrado anteriormente", registroForm);
				return "nuevoUsuario";
			}
			
			crearScript(registroForm);
			Integer inserts = registrarDesdeSql(rfc);
			log.info("sql inserts: " + inserts);
			
			Calendar one_year_later = Calendar.getInstance();
			one_year_later.add(Calendar.YEAR, 1);
			SimpleDateFormat sds = new SimpleDateFormat("ddMMyyyy");
						
			//Se asignan 10 timbres, fecha vencimiento anual, plan ilimitado
			String passTimbrado = asignarTimbres(rfc, 10, sds.format(one_year_later.getTime()), 1);

			if (passTimbrado == null) {
				return "500 - Folios no validos. (pTimbrado)";
			}
			
			cargarModel(model, "Registro completado, los datos de acceso se han enviado a su correo.", registroForm);
			model.addAttribute("registrado", true);

			return "nuevoUsuario";
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			cargarModel(model, "No se encontró el archivo de registro", registroForm);
			return "nuevoUsuario";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			cargarModel(model, "Encoding incorrecto", registroForm);
			return "nuevoUsuario";
		} catch (IOException e) {
			e.printStackTrace();
			cargarModel(model, "Error al crear el archivo de registro", registroForm);
			return "nuevoUsuario";
		} catch (Exception e) {
			e.printStackTrace();
			cargarModel(model, "Error inesperado", registroForm);
			return "nuevoUsuario";
		}

	}

	private void crearScript(RegistroForm registroForm) throws UnsupportedEncodingException, IOException {

		String pass = PasswordGenerator.getPassword(8);
		String passEnc = "";
		try {
			passEnc = SecurityUtil.encryptString(pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		String pathSqls = parametroDao.findByClave("PATH_SQLS").getValor();

		//script original en el que se reemplazarán los valores
		File file = new File(pathSqls + "scriptG.sql");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		String script = sb.toString();
		br.close();

		String rfcX = registroForm.getRfc();
//insert into Permiso values ('133', NULL, '0', '2013-04-26 17:45:48', '1', '16', NULL, 'Base', '0', '0', NULL, 'SFF130419GK1');
		script = script.replaceAll("rfcX", rfcX);
		script = script.replaceAll("tenant_idX", rfcX);
		script = script.replaceAll("passX", passEnc);
		
		script = script.replaceAll("emailX", registroForm.getEmail());
		script = script.replaceAll("codigoPostalX", registroForm.getCodigoPostal());
		script = script.replaceAll("delegacionX", registroForm.getDelegacionMunicipio());
		script = script.replaceAll("localidadX", registroForm.getLocalidad());
		script = script.replaceAll("estadoX", registroForm.getEstado());
		script = script.replaceAll("razonSocialX", registroForm.getRazonSocial());
		if (registroForm.getDistribuidor() == null || registroForm.getDistribuidor().isEmpty()) {
			registroForm.setDistribuidor("matriz");
		}
		script = script.replaceAll("distribuidorX", registroForm.getDistribuidor());
		
		script = script.replaceAll("foliosDisponiblesX", "10");
		script = script.replaceAll("gratuitoX", "0");
		
		Calendar one_year_later = Calendar.getInstance();
		one_year_later.add(Calendar.YEAR, 1);
		SimpleDateFormat sds = new SimpleDateFormat("yyyy-MM-dd");
		script = script.replaceAll("fechaVencimientoX", "'"+sds.format(one_year_later.getTime())+"'");
		
		log.info("Creando script de registro: " + pathSqls + rfcX + ".sql");
		File fileSqlUsuario = new File(pathSqls + rfcX + ".sql");
		fileSqlUsuario.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileSqlUsuario);
		fos.write(script.getBytes("UTF-8"));
		fos.close();
		try {
			enviarMail(registroForm, pass);
		} catch (Exception e) {
			enviarMail(registroForm, pass);
			e.printStackTrace();
		}	
	}

	public void enviarMail(RegistroForm registroForm, String pass) {
		String texto = "";
		try {
			String fileMail = parametroDao.findByClave("PATH_MAIL_ACTIVACION").getValor();
			FileInputStream ios = new FileInputStream(fileMail);
			texto = new Scanner(ios).useDelimiter("\\A").next();
			
			texto = texto.replace("usuarioX", registroForm.getRazonSocial());
			texto = texto.replace("claveX", registroForm.getRfc());
			texto = texto.replace("passwordX", pass);
			
			System.out.println(texto);
			
			EmailUtil.enviarCorreo("Activación cuenta facturación.", texto, registroForm.getEmail()); 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			EmailUtil.enviarCorreo("Activación cuenta facturación.", texto, registroForm.getEmail());
			e.printStackTrace();
		}
	}
	
	private Integer registrarDesdeSql(String rfc) {
		String pathSql = parametroDao.findByClave("PATH_SQLS").getValor();
		return registroDao.ejecutarSql(pathSql + rfc + ".sql");
	}
	
	private Model cargarModel(Model model, String mensaje, RegistroForm registroForm) {
		model.addAttribute("paises", paisEstadoDao.findAllPais());
		model.addAttribute("estados", paisEstadoDao.findAllEstadoMap("MEX"));
		if (registroForm == null)
			model.addAttribute("registroForm", new RegistroForm());
		else 
			model.addAttribute("registroForm", registroForm);
		model.addAttribute("mensaje", mensaje);
		return model;
	}
	
	private String asignarTimbres(String rfc, Integer timbres, String fechaVencimiento, int tipoPlan) {
		String url = parametroDao.findByClave("URL_ACTIVACION_SUBCUENTAS")
				.getValor();
		url += "?usuario=#U&pwd=#P&nuevo=#R&timbres=#N&fechaVencimiento=#FV&tipoPlan=#TP";

		try {
			url = url.replace("#U",
					parametroDao.findByClave("USUARIO_TIMBRADO_PRODUCCION")
							.getValor());
			url = url.replace("#P",
					parametroDao.findByClave("PASSWORD_TIMBRADO_PRODUCCION")
							.getValor());
			
			url = url.replace("#R", rfc.trim());
			url = url.replace("#N", "" + timbres);
			url = url.replace("#FV", "" + fechaVencimiento);
			url = url.replace("#TP", "" + tipoPlan);
			System.out.println(url);

			HttpURLConnection con = (HttpURLConnection) new URL(url)
					.openConnection();
			con.setRequestMethod("GET");

			if (con.getResponseCode() == 200) {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				String str = response.toString();

				System.out.println("\"" + str + "\"");
				System.out.println("\"" + url + "\"");

				String data[] = str.split("-");
				if (data.length == 4) {
					return data[3].trim();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return "";
	}

}
