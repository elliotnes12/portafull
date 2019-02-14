package mx.xpd.cfdi.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.CodigoPostal;
import mx.xpd.cfdi.domain.Colonia;
import mx.xpd.cfdi.domain.Estado;
import mx.xpd.cfdi.domain.Localidad;
import mx.xpd.cfdi.domain.Pais;
import mx.xpd.cfdi.domain.ProductoServicio;
import mx.xpd.cfdi.domain.map.MapCliente;
import mx.xpd.cfdi.domain.map.MapLugarExpedicion;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.PaisEstadoDao;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/rest/estado")
public class EstadoRestController {
	
	
	@Autowired
	private PaisEstadoDao paisEstadoDao;

	@RequestMapping(value="/listarEstados/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody void listarEstados(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		out.println("<option value='default'>Seleccionar</option>");
		
		List<Estado> listaEstados = paisEstadoDao.findAllEstadoMap(id);
		for(int i=0; i<listaEstados.size(); i++){
			out.println("<option value='"+listaEstados.get(i).getId()+"'>"+listaEstados.get(i).getNombre()+"</option>");
		 }
    }
	
	
	
	@RequestMapping(value="/listarLocalidades/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody void listarLocalidades(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		out.println("<option value='default'>Seleccionar</option>");
		
		List<Localidad> listaEstados = paisEstadoDao.findAllLocalidadMap(id);
		for(int i=0; i<listaEstados.size(); i++){
			out.println("<option value='"+listaEstados.get(i).getClave()+"'>"+listaEstados.get(i).getNombre()+"</option>");
		 }
    }
	
	@RequestMapping(value="/listarMunicipios/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody void listarMunicipios(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		out.println("<option value='default'>Seleccionar</option>");
		
		List<Localidad> listaEstados = paisEstadoDao.findAllMunicipioMap(id);
		for(int i=0; i<listaEstados.size(); i++){
			out.println("<option value='"+listaEstados.get(i).getClave()+"'>"+listaEstados.get(i).getNombre()+"</option>");
		 }
    }
	
	@RequestMapping(value="/listarCodigosPostalesEstado/{estadoId}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody void listarCodigosPostalesEstado(@PathVariable("estadoId") String estadoId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		out.println("<option value='default'>Seleccionar</option>");
		
		List<CodigoPostal> listaEstados = paisEstadoDao.findAllCodigoPostalMap(estadoId);
		for(int i=0; i<listaEstados.size(); i++){
			out.println("<option value='"+listaEstados.get(i).getCp()+"'>"+listaEstados.get(i).getCp()+"</option>");
		 }
    }
	
	@RequestMapping(value="/listarCodigosPostalesEstadoMunicipio/{estadoId}/{municipioId}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody void listarCodigosPostalesEstadoMunicipio(@PathVariable("estadoId") String estadoId, @PathVariable("municipioId") String municipioId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		out.println("<option value='default'>Seleccionar</option>");
		
		List<CodigoPostal> listaEstados = paisEstadoDao.findAllCodigoPostalMap(estadoId, municipioId);
		for(int i=0; i<listaEstados.size(); i++){
			out.println("<option value='"+listaEstados.get(i).getCp()+"'>"+listaEstados.get(i).getCp()+"</option>");
		 }
    }
	
	@RequestMapping(value="/listarCodigosPostalesEstadoMunicipioLocalidad/{estadoId}/{municipioId}/{localidadId}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody void listarCodigosPostalesEstadoMunicipio(@PathVariable("estadoId") String estadoId, @PathVariable("municipioId") String municipioId, @PathVariable("localidadId") String localidadId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		out.println("<option value='default'>Seleccionar</option>");
		
		List<CodigoPostal> listaEstados = paisEstadoDao.findAllCodigoPostalMap(estadoId, municipioId, localidadId);
		for(int i=0; i<listaEstados.size(); i++){
			out.println("<option value='"+listaEstados.get(i).getCp()+"'>"+listaEstados.get(i).getCp()+"</option>");
		 }
    }
	
	@RequestMapping(value="/listarColonias/{codigoPostalId}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody void listarColonias(@PathVariable("codigoPostalId") String codigoPostalId, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType( "text/html; charset=iso-8859-1" );
		PrintWriter out = response.getWriter();
		out.println("<option value='default'>Seleccionar</option>");
		
		List<Colonia> listaEstados = paisEstadoDao.findAllColoniaMap(codigoPostalId);
		for(int i=0; i<listaEstados.size(); i++){
			out.println("<option value='"+listaEstados.get(i).getC_colonia()+"'>"+listaEstados.get(i).getNombre()+"</option>");
		 }
    }
	

	@RequestMapping(value="/find/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody Estado findById(@PathVariable("id") String id, HttpServletRequest request) {
		System.out.println(id);
		return paisEstadoDao.findById(id);
    }
}
