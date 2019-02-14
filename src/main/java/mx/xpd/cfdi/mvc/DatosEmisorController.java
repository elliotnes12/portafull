package mx.xpd.cfdi.mvc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mx.xpd.cfdi.domain.DatosEmisor;
import mx.xpd.cfdi.repo.CatalogoRegimenFiscalDao;
import mx.xpd.cfdi.repo.DatosEmisorDao;
import mx.xpd.cfdi.repo.PaisEstadoDao;
import mx.xpd.cfdi.repo.ParametroDao;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/datosEmisor")
public class DatosEmisorController {
	@Autowired
	private DatosEmisorDao datosEmisorDao;
	
	@Autowired
	private ParametroDao parametroDao;
	@Autowired
	private PaisEstadoDao paisEstadosDao;
	
	@Autowired
	private CatalogoRegimenFiscalDao catalogoRegimenFiscalDao;
	
	private static final Logger log = Logger.getLogger("DatosEmisorController");

	@RequestMapping(method = RequestMethod.GET)
	public String mostrar(Model model, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		datosEmisorDao.setTenantId(tenantID);
		if(datosEmisorDao.findEmisor(tenantID) != null){
			datosEmisorDao.setTenantId(tenantID);
			DatosEmisor datosEmisor = datosEmisorDao.findEmisor(tenantID);
			model.addAttribute("datosEmisor", datosEmisor);
			model.addAttribute("estados", paisEstadosDao.findAllEstadoMap("MEX"));
			model.addAttribute("delegacionesMunicipio", paisEstadosDao.findAllMunicipioMap(datosEmisor.getEstado()));
			model.addAttribute("localidades", paisEstadosDao.findAllLocalidadMap(datosEmisor.getEstado()));
			if ((datosEmisor.getDelegacionMunicipio().equals(""))&&(datosEmisor.getLocalidad().equals(""))){
				model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(datosEmisor.getEstado()));	
			}
			else{
				model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(datosEmisor.getEstado(), datosEmisor.getDelegacionMunicipio(), datosEmisor.getLocalidad()));
				}
			
			model.addAttribute("regimenes", catalogoRegimenFiscalDao.findAll());
		}
		else{
			log.warn("No se tiene registrado ningún emisor");
			return "redirect:/login/inicio";
		}
		return "datosEmisor/mostrar";
	}
	
	@RequestMapping(value="/editar", method=RequestMethod.POST)
	public String editar(@Valid @ModelAttribute("datosEmisor") DatosEmisor datosEmisor, 
			@RequestParam("archivo") MultipartFile file, 
			BindingResult result, Model model, HttpServletRequest request){
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		datosEmisorDao.setTenantId(tenantID);
		DatosEmisor emisorViejo = datosEmisorDao.findEmisor(tenantID); 
		String rfc = emisorViejo.getRfc();

		datosEmisor.setRfc(rfc);
		/* Seteamos datos que no se enviaron al form */
		datosEmisor.setFoliosDisponibles(emisorViejo.getFoliosDisponibles());
		datosEmisor.setLogo(emisorViejo.getLogo());
		datosEmisor.setPaso(emisorViejo.getPaso());
		datosEmisor.setGratuito(emisorViejo.isGratuito());
		datosEmisor.setProductivo(emisorViejo.isProductivo());
		// -- Para que no actualice los datos que se habian guardado --
		datosEmisor.setFechaRegistro(emisorViejo.getFechaRegistro());
		
		datosEmisor.setUltimaCompra(emisorViejo.getUltimaCompra());
		datosEmisor.setTipoPlan(emisorViejo.getTipoPlan());
		datosEmisor.setFechaVencimiento(emisorViejo.getFechaVencimiento());
		// ------------------------------------------------------------
		String nombre = file.getOriginalFilename().toLowerCase();
		String extension = "";
		String extension2 = "";
		if (nombre != null && nombre.length() > 5) {
			extension = nombre.substring(nombre.length() - 5, nombre.length());
			extension2 = nombre.substring(nombre.length() - 4, nombre.length());
			if(extension.equals(".jpeg") || extension2.equals(".jpg") && file.getSize()<=500000){
				log.info("el archivo si es valido");
			}else{
				log.info("el archivo no es valido debe ser jpg");
				datosEmisorDao.setTenantId(tenantID);
				DatosEmisor datosEmisor2 = datosEmisorDao.findEmisor(tenantID);
				model.addAttribute("datosEmisor", datosEmisor2);
				model.addAttribute("estados", paisEstadosDao.findAllEstadoMap("MEX"));
				model.addAttribute("delegacionesMunicipio", paisEstadosDao.findAllMunicipioMap(datosEmisor.getEstado()));
				model.addAttribute("localidades", paisEstadosDao.findAllLocalidadMap(datosEmisor.getEstado()));
				model.addAttribute("cps", paisEstadosDao.findAllCodigoPostalMap(datosEmisor.getEstado(), datosEmisor.getDelegacionMunicipio(), datosEmisor.getLocalidad()));
				model.addAttribute("regimenes", catalogoRegimenFiscalDao.findAll());
				model.addAttribute("imagenError", true);
				return "datosEmisor/mostrar";
			}
		}
		
		
		log.info("el peso del archivo es : " + file.getSize());
		
		if(!file.isEmpty()){
			try{
				log.info("agregando logo");
				
				BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
				
				byte[] fileBytes = file.getBytes();	
				rfc = datosEmisor.getTenantId();
				String rutaPC =parametroDao.findByClave("PATH_IMG_LOGO").getValor() + tenantID + ".png";
				File fos = new File(rutaPC);
				ImageIO.write(bufferedImage, "png", new File(rutaPC));
				
				log.info("ruta pc: "+rutaPC);
				datosEmisor.setLogo(rutaPC);

			}catch(IOException e){
				log.info("no agrego logo");
				e.printStackTrace();
			}
		}
		datosEmisor.setTenantId(tenantID);
		datosEmisor.setDelegacionMunicipio(datosEmisor.getDelegacionMunicipio().equals("default")?"":datosEmisor.getDelegacionMunicipio());
		datosEmisor.setLocalidad(datosEmisor.getLocalidad().equals("default")?"":datosEmisor.getLocalidad());
		datosEmisorDao.update(datosEmisor);
		return "redirect:/datosEmisor/";
		}
}

