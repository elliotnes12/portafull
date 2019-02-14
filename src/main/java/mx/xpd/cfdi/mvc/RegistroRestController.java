package mx.xpd.cfdi.mvc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.repo.RegistroDao;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/registro")
public class RegistroRestController {

	@Autowired
	private RegistroDao registroDao;
	@Autowired
	private ParametroDao parametroDao;
	private Logger log = Logger.getLogger(RegistroRestController.class);

	@RequestMapping("/{archivoSql}")
	public @ResponseBody
	Integer registrarDesdeSql(@PathVariable("archivoSql") String rfc) {
		String pathSql = parametroDao.findByClave("PATH_SQLS").getValor();
		return registroDao.ejecutarSql(pathSql + rfc + ".sql");
	}

//	/rest/registro
	@RequestMapping("/crearSql")
	public @ResponseBody
	Boolean crearSql(Model model) {
		String pathSqls = parametroDao.findByClave("PATH_SQLS").getValor();

		String rfcX = "AAA010101AAA";
		String tenant_idX = rfcX;
		String calleX = "Nuevo México";
		String ciudadX = "Puebla";
		String codigoPostalX = "72590";
		String coloniaX = "Vista Alegre";
		String delegacionX = "Puebla";
		String emailX = "gerardo.valdez@xpd.mx";
		String estadoX = "Puebla";
		String faxX = ""; // null
		String noExteriorX = "19";
		String noInteriorX = ""; // null
		String paisX = "México";
		String razonSocialX = "Empresa de Prueba S.A. de C.V";
		String referenciaX = "Contra esquina con hsbc de Boulevard Atlixco, frente a un Banamex y a un lado del edificio Premium";
		String telefono1X = "01800 - Xpd";
		String telefono2X = ""; // null
		String tipoPersonaX = "1";
		String foliosDisponiblesX = "300";
		String gratuitoX = "0";

		try {
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
			
			script = script.replaceAll("rfcX", rfcX);
			script = script.replaceAll("tenant_idX", tenant_idX);
			script = script.replaceAll("calleX", calleX);
			script = script.replaceAll("ciudadX", ciudadX);
			script = script.replaceAll("codigoPostalX", codigoPostalX);
			script = script.replaceAll("coloniaX", coloniaX);
			script = script.replaceAll("delegacionX", delegacionX);
			script = script.replaceAll("emailX", emailX);
			script = script.replaceAll("estadoX", estadoX);
			script = script.replaceAll("faxX", faxX);
			script = script.replaceAll("noExteriorX", noExteriorX);
			script = script.replaceAll("noInteriorX", noInteriorX);
			script = script.replaceAll("paisX", paisX);
			script = script.replaceAll("razonSocialX", razonSocialX);
			script = script.replaceAll("referenciaX", referenciaX);
			script = script.replaceAll("telefono1X", telefono1X);
			script = script.replaceAll("telefono2X", telefono2X);
			script = script.replaceAll("tipoPersonaX", tipoPersonaX);
			script = script.replaceAll("foliosDisponiblesX", foliosDisponiblesX);
			script = script.replaceAll("gratuitoX", gratuitoX);

			File filePrueba = new File("");
			log.info("filePrueba url: " + filePrueba.getAbsolutePath());
			log.info("Creando script de registro: " + pathSqls + rfcX + ".sql");
			File fileSqlUsuario = new File(pathSqls + rfcX + ".sql");
			fileSqlUsuario.createNewFile();
			FileOutputStream fos = new FileOutputStream(fileSqlUsuario);
			fos.write(script.getBytes("UTF-8"));
			fos.close();
			

		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}
}
