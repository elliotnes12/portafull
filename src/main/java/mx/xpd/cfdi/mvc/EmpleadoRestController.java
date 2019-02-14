package mx.xpd.cfdi.mvc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mx.xpd.cfdi.domain.Empleado;
import mx.xpd.cfdi.exception.LlavePrivadaException;
import mx.xpd.cfdi.repo.EmpleadoDao;

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
@RequestMapping("/rest/empleado")
public class EmpleadoRestController {
	
	Logger log = org.slf4j.LoggerFactory.getLogger(EmpleadoRestController.class);

	@Autowired
	private EmpleadoDao empleadoDao;
	
	@RequestMapping(value="/eliminar/{id}", method=RequestMethod.GET)
    public @ResponseBody boolean eliminar(@PathVariable("id") Long id, HttpServletRequest request) {
		final String tenantID = (String)request.getSession().getAttribute("tenantId");
		return empleadoDao.remove(tenantID, id);
    }
	
}
