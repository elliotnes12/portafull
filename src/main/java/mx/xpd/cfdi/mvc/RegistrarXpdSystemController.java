package mx.xpd.cfdi.mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.RegistroForm;
import mx.xpd.cfdi.domain.Usuario;
import mx.xpd.cfdi.repo.ClienteDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.repo.RegistroDao;
import mx.xpd.cfdi.repo.UsuarioDao;
import mx.xpd.cfdi.util.EmailUtil;
import mx.xpd.cfdi.util.PasswordGenerator;
import mx.xpd.cfdi.util.SecurityUtil;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/XPD/registrar")
public class RegistrarXpdSystemController {

	@Autowired
	private ParametroDao parametroDao;
	@Autowired
	private RegistroDao registroDao;
	@Autowired
	private DatosEmisorDao emisorDao;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private UsuarioDao usuarioDao;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
	public @ResponseBody String index(
			@ModelAttribute("nuevo") RegistroForm registroForm,
			HttpServletRequest req) {
		try {
			registroForm.setRfc(URLDecoder.decode(registroForm.getRfc(),
					"UTF-8"));
			registroForm.setResidenciaFiscal("México");
			registroForm.setRazonSocial(URLDecoder.decode(registroForm
					.getRazonSocial()));
			registroForm.setFoliosDisponibles(URLDecoder.decode(
					registroForm.getFoliosDisponibles(), "UTF-8"));

			String[] distribuidor = (registroForm.getDistribuidor()).split("#");

			System.out.println(distribuidor[0]);
			System.out.println(distribuidor[1]);
			System.out.println(distribuidor[2]);

			System.out.println("bandera cxp: "
					+ req.getParameter("activacionCxP"));
			
			String pass = PasswordGenerator.getPassword(8);

			/* LACO: Se busca el cliente. */
			Cliente cte = clienteDao.findByRfc("CCC1007293K0",
					registroForm.getRfc());

			/* Si el cliente no existe, se crea. */
			if (cte == null) {
				cte = new Cliente();
				cte.setClave(registroForm.getRfc());
				cte.setEliminado(false);
				cte.setEmail(registroForm.getEmail());
				cte.setFechaRegistro(new Date());
				cte.setResidenciaFiscal("México");
				cte.setRazonSocial(registroForm.getRazonSocial());
				cte.setRfc(registroForm.getRfc());
				cte.setTenantId("CCC1007293K0");
				cte.setRazonSocialDes(registroForm.getRazonSocial());
				cte.setRfcDes(registroForm.getRfc());
				clienteDao.add(cte);
			}

			try {
				registroForm.setPassword(SecurityUtil.encryptString(pass));
			} catch (Exception e) {
				e.printStackTrace();
			}

			/* LACO: Se valida el RFC */
			String rfc = registroForm.getRfc();
			if (rfc == null || rfc.equals("")) {
				return "500 - R.F.C no válido.";
			}

			/* LACO: Se obtiene el numero de folios que se van a cargar. */
			int folios = Integer.parseInt(registroForm.getFoliosDisponibles());

			/* Se busca el Emisor. */
			DatosEmisor emisor = emisorDao.findByRfc(rfc);
			int intTipoPlan = 1;
			
			if (registroForm.getTipoPlan())
				intTipoPlan = 1;
			else
				intTipoPlan = 0;
			
			
			/* Se le asignan los timbres al Emisor, y se obtiene el password. */
			String passTimbrado = asignarTimbres(rfc, folios, 
					registroForm.getFechaVencimiento(), intTipoPlan);

			if (passTimbrado == null) {
				return "500 - Folios no validos. (pTimbrado)";
			}

			/* El Emisor ya existe, se van a recargar folios. */
			if (emisor != null) {
				if (registroForm.getFoliosDisponibles().isEmpty()) {
					System.out.println("Empty");
					return "500 - Folios no validos.";
				}
				try {
					Usuario usuario = usuarioDao.findAll(rfc).get(0);
					emisor.setFoliosDisponibles(emisor.getFoliosDisponibles()
							+ folios);
					emisor.setTenantId(emisor.getRfc());

					Calendar one_year_later = Calendar.getInstance();
					SimpleDateFormat sds = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					emisor.setUltimaCompra(sds.format(one_year_later.getTime()));

					//Se cambia el plan
					emisor.setTipoPlan(registroForm.getTipoPlan());
					
					//Se actualiza la fecha de Vencimiento
					DateFormat fromFormat = new SimpleDateFormat("ddMMyyyy");
					fromFormat.setLenient(false);
					DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd");
					toFormat.setLenient(false);
					try {
						Date date = fromFormat.parse(registroForm.getFechaVencimiento());
						emisor.setFechaVencimiento(toFormat.format(date));
						emisorDao.recarga(emisor);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (emisor.isGratuito()) {
						emisor.setGratuito(false);
						emisorDao.recarga(emisor);
						return "200 - Cliente de gratuito a pago.|"+usuario.getPassword();
					}
					if (!registroForm.getFoliosDisponibles().equals("0")) {
						emisorDao.recarga(emisor);
						return "200 - Folios cargados.|"+usuario.getPassword();
					}
					return "200 - Folios cargados.|"+usuario.getPassword();
				} catch (Exception e) {
					e.printStackTrace();
					return "500 - Folios no validos.";
				}
			}

			registroForm.setFoliosDisponibles("" + folios);
			String nomina = registroForm.getNomina();
			crearScript(registroForm, passTimbrado);
			Integer inserts = registrarDesdeSql(rfc);
			// registroForm.setPassword(SecurityUtil.encryptString(passTimbrado));

			return "200 - Usuario registrado.|"+pass;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "500 - SQL no encontrado";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "500 - Error encoding";
		} catch (IOException e) {
			e.printStackTrace();
			return "500 - Error interno";
		} catch (Exception e) {
			e.printStackTrace();
			return "500 - Error interno";
		}

	}

	private String asignarTimbres(String rfc, Integer timbres, String fechaVencimiento, int tipoPlan) {
		String url = parametroDao.findByClave("URL_ACTIVACION_SUBCUENTAS")
				.getValor();
		url += "?usuario=#U&pwd=#P&nuevo=#R&timbres=#N&fechaVencimiento=#FV&tipoPlan=#TP";
		//url += "/#R/#N?user=#U&pwd=#P&fechaVencimiento=#FV&tipoPlan=#TP";

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

	private void crearScript(RegistroForm registroForm, String pTimbrado)
			throws UnsupportedEncodingException, IOException {

		String pathSqls = parametroDao.findByClave("PATH_SQLS").getValor();

		// script original en el que se reemplazarán los valores
		File file = new File(pathSqls + "script.sql");
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
		script = script.replaceAll("codigoPostalX", registroForm.getCodigoPostal());
		script = script.replaceAll("delegacionX", registroForm.getDelegacionMunicipio());
		script = script.replaceAll("localidadX", registroForm.getLocalidad());
		script = script.replaceAll("emailX", registroForm.getEmail());
		script = script.replaceAll("estadoX", registroForm.getEstado());
		script = script.replaceAll("razonSocialX", registroForm.getRazonSocial());
		script = script.replaceAll("rfcX", rfcX);
		script = script.replaceAll("tenant_idX", rfcX);
		script = script.replaceAll("foliosDisponiblesX", registroForm.getFoliosDisponibles());
		script = script.replaceAll("gratuitoX", "0");
		script = script.replaceAll("distribuidorX", "0");
		script = script.replaceAll("distribuidorXID", "0");
		script = script.replaceAll("pTimbradoX", pTimbrado);
		script = script.replaceAll("tipoPlanX", registroForm.getTipoPlan().toString());
		
		
		script = script.replaceAll("paisX", registroForm.getResidenciaFiscal());
		script = script.replaceAll("passX", registroForm.getPassword());
		if (registroForm.getTenant_creador() != null)
			script = script.replaceAll("tenant_creadorX", registroForm.getTenant_creador());
		else
			script = script.replaceAll("tenant_creadorX", "");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sw = sdf.format(new Date());
		//script = script.replaceAll("ultimaCompra", sw);
				
		DateFormat fromFormat = new SimpleDateFormat("ddMMyyyy");
		fromFormat.setLenient(false);
		DateFormat toFormat = new SimpleDateFormat("yyyy-MM-dd");
		toFormat.setLenient(false);
		try {
			Date date = fromFormat.parse(registroForm.getFechaVencimiento());
			script = script.replaceAll("fechaVencimientoX", "'"+toFormat.format(date)+"'");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		

		File fileSqlUsuario = new File(pathSqls + rfcX + ".sql");
		fileSqlUsuario.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileSqlUsuario);
		fos.write(script.getBytes("UTF-8"));
		fos.close();

	}

	private Integer registrarDesdeSql(String rfc) {
		String pathSql = parametroDao.findByClave("PATH_SQLS").getValor();
		return registroDao.ejecutarSql(pathSql + rfc + ".sql");
	}

}