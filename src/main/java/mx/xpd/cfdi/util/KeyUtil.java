package mx.xpd.cfdi.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;

import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.exception.PasswordException;
import mx.xpd.cfdi.repo.ParametroDao;

import org.apache.commons.codec.binary.Base64;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Configurable
public class KeyUtil {

	@Autowired
	private ParametroDao daoParametro;
	
	private Logger log = Logger.getLogger(KeyUtil.class);
	private String carpetaCSD = "/var/tmp/";
	private String archivoIncorrecto = "Error reading key";
	private String passIncorrecto = "Error decrypting key";
	private PrivateKey privateKey;
	private byte[] fileBytes;
	
	public KeyUtil(byte[] fileBytes, Boolean passRemovido) throws InvalidKeySpecException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext (this);
		carpetaCSD = daoParametro.findByClave("PATH_CSD").getValor();
		this.fileBytes = fileBytes;
		if (passRemovido) {
			privateKey = keyDesdeBytes(fileBytes);			
		}
	}
	
	public String getPemBase64(String pass) throws IOException, InterruptedException, LlavePrivadaException, PasswordException, InvalidKeySpecException{
		Long ahora = new Date().getTime();
		Double rand = Math.random();
		String rutaArchivoKey = carpetaCSD + ahora + rand + ".key";
		String rutaArchivoPem = carpetaCSD + ahora + rand + ".pem";
		String rutaArchivoFinal = carpetaCSD + ahora + rand + "Final.pem";

		Archivo archivo = new Archivo();
		archivo.guardarBytes(rutaArchivoKey, fileBytes);

		//obteniendo removiendo la contraseña del archivo Key del CSD
		String comandoLlave = "openssl pkcs8 -inform DER -in " + rutaArchivoKey +
				" -passin pass:" + pass + " -out " + rutaArchivoPem;
		Process proc = Runtime.getRuntime().exec(comandoLlave);
		int code = proc.waitFor();
		
		//Necesario si la version de openssl es menor a 1.0
		String segundoComando = "openssl pkcs8 -inform pem -outform pem " +
								" -in " + rutaArchivoPem + " -out " + rutaArchivoFinal + " -topk8 -nocrypt";
		
		Process proc2 = Runtime.getRuntime().exec(segundoComando);
		code += proc2.waitFor();

		String strPem = archivo.leerArchivo(rutaArchivoFinal);

		//borrando archivos temporales
		File archivoKey = new File(rutaArchivoKey);
		File archivoPem = new File(rutaArchivoPem);
		File archivoFinal = new File(rutaArchivoFinal);

		if (!archivoKey.delete() ){
			log.info("No se pudo borrar el archivo: " + rutaArchivoKey);
		}
		if (!archivoPem.delete() ){
			log.info("No se pudo borrar el archivo: " + rutaArchivoPem);
		}
		if (!archivoFinal.delete() ){
			log.info("No se pudo borrar el archivo: " + rutaArchivoFinal);
		}

		if (code != 0 ) {
			InputStream is = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String mensajeError = br.readLine();

			if (mensajeError.equals(passIncorrecto)) { 
				throw new PasswordException("Contraseña incorrecta");
			}
			if (mensajeError.equals(archivoIncorrecto)) {
				throw new LlavePrivadaException("Archivo incorrecto");
			}
			throw new LlavePrivadaException();
		}
		
		privateKey = keyDesdeStringPem(strPem);
		return strPem;
	}

	public Boolean perteneceAlCert(X509Certificate cert) {
		RSAPublicKey publicKey = (RSAPublicKey)cert.getPublicKey();
		RSAPrivateKey privateKey = (RSAPrivateKey)this.privateKey;
		BigInteger publicModulo = publicKey.getModulus();
		BigInteger privateModulo = privateKey.getModulus();
		return publicModulo.equals(privateModulo) ? true : false;
	}
	
	private PrivateKey keyDesdeStringPem(String keyBase64) throws InvalidKeySpecException {
		keyBase64 = keyBase64.replaceAll("-----BEGIN PRIVATE KEY-----", "");
		keyBase64 = keyBase64.replaceAll("-----END PRIVATE KEY-----", "");
		byte[] encoded = Base64.decodeBase64(keyBase64); 
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(encoded);
		KeyFactory kf;
		try {
			kf = KeyFactory.getInstance("RSA");
			PrivateKey pKey = kf.generatePrivate(spec);
			return pKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new InvalidKeySpecException();
		}
	}
	
	private PrivateKey keyDesdeBytes(byte[] keyBytes) throws InvalidKeySpecException {
		PKCS8EncodedKeySpec key = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf;
		try {
			kf = KeyFactory.getInstance("RSA");
			return kf.generatePrivate(key);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

}
