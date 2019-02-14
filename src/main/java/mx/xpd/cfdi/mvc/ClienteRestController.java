package mx.xpd.cfdi.mvc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.map.MapCliente;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.ClienteDao;

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
@RequestMapping("/rest/cliente")
public class ClienteRestController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(ComprobanteController.class);

	@Autowired
	private ClienteDao clienteDao;

	@RequestMapping(value="/nuevos/{tenant}/{fecha}", method=RequestMethod.GET)
    public @ResponseBody List<Cliente> nuevos(@PathVariable("tenant") String tenant, 
    		@PathVariable("fecha") String fecha, HttpServletRequest request) {
		List<Cliente> tmp = clienteDao.findNuevos(tenant, fecha);
		return tmp;
    }

	@RequestMapping(value="/agregar/", method=RequestMethod.POST)
    public @ResponseBody Map<String, String> agregar(HttpServletRequest request) {	
		String str = request.getParameter("json");	
	    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		Cliente []ctes= gson.fromJson(str, Cliente[].class);
		Map<String, String> result = new HashMap<String, String>();
		String clave = "";
		for (Cliente cte : ctes) {
			try {
				
				Cliente tmp = clienteDao.findByClave(cte.getTenantId(), cte.getClave());
				clave = cte.getClave();
				if (tmp != null) {
					clienteDao.add(cte);
					result.put(clave, "200");
				} else {
					result.put(clave, "504");
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.put(clave, "500");
			}
			
		}
		return result;
    }
	
	
	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.GET)
    public @ResponseBody boolean eliminar(@PathVariable("id") Long id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		return clienteDao.remove(tenantID, id);
    }
	
	@RequestMapping(value="/find/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody Cliente findById(@PathVariable("id") Long id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		clienteDao.setTenantId(tenantID);
		return clienteDao.findById(tenantID, id);
    }
	
	@RequestMapping(value="/listarAll/{tenant}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Cliente> listarAll(@PathVariable("tenant") String tenant, HttpServletRequest request) {
		List<Cliente> ctes = clienteDao.findAll(tenant);
		return ctes;
    }

	
	@RequestMapping(value="/listar/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MapCliente> listar(@PathVariable("id") String id, HttpServletRequest request) {
		 final String tenantID = (String)request.getSession().getAttribute("tenantId");
		 clienteDao.setTenantId(tenantID);
		 List<MapCliente> m = clienteDao.findAllMap(tenantID,id);
		 List<MapCliente> map = new ArrayList<MapCliente>();
		 for (MapCliente mapCliente : m) {
			 try {
				mapCliente.setName(new String(mapCliente.getName().getBytes("UTF-8")));
				map.add(mapCliente);
			} catch (UnsupportedEncodingException e) {
			}
		 }
		 return map;		 
    }
	
	
	@RequestMapping(value="/listarRFC/{id}", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MapCliente> listarRFC(@PathVariable("id") String id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		clienteDao.setTenantId(tenantID);
		
		 List<MapCliente> m = clienteDao.findAllMapRfc(tenantID, id);
		 List<MapCliente> map = new ArrayList<MapCliente>();
		 for (MapCliente mapCliente : m) {
			 try {
				mapCliente.setName(new String(mapCliente.getName().getBytes("UTF-8")));
				map.add(mapCliente);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		 }
		 return map;		 
    }
	
	
	@RequestMapping(value="/existe/{clave}", method=RequestMethod.GET)
    public @ResponseBody Boolean existe(@PathVariable("clave") String clave, HttpServletRequest request)  throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		Cliente cliente =clienteDao.findByClave(tenantID, clave);
		if (cliente!= null) {
			return true;
		} 
		return false;
	}
}
