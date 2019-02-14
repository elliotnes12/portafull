package mx.xpd.cfdi.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;

import mx.xpd.cfdi.exception.CertificadoException;

import org.jboss.logging.Logger;

public class CertificadoUtil {
	private static Logger log = Logger.getLogger(CertificadoUtil.class);

	private X509Certificate cert;
	private String rfc;
	private int tipo;
	private String carpetaCSD = "/var/tmp/";
	private byte[] fileBytes;

	public CertificadoUtil(String ruta) throws IOException,
			CertificateException {
		File file = new File(ruta);
		InputStream is = new FileInputStream(ruta);
		fileBytes = new byte[(int) file.length()];
		is.read(fileBytes);
		is.close();

		// codigo repetido en el otro constructor
		InputStream inStream = new ByteArrayInputStream(fileBytes);
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		cert = (X509Certificate) cf.generateCertificate(inStream);

		try {
			LdapName ln = new LdapName(cert.getSubjectDN().getName());

			for (Rdn rdn : ln.getRdns()) {
				if (rdn.getType().equalsIgnoreCase("OID.2.5.4.45")) {
					if (rdn.getValue() != null) {
						String[] array = ((String) rdn.getValue()).split("/");
						if (array.length == 0) {
							throw new CertificateException(
									"Datos inválidos del Sujeto");
						} else {
							rfc = array[0].trim();
						}
						break;
					}
				}
			}
		} catch (InvalidNameException e) {
			log.error("Datos Inválidos del certificado", e);
			throw new CertificateException(e);
		}
	}
	
	

	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public CertificadoUtil(byte[] certificado) throws CertificateException {
		this.fileBytes = certificado;
		InputStream inStream = new ByteArrayInputStream(fileBytes);
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		try {
			cert = (X509Certificate) cf.generateCertificate(inStream);
		} catch(Exception e) {
			log.error("Datos Inválidos del certificado", e);
			throw new CertificateException(e);
		}

		try {
			LdapName ln = new LdapName(cert.getSubjectDN().getName());

			for (Rdn rdn : ln.getRdns()) {
				if (rdn.getType().equalsIgnoreCase("OID.2.5.4.45")) {
					if (rdn.getValue() != null) {
						String[] array = ((String) rdn.getValue()).split("/");
						if (array.length == 0) {
							throw new CertificateException(
									"Datos inválidos del Sujeto");
						} else {
							rfc = array[0].trim();
						}
						break;
					}
				}
			}
		} catch (InvalidNameException e) {
			log.error("Datos Inválidos del certificado", e);
			throw new CertificateException(e);
		}
	}
	
	

	public boolean isCSD() {
		boolean isCsd = true;
		boolean[] array = cert.getKeyUsage();
		// digitalSignature
		if (array[0] == false)
			isCsd = false;
		// nonRepudiation
		if (array[1] == false)
			isCsd = false;
		// keyEncipherment
		if (array[2] == true)
			isCsd = false;
		// dataEncipherment
		if (array[3] == true)
			isCsd = false;
		// keyAgreement
		if (array[4] == true)
			isCsd = false;
		// keyCertSign
		if (array[5] == true)
			isCsd = false;
		// cRLSign
		if (array[6] == true)
			isCsd = false;
		// encipherOnly
		if (array[7] == true)
			isCsd = false;
		// decipherOnly
		if (array[8] == true)
			isCsd = false;
		return isCsd;
	}

	public boolean isVigente(Date fecha) {
		try {
			cert.checkValidity(fecha);
			return true;
		} catch (CertificateExpiredException e) {
			return false;
		} catch (CertificateNotYetValidException e) {
			return false;
		}
	}

	public String getCSDPemBase64(boolean isPersonaFisica) throws IOException, InterruptedException,
			CertificadoException {
		String archivoIncorrecto = "unable to load certificate";
		
		if(!isCSD()) {
			log.warn("No es de tipo CSD");
			throw new CertificadoException("No es de tipo CSD");
		}
		
		Long ahora = new Date().getTime();
		if ( ahora > cert.getNotAfter().getTime() ) {
			log.warn("Certificado Caduco");
			throw new CertificadoException("Certificado Caduco");
		}
			
			
		Double rand = Math.random();
		String rutaArchivoCer = carpetaCSD + ahora + rand + ".cer";
		String rutaArchivoPem = carpetaCSD + ahora + rand + ".pem";

		Archivo archivo = new Archivo();
		archivo.guardarBytes(rutaArchivoCer, fileBytes);

		// convirtiendo de DER a PEM
		String comandoLlave = "openssl x509 -inform DER -outform PEM -in "
				+ rutaArchivoCer + " -out " + rutaArchivoPem;
		Process proc = Runtime.getRuntime().exec(comandoLlave);
		int code = proc.waitFor();
		
		// borrando archivos temporales
		File archivoCer = new File(rutaArchivoCer);
		if (!archivoCer.delete()) {
			log.info("No se pudo borrar el archivo: " + rutaArchivoCer);
		}

		String strPem = "";
		if (code == 0) {
			strPem = archivo.leerArchivo(rutaArchivoPem);
			File archivoPem = new File(rutaArchivoPem);
			if (!archivoPem.delete()) {
				log.info("No se pudo borrar el archivo: " + rutaArchivoPem);
			}
		} else {
			InputStream is = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String mensajeError = br.readLine();
			log.info("Mensaje de Error:" + mensajeError);

			if (mensajeError.equals(archivoIncorrecto)) {
				throw new CertificadoException("Archivo incorrecto");
			}
			throw new CertificadoException();
		}

		return strPem;
	}

	public Boolean perteneceAPrivateKey(PrivateKey privateKey) {
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)privateKey;
		RSAPublicKey publicKey = (RSAPublicKey)this.cert.getPublicKey();
		BigInteger publicModulo = publicKey.getModulus();
		BigInteger privateModulo = rsaPrivateKey.getModulus();
		return publicModulo.equals(privateModulo) ? true : false;
	}
	
	public String getNoSerie() {
		BigInteger serial = cert.getSerialNumber();
		char[] serialHex = serial.toString(16).toCharArray();
		ArrayList<Character> serialFinal = new ArrayList<Character>();
		
		for (int i = 0; i < serialHex.length; i++) {
			if (i%2 != 0) {
				serialFinal.add(serialHex[i]);
			}
		}
		
		String noCertificado = "";
		for (Character character : serialFinal) {
			noCertificado += character;
		}
		
		return noCertificado;
	}

	public PublicKey getPublicKey() {
		return cert.getPublicKey();
	}
	
	public X509Certificate getCert() {
		return cert;
	}

	public void setCert(X509Certificate cert) {
		this.cert = cert;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	public String getRFC() {
		return rfc;
	}
}