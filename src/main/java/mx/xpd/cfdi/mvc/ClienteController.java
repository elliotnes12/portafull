package mx.xpd.cfdi.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.map.MapCliente;
import mx.xpd.cfdi.domain.map.MapClienteJSON;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.CatalogoUsoCFDIDao;
import mx.xpd.cfdi.repo.ClienteDao;
import mx.xpd.cfdi.repo.PaisEstadoDao;
import mx.xpd.cfdi.util.SecurityUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {
	
   private Logger log = Logger.getLogger(ClienteController.class);

	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private PaisEstadoDao paisEstadosDao;
	@Autowired
	private CatalogoUsoCFDIDao catalogoUsoCFDIDao;
	
		
	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model, HttpServletRequest request) {
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		Cliente cliente = new Cliente();
		String msg = (String)request.getParameter("msg");
		String error = (String)request.getParameter("error");
		if(msg != null && msg.length() > 0) {
			model.addAttribute("msg", msg);
			model.addAttribute("error", error);
		}
		model.addAttribute("cliente", cliente);
		clienteDao.setTenantId(tenantID);
		List<MapClienteJSON> clientes = clienteDao.findMapAll(tenantID);
		model.addAttribute("clientes", clientes);
		model.addAttribute("paises", paisEstadosDao.findAllPais());
		model.addAttribute("usosCFDI", catalogoUsoCFDIDao.findAll());
		return "cliente/mostrar";
	}
	
	@RequestMapping(value="/agregarClaveDes", method = RequestMethod.GET)
	public void agregarClaveDes(HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		List<MapCliente> mapClientes = clienteDao.findClMapClaveDes(tenantID);
		log.info(mapClientes.size());
		
		String tmp = "";
		for (MapCliente mapCliente : mapClientes) {
			try {
				log.info(mapClientes.size());
				tmp = SecurityUtil.decryptString(mapCliente.getName());
				tmp = new String(tmp.getBytes("UTF-8"));
				mapCliente.setName(tmp);
				clienteDao.updateClaveDes(mapCliente);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	@RequestMapping(value="/agregarRFCDes", method = RequestMethod.GET)
	public void agregarRFCDes(HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		List<MapCliente> mapClientes = clienteDao.findAllMapRFCDes(tenantID);
		log.info(mapClientes.size());
		
		String tmp = "";
		for (MapCliente mapCliente : mapClientes) {
			try {
				log.info(mapClientes.size());
				tmp = SecurityUtil.decryptString(mapCliente.getName());
				tmp = new String(tmp.getBytes("UTF-8"));
				mapCliente.setName(tmp);
				clienteDao.updateRFCDes(mapCliente, tenantID);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
		
	@RequestMapping(value="/agregarDes", method = RequestMethod.GET)
	public void agregarDes() {
		List<MapCliente> mapClientes = clienteDao.findAllMapDes();
		log.info(mapClientes.size());
		
		String tmp = "";
		for (MapCliente mapCliente : mapClientes) {
			try {
				log.info(mapClientes.size());
				tmp = SecurityUtil.decryptString(mapCliente.getName());
				tmp = new String(tmp.getBytes("UTF-8"));
				mapCliente.setName(tmp);
				clienteDao.updateDes(mapCliente);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	@RequestMapping(value="/agregar", method = RequestMethod.POST)
	public String Agregar( @Valid @ModelAttribute("cliente") Cliente nuevoCliente, BindingResult result, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		if (!result.hasErrors()) {
			nuevoCliente.setRfcDes(nuevoCliente.getRfc());
			nuevoCliente.setRazonSocialDes(nuevoCliente.getRazonSocial());
			nuevoCliente.setClaveDes(nuevoCliente.getClave());
			clienteDao.setTenantId(tenantID);
			clienteDao.add(nuevoCliente);
			String url = "";
			String msg = "Cliente guardado correctamente";
			String error = "0";
			url = "?msg=" + msg + "&error=" + error;
		return "redirect:/cliente/" + url;
		}else {
			model.addAttribute("clientes", clienteDao.findAll(tenantID));
			return "cliente/mostrar";
		}
	}
	
	@RequestMapping(value="/editar/{id}", method=RequestMethod.GET)
	public String editar(@PathVariable Long id, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		clienteDao.setTenantId(tenantID);
		Cliente cliente = clienteDao.findById(tenantID,id);
		if (cliente == null) {
			return "redirect:/cliente/";
		}
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("paises", paisEstadosDao.findAllPais());
		model.addAttribute("usosCFDI", catalogoUsoCFDIDao.findAll());
		return "cliente/editar";
	}
	
	@RequestMapping(value="/detalle/{id}", method=RequestMethod.GET)
	public String detalle(@PathVariable Long id, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		clienteDao.setTenantId(tenantID);
		Cliente cliente = clienteDao.findById(tenantID, id);
		if (cliente == null) {
			return "redirect:/cliente/";
		}
		model.addAttribute("cliente", cliente);
		model.addAttribute("paises", paisEstadosDao.findAllPais());
		model.addAttribute("usosCFDI", catalogoUsoCFDIDao.findAll());
		return "cliente/detalle";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model, HttpServletRequest request) throws LlavePrivadaException {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		Cliente clienteActual = clienteDao.findById(tenantID, cliente.getId());
		
		clienteDao.setTenantId(tenantID);
		clienteDao.update(cliente);
		return "redirect:/cliente/";
	}

}
