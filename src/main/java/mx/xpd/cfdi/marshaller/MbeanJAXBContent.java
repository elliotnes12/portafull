package mx.xpd.cfdi.marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class MbeanJAXBContent {

	private static JAXBContext instance;

	public static synchronized JAXBContext initContext() throws JAXBException {
			if (instance == null)
				instance = JAXBContext.newInstance(Comprobante.class);
		return instance;
	}
}
