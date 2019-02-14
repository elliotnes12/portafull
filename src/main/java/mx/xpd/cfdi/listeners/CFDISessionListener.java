package mx.xpd.cfdi.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CFDISessionListener implements HttpSessionListener {
	
	private Logger log = LoggerFactory.getLogger(CFDISessionListener.class);

	public void sessionCreated(HttpSessionEvent event) {
		log.info("Session creada... ID [ " + event.getSession().getId() + "]" );
	}
	
	public void sessionDestroyed(HttpSessionEvent event) {
		
		log.info("Session destruida... ID [ " + event.getSession().getId() + "]");
	
	}
}