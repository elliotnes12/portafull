package mx.xpd.cfdi.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Archivo {
	
	public String leerArchivo(String ruta) throws IOException{
		
		FileInputStream fis = new FileInputStream(ruta);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		StringBuffer sb = new StringBuffer();
		String linea;
		
		while ( (linea = br.readLine()) != null){
			sb.append(linea + "\n");
		}
		
		br.close();
		
		return sb.toString();
	}

	public void guardarBytes(String ruta, byte[] bytes) throws IOException{
		FileOutputStream fos = new FileOutputStream(ruta);
		fos.write(bytes);
		fos.close();
	}
	
}
