package mx.xpd.cfdi.cxp.aprovisionamiento;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi;

import sun.misc.BASE64Decoder;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class JSONJWT {

private static Logger log = Logger.getLogger(JSONJWT.class);
	
	public String getJWT(String path, String issuer, String usuario, Integer minutos) {
		
		RSAPrivateKey privateKey = null;
		String jwtSerialize = null;
		
		try {
			privateKey = (RSAPrivateKey)readPrivateKey(new File(path));		
		
			// Create RSA-signer with the private key
			JWSSigner signer = new RSASSASigner(privateKey);
	
			//Prepare JOSEObjectType object
			JOSEObjectType jot = new JOSEObjectType("JWT");
			
			//Prepare JWT with header set
			JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS512).type(jot).build();
			
			log.info("Header: " + header.toString());
					
			// Prepare JWT with claims set
			JWTClaimsSet claimsSet = new JWTClaimsSet();
			claimsSet.setIssuer(issuer);
			claimsSet.setClaim("usuario", usuario);
			Date date = new Date();
			date.getTime();
			long unixTime = date.getTime() + calculaMilisegundos(minutos);
			log.info("Tiempo Unix: " + unixTime);
			claimsSet.setExpirationTime(new java.util.Date((long)unixTime));
							
			// Print json object
			log.info("Body: " + claimsSet.toString());
			
			SignedJWT signedJWT = new SignedJWT(header, claimsSet);		
	
			// Compute the RSA signature
			signedJWT.sign(signer);
	
			// To serialize to compact form, produces something like		
			jwtSerialize = signedJWT.serialize();
			log.info("JWT: " + jwtSerialize);
		
		} catch(NoSuchAlgorithmException nsae) {
			log.error("Ocurrio NoSuchAlgorithmException: "+nsae.getCause());
			nsae.printStackTrace();
		} catch(JOSEException je){
			log.error("Ocurrio NoSuchAlgorithmException: "+je.getCause());
			je.printStackTrace();
		}catch(ParseException pe){
			log.error("Ocurrio ParseException: "+pe.getCause());
			pe.printStackTrace();
		}catch(Exception e){
			log.error("Ocurrio Exception: "+e.getCause());
			e.printStackTrace();
		}
		
		return jwtSerialize;
	}	
	
	@SuppressWarnings("restriction")
	public static PrivateKey readPrivateKey (File keyFile) throws Exception {

		FileInputStream in = new FileInputStream(keyFile);
		byte[] keyBytes = new byte[in.available()];
		in.read(keyBytes);
		in.close();
		
		String privateKey = new String(keyBytes, "UTF-8");
		privateKey = privateKey.replace("-----BEGIN PRIVATE KEY-----\n", "")
				.replace("\n-----END PRIVATE KEY-----\n", "");
		
		privateKey = privateKey.replace("-----BEGIN RSA PRIVATE KEY-----\n", "")
				.replace("\n-----END RSA PRIVATE KEY-----\n", "");
		
		log.info("Llave: " + privateKey);
		
		BASE64Decoder decoder = new BASE64Decoder();
		keyBytes = decoder.decodeBuffer(privateKey);
		
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		return keyFactory.generatePrivate(spec);
	}
	
	public static Long calculaMilisegundos(Integer minutos){
		int milis = 1000; //Mlisegundos en un segundo
		int segundos = 60; //Segundos en un minuto
		return (long) (milis * segundos * minutos);
	}

}