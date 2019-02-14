package mx.xpd.cfdi.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SecurityUtil {

	public static String pKey;
//	private Logger log = Logger.getLogger(SecurityUtil.class);

	static {
		//hay que leerlo desde archivo, la ruta se obtiene de bdd pero no se puede poner autowired
		//a menos de que se genere en el constructor una configuración, pero los métodos son static
		//		pKey = "70CEB70D37726F26F99A47AA33262C68";
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("/home/cfdi33/files/aesCfdi.txt"));
			pKey =  decryptDes(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
	}

	public static String encryptString (String pUnencryptedString) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
		Security.addProvider(new BouncyCastleProvider());
		byte[] keybBytes = Base64.decodeBase64(pKey.getBytes());
		SecretKeySpec sks = new SecretKeySpec(keybBytes, "AES");
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, sks);

		byte[] inputBytes = pUnencryptedString.trim().getBytes("UTF8");
		System.out.println("->" +new String(inputBytes));
		byte[] outputBytes = c.doFinal(inputBytes);

		String base64 = new String (Base64.encodeBase64(outputBytes));
		return base64;
	}

	public static String decryptString (String pEncryptedString) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
		Security.addProvider(new BouncyCastleProvider());
		byte[] keybBytes = Base64.decodeBase64(pKey.getBytes());
		SecretKeySpec sks = new SecretKeySpec(keybBytes, "AES");
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, sks);

		byte[] inputBytes = Base64.decodeBase64(pEncryptedString.getBytes());
		byte[] outputBytes = c.doFinal(inputBytes);
		return new String(outputBytes);
	}

	public static String decryptDes(InputStream is)  {
		try {
			DESKeySpec dks = new DESKeySpec("xpd$2012#".getBytes());
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			SecretKey desKey = skf.generateSecret(dks);
			Cipher cipher = Cipher.getInstance("DES"); // DES/ECB/PKCS5Padding for SunJCE

			cipher.init(Cipher.DECRYPT_MODE, desKey);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			CipherOutputStream cos = new CipherOutputStream(baos, cipher);
			doCopy(is, cos);
			
			return new String(baos.toByteArray(), "UTF-8");
			
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}
}

