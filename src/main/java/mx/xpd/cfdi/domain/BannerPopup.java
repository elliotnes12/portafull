package mx.xpd.cfdi.domain;

import java.text.MessageFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.logging.Logger;

import com.sun.istack.internal.NotNull;

@Entity
public class BannerPopup {
	@Transient
	private Logger log = Logger.getLogger(BannerPopup.class);
	
	@Id
	@NotNull
	private int id;
	private String texto;
	private String image;
	private String urlRedirect;
	@NotNull
	@NotEmpty
	private String activo;
	
	public Logger getLog() {
		return log;
	}
	public void setLog(Logger log) {
		this.log = log;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUrlRedirect() {
		return urlRedirect;
	}
	public void setUrlRedirect(String urlRedirect) {
		this.urlRedirect = urlRedirect;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	@Override
	public String toString() {
		return 
				"{\n"
					+ "id:\""+id+"\",\n"
					+ "text:\""+texto+"\",\n"
					+ "image:\""+image+"\",\n"
					+ "urlRedirect:\""+urlRedirect+"\"\n"
				+ "}";
	}
}
