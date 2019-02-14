package mx.xpd.cfdi.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;




public class Reto {

	public static void main(String []args) throws MalformedURLException, IOException {
		
		String url = "http://expidetufactura.com.mx:8080/LCO/rest/certificado/xpd/55412/CCC1007293K0/";
		HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
		
		
		
		con.setRequestMethod("GET");
		
		java.io.InputStream in = con.getInputStream();
		
		byte []bytes = new byte[1024];
		in.read(bytes);
		
		String dat = new String(bytes);
		
		System.out.println(Integer.parseInt(dat.substring(0,3)));
		
		
	}
	
	
}
