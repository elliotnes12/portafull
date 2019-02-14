package mx.xpd.cfdi.repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RegistroDaoImpl implements RegistroDao {

	@Autowired
	@Qualifier(value = "entityManager")
	private EntityManager em;
	private Logger log = Logger.getLogger(RegistroDaoImpl.class);
	
	@Override
	public Integer ejecutarSql(String ruta) {
		try {
			List<String> lineas = leerLineasArchivo(ruta);
			int i = 0;
			for (String strQuery : lineas) {
				log.info("Ejecutando - " + strQuery);
				Query query = em.createNativeQuery(strQuery);
				i += query.executeUpdate();
			}
			return i;
		} catch (IOException e) {
			e.printStackTrace();
			return 0; //TODO return false;
		}
	}
	
	private List<String> leerLineasArchivo(String ruta) throws IOException {
		File file = new File(ruta);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		List<String> lineas = new ArrayList<String>();
		String linea;
		while ((linea = br.readLine()) != null) {
			lineas.add(linea);
		}
		br.close();
		return lineas;
	}

}
