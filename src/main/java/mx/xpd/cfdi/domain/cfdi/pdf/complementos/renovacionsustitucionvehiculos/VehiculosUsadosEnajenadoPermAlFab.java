package mx.xpd.cfdi.domain.cfdi.pdf.complementos.renovacionsustitucionvehiculos;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "VehiculosUsadosEnajenadoPermAlFab")
public class VehiculosUsadosEnajenadoPermAlFab{

	private String precioVehUsadoRenovacion;
	private String tipoVehRenovacion;
	private String marcaRenovacion;
	private String tipooClaseRenovacion;
	private String anioRenovacion;
	private String modeloRenovacion;
	private String nivRenovacion;
	private String numSerieRenovacion;
	private String numPlacasRenovacion;
	private String numMotorRenovacion;
	private String numFolTarjCirRenovacion;
	private String numPedImRenovacion;
	private String aduanaRenovacion;
	private String fechaRegularizacionRenovacion;
	private String foliofiscalRenovacion;
	
	
	public VehiculosUsadosEnajenadoPermAlFab() {
		
	}
	
	@XmlAttribute(name = "PrecioVehUsado")
	public String getPrecioVehUsadoRenovacion() {
		return precioVehUsadoRenovacion;
	}

	public void setPrecioVehUsado(String precioVehUsadoRenovacion) {
		this.precioVehUsadoRenovacion = precioVehUsadoRenovacion;
	}
	
	@XmlAttribute(name = "TipoVeh")
	public String getTipoVehRenovacion() {
		return tipoVehRenovacion;
	}

	public void setTipoVehRenovacion(String tipoVehRenovacion) {
		this.tipoVehRenovacion = tipoVehRenovacion;
	}
	
	@XmlAttribute(name = "Marca")
	public String getMarcaRenovacion() {
		return marcaRenovacion;
	}

	public void setMarcaRenovacion(String marcaRenovacion) {
		this.marcaRenovacion = marcaRenovacion;
	}
	
	@XmlAttribute(name = "TipooClase")
	public String getTipooClaseRenovacion() {
		return tipooClaseRenovacion;
	}

	public void setTipooClaseRenovacion(String tipooClaseRenovacion) {
		this.tipooClaseRenovacion = tipooClaseRenovacion;
	}
	
	@XmlAttribute(name = "Año")
	public String getAnioRenovacion() {
		return anioRenovacion;
	}

	public void setAnioRenovacion(String anioRenovacion) {
		this.anioRenovacion = anioRenovacion;
	}
	
	@XmlAttribute(name = "Modelo")
	public String getModeloRenovacion() {
		return modeloRenovacion;
	}

	public void setModeloRenovacion(String modeloRenovacion) {
		this.modeloRenovacion = modeloRenovacion;
	}
	
	@XmlAttribute(name = "NIV")
	public String getNivRenovacion() {
		return nivRenovacion;
	}

	public void setNivRenovacion(String nivRenovacion) {
		this.nivRenovacion = nivRenovacion;
	}
			
	@XmlAttribute(name = "NumSerie")
	public String getNumSerieRenovacion() {
		return numSerieRenovacion;
	}

	public void setNumSerieRenovacion(String numSerieRenovacion) {
		this.numSerieRenovacion = numSerieRenovacion;
	}
	
	@XmlAttribute(name = "NumPlacas")
	public String getNumPlacasRenovacion() {
		return numPlacasRenovacion;
	}

	public void setNumPlacasRenovacion(String numPlacasRenovacion) {
		this.numPlacasRenovacion = numPlacasRenovacion;
	}
	
	@XmlAttribute(name = "NumMotor")
	public String getNumMotorRenovacion() {
		return numMotorRenovacion;
	}

	public void setNumMotorRenovacion(String numMotorRenovacion) {
		this.numMotorRenovacion = numMotorRenovacion;
	}
	
	@XmlAttribute(name = "NumFolTarjCir")
	public String getNumFolTarjCirRenovacion() {
		return numFolTarjCirRenovacion;
	}

	public void setNumFolTarjCirRenovacion(String numFolTarjCirRenovacion) {
		this.numFolTarjCirRenovacion = numFolTarjCirRenovacion;
	}
	
	@XmlAttribute(name = "NumPedIm")
	public String getNumPedImRenovacion() {
		return numPedImRenovacion;
	}

	public void setNumPedImRenovacion(String numPedImRenovacion) {
		this.numPedImRenovacion = numPedImRenovacion;
	}
	
	@XmlAttribute(name = "Aduana")
	public String getAduanaRenovacion() {
		return aduanaRenovacion;
	}

	public void setAduanaRenovacion(String aduanaRenovacion) {
		this.aduanaRenovacion = aduanaRenovacion;
	}
	
	@XmlAttribute(name = "FechaRegulVeh")
	public String getFechaRegularizacionRenovacion() {
		return fechaRegularizacionRenovacion;
	}

	public void setFechaRegularizacionRenovacion(String fechaRegularizacionRenovacion) {
		this.fechaRegularizacionRenovacion = fechaRegularizacionRenovacion;
	}
	
	@XmlAttribute(name = "Foliofiscal")
	public String getFoliofiscalRenovacion() {
		return foliofiscalRenovacion;
	}

	public void setFoliofiscalRenovacion(String foliofiscalRenovacion) {
		this.foliofiscalRenovacion = foliofiscalRenovacion;
	}
}