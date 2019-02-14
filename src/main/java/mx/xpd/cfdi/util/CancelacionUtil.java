package mx.xpd.cfdi.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import mx.xpd.cfdi.repo.ParametroDao;
import mx.xpd.cfdi.timbrado.service.TimbradoWSServiceSoapBindingStub;
import mx.xpd.service.CancelacionProductivo_PortType;
import mx.xpd.service.CancelacionProductivo_ServiceLocator;
import mx.xpd.service.RespuestaCancelacion;
import mx.xpd.service.cancelacion.CancelacionMultipleRequest;
import mx.xpd.service.cancelacion.CancelacionPort;
import mx.xpd.service.cancelacion.CancelacionPortServiceLocator;
import mx.xpd.service.cancelacion.ParametrosCancelaMultiple;
import mx.xpd.service.cancelacion.RespuestaCliente;

import org.apache.commons.codec.binary.Base64;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;



@Configurable
public class CancelacionUtil {
	
	private static Logger log = Logger.getLogger(CancelacionUtil.class);
	
	@Autowired
	private ParametroDao parametroDao;
	/*
	public static void main (String args[]) {
		CancelacionUtil cUtil = new CancelacionUtil();
		try {			
			String certificado = "-----BEGIN CERTIFICATE-----MIIEdDCCA1ygAwIBAgIUMjAwMDEwMDAwMDAxMDAwMDU4NjcwDQYJKoZIhvcNAQEFBQAwggFvMRgwFgYDVQQDDA9BLkMuIGRlIHBydWViYXMxLzAtBgNVBAoMJlNlcnZpY2lvIGRlIEFkbWluaXN0cmFjacOzbiBUcmlidXRhcmlhMTgwNgYDVQQLDC9BZG1pbmlzdHJhY2nDs24gZGUgU2VndXJpZGFkIGRlIGxhIEluZm9ybWFjacOzbjEpMCcGCSqGSIb3DQEJARYaYXNpc25ldEBwcnVlYmFzLnNhdC5nb2IubXgxJjAkBgNVBAkMHUF2LiBIaWRhbGdvIDc3LCBDb2wuIEd1ZXJyZXJvMQ4wDAYDVQQRDAUwNjMwMDELMAkGA1UEBhMCTVgxGTAXBgNVBAgMEERpc3RyaXRvIEZlZGVyYWwxEjAQBgNVBAcMCUNveW9hY8OhbjEVMBMGA1UELRMMU0FUOTcwNzAxTk4zMTIwMAYJKoZIhvcNAQkCDCNSZXNwb25zYWJsZTogSMOpY3RvciBPcm5lbGFzIEFyY2lnYTAeFw0xMjA3MjcxNzAyMDBaFw0xNjA3MjcxNzAyMDBaMIHbMSkwJwYDVQQDEyBBQ0NFTSBTRVJWSUNJT1MgRU1QUkVTQVJJQUxFUyBTQzEpMCcGA1UEKRMgQUNDRU0gU0VSVklDSU9TIEVNUFJFU0FSSUFMRVMgU0MxKTAnBgNVBAoTIEFDQ0VNIFNFUlZJQ0lPUyBFTVBSRVNBUklBTEVTIFNDMSUwIwYDVQQtExxBQUEwMTAxMDFBQUEgLyBIRUdUNzYxMDAzNFMyMR4wHAYDVQQFExUgLyBIRUdUNzYxMDAzTURGUk5OMDkxETAPBgNVBAsTCFVuaWRhZCAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2TTQSPONBOVxpXv9wLYo8jezBrb34i/tLx8jGdtyy27BcesOav2c1NS/Gdv10u9SkWtwdy34uRAVe7H0a3VMRLHAkvp2qMCHaZc4T8k47Jtb9wrOEh/XFS8LgT4y5OQYo6civfXXdlvxWU/gdM/e6I2lg6FGorP8H4GPAJ/qCNwIDAQABox0wGzAMBgNVHRMBAf8EAjAAMAsGA1UdDwQEAwIGwDANBgkqhkiG9w0BAQUFAAOCAQEATxMecTpMbdhSHo6KVUg4QVF4Op2IBhiMaOrtrXBdJgzGotUFcJgdBCMjtTZXSlq1S4DG1jr8p4NzQlzxsdTxaB8nSKJ4KEMgIT7E62xRUj15jI49qFz7f2uMttZLNThipunsN/NF1XtvESMTDwQFvas/Ugig6qwEfSZc0MDxMpKLEkEePmQwtZD+zXFSMVa6hmOu4M+FzGiRXbj4YJXn9Myjd8xbL/c+9UIcrYoZskxDvMxc6/6M3rNNDY3OFhBK+V/sPMzWWGt8S1yjmtPfXgFs1t65AZ2hcTwTAuHrKwDatJ1ZPfa482ZBROAAX1waz7WwXp0gso7sDCm2/yUVww==-----END CERTIFICATE-----";
			String llavePrivada = "-----BEGIN PRIVATE KEY-----MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALZNNBI840E5XGle/3AtijyN7MGtvfiL+0vHyMZ23LLbsFx6w5q/ZzU1L8Z2/XS71KRa3B3Lfi5EBV7sfRrdUxEscCS+naowIdplzhPyTjsm1v3Cs4SH9cVLwuBPjLk5BijpyK99dd2W/FZT+B0z97ojaWDoUais/wfgY8An+oI3AgMBAAECgYAyEeJLYA3KzEZlaoId/WQKXbC5QU78BPZwSd8LI3paZZx6yf0Pc6KVKpaEnAnhFfXBbnMme82cR3JyL+Hsjv1RMxz2aOQFmj1lSJAth3w4aAYx2gZzo0Hqg9Qjn/Bew/ChaDAwvDGqpbVfOeZkVuF36hqdgvXh4nD3POLnoXctgQJBAOrygWhspAauyzBsy8ZhHBS84iwlJbZ64RE+95d3sMGCIuW00+FOUxtD4bz0xbCaV3zkbGAntpjcGx5r1fN2ucMCQQDGowycldpEtqZyvgm2XnIRcHA8U3d71xVMguSQqIHrk+BYBdmdB9A86jhMS4CDDfxQPWT6k3ZlydAdwbFBDBp9AkBVqLDRt7pdzWC7eQ8adtFcJjl3yttjGo3wUbrHeJXzF1VN1o3heUMHj8o/sCZbawo2uLlinVgPh0BD6SEKMOEtAkAEVlUVKjR84Zwaz0l5APDurozU1GG8g4LEi+sfuX40vaLdaStKQXxriBW4nMFumySSP/Tvf77LFDAGJk+PgwslAkEArlH6rpmldpCH70qPwOeqd8a+5qikPTfg5e9z+uEjtT1aA0VksKtKo7lfeCSqV9Xk+5QZ4nZRw6djgyVGmEtdaw==-----END PRIVATE KEY-----";
			RespuestaCancelacion respuesta = cUtil.cancelarFolio("AAA010101AAA", "1111C564-F912-44C8-B16F-086A500E83E1", llavePrivada, certificado);
			if (respuesta.getCodEstatus().equals("200")) {
				log.info(respuesta.getEstatusUUIDs(0) + " - " + respuesta.getUuids(0));
			} else {				
				log.info(respuesta.getCodEstatus() + respuesta.getCodMensaje());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	public CancelacionUtil() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);		
	}

	public RespuestaCancelacion cancelarFolio(String ambiente, String rfc, String uuid, String llavePrivadaPem, String certificadoPem) throws CertificateException, InvalidKeySpecException, TransformerException, IOException, SAXException, MarshalException, XMLSignatureException, InstantiationException, IllegalAccessException, ClassNotFoundException, ServiceException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		Date date = new Date();
		String fecha = sdf.format(date);
		String xml = "<Cancelacion xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" RfcEmisor=\"" + rfc + "\" Fecha=\"" + fecha + "\" xmlns=\"http://cancelacfd.sat.gob.mx\">" +
				"<Folios>" +
				"<UUID>" + uuid + "</UUID>" + 
				"</Folios>" + 
				"</Cancelacion>";
		certificadoPem = certificadoPem.replaceAll("-----BEGIN CERTIFICATE-----", "");
		certificadoPem = certificadoPem.replaceAll("-----END CERTIFICATE-----", "");
		llavePrivadaPem = llavePrivadaPem.replaceAll("-----BEGIN PRIVATE KEY-----", "");
		llavePrivadaPem = llavePrivadaPem.replaceAll("-----END PRIVATE KEY-----", "");
		xml = this.generarXml(Base64.decodeBase64(certificadoPem), Base64.decodeBase64(llavePrivadaPem), xml);
		
		CancelacionProductivo_ServiceLocator service = new CancelacionProductivo_ServiceLocator();
		String endPoint = "";
		String usuario  = "";
		String password = "";
		
		if (ambiente.equals("PRUEBAS")) {
			endPoint = parametroDao.findByClave("URL_CANCELACION_PRUEBAS").getValor();
			usuario  = parametroDao.findByClave("USUARIO_CANCELACION_PRUEBAS").getValor();
			password = parametroDao.findByClave("PASSWORD_CANCELACION_PRUEBAS").getValor();
		} else {
			endPoint = parametroDao.findByClave("URL_CANCELACION_PRODUCCION").getValor();
			usuario  = parametroDao.findByClave("USUARIO_CANCELACION_PRODUCCION").getValor();
			password = parametroDao.findByClave("PASSWORD_CANCELACION_PRODUCCION").getValor();
		}
		
		service.setCancelacionProductivoPortEndpointAddress(endPoint);
		CancelacionProductivo_PortType port = service.getCancelacionProductivoPort();
		log.info("cancelando folio: " + uuid + " - rfcEmisor: " + rfc);
		//// "SistFact", "o-4OG5#0/RrT"+
		log.info(new String(xml.getBytes("UTF-8")));
		RespuestaCancelacion respuesta = port.cancelar(usuario, password, xml.getBytes("UTF-8"));
		if (respuesta.getCodEstatus().equals("200")) {
			log.info("respuesta: " + respuesta.getEstatusUUIDs(0) + " - " + respuesta.getUuids(0));
		} else { 
			log.info("respuesta: " + respuesta.getCodEstatus() + " - " + respuesta.getCodMensaje());	
		}
		return respuesta;
	}
	
	public RespuestaCliente cancelarFolioNuevoEsquema(String ambiente, String rfc, String numSerieCertificado, String rfcReceptor, String uuid, String total, String emailReceptor, String emailEmisor) throws CertificateException, InvalidKeySpecException, TransformerException, IOException, SAXException, MarshalException, XMLSignatureException, InstantiationException, IllegalAccessException, ClassNotFoundException, ServiceException {
		CancelacionPortServiceLocator service = new CancelacionPortServiceLocator();
		
		String endPoint = "";
		String usuario  = "";
		String password = "";
		
		if (ambiente.equals("PRUEBAS")) {
			endPoint = parametroDao.findByClave("URL_NUEVA_CANCELACION_PRUEBAS").getValor();
			usuario  = parametroDao.findByClave("USUARIO_NUEVA_CANCELACION_PRUEBAS").getValor();
			password = parametroDao.findByClave("PASSWORD_NUEVA_CANCELACION_PRUEBAS").getValor();
		} else {
			endPoint = parametroDao.findByClave("URL_NUEVA_CANCELACION_PRODUCCION").getValor();
			usuario  = parametroDao.findByClave("USUARIO_NUEVA_CANCELACION_PRODUCCION").getValor();
			password = parametroDao.findByClave("PASSWORD_NUEVA_CANCELACION_PRODUCCION").getValor();
		}
		
		service.setCancelacionPortSoap11EndpointAddress(endPoint);

		CancelacionPort port = service.getCancelacionPortSoap11();
		
		ParametrosCancelaMultiple[] parametros = new ParametrosCancelaMultiple[1];
		parametros[0] = new ParametrosCancelaMultiple();
		parametros[0].setRfcEmisor(rfc);
		parametros[0].setNoCertificado(numSerieCertificado);
		parametros[0].setUuid(uuid);
		parametros[0].setRfcReceptor(rfcReceptor);
		parametros[0].setTotal(total);
		
		CancelacionMultipleRequest cancelacionMultipleRequest =  new CancelacionMultipleRequest();
		cancelacionMultipleRequest.setUsuario(usuario);
		cancelacionMultipleRequest.setContrasena(password);
		cancelacionMultipleRequest.setParametros(parametros);
		if (emailReceptor != null){
			cancelacionMultipleRequest.setCorreo(emailReceptor);
		}
		if (emailEmisor != null){
			cancelacionMultipleRequest.setCorreoCopia(emailEmisor);
		}
				
		log.info("cancelando folio: " + uuid + " - rfcEmisor: " + rfc + " - rfcReceptor: " + rfcReceptor);
		
		RespuestaCliente[] respuesta = port.cancelacionMultiple(cancelacionMultipleRequest);
			
		log.info("respuesta: " + respuesta[0].getCodigo() + " - " + respuesta[0].getMensaje());	
		
		return respuesta[0];
	}
	
	public RespuestaCancelacion cancelarFolioRetenciones(String ambiente, String rfc, String uuid, String llavePrivadaPem, String certificadoPem) throws CertificateException, InvalidKeySpecException, TransformerException, IOException, SAXException, MarshalException, XMLSignatureException, InstantiationException, IllegalAccessException, ClassNotFoundException, ServiceException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		Date date = new Date();
		String fecha = sdf.format(date);
		String xml = "";
		if (ambiente.equals("PRUEBAS")){
			xml = "<Cancelacion xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" RfcEmisor=\"" + rfc + "\" Fecha=\"" + fecha + "\" xmlns=\"http://cancelaretencion.sat.gob.mx\">" +
					"<Folios>" +
					"<UUID>" + uuid + "</UUID>" + 
					"</Folios>" + 
					"</Cancelacion>";
		}
		if (ambiente.equals("PRODUCCION")){
			xml = "<Cancelacion xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" RfcEmisor=\"" + rfc + "\" Fecha=\"" + fecha + "\" xmlns=\"http://www.sat.gob.mx/esquemas/retencionpago/1\">" +
					"<Folios>" +
					"<UUID>" + uuid + "</UUID>" + 
					"</Folios>" + 
					"</Cancelacion>";
		}
		
		certificadoPem = certificadoPem.replaceAll("-----BEGIN CERTIFICATE-----", "");
		certificadoPem = certificadoPem.replaceAll("-----END CERTIFICATE-----", "");
		llavePrivadaPem = llavePrivadaPem.replaceAll("-----BEGIN PRIVATE KEY-----", "");
		llavePrivadaPem = llavePrivadaPem.replaceAll("-----END PRIVATE KEY-----", "");
		xml = this.generarXml(Base64.decodeBase64(certificadoPem), Base64.decodeBase64(llavePrivadaPem), xml);
		
		CancelacionProductivo_ServiceLocator service = new CancelacionProductivo_ServiceLocator();
		String endPoint = "";
		String usuario  = "";
		String password = "";
		
		if (ambiente.equals("PRUEBAS")) {
			endPoint = parametroDao.findByClave("URL_CANCELACION_RETENCIONES_PRUEBAS").getValor();
			usuario  = parametroDao.findByClave("USUARIO_CANCELACION_RETENCIONES_PRUEBAS").getValor();
			password = parametroDao.findByClave("PASSWORD_CANCELACION_RETENCIONES_PRUEBAS").getValor();
		} else {
			endPoint = parametroDao.findByClave("URL_CANCELACION_RETENCIONES_PRODUCCION").getValor();
			usuario  = parametroDao.findByClave("USUARIO_CANCELACION_RETENCIONES_PRODUCCION").getValor();
			password = parametroDao.findByClave("PASSWORD_CANCELACION_RETENCIONES_PRODUCCION").getValor();
		}
		
		service.setCancelacionProductivoPortEndpointAddress(endPoint);
		CancelacionProductivo_PortType port = service.getCancelacionProductivoPort();
		log.info("cancelando retenciones folio: " + uuid + " - rfcEmisor: " + rfc);
		//// "SistFact", "o-4OG5#0/RrT"+
		log.info(new String(xml.getBytes("UTF-8")));
		RespuestaCancelacion respuesta = port.cancelar(usuario, password, xml.getBytes("UTF-8"));
		if (respuesta.getCodEstatus().equals("200")) {
			log.info("respuesta: " + respuesta.getEstatusUUIDs(0) + " - " + respuesta.getUuids(0));
		} else { 
			log.info("respuesta: " + respuesta.getCodEstatus() + " - " + respuesta.getCodMensaje());	
		}
		return respuesta;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String generarXml(byte[] certBytes, byte[] llaveBytes, String preFirma) throws TransformerException, CertificateException, IOException, SAXException, InvalidKeySpecException, MarshalException, XMLSignatureException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			byte[] preFirmaBytes = preFirma.getBytes("UTF-8");
			Document doc = db.parse(new ByteArrayInputStream(preFirmaBytes));
			
			PrivateKey privK = new KeyUtil(llaveBytes, true).getPrivateKey();
			X509Certificate cert = new CertificadoUtil(certBytes).getCert(); 
										
			
			String providerName = System.getProperty("jsr105Provider", "org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI");
			
			DOMSignContext dsc = new DOMSignContext(privK, doc.getDocumentElement());
//			XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM", (Provider) Class.forName(providerName).newInstance());
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
			
			Reference ref = fac.newReference
					("", fac.newDigestMethod(DigestMethod.SHA1, null),
							Collections.singletonList
							(fac.newTransform(Transform.ENVELOPED,
									(TransformParameterSpec) null)), null, null);
			
			SignedInfo si = fac.newSignedInfo
					(fac.newCanonicalizationMethod
							(CanonicalizationMethod.INCLUSIVE,
									(C14NMethodParameterSpec) null),
									fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
									Collections.singletonList(ref)); 
			
			KeyInfoFactory kif = fac.getKeyInfoFactory();
			
			List x509 = new ArrayList();
			
			x509.add(kif.newX509IssuerSerial(cert.getIssuerX500Principal().toString(), cert.getSerialNumber()));
			x509.add(cert);
			X509Data x509Data = kif.newX509Data(x509);
			List items = new ArrayList();
			
			items.add(x509Data);
			KeyInfo ki = kif.newKeyInfo(items);			
			XMLSignature signature = fac.newXMLSignature(si, ki);
			
			signature.sign(dsc);
			

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer trans = tf.newTransformer();
//			trans.transform(new DOMSource(doc), new StreamResult("cancelacionSistemaFacturacion.xml"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			trans.transform(new DOMSource(doc), new StreamResult(bos));
			log.info("termina proceso de generar xml");
			
			return bos.toString("UTF-8");
			
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} 
//			catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		return "";
	}
	
}
