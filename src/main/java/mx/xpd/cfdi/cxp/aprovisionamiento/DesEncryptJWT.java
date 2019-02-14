package mx.xpd.cfdi.cxp.aprovisionamiento;

import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;

public class DesEncryptJWT {

	private static Logger log = Logger.getLogger(DesEncryptJWT.class);
	
	public String getRFCByJWT(String path, String jwt){
		RSAPublicKey publicKey = null;
		String rfcUsuario = null;
		
		try {
			
			publicKey = (RSAPublicKey)readPublicKey(new File(path));			
			log.info("publicKey: "+publicKey);		
		
			SignedJWT signedJWT = SignedJWT.parse(jwt);
			JWSVerifier verifier = new RSASSAVerifier(publicKey);
			
			if(signedJWT.verify(verifier) == true){
			   if(signedJWT.getJWTClaimsSet().getIssuer().equalsIgnoreCase("cuentasporpagar.com")){
			      if(signedJWT.getJWTClaimsSet().getClaim("inquilino") != null){
				    rfcUsuario = signedJWT.getJWTClaimsSet().getClaim("inquilino").toString();
				    rfcUsuario = rfcUsuario.replace("mx_", "");
			      }else{
			    	log.info("No existe el inquilino...");
			      }
			   }else{
			      log.info("El issuer no es cuentasporpagar.com"); 	  
			   }
			}else{
				log.info("La firma no es válida");
			}
		
		}catch(ParseException pe){
			log.error("Ocurrio ParseException "+pe.getCause());
			pe.printStackTrace();
		}catch(JOSEException je){
			log.error("Ocurrio JOSEException "+je.getCause());
			je.printStackTrace();
		}catch(Exception e) {
			log.error("Error al generar RSA Key");
			e.printStackTrace();
		}
		return rfcUsuario;
	}
	
	public static PublicKey readPublicKey (File keyFile) throws Exception {

		FileInputStream fis = new FileInputStream(keyFile);		
		PublicKey key = null;	
		
		try{
	    CertificateFactory fact = CertificateFactory.getInstance("X.509");
	    X509Certificate cer = (X509Certificate) fact.generateCertificate(fis);	    
	    fis.close();	    
	    key = cer.getPublicKey();
		}catch(Exception e){
			e.printStackTrace();
		}
	    return key;
	}
}
