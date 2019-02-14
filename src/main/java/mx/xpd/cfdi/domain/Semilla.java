package mx.xpd.cfdi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Paul
 *
 */
@Entity
public class Semilla implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String pkey;
	
	private Date fechaRegistro;
	private Date ultimaActualizacion;
	private Boolean eliminado;
	private Boolean semaforo;
	
	public Semilla(){
		this.fechaRegistro = new Date();
		this.ultimaActualizacion = new Date();
		this.setEliminado(false);
		this.setSemaforo(false);
	}
	
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	public Boolean getEliminado() {
		return eliminado;
	}

	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

	public Boolean getSemaforo() {
		return semaforo;
	}

	public void setSemaforo(Boolean semaforo) {
		this.semaforo = semaforo;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getPkey() {
		return pkey;
	}

	public void setPkey(String pkey) {
		this.pkey = pkey;
	}
	

	
	
}
