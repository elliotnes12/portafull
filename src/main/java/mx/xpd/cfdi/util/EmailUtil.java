package mx.xpd.cfdi.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mx.xpd.cfdi.mvc.UsuarioController;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {
	
	private static Logger log = LoggerFactory.getLogger(EmailUtil.class);
	
	public static void enviarCorreo(String asunto, String texto, String correo) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "mail.expidetufactura.com.mx");
			props.put("mail.smtp.port", 25);
			props.put("mail.smtp.auth", "true");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("portal@xpd.mx", "P0rt4l_XPD$-$2015");
					//return new PasswordAuthentication("root@localhost.localdomain", "wip075developer");
				}
			});;

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("portal@xpd.mx"));
			Address replay[] = new Address[1];
			replay[0] = new InternetAddress("soporte@expidetufactura.com.mx");
			message.setReplyTo(replay);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
			message.setSubject(asunto);
			message.setContent(texto, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (Exception e) {
			log.error(e.getCause().toString());
			e.printStackTrace();
		}
	}

}