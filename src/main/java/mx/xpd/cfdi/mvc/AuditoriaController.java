package mx.xpd.cfdi.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.AuditoriaCertificadoSelloDigital;
import mx.xpd.cfdi.domain.AuditoriaCliente;
import mx.xpd.cfdi.domain.AuditoriaDatosEmisor;
import mx.xpd.cfdi.domain.AuditoriaLugarEmision;
import mx.xpd.cfdi.domain.AuditoriaMoneda;
import mx.xpd.cfdi.domain.AuditoriaProductoServicio;
import mx.xpd.cfdi.domain.AuditoriaUsuario;
import mx.xpd.cfdi.domain.CertificadoSelloDigital;
import mx.xpd.cfdi.domain.Cliente;
import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.domain.LugarExpedicion;
import mx.xpd.cfdi.domain.Moneda;
import mx.xpd.cfdi.domain.ProductoServicio;
import mx.xpd.cfdi.domain.Usuario;
import mx.xpd.cfdi.repo.AuditoriaDao;
import mx.xpd.cfdi.repo.CertificadoSelloDigitalDao;
import mx.xpd.cfdi.repo.ClienteDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.GrupoUsuarioDao;
import mx.xpd.cfdi.repo.LugarExpedicionDao;
import mx.xpd.cfdi.repo.MonedaDao;
import mx.xpd.cfdi.repo.ProductoServicioDao;
import mx.xpd.cfdi.repo.UsuarioDao;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/auditoria")
public class AuditoriaController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(AuditoriaController.class);

	@Autowired
	private AuditoriaDao auditoriaDao;
	@Autowired
	private MonedaDao monedaDao;
	@Autowired
	private LugarExpedicionDao lugarDao;
	@Autowired
	private ClienteDao clienteDao;
	@Autowired
	private GrupoUsuarioDao grupoDao;
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private ProductoServicioDao productoDao;
	@Autowired
	private DatosEmisorDao datosDao;
	@Autowired
	private CertificadoSelloDigitalDao csdDao;

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model) {
		//model.addAttribute("moneda", new Moneda());
		//model.addAttribute("monedas", monedaDao.findAll());
		return "auditoria/mostrar";
	}
	
	@RequestMapping(value="/moneda", method = RequestMethod.GET)
	public String moneda(Model model) {
		model.addAttribute("monedas", auditoriaDao.findAllMoneda());
		return "auditoria/moneda";
	}
	
	@RequestMapping(value="/cliente", method = RequestMethod.GET)
	public String cliente(Model model) {
		model.addAttribute("clientes", auditoriaDao.findAllCliente());
		return "auditoria/cliente";
	}
	
	@RequestMapping(value="/lugarExpedicion", method = RequestMethod.GET)
	public String lugarEmision(Model model) {
		model.addAttribute("lugares", auditoriaDao.findAllLugar());
		return "auditoria/lugarExpedicion";
	}
	
	@RequestMapping(value="/producto", method = RequestMethod.GET)
	public String producto(Model model) {
		model.addAttribute("productos", auditoriaDao.findAllProducto());
		return "auditoria/producto";
	}
	
	@RequestMapping(value="/cfd", method = RequestMethod.GET)
	public String cfd(Model model) {
		//model.addAttribute("cfds", auditoriaDao.findAllcsd());
		return "auditoria/cfd";
	}
	
	@RequestMapping(value="/datosEmisor", method = RequestMethod.GET)
	public String datosEmisor(Model model) {
		model.addAttribute("datos", auditoriaDao.findAllDatos());
		return "auditoria/datosEmisor";
	}
	
	@RequestMapping(value="/csd", method = RequestMethod.GET)
	public String csd(Model model) {
		model.addAttribute("csds", auditoriaDao.findAllCSD());
		return "auditoria/csd";
	}
	
	@RequestMapping(value="/grupoUsuario", method = RequestMethod.GET)
	public String grupoUsuarios(Model model) {
		model.addAttribute("grupos", auditoriaDao.findAllGrupoUsuario());
		return "auditoria/grupoUsuario";
	}
	
	@RequestMapping(value="/usuario", method = RequestMethod.GET)
	public String usuarios(Model model) {
		model.addAttribute("usuarios", auditoriaDao.findAllUsuario());
		return "auditoria/usuario";
	}
	

	@RequestMapping(value="/detalle/cliente/{id}", method=RequestMethod.GET)
	public String detalleCliente(@PathVariable Long id, Model model,HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		AuditoriaCliente cliente = auditoriaDao.findByIdCliente(id);
		Cliente clienteActual = clienteDao.findById(tenantID, cliente.getId());
		if (cliente == null || clienteActual == null) {
			return "redirect:/auditoria/";
		} 
		model.addAttribute("clienteAnterior", cliente);
		model.addAttribute("cliente", clienteActual);
		return "auditoria/detalleCliente";
	}
	
	@RequestMapping(value="/detalle/lugarExpedicion/{id}", method=RequestMethod.GET)
	public String detalleLugar(@PathVariable Long id, Model model) {		
		AuditoriaLugarEmision lugar= auditoriaDao.findByIdLugar(id);
		LugarExpedicion lugarActual = lugarDao.findById(lugar.getId());
		if (lugar == null || lugarActual == null) {
			return "redirect:/auditoria/";
		} 
		model.addAttribute("lugarAnterior", lugar);
		model.addAttribute("lugar", lugarActual);
		return "auditoria/detalleLugar";
	}
	
	@RequestMapping(value="/detalle/moneda/{id}", method=RequestMethod.GET)
	public String detalleMoneda(@PathVariable Long id, Model model) {
		AuditoriaMoneda moneda = auditoriaDao.findByIdMoneda(id);
		Moneda monedaActual = monedaDao.findById(moneda.getId());
		if (moneda == null || monedaActual == null) {
			return "redirect:/auditoria/";
		} 
		model.addAttribute("monedaAnterior", moneda);
		model.addAttribute("moneda", monedaActual);
		return "auditoria/detalleMoneda";
	}
	
	@RequestMapping(value="/detalle/datos/{id}", method=RequestMethod.GET)
	public String detalleDatosEmisor(@PathVariable Long id, Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		
		AuditoriaDatosEmisor datos = auditoriaDao.findByIdDatos(id);
		DatosEmisor datosActual = datosDao.findEmisor(tenantID);
		if (datos == null || datosActual == null) {
			return "redirect:/auditoria/";
		} 
		model.addAttribute("datosAnterior", datos);
		model.addAttribute("datosEmisor", datosActual);
		return "auditoria/detalleDatosEmisor";
	}
	
	@RequestMapping(value="/detalle/csd/{id}", method=RequestMethod.GET)
	public String detalleCSD(@PathVariable Long id, Model model) {
		AuditoriaCertificadoSelloDigital csd = auditoriaDao.findByIdCSD(id);
		CertificadoSelloDigital csdActual = csdDao.findById(csd.getId());
		if (csd == null || csdActual == null) {
			return "redirect:/auditoria/";
		} 
		model.addAttribute("csdAnterior", csd);
		model.addAttribute("csdActual", csdActual);
		return "auditoria/detalleCSD";
	}
	
	@RequestMapping(value="/detalle/usuario/{id}", method=RequestMethod.GET)
	public String detalleUsuario(@PathVariable Long id, Model model, HttpServletRequest request) {
		
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		AuditoriaUsuario usuario = auditoriaDao.findByIdUsuario(id);
		Usuario usuarioActual = usuarioDao.findById(usuario.getId(), tenantID);
		if (usuario== null || usuarioActual == null) {
			return "redirect:/auditoria/";
		} 
		model.addAttribute("usuarioAnterior", usuario);
		model.addAttribute("usuario", usuarioActual);
		return "auditoria/detalleUsuario";
	}
	
	@RequestMapping(value="/detalle/producto/{id}", method=RequestMethod.GET)
	public String detalleProducto(@PathVariable Long id, Model model) {
		AuditoriaProductoServicio producto = auditoriaDao.findByIdProductoServicio(id);
		ProductoServicio productoActual = productoDao.findById(producto.getId());
		if (producto== null || productoActual == null) {
			return "redirect:/auditoria/";
		}
		model.addAttribute("listaMonedas", obtenerNombresMoneda(monedaDao.findAll()));
		model.addAttribute("productoAnterior", producto);
		model.addAttribute("productoServicio", productoActual);
		return "auditoria/detalleProducto";
	}
	
	private List<String> obtenerNombresMoneda(List<Moneda> monedas) {
		List<String> nombresMoneda = new ArrayList<String>();
		for (Moneda moneda : monedas) {
			nombresMoneda.add(moneda.getClave());
		}
		return nombresMoneda;
	}
	
}
