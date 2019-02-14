package mx.xpd.cfdi.repo;

import java.util.List;

import mx.xpd.cfdi.domain.CodigoPostal;
import mx.xpd.cfdi.domain.Colonia;
import mx.xpd.cfdi.domain.Estado;
import mx.xpd.cfdi.domain.Localidad;
import mx.xpd.cfdi.domain.Pais;


public interface PaisEstadoDao {

	public List<Pais> findAllPais();
	
	public List<Estado> findAllEstado();
	
	//public List<CatalogoEstados> findAllCatalogoEstados();
	
	public String findClavePais(String strPais);
	
	public String findClaveEstado(String strEstado);
	
	public String findClaveMunicipio(String strMunicipio, String strEstado);
	
	public String findClaveLocalidad(String strLocalidad, String strEstado);
	
	public List<Estado> findAllEstadoMap(String paisId);
	
	public List<Localidad> findAllLocalidadMap(String paisId);
	
	public List<Localidad> findAllMunicipioMap(String paisId);
	
	public List<CodigoPostal> findAllCodigoPostalMap(String estadoId);
	
	public List<CodigoPostal> findAllCodigoPostalMap(String estadoId, String municipioId);
	
	public List<CodigoPostal> findAllCodigoPostalMap(String estadoId, String municipioId, String localidadId );
	
	public List<Colonia> findAllColoniaMap(String codigoPostalId);
	
	public Estado findById(String paisId);
	
	public String findNombreMunicipio(String strEstado, String strClave);
	
}
