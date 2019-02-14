package mx.xpd.cfdi.domain.cfdi.pdf.complementos.renovacionsustitucionvehiculos;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "VehiculoUsadoEnajenadoPermAlFab")
public class VehiculoUsadoEnajenadoPermAlFab{

	private String precioVehUsadoSustitucion;
	private String tipoVehSustitucion;
	private String marcaSustitucion;
	private String tipooClaseSustitucion;
	private String anioSustitucion;
	private String modeloSustitucion;
	private String nivSustitucion;
	private String numSerieSustitucion;
	private String numPlacasSustitucion;
	private String numMotorSustitucion;
	private String numFolTarjCirSustitucion;
	private String numFolAvisointSustitucion;
	private String numPedImSustitucion;
	private String aduanaSustitucion;
	private String fechaRegularizacionSustitucion;
	private String foliofiscalSustitucion;
	
	
	public VehiculoUsadoEnajenadoPermAlFab() {
		
	}
	
	@XmlAttribute(name = "PrecioVehUsado")
	public String getPrecioVehUsadoSustitucion() {
		return precioVehUsadoSustitucion;
	}

	public void setPrecioVehUsado(String precioVehUsadoSustitucion) {
		this.precioVehUsadoSustitucion = precioVehUsadoSustitucion;
	}
	
	@XmlAttribute(name = "TipoVeh")
	public String getTipoVehSustitucion() {
		return tipoVehSustitucion;
	}

	public void setTipoVehSustitucion(String tipoVehSustitucion) {
		this.tipoVehSustitucion = tipoVehSustitucion;
	}
	
	@XmlAttribute(name = "Marca")
	public String getMarcaSustitucion() {
		return marcaSustitucion;
	}

	public void setMarcaSustitucion(String marcaSustitucion) {
		this.marcaSustitucion = marcaSustitucion;
	}
	
	@XmlAttribute(name = "TipooClase")
	public String getTipooClaseSustitucion() {
		return tipooClaseSustitucion;
	}

	public void setTipooClaseSustitucion(String tipooClaseSustitucion) {
		this.tipooClaseSustitucion = tipooClaseSustitucion;
	}
	
	@XmlAttribute(name = "Año")
	public String getAnioSustitucion() {
		return anioSustitucion;
	}

	public void setAanioSustitucion(String anioSustitucion) {
		this.anioSustitucion = anioSustitucion;
	}
	
	@XmlAttribute(name = "Modelo")
	public String getModeloSustitucion() {
		return modeloSustitucion;
	}

	public void setModeloSustitucion(String modeloSustitucion) {
		this.modeloSustitucion = modeloSustitucion;
	}
	
	@XmlAttribute(name = "NIV")
	public String getNivSustitucion() {
		return nivSustitucion;
	}

	public void setNivSustitucion(String nivSustitucion) {
		this.nivSustitucion = nivSustitucion;
	}
			
	@XmlAttribute(name = "NumSerie")
	public String getNumSerieSustitucion() {
		return numSerieSustitucion;
	}

	public void setNumSerieSustitucion(String numSerieSustitucion) {
		this.numSerieSustitucion = numSerieSustitucion;
	}
	
	@XmlAttribute(name = "NumPlacas")
	public String getNumPlacasSustitucion() {
		return numPlacasSustitucion;
	}

	public void setNumPlacasSustitucion(String numPlacasSustitucion) {
		this.numPlacasSustitucion = numPlacasSustitucion;
	}
	
	@XmlAttribute(name = "NumMotor")
	public String getNumMotorSustitucion() {
		return numMotorSustitucion;
	}

	public void setNumMotorSustitucion(String numMotorSustitucion) {
		this.numMotorSustitucion = numMotorSustitucion;
	}
	
	@XmlAttribute(name = "NumFolTarjCir")
	public String getNumFolTarjCirSustitucion() {
		return numFolTarjCirSustitucion;
	}

	public void setNumFolTarjCirSustitucion(String numFolTarjCirSustitucion) {
		this.numFolTarjCirSustitucion = numFolTarjCirSustitucion;
	}
	
	@XmlAttribute(name = "NumFolAvisoint")
	public String getNumFolAvisointSustitucion() {
		return numFolAvisointSustitucion;
	}

	public void setNumFolAvisointSustitucion(String numFolAvisointSustitucion) {
		this.numFolAvisointSustitucion = numFolAvisointSustitucion;
	}
	
	
	@XmlAttribute(name = "NumPedIm")
	public String getNumPedImSustitucion() {
		return numPedImSustitucion;
	}

	public void setNumPedImSustitucion(String numPedImSustitucion) {
		this.numPedImSustitucion = numPedImSustitucion;
	}
	
	@XmlAttribute(name = "Aduana")
	public String getAduanaSustitucion() {
		return aduanaSustitucion;
	}

	public void setAduanaSustitucion(String aduanaSustitucion) {
		this.aduanaSustitucion = aduanaSustitucion;
	}
	
	@XmlAttribute(name = "FechaRegulVeh")
	public String getFechaRegularizacionSustitucion() {
		return fechaRegularizacionSustitucion;
	}

	public void setFechaRegularizacionSustitucion(String fechaRegularizacionSustitucion) {
		this.fechaRegularizacionSustitucion = fechaRegularizacionSustitucion;
	}
	
	@XmlAttribute(name = "Foliofiscal")
	public String getFoliofiscalSustitucion() {
		return foliofiscalSustitucion;
	}

	public void setFoliofiscalSustitucion(String foliofiscalSustitucion) {
		this.foliofiscalSustitucion = foliofiscalSustitucion;
	}
}