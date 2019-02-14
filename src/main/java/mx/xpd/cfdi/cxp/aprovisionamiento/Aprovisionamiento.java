package mx.xpd.cfdi.cxp.aprovisionamiento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mx.xpd.cfdi.cxp.constantes.ConstantesCxP;
import mx.xpd.cfdi.cxp.pojo.Inquilino;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class Aprovisionamiento {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	private String className = this.getClass().getSimpleName(); 
	
	public List<Inquilino> obtenerListaInquilinos(String pURL, String pUserCxP, String pPwdCxP){
		log.info(className + ".obtenerListaInquilinos");
		List<Inquilino> listaInquilinos = new ArrayList<Inquilino>();
		
		try{
			
			//System.setProperty ("jsse.enableSNIExtension", "false");
			URL url = new URL(pURL);
			log.info("URL obtenerListaInquilinos: "+url.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			String userCredentials = pUserCxP + ":" + pPwdCxP;
			String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
			conn.setRequestProperty ("Authorization", basicAuth);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod("GET");
			
			log.info("Respuesta CxP: " + conn.getResponseMessage());
						
			switch (conn.getResponseCode()) {
				case ConstantesCxP.SUCCESS_TENANT_LIST:
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String output;
					String cadenaJSON = "";
					log.info("Inquilinos existentes");				
					while ((output = br.readLine()) != null) {
						log.info(output);
						cadenaJSON = output;
					}
					JSONArray jsonArray = new JSONArray(cadenaJSON);					
					Gson gson = new Gson();
				    for(int i=0; i<jsonArray.length(); i++){
				    	listaInquilinos.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Inquilino.class));
				    }				    
				    break;
				case ConstantesCxP.UNAUTHENTICATED_TENANTS_LIST:
					log.info("No autenticado (usuario y contraseña)");				
				    break;
				case ConstantesCxP.WITHOUT_AUTHORITY_TENANTS_LIST:
					log.info("Sin autorización para listar inquilinos");
				    break;				
				default:
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}		
	 
			conn.disconnect();
			
		}catch (MalformedURLException e){
			log.error("Ocurrió MalformedURLException en " + className+ ".obtenerListaInquilinos");
			e.printStackTrace();
		}catch (IOException e){
			log.error("Ocurrió IOException en " + className+ ".obtenerListaInquilinos");
			e.printStackTrace();
		}catch (JSONException e) {
			log.error("Ocurrió JSONException en " + className+ ".obtenerListaInquilinos");
			e.printStackTrace();
		}
		
		return listaInquilinos;
	}
	
	public Inquilino obtenerInquilino(String rfc, String pURL, String pUserCxP, String pPwdCxP){
		log.info(className + ".obtenerInquilino");
		Inquilino inquilino = null;
		
		try {		
			
			//System.setProperty ("jsse.enableSNIExtension", "false");
			URL url = new URL(pURL + ConstantesCxP.PAIS + rfc.trim());
			log.info("URL obtenerInquilino: "+url.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			String userCredentials = pUserCxP + ":" + pPwdCxP;
			String basicAuth = "Basic " + new String(new Base64().encode(userCredentials.getBytes()));
			conn.setRequestProperty ("Authorization", basicAuth);
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod("GET");
			
			log.info("Respuesta CxP: " + conn.getResponseMessage());
						
			switch (conn.getResponseCode()) {
				case ConstantesCxP.SUCCESS_GET_TENANT:
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String output;
					String cadenaJSON = "";
					log.info("Inquilino encontrado");				
					while ((output = br.readLine()) != null) {
						log.info(output);
						cadenaJSON = output;
					}
					Gson gson = new Gson();				
					inquilino = gson.fromJson(cadenaJSON, Inquilino.class);				
					break;
				case ConstantesCxP.UNAUTHENTICATED_GET_TENANT:
					log.info("No autenticado (usuario y contraseña)");				
				    break;
				case ConstantesCxP.WITHOUT_AUTHORITY_GET_TENANT:
					log.info("Sin autorización para ver este inquilino");
				    break;
				case ConstantesCxP.TENANT_NOT_FOUND:
					log.info("Inquilino no encontrado");
				    break;
				default:
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}		
	 
			conn.disconnect();
	 
		  }catch (MalformedURLException e){
			  log.error("Ocurrió MalformedURLException en " + className+ ".obtenerInquilino");
			e.printStackTrace();
		  }catch (IOException e){
			  log.error("Ocurrió IOException en " + className+ ".obtenerInquilino");
			e.printStackTrace();
		  }
	 
		return inquilino;
	}
	
}	
