package mx.xpd.cfdi.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import mx.xpd.cfdi.repo.ParametroDao;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/images")
public class ImageController {
	
	@Autowired
	private ParametroDao parametroDao;
	
//	private static final Logger log = Logger.getLogger("ImageServlet");

	@RequestMapping(value = "/logo/{rfc}", produces = "image/png")
	public @ResponseBody byte[] imprimeImagen(@PathVariable (value = "rfc") String rfc, Model model) throws IOException {
		String path = parametroDao.findByClave("PATH_IMG_LOGO").getValor();
		File image = new File(path + File.separatorChar + rfc + ".png");
		if (!image.exists()) {
			 image = new File(path + File.separatorChar + "blank.png");
		}
		InputStream in = new FileInputStream(image);
	    return IOUtils.toByteArray(in);
	}
	
}
