package mx.xpd.service.rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RecompraService implements RecompraInterface {
	
	private final static Logger log = Logger.getLogger(RecompraService.class);
	
	@Override
	public JsonObject getAgente(String urlService, String rfc) {
		JsonObject jsonObj = null;
		URL url;
		try {
			log.info("URL_SERVICE : " + urlService + rfc);
			url = new URL(urlService + rfc);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			InputStream jsonStr = conn.getInputStream();
			JsonParser parser = new JsonParser();
			jsonObj = parser.parse(IOUtils.toString(jsonStr)).getAsJsonObject();
			log.info(" SERVICE_RESPONSE : " + jsonObj.toString());
			conn.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObj;
	}

}
