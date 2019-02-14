package mx.xpd.cfdi.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;


public class SelloCadena {
	
	private static String cleanCertificate(String cer) {
		return cer.replace("-----BEGIN CERTIFICATE-----",	"").replace("-----END CERTIFICATE-----", "")
				.replace("-----BEGIN RSA PRIVATE KEY-----",	"").replace("-----END RSA PRIVATE KEY-----", "")
				.replace("-----END PRIVATE KEY-----", "").replace("-----BEGIN PRIVATE KEY-----", "").trim();
	}
	
	public static String getSello(String res, String pass, byte []keyd)  {
		String selloS = null;
		try {
		
			KeyUtil keyUtil = new KeyUtil(keyd, false);
			
			
			String keyC = keyUtil.getPemBase64(pass);
			keyC = cleanCertificate(keyC);
			System.out.println(keyC);
			PKCS8EncodedKeySpec key = new PKCS8EncodedKeySpec(Base64.decode(keyC));
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PrivateKey kkey = kf.generatePrivate(key);
			Signature signature = Signature.getInstance("SHA1withRSA");
			signature.initSign(kkey);
	
			signature.update(res.getBytes("UTF-8"));	//utf8
	
			byte[] sello = signature.sign();
			
			selloS = Base64.encodeBytes(sello);

		} catch(Exception e) {
			e.printStackTrace();
		} 
			return selloS;
		
	}
	
}
