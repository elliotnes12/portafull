package mx.xpd.cfdi.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.hibernate.lob.ReaderInputStream;
import org.jfree.util.Log;

import mx.xpd.cfdi.util.Base64;
import mx.xpd.cfdi.util.Hash;


public class Sello {
	
	public static String getSello(InputStream xml, String llave, String xslt)  {
		String selloS = null;
		try {
		
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer(new StreamSource(xslt));
			Writer out = new StringWriter();
			StreamResult result = new StreamResult(out);
			transformer.transform(new StreamSource(xml), result);
			
			String res = out.toString();
			Log.info("Sello: #################### \n" + res + "\n");
			System.out.println(res);

			BufferedInputStream bis = new BufferedInputStream(new ReaderInputStream(new StringReader(llave)));
			byte[] pKey = new byte[llave.length() + 1]; 
			bis.read(pKey); 
			bis.close();
			
			PKCS8EncodedKeySpec key = new PKCS8EncodedKeySpec(Base64.decode(llave));
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PrivateKey kkey = kf.generatePrivate(key);
			Signature signature = Signature.getInstance("SHA256withRSA");
			signature.initSign(kkey);
	
			signature.update(res.getBytes("UTF-8"));	//utf8
	
			byte[] sello = signature.sign();
			
			selloS = Base64.encodeBytes(sello);

		} catch(Exception e) {
			e.printStackTrace();
		} 
			return selloS;
		
	}
	
	public static String getSelloRetenciones(InputStream xml, String llave, String xslt)  {
		String selloS = null;
		try {
		
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer(new StreamSource(xslt));
			Writer out = new StringWriter();
			StreamResult result = new StreamResult(out);
			transformer.transform(new StreamSource(xml), result);
			
			String res = out.toString();
			Log.info("Sello: #################### \n" + res + "\n");
			System.out.println(res);

			BufferedInputStream bis = new BufferedInputStream(new ReaderInputStream(new StringReader(llave)));
			byte[] pKey = new byte[llave.length() + 1]; 
			bis.read(pKey); 
			bis.close();
			
			PKCS8EncodedKeySpec key = new PKCS8EncodedKeySpec(Base64.decode(llave));
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
